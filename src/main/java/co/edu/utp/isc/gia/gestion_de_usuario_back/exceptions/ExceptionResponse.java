package co.edu.utp.isc.gia.gestion_de_usuario_back.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
public class ExceptionResponse {
    private Date timestamp;
    private String mensaje;
    private String detalles;
    private String httpCodeMessage;

    public ExceptionResponse(Date timestamp, String message,
                             String details,String httpCodeMessage) {
        super();
        this.timestamp = timestamp;
        this.mensaje = message;
        this.detalles = details;
        this.httpCodeMessage=httpCodeMessage;
    }
}