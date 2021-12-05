package com.knoldus.validator

import com.knoldus.db.CompanyReadTo
import com.knoldus.models.{Company, Employee}
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.funsuite.AnyFunSuite

class EmployeeValidatorTest extends AnyFunSuite {

  val employee = new Employee("Shubham","Rawat",23,12000,"Intern","knoldus","Shubham.rawat@knoldus.com")
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
  val CompanyRead = mock[CompanyReadTo]
  val EmailValidator = mock[EmailValidator]
  val employeeValidator = new EmployeeValidator(CompanyRead,EmailValidator)

  test("Employee should valid"){
    when(CompanyRead.getCompanyByName(employee.companyName)).thenReturn(Option(knoldusCompany))
    when(EmailValidator.emailIdIsValid(employee.emailId)).thenReturn(true)
    val result = employeeValidator.employeeIsValid(employee)
    assert(result)
  }
  test("Employee is not valid bcz of his email is invalid"){
    when(CompanyRead.getCompanyByName(employee.companyName)).thenReturn(Option(knoldusCompany))
    when(EmailValidator.emailIdIsValid(employee.emailId)).thenReturn(false)
    val result = employeeValidator.employeeIsValid(employee)
    assert(!result)
  }
  test("Employee is not valid bcz his company not exist in DB"){
    when(CompanyRead.getCompanyByName(employee.companyName)).thenReturn(None)
    when(EmailValidator.emailIdIsValid(employee.emailId)).thenReturn(true)
    val result = employeeValidator.employeeIsValid(employee)
    assert(!result)
  }
  test("Employee is not valid bcz his company not exist in DB and email is not valid"){
    when(CompanyRead.getCompanyByName(employee.companyName)).thenReturn(None)
    when(EmailValidator.emailIdIsValid(employee.emailId)).thenReturn(false)
    val result = employeeValidator.employeeIsValid(employee)
    assert(!result)
  }
}