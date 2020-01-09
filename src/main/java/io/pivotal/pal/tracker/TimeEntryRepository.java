package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.List;

public interface TimeEntryRepository {

    //private static List<TimeEntry> list; = new ArrayList<TimeEntry>();

    TimeEntry create(TimeEntry TimeEntr);
    TimeEntry find(long timeEntryId);
    TimeEntry update(long TimeEntryId, TimeEntry TimeEntr);
    public List<TimeEntry> list();
    boolean delete(long id);


}
