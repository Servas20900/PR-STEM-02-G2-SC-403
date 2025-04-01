package ProyectoG2.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "Clases")
public class Clase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_clase")
    private int idClase;
    private String nombre_clase;
    private String instructor;
    private String dificultad;
    private String tipo;
    private String horario;

    public Clase() {}

    public Clase(String nombre_clase, String instructor, String dificultad, String tipo, String horario) {
        this.nombre_clase = nombre_clase;
        this.instructor = instructor;
        this.dificultad = dificultad;
        this.tipo = tipo;
        this.horario = horario;
    }

}
