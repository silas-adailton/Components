package br.com.autodoc.components.viewModel;


import java.util.List;

import br.com.autodoc.components.model.UserFirebase;

public interface ViewModelFirebaseContract {

    interface View {
        void showUserFirebase(List<UserFirebase> list);

    }
}
