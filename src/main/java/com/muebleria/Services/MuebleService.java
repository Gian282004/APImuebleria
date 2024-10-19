package com.muebleria.Services;
import com.muebleria.Mappers.MuebleMapper;
import com.muebleria.Mappers.VentaMapper;
import com.muebleria.Repositories.MuebleRepository;
import com.muebleria.Repositories.VentaRepository;
import com.muebleria.entitys.MuebleEntity;
import com.muebleria.entitys.VentaEntity;
import com.muebleria.models.Mueble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MuebleService {

    private final MuebleRepository muebleRepository;
    private final MuebleMapper muebleMapper;

    @Autowired
    public MuebleService(MuebleRepository muebleRepository, MuebleMapper muebleMapper)
    {
        this.muebleRepository=muebleRepository;
        this.muebleMapper=muebleMapper;
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
        MuebleEntity entity=muebleRepository.save(muebleMapper.toEntity(mueble));
        return muebleMapper.toModel(entity);
    }

    public void eliminar(Integer id) {
        muebleRepository.deleteById(id);
    }
}