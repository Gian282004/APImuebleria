package com.muebleria.Services;
import com.muebleria.Mappers.CategoriaMapper;
import com.muebleria.Mappers.ImagenMapper;
import com.muebleria.Mappers.MuebleMapper;
import com.muebleria.Repositories.CategoriaRepository;
import com.muebleria.Repositories.ImagenRepository;
import com.muebleria.Repositories.MuebleRepository;
import com.muebleria.entitys.CategoriaEntity;
import com.muebleria.entitys.ImagenesEntity;
import com.muebleria.entitys.MuebleEntity;
import com.muebleria.models.Categoria;
import com.muebleria.models.Imagen;
import com.muebleria.models.Mueble;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MuebleService {

    private final MuebleRepository muebleRepository;
    private final MuebleMapper muebleMapper;
    private final CategoriaRepository categoriaRepository;
    private final ImagenRepository imagenRepository;
    private final CategoriaMapper categoriaMapper;
    private final ImagenMapper imagenMapper;

    @Autowired
    public MuebleService(MuebleRepository muebleRepository, MuebleMapper muebleMapper, CategoriaRepository categoriaRepository, ImagenRepository imagenRepository, CategoriaMapper categoriaMapper, ImagenMapper imagenMapper) {
        this.muebleRepository = muebleRepository;
        this.muebleMapper = muebleMapper;
        this.categoriaRepository = categoriaRepository;
        this.imagenRepository = imagenRepository;
        this.categoriaMapper = categoriaMapper;
        this.imagenMapper = imagenMapper;
    }

    public List<Mueble> listarTodos() {
        List<MuebleEntity> mueblesEntity = muebleRepository.findAll();

        // Asegurarse de que las relaciones se carguen explícitamente
        for (MuebleEntity muebleEntity : mueblesEntity) {
            Hibernate.initialize(muebleEntity.getCategorias());  // Cargar las categorías
            Hibernate.initialize(muebleEntity.getImagenes());    // Cargar las imágenes
        }

        // Ahora las categorías e imágenes están completamente cargadas
        return mueblesEntity.stream()
                .map(muebleMapper::toModel)
                .collect(Collectors.toList());
    }
    @Transactional
    public Optional<Mueble> obtenerPorId(Integer id) {
        Optional<MuebleEntity> entity = muebleRepository.findById(id);

        entity.ifPresent(mueble -> {
            Hibernate.initialize(mueble.getImagenes());
            Hibernate.initialize(mueble.getCategorias());
        });

        return entity.map(muebleMapper::toModel);
    }
    @Transactional
    public Mueble guardar(Mueble mueble) {
        // Paso 1: Convertir DTO a entidad Mueble
        MuebleEntity muebleEntity = muebleMapper.toEntity(mueble);

        // Paso 2: Guardar el mueble en la base de datos
        MuebleEntity savedMueble = muebleRepository.save(muebleEntity);
        System.out.println("categorias:" +mueble);
        // Paso 3: Asignar categorías e imágenes
        if (mueble.getCategorias() != null) {
            asignarCategorias(mueble.getCategorias(), savedMueble);
        }
        if (mueble.getImagenes() != null) {
            asignarImagenes(mueble.getImagenes(), savedMueble);
            muebleRepository.save(savedMueble);
        }


        // Recargar el mueble con todas sus relaciones
        MuebleEntity updatedMueble = muebleRepository.findById(savedMueble.getId())
                .orElseThrow(() -> new RuntimeException("Mueble no encontrado"));
        Hibernate.initialize(updatedMueble.getImagenes());
        // Mapear la entidad a modelo
        Mueble muebleModel = muebleMapper.toModel(updatedMueble);

        muebleModel.setCategorias(updatedMueble.getCategorias().stream()
                .map(categoriaMapper::toModel)
                .collect(Collectors.toList()));

        muebleModel.setImagenes(updatedMueble.getImagenes().stream()
                .map(imagenMapper::toModel)
                .collect(Collectors.toList()));
        // Retornar el modelo completo con relaciones
        muebleModel.setId(updatedMueble.getId());
        return muebleModel;
    }
    private void asignarCategorias(List<Categoria> categoriasDTO, MuebleEntity mueble) {
        if (mueble.getCategorias() == null) {
            mueble.setCategorias(new ArrayList<>()); // Asegurar que la lista no sea nula
        }

        for (Categoria categoriaDTO : categoriasDTO) {
            CategoriaEntity categoria = categoriaRepository.findByNombre(categoriaDTO.getNombre());

            if (categoria == null) {
                categoria = new CategoriaEntity();
                categoria.setNombre(categoriaDTO.getNombre());
                categoria = categoriaRepository.save(categoria);
            }

            System.out.println("Asignando categoría: " + categoria.getNombre()); // Debug log
            mueble.getCategorias().add(categoria);
        }

        System.out.println("Categorías asignadas al mueble: " + mueble.getCategorias());
    }

    private void asignarImagenes(List<Imagen> imagenURLs, MuebleEntity mueble) {
        if (mueble.getImagenes() == null) {
            mueble.setImagenes(new ArrayList<>()); // Inicializar si es null
        }

        for (Imagen imagen : imagenURLs) {
            ImagenesEntity imagenEntity = new ImagenesEntity();
            imagenEntity.setImagenURL(imagen.getUrl());
            imagenEntity.setMueble(mueble);  // Asegurar la relación bidireccional

            mueble.getImagenes().add(imagenEntity);
            imagenRepository.save(imagenEntity);
        }
    }

    public void eliminar(Integer id) {
        muebleRepository.deleteById(id);
    }
}

