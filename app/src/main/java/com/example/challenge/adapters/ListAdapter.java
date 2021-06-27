package com.example.challenge.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.challenge.databinding.ListItemBinding;
import com.example.challenge.models.ListModel;

import org.jetbrains.annotations.NotNull;

public class ListAdapter extends androidx.recyclerview.widget.ListAdapter<ListModel, ListAdapter.ListViewHolder> {

    private ListItemClickListener listItemClickListener;

    public ListAdapter(ListItemClickListener listItemClickListener) {
        super(ListModel.itemCallback);
        this.listItemClickListener = listItemClickListener;
    }

    @NonNull
    @NotNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListItemBinding listItemBinding = ListItemBinding.inflate(layoutInflater, parent, false);
        listItemBinding.setListInterface(listItemClickListener);
        return new ListViewHolder(listItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ListViewHolder holder, int position) {
        ListModel model = getItem(position);
        holder.listItemBinding.setListEntry(model);
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        private ListItemBinding listItemBinding;

        public ListViewHolder(@NonNull @NotNull ListItemBinding listItemBinding) {
            super(listItemBinding.getRoot());
            this.listItemBinding = listItemBinding;
        }
    }

    public interface ListItemClickListener {
        void onListItemClick(ListModel model);
    }
}
