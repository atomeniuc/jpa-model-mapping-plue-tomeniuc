package at.spengergasse.plue.jpamodelmapping.domain;

public record ApiKey(String value) {

    private static final int MIN_LENGTH = 6;
    private static final int MAX_LENGTH = 10;

    public ApiKey {
        if (value == null) throw ApiKeyException.forNullValue();
        if (value.length() < MIN_LENGTH || value.length() > MAX_LENGTH) throw ApiKeyException.forInvalidLengthValue(value);
    }

    public static class ApiKeyException extends RuntimeException {
        private ApiKeyException(String message) {
            super(message);
        }

        public static ApiKeyException forNullValue() {
            var msg = "You provided an unsupported null value!";
            return new ApiKeyException(msg);
        }

        public static ApiKeyException forInvalidLengthValue(String value) {
            var msg = "You provided a value '%s' with an out of range length %d (valid length range: %d..%d)!"
                    .formatted(value, value.length(), MIN_LENGTH, MAX_LENGTH);
            return new ApiKeyException(msg);
        }
    }
}
