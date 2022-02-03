package com.om.example.service;

import com.om.example.model.EmployeeAddressEntity;
import com.om.example.model.EmployeeEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class EmployeeService {


  public List<EmployeeEntity> getAll() {
    return EmployeeEntity.listAll();
  }

  public List<EmployeeEntity> getEmployeeById(UUID employeeId) {
    return EmployeeEntity.findById(employeeId);
  }

  @Transactional
  public List<EmployeeEntity> getEmployeesByAddressLine1(String addressLine1) {
    return this.getEmployeeAddressByAddressLine1(addressLine1).stream().map(EmployeeAddressEntity::getEmployeeEntity).toList();
  }

  private List<EmployeeAddressEntity> getEmployeeAddressByAddressLine1(String addressLine1) {
    return EmployeeAddressEntity.list("addressLine1", addressLine1);
  }
}
