package io.pivotal.pal.tracker;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;;


@SpringBootApplication
public class PalTrackerApplication {

    public static void main(String[] args){
        SpringApplication.run(PalTrackerApplication.class, args);
    }

    @Bean
    public JdbcTimeEntryRepository TimeEntryRepositoryService() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl(System.getenv("SPRING_DATASOURCE_URL"));
        JdbcTimeEntryRepository timeEntryRepository = new JdbcTimeEntryRepository(dataSource);
        return timeEntryRepository;
    }

}