package com.om.example;

import com.om.example.model.EmployeeAddressEntity;
import com.om.example.model.EmployeeEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/api/v1/employee")
@ApplicationScoped
@Consumes("application/json")
@Produces("application/json")
public class EmployeeRestResource {


  @Transactional
  @POST
  public Response addEmployee(EmployeeEntity employee) {
    employee.persist();
    return Response.created(URI.create("/api/v1/employee/" + employee.getId())).build();
  }

  @Transactional
  @POST
  @Path("/address")
  public Response addEmployeeAddress(EmployeeAddressEntity employeeAddress) {
    employeeAddress.persist();
    return Response.created(URI.create("/api/v1/employee/address/" + employeeAddress.getId())).build();
  }
}
