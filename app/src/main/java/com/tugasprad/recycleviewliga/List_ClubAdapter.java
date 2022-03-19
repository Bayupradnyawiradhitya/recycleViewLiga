package com.tugasprad.recycleviewliga;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class List_ClubAdapter extends RecyclerView.Adapter<List_ClubAdapter.ListViewHolder> {
    private ArrayList<Club> listClub;

    public List_ClubAdapter(ArrayList<Club> list){
        this.listClub = list;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_club,parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Club club = listClub.get(position);
        Glide.with(holder.itemView.getContext())
                .load(club.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);
        holder.tvName.setText(club.getName());
        holder.tvDeskripsi.setText(club.getDeskripsi());

    }

    @Override
    public int getItemCount() {
        return listClub.size();
    }


    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName;
        TextView tvDeskripsi;

        ListViewHolder(View itemview) {
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.img_item_club);
            tvName = itemview.findViewById(R.id.tv_item_name);
            tvDeskripsi = itemview.findViewById(R.id.tv_deskripsi);


        }
    }
}
