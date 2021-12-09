package co.edu.utp.isc.gia.gestion_de_usuario_back.service.impl;

import co.edu.utp.isc.gia.gestion_de_usuario_back.entities.UsuarioEntity;
import co.edu.utp.isc.gia.gestion_de_usuario_back.exceptions.BadRequestException;
import co.edu.utp.isc.gia.gestion_de_usuario_back.exceptions.ExceptionResponse;
import co.edu.utp.isc.gia.gestion_de_usuario_back.exceptions.UserNotFoundException;
import co.edu.utp.isc.gia.gestion_de_usuario_back.repository.UsuarioRepository;
import co.edu.utp.isc.gia.gestion_de_usuario_back.service.UsuarioServicio;
import co.edu.utp.isc.gia.gestion_de_usuario_back.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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

    @Override
    public boolean actualizarUsuario(UsuarioDTO usuarioDTO) {

        if (usuarioRepository.existsById(usuarioDTO.getId())) {

            UsuarioEntity usuarioEntity = usuarioRepository.save(modelMapper.map(usuarioDTO, UsuarioEntity.class));

            return true;
        }
        return false;
    }

    @Override
    public boolean borrarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public UsuarioDTO obtenerUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            UsuarioEntity usuarioEntity = usuarioRepository.findById(id).get();
            return modelMapper.map(usuarioRepository.findById(id).get(), UsuarioDTO.class);
        } else {
            throw new UserNotFoundException("EL usuario no existe");
        }
    }

    @Override
    public List<UsuarioDTO> obtenerPorNombre(String nombre) {
        if (nombre != "" && nombre != null){
            List<UsuarioEntity> usuarioEntities = usuarioRepository.findByNombre(nombre);
            List<UsuarioDTO> usuarioDTOS = new ArrayList<>();
            usuarioEntities.forEach(usuarioEntity -> {
                usuarioDTOS.add(modelMapper.map(usuarioEntity, UsuarioDTO.class));
            });
            return usuarioDTOS;
        } else {
            throw new UserNotFoundException("Nombre no puede ser vacio");
        }
    }

    @Override
    public List<UsuarioDTO> obtenerPorNombreApellido(String nombre, String apellido) {
        if (nombre != "" && nombre != null){
            List<UsuarioEntity> usuarioEntities = usuarioRepository.findByNombreAndApellido(nombre, apellido);
            List<UsuarioDTO> usuarioDTOS = new ArrayList<>();
            usuarioEntities.forEach(usuarioEntity -> {
                usuarioDTOS.add(modelMapper.map(usuarioEntity, UsuarioDTO.class));
            });
            return usuarioDTOS;
        } else {
            throw new UserNotFoundException("Nombre no puede ser vacio");
        }
    }

}
