package io.pivotal.pal.tracker;
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
    public InMemoryTimeEntryRepository TimeEntryRepositoryService() {
        InMemoryTimeEntryRepository timeEntryRepository = new InMemoryTimeEntryRepository();
        return timeEntryRepository;
    }

}