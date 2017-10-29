package dojo.leeds.problem3;

public class JPerson {
    private final String firstName;
    private final String surname;
    private final int age;
    private final JCompany employer;

    public JPerson(String firstName, String surname, int age, JCompany employer) {
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
        this.employer = employer;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public JCompany getEmployer() {
        return employer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JPerson jPerson = (JPerson) o;

        if (age != jPerson.age) return false;
        if (!firstName.equals(jPerson.firstName)) return false;
        if (!surname.equals(jPerson.surname)) return false;
        return employer.equals(jPerson.employer);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + age;
        result = 31 * result + employer.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "JPerson{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", employer=" + employer +
                '}';
    }

}
