package spring.hibernate.hsqldb.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users_profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "carrera")
    private String carrera;

    @Column(name = "estudio")
    private String estudio;

    @Type(type= "org.hibernate.type.NumericBooleanType")
    @Column(name = "titulado")
    private Boolean titulado;

    @Column(name = "color")
    private String color;

    @JsonManagedReference
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Skills> skills;

    @Column(name = "sueldo")
    private BigDecimal sueldo;

    @Column(name = "currency")
    private String currency;

    @Column(name = "civil")
    private Integer civil;

    @Column(name = "phone")
    private String phone;

    @Column(name = "borndate")
    private Date dateBorn;

}
