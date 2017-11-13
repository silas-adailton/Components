package br.com.autodoc.components.view;

import android.app.AlertDialog;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.autodoc.components.MainApplication;
import br.com.autodoc.components.R;
import br.com.autodoc.components.data.Repositiry;
import br.com.autodoc.components.model.User;
import br.com.autodoc.components.viewModel.UserViewModel;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {
//    @Inject
    UserViewModel userViewModel = new UserViewModel(null);

    @Inject
    Repositiry repositiry;

    ViewModelProvider.Factory viewModelFactory;

    @BindView(R.id.editText_name)EditText editName;

    List<User> listUsuario = new ArrayList<>();
    LiveData<List<User>> listLiveData = new MutableLiveData<>();

    @BindView(R.id.recycler_user)
    RecyclerView recyclerView;
    private UserHowAdapter userHowAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initRecyclerView();
        showListUser();


        userViewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel.class);



        listUsuario = userViewModel.getUsers();
        userHowAdapter = new UserHowAdapter(listUsuario);
        recyclerView.setAdapter(userHowAdapter);
//
//        listUserViewModel = ViewModelProviders.of(this).get(ListUserViewModel.class);
//
//        listUserViewModel.listUserLive.observe(this, new Observer<List<User>>() {
//            @Override
//            public void onChanged(@Nullable List<User> list) {
//                userHowAdapter = new UserHowAdapter(list);
//                recyclerView.setAdapter(userHowAdapter);
//            }
//        });



//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                listUsuario = repositiry.getAll();
//                Log.d("TESTE", "onCreate: "+ listUsuario.toString());
//
//                userHowAdapter = new UserHowAdapter(listUsuario);
//                recyclerView.setAdapter(userHowAdapter);
//
//
//            }
//        }).start();
//
    }

    @OnClick(R.id.button_save) void save() {
        String userName = editName.getText().toString().trim();

        userViewModel.saveUser(userName);

        editName.setText(null);

        Toast.makeText(this, userName, Toast.LENGTH_SHORT).show();

//        showDialog();
    }

    @OnClick(R.id.button_listar) void listar() {
        Intent intent = new Intent(this, ListUserActivity.class);
        startActivity(intent);
    }

    private void showDialog() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_teste, null,false);
        Button button = view.findViewById(R.id.button_dialog);
        LinearLayoutCompat rel =view.findViewById(R.id.layout_check);
        dialog.setView(view);
        dialog.setCancelable(false);



        for (int i = 0; i < 5; i++) {
            CheckBox checkBox = new CheckBox(this);
            checkBox.setId(i);
            checkBox.setText("Pré Observação "+i);
            rel.addView(checkBox);
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "HAHAHA", Toast.LENGTH_SHORT).show();
            }
        });


        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "HUEHUE", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(MainActivity.this, "Cancelando!", Toast.LENGTH_SHORT).show();
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                    }
                });

            }
        });
        dialog.create();
        dialog.show();

    }

    private void initRecyclerView() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(dividerItemDecoration);

    }

    private void showListUser() {

//        listLiveData = listUserViewModel.getUsers();
//                userHowAdapter = new UserHowAdapter(listUsuario);
//                recyclerView.setAdapter(userHowAdapter);

//        Toast.makeText(MainActivity.this, "LiveData "+listLiveData.getValue(), Toast.LENGTH_SHORT).show();
//
//        listUsuario = listUserViewModel.listUser();
//
//        userHowAdapter = new UserHowAdapter(listUsuario);
//        recyclerView.setAdapter(userHowAdapter);

//        listUsuario = listUserViewModel.getUsers();
//
//        userHowAdapter = new UserHowAdapter(listUsuario);
//        recyclerView.setAdapter(userHowAdapter);

//        for (int i = 1; i <= 10; i++) {
//            User user = new User();
//            user.setId(i);
//            user.setName("Teste "+i);
////
//            listUsuario.add(user);
//            Toast.makeText(this, "Lista :"+listUsuario.toString(), Toast.LENGTH_SHORT).show();
//
//            Toast.makeText(this, "Usuario: "+user.getName()+ " Id: "+user.getId(), Toast.LENGTH_SHORT).show();
////            (this.getPackageName().getClass().getSimpleName(), "showListUser: "+ listUsuario.toString());
//
//        }

//        userHowAdapter = new UserHowAdapter(listUsuario);
//        recyclerView.setAdapter(userHowAdapter);

    }
}
