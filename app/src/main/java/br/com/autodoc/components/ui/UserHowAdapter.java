package br.com.autodoc.components.ui;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import br.com.autodoc.components.R;
import br.com.autodoc.components.model.User;
import butterknife.BindView;
import butterknife.ButterKnife;

public class UserHowAdapter extends RecyclerView.Adapter<UserHowAdapter.ViewHolder> {
    private List<User> list;
    private ClickCallback clickCallback;

    @Inject
    User user;

    public UserHowAdapter(List<User> list) {
        this.list = list;
    }

    public void setClickCallback(ClickCallback clickCallback) {
        this.clickCallback = clickCallback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_user, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        user = list.get(holder.getAdapterPosition());
        User user = list.get(holder.getAdapterPosition());
        holder.textViewUser.setText(user.getName());
        holder.textViewUser.setTag(user.getId());

        if (clickCallback != null) {
            holder.itemView.setOnClickListener(view -> {
                holder.textViewUser.setBackgroundColor(holder.itemView.getContext().getResources().getColor(R.color.colorTeste));
            });
        }

        holder.itemView.setOnLongClickListener(view -> {
            clickCallback.clickCalback(user);

                holder.textViewUser.setBackgroundColor(holder.itemView.getResources().getColor(R.color.primary));

            return true;
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    interface ClickCallback {
        void clickCalback(User user);
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
