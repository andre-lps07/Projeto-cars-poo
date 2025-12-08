package br.edu.ifpr.cars.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TravelService {
    
    private final TravelRequestRepository travelRequestRepository;
    private final PassengerRepository passengerRepository;
    private final DriverRepository driverRepository;
    
    public TravelService(TravelRequestRepository travelRequestRepository,
                        PassengerRepository passengerRepository,
                        DriverRepository driverRepository) {
        this.travelRequestRepository = travelRequestRepository;
        this.passengerRepository = passengerRepository;
        this.driverRepository = driverRepository;
    }
    
    // Passageiro cria viagem → status CREATED
    @Transactional
    public TravelRequest createTravelRequest(Long passengerId, String origin, String destination) {
        Passenger passenger = passengerRepository.findById(passengerId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
                "Passenger not found with id: " + passengerId));
        
        TravelRequest travel = new TravelRequest();
        travel.setPassenger(passenger);
        travel.setOrigin(origin);
        travel.setDestination(destination);
        travel.setStatus(TravelRequestStatus.CREATED);
        
        return travelRequestRepository.save(travel);
    }
    
    // Motorista aceita a viagem → status ACCEPTED
    @Transactional
    public TravelRequest acceptTravel(Long travelId, Long driverId) {
        // Caso id não exista → retornar 404
        TravelRequest travel = travelRequestRepository.findById(travelId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
                "Travel request not found with id: " + travelId));
        
        // Se já estiver ACCEPTED ou FINISHED → retornar 400
        if (travel.getStatus() == TravelRequestStatus.ACCEPTED || 
            travel.getStatus() == TravelRequestStatus.FINISHED) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
                "Cannot accept travel with status: " + travel.getStatus());
        }
        
        // Não pode aceitar viagem em status diferente de CREATED
        if (travel.getStatus() != TravelRequestStatus.CREATED) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
                "Can only accept travel in CREATED status");
        }
        
        Driver driver = driverRepository.findById(driverId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
                "Driver not found with id: " + driverId));
        
        travel.setDriver(driver);
        travel.setStatus(TravelRequestStatus.ACCEPTED);
        
        return travelRequestRepository.save(travel);
    }
    
    public TravelRequest findById(Long id) {
        return travelRequestRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
                "Travel request not found"));
    }
}