package co.edu.utp.isc.gia.gestion_de_usuario_back.service.impl;

import co.edu.utp.isc.gia.gestion_de_usuario_back.dto.HistorialDTO;
import co.edu.utp.isc.gia.gestion_de_usuario_back.entities.HistorialEntity;
import co.edu.utp.isc.gia.gestion_de_usuario_back.entities.UsuarioEntity;
import co.edu.utp.isc.gia.gestion_de_usuario_back.repository.HistorialRespository;
import co.edu.utp.isc.gia.gestion_de_usuario_back.repository.UsuarioRepository;
import co.edu.utp.isc.gia.gestion_de_usuario_back.service.HistorialService;
import co.edu.utp.isc.gia.gestion_de_usuario_back.service.UsuarioServicio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistorialServiceImpl implements HistorialService {

    @Autowired
    private HistorialRespository historialRespository;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public HistorialDTO guardarHistorial(HistorialDTO historialDTO){
        HistorialEntity historialEntity = modelMapper.map(historialDTO,HistorialEntity.class);
        historialEntity.setUsuarioEntity(modelMapper.map(usuarioServicio.obtenerUsuario(historialDTO.getIdHistorial()),
                UsuarioEntity.class));
        return modelMapper.map(historialRespository.save(historialEntity),HistorialDTO.class);

    }

}
