package tech.iapp.XmlConsumer.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.iapp.XmlConsumer.api.XmlConsumerApi;
import tech.iapp.XmlConsumer.dao.EPaperInfo;
import tech.iapp.XmlConsumer.model.dto.EPaperRequest;
import tech.iapp.XmlConsumer.model.dto.XmlSaveResponse;
import tech.iapp.XmlConsumer.service.XmlConsumerService;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class XmlConsumerController implements XmlConsumerApi {

  private final XmlConsumerService xmlConsumerService;

  @Override
  @PostMapping(value = "/epaper", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
          , produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<XmlSaveResponse> extractXmlInfo(@RequestBody EPaperRequest xmlFileRequest) {
    log.info("Xml request received as :" + xmlFileRequest.toString());
    XmlSaveResponse xmlSaveResponse = xmlConsumerService.extractAndSaveDeviceInfo(xmlFileRequest);
    log.info("Dispatch Xml response as :" + xmlSaveResponse.toString());
    return ResponseEntity.status(HttpStatus.CREATED).body(xmlSaveResponse);
  }

  @Override
  @GetMapping(value = "/epaper", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
  public Page<EPaperInfo> getAllEPapers(@RequestParam(defaultValue = "") String newspaperName,
                                          @RequestParam(defaultValue = "") String fileName,
                                        @RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "20") int size,
                                        @RequestParam(defaultValue = "") List<String> sortList,
                                        @RequestParam(defaultValue = "DESC") Sort.Direction sortOrder) {
    log.info("Get request received");
    return xmlConsumerService.fetchFilteredEPaperInfoAsPage(newspaperName, fileName,
            page, size, sortList, sortOrder.toString());
  }

}