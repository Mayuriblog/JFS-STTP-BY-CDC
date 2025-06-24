// NotAllowedToSwimException.java
class NotAllowedToSwimException extends Exception {
  String err;
  NotAllowedToSwimException() {
    err="User age below 15 yrs and above 60 yrs are not allowed to swim";
  }
  NotAllowedToSwimException(String err) {
    this.err=err;
  }
  public String toString() {
    return err;
  }
}