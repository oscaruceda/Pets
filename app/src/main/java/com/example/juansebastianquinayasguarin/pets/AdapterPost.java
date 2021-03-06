package com.example.juansebastianquinayasguarin.pets;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by juansebastianquinayasguarin on 5/4/18.
 */

public class AdapterPost implements ListAdapter {

    private Context context;
    private ArrayList<Post> listaPost = new ArrayList<>();
    private TextView tv_titulo, tv_desc;
    private ImageView imagen, imginfo;


    public AdapterPost() {
    }

    public AdapterPost(Context context, ArrayList<Post> listaPost) {
        this.context = context;
        this.listaPost = listaPost;
    }

    public TextView getTv_titulo() {
        return tv_titulo;
    }

    public void setTv_titulo(TextView tv_titulo) {
        this.tv_titulo = tv_titulo;
    }

    public TextView getTv_desc() {
        return tv_desc;
    }

    public void setTv_desc(TextView tv_desc) {
        this.tv_desc = tv_desc;
    }

    public ImageView getImagen() {
        return imagen;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return listaPost.size();
    }

    @Override
    public Object getItem(int position) {
        return listaPost.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View modeloVistaPost = inflater.inflate(R.layout.list_view_post, parent, false);
        imagen = modeloVistaPost.findViewById(R.id.img_list_view_post);
        tv_titulo = (TextView) modeloVistaPost.findViewById(R.id.tv_list_view_titulo);
        tv_desc = (TextView) modeloVistaPost.findViewById(R.id.tv_list_view_desc);
        imagen = (ImageView) modeloVistaPost.findViewById(R.id.img_list_view_post);
        imginfo = (ImageView) modeloVistaPost.findViewById(R.id.img_list_view_post_info);
        tv_titulo.setText(listaPost.get(position).getTitulo());
        tv_desc.setText(listaPost.get(position).getDescripcion());
        //TOCAR PARA COGER IMG DEL DATABASE
        return modeloVistaPost;
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return listaPost.isEmpty();
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }
}
