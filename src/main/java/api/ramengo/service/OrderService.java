package api.ramengo.service;

import api.ramengo.dto.OrderDTO;

import api.ramengo.model.Broth;
import api.ramengo.model.Order;
import api.ramengo.model.Protein;
import api.ramengo.repository.BrothRepository;
import api.ramengo.repository.OrderRepository;
import api.ramengo.repository.ProteinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private BrothRepository brothRepository;
    @Autowired
    private ProteinRepository proteinRepository;
    @Autowired
    private OrderRepository repository;

    Long id;

    public Long getId() {
        return id;
    }

    public void solicitar(OrderDTO dto) {
        Broth broth = brothRepository.getReferenceById(dto.brothId());
        Protein protein = proteinRepository.getReferenceById(dto.proteinId());

        Order order = new Order(broth, protein);
        this.id = repository.save(order).getId();
    }

}
