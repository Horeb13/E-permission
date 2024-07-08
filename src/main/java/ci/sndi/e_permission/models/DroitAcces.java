package ci.sndi.e_permission.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
@Table(name = "DROIT_ACCES")

public class DroitAcces extends Auditable {
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


    // Getters and setters
}

