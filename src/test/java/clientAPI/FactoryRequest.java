package clientAPI;

public class FactoryRequest {

    public static IRequest make (String type){
        IRequest request;
        switch (type){
            case"put":
                request = new RequestPUT();
                break;
            case"post":
                request = new RequestPOST();
                break;
            case"delete":
                request = new RequestDELETE();
                break;
            case"get":
                request = new RequestGET();
                break;
            default:
                request = new RequestGET();
                break;
        }
        return request;
    }
}
