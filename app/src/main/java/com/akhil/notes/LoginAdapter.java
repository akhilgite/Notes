package com.akhil.notes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class LoginAdapter extends RecyclerView.Adapter<LoginAdapter.ItemHolder> {

    ArrayList<User> users;

    public LoginAdapter(ArrayList<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_login,viewGroup,false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int i) {
        User user = users.get(i);
        itemHolder.tvUsername.setText(user.getUsername());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class ItemHolder extends RecyclerView.ViewHolder{

        TextView tvUsername;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            tvUsername = itemView.findViewById(R.id.tv_username);
        }
    }
}
