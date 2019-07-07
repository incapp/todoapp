package com.test.todolistapp;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.MyViewHolder> {

    private List<Todo> todoList;

    public TodoListAdapter(List<Todo> todoList) {
        this.todoList = todoList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_for_recyclerview, null, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Todo todo = todoList.get(i);

        myViewHolder.textViewDesc.setText(todo.getDesc());

//        if (todo.isComplete()) {
//            myViewHolder.textViewDesc.setPaintFlags(
//                    myViewHolder.textViewDesc.getPaintFlags() |
//                            Paint.STRIKE_THRU_TEXT_FLAG
//            );
//        } else {
//            myViewHolder.textViewDesc.setPaintFlags(
//                    myViewHolder.textViewDesc.getPaintFlags() |
//                            ~Paint.STRIKE_THRU_TEXT_FLAG
//            );
//        }
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewDesc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewDesc = itemView.findViewById(R.id.textView_desc);
        }
    }
}
