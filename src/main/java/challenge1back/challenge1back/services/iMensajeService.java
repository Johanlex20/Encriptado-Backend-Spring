package challenge1back.challenge1back.services;

import challenge1back.challenge1back.models.Mensaje;

import java.util.List;

public interface iMensajeService {

    List<Mensaje> findAll();

    Mensaje save (Mensaje mensaje);

    Mensaje findById(Long id);

    Boolean delete( Long id);

}
