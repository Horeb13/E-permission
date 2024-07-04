package ci.sndi.e_permission.models;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
@Table(name = "ASSIGNATION")
public class Assignation extends Auditable {

    @EmbeddedId
    private AssignationId id;
    
    @ManyToOne
    @JoinColumn(name = "Id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "Id_ROLE", nullable = false)
    private Role role;

    @Column(name = "DATE_DEBUT")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Column(name = "DATE_FIN")
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    

    // Getters and setters
}


