/**
 * POJO class representing a Student entity
 */
public class Student {
    private int id;
    private String name;
    private String email;
    private int age;

    public Student() {}

    // Constructor without ID (for insert)
    public Student(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // Constructor with ID (for update/read)
    public Student(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // Getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return String.format("Student{id=%d, name='%s', email='%s', age=%d}", id, name, email, age);
    }
}
