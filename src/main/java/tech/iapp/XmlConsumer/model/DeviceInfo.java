package tech.iapp.XmlConsumer.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@JacksonXmlRootElement
public class DeviceInfo {
    @JacksonXmlProperty(isAttribute = true)
    @NotBlank(message = "Name attribute must be specified in DeviceInfo")
    private String name;
    @JacksonXmlProperty(isAttribute = true)
    @NotBlank(message = "Id attribute must be specified in DeviceInfo")
    private String id;
    @JacksonXmlProperty
    @NotNull
    private ScreenInfo screenInfo;
    @JacksonXmlProperty
    @NotNull
    private OsInfo osInfo;
    @JacksonXmlProperty
    @NotNull
    private AppInfo appInfo;
}
