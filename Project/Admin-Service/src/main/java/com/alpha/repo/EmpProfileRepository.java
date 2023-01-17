package com.alpha.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alpha.model.EmpProfile;

public interface EmpProfileRepository extends JpaRepository<EmpProfile, Integer>{

}
