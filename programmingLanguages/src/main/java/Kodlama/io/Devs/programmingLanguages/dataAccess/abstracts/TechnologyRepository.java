package Kodlama.io.Devs.programmingLanguages.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.Devs.programmingLanguages.entities.concretes.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Integer> {

}
