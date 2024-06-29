package ci.sndi.e_permission.services;

import ci.sndi.e_permission.models.DroitAcces;
import ci.sndi.e_permission.models.DroitAccesId;
import ci.sndi.e_permission.repositories.DroitAccesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroitAccesService {

    @Autowired
    private DroitAccesRepository droitAcessRepository;

    public List<DroitAcces> getAllDroitAcess() {
        return droitAcessRepository.findAll();
    }

    public DroitAcces getDroitAcessById(DroitAccesId id) {
        return droitAcessRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("DroitAcess not found"));
    }

    public DroitAcces createDroitAcess(DroitAcces droitAcess) {
        return droitAcessRepository.save(droitAcess);
    }

    public DroitAcces updateDroitAcess(DroitAccesId id, DroitAcces droitAcess) {
        DroitAcces existingDroitAcess = droitAcessRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("DroitAcess not found"));
        // Update fields here
        return droitAcessRepository.save(existingDroitAcess);
    }

    public void deleteDroitAcess(DroitAccesId id) {
        droitAcessRepository.deleteById(id);
    }
}
