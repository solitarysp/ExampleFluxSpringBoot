package vn.com.viettel.vds.example.flux.domain.exceptions;

public class UserDetailException extends Exception {
    public UserDetailException(String message) {
        super(message);
    }

    public UserDetailException(String message, Throwable cause) {
        super(message, cause);
    }

    public static class UserExists extends UserDetailException {
        public UserExists(Throwable throwable) {
            super("User Exists", throwable);
        }

        public UserExists(String message, Throwable throwable) {
            super(message, throwable);
        }

        public UserExists(String message) {
            super(message);
        }
    }

    public static class UserIdNotFound extends UserDetailException {
        public UserIdNotFound(Throwable throwable) {
            super("User Id Not Found", throwable);
        }

        public UserIdNotFound(String message, Throwable throwable) {
            super(message, throwable);
        }

        public UserIdNotFound(String message) {
            super(message);
        }
    }
}
