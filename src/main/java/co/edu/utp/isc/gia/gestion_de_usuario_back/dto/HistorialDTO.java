package co.edu.utp.isc.gia.gestion_de_usuario_back.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HistorialDTO implements Serializable {

    private Long id;

    private Date fecha;

    private String descripcion;

    private Long idHistorial;
}
