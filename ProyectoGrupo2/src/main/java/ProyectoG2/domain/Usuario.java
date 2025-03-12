package ProyectoG2.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String email;

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    private String tipoPlan;

    @Temporal(TemporalType.DATE)
    private Date fechaExpiracionPlan;

    public Usuario() {
    }

    public Usuario(String nombre, String email, Date fechaNacimiento, String tipoPlan, Date fechaExpiracionPlan) {
        this.nombre = nombre;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoPlan = tipoPlan;
        this.fechaExpiracionPlan = fechaExpiracionPlan;
    }
}
