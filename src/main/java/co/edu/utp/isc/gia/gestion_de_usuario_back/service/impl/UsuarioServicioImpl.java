package co.edu.utp.isc.gia.gestion_de_usuario_back.service.impl;

import co.edu.utp.isc.gia.gestion_de_usuario_back.entities.UsuarioEntity;
import co.edu.utp.isc.gia.gestion_de_usuario_back.repository.UsuarioRepository;
import co.edu.utp.isc.gia.gestion_de_usuario_back.service.UsuarioServicio;
import co.edu.utp.isc.gia.gestion_de_usuario_back.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public UsuarioServicioImpl() {
    }

    public UsuarioServicioImpl(UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UsuarioDTO guardarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = modelMapper.map(usuarioDTO, UsuarioEntity.class);
        UsuarioEntity usuarioEntityPer = usuarioRepository.save(usuarioEntity);
        System.out.println(usuarioEntityPer);
        UsuarioDTO usuarioDTO1 = modelMapper.map(usuarioEntityPer, UsuarioDTO.class);

        /*UsuarioDTO usuarioDTOper = UsuarioDTO.builder().nombre(usuarioEntityPer.getNombre()).apellido(usuarioEntityPer
                .getApellido()).telefono(usuarioEntityPer.getTelefono()).email(usuarioEntityPer.getEmail()).build();*/

        return usuarioDTO1;
    }
}
