import CustomExceptions.StudentsDisciplineException;
import CustomExceptions.WrongUniversityStructureException;
import UniversityStructure.Disciplines;
import UniversityStructure.Student;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

//        В университете есть несколько факультетов, в которых учатся студенты, объединенные в группы.
//        У каждого студента есть несколько учебных предметов по которым он получает оценки.
//        Необходимо реализовать иерархию студентов, групп и факультетов.

        List<Student> studentList = new ArrayList<>();

        try {
            studentList = UniversityAction.generateStudentsList();
        } catch (WrongUniversityStructureException e) { //  Отсутсвие факультета в университете,Отсутсвие группы на факультете, Отсутствие студентов в группе WrongUniversityStructureException
            e.printStackTrace();
        }

        System.out.println(studentList);

        try {
            UniversityAction.generateStudentsProgram(studentList);
        } catch (StudentsDisciplineException e) {   //  Отсутсвие предметов у студента (должен быть хотя бы один)
            e.printStackTrace();                    //  Оценка ниже 0 или выше 10
        }
        System.out.println(studentList);

        //  Посчитать средний балл по всем предметам студента
        System.out.println("Средний балл: "+ UniversityAction.getAvgGradeInAllDisciplines(studentList.get(0)));

        // Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
        System.out.println("Средний балл по предмету, факультету, группе: " + UniversityAction.getAvgGradeByDisciplineGroupFaculty(studentList, Disciplines.Math, "INFORMATICS", "1INFORM"));

        // Посчитать средний балл по предмету для всего университета
        System.out.println("Средний балл по предмету: " + UniversityAction.getAvgGradeByDiscipline(studentList, Disciplines.Economic));

        }



}


