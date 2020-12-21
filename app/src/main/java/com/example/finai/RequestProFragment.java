package com.example.finai;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RequestProFragment extends Fragment {


    View v;
    private RecyclerView myrecyclerview;
    private List<RequestPro> Professional;

    public RequestProFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_request, container, false);
        //myrecyclerview = (RecyclerView) v.findViewById(R.id.contact_recyclerview);
        RecyclerView myrecyclerview = v.findViewById(R.id.contact_recyclerview);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(), Professional);
        myrecyclerview.setAdapter(recyclerAdapter);
        myrecyclerview.setItemAnimator(new DefaultItemAnimator());
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Professional = new ArrayList<>();
        Professional.add(new RequestPro("Chris O Shea - App Professional", "Phone - 1800 619 619  Email - Chris@usb.com ", R.drawable.icon));
        Professional.add(new RequestPro("Mei Chen - Website Professional", "Phone - 1800 916 916  Email - Mei@usb.com", R.drawable.icon));
        Professional.add(new RequestPro("Luke Briggs - ML Expert", "Phone - 1800 600 600  Email - Luke@usb.com ", R.drawable.icon));
        Professional.add(new RequestPro("Oliver Richardson - ML Expert", "Phone - 1800 900 900  Email - Oliver@usb.com ", R.drawable.icon));

    }
}
