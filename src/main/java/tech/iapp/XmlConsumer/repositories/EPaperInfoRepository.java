package tech.iapp.XmlConsumer.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.iapp.XmlConsumer.dao.EPaperInfo;

@Repository
public interface EPaperInfoRepository extends JpaRepository<EPaperInfo, Integer> {
    String FILTER_EPAPER_ON_NEWSPAPER_NAME_AND_FILE_NAME_QUERY = "select e from EPaperInfo e where UPPER(e.newspaperName) like CONCAT('%',UPPER(?1),'%') and UPPER(e.fileName) like CONCAT('%',UPPER(?2),'%')";

    @Query(FILTER_EPAPER_ON_NEWSPAPER_NAME_AND_FILE_NAME_QUERY)
    Page<EPaperInfo> fetchFilteredPaperInfoAsList(String newspaperName, String fileName, Pageable pageable);
}
