package com.example.dinostudy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StopwatchAdapter extends RecyclerView.Adapter<StopwatchAdapter.CustomViewHolder> {

    private ArrayList<Data_Subject> arrayList;

    public StopwatchAdapter(ArrayList<Data_Subject> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public StopwatchAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_subject,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StopwatchAdapter.CustomViewHolder holder, int position) {
        holder.tv_subject.setText(arrayList.get(position).getTv_subject());
        holder.tv_subject_time.setText(arrayList.get(position).getTv_subject_time());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String curName = holder.tv_subject.getText().toString();
                Toast.makeText(view.getContext(), curName, Toast.LENGTH_SHORT).show();
            }
        });

        //길게 누르면 삭제
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                remove(holder.getAdapterPosition());
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public void remove(int position){
        try {
            arrayList.remove(position); //리스트 뷰 지움
            notifyItemRemoved(position); //새로고침
        } catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView tv_subject;
        protected TextView tv_subject_time;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_subject = (TextView) itemView.findViewById(R.id.tv_subject);
            this.tv_subject_time = (TextView) itemView.findViewById(R.id.tv_subject_time);
        }
    }
}
