import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Content {
    private final String fileName;
    private Path filePath;
    private String type;


    public Content(String fileName) {
        this.fileName = fileName;
        this.filePath = Path.of(fileName);
        this.type = getContentType();
    }

    public String getContentType() {
        try {
            return Files.probeContentType(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isExists() {
        String fName = fileName;
        if (fName.charAt(0) == '/') {
            fName = fName.substring(1);
        }
        return Files.exists(filePath);
    }

    public Path getFilePath() {
        return filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public String getType() {
        return type;
    }
}
