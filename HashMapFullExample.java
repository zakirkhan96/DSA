import java.util.HashMap;
import java.util.Map;

public class HashMapFullExample {

    // Custom class for object key/value usage
    static class Student {
        int id;
        String name;

        Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "(" + id + ", " + name + ")";
        }

        // Override equals and hashCode for correct hashmap behavior
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student s = (Student) o;
            return this.id == s.id && this.name.equals(s.name);
        }

        @Override
        public int hashCode() {
            return id + name.hashCode();
        }
    }

    public static void main(String[] args) {
        // 1. Basic HashMap creation and insertion
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Ali");
        map.put(2, "Zara");
        map.put(3, "Ahmed");

        System.out.println("1. Basic HashMap: " + map);

        // 2. Get a value
        System.out.println("2. Value at key 2: " + map.get(2));

        // 3. Check existence
        System.out.println("3. Contains key 3? " + map.containsKey(3));
        System.out.println("   Contains value 'Zara'? " + map.containsValue("Zara"));

        // 4. Remove key
        map.remove(1);
        System.out.println("4. After removing key 1: " + map);

        // 5. Iterating keys
        System.out.println("5. Iterating keys:");
        for (Integer key : map.keySet()) {
            System.out.println("Key: " + key);
        }

        // 6. Iterating values
        System.out.println("6. Iterating values:");
        for (String val : map.values()) {
            System.out.println("Value: " + val);
        }

        // 7. Iterating entries (key + value)
        System.out.println("7. Iterating entries:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // 8. Size of map
        System.out.println("8. Size of map: " + map.size());

        // 9. Null key and null values
        map.put(null, "NullKey");
        map.put(4, null);
        System.out.println("9. Map with nulls: " + map);

        // 10. Clearing map
        map.clear();
        System.out.println("10. After clearing: " + map);

        // 11. Using objects as keys/values
        HashMap<Student, String> studentMap = new HashMap<>();
        Student s1 = new Student(101, "Hamza");
        Student s2 = new Student(102, "Ayesha");

        studentMap.put(s1, "A Grade");
        studentMap.put(s2, "B Grade");

        System.out.println("11. HashMap with objects as keys:");
        for (Map.Entry<Student, String> entry : studentMap.entrySet()) {
            System.out.println("Student: " + entry.getKey() + ", Grade: " + entry.getValue());
        }

        // 12. Nested HashMap
        HashMap<String, HashMap<String, Integer>> departmentMarks = new HashMap<>();

        HashMap<String, Integer> csMarks = new HashMap<>();
        csMarks.put("Zain", 85);
        csMarks.put("Sara", 90);

        HashMap<String, Integer> seMarks = new HashMap<>();
        seMarks.put("Ali", 80);
        seMarks.put("Noor", 88);

        departmentMarks.put("CS", csMarks);
        departmentMarks.put("SE", seMarks);

        System.out.println("12. Nested HashMap:");
        for (String dept : departmentMarks.keySet()) {
            System.out.println("Department: " + dept);
            HashMap<String, Integer> students = departmentMarks.get(dept);
            for (String name : students.keySet()) {
                System.out.println("  " + name + ": " + students.get(name));
            }
        }

        // 13. Encapsulated usage in class
        School school = new School();
        school.addStudent(1, "Imran");
        school.addStudent(2, "Aiman");
        school.printStudents();
    }
}

// 13. Encapsulated HashMap in a class
class School {
    private HashMap<Integer, String> studentList = new HashMap<>();

    public void addStudent(int rollNo, String name) {
        studentList.put(rollNo, name);
    }

    public void printStudents() {
        System.out.println("13. Students in school:");
        for (Map.Entry<Integer, String> entry : studentList.entrySet()) {
            System.out.println("Roll No: " + entry.getKey() + ", Name: " + entry.getValue());
        }
    }
}
