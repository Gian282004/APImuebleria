package com.muebleria.Mappers;

import com.muebleria.DTO.HistorialRequest;
import com.muebleria.entitys.CategoriaEntity;
import com.muebleria.entitys.HistorialEntity;
import com.muebleria.models.Categoria;
import com.muebleria.models.Historial;
import com.muebleria.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HistorialMapper {

    private final PayerMapper payerMapper;
    private final ItemMapper itemMapper;

    @Autowired
    // Constructor con inyección de dependencias
    public HistorialMapper(PayerMapper payerMapper, ItemMapper itemMapper) {
        this.payerMapper = payerMapper;
        this.itemMapper = itemMapper;
    }

    public Historial toModel(HistorialEntity historialEntity) {
        if (historialEntity == null) {
            return null;
        }
        return new Historial(
                historialEntity.getId(),
                historialEntity.getPaymentId(),
                historialEntity.getUserId(),
                historialEntity.getAmount(),
                historialEntity.getStatus(),
                historialEntity.getDateApproved(),
                historialEntity.getPaymentMethod(),
                historialEntity.getPaymentType(),
                historialEntity.getDateCreated()
        );
    }


    public Historial toModel(HistorialRequest historialRequest) {
        if (historialRequest == null) {
            return null;
        }
        return new Historial(
                historialRequest.getId(),
                historialRequest.getPaymentId(),
                historialRequest.getUserId(),
                historialRequest.getAmount(),
                historialRequest.getStatus(),
                historialRequest.getDateApproved(),
                historialRequest.getPaymentMethod(),
                historialRequest.getPaymentType(),
                historialRequest.getDateCreated()
        );
    }

    public HistorialEntity toEntity(Historial historial) {
        if (historial == null) {
            return null;
        }
        return new HistorialEntity(
                historial.getId(),
                historial.getPaymentId(),
                historial.getUserId(),
                historial.getAmount(),
                historial.getStatus(),
                historial.getDateApproved(),
                historial.getPaymentMethod(),
                historial.getPaymentType(),
                historial.getDateCreated()
        );
    }

    public HistorialRequest toDTO(HistorialEntity historialEntity) {
        if (historialEntity == null) {
            return null;
        }
        List<Item> itemDTOList = historialEntity.getItems().stream()
                .map(itemMapper::toModel)  // Convertir cada Item a ItemDTO
                .collect(Collectors.toList());

        return new HistorialRequest(
                historialEntity.getId(),
                historialEntity.getPaymentId(),
                historialEntity.getUserId(),
                historialEntity.getAmount(),
                historialEntity.getStatus(),
                historialEntity.getPaymentMethod(),
                historialEntity.getPaymentType(),
                historialEntity.getDateCreated(),
                historialEntity.getDateApproved(),
                this.payerMapper.toModel(historialEntity.getPayer()),
                itemDTOList  // Mapear a DTO de items
        );
    }

    public HistorialRequest toDTO(Historial historial) {
        if (historial == null) {
            return null;
        }
        return new HistorialRequest(
                historial.getId(),
                historial.getPaymentId(),
                historial.getUserId(),
                historial.getAmount(),
                historial.getStatus(),
                historial.getPaymentMethod(),
                historial.getPaymentType(),
                historial.getDateCreated(),
                historial.getDateApproved(),
                historial.getPayer(),
                historial.getItems()
        );
    }
}

