package co.edu.utp.isc.gia.gestion_de_usuario_back.controller;

import co.edu.utp.isc.gia.gestion_de_usuario_back.service.UsuarioServicio;
import co.edu.utp.isc.gia.gestion_de_usuario_back.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping()
    public UsuarioDTO guardarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        System.out.println(usuarioDTO);
        return usuarioServicio.guardarUsuario(usuarioDTO);
    }

    @PutMapping()
    public boolean actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        return usuarioServicio.actualizarUsuario(usuarioDTO);
    }

    @DeleteMapping()
    public boolean borrarUsuario(@RequestParam("id") Long id){
        return usuarioServicio.borrarUsuario(id);
    }

    @GetMapping()
    public UsuarioDTO obtenerUsuario(@RequestParam("id") Long id){
        return usuarioServicio.obtenerUsuario(id);
    }

    @GetMapping("obtenerPorNombre")
    public List<UsuarioDTO> obtenerPorNombre(@RequestParam("nombre") String nombre){
        return usuarioServicio.obtenerPorNombre(nombre);
    }

    @GetMapping("obtenerPorNombreApellido")
    public List<UsuarioDTO> obtenerPorNombreApellido(@RequestParam("nombre") String nombre,
                                                     @RequestParam("apellido") String apellido){
        return usuarioServicio.obtenerPorNombreApellido(nombre, apellido);
    }
}
