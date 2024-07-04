package ci.sndi.e_permission.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "Type_de_Permission")
public class TypeDePermission extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Type_de_Permission")
    private Long id;

    @Column(name = "Nom_de_la_permission")
    private String nom;

    @Column(name = "Description")
    private String description;

    @Column(name = "duree")
    private Integer duree;


    // Getters and setters
}
