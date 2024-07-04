package ci.sndi.e_permission.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.Date;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "Demande_de_permission")
public class DemandeDePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_demande")
    private Long id;

    @Column(name = "date_de_fin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @Column(name = "Commentaire")
    private String commentaire;

    @Column(name = "date_de_debut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;

    @Column(name = "MODIFIE_PAR")
    private String modifiePar;

    @ManyToOne
    @JoinColumn(name = "Id_STATUT", nullable = false)
    private StatutDemande statutDemande;

    @ManyToOne
    @JoinColumn(name = "Id_Type_de_Permission", nullable = false)
    private TypeDePermission typeDePermission;

    @ManyToOne
    @JoinColumn(name = "Id_utilisateur",  nullable = false)
    private Utilisateur utilisateur;

    

    // Getters and setters
}
