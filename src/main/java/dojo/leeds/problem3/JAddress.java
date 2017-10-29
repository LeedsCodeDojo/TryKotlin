package dojo.leeds.problem3;

public class JAddress {
    private final String line1;
    private final String line2;
    private final String line3;
    private final String line4;
    private final String county;
    private final String postCode;

    public JAddress(String line1, String line2, String line3, String line4, String county, String postCode) {
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.line4 = line4;
        this.county = county;
        this.postCode = postCode;
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getLine3() {
        return line3;
    }

    public String getLine4() {
        return line4;
    }

    public String getCounty() {
        return county;
    }

    public String getPostCode() {
        return postCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JAddress jAddress = (JAddress) o;

        if (!line1.equals(jAddress.line1)) return false;
        if (!line2.equals(jAddress.line2)) return false;
        if (line3 != null ? !line3.equals(jAddress.line3) : jAddress.line3 != null) return false;
        if (line4 != null ? !line4.equals(jAddress.line4) : jAddress.line4 != null) return false;
        if (!county.equals(jAddress.county)) return false;
        return postCode.equals(jAddress.postCode);
    }

    @Override
    public int hashCode() {
        int result = line1.hashCode();
        result = 31 * result + line2.hashCode();
        result = 31 * result + (line3 != null ? line3.hashCode() : 0);
        result = 31 * result + (line4 != null ? line4.hashCode() : 0);
        result = 31 * result + county.hashCode();
        result = 31 * result + postCode.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "JAddress{" +
                "line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", line3='" + line3 + '\'' +
                ", line4='" + line4 + '\'' +
                ", county='" + county + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}
