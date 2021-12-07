package co.edu.utp.isc.gia.gestion_de_usuario_back.Repository;

import co.edu.utp.isc.gia.gestion_de_usuario_back.Entities.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long> {
}
