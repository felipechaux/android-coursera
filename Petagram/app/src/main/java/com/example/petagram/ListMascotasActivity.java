package com.example.petagram;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageButton;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ListMascotasActivity extends AppCompatActivity {

    private SwipeRefreshLayout sfiMyIndicator;
    private RecyclerView recyclerListMascotas;
    private ArrayList<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mascotas);

        configActionBar();

        sfiMyIndicator = findViewById(R.id.sfiMyIndicator);
        recyclerListMascotas = findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerListMascotas.setLayoutManager(llm);

        addFab();
        logicIndicator();
        initListMascotas();
        initAdapter();

    }

    private void configActionBar() {
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.myActionBar);
            setSupportActionBar(toolbar);
            ImageButton btnFavoritos = toolbar.findViewById(R.id.btnFavoritos);
            btnFavoritos.setOnClickListener(view -> startActivity(new Intent(ListMascotasActivity.this, ListMascotaFavorita.class)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mascota_menu, menu);
        return true;
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
            MascotaAdapter adapter = new MascotaAdapter(mascotas, this);
            recyclerListMascotas.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("ResourceType")
    private void logicIndicator() {
        try {
            sfiMyIndicator.setOnRefreshListener(this::refreshContent);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void refreshContent() {
        try {
            initListMascotas();
            MascotaAdapter adapter = new MascotaAdapter(mascotas, this);
            recyclerListMascotas.setAdapter(adapter);
            sfiMyIndicator.setRefreshing(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void addFab() {
        try {
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(view -> {
                Snackbar.make(view, "Foto", Snackbar.LENGTH_SHORT).show();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}