package CustomExceptions;

public class StudentsDisciplineException extends Exception {
    public StudentsDisciplineException(String description){
        super(description);
    }
//        Отсутсвие предметов у студента (должен быть хотя бы один)
//        Оценка ниже 0 или выше 10
}
