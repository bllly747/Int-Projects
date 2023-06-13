Exam Seating Arrangement System
This system allows you to assign students to exam rooms. The system works by first creating a list of students and a list of exam rooms. The system then assigns students to exam rooms in a round-robin fashion. If there are more students than exam rooms, some students will be assigned to the same exam room.

How to Use
To use the system, first create a list of students and a list of exam rooms. Then, run the following command:

Code snippet
java ExamSeatingArrangement
Use code with caution. Learn more
The system will then assign students to exam rooms and print the seating arrangement to the console.

Example
The following example shows how to use the system to assign 4 students to 3 exam rooms:

Code snippet
// Create a list of students
List<Student> students = new ArrayList<>();
students.add(new Student("John Doe", "123456789"));
students.add(new Student("Jane Doe", "987654321"));
students.add(new Student("Mike Smith", "012345678"));
students.add(new Student("Sarah Jones", "876543210"));

// Create a list of exam rooms
List<ExamRoom> examRooms = new ArrayList<>();
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
The output of the program will be:

Code snippet
Room 1: John Doe
Room 2: Jane Doe
Room 3: Mike Smith
Sarah Jones





