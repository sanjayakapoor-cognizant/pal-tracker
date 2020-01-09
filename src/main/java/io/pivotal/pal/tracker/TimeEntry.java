package io.pivotal.pal.tracker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Collection;

public class TimeEntry {

    private long id;
    private static long count;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry (){
        this.id=++count;
        this.projectId=0L;
        this.userId=0L;
        this.date = null;
        this.hours=0;
    }

    public TimeEntry (long projectId, long userId, LocalDate LDate, int hrs){
        this.id = ++count;
        this.projectId = projectId;
        this.userId = userId;
        this.date = LDate;
        this.hours = hrs;
        System.out.println("TimeEntry Created with id :" + this.id);
        System.out.println("Count Value is :" + count);
    }

    public TimeEntry (long timeEntryId, long projectId, long userId, LocalDate LDate, int hrs){
        this.id = timeEntryId;
        this.projectId = projectId;
        this.userId = userId;
        this.date = LDate;
        this.hours = hrs;
    }

    public long getId() {
        return id;
    }

    public int getHours() {
        return hours;
    }

    public LocalDate getDate() {
        return date;
    }

    public long getProjectId() {
        return projectId;
    }

    public long getUserId() {
        return userId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setProjectId(long id) {
        this.projectId = id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
