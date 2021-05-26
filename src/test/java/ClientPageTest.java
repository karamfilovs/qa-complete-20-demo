import api.ClientAPI;
import dto.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ClientPageTest extends BaseTest {
    private final String NO_CLIENTS_MESSAGE = "Все още нямате добавени клиенти.";
    private static final String EMAIL = System.getProperty("email");
    private static final String PASSWORD = System.getProperty("password");

    @Test
    @DisplayName("Can get correct message when no clients exist")
    public void canGetCorrectMessageWhenNoClientsExist(){
        loginPage.login(EMAIL,  PASSWORD);
        clientPage.goTo();
        Assertions.assertEquals(NO_CLIENTS_MESSAGE, clientPage.getEmptyListMessage());
    }

    @Test
    @Tag("client")
    @Tag("smoke")
    @Tag("positive")
    @DisplayName("Can search for existing clients by company name")
    public void canSearchForExistingClientsByCompanyName(){
        ClientAPI clientAPI = new ClientAPI();
        clientAPI.deleteAll();
        loginPage.login(EMAIL, PASSWORD);
        clientPage.goTo();
        //Add new client via API
        Client client = new Client();
        client.setFirm_name("Pragmatic");
        client.setFirm_mol("Alex");
        client.setFirm_town("Sofia");
        client.setFirm_addr("Ivan Stranski");
        client.setFirm_is_reg_vat(false);
        clientAPI.create(client);
        //Search for client via UI
        clientPage.searchByCompanyName("Pragmatic");
        //Check that the client exists
        Assertions.assertTrue(clientPage.getResultTableInfo().contains("Pragmatic"), "Table does not contain company name");
    }

    @Test
    public void getAllClients(){
        ClientAPI clientAPI = new ClientAPI();
        clientAPI.deleteAll();
    }
}
