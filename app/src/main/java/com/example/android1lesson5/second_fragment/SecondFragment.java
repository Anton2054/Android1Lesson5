package com.example.android1lesson5.second_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.android1lesson5.R;
import com.example.android1lesson5.first_fragment.FirstFragment;


public class SecondFragment extends Fragment {
    EditText etInput;
    Button btnData;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etInput = view.findViewById(R.id.et_input);
        btnData = view.findViewById(R.id.btn_data);
        listeners();
        getData();
    }

    private void listeners() {
        btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etInput.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("KEY", title);
                FirstFragment firstFragment = new FirstFragment();
                firstFragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction().replace(R.id.fl_container, firstFragment).commit();
            }
        });
    }

    private void getData() {
        if (getArguments() != null) {
            String tx = getArguments().getString("etKEY");
            etInput.setText(tx);
        }
    }

}