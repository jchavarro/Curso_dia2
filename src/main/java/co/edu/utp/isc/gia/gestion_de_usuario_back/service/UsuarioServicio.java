package co.edu.utp.isc.gia.gestion_de_usuario_back.service;

import co.edu.utp.isc.gia.gestion_de_usuario_back.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioServicio {
    UsuarioDTO guardarUsuario(UsuarioDTO usuarioDTO);

    boolean actualizarUsuario(UsuarioDTO usuarioDTO);

    boolean borrarUsuario(Long id);

    UsuarioDTO obtenerUsuario(Long id);

    List<UsuarioDTO> obtenerPorNombre(String nombre);

    List<UsuarioDTO> obtenerPorNombreApellido(String nombre, String apellido);
}
