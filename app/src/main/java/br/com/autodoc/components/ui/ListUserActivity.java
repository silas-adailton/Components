package br.com.autodoc.components.ui;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.autodoc.components.R;
import br.com.autodoc.components.data.user.Repository;
import br.com.autodoc.components.model.User;
import br.com.autodoc.components.viewModel.ListUserViewModel;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;

public class ListUserActivity extends DaggerAppCompatActivity implements LifecycleOwner {
    private LifecycleRegistry lifecycleRegistry;

    ListUserViewModel listUserViewModel;

    List<User> liUser = new ArrayList<>();
    LiveData<List<User>> listLiveData = new MutableLiveData<>();

    @Inject
    ViewModelProvider.Factory factory;

    @Inject
    Repository repositoryImpl;

    @BindView(R.id.recycler_user) RecyclerView recyclerView;
    private UserHowAdapter userHowAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        ButterKnife.bind(this);
        initializeRecyclerView();
        listUserViewModel = ViewModelProviders.of(this, factory).get(ListUserViewModel.class);

        listUserViewModel.getUsers().observe(this, userEntities -> {

//                Toast.makeText(ListUserActivity.this, ""+userEntities, Toast.LENGTH_SHORT).show();
            userHowAdapter = new UserHowAdapter(userEntities);
            recyclerView.setAdapter(userHowAdapter);
        });


//        listLiveData = listUserViewModel.getUsers();
//
//        Toast.makeText(this, ""+listLiveData.getValue(), Toast.LENGTH_SHORT).show();

//            userHowAdapter = new UserHowAdapter(listLiveData);
//            recyclerView.setAdapter(userHowAdapter);



//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                liUser = repositoryImpl.getAll();
//
////                for (int i = 0; i < 10; i++) {
////
////                    User user = new User();
////                    user.setNamePet("Teste "+i);
////                    liUser.add(user);
////                }
////
////                Toast.makeText(ListUserActivity.this, ""+liUser.toString(), Toast.LENGTH_SHORT).show();
////
//                userHowAdapter = new UserHowAdapter(liUser);
//                recyclerView.setAdapter(userHowAdapter);
//            }
//        }).start();






//        showUsers();
    }

    public void showUsers() {

//        LiveData<List<User>> listUser = listUserViewModel.getUsers();

//        userHowAdapter = new UserHowAdapter(listUser);
//        recyclerView.setAdapter(userHowAdapter);

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
