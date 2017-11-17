package br.com.autodoc.components.ui;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import br.com.autodoc.components.R;
import br.com.autodoc.components.model.User;
import butterknife.BindView;
import butterknife.ButterKnife;

public class UserHowAdapter extends RecyclerView.Adapter<UserHowAdapter.ViewHolder> {
    private List<User> list;
    private UserOnclickListener userOnclickListener;

    @Inject
    User user;

    public UserHowAdapter(List<User> list) {
        this.list = list;
    }

    public void setUserOnclickListener(UserOnclickListener userOnclickListener) {
        this.userOnclickListener = userOnclickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_user, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        user = list.get(position);
        holder.textViewUser.setText(user.getName());
        holder.textViewUser.setTag(user.getId());

        int id = (int) holder.textViewUser.getTag();

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
//                holder.checkBoxDeleteUser.setVisibility(View.VISIBLE);
//                holder.checkBoxDeleteUser.setChecked(true);
                userOnclickListener.onClickUserListener(id);

                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    interface UserOnclickListener {
        void onClickUserListener(int id);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textView)
        TextView textViewUser;

        @BindView(R.id.checkbox_delete_user)
        CheckBox checkBoxDeleteUser;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
