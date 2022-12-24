package tech.iapp.XmlConsumer.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@JacksonXmlRootElement
public class OsInfo {
    @JacksonXmlProperty(isAttribute = true)
    @NotBlank(message = "Name attribute must be specified in OsInfo")
    private String name;
    @JacksonXmlProperty(isAttribute = true)
    private String version;
}
