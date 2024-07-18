package ci.sndi.e_permission.models;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
// import jakarta.persistence.PostLoad;
// import jakarta.persistence.PostPersist;
// import jakarta.persistence.PostUpdate;
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
@Table(name = "Utilisateur")
public class Utilisateur extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_utilisateur")
    private Long id;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Prenom")
    private String prenom;

    @Column(name = "Email")
    private String email;

    @Column(name = "Mot_de_passe")
    private String motDePasse;

    @ManyToOne
    @JoinColumn(name = "Id_Departement", nullable = false)
    private Departement departement;

    @Column(nullable = false)
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "ASSIGNATION",
        joinColumns = @JoinColumn(name = "id_utilisateur"),
        inverseJoinColumns = @JoinColumn(name = "id_role")
    )
    private Set<Role> roles;

    // private boolean isStandard ;
    // private boolean isAdmin;
    // private boolean isSuperAdmin;
    // private boolean isManager;

    // @PostLoad
    // @PostPersist
    // @PostUpdate
    // private void init() {
    //     for (Role role : roles) {
    //         if (role.isStandard()) {
    //             this.isStandard = true;
    //             continue;
    //         }
    //         if (role.isAdmin()) {
    //             this.isAdmin = true;
    //             continue;
    //         }
    //         if (role.isSuperAdmin()) {
    //             this.isSuperAdmin = true;
    //             continue;
    //         }
    //         if (role.isManager()) {
    //             this.isManager = true;
    //             continue;
    //         }
    //     }
    // }

        // Getters and setters
}