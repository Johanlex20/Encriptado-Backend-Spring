package challenge1back.challenge1back.services;

import challenge1back.challenge1back.models.Mensaje;
import challenge1back.challenge1back.respository.iMensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MensajeService implements  iMensajeService{

    @Autowired
    iMensajeRepository mensajeRepository;

    public List<Mensaje> findAll() {
        return mensajeRepository.findAll();
    }

    @Transactional
    public Mensaje save(Mensaje mensaje) {
        List<Mensaje> mensajesExistentes = mensajeRepository.findAll();
        mensajeRepository.deleteAll(mensajesExistentes);
        return mensajeRepository.save(mensaje);
    }

    @Override
    public Mensaje findById(Long id) {
        return mensajeRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(Long id) {
        mensajeRepository.deleteById(id);
        return true;
    }


    @PostMapping(value = "/mensajes/desencriptar")
    public void desencriptar(@RequestBody Mensaje mensaje){
        String contenido = mensaje.getMensaje();

        // Realiza las sustituciones necesarias indicaciones
        contenido = contenido.replace("enter","e")
                .replace("imes","i")
                .replace("ai","a")
                .replace("ober","o")
                .replace("ufat","u");

        mensaje.setMensaje(contenido);
    }

    public List<Mensaje> desencriptar(List<Mensaje> mensajes){
        for (Mensaje mensaje : mensajes){
            desencriptar(mensaje);
        }
        return mensajes;
    }
}
