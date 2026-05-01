package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.databinding.Fragment2Binding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {

    private Fragment2Binding fragment2Binding;
    private OnUserDataSend listener;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public interface OnUserDataSend {
        void onSendData(String name);
    }

    public Fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (OnUserDataSend) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragment2Binding = Fragment2Binding.inflate(inflater, container, false);

        fragment2Binding.btnContinue.setOnClickListener(view -> {
            String name = fragment2Binding.editTextName.getText().toString();
            String email = fragment2Binding.editTextEmail.getText().toString();
            String age = fragment2Binding.editTextAge.getText().toString();

            if (TextUtils.isEmpty(name)) {
                Toast.makeText(getContext(), "Enter name!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(email)) {
                Toast.makeText(getContext(), "Enter email!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(age)) {
                Toast.makeText(getContext(), "Enter age!", Toast.LENGTH_SHORT).show();
            } else {
                listener.onSendData(name);
            }
        });

        return fragment2Binding.getRoot();
    }
}