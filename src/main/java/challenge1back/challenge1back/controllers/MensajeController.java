package challenge1back.challenge1back.controllers;

import challenge1back.challenge1back.models.Mensaje;
import challenge1back.challenge1back.services.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(value = {"http://localhost:4200", "http://localhost:8080"})

public class MensajeController {

    @Autowired
    MensajeService mensajeService;

    @GetMapping(value = "/mensajes")
    public List<Mensaje> findAll(){
        System.out.println("Resultados encontrados!");
        return mensajeService.findAll();
    }
    @GetMapping(value = "/mensajes/{id}")
    public Mensaje findById(@PathVariable(value = "id") Long id){
        Mensaje mensajeEncontrado = new Mensaje();
        mensajeEncontrado = mensajeService.findById(id);
        System.out.println("mensaje id: "+id);
        return mensajeService.findById(id);
    }
    @PostMapping(value = "/mensajes")
    public Mensaje save(@RequestBody Mensaje mensaje){
        Map<String, Object> response = new HashMap<>();
        convertirVocales(mensaje);
        return  mensajeService.save(mensaje);
    }

    @DeleteMapping(value = "/mensajes/{id}")
    public Boolean delete(@PathVariable(value = "id") Long id){
        System.out.println("Mensaje id: "+id+" eliminado!");
        return mensajeService.delete(id);
    }


    private void convertirVocales(Mensaje mensaje){
        // Itera sobre la lista de mensajes
            String contenido = mensaje.getMensaje();

            // Realiza las sustituciones necesarias indicaciones
            contenido = contenido.replace("e","enter")
                    .replace("i", "imes")
                    .replace("a","ai")
                    .replace("o", "ober")
                    .replace("u","ufat");
            // Actualiza el contenido del mensaje con el resultado de la conversión
            mensaje.setMensaje(contenido);
        }

        @PostMapping(value = "/mensajes/desencriptar")
        public List<Mensaje> desencriptarMensajes(@RequestBody List<Mensaje> mensajes) {
            return mensajeService.desencriptar(mensajes);
        }
    }



