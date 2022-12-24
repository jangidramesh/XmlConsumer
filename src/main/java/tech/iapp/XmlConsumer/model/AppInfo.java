package tech.iapp.XmlConsumer.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@JacksonXmlRootElement
public class AppInfo {
    @JacksonXmlProperty
    @NotBlank(message = "NewspaperName field must be specified in AppInfo")
    private String newspaperName;
    @JacksonXmlProperty
    @NotBlank(message = "Version field must be specified in AppInfo")
    private String version;
}
