package server.entities;

public class Employee implements Comparable{
    private String name;
    private String specialization;
    private int daySold;
    private int sectorNumber;

    public Employee(String name, String specialization, int daySold, int sectorNumber) {
        this.name = name;
        this.specialization = specialization;
        this.daySold = daySold;
        this.sectorNumber = sectorNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getDaySold() {
        return daySold;
    }

    public void setDaySold(int daySold) {
        this.daySold = daySold;
    }

    public int getSectorNumber() {
        return sectorNumber;
    }

    public void setSectorNumber(int sectorNumber) {
        this.sectorNumber = sectorNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Сотрудник: ");
        sb.append(name).append("     \t").append('|');
        sb.append("Специализируется на ").append(specialization).append(" | ");
        sb.append("Продано за этот день - ").append(daySold).append("|\n");
        return sb.toString();
    }

    @Override
    public int compareTo(Object o) {
        Employee employ = (Employee) o;
        return this.daySold-employ.getDaySold();
    }
}
