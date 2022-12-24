package tech.iapp.XmlConsumer.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@JacksonXmlRootElement
public class ScreenInfo {
    @JacksonXmlProperty(isAttribute = true)
    @NotBlank(message = "Width attribute must be specified in ScreenInfo")
    private Integer width;
    @JacksonXmlProperty(isAttribute = true)
    @NotBlank(message = "Height attribute must be specified in ScreenInfo")
    private Integer height;
    @JacksonXmlProperty(isAttribute = true)
    @NotBlank(message = "Dpi attribute must be specified in ScreenInfo")
    private Integer dpi;
}
