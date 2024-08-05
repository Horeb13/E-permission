package ci.sndi.e_permission.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemandeDePermissionResponse {
    private Long id;
    private String typeDePermission;
    private Date dateDebut;
    private Date dateFin;
    private String userEmail;
    private String description;
    private String statut;

}
