package ro.academyplus.avaj.aircraft;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferInFile {

    private static BufferInFile bufferInFile;
    private static FileOutputStream fileOutputStream;
    private static File file;

    private BufferInFile()
    {
    }

    public static BufferInFile RegisterBuffer()
    {
        if (bufferInFile == null)
        {
            try {
                bufferInFile = new BufferInFile();
                file = new File("simulation.txt");
                fileOutputStream = new FileOutputStream(file, false);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return bufferInFile;
    }

    public void print(String str)
    {
        try {
            fileOutputStream.write(str.getBytes());
            fileOutputStream.write("\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeBuf()
    {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
