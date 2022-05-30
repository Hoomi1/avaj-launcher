package ft.school21.avaj.simulator;

public class MyException extends Exception{

    public MyException(String ex)
    {
        super(ex);
    }

    public static void printMyException(String ex)
    {
        System.err.println(ex);
    }
}
