package challenge1back.challenge1back.respository;

import challenge1back.challenge1back.models.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iMensajeRepository extends JpaRepository<Mensaje,Long> {

}
