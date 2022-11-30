package com.example.dinostudy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.CustomViewHolder> {

    private ArrayList<Data_Board> arrayList;

    public BoardAdapter(ArrayList<Data_Board> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_board,parent,false);
        BoardAdapter.CustomViewHolder holder = new BoardAdapter.CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Data_Board data = arrayList.get(position);
        holder.title.setText(data.getTitle());
        holder.contents.setText(data.getContents());
        holder.nickname.setText(data.getDocumentID());
        holder.board_category.setText(data.getCategory());
        holder.board_date.setText(data.getDate());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //글 본문 띄워주기!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private TextView contents;
        private TextView board_category;
        private TextView nickname;
        private TextView board_date;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tv_title);
            contents = itemView.findViewById(R.id.contents);
            board_category = itemView.findViewById(R.id.board_category);
            nickname = itemView.findViewById(R.id.nickname);
            board_date = itemView.findViewById(R.id.board_date);
        }
    }
}
