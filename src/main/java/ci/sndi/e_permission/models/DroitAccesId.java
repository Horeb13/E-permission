package ci.sndi.e_permission.models;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class DroitAccesId implements Serializable {
    @Column(name = "Id_TYPE_ROLE")
    private Long idTypeRole;

    @Column(name = "Id_MENU")
    private Long idMenu;

    // getters and setters
}