package ci.sndi.e_permission.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Data // Génère automatiquement les getters, setters, toString, equals, et hashCode pour les champs de la classe en utilisant Lombok.
@Entity //Indique que cette classe est une entité JPA, ce qui signifie qu'elle sera mappée à une table de base de données.
@Builder //Génère un constructeur de style builder en utilisant Lombok.
@NoArgsConstructor //Génère un constructeur sans arguments en utilisant Lombok.
@AllArgsConstructor //Génère un constructeur avec un argument pour chaque champ en utilisant Lombok.
@EqualsAndHashCode(callSuper = false)
@Table(name = "ROLE") //Spécifie le nom de la table dans la base de données à laquelle cette entité est mappée.
public class Role extends Auditable {
    @Id //Indique que ce champ est la clé primaire de l'entité.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Spécifie que la valeur de la clé primaire est générée automatiquement par la base de données.
    @Column(name = "Id_ROLE") //Spécifie le nom de la colonne dans la table de la base de données correspondant à ce champ.
    private Long id;

    @Column(name = "LIBELLE")
    private String libelle;



    @ManyToOne
    @JoinColumn(name = "Id_ROLE_1", nullable = true)
    private Role parentRole;

    @ManyToOne
    @JoinColumn(name = "Id_TYPE_ROLE", nullable = false)
    private TypeRole typeRole;

    

    // private boolean isStandard;
    // private boolean isAdmin;
    // private boolean isSuperAdmin;
    // private boolean isManager;

    // @PostLoad
    // @PostPersist
    // @PostUpdate
    // private void init() {
    //     this.isStandard = this.typeRole.getLibelle().equals("Standard");
    //     this.isAdmin = this.typeRole.getLibelle().equals("Admin");
    //     this.isSuperAdmin = this.typeRole.getLibelle().equals("Super Admin");
    //     this.isManager = this.typeRole.getLibelle().equals("Manager");
    // }




}

