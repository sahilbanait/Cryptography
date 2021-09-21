package com.example.cryptography;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.cryptography.databinding.DecryptBinding;

public class Decryption extends AppCompatActivity {
DecryptBinding binding;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.decrypt);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editText = binding.editText.getText().toString();
                String textView = Decrypt.decode(editText);
                binding.textView.setText(textView);
            }
        });


        binding.buttonGoToEncrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Encryption.class);
                startActivity(intent);
            }
        });

    }

}
