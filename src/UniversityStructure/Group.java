package UniversityStructure;

public class Group extends Faculty {

    private String group;

    public Group(String university, String faculty, String group) {
        super(university, faculty);
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Group '" + group +
                "' " + super.toString();
    }
}
