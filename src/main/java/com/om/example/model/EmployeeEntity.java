package com.om.example.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name = "employee")
public class EmployeeEntity extends PanacheEntityBase {
  @Id
  @Column(name = "employee_id", nullable = false)
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator", parameters = {
    @Parameter(name = "uuid_gen_strategy_class", value = "org.hibernate.id.uuid.CustomVersionOneStrategy")})
  private UUID id;

  @Column(name = "first_name", nullable = false, length = 100)
  private String firstName;

  @Column(name = "last_name", nullable = false, length = 100)
  private String lastName;

  @Column(name = "email", nullable = false, length = 500)
  private String email;

  @Column(name = "phone_number", nullable = false, length = 10)
  private String phoneNumber;

  @Column(name = "hire_date", nullable = false)
  private LocalDate hireDate;

  @Column(name = "salary", nullable = false, precision = 131089)
  private BigDecimal salary;

  public Set<EmployeeAddressEntity> getEmployeeAddressEntities() {
    if (this.employeeAddressEntities == null) {
      this.employeeAddressEntities = new HashSet<>();
    }
    return employeeAddressEntities;
  }

  public void setEmployeeAddressEntities(Set<EmployeeAddressEntity> employeeAddressEntities) {
    this.employeeAddressEntities = employeeAddressEntities;
  }

  @OneToMany(mappedBy = "employeeEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = EmployeeAddressEntity.class)
  Set<EmployeeAddressEntity> employeeAddressEntities;
  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  public LocalDate getHireDate() {
    return hireDate;
  }

  public void setHireDate(LocalDate hireDate) {
    this.hireDate = hireDate;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }


}
