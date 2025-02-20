package com.muebleria.Controllers;

import com.muebleria.DTO.HistorialRequest;
import com.muebleria.Mappers.HistorialMapper;
import com.muebleria.Mappers.ItemMapper;
import com.muebleria.Services.HistorialService;
import com.muebleria.entitys.HistorialEntity;
import com.muebleria.entitys.ItemsEntity;
import com.muebleria.models.Historial;
import com.muebleria.models.Item;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/historial")
@CrossOrigin(origins = "http://localhost:3000")  // Restringir solicitudes a un dominio específico (ajustar según sea necesario)
public class HistorialController {

    private final HistorialService historialService;
    private final HistorialMapper historialMapper;
    private final ItemMapper itemMapper;

    @Autowired
    public HistorialController(HistorialService historialService, HistorialMapper historialMapper, ItemMapper itemMapper) {
        this.historialService = historialService;
        this.historialMapper = historialMapper;
        this.itemMapper=itemMapper;
    }

    // 1. Crear un nuevo historial


    // 2. Obtener un historial por ID
    @GetMapping("/{id}")
    public ResponseEntity<HistorialRequest> getHistorial(@PathVariable Integer id) {
       HistorialRequest historialOptional = historialService.getHistorialById(id);
        if (historialOptional!=null) {
            return ResponseEntity.ok(historialOptional);
        } else {
            return ResponseEntity.notFound().build();  // Status 404 Not Found
        }
    }

    // 3. Obtener todos los historiales
    @GetMapping
    public ResponseEntity<List<HistorialRequest>> getAllHistorials() {
        List<Historial> historiales = historialService.getAllHistorials();
        List<HistorialRequest> historialDTOs = historiales.stream()
                .map(historialMapper::toDTO)  // Convertimos cada Historial a HistorialDTO
                .collect(Collectors.toList());
        return ResponseEntity.ok(historialDTOs);  // Status 200 OK
    }

    @PostMapping
    public HistorialRequest PostHistorial(@Valid @RequestBody HistorialRequest historialRequest) {
        // Mapeamos el historialRequest a una entidad de Historial
        HistorialEntity historial = this.historialMapper.toEntity(
                this.historialMapper.toModel(historialRequest)
        );

        // Usamos stream().map() para convertir el List<ItemRequest> a List<ItemEntity>
        List<ItemsEntity> items = historialRequest.getItems().stream()
                .map(itemRequest -> this.itemMapper.toEntity(itemRequest)) // Mapeo individual
                .collect(Collectors.toList()); // Recolecta los resultados en una lista

        // Guardamos el historial y los items
        return this.historialService.saveHistorial(historial, items);
    }

    // 4. Actualizar un historial por ID

}