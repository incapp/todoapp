package com.test.todolistapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editTextTodo;
    ImageButton imageButtonAdd;
    RecyclerView recyclerView;
    TodoDao todoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTodo = findViewById(R.id.editText_todo);
        imageButtonAdd = findViewById(R.id.imageButton_add);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.VERTICAL,
                false
        ));
        recyclerView.addItemDecoration(new DividerItemDecoration(
                MainActivity.this,
                DividerItemDecoration.VERTICAL
        ));

        todoDao = AppDatabase
                .getAppDatabase(MainActivity.this)
                .todoDao();

        showTodoList();

        imageButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String desc = editTextTodo.getText().toString();

                Todo todo = new Todo(desc);

                todoDao.insertTodo(todo);

                showTodoList();
            }
        });
    }

    private void showTodoList() {
        List<Todo> todoList = todoDao.getAllTodo();

        TodoListAdapter todoListAdapter = new TodoListAdapter(todoList);

        recyclerView.setAdapter(todoListAdapter);
    }
}
