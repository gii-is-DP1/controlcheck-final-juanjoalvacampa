package org.springframework.samples.petclinic.care;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "care")
public class Care extends BaseEntity{
	
	@Size(min = 5, max = 30)
	@NotNull
	@Column(name = "name", unique  = true)
    String name;
	
	@Column(name = "description")
	@NotNull
    String description;
	
	@NotNull
	@Size(min = 1)
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "compatible_pet_types")
    Set<PetType> compatiblePetTypes;
}
