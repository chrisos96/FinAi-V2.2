package com.example.finai;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ChatFragment extends Fragment {

    TextView Input_txt;
    TextView Output_txt;
    Button Send_txt;

    public ChatFragment(){
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        Input_txt = (TextView) view.findViewById(R.id.input_text);
        Output_txt = (TextView) view.findViewById(R.id.output_text);
        Send_txt = (Button) view.findViewById(R.id.send_button);

        //The code for the ChatBot to import will most likely go here

    }





    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chatbot,container,false);
    }
}
