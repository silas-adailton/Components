package br.com.autodoc.components.ui;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
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

        if (userOnclickListener != null) {
            holder.itemView.setOnClickListener(view -> {
                user.setSelected(false);
                int corFundo = holder.itemView.getContext().getResources().getColor(R.color.text);
//                            holder.itemView.getContext().getResources().getColor(
//                            user.isSelected() ? R.color.primary : R.color.text);

                holder.textViewUser.setBackgroundColor(corFundo);
                userOnclickListener.onClickUser(view, list, id);
            });
        }

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                user.setSelected(true);
                Toast.makeText(holder.itemView.getContext(), "Click longo", Toast.LENGTH_SHORT).show();
//                holder.checkBoxDeleteUser.setVisibility(View.VISIBLE);
//                holder.checkBoxDeleteUser.setChecked(true);

                List<User> userSelected = new ArrayList<>();

                for (int i =0; i< list.size(); i++){
                    if (user.isSelected()) {
                        userSelected.add(user);
                    }
                }

                userOnclickListener.onClickUserListener(holder.itemView, userSelected, id);

                if (user.isSelected()) {
                    int corFundo =  holder.itemView.getContext().getResources().getColor(
                            user.isSelected() ? R.color.primary : R.color.text);
                            //holder.itemView.getContext().getResources().getColor(R.color.separator);
//

                    holder.textViewUser.setBackgroundColor(corFundo);
                }

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    interface UserOnclickListener {
        void onClickUserListener(View view, List<User>list, int id);
        void onClickUser(View view, List<User>list, int id);
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
