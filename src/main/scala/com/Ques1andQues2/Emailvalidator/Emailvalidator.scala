package com.Ques1andQues2.Emailvalidator

class Emailvalidator {
  def emailIsValid(emailId: String): Boolean = {
    if("""^([a-zA-Z\d\.-]+)@([a-zA-Z\d-]+)\.(com|net|org|COM|NET|ORG)$""".r.findFirstIn(emailId).isEmpty)
      false
    else
      true
  }
}
