import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

public class Response {
    private final String fileName;
    private final OutputStream out;
    private Message message;
    private Content content;

    public Response(String path, OutputStream out) {
        this.fileName = path;
        this.out = out;
        this.content = new Content(fileName);
        this.message = newMessage();
    }

    private Message newMessage() {
        if (content.isExists()) {
            String mimeType = null;
            long length = 0;
            try {
                mimeType = content.getContentType();
                length = Files.size(content.getFilePath());
                return new OKMessage(new String[] { mimeType, String.valueOf(length) });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ErrorMessage(null);
    }

    public String getMessage() {
        return message.getText();
    }

    public void write() {
        try {
            out.write(message.getText().getBytes());
            if (content.isExists()) {
                Files.copy(content.getFilePath(), out);
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
