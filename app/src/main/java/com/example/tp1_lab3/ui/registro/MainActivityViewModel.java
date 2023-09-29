package com.example.tp1_lab3.ui.registro;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.tp1_lab3.model.Usuario;
import com.example.tp1_lab3.ui.login.LoginActivity;
import com.example.tp1_lab3.ui.request.ApiClient;

public class MainActivityViewModel extends AndroidViewModel {

    private Context context;
    private ApiClient apiClient;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        apiClient = new ApiClient();
    }

    public void registrarUsuario(String nombre, String apellido, String dni, String mail, String clave) {
        try {
            Long dniLong = Long.parseLong(dni);
            Usuario usuario = new Usuario(nombre, apellido, dniLong, mail, clave);

            apiClient.registrar(context, usuario);

            Intent intent = new Intent(context, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            context.startActivity(intent);

        } catch (NumberFormatException e) {
            Toast.makeText(context, "El DNI debe ser un número válido", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(context, "Error al registrar usuario", Toast.LENGTH_SHORT).show();
        }

    }
}
