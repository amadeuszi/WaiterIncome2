package org.amadeusz.repository;

import org.amadeusz.model.UserExpense;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<UserExpense, Integer> {

}
