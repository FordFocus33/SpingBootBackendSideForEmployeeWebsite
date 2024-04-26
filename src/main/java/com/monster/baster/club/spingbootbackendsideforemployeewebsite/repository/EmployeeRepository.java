package com.monster.baster.club.spingbootbackendsideforemployeewebsite.repository;

import com.monster.baster.club.spingbootbackendsideforemployeewebsite.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
