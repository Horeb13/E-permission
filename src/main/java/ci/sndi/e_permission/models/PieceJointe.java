package ci.sndi.e_permission.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Pièce_jointe")
public class PieceJointe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Pièce_jointe")
    private Long id;

    @Column(name = "Nom_du_fichier")
    private String nomDuFichier;

    @Column(name = "Type_de_fichier")
    private String typeDeFichier;

    @Column(name = "Url_du_fichier")
    private String urlDuFichier;

    @ManyToOne
    @JoinColumn(name = "Id_demande", nullable = false)
    private DemandeDePermission demandeDePermission;

    // Getters and setters
}
