package org.springframework.samples.petclinic.care;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface CareProvisionRepository extends CrudRepository<CareProvision, Integer>{
    List<CareProvision> findAll();   
    
    Optional<CareProvision> findById(int id);
    CareProvision save(CareProvision p);
    
    @Query("SELECT c FROM Care c")
	List<Care> findAllCares();
    
    @Query("SELECT c FROM Care c WHERE c.compatible_pet_types = ?1")
    List<Care> findCompatibleCares(String petTypeName);
    //Care findCareByName(String name);
    //List<CareProvision> findCaresProvidedByVisitId(Integer visitId);
}
