package com.example.demo;

import lombok.Builder;

public class BuilderExample {

    public static void main(String[] args) {
        HttpConfig config = new HttpConfig(
                2000,
                true,
                "https"
        );
        HttpConfig config2 = HttpConfig.builder()
                .setTimeout(2000)
                .setUseSsl(true)
                .build();
    }

    @Builder
    public static class HttpConfig {
        private final int timeout;
        private final boolean useSsl;
        private final String protocol;

        private HttpConfig(int timeout, boolean useSsl, String protocol) {
            this.timeout = timeout;
            this.useSsl = useSsl;
            this.protocol = protocol;
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder {
            private int timeout = 1000;
            private boolean useSsl = false;
            private String protocol = "http";

            private Builder() {

            }

            public Builder setTimeout(int timeout) {
                this.timeout = timeout;
                return this;
            }

            public Builder setUseSsl(boolean useSsl) {
                this.useSsl = useSsl;
                return this;
            }

            public Builder setProtocol(String protocol) {
                this.protocol = protocol;
                return this;
            }

            public HttpConfig build() {
                return new HttpConfig(
                        timeout,
                        useSsl,
                        protocol
                );
            }
        }
    }

}
