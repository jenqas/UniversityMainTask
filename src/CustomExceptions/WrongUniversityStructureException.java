package CustomExceptions;

public class WrongUniversityStructureException extends Exception{
    //        Отсутствие факультетов в университете
    //        Отсутствие групп на факультете
    //        Отсутствие студентов в группе

    public WrongUniversityStructureException(String message) {
        super(message);
    }
}
