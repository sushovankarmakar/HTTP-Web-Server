import java.util.HashMap;

public class FileExtensionToContentTypeMapper {
    public static HashMap<String, String> fileContentTypeExtensionMap = new HashMap<String, String>(){{
        put("txt", "text/plain");
        put("html","text/html");
        put("jpg", "text");
        put("png","text");
    }};

    public static String getFileContentType(String fileName){
        String splits[] = fileName.split("\\.");
        return fileContentTypeExtensionMap.get(splits[1]);
    }
}
