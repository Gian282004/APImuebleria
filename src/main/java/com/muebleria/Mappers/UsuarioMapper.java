package com.muebleria.Mappers;

import com.muebleria.DTO.UsuarioRequest;
import com.muebleria.entitys.UsuarioEntity;
import com.muebleria.models.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toModel(UsuarioRequest user)
    {
        Usuario userModel=new Usuario(user.getUsername(), user.getContrasenia(), user.getNombre(), user.getEmail(), user.getPhone());
        return userModel;
    }
    public Usuario toModel(UsuarioEntity user)
    {
        Usuario userModel=new Usuario(user.getId(), user.getUsername(), user.getContrasenia(), user.getNombre(),  user.getEmail(), user.getPhone());
        return userModel;
    }

    public UsuarioEntity toentity(Usuario userModel)
    {
        UsuarioEntity user=new UsuarioEntity(userModel.getId(), userModel.getUsername(), userModel.getContrasenia(), userModel.getNombre(), userModel.getEmail(), userModel.getPhone());
        return user;
    }


}
