package com.knoldus.request

import com.knoldus.db.CompanyReadTo
import com.knoldus.models.Employee
import com.knoldus.validator.{EmailValidator, EmployeeValidator}
import org.scalatest.funsuite.AnyFunSuite


class EmployeeImplIntegrationTest extends AnyFunSuite {
  val companyName = new CompanyReadTo
  val validateEmail = new EmailValidator
  val employeeValidator = new EmployeeValidator(companyName, validateEmail)

  val employeeImpl = new EmployeeImpl(employeeValidator)

  test("User cannot be created because company does not exist"){
    val lucifer: Employee = new Employee("Lucifer", "MorningStar", 22, 10000, "Intern", "tata", "lucifer.morningstar@gmail.com")
    val result = employeeImpl.createEmployee(lucifer)
    assert(result.isEmpty)
  }

  test("User not created because email is invalid"){
    val Utkarsh: Employee = new Employee("Shubham", "Rawat", 23, 12000, "Intern", "Knoldus", "Shubham.rawat@gmailcom")
    val result = employeeImpl.createEmployee(Utkarsh)
    assert(result.isEmpty)
  }

  test("User cannot be created because email is invalid and company does not exist in DB"){
    val lucifer: Employee = new Employee("Lucifer", "MorningStar", 22, 10000, "Intern", "tata", "lucifer.morningstar@gmalcom")
    val result = employeeImpl.createEmployee(lucifer)
    assert(result.isEmpty)
  }

  test("User can be created"){
    val Shubham: Employee = new Employee("Shubham", "Rawat", 23, 12000, "Intern", "Knoldus", "shubham.rawat@gmail.com")
    val result = employeeImpl.createEmployee(Shubham)
    assert(result.isDefined)
  }

}