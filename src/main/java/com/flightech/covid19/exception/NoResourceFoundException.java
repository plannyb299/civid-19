package com.flightech.covid19.exception;

public class NoResourceFoundException extends RuntimeException{

  public NoResourceFoundException(String message) {
    super(message);
  }

  public NoResourceFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public NoResourceFoundException(final Throwable cause) {
    super(cause);
  }

}
