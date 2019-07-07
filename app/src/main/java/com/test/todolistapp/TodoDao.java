package com.test.todolistapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TodoDao {

    @Insert
    void insertTodo(Todo todo);

    @Update
    void update(Todo todo);

    @Query("SELECT * FROM todo ORDER BY is_complete")
    List<Todo> getAllTodo();
}
