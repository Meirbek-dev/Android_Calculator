package kz.bmk01.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewY;
    private EditText A, B, C, D, X;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewY = findViewById(R.id.textViewY);
        A = findViewById(R.id.editTextA);
        B = findViewById(R.id.editTextB);
        C = findViewById(R.id.editTextC);
        D = findViewById(R.id.editTextD);
        X = findViewById(R.id.editTextX);


        if (savedInstanceState != null) {
            textViewY.setText(savedInstanceState.getString("y"));
        }
    }

    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // Сохранение нужных нам значений компонент при перевороте экрана
        outState.putString("y", textViewY.getText().toString());
    }


    @SuppressLint("DefaultLocale")
    public void onButtonSolveClick(View view) {
        double a, b, c, d, x, y;

        try {
            x = Double.parseDouble(X.getText().toString().trim());

            if (x <= 5) {
                a = Double.parseDouble(A.getText().toString().trim());
                b = Double.parseDouble(B.getText().toString().trim());
                c = Double.parseDouble(C.getText().toString().trim());
                d = Double.parseDouble(D.getText().toString().trim());

                y = (a * a * c + b * b - d) / x;
            } else {
                y = x * x + 5;
            }

            textViewY.setText(String.format("y = %.3f", y));
        } catch (Exception e) {
            Toast.makeText(this, "Ошибка", Toast.LENGTH_LONG).show();
        }

        clearFocuses();
    }

    public void onButtonClearClick(View view) {
        textViewY.setText("");
        textViewY.setHint("y = ");
        A.setText("");
        B.setText("");
        C.setText("");
        D.setText("");
        X.setText("");
        clearFocuses();
    }

    private void clearFocuses() {
        A.clearFocus();
        B.clearFocus();
        C.clearFocus();
        D.clearFocus();
        X.clearFocus();
    }
}