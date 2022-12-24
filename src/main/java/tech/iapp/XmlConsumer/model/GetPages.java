package tech.iapp.XmlConsumer.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@JacksonXmlRootElement
public class GetPages {
    @JacksonXmlProperty(isAttribute = true)
    @NotBlank(message = "EditionDefId attribute must be specified in GetPages")
    private String editionDefId;
    @JacksonXmlProperty(isAttribute = true)
    @NotBlank(message = "PublicationDate attribute must be specified in GetPages")
    private String publicationDate;
}