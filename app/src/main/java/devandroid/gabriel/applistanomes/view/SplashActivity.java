package devandroid.gabriel.applistanomes.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import devandroid.gabriel.applistanomes.R;

public class SplashActivity extends AppCompatActivity {

    public static final int TIME_OUT_SPLASH = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        carregarTelaSplash();
    }

    private void carregarTelaSplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //Criar a "intenção" de mudar para a proxima tela
                Intent telaPrincipal = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(telaPrincipal);
                finish();
            }
        }, TIME_OUT_SPLASH);
    }
}