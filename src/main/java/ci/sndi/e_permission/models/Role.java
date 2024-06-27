package ci.sndi.e_permission.models;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false, exclude = "assignations")
@Table(name = "ROLE")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_ROLE")
    private Long id;

    @Column(name = "LIBELLE")
    private String libelle;

    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;

    @Column(name = "MODIFIE_PAR")
    private String modifiePar;

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

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    @Builder.Default
    private List < Assignation > assignations = new ArrayList<>();

    // Getters and setters
}
