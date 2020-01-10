package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.List;

public interface TimeEntryRepository {

    //private static List<TimeEntry> list; = new ArrayList<TimeEntry>();

    TimeEntry create(TimeEntry TimeEntr);
    TimeEntry find(Long timeEntryId);
    TimeEntry update(Long id, TimeEntry timeEntry);
    List<TimeEntry> list();
    void delete(Long id);
}
