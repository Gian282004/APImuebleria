package com.muebleria.Mappers;

import com.muebleria.entitys.ItemsEntity;
import com.muebleria.entitys.PayerEntity;
import com.muebleria.models.Item;
import com.muebleria.models.Payer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemMapper {

    public Item toModel(ItemsEntity itemsEntity) {
        if (itemsEntity == null) {
            return null;
        }
        return new Item(itemsEntity.getId_item(), itemsEntity.getTitle(), itemsEntity.getQuantity(), itemsEntity.getUnitPrice(), itemsEntity.getTotalPrice());
    }

    public ItemsEntity toEntity(Item item) {
        if (item == null) {
            return null;
        }
        return new ItemsEntity(item.getId(), item.getName(), item.getQuantity(), item.getUnitPrice(), item.getTotalPrice());
    }
}
