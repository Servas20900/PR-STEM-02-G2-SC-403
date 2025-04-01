package ProyectoG2.domain;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Data
@Entity
@Table(name = "Promociones")
public class Promociones implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_promocion")
    private long id_promocion;
    private String titulo;
    private String descripcion;
    private Double precio;


    public Promociones() {}

    public Promociones(String titulo, String descripcion,Double precio) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
    }
}
