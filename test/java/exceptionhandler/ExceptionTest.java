package exceptionhandler;


import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.Api.Assert;
import userdetails.InvalidException;
import userdetails.UserDetailsException;

public class ExceptionTest {


    @Test
    public void givenFirstName_CheckValidationForFName_ReturnTrue() {
        UserDetailsException userDetails = new UserDetailsException();
        try {
            userDetails.validateName("Priyanka");
        } catch (InvalidException e) {
            Assert.assertEquals(InvalidException.ExceptionType.INVALID_NAME, e.type);
        }
    }


    @Test
    public void givenFirstLetterSmall_CheckForValidationForLastName_ReturnFalse() {
        UserDetailsException userDetails = new UserDetailsException();
        try {
            userDetails.validateName("priyanka");
        }catch (InvalidException e) {
            Assert.assertEquals(InvalidException.ExceptionType.INVALID_NAME, e.type);
        }
    }


    @Test
    public void givenEmail_CheckValidation_ReturnTrue() {
        UserDetailsException userDetails = new UserDetailsException();
        try {
            userDetails.validateEmail("abc.xyz@bl.com");
        }catch (InvalidException e) {
            Assert.assertEquals(InvalidException.ExceptionType.INVALID_EMAIL, e.type);
        }
    }

    @Test
    public void givenEmailWithoutTld_CheckValidation_ReturnFalse() {
        UserDetailsException userDetails = new UserDetailsException();
        try {
            userDetails.validateEmail("abc.xyz@bl");
        }catch (InvalidException e){
            Assert.assertEquals(InvalidException.ExceptionType.INVALID_EMAIL, e.type);
        }
    }

    @Test
    public void givenMobileNumber_CheckForValidation_ReturnTrue() {
        UserDetailsException userDetails = new UserDetailsException();
        try {
            userDetails.validateMobileNumber("98 9989745621");
        }catch (InvalidException e){
            Assert.assertEquals(InvalidException.ExceptionType.INVALID_MOBILENUMBER, e.type);
        }
    }

    @Test
    public void givenNumberWithoutCC_CheckForValidation_ReturnFalse() {
        UserDetailsException userDetails = new UserDetailsException();
        try {
            userDetails.validateMobileNumber("9923567545");
        }catch (InvalidException e){
            Assert.assertEquals(InvalidException.ExceptionType.INVALID_MOBILENUMBER, e.type);
        }
    }

    @Test
    public void givenPassWordWithoutSpecialSymbol_CheckForValidation_ReturnFalse() {
        UserDetailsException userDetails = new UserDetailsException();
        try {
            userDetails.validatePassWord("priyanka113");
        }catch (InvalidException e){
            Assert.assertEquals(InvalidException.ExceptionType.INVALID_PASSWORD, e.type);
        }
    }

    @Test
    public void givenProperPassWord_CheckForValidity_ReturnTrue(){
        UserDetailsException userDetails = new UserDetailsException();
        try{
            userDetails.validatePassWord("Priyanka@113");
        }catch (InvalidException e){
            Assert.assertEquals(InvalidException.ExceptionType.INVALID_PASSWORD, e.type);
        }
    }
}


