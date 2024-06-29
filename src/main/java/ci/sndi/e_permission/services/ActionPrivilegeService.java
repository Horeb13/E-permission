package ci.sndi.e_permission.services;

import ci.sndi.e_permission.models.ActionPrivilege;
import ci.sndi.e_permission.repositories.ActionPrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionPrivilegeService {

    @Autowired
    private ActionPrivilegeRepository actionPrivilegeRepository;

    public List<ActionPrivilege> getAllActionPrivileges() {
        return actionPrivilegeRepository.findAll();
    }

    public ActionPrivilege getActionPrivilegeById(Long id) {
        return actionPrivilegeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ActionPrivilege not found"));
    }

    public ActionPrivilege createActionPrivilege(ActionPrivilege actionPrivilege) {
        return actionPrivilegeRepository.save(actionPrivilege);
    }

    public ActionPrivilege updateActionPrivilege(Long id, ActionPrivilege actionPrivilege) {
        ActionPrivilege existingActionPrivilege = actionPrivilegeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ActionPrivilege not found"));
        existingActionPrivilege.setLibelle(actionPrivilege.getLibelle());
        return actionPrivilegeRepository.save(existingActionPrivilege);
    }

    public void deleteActionPrivilege(Long id) {
        actionPrivilegeRepository.deleteById(id);
    }
}
