package api.ramengo.service;

import api.ramengo.dto.ProteinDTO;
import api.ramengo.repository.ProteinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProteinService {
    @Autowired
    private ProteinRepository repository;

    public List<ProteinDTO> buscarProteinas() {
        return repository
                .findAll()
                .stream()
                .map(ProteinDTO::new)
                .toList();
    }
}
