package com.paulo.modulo14_concorrencia.domain;

public class Discount {
    public enum Code {
        NONE(0), SAYAGIN(4), SUPERSAYAGIN(7), SUPERSAYAGIN2(10), SUPERSAYAGIN3(13);

        private final int code;

        private Code (int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }
}
