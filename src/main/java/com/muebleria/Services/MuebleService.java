package com.muebleria.Services;
import com.muebleria.Repositories.MuebleRepository;
import com.muebleria.models.Mueble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuebleService {

    @Autowired
    private MuebleRepository muebleRepository;

    public List<Mueble> listarTodos() {
        return muebleRepository.findAll();
    }

    public Optional<Mueble> obtenerPorId(Integer id) {
        return muebleRepository.findById(id);
    }

    public Mueble guardar(Mueble mueble) {
        return muebleRepository.save(mueble);
    }

    public void eliminar(Integer id) {
        muebleRepository.deleteById(id);
    }
}