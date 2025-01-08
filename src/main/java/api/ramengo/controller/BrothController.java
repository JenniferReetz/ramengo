package api.ramengo.controller;

import api.ramengo.dto.BrothDTO;
import api.ramengo.exceptions.ResourceNotFoundException;
import api.ramengo.service.BrothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/broths")
public class BrothController {
    @Autowired
    private BrothService brothService;

    @GetMapping
    public ResponseEntity<List<BrothDTO>> listarProteinas(){
        List<BrothDTO> broths = brothService.buscarBroths();
        if (broths.isEmpty()) {
            throw new ResourceNotFoundException("No broths found in the database.");
        }
        return ResponseEntity.ok(broths);
    }
 }
