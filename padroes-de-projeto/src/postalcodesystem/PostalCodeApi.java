package postalcodesystem;

public class PostalCodeApi {

    private static PostalCodeApi instance = new PostalCodeApi();

    private PostalCodeApi(){

    }

    public static PostalCodeApi getInstance(){
        return instance;
    }

    public String getCity(String code){
        return "Natal";
    }

    public String getCounty(String code){
        return "RN";
    }

}
