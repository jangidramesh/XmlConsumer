package tech.iapp.XmlConsumer.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import tech.iapp.XmlConsumer.dao.EPaperInfo;
import tech.iapp.XmlConsumer.model.dto.EPaperRequest;

import java.util.List;

public interface XmlConsumerApi {
    ResponseEntity extractXmlInfo(EPaperRequest xmlFilerequest);

    Page<EPaperInfo> getAllEPapers(String newspaperName, String fileName
            , int page, int size, List<String> sortList, Sort.Direction sortOrder);
}
