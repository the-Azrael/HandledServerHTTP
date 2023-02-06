import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileList {
    private final Path filesPath;
    private final String folder;
    private final List<String> listOfFiles;
    public FileList(String path) {
        this.folder = path;
        this.listOfFiles = getListOfFiles();
        this.filesPath = Path.of(path);
    }

    public List<String> getListOfFiles() {
        return Stream.of(new File(folder).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toList());
    }

    public boolean isFileInList(String file) {
        return  listOfFiles.contains(file);
    }

    public Path getFilesPath() {
        return filesPath;
    }
}
