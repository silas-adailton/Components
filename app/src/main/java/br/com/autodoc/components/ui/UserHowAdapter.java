package br.com.autodoc.components.ui;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.autodoc.components.R;
import br.com.autodoc.components.model.User;
import butterknife.BindView;
import butterknife.ButterKnife;

public class UserHowAdapter extends RecyclerView.Adapter<UserHowAdapter.ViewHolder>{
    private List<User> list;

    public UserHowAdapter(List<User> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_user, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = list.get(position);

        holder.textViewUser.setText(user.getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textView)
        TextView textViewUser;
        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
