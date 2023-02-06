public class Request {
    private final String inData;
    private final String[] splitData;

    public Request(String data) {
        this.inData = data;
        this.splitData = getSplitDataFromData();
    }

    private String[] getSplitDataFromData() {
        return inData.split(" ");
    }

    public String[] getSplitData() {
        return splitData;
    }

    public String getInData() {
        return inData;
    }
}
