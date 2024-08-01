package ci.sndi.e_permission.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DemandeDePermissionDto {
    private Date dateDebut;
    private Date dateFin;
    private String typeDePermission;
    private String userEmail;
    private String description;

}
