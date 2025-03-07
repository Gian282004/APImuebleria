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
        return muebleRepository.findAll().stream()
                .map(muebleMapper::toModel).collect(Collectors.toList());
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

    public Mueble guardar(Mueble mueble) {
        // Paso 1: Convertir DTO a entidad Mueble
        MuebleEntity muebleEntity = muebleMapper.toEntity(mueble);

        // Paso 2: Guardar el mueble en la base de datos
        MuebleEntity savedMueble = muebleRepository.save(muebleEntity);

        // Paso 3: Asignar categorías e imágenes si están presentes
        if (mueble.getCategorias() != null) {
            asignarCategorias(mueble.getCategorias(), savedMueble);
        }
        if (mueble.getImagenes() != null) {
            asignarImagenes(mueble.getImagenes(), savedMueble);
        }

        // Recargar el mueble con todas sus relaciones utilizando EntityGraph
        MuebleEntity updatedMueble = muebleRepository.findById(savedMueble.getId())
                .orElseThrow(() -> new RuntimeException("Mueble no encontrado"));

        // Mapear la entidad a modelo
        Mueble muebleModel = muebleMapper.toModel(updatedMueble);

        // Mapear y asignar categorías e imágenes
        muebleModel.setCategorias(updatedMueble.getCategorias().stream()
                .map(categoriaMapper::toModel)
                .collect(Collectors.toList()));

        muebleModel.setImagenes(updatedMueble.getImagenes().stream()
                .map(imagenMapper::toModel)
                .collect(Collectors.toList()));

        return muebleModel;
    }

    private void asignarImagenes(List<Imagen> imagenURLs, MuebleEntity mueble) {
        for (Imagen imagen : imagenURLs) {
            ImagenesEntity imagenEntity = new ImagenesEntity();
            imagenEntity.setImagenURL(imagen.getUrl());
            imagenEntity.setMueble(mueble);  // Relacionar la imagen con el mueble
            mueble.getImagenes().add(imagenEntity);
            imagenRepository.save(imagenEntity);
        }
    }

    @Transactional
    public void asociarImagenesAMueble(List<String> urlsImagenes, Integer idMueble) {
        MuebleEntity mueble = muebleRepository.findById(idMueble)
                .orElseThrow(() -> new RuntimeException("Mueble no encontrado"));

        List<ImagenesEntity> imagenesEntities = new ArrayList<>();

        for (String url : urlsImagenes) {
            ImagenesEntity imagenEntity = new ImagenesEntity();
            imagenEntity.setImagenURL(url);
            imagenEntity.setMueble(mueble);
            imagenesEntities.add(imagenEntity);
        }

        imagenRepository.saveAll(imagenesEntities);
        mueble.getImagenes().addAll(imagenesEntities); // Asociar a la lista del mueble
    }

    public void eliminar(Integer id) {
        muebleRepository.deleteById(id);
    }

    // Método para asignar categorías
    private void asignarCategorias(List<Categoria> categorias, MuebleEntity mueble) {
        for (Categoria categoria : categorias) {
            // Supongo que el proceso de asignación de categorías es similar al de las imágenes
            // Implementa la lógica aquí para asociar la categoría con el mueble
        }
    }
}

