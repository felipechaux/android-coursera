package com.example.petagram;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.petagram.adapter.MascotaAdapter;
import com.example.petagram.pojo.Mascota;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


public class ListMascotasFragment extends Fragment {
    private RecyclerView recyclerListMascotas;
    private ArrayList<Mascota> mascotas;
    private SwipeRefreshLayout sfiMyIndicator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list_mascotas, container, false);
        sfiMyIndicator = v.findViewById(R.id.sfiMyIndicator);
        recyclerListMascotas = v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerListMascotas.setLayoutManager(llm);

        addFab(v);
        initListMascotas();
        initAdapter();
        logicIndicator();
        return v;
    }

    @SuppressLint("ResourceType")
    private void logicIndicator() {
        try {
            sfiMyIndicator.setOnRefreshListener(this::refreshContent);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void initListMascotas() {
        try {
            mascotas = new ArrayList<>();
            mascotas.add(new Mascota("Fredo", "https://png.pngtree.com/png-clipart/20190411/ourlarge/pngtree-kirky-dog-hand-painted-illustration-elements-png-image_924470.jpg", 3));
            mascotas.add(new Mascota("Rami", "https://png.pngtree.com/png-clipart/20190408/ourlarge/pngtree-hand-painted-elements-of-crouching-wolf-and-dog-png-image_926556.jpg", 2));
            mascotas.add(new Mascota("Feli", "https://png.pngtree.com/element_origin_min_pic/00/03/16/075688f7c3a6be5.jpg", 2));
            mascotas.add(new Mascota("Pelusa", "https://png.pngtree.com/png-clipart/20190411/ourlarge/pngtree-kirkys-hand-painted-elements-for-pet-dogs-png-image_924657.jpg", 5));
            mascotas.add(new Mascota("Max", "https://png.pngtree.com/element_origin_min_pic/17/07/21/103c21b14dba749cb1aee8bb17e18185.jpg", 5));
            mascotas.add(new Mascota("BlackMens", "https://png.pngtree.com/png-clipart/20210119/ourlarge/pngtree-png-dog-image-png-image_2763385.jpg", 5));
            mascotas.add(new Mascota("Navideño", "https://png.pngtree.com/png-vector/20201028/ourlarge/pngtree-golden-retriever-dog-wearing-a-santa-hat-for-christmas-vector-illustration-png-image_2381030.jpg", 5));
            mascotas.add(new Mascota("BlackMens", "https://png.pngtree.com/png-vector/20200205/ourlarge/pngtree-adorable-puppy-dog-cute-with-ribbon-watercolor-illustration-png-image_2141717.jpg", 5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initAdapter() {
        try {
            MascotaAdapter adapter = new MascotaAdapter(mascotas, getActivity(),false);
            recyclerListMascotas.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addFab(View v) {
        try {
            FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
            fab.setOnClickListener(view -> {
                Snackbar.make(view, "Foto", Snackbar.LENGTH_SHORT).show();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refreshContent() {
        try {
            initListMascotas();
            MascotaAdapter adapter = new MascotaAdapter(mascotas, getActivity(),false);
            recyclerListMascotas.setAdapter(adapter);
            sfiMyIndicator.setRefreshing(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}