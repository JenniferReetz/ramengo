package api.ramengo.service;

import api.ramengo.dto.BrothDTO;
import api.ramengo.repository.BrothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrothService {
    @Autowired
    private BrothRepository repository;
    public List<BrothDTO> buscarBroths() {
        return repository
                .findAll()
                .stream()
                .map(BrothDTO::new)
                .toList();
    }
}
