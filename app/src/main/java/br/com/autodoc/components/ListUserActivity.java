package br.com.autodoc.components;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.autodoc.components.model.User;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ListUserActivity extends AppCompatActivity {

    @BindView(R.id.recycler_user) RecyclerView recyclerView;
    private UserHowAdapter userHowAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        ButterKnife.bind(this);

        initializeRecyclerView();

//        showUsers();
    }

    public void showUsers( List<User> listUser) {
        userHowAdapter = new UserHowAdapter(listUser);
        recyclerView.setAdapter(userHowAdapter);

    }

    public void initializeRecyclerView() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(dividerItemDecoration);

    }
}
