package UniversityStructure;

import CustomExceptions.StudentsDisciplineException;
import UniversityStructure.Disciplines;
import UniversityStructure.Student;

import java.util.*;

public class University {

    private String university;

    public University(String university){
        this.university = university;
    }

    public void setUniversityName(String university) {
        this.university = university;
    }

    public String getUniversity() {
        return university;
    }

    @Override
    public String toString() {
        return "University '" + university + '\'';
    }
}
