package ProyectoG2.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Blog")
public class Blog implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_articulo_blog")
    private Long id_articulo_blog;
    private String titulo;
    private String img;
    private String contenido;
    private String categoria;

    public Blog() {}

    public Blog(String titulo, String img, String contenido, String categoria) {
        this.titulo = titulo;
        this.img = img;
        this.contenido = contenido;
        this.categoria = categoria;
    }
}
