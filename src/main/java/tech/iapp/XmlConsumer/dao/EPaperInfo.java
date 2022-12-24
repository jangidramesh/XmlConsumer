package tech.iapp.XmlConsumer.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "epaper_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EPaperInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String newspaperName;
    private Integer width;
    private Integer height;
    private Integer dpi;
    private String fileName;
    private String uploadTime;

}
