package com.example.firsttp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ListEtdAdapter extends BaseAdapter {
    List<HashMap<String, Object>> eltsEtdListe;
    Context context;
    LayoutInflater layoutInf;

    public ListEtdAdapter(List<HashMap<String, Object>> eltsEtdListe, Context context) {
        this.eltsEtdListe = eltsEtdListe;
        this.context = context;
        this.layoutInf = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return this.eltsEtdListe.size();
    }

    @Override
    public Object getItem(int position) {
        return this.eltsEtdListe.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        TextView tn, tp, tt;
        ImageView imageView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInf.inflate(R.layout.structetdelt, null);
            holder = new ViewHolder();
            holder.tn = convertView.findViewById(R.id.txtN);
            holder.tp = convertView.findViewById(R.id.txtP);
            holder.tt = convertView.findViewById(R.id.txtT);
            holder.imageView = convertView.findViewById(R.id.imgStudent);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tn.setText(eltsEtdListe.get(position).get("nom").toString());
        holder.tp.setText(eltsEtdListe.get(position).get("prenom").toString());
        holder.tt.setText(eltsEtdListe.get(position).get("tel").toString());

        // Set sample image or from list if available
        if (eltsEtdListe.get(position).containsKey("image")) {
            holder.imageView.setImageResource((int) eltsEtdListe.get(position).get("image"));
        } else {
            holder.imageView.setImageResource(R.drawable.ic_launcher_foreground);
        }
        return convertView;
    }
}
