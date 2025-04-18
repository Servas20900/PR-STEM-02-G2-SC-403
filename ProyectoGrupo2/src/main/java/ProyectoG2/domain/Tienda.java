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
    private Long id_articulo;
    private String nombre_articulo;
    private String descripcion;
    private String img; 
    private Double precio;
    private String marca;
    private String sexo;
    private String talla;
    private String categoria;
}
