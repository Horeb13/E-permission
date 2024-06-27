package ci.sndi.e_permission.models;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;


import java.io.Serializable;


@EqualsAndHashCode(callSuper = false)
@Embeddable
public class AssignationId implements Serializable {
    private Long utilisateur;
    private Long role;

    
}
