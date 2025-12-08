package br.edu.ifpr.cars.api;

import br.edu.ifpr.cars.domain.TravelRequest;
import br.edu.ifpr.cars.domain.TravelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/travels")
public class TravelController {
    
    private final TravelService travelService;
    
    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }
    
    // Passageiro cria viagem
    @PostMapping
    public ResponseEntity<TravelRequest> createTravel(@RequestBody Map<String, Object> request) {
        Long passengerId = Long.valueOf(request.get("passengerId").toString());
        String origin = request.get("origin").toString();
        String destination = request.get("destination").toString();
        
        TravelRequest travel = travelService.createTravelRequest(passengerId, origin, destination);
        return ResponseEntity.status(HttpStatus.CREATED).body(travel);
    }
    
    // Motorista aceita viagem
    @PatchMapping("/{id}/accept")
    public ResponseEntity<TravelRequest> acceptTravel(
            @PathVariable Long id,
            @RequestBody Map<String, Object> request) {
        Long driverId = Long.valueOf(request.get("driverId").toString());
        
        TravelRequest travel = travelService.acceptTravel(id, driverId);
        return ResponseEntity.ok(travel);
    }
    
    // Buscar viagem por ID
    @GetMapping("/{id}")
    public ResponseEntity<TravelRequest> getTravel(@PathVariable Long id) {
        TravelRequest travel = travelService.findById(id);
        return ResponseEntity.ok(travel);
    }
}