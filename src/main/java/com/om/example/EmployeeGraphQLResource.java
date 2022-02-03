package com.om.example;

import com.om.example.model.EmployeeEntity;
import com.om.example.service.EmployeeService;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import javax.inject.Inject;
import java.util.List;

@GraphQLApi
public class EmployeeGraphQLResource {
  @Inject
  EmployeeService service;

  @Query("allEmployees")
  @Description("Get all Employees.")
  public List<EmployeeEntity> getEmployees() {
    return service.getAll();
  }

  @Query("findEmployeesByAddressLine1")
  @Description("Find all Employees at a particular address.")
  public List<EmployeeEntity> findEmployeesByAddressLine1(@Name("addressLine1") String addressLine1) {
    return service.getEmployeesByAddressLine1(addressLine1);
  }
}
