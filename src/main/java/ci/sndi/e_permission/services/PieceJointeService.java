package ci.sndi.e_permission.services;

import ci.sndi.e_permission.models.PieceJointe;
import ci.sndi.e_permission.repositories.PieceJointeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PieceJointeService {

    @Autowired
    private PieceJointeRepository pieceJointeRepository;

    public List<PieceJointe> getAllPieceJointes() {
        return pieceJointeRepository.findAll();
    }

    public PieceJointe getPieceJointeById(Long id) {
        return pieceJointeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PieceJointe not found"));
    }

    public PieceJointe createPieceJointe(PieceJointe pieceJointe) {
        return pieceJointeRepository.save(pieceJointe);
    }

    public PieceJointe updatePieceJointe(Long id, PieceJointe pieceJointe) {
        PieceJointe existingPieceJointe = pieceJointeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PieceJointe not found"));
        existingPieceJointe.setNomDuFichier(pieceJointe.getNomDuFichier());
        existingPieceJointe.setTypeDeFichier(pieceJointe.getTypeDeFichier());
        existingPieceJointe.setUrlDuFichier(pieceJointe.getUrlDuFichier());
        return pieceJointeRepository.save(existingPieceJointe);
    }

    public void deletePieceJointe(Long id) {
        pieceJointeRepository.deleteById(id);
    }
}
