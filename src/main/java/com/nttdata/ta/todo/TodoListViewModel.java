package com.nttdata.ta.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoListViewModel {

    private List<TodoItem> todoList;

    public TodoListViewModel() {
        this.todoList = new ArrayList<>();
    }

    public TodoListViewModel(Iterable<TodoItem> todoList) {

        this.todoList = new ArrayList<>();

        for (TodoItem item : todoList) {
            this.todoList.add(item);
        }
    }

    public List<TodoItem> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<TodoItem> todoList) {
        this.todoList = todoList;
    }
}