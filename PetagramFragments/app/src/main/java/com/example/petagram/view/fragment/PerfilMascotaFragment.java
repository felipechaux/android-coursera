package com.example.petagram.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagram.CircleTransform;
import com.example.petagram.R;
import com.example.petagram.adapter.MascotaAdapter;
import com.example.petagram.pojo.Mascota;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PerfilMascotaFragment extends Fragment {

    private ImageView imagePerfil;
    private RecyclerView recyclerPerfil;
    private ArrayList<Mascota> mascotaPerfil;
    private TextView textViewNombre;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view =inflater.inflate(R.layout.fragment_perfil_mascota, container, false);
        imagePerfil = view.findViewById(R.id.imagePerfilMascota);

        textViewNombre=view.findViewById(R.id.textNombreMascota);
        textViewNombre.setText(getString(R.string.name_mascota));

        recyclerPerfil=view.findViewById(R.id.rvPerfilMascota);
        GridLayoutManager llm = new GridLayoutManager(getActivity(),3);
        recyclerPerfil.setLayoutManager(llm);


        addFab(view);
        loadImageBio();
        initPerfilMascota();
        initAdapter();
        return view;
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

    public void initPerfilMascota() {
        try {
            mascotaPerfil = new ArrayList<>();
            mascotaPerfil.add(new Mascota("Fredo", "https://png.pngtree.com/png-clipart/20190411/ourlarge/pngtree-kirkys-hand-painted-elements-for-pet-dogs-png-image_924657.jpg", 5));
            mascotaPerfil.add(new Mascota("Fredo", "https://png.pngtree.com/png-clipart/20190402/ourlarge/pngtree-cute-dog-soft-furry-dog-elements-png-image_892146.jpg", 0));
            mascotaPerfil.add(new Mascota("Fredo", "https://png.pngtree.com/png-clipart/20190402/ourlarge/pngtree-cute-smile-dog-head-element-png-image_899233.jpg", 3));
            mascotaPerfil.add(new Mascota("Fredo", "https://png.pngtree.com/png-clipart/20190411/ourlarge/pngtree-yellow-kirky-dog-hand-painted-elements-png-image_932847.jpg", 10));
            mascotaPerfil.add(new Mascota("Fredo", "https://png.pngtree.com/png-vector/20190115/ourlarge/pngtree-dog-cartoon-dog-various-breeds-of-dogs-year-of-the-dog-png-image_335490.jpg", 2));
            mascotaPerfil.add(new Mascota("Fredo", "https://png.pngtree.com/png-vector/20190115/ourlarge/pngtree-dog-cartoon-dog-year-of-the-dog-2018-png-image_335500.jpg", 3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void initAdapter() {
        try {
            MascotaAdapter adapter = new MascotaAdapter(mascotaPerfil, getActivity(),true);
            recyclerPerfil.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadImageBio() {
        try {
            Picasso.get().load("https://png.pngtree.com/png-clipart/20190411/ourlarge/pngtree-kirky-dog-hand-painted-illustration-elements-png-image_924470.jpg").transform(new CircleTransform())
                    .into(imagePerfil);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}