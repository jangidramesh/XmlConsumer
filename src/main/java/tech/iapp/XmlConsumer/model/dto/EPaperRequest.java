package tech.iapp.XmlConsumer.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import tech.iapp.XmlConsumer.model.DeviceInfo;
import tech.iapp.XmlConsumer.model.GetPages;

@Data
@AllArgsConstructor
@JacksonXmlRootElement
public class EPaperRequest {
    @JacksonXmlProperty
    private DeviceInfo deviceInfo;
    @JacksonXmlProperty
    private GetPages getPages;
}
