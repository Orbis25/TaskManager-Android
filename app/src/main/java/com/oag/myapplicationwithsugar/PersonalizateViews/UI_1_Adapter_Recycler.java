package com.oag.myapplicationwithsugar.PersonalizateViews;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.oag.myapplicationwithsugar.R;
import com.oag.myapplicationwithsugar.ViewModel.UI_1_RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UI_1_Adapter_Recycler
        extends RecyclerView.Adapter<UI_1_Adapter_Recycler.ViewHolderDatos>
        implements View.OnClickListener{

    ArrayList<UI_1_RecyclerView> listData;

    private View.OnClickListener listener;

    public UI_1_Adapter_Recycler(ArrayList<UI_1_RecyclerView> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override //enlaza el itemlist.xml
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list, null , false);

        view.setOnClickListener(this); //escucha el evento de seleccion

        return new ViewHolderDatos(view );
    }

    @Override //establece la comunicacion entre el adaptador y el viewholder
    public void onBindViewHolder(@NonNull ViewHolderDatos viewHolderDator, int i) {
        viewHolderDator.Title.setText(listData.get(i).getTitle());
        viewHolderDator.Description.setText(listData.get(i).getDescription());
        viewHolderDator.Pic.setImageResource(listData.get(i).getPic());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }


    //pasamos un listener
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(this.listener != null){
            //le pasamos el evento
            listener.onClick(v);
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        //colocar referencia a la vista que implementara el reciclerview
        TextView Title;
        TextView Description;
        ImageView Pic;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            //aqui llamamos la referencia
            Title = itemView.findViewById(R.id.model_recicler);
            Description = itemView.findViewById(R.id.model_reciclerDes);
            Pic = itemView.findViewById(R.id.img_rc);

        }

    }
}
