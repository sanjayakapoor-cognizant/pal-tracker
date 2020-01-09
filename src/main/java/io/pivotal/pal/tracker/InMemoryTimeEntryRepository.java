package io.pivotal.pal.tracker;

import com.sun.net.httpserver.Authenticator;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{
    private static List<TimeEntry> list = new ArrayList<TimeEntry>();

    public TimeEntry create(TimeEntry TimeEntr){
        list.add(TimeEntr);
        return TimeEntr;
    }

    public TimeEntry find(long timeEntryId){
        int i=0;
        while(i < list.size()){
            if((list.get(i)).getId() == timeEntryId){
                return list.get(i);
            }
            i++;
        }
        return null;
    }

    public TimeEntry update(long TimeEntryId, TimeEntry TimeEntr){
        TimeEntry FoundTimeEntry = this.find(TimeEntryId);
        if (FoundTimeEntry != null){
            FoundTimeEntry.setUserId(TimeEntr.getUserId());
            FoundTimeEntry.setDate(TimeEntr.getDate());
            FoundTimeEntry.setProjectId(TimeEntr.getProjectId());
            FoundTimeEntry.setHours(TimeEntr.getHours());
            return FoundTimeEntry;
        }
        return null;
    }

    public boolean delete(long id) {
        int i=0;
        while(i < list.size()){
            if(id == (list.get(i)).getId()){
                list.remove(i);
                return true;
            }
            i++;
        }
        return false;
    }

    public  List<TimeEntry> list() {
        return list;
    }
}
