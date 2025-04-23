package ProyectoG2.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Clases")
public class Clase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clase")
    private int idClase;
    private String nombre_clase;
    private String instructor;
    private String dificultad;
    private String tipo;
    private int usuarios_registrados;
    private int capacidad_maxima;
    private LocalDateTime horario;
}
