package api.ramengo.controller;
import api.ramengo.dto.OrderDTO;
import api.ramengo.dto.OrderResponseDTO;
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
    public ResponseEntity<OrderResponseDTO> OrderRequest(@RequestBody @Valid OrderDTO dto) {
        try {

            OrderResponseDTO response = this.orderService.solicitar(dto);
            return ResponseEntity.ok().body(response);

        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
