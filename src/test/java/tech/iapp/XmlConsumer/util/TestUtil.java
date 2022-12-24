package tech.iapp.XmlConsumer.util;

public class TestUtil {
    public static String createRequest() {
        String xmlReq = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<epaperRequest>\n" +
                "    <deviceInfo name=\"Browser\" id=\"soaa@comp\">\n" +
                "        <screenInfo width=\"1280\" height=\"752\" dpi=\"160\" />\n" +
                "        <osInfo name=\"Browser\" version=\"1.0\" />\n" +
                "        <appInfo>\n" +
                "            <newspaperName>soa</newspaperName>\n" +
                "            <version>1.0</version>\n" +
                "        </appInfo>\n" +
                "    </deviceInfo>\n" +
                "    <getPages editionDefId=\"11\" publicationDate=\"2017-06-06\" />\n" +
                "</epaperRequest>";
        return xmlReq;
    }
}
