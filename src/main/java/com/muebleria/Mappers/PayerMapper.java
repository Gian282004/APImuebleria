package com.muebleria.Mappers;

import com.muebleria.entitys.CategoriaEntity;
import com.muebleria.entitys.PayerEntity;
import com.muebleria.models.Categoria;
import com.muebleria.models.Payer;
import org.springframework.stereotype.Component;

@Component
public class PayerMapper {

    public Payer toModel(PayerEntity payerEntity) {
        if (payerEntity == null) {
            return null;
        }
        return new Payer(payerEntity.getId_payer(), payerEntity.getName(), payerEntity.getEmail(), payerEntity.getPhone());
    }

    public PayerEntity toEntity(Payer payer) {
        if (payer == null) {
            return null;
        }
        return new PayerEntity(payer.getIdPayer(), payer.getName(), payer.getEmail(), payer.getPhone());
    }
}
