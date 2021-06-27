package com.example.challenge.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.challenge.R;
import com.example.challenge.adapters.ListAdapter;
import com.example.challenge.databinding.FragmentListBinding;
import com.example.challenge.models.ListModel;
import com.example.challenge.viewmodels.ListViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment implements ListAdapter.ListItemClickListener {

    private static final String TAG = "ListFragment";

    private FragmentListBinding fragmentListBinding;
    private ListAdapter listAdapter;
    private ListViewModel listViewModel;

    public ListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_list, container, false);
        fragmentListBinding = FragmentListBinding.inflate(inflater, container, false);
        return fragmentListBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listAdapter = new ListAdapter(this);
        fragmentListBinding.recyclerView.setAdapter(listAdapter);
        fragmentListBinding.recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        fragmentListBinding.recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL));

        listViewModel = new ViewModelProvider(requireActivity()).get(ListViewModel.class);
        listViewModel.fetchRepositoryList().observe(getViewLifecycleOwner(), new Observer<List<ListModel>>() {
            @Override
            public void onChanged(List<ListModel> listModels) {
                listAdapter.submitList(listModels);
            }
        });
    }

    @Override
    public void onListItemClick(ListModel model) {
        Toast.makeText(requireActivity(), model.getName() + " " + "Clicked !", Toast.LENGTH_SHORT).show();
    }
}