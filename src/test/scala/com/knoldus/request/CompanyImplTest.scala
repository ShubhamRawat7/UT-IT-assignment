package com.knoldus.request

import com.knoldus.models.Company
import com.knoldus.validator.CompanyValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.funsuite.AnyFunSuite

class CompanyImplTest extends AnyFunSuite {
  val CompanyValidator = mock[CompanyValidator]
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  test("Company should be created"){
    val companyImpl = new CompanyImpl(CompanyValidator)
    when(CompanyValidator.companyIsValid(knoldusCompany)) thenReturn(true)
    val result = companyImpl.createCompany(knoldusCompany)
    assert(result.isDefined)
  }

}