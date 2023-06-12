import java.util.ArrayList;
import java.util.List;

public class ExamSeatingArrangement {

    public static void main(String[] args) {

        // Create a list of students
        List<Student> students = new ArrayList<>();

        // Add students to the list
        students.add(new Student("John Doe", "123456789"));
        students.add(new Student("Jane Doe", "987654321"));
        students.add(new Student("Mike Smith", "012345678"));
        students.add(new Student("Sarah Jones", "876543210"));

        // Create a list of exam rooms
        List<ExamRoom> examRooms = new ArrayList<>();

        // Add exam rooms to the list
        examRooms.add(new ExamRoom("Room 1", 10));
        examRooms.add(new ExamRoom("Room 2", 10));
        examRooms.add(new ExamRoom("Room 3", 10));

        // Assign students to exam rooms
        for (Student student : students) {

            // Find an empty exam room
            ExamRoom examRoom = examRooms.stream()
                    .filter(room -> room.getAvailableSeats() > 0)
                    .findFirst()
                    .orElse(null);

            // If an empty exam room is found, assign the student to the room
            if (examRoom != null) {
                examRoom.addStudent(student);
            }
        }

        // Print the seating arrangement
        for (ExamRoom examRoom : examRooms) {
            System.out.println(examRoom.getSeatingArrangement());
        }
    }
}

class Student {

    private String name;
    private String rollNumber;

    public Student(String name, String rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }
}

class ExamRoom {

    private String name;
    private int availableSeats;
    private List<Student> students;

    public ExamRoom(String name, int availableSeats) {
        this.name = name;
        this.availableSeats = availableSeats;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
        availableSeats--;
    }

    public String getSeatingArrangement() {
        StringBuilder seatingArrangement = new StringBuilder();
        for (Student student : students) {
            seatingArrangement.append(student.getName()).append(" ");
        }
        return seatingArrangement.toString();
    }
}