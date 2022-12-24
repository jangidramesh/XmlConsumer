package tech.iapp.XmlConsumer.util;

import tech.iapp.XmlConsumer.dao.EPaperInfo;
import tech.iapp.XmlConsumer.model.dto.EPaperRequest;
import tech.iapp.XmlConsumer.model.dto.XmlSaveResponse;

import java.time.Instant;

public class MapperUtil {

    public static EPaperInfo toData(EPaperRequest ePaperRequest){
        EPaperInfo ePaperInfo = new EPaperInfo();
        ePaperInfo.setNewspaperName(ePaperRequest.getDeviceInfo().getAppInfo().getNewspaperName());
        ePaperInfo.setWidth(ePaperRequest.getDeviceInfo().getScreenInfo().getWidth());
        ePaperInfo.setHeight(ePaperRequest.getDeviceInfo().getScreenInfo().getHeight());
        ePaperInfo.setDpi(ePaperRequest.getDeviceInfo().getScreenInfo().getDpi());
        ePaperInfo.setFileName("Upload_"+ePaperRequest.getDeviceInfo().getId());
        ePaperInfo.setUploadTime(Instant.now().toString());
        return ePaperInfo;
    }

    public static XmlSaveResponse toData(EPaperInfo ePaperInfo){
        XmlSaveResponse xmlSaveResponse = new XmlSaveResponse();
        xmlSaveResponse.setFileName(ePaperInfo.getFileName());
        xmlSaveResponse.setUploadTime(ePaperInfo.getUploadTime());
        return xmlSaveResponse;
    }
}
