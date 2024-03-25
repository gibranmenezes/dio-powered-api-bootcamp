package crm;

public class CrmService {

    private CrmService(){

    }

    public static void saveClient(String name, String postalCode, String county, String city) {
        System.out.println("Client saved in the CRM system");
        System.out.println("name: " + name + " postalCode: " + postalCode + " county: " + county + " city: " + city);   

    }

}
