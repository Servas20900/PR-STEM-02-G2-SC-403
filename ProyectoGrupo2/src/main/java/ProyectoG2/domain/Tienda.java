package ProyectoG2.domain;


import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
@Getter
@Table(name = "Productos")
public class Tienda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_articulo")
    private Long idArticulo;
    private String nombreArticulo;
    private String descripcion;
    private String img; 
    private Double precio;
    private String marca;
    private String sexo;
    private String talla;
    private String categoria;

    public Tienda() {
    }

    public Tienda(String nombreArticulo, String descripcion, String img, Double precio, String marca, String sexo, String talla, String categoria) {
        this.nombreArticulo = nombreArticulo;
        this.descripcion = descripcion;
        this.img = img;
        this.precio = precio;
        this.marca = marca;
        this.sexo = sexo;
        this.talla = talla;
        this.categoria = categoria;
    }
}
