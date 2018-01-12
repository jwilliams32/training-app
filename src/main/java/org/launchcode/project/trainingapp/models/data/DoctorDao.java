package org.launchcode.project.trainingapp.models.data;

import org.launchcode.project.trainingapp.models.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DoctorDao extends CrudRepository<Doctor, Integer> {
}
