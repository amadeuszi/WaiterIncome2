package org.amadeusz.repository;

import org.amadeusz.model.UserSettings;
import org.springframework.data.repository.CrudRepository;

public interface SettingsRepository extends CrudRepository<UserSettings, Integer> {

}
