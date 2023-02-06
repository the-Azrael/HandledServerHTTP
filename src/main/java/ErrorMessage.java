public class ErrorMessage implements Message {
    private static final String code = "404 Not Found";
    private String[] params;
    private String text;

    public ErrorMessage(String[] params) {
        this.text = String.format("HTTP/1.1 %s \r\n" +
                "Content-Length: 0\r\n" +
                "Connection: close\r\n" +
                "\r\n", code);
        this.params = params;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String[] getParams() {
        return params;
    }
}
