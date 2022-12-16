package clientAPI;

import org.json.JSONObject;

public class RequestInformation {

    private String url;
    private JSONObject body;
    private String email;
    private String password;

    public RequestInformation() {
    }

    public RequestInformation(String url, JSONObject body, String email, String password) {
        this.url = url;
        this.body = body;
        this.email = email;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public JSONObject getBody() {
        return body;
    }

    public void setBody(JSONObject body) {
        this.body = body;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
