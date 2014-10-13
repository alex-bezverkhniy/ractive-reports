package org.alexbezverkhniy.ractivereports.core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Alex Bezverkhniy on 10/9/14.
 */
@Entity
public class Report implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    private String version;
    @Column(length = 30000)
    private String template;
    @Column(length = 3000)
    private String defaultJsonData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDefaultJsonData() {
        return defaultJsonData;
    }

    public void setDefaultJsonData(String defaultJsonData) {
        this.defaultJsonData = defaultJsonData;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
