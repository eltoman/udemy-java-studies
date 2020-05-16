package entities;

public class Employee {

    Integer id;

    public Employee(Integer id, String name, Double salary) {
        this.id = id;
        this.name = name;
        salary = salary;
    }

    String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Double salary) {
        salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    Double salary;

    public String toString(){
        return "ID: " + id + " - Name: "+ this.name + " - Salary: " + this.salary;
    }

    public void increaseSalary(double percentage) {
        salary += salary * percentage / 100.0;
    }
}
