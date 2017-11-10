package br.com.autodoc.components.di.module;

import android.arch.lifecycle.LiveData;

import java.util.List;

import br.com.autodoc.components.data.Repositiry;
import br.com.autodoc.components.model.User;
import br.com.autodoc.components.viewModel.ListUserViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class ListUserViewModelModule {

    @Provides
    ListUserViewModel proListUserViewModel(Repositiry repositiry) {

        return new ListUserViewModel(repositiry);
    }
}
