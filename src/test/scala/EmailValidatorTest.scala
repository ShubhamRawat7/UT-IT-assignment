import com.Ques1andQues2.Emailvalidator.Emailvalidator
import org.scalatest.funsuite.AnyFunSuite

class EmailValidatorTest extends AnyFunSuite {
  var emailObject = new Emailvalidator

  test("Without name of recipient"){
    assert(!emailObject.emailIsValid(emailId = "@gmail.com"))
  }

  test("Without @ in the email"){
    assert(!emailObject.emailIsValid("Lucifer.MorningStar.gmail.com"))
  }

  test("Without domain name"){
    assert(!emailObject.emailIsValid("lucifer.morningstar@"))
  }

  test("Other domain name than .com| .net| .org "){
    assert(!emailObject.emailIsValid("shubham@rediffmail.in"))
  }

  test("correct one uppercase"){
    assert(emailObject.emailIsValid("shubham@REDIFFMAIL.COM"))
  }

  test("Correct one lowercase"){
    assert(emailObject.emailIsValid("shubham@rediffmail.com"))
  }

}