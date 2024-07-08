package ci.sndi.e_permission.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.Set;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "ROLE")
public class Role extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_ROLE")
    private Long id;

    @Column(name = "LIBELLE")
    private String libelle;


    @ManyToMany
    @JoinTable(
        name = "ASSIGNATION",
        joinColumns = @JoinColumn(name = "Id_ROLE"),
        inverseJoinColumns = @JoinColumn(name = "Id_utilisateur")
    )
    private Set<Utilisateur> utilisateurs;

    @ManyToOne
    @JoinColumn(name = "Id_ROLE_1", nullable = true)
    private Role parentRole;

    @ManyToOne
    @JoinColumn(name = "Id_TYPE_ROLE", nullable = false)
    private TypeRole typeRole;


    // Getters and setters
}
