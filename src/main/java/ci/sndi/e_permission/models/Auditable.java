package ci.sndi.e_permission.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class Auditable {
    
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    @Column(name = "DATE_MODIFICATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;

    @Column(name = "MODIFIE_PAR")
    private String modifiePar;

    @PrePersist
    protected void onCreate() {
        this.dateCreation = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.dateModification = new Date();
    }
}
