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
@Table(name = "MENU")
public class Menu extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_MENU")
    private Long id;

    @Column(name = "LIEN")
    private String lien;

    @Column(name = "LIBELLE")
    private String libelle;

    @Column(name = "ICONE")
    private String icone;

    @ManyToOne
    @JoinColumn(name = "Id_MENU_1", nullable = true)
    private Menu parentMenu;


    // Getters and setters
}
