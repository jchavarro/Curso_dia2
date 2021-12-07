package co.edu.utp.isc.gia.gestion_de_usuario_back.Controller;

import co.edu.utp.isc.gia.gestion_de_usuario_back.Service.UsuarioServicio;
import co.edu.utp.isc.gia.gestion_de_usuario_back.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuario")
@AllArgsConstructor
public class UsuarioController {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping(value = "guardar")
    public UsuarioDTO guardarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        System.out.println(usuarioDTO);
        return usuarioServicio.guardarUsuario(usuarioDTO);
    }

}
