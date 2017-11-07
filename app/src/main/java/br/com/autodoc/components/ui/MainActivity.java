package br.com.autodoc.components.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import br.com.autodoc.components.R;
import br.com.autodoc.components.viewModel.UserViewModel;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    UserViewModel userViewModel;


    @BindView(R.id.editText_name)EditText editName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.button_save) void save() {
        String userName = editName.getText().toString().trim();

        userViewModel.saveUser(userName);

        Toast.makeText(this, userName, Toast.LENGTH_SHORT).show();

    }

    @OnClick(R.id.button_listar) void listar() {
        Intent intent = new Intent(this, ListUserActivity.class);
        startActivity(intent);
    }
}
