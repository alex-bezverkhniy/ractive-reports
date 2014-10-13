package org.alexbezverkhniy.ractivereports;

import org.alexbezverkhniy.ractivereports.core.model.Report;
import org.alexbezverkhniy.ractivereports.core.repositories.ReportRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;

/**
 * Created by Alex Bezverkhniy on 10/9/14.
 */
@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "org.alexbezverkhniy.ractivereports.core.repositories")
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        //SpringApplication.run(Application.class, args);

        ReportRepository reportRepository = context.getBean(ReportRepository.class);

        Report report = new Report();
        report.setName("sample-report");
        report.setTitle("Sample Report");
        report.setLastUpdate(new Date());
        report.setVersion("0.0.1");
        report.setTemplate("<p>Hello {{name}}!</p>\n" +
                "<table id=\"rows\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width:500px\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td><b>Name</b></td>\n" +
                "\t\t\t<td><b>Age</b></td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>{{name}}</td>\n" +
                "\t\t\t<td>{{age}}</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>&nbsp;</td>\n" +
                "\t\t\t<td>&nbsp;</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>\n");
        report.setDefaultJsonData("{\"name\" : \"World\", \"rows\": [{\"name\" : \"Alex\", \"age\" : \"33\"},{\"name\" : \"Alik\", \"age\" : \"33\"}]}");

        reportRepository.save(report);

    }

}