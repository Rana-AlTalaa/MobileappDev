package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements Fragment2.OnUserDataSend {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Fragment1 fragment1 = Fragment1.newInstance(null, null);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment1)
                .commit();

        binding.buttonContinue.setOnClickListener(view -> {
            Fragment2 fragment2 = Fragment2.newInstance(null, null);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment2)
                    .addToBackStack(null)
                    .commit();

            binding.buttonContinue.setVisibility(View.GONE);
        });
    }

    @Override
    public void onSendData(String name) {
        Fragment3 fragment3 = Fragment3.newInstance(name);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment3)
                .addToBackStack(null)
                .commit();
    }
}