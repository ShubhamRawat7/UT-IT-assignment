package com.knoldus.db

import org.scalatest.funsuite.AnyFunSuite

class CompanyReadToTest extends AnyFunSuite {
  val Companyreadto = new CompanyReadTo()

  test("Check if company exists in DB"){
    val CompanyName = "Knoldus"
    val result = Companyreadto.getCompanyByName(CompanyName)
    assert(result.isDefined)
  }


  test("Company should not exist in DB"){
    val companyName = "Goldman Sachs"
    val result = Companyreadto.getCompanyByName(companyName)
    assert(result.isEmpty)
  }

}