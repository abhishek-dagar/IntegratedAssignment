package com.infy.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.infy.dto.ManufacturingUnit;

@Entity
public class Employee {
    @Id
    private Integer employeeId;
    private String emailId;
    @Column(name = "employeeName")
    private String name;
    @Column(name = "dob")
    private LocalDate dateOfBirth;
    @Enumerated(value = EnumType.STRING)
    private ManufacturingUnit manufacturingUnit;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ManufacturingUnit getManufacturingUnit() {
        return manufacturingUnit;
    }

    public void setManufacturingUnit(ManufacturingUnit manufacturingUnit) {
        this.manufacturingUnit = manufacturingUnit;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", emailId=" + emailId + ", name=" + name + ", dateOfBirth="
                + dateOfBirth + ", manufacturingUnit=" + manufacturingUnit + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.getEmployeeId() == null) ? 0 : this.getEmailId().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (this.getEmployeeId() == null) {
            if (other.getEmployeeId() != null)
                return false;
        } else if (!this.getEmployeeId().equals(other.getEmployeeId()))
            return false;
        return true;
    }
}
