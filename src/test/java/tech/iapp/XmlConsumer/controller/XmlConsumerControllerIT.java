package tech.iapp.XmlConsumer.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tech.iapp.XmlConsumer.XmlConsumerApplication;
import tech.iapp.XmlConsumer.model.dto.XmlSaveResponse;
import tech.iapp.XmlConsumer.util.TestUtil;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = XmlConsumerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class XmlConsumerControllerIT {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testExtractXmlInfo() {

        String ePaperRequest = TestUtil.createRequest();
        headers.setContentType(MediaType.APPLICATION_XML);
        HttpEntity<String> entity = new HttpEntity<String>(ePaperRequest, headers);

        ResponseEntity<XmlSaveResponse> response = restTemplate.exchange(
                createURL("/iApps/api/epaper"),
                HttpMethod.POST, entity, XmlSaveResponse.class);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void testGetAllEPapers() {

        headers.setContentType(MediaType.APPLICATION_XML);
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURL("/iApps/api/epaper"),
                HttpMethod.GET, entity, String.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }


    private String createURL(String uri) {
        return "http://localhost:" + port + uri;
    }

}
