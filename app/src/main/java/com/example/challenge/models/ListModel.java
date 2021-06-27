package com.example.challenge.models;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ListModel {
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("owner")
    @Expose
    private OwnerModel ownerModel;

    public ListModel(long id, String name, String description, OwnerModel ownerModel) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ownerModel = ownerModel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public OwnerModel getOwnerModel() {
        return ownerModel;
    }

    public void setOwnerModel(OwnerModel ownerModel) {
        this.ownerModel = ownerModel;
    }

    @Override
    public String toString() {
        return "ListModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ownerModel=" + ownerModel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListModel listModel = (ListModel) o;
        return getId() == listModel.getId() &&
                getName().equals(listModel.getName()) &&
                getDescription().equals(listModel.getDescription()) &&
                getOwnerModel().equals(listModel.getOwnerModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getOwnerModel());
    }

    public static DiffUtil.ItemCallback<ListModel> itemCallback = new DiffUtil.ItemCallback<ListModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull @NotNull ListModel oldItem, @NonNull @NotNull ListModel newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull @NotNull ListModel oldItem, @NonNull @NotNull ListModel newItem) {
            return oldItem.equals(newItem);
        }
    };

    @BindingAdapter("android:profileImage")
    public static void loadImage(ImageView imageView, String imageUrl) {
        Glide.with(imageView)
                .load(imageUrl)
                .fitCenter()
                .into(imageView);
    }
}
