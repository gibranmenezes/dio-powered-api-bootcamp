package facade;

import crm.CrmService;
import postalcodesystem.PostalCodeApi;

public class Facade {

    public void migrateClient(String name, String postalCode) {
        String city = PostalCodeApi.getInstance().getCity(postalCode);
        String county = PostalCodeApi.getInstance().getCounty(postalCode);

        CrmService.saveClient(name, postalCode, county, city);

    }

}
