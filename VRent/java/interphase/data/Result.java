/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.example.interphase.data;

public class Result<T> {
    private Result() {
    }

    public String toString() {
        if (this instanceof Success) {
            Success success = (Success)this;
            return "Success[data=" + success.getData().toString() + "]";
        }
        if (this instanceof Error) {
            Error error = (Error)this;
            return "Error[exception=" + error.getError().toString() + "]";
        }
        return "";
    }

    public static final class Error
    extends Result {
        private Exception error;

        public Error(Exception exception) {
            this.error = exception;
        }

        public Exception getError() {
            return this.error;
        }
    }

    public static final class Success<T>
    extends Result {
        private T data;

        public Success(T t) {
            this.data = t;
        }

        public T getData() {
            return this.data;
        }
    }
}

