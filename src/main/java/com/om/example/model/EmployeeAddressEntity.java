package com.om.example.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "employee_address")
public class EmployeeAddressEntity extends PanacheEntityBase {
  @Id
  @Column(name = "address_id", nullable = false)
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator", parameters = {
    @org.hibernate.annotations.Parameter(name = "uuid_gen_strategy_class", value = "org.hibernate.id.uuid.CustomVersionOneStrategy")})
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "employee_id", nullable = false)
  private EmployeeEntity employeeEntity;

  @Column(name = "address_line_1", nullable = false, length = 400)
  private String addressLine1;

  @Column(name = "address_line_2", length = 400)
  private String addressLine2;

  @Column(name = "city", nullable = false, length = 500)
  private String city;

  @Column(name = "province", nullable = false, length = 20)
  private String province;

  public EmployeeEntity getEmployeeEntity() {
    return employeeEntity;
  }

  public void setEmployeeEntity(EmployeeEntity employeeEntity) {
    this.employeeEntity = employeeEntity;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getAddressLine2() {
    return addressLine2;
  }

  public void setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
  }

  public String getAddressLine1() {
    return addressLine1;
  }

  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }
}
