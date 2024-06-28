package ci.sndi.e_permission.services;

import ci.sndi.e_permission.models.Departement;
import ci.sndi.e_permission.repositories.DepartementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartementService {

    private final DepartementRepository departementRepository;

    public DepartementService(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    public Departement createDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    public Optional<Departement> getDepartementById(Long id) {
        return departementRepository.findById(id);
    }

    public Departement updateDepartement(Long id, Departement departementDetails) {
        Departement departement = departementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Departement non trouvé avec l'ID : " + id));

        departement.setNom(departementDetails.getNom());
        departement.setDirection(departementDetails.getDirection());
        // Mettez à jour d'autres champs selon vos besoins

        return departementRepository.save(departement);
    }

    public void deleteDepartement(Long id) {
        departementRepository.deleteById(id);
    }
}
