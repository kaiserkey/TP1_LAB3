package com.example.tp1_lab3.ui.registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.tp1_lab3.R;
import com.example.tp1_lab3.databinding.ActivityMainBinding;
import com.example.tp1_lab3.model.Usuario;
import com.example.tp1_lab3.ui.login.LoginActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainActivityViewModel mv;
    private LoginActivityViewModel loginViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        loginViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LoginActivityViewModel.class);


        Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");
        binding.etNombre.setText(usuario.getNombre());
        binding.etApellido.setText(usuario.getApellido());
        binding.etDni.setText(String.valueOf(usuario.getDni()));
        binding.etMail.setText(usuario.getMail());
        binding.etClave.setText(usuario.getClave());

        binding.btnRegistrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mv.registrarUsuario(binding.etNombre.getText().toString()
                        ,binding.etApellido.getText().toString()
                        ,binding.etDni.getText().toString()
                        ,binding.etMail.getText().toString()
                        ,binding.etClave.getText().toString());
            }
        });

    }
}