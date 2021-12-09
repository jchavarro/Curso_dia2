package co.edu.utp.isc.gia.gestion_de_usuario_back.repository;

import co.edu.utp.isc.gia.gestion_de_usuario_back.entities.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long> {

    List<UsuarioEntity> findByNombre(String nombre);

    List<UsuarioEntity> findByNombreAndApellido(String nombre, String apellido);

}
