package tech.iapp.XmlConsumer.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class XmlSaveResponse {
    private String fileName;
    private String uploadTime;
}
