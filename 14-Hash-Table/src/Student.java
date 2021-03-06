import java.util.HashMap;

public class Student {
  int grade;
  int cls;
  String firstName;
  String lastName;

  Student(int grade, int cls, String firstName, String lastName) {
    this.grade = grade;
    this.cls = cls;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Returns a hash code value for the object. This method is supported for the benefit of hash
   * tables such as those provided by {@link HashMap}.
   *
   * <p>The general contract of {@code hashCode} is:
   *
   * <ul>
   *   <li>Whenever it is invoked on the same object more than once during an execution of a Java
   *       application, the {@code hashCode} method must consistently return the same integer,
   *       provided no information used in {@code equals} comparisons on the object is modified.
   *       This integer need not remain consistent from one execution of an application to another
   *       execution of the same application.
   *   <li>If two objects are equal according to the {@code equals(Object)} method, then calling the
   *       {@code hashCode} method on each of the two objects must produce the same integer result.
   *   <li>It is <em>not</em> required that if two objects are unequal according to the {@link
   *       Object#equals(Object)} method, then calling the {@code hashCode} method on each of the
   *       two objects must produce distinct integer results. However, the programmer should be
   *       aware that producing distinct integer results for unequal objects may improve the
   *       performance of hash tables.
   * </ul>
   *
   * @return a hash code value for this object.
   * @implSpec As far as is reasonably practical, the {@code hashCode} method defined by class
   *     {@code Object} returns distinct integers for distinct objects.
   * @see Object#equals(Object)
   * @see System#identityHashCode
   */
  @Override
  public int hashCode() {
    int B = 31;
    int hash = 0;
    hash = hash * B + ((Integer) grade).hashCode();
    hash = hash * B + ((Integer) cls).hashCode();
    hash = hash * B + firstName.toLowerCase().hashCode();
    hash = hash * B + lastName.toLowerCase().hashCode();
    return hash;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o) {
      return true;
    }

    if (o == null) {
      return false;
    }

    if (getClass() != o.getClass()) {
      return false;
    }

    Student another = (Student) o;
    return this.grade == another.grade
        && this.cls == another.cls
        && this.firstName.toLowerCase().equals(another.firstName.toLowerCase())
        && this.lastName.toLowerCase().equals(another.lastName.toLowerCase());
  }
}
