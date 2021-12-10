package co.edu.utp.isc.gia.gestion_de_usuario_back.controller;

import co.edu.utp.isc.gia.gestion_de_usuario_back.dto.HistorialDTO;
import co.edu.utp.isc.gia.gestion_de_usuario_back.service.HistorialService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("historial")
public class HistorialController {

    private HistorialService historialService;

    public HistorialController(HistorialService historialService) {
        this.historialService = historialService;
    }

    @PostMapping()
    public HistorialDTO guardarHistorial(@RequestBody HistorialDTO historialDTO){
        return historialService.guardarHistorial(historialDTO);
    }
}
