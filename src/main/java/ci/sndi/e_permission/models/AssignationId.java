package ci.sndi.e_permission.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class AssignationId implements Serializable {
    @Column(name = "id_utilisateur")
    private Long utilisateur;
    @Column(name = "id_role")
    private Long role;

}
