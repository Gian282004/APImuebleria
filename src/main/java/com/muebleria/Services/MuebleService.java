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
    public MuebleService(MuebleRepository muebleRepository, MuebleMapper muebleMapper, CategoriaRepository categoriaRepository, ImagenRepository imagenRepository, CategoriaMapper categoriaMapper, ImagenMapper imagenMapper)
    {
        this.muebleRepository=muebleRepository;
        this.muebleMapper=muebleMapper;
        this.categoriaRepository=categoriaRepository;
        this.imagenRepository=imagenRepository;
        this.categoriaMapper=categoriaMapper;
        this.imagenMapper=imagenMapper;

    }


    public List<Mueble> listarTodos() {
        return muebleRepository.findAll().
                stream()
                .map(muebleMapper::toModel).collect(Collectors.toList());
    }

    public Optional<Mueble> obtenerPorId(Integer id) {
        Optional<MuebleEntity> entity= muebleRepository.findById(id);
        return entity.map(muebleMapper::toModel);
    }

    public Mueble guardar(Mueble mueble) {
        // Paso 1: Convertir DTO a entidad Mueble
        MuebleEntity muebleEntity = muebleMapper.toEntity(mueble);

        // Paso 2: Guardar el mueble en la base de datos
        MuebleEntity savedMueble = muebleRepository.save(muebleEntity);

        // Paso 3: Asignar categorías e imágenes
        if (mueble.getCategorias() != null) {
            asignarCategorias(mueble.getCategorias(), savedMueble);
        }
        if (mueble.getImagenes() != null) {
            asignarImagenes(mueble.getImagenes(), savedMueble);
        }

        // Recargar el mueble con todas sus relaciones
        MuebleEntity updatedMueble = muebleRepository.findByIdWithImages(savedMueble.getId())
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
        System.out.println("Soy la entidad"+ updatedMueble.toString());
// Retornar el modelo completo con relaciones
        return muebleModel;
    }
    private void asignarCategorias(List<Categoria> categoriasDTO, MuebleEntity mueble) {
        for (Categoria categoriaDTO : categoriasDTO) {
            // Paso 4: Buscar o crear la categoría en la base de datos
            CategoriaEntity categoria = categoriaRepository.findByNombre(categoriaDTO.getNombre());

            if (categoria == null) {
                // Si la categoría no existe, la creamos
                categoria = new CategoriaEntity();
                categoria.setNombre(categoriaDTO.getNombre());
                categoria = categoriaRepository.save(categoria);  // Guardamos la nueva categoría
            }

            // Paso 5: Asignar la categoría al mueble (relación ManyToMany)
            mueble.getCategorias().add(categoria);
        }
    }

    private void asignarImagenes(List<Imagen> imagenURLs, MuebleEntity mueble) {
        for (Imagen imagen : imagenURLs) {
            // Paso 6: Crear la entidad imagen y asignarla al mueble
            ImagenesEntity imagenEntity = new ImagenesEntity();
            imagenEntity.setImagenURL(imagen.getUrl());
            imagenEntity.setMueble(mueble);  // Relacionar la imagen con el mueble
            mueble.getImagenes().add(imagenEntity);
            // Paso 7: Guardar la imagen
            imagenRepository.save(imagenEntity);
        }
    }


    public void eliminar(Integer id) {
        muebleRepository.deleteById(id);
    }
}