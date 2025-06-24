//SwimmerAdmission.java
class SwimmerAdmission {
  void admission(String name, int age) throws NotAllowedToSwimException {
    if(age>=15 && age<=60) {
      System.out.println(name+" swimming admission accepted");
    } else {
      throw new NotAllowedToSwimException();
    }
  }
}