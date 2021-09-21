package com.example.cryptography;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.cryptography.databinding.EncryptBinding;


public class Encryption extends AppCompatActivity {
    EncryptBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.encrypt);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editText = binding.editText.getText().toString();
                String textView = Encrypt.encode(editText);
                binding.textView.setText(textView);
            }
        });

        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        binding.buttonClipboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = binding.textView.getText().toString().trim();
                if(!data.isEmpty()){
                    ClipData clipData = ClipData.newPlainText("text", data);
                    clipboardManager.setPrimaryClip(clipData);
                    Toast.makeText(getApplicationContext(), "Text copied", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.buttonGoTODecrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Decryption.class);
                startActivity(intent);
            }
        });
    }



}
