package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.Fragment3Binding;

public class Fragment3 extends Fragment {

    private Fragment3Binding fragment3Binding;
    private static final String ARG_NAME = "name";
    private String name;

    public interface OnCheckBoxChanged {
        void onChanged(boolean isChecked);
    }

    public Fragment3() {
    }

    public static Fragment3 newInstance(String name) {
        Fragment3 fragment = new Fragment3();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            name = getArguments().getString(ARG_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragment3Binding = Fragment3Binding.inflate(inflater, container, false);

        fragment3Binding.textName.setText("Welcome, " + name);

        fragment3Binding.btnFinish.setEnabled(false);
        fragment3Binding.btnFinish.setText("Continue");

        OnCheckBoxChanged checkBoxChanged = new OnCheckBoxChanged() {
            @Override
            public void onChanged(boolean isChecked) {
                fragment3Binding.btnFinish.setEnabled(isChecked);

                if (isChecked) {
                    fragment3Binding.btnFinish.setText("Finish");
                } else {
                    fragment3Binding.btnFinish.setText("Continue");
                }
            }
        };

        fragment3Binding.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            checkBoxChanged.onChanged(isChecked);
        });

        return fragment3Binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragment3Binding = null;
    }
}