package com.nttdata.ta.todo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String category;
    private String name;
    private boolean complete;
    private String priority;

    private boolean xpAwarded;

    // Default constructor required by JPA
    public TodoItem() {
        this.priority = "MEDIUM";
        this.xpAwarded = false;
    }

    // Constructor used when creating a new task
    public TodoItem(String category, String name) {
        this.category = category;
        this.name = name;
        this.complete = false;
        this.priority = "MEDIUM";
        this.xpAwarded = false;
    }

    @Override
    public String toString() {
        return String.format(
                "TodoItem[id=%d, category='%s', name='%s', complete='%b', priority='%s', xpAwarded='%b']",
                id,
                category,
                name,
                complete,
                priority,
                xpAwarded
        );
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean isXpAwarded() {
        return xpAwarded;
    }

    public void setXpAwarded(boolean xpAwarded) {
        this.xpAwarded = xpAwarded;
    }
}