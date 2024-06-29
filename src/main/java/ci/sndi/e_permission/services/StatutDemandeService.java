package ci.sndi.e_permission.services;

import ci.sndi.e_permission.models.StatutDemande;
import ci.sndi.e_permission.repositories.StatutDemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatutDemandeService {

    @Autowired
    private StatutDemandeRepository statutDemandeRepository;

    public List<StatutDemande> getAllStatutDemandes() {
        return statutDemandeRepository.findAll();
    }

    public StatutDemande getStatutDemandeById(Long id) {
        return statutDemandeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("StatutDemande not found"));
    }

    public StatutDemande createStatutDemande(StatutDemande statutDemande) {
        return statutDemandeRepository.save(statutDemande);
    }

    public StatutDemande updateStatutDemande(Long id, StatutDemande statutDemande) {
        StatutDemande existingStatutDemande = statutDemandeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("StatutDemande not found"));
        existingStatutDemande.setCode(statutDemande.getCode());
        existingStatutDemande.setLibelle(statutDemande.getLibelle());
        return statutDemandeRepository.save(existingStatutDemande);
    }

    public void deleteStatutDemande(Long id) {
        statutDemandeRepository.deleteById(id);
    }
}
