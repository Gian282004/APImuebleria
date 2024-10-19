package com.muebleria.Mappers;

import com.muebleria.DTO.UsuarioRequest;
import com.muebleria.entitys.UsuarioEntity;
import com.muebleria.models.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toModel(UsuarioRequest user)
    {
        Usuario userModel=new Usuario(user.getNombre(), user.getContrasenia(), user.getEmail());
        return userModel;
    }
    public Usuario toModel(UsuarioEntity user)
    {
        Usuario userModel=new Usuario(user.getId_usuario(), user.getNombreUsuario(), user.getContrasenia(), user.getEmail());
        return userModel;
    }

    public UsuarioEntity toentity(Usuario userModel)
    {
        UsuarioEntity user=new UsuarioEntity(userModel.getId(), userModel.getNombre(), userModel.getContrasenia(), userModel.getEmail());
        return user;
    }
}
