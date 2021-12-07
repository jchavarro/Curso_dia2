package co.edu.utp.isc.gia.gestion_de_usuario_back.Service.impl;

import co.edu.utp.isc.gia.gestion_de_usuario_back.Entities.UsuarioEntity;
import co.edu.utp.isc.gia.gestion_de_usuario_back.Repository.UsuarioRepository;
import co.edu.utp.isc.gia.gestion_de_usuario_back.Service.UsuarioServicio;
import co.edu.utp.isc.gia.gestion_de_usuario_back.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    private UsuarioRepository usuarioRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public UsuarioDTO guardarUsuario(UsuarioDTO usuarioDTO) {
        System.out.println(usuarioDTO);
        UsuarioEntity usuarioEntity = modelMapper.map(usuarioDTO, UsuarioEntity.class);
        System.out.println(usuarioEntity);
        UsuarioEntity usuarioEntityPer = usuarioRepository.save(usuarioEntity);
        System.out.println(usuarioEntityPer);
        UsuarioDTO usuarioDTO1 = modelMapper.map(usuarioEntityPer, UsuarioDTO.class);

        /*UsuarioDTO usuarioDTOper = UsuarioDTO.builder().nombre(usuarioEntityPer.getNombre()).apellido(usuarioEntityPer
                .getApellido()).telefono(usuarioEntityPer.getTelefono()).email(usuarioEntityPer.getEmail()).build();*/

        return usuarioDTO1;
    }
}
