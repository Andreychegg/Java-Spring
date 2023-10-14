package aop;

public class Student {
    private String nameSurname;
    private int coures;
    private double avgGrade;

    public Student(String nameSurname, int coures, double avgGrade) {
        this.nameSurname = nameSurname;
        this.coures = coures;
        this.avgGrade = avgGrade;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public int getCoures() {
        return coures;
    }

    public void setCoures(int coures) {
        this.coures = coures;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nameSurname='" + nameSurname + '\'' +
                ", coures=" + coures +
                ", avgGrade=" + avgGrade +
                '}';
    }
}
