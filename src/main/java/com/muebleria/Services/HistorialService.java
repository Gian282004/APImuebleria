package com.muebleria.Services;

import com.muebleria.DTO.HistorialRequest;
import com.muebleria.Mappers.HistorialMapper;
import com.muebleria.Repositories.HistorialRepository;
import com.muebleria.Repositories.ItemRepository;
import com.muebleria.Repositories.PayerRepository;
import com.muebleria.entitys.HistorialEntity;
import com.muebleria.entitys.ItemsEntity;
import com.muebleria.models.Historial;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HistorialService {
   private final HistorialRepository historialRepository;
   private final ItemRepository itemRepository;
   private final PayerRepository payerRepository;
    private final HistorialMapper historialMapper;
    @Autowired
    public HistorialService(HistorialRepository historialRepository, ItemRepository itemRepository, PayerRepository payerRepository, HistorialMapper historialMapper)
    {
        this.historialRepository=historialRepository;
        this.itemRepository=itemRepository;
        this.payerRepository=payerRepository;
        this.historialMapper=historialMapper;
    }

     public List<Historial> getAllHistorials ()
     {
         return historialRepository.findAll().
                 stream()
                 .map(historialMapper::toModel).collect(Collectors.toList());
     }

     public HistorialRequest getHistorialById(Integer id)
     {
       return this.historialRepository.findById(id)
                 .map(this.historialMapper::toDTO)
                 .orElseThrow(() -> new EntityNotFoundException("Historial no encontrado con ID: " + id));
     }

    public HistorialRequest updateHistorial(Integer id, Historial historial) {
        return this.historialRepository.findById(id)
                .map(this.historialMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Historial no encontrado con ID: " + id));
    }
    public HistorialRequest saveHistorial(HistorialEntity historial, List<ItemsEntity> items) {
        // Se asume que el historial ya tiene un payer válido
        HistorialEntity savedHistorial = historialRepository.save(historial);

        // Asignar historial a cada ítem y guardarlos
        items.forEach(item -> item.setHistorial(savedHistorial));
        itemRepository.saveAll(items);

        return this.historialMapper.toDTO(savedHistorial);
    }

     public void deleteHistorial(Integer id)
     {

     }

}
