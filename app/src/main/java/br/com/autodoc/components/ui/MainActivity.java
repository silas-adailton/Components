package br.com.autodoc.components.ui;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import br.com.autodoc.components.R;
import br.com.autodoc.components.model.User;
import br.com.autodoc.components.viewModel.UserViewModel;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

public class MainActivity extends LifecycleActivity {

    @BindView(R.id.editText_name)EditText editName;
    @Inject
    ViewModelProvider.Factory factory;

    @BindView(R.id.recycler_user)

    RecyclerView recyclerViewUser;
    private UserViewModel userViewModel;
    private UserHowAdapter userHowAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initRecyclerView();
        showListUser();

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

    public void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerViewUser.setLayoutManager(layoutManager);
        recyclerViewUser.setHasFixedSize(true);
        recyclerViewUser.setItemAnimator(new DefaultItemAnimator());
        recyclerViewUser.addItemDecoration(dividerItemDecoration);
    }

    public void showListUser() {
        userViewModel = ViewModelProviders.of(this, factory).get(UserViewModel.class);

        userViewModel.getListUser().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                userHowAdapter = new UserHowAdapter(users);
                recyclerViewUser.setAdapter(userHowAdapter);
            }
        });
    }
}
