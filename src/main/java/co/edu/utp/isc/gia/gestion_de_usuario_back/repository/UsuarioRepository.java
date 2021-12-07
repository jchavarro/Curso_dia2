package co.edu.utp.isc.gia.gestion_de_usuario_back.repository;

import co.edu.utp.isc.gia.gestion_de_usuario_back.entities.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long> {
}
