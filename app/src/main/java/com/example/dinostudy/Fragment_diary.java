package com.example.dinostudy;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_diary extends Fragment {

    //private TextView tv_compliment, tv_reflection;
    //private ImageButton btn_diary_plus;

    public Fragment_diary(){

    }

    Context ct;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_diary, container, false);

        ct = container.getContext();

        final ImageButton btn_diart_plus = (ImageButton) v.findViewById(R.id.btn_diary_plus);
        final TextView tv_compliment = (TextView) v.findViewById(R.id.tv_compliment);
        final TextView tv_reflection = (TextView) v.findViewById(R.id.tv_reflection);

        btn_diart_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ct);
                View view1 = LayoutInflater.from(ct).inflate(R.layout.plus_diary, null, false);
                builder.setView(view1);

                final EditText et_compliment = (EditText) view1.findViewById(R.id.et_compliment);
                final EditText et_reflection = (EditText) view1.findViewById(R.id.et_reflection);
                final Button btn_diary_insert = (Button) view1.findViewById(R.id.btn_diary_insert);

                final AlertDialog dialog = builder.create();

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                btn_diary_insert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //사용자 입력한 내용
                        String compliment = et_compliment.getText().toString();
                        String reflection = et_reflection.getText().toString();

                        tv_compliment.setText(compliment);
                        tv_reflection.setText(reflection);

                        tv_compliment.setMovementMethod(new ScrollingMovementMethod());
                        tv_reflection.setMovementMethod(new ScrollingMovementMethod());

                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        return v;
    }
}
