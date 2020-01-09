package io.pivotal.pal.tracker;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("/time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;
    public TimeEntryController (TimeEntryRepository timeEntryRepository){
        this.timeEntryRepository = timeEntryRepository;
    }

    @GetMapping(value="/time-entries/{EntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable long EntryId){
        var timeEntry = timeEntryRepository.find(EntryId);
        HttpStatus HStatus = HttpStatus.NOT_FOUND;
        var headers = new HttpHeaders();
        headers.add("Responded", "TimeEntryController");
        if ( timeEntry != null){
            HStatus = HttpStatus.OK;
        }
        return ResponseEntity.status(HStatus).headers(headers).body(timeEntry);

    }

    @PutMapping(value="/time-entries/{EntryId}", consumes = "application/json")
    public ResponseEntity<TimeEntry> update(@PathVariable long EntryId, @RequestBody TimeEntry TimeEnt){
        HttpStatus HStatus = HttpStatus.NOT_FOUND;
        var timeEntry = timeEntryRepository.update(EntryId,TimeEnt);
        var headers = new HttpHeaders();
        headers.add("Responded", "TimeEntryController");
        if (timeEntry != null) {
            HStatus = HttpStatus.OK;
        }
        return ResponseEntity.status(HStatus).headers(headers).body(timeEntry);
    }

    @GetMapping("/time-entries")
     public ResponseEntity<List<TimeEntry>> list(){
        var timeEntryList = timeEntryRepository.list();
        HttpStatus HStatus = HttpStatus.OK;
        var headers = new HttpHeaders();
        headers.add("Responded", "TimeEntryController");
        return ResponseEntity.status(HStatus).headers(headers).body(timeEntryList);
    }

    @PostMapping(path = "/time-entries", consumes = "application/json")
     public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        var timeEntry = timeEntryRepository.create(timeEntryToCreate);
        var headers = new HttpHeaders();
        headers.add("Responded", "TimeEntryController");
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(timeEntry);

    }

    @DeleteMapping(value="/time-entries/{timeEntryId}")
    public ResponseEntity delete(@PathVariable long timeEntryId) {
        boolean value   = this.timeEntryRepository.delete(timeEntryId);
        var headers = new HttpHeaders();
//        if (value == true){
//            return ResponseEntity.status(HttpStatus.FOUND).headers(headers).body(null);
//        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).headers(headers).body(null);
    }

}
