package ProyectoG2.domain;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Data
@Entity
@Table(name = "Promociones")
public class Promociones implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_promocion")
    private int id_promocion;
    private String titulo;
    private String descripcion;
    private int precio;


    public Promociones() {}

    public Promociones(String titulo, String descripcion,int precio) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
    }
}
