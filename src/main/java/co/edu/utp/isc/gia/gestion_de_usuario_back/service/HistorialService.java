package co.edu.utp.isc.gia.gestion_de_usuario_back.service;

import co.edu.utp.isc.gia.gestion_de_usuario_back.dto.HistorialDTO;
import org.springframework.stereotype.Service;


public interface HistorialService {

    HistorialDTO guardarHistorial(HistorialDTO historialDTO);

}
