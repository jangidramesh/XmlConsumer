package tech.iapp.XmlConsumer.service;

import org.springframework.data.domain.Page;
import tech.iapp.XmlConsumer.dao.EPaperInfo;
import tech.iapp.XmlConsumer.model.dto.EPaperRequest;
import tech.iapp.XmlConsumer.model.dto.XmlSaveResponse;

import java.util.List;

public interface XmlConsumerService {
    XmlSaveResponse extractAndSaveDeviceInfo(EPaperRequest xmlFileRequest);
    Page<EPaperInfo> fetchFilteredEPaperInfoAsPage(String newspaperName, String fileName, int page,
                                                   int size, List<String> sortList, String sortOrder);
}
