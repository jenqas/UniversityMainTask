package UniversityStructure;

import CustomExceptions.WrongUniversityStructureException;

public class Faculty extends University{

    private String faculty;

    public Faculty(String university, String faculty) {
        super(university);
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
       this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Faculty '" + faculty  + "' " + super.toString();
    }
}

