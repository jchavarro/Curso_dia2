package co.edu.utp.isc.gia.gestion_de_usuario_back.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuarioDTO implements Serializable {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
}
