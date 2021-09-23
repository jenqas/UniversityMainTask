import CustomExceptions.StudentsDisciplineException;
import CustomExceptions.WrongUniversityStructureException;
import UniversityStructure.Disciplines;
import UniversityStructure.Group;
import UniversityStructure.Student;

import java.util.*;

public class UniversityAction {

    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public static List<Student> generateStudentsList () throws WrongUniversityStructureException {
        List<Student> studentsList = Arrays.asList(
                new Student("BSEU","ECONOMICS", "1ECON", "Ivanov Petya"),
                new Student("BSEU","ECONOMICS", "2ECON", "Yuhimuk Sasha"),
                new Student("BSEU","INFORMATICS", "1INFORM", "Sidarovich Yauheni"),
                new Student("BSEU","INFORMATICS", "1INFORM", "Ustimenko Djigan"),
                new Student("BSEU","CHEMISTRY", "1CHEM", "Yakimovich Darya")
        );

        for (Student s: studentsList) {
            if (s.getUniversity()!="" && s.getFaculty()=="") throw new WrongUniversityStructureException("Отсутсвие факультета в университете");
            if (s.getFaculty()!="" && s.getGroup()=="") throw new WrongUniversityStructureException("Отсутсвие группы на факультете");
            if (s.getGroup()!="" && s.getStudentName()=="") throw new WrongUniversityStructureException("Отсутствие студентов в группе");
        }

        return studentsList;
    }

    public static void generateStudentsProgram(List<Student> students) throws StudentsDisciplineException {

        Map<Disciplines, Integer> student1Disciplines = new HashMap<Disciplines, Integer>();
        student1Disciplines.put(Disciplines.Math,2);
        student1Disciplines.put(Disciplines.Economic,5);
        student1Disciplines.put(Disciplines.Philosophy,7);

        Map <Disciplines, Integer> student2Disciplines = new HashMap<Disciplines, Integer>();
        student2Disciplines.put(Disciplines.Math,2);
        student2Disciplines.put(Disciplines.Economic,8);
        student2Disciplines.put(Disciplines.Philosophy,7);
        student2Disciplines.put(Disciplines.History,9);
        student2Disciplines.put(Disciplines.Logic,5);

        Map <Disciplines, Integer> student3Disciplines = new HashMap<Disciplines, Integer>();
        student3Disciplines.put(Disciplines.History,9);
        student3Disciplines.put(Disciplines.Economic,6);
        student3Disciplines.put(Disciplines.Logic,8);
        student3Disciplines.put(Disciplines.Math,9);

        Map <Disciplines, Integer> student4Disciplines = new HashMap<Disciplines, Integer>();
        student4Disciplines.put(Disciplines.Math,2);
        student4Disciplines.put(Disciplines.History,4);
        student4Disciplines.put(Disciplines.Philosophy,7);

        Map <Disciplines, Integer> student5Disciplines = new HashMap<Disciplines, Integer>();
        student5Disciplines.put(Disciplines.Math,8);
        student5Disciplines.put(Disciplines.Chemistry,10);
        student5Disciplines.put(Disciplines.Logic,5);
        student5Disciplines.put(Disciplines.History,9);

        students.get(0).setDisciplines(student1Disciplines);
        students.get(1).setDisciplines(student2Disciplines);
        students.get(2).setDisciplines(student3Disciplines);
        students.get(3).setDisciplines(student4Disciplines);
        students.get(4).setDisciplines(student5Disciplines);

    }

    public static double getAvgGradeInAllDisciplines (Student student){

        int sumOfDisciplinesGrades=0;
        Map map = student.getDisciplines();
        ArrayList<Integer> valueList = new ArrayList<Integer>(map.values());

        for (Integer i : valueList) {
            sumOfDisciplinesGrades+=i;
        }
        System.out.println("\nCтудент: '" + student.getStudentName() + "'\nПредметы: " + map.toString());

        return ((double)sumOfDisciplinesGrades/valueList.size());
    }

    public static double getAvgGradeByDisciplineGroupFaculty(List<Student> students, Disciplines discipline, String faculty, String group){

        List<Student> sortedStudent = new ArrayList<>();
        boolean studentMatchesParameters = false;

        for (Student s: students) {

            if (s.getFaculty()==faculty && s.getGroup()==group) {

                Map map = s.getDisciplines();
                ArrayList<Disciplines> studentsDisciplines = new ArrayList<Disciplines>(map.keySet());

                for (Disciplines disciplineName: studentsDisciplines) {
                    if (disciplineName == discipline) studentMatchesParameters=true;
                }

            }

            if (studentMatchesParameters) sortedStudent.add(s);
            studentMatchesParameters = false;
        }

        System.out.println("\nСтуденты по параметрам (" + discipline + ", "+ faculty + ", "+ group + ") :" + sortedStudent.toString());

        int sumOfDisciplinesGrades = 0;
        double avgGrade = 0;

        for (Student s: sortedStudent) {
            sumOfDisciplinesGrades += s.getDisciplines().get(discipline);
        }

        avgGrade = ((double)sumOfDisciplinesGrades/sortedStudent.size());

        return avgGrade;

    }

    public static double getAvgGradeByDiscipline(List<Student> students, Disciplines discipline){

        List<Student> sortedStudents = new ArrayList<>();
        boolean studentMatchesParameters = false;

        for (Student s: students) {

            Map map = s.getDisciplines();
            ArrayList<Disciplines> studentsDisciplines = new ArrayList<Disciplines>(map.keySet());

            for (Disciplines disciplineName: studentsDisciplines) {
                if (disciplineName == discipline) studentMatchesParameters=true;
            }

            if (studentMatchesParameters) sortedStudents.add(s);
            studentMatchesParameters = false;
        }

        System.out.println("\nСтуденты с предметом '" + discipline + "' :" + sortedStudents.toString());

        int sumOfDisciplinesGrades = 0;
        double avgGrade = 0;

        for (Student s: sortedStudents) {
            sumOfDisciplinesGrades += s.getDisciplines().get(discipline);
        }

        avgGrade = ((double)sumOfDisciplinesGrades/sortedStudents.size());

        return avgGrade;

    }
}
