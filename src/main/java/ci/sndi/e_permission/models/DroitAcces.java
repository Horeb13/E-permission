package ci.sndi.e_permission.models;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
@Table(name = "DROIT_ACCES")

public class DroitAcces {
    @EmbeddedId
    private DroitAccesId id;

    @ManyToOne
    @MapsId("idTypeRole")
    @JoinColumn(name = "Id_TYPE_ROLE")
    private TypeRole typeRole;

    @ManyToOne
    @MapsId("idMenu")
    @JoinColumn(name = "Id_MENU")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "Id_ACTION_PRIVILEGE")
    private ActionPrivilege actionPrivilege;

    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;

    // Getters and setters
}

