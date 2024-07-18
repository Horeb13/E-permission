package ci.sndi.e_permission.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@Table(name = "ASSIGNATION")
public class Assignation extends Auditable {

    @EmbeddedId
    private AssignationId id;

    @Column(name = "DATE_DEBUT")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Column(name = "DATE_FIN")
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    

    // Getters and setters
}
