package ProyectoG2.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;


@Data
@Entity
@Table(name = "productos")
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_articulo")
    private long id_articulo;

    @Column(name = "nombre_articulo")
    private String nombreArticulo;

    private String descripcion;
    private String img;
    private Double precio;
    private String marca;
    private String  sexo;
    private String  talla;

    public Productos() {}

    public Productos(long id_articulo, String nombreArticulo, String descripcion, String img, Double precio,
            String marca, String  sexo, String  talla ) {
        this.id_articulo = id_articulo;
        this.nombreArticulo = nombreArticulo;
        this.descripcion = descripcion;
        this.img = img;
        this.precio = precio;
        this.marca = marca;
        this.sexo = sexo;
        this.talla = talla;
    } 

    
}


