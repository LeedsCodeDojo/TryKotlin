package dojo.leeds.problem3;

public class JCompany {
    private final String companyName;
    private final JAddress headOffice;

    public JCompany(String companyName, JAddress headOffice) {
        this.companyName = companyName;
        this.headOffice = headOffice;
    }

    public String getCompanyName() {
        return companyName;
    }

    public JAddress getHeadOffice() {
        return headOffice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JCompany jCompany = (JCompany) o;

        if (!companyName.equals(jCompany.companyName)) return false;
        return headOffice.equals(jCompany.headOffice);
    }

    @Override
    public int hashCode() {
        int result = companyName.hashCode();
        result = 31 * result + headOffice.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "JCompany{" +
                "companyName='" + companyName + '\'' +
                ", headOffice=" + headOffice +
                '}';
    }
}
