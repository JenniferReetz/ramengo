package api.ramengo.service;

import api.ramengo.dto.OrderDTO;

import api.ramengo.dto.OrderResponseDTO;
import api.ramengo.model.Broth;
import api.ramengo.model.Order;
import api.ramengo.model.Protein;
import api.ramengo.repository.BrothRepository;
import api.ramengo.repository.OrderRepository;
import api.ramengo.repository.ProteinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private BrothRepository brothRepository;
    @Autowired
    private ProteinRepository proteinRepository;
    @Autowired
    private OrderRepository repository;
    @Autowired
    private RestTemplate restTemplate;
    Long id;

    public Long getId() {
        return id;
    }

    public OrderResponseDTO solicitar(OrderDTO dto) {
        Broth broth = brothRepository.getReferenceById(dto.brothId());
        Protein protein = proteinRepository.getReferenceById(dto.proteinId());

        Order order = new Order(broth, protein);
        String description = broth.getName() + " and " + protein.getName() + " Ramen";
        this.id = repository.save(order).getId();
        return new OrderResponseDTO(
                this.id,
                generateExternalOrderId(),
                description,
                "https://tech.redventures.com.br/icons/ramen/ramenChasu.png"
                );
    }
    public String generateExternalOrderId() {
        String endpoint = "https://api.tech.redventures.com.br/orders/generate-id";
        String apiKey = "ZtVdh8XQ2U8pWI2gmZ7f796Vh8GllXoN7mr0djNf";

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", apiKey);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(endpoint, HttpMethod.POST, entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException("Erro ao gerar ID externo: " + response.getStatusCode());
        }
    }
}
