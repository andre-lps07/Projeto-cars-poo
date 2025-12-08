package br.edu.ifpr.cars.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelRequestRepository extends JpaRepository<TravelRequest, Long> {
    // Spring Data JPA cria os métodos automaticamente
}