package clientAPI;

public class ResponseInformation {
    private int responseCode;

    public ResponseInformation(){}

    public ResponseInformation(int responseCode) {
        this.responseCode = responseCode;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
