package ci.sndi.e_permission.services;

import ci.sndi.e_permission.models.Direction;
import ci.sndi.e_permission.repositories.DirectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectionService {

    private final DirectionRepository directionRepository;

    public DirectionService(DirectionRepository directionRepository) {
        this.directionRepository = directionRepository;
    }

    public List<Direction> getAllDirections() {
        return directionRepository.findAll();
    }

    public Direction createDirection(Direction direction) {
        return directionRepository.save(direction);
    }

    public Optional<Direction> getDirectionById(Long id) {
        return directionRepository.findById(id);
    }


    public Direction updateDirection(Long id, Direction directionDetails) {
        Direction direction = directionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Direction non trouvée avec l'ID : " + id));

        direction.setNom(directionDetails.getNom());
        direction.setCode(directionDetails.getCode());
        direction.setModifiePar(directionDetails.getModifiePar());

        return directionRepository.save(direction);
    }

    public void deleteDirection(Long id) {
        directionRepository.deleteById(id);
    }
}
