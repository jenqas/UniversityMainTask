package UniversityStructure;

import CustomExceptions.StudentsDisciplineException;

import java.util.Map;

public class Student extends Group {

    private String studentName;
    private Map<Disciplines, Integer> disciplines;

    public Student(String university, String faculty, String group, String studentName) {
        super(university, faculty, group);
        this.studentName = studentName;
    }

    public Student(String university, String faculty, String group, String studentName, Map<Disciplines, Integer> disciplines) {
        super(university, faculty, group);
        this.studentName = studentName;
        this.disciplines = disciplines;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setDisciplines(Map<Disciplines, Integer> disciplines) throws StudentsDisciplineException {
        int disciplinesCounter=0;
        for (Disciplines disciplineName : disciplines.keySet()) {
            disciplinesCounter++;
        }
        if (disciplinesCounter==0) throw new StudentsDisciplineException("Студент не записан ни на одну из дисциплин..");

        for (Integer grade: disciplines.values()) {
            if (grade<0 || grade>10) throw new StudentsDisciplineException("Отметка по дисциплине должна быть от 0 до 10");
        }

        this.disciplines = disciplines;

    }

    public String getStudentName() {
        return studentName;
    }

    public Map<Disciplines, Integer> getDisciplines() {
        return disciplines;
    }

    @Override
    public String toString() {
        try {
            return "\nStudent '" + studentName +
                    "' || " + super.toString() + " || Disciplines " + disciplines.toString();
        } catch (NullPointerException e){
            return "\nStudent '" + studentName +
                    "' || " + super.toString();
        }
    }
}
