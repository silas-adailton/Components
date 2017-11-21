package br.com.autodoc.components.ui;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.autodoc.components.R;
import br.com.autodoc.components.model.User;
import br.com.autodoc.components.viewModel.UserViewModel;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.subscribers.DisposableSubscriber;

public class MainActivity extends DaggerAppCompatActivity implements LifecycleObserver, UserHowAdapter.UserOnclickListener {

    @BindView(R.id.editText_name)
    EditText editName;
    @BindView(R.id.recycler_user)
    RecyclerView recyclerViewUser;
    @BindView(R.id.main_toolbar)
    Toolbar toolbar;

    @BindView(R.id.button_save)Button btnSalvar;

    @Inject
    ViewModelProvider.Factory factory;
    private UserViewModel userViewModel;
    private UserHowAdapter userHowAdapter;

    @Inject
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLifecycle().addObserver(MainActivity.this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        getLifecycle().removeObserver(MainActivity.this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void initializeView() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void showButtonSave() {
        editName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                btnSalvar.setVisibility(View.GONE);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0) {
                    btnSalvar.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void initializeToolbar() {
        getSupportActionBar();
        toolbar.setTitle("Teste");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerViewUser.setLayoutManager(layoutManager);
        recyclerViewUser.setHasFixedSize(true);
        recyclerViewUser.setItemAnimator(new DefaultItemAnimator());
        recyclerViewUser.addItemDecoration(dividerItemDecoration);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void showListUser() {

        registerForContextMenu(recyclerViewUser);

        userViewModel = ViewModelProviders.of(this, factory).get(UserViewModel.class);

//        userViewModel.getListUser().observe(this, new Observer<List<User>>() {
//            @Override
//            public void onChanged(@Nullable List<User> users) {
//                userHowAdapter = new UserHowAdapter(users);
//                recyclerViewUser.setAdapter(userHowAdapter);
//            }
//        });
        userViewModel.getUser().subscribeWith(new DisposableSubscriber<List<User>>() {
            @Override
            public void onNext(List<User> users) {
                userHowAdapter = new UserHowAdapter(users);
                recyclerViewUser.setAdapter(userHowAdapter);
                userHowAdapter.setUserOnclickListener(MainActivity.this);
            }

            @Override
            public void onError(Throwable t) {
                Toast.makeText(MainActivity.this, "Erro " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Toast.makeText(MainActivity.this, "Completou", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @OnClick(R.id.button_save)
    void save() {
        String userName = editName.getText().toString().trim();

//        userViewModel.saveUser(userName);
//        userViewModel = ViewModelProviders.of(this, factory).get(UserViewModel.class);

        userViewModel.saveUserRx(userName).doOnTerminate(this::clearEditText)
                .subscribe();
        Toast.makeText(this, userName, Toast.LENGTH_SHORT).show();
    }

    private void clearEditText() {
        editName.setText("");
    }

    @Override
    public void onClickUserListener(View view, List<User> list, int id) {
//        delete(id);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected()) {
                Toast.makeText(this, ""+list.toString(), Toast.LENGTH_SHORT).show();
            }
        }

        ActionMode.Callback callback = new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                MenuInflater inflater = actionMode.getMenuInflater();
                inflater.inflate(R.menu.item_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                delete(id);
                Toast.makeText(MainActivity.this, "ItemClicked", Toast.LENGTH_SHORT).show();
                actionMode.finish();
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {

            }
        };
        recyclerViewUser.startActionMode(callback);


    }

    @Override
    public void onClickUser(View view, List<User> list, int id) {
//        findViewById(R.id.textView).setBackgroundColor(getResources().getColor(R.color.text));
    }

    private void delete(int id) {
        userViewModel.deleteUser(id).subscribe();

    }

}
