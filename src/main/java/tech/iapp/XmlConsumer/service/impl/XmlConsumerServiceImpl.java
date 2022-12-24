package tech.iapp.XmlConsumer.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tech.iapp.XmlConsumer.dao.EPaperInfo;
import tech.iapp.XmlConsumer.model.dto.EPaperRequest;
import tech.iapp.XmlConsumer.model.dto.XmlSaveResponse;
import tech.iapp.XmlConsumer.repositories.EPaperInfoRepository;
import tech.iapp.XmlConsumer.service.XmlConsumerService;
import tech.iapp.XmlConsumer.util.MapperUtil;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class XmlConsumerServiceImpl implements XmlConsumerService {

    private final EPaperInfoRepository ePaperInfoRepository;

    @Override
    public XmlSaveResponse extractAndSaveDeviceInfo(EPaperRequest xmlFilerequest) {
        log.info("Inside extractAndSaveDeviceInfo method");
        EPaperInfo ePaperInfo = ePaperInfoRepository.save(MapperUtil.toData(xmlFilerequest));
        log.info("Leaving extractAndSaveDeviceInfo method");
        return MapperUtil.toData(ePaperInfo);
    }

    @Override
    public Page<EPaperInfo> fetchFilteredEPaperInfoAsPage(String newspaperName, String fileName, int page,
                                                          int size, List<String> sortList, String sortOrder) {
        log.info("Inside fetchFilteredEPaperInfoAsPage method");
        Pageable pageable = PageRequest.of(page, size, Sort.by(createOrder(sortList, sortOrder)));
        log.info("Leaving fetchFilteredEPaperInfoAsPage method");
        return ePaperInfoRepository.fetchFilteredPaperInfoAsList(newspaperName, fileName, pageable);
    }

    private List<Sort.Order> createOrder(List<String> sortList, String sortDirection) {
        List<Sort.Order> sorts = new ArrayList<>();
        Sort.Direction direction;
        for (String sort : sortList) {
            if (sortDirection != null) {
                direction = Sort.Direction.fromString(sortDirection);
            } else {
                direction = Sort.Direction.DESC;
            }
            sorts.add(new Sort.Order(direction, sort));
        }
        return sorts;
    }
}
