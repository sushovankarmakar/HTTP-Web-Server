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

    @Test
    public void isFileExtensionToContentTypeMapperTest () {

        assertEquals("text/plain", FileExtensionToContentTypeMapper.getFileContentType("sushovan.txt"));
        assertEquals("text/html", FileExtensionToContentTypeMapper.getFileContentType("sushovan.html"));
        assertEquals("text", FileExtensionToContentTypeMapper.getFileContentType("sushovan.jpg"));
        assertEquals("text", FileExtensionToContentTypeMapper.getFileContentType("sushovan.png"));
    }

    @Test
    public void isExtractFileNameAndMethodNameTest (){
        Parser parser = new Parser();
        parser.parse(("GET /sushovan.txt HTTP/1.1").getBytes());
        String expectedFileName = "sushovan.txt";
        String expectedMethodName = "GET";
        String actualFileName = parser.fileRequested;
        String actualMethodName = parser.methodName;
        assertEquals(expectedFileName, actualFileName);
        assertEquals(expectedMethodName,actualMethodName);
    }

}
