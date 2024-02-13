package challenge1back.challenge1back.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Mensaje no puede estar vacio")
    @Size(min = 3, max = 5000)
    @Column(nullable = false)
    private String mensaje;

}
