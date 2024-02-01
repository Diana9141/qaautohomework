package hw6;


class CustomUncheckedException extends RuntimeException {
        public CustomUncheckedException(String message, Throwable cause) {
            super(message, cause);
    }
}
