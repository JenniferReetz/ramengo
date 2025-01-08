package api.ramengo.controller;
import api.ramengo.dto.OrderDTO;
import api.ramengo.model.Order;
import api.ramengo.repository.OrderRepository;
import api.ramengo.service.OrderService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<String> OrderRequest(@RequestBody @Valid OrderDTO dto) {
        try {
            // Processa o pedido local
            this.orderService.solicitar(dto);

            // Gera o ID externo
            String externalOrderId = orderService.generateExternalOrderId();

            // Recupera os dados do pedido local
            Long id = orderService.getId();
            Order order = orderRepository.getReferenceById(id);
            String broth = order.getBroth().getName();
            String protein = order.getProtein().getName();
            String description = broth + " and " + protein + " Ramen";
            String image = "https://tech.redventures.com.br/icons/ramen/ramenChasu.png";

            // Cria a resposta
            String response = "\nInternal ID: " + order.getId() +
                    "\nExternal ID: " + externalOrderId +
                    "\nDescription: " + description +
                    "\nImage: " + image;

            return ResponseEntity.ok(response);
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body("Erro ao gerar pedido: " + e.getMessage());
        }
    }
}
