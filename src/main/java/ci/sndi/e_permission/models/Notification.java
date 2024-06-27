package ci.sndi.e_permission.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Notification")
    private Long id;

    @Column(name = "contenu", length = 250)
    private String contenu;

    @Column(name = "date_d_envoi")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnvoi;

    @Column(name = "statut", length = 10)
    private String statut;

    @ManyToOne
    @JoinColumn(name = "Id_STATUT_NOTIFICATION", nullable = false)
    private StatutNotification statutNotification;

    @ManyToOne
    @JoinColumn(name = "Id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    // Getters and setters
}
