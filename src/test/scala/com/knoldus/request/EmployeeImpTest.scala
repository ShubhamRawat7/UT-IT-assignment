package com.knoldus.request

import com.knoldus.models.Employee
import com.knoldus.validator.EmployeeValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.funsuite.AnyFunSuite

class EmployeeImplTest extends AnyFunSuite{
  val EmployeeValidator = mock[EmployeeValidator]
  val Shubham:Employee = new Employee("Shubham","Rawat",23,12000,"Intern","Knoldus","shubham.rawat@gmail.com")
  val userImpl = new EmployeeImpl(EmployeeValidator)

  test("User can be ceated"){
    when(EmployeeValidator.employeeIsValid(Shubham)) thenReturn(true)
    val result = userImpl.createEmployee(Shubham)
    assert(result.isDefined)
  }
  test("User can not be created"){
    when(EmployeeValidator.employeeIsValid(Shubham)) thenReturn(false)
    val result = userImpl.createEmployee(Shubham)
    assert(result.isEmpty)
  }
}