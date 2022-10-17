package com.example.dinostudy;

import android.app.AlertDialog;
import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.CustomViewHolder>{

    private ArrayList<Data_Todo> arrayList;
    private Context todoContext;

    public TodoAdapter(ArrayList<Data_Todo> arrayList) {
        this.arrayList = arrayList;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        protected CheckBox cb_todo;
        protected TextView tv_todo;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            this.cb_todo = (CheckBox) itemView.findViewById(R.id.cb_todo);
            this.tv_todo = (TextView) itemView.findViewById(R.id.tv_todo);

            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            MenuItem Edit = contextMenu.add(Menu.NONE, 1001, 1, "편집");
            MenuItem Delete = contextMenu.add(Menu.NONE, 1002, 2, "삭제");
            Edit.setOnMenuItemClickListener(onEditMenu);
            Delete.setOnMenuItemClickListener(onEditMenu);
        }

        private final MenuItem.OnMenuItemClickListener onEditMenu = new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case 1001:
                        AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
                        View view = LayoutInflater.from(itemView.getContext()).inflate(R.layout.plus_todo, null, false);
                        builder.setView(view);

                        final Button btn_todo_insert = (Button)view.findViewById(R.id.btn_todo_insert);
                        final EditText et_todo = (EditText)view.findViewById(R.id.et_todo);
                        btn_todo_insert.setText("변경");

                        et_todo.setText(arrayList.get(getAdapterPosition()).getTv_todo());

                        final AlertDialog dialog = builder.create();

                        btn_todo_insert.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String todo_content = et_todo.getText().toString();

                                //false를 디폴트로 넣었지만 현재값 유지하게 바꿔야 함
                                Data_Todo dataTodo = new Data_Todo(false, todo_content);

                                arrayList.set(getAdapterPosition(), dataTodo);

                                notifyItemChanged(getAdapterPosition());

                                dialog.dismiss();
                            }
                        });

                        dialog.show();
                        break;
                    case 1002:
                        arrayList.remove(getAdapterPosition());
                        notifyItemRemoved(getAdapterPosition());
                        notifyItemRangeChanged(getAdapterPosition(), arrayList.size());

                        break;
                }
                return true;
            }
        };
    }



    @NonNull
    @Override
    public TodoAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_todo,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.cb_todo.setChecked(arrayList.get(position).getCb_todo());
        holder.tv_todo.setText(arrayList.get(position).getTv_todo());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String curName = holder.tv_todo.getText().toString();
                Toast.makeText(view.getContext(),curName,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

}
