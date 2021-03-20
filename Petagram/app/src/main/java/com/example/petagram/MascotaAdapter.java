package com.example.petagram;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdapter(ArrayList<Mascota> contacts, Activity activity) {
        this.mascotas = contacts;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item_list_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        try {
            Mascota mascota = mascotas.get(position);
            mascotaViewHolder.tvNombreMascota.setText(mascota.getNombre());
            mascotaViewHolder.tvHuesitos.setText(String.valueOf(mascota.getHuesitos()));
            mascotaViewHolder.btnHueso.setOnClickListener(view ->
                    like(mascota)
            );
            getImagenUrl(mascotaViewHolder.imgMascota, mascota.getUrlImage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void like(Mascota mascota){
        try {
            int incremento =mascota.getHuesitos();
            incremento++;
            mascota.setHuesitos(incremento);
            notifyDataSetChanged();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    private void getImagenUrl(ImageView image, String url) {
        try {
            Picasso.get().load(url).into(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMascota;
        private ImageButton btnHueso;
        private TextView tvNombreMascota;
        private TextView tvHuesitos;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            btnHueso = itemView.findViewById(R.id.btnHueso);
            tvNombreMascota = itemView.findViewById(R.id.textNombreMascota);
            tvHuesitos = itemView.findViewById(R.id.textHuesitos);
            imgMascota = itemView.findViewById(R.id.imgMascota);
        }
    }
}
