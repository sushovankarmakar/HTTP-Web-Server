import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;

import static org.junit.Assert.assertEquals;

public class FileHandleTest {
    @Test
    public void isReadFileDataReadingDataTest (){
        FileOutputStream fileOutputStream = null;
        try{
            File file = new File("sushovan.txt");
            fileOutputStream = new FileOutputStream(file);
            String expectedData = "this is Sushovan";
            fileOutputStream.write(expectedData.getBytes());
            int fileLength = (int) file.length();
            fileOutputStream.close();

            FileDataReader fileDataReader = new FileDataReader();
            String actualData = new String(fileDataReader.readFileData(file,fileLength));

            assertEquals(expectedData, actualData);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
