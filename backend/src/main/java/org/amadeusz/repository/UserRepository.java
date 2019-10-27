package org.amadeusz.repository;

import org.amadeusz.model.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<ApplicationUser, Integer> {

}
