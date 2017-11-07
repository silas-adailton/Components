package br.com.autodoc.components;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.editText_name)EditText editName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        editName.setText("ajdjkahdjkahdjkas");



    }

    @OnClick(R.id.button_save) void save() {
        String user = editName.getText().toString().trim();

        Toast.makeText(this, user, Toast.LENGTH_SHORT).show();

    }

    @OnClick(R.id.button_listar) void listar() {
        Intent intent = new Intent(this, ListUserActivity.class);
        startActivity(intent);
    }
}
