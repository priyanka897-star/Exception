package userdetails;

public class InvalidException extends Exception {
        public InvalidException(ExceptionType enteredNull) {
        }

        enum ExceptionType {
            INVALID_NAME, INVALID_EMAIL, INVALID_MOBILENUMBER,INVALID_PASSWORD,ENTERED_NULL
        }

        public ExceptionType type;
        public InvalidException(ExceptionType type, String message){
            super(message);
            this.type = type;
        }
    }

