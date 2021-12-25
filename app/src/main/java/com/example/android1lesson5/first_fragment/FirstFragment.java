package com.example.android1lesson5.first_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.android1lesson5.R;
import com.example.android1lesson5.second_fragment.SecondFragment;

import java.security.Key;


public class FirstFragment extends Fragment {
    Button btnGo;
    TextView txOne;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnGo = view.findViewById(R.id.btn_go);
        txOne = view.findViewById(R.id.tv_one);
        listeners();
        getData();

    }


    private void listeners() {
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment secondFragment = new SecondFragment();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fl_container, secondFragment).commit();
            }
        });
        txOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comet = txOne.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("etKEY", comet);
                SecondFragment secondFragment = new SecondFragment();
                secondFragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction().replace(R.id.fl_container, secondFragment).commit();
            }

        });
    }

    private void getData() {
        if (getArguments() != null) {
            String s = getArguments().getString("KEY");
            txOne.setText(s);
        }
    }
}