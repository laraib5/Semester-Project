package com.example.mrappointa;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> implements Filterable {
    private static  final  String TAG ="RecyclerAdapter";
    int count =0;
    List<String> doctorsList;
    List<String> doctorsListAll;
    List<String> description;
    private RecyclerViewClickListener listener;

    public  RecyclerAdapter(List<String> doctorsList,List<String> description, RecyclerViewClickListener listener){
        this.doctorsList=doctorsList;
        this.doctorsListAll=new ArrayList<>(doctorsList);
        this.description=description;
        this.listener=listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        Log.i(TAG, "onCreateViewHolder: "+ count++);
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.row_item, parent, false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void  onBindViewHolder(@NonNull ViewHolder holder, int position){
        //holder.rowCountTextView.setText(String.valueOf(position));
        holder.textView.setText(doctorsList.get(position));
        holder.rowCountTextView.setText(description.get(position));
    }

    @Override
    public int getItemCount(){
        return doctorsList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<String> filteredList=new ArrayList<>();
            if(charSequence.toString().isEmpty()){
                filteredList.addAll(doctorsListAll);
            }else {
                for (String doctor:doctorsListAll){
                    if (doctor.toLowerCase().contains(charSequence.toString().toLowerCase())){
                        filteredList.add(doctor);
                    }
                }
            }
            FilterResults filterResults=new FilterResults();
            filterResults.values=filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            doctorsList.clear();
            doctorsList.addAll((Collection<? extends  String>) filterResults.values);
            notifyDataSetChanged();
        }
    };

    public interface RecyclerViewClickListener{
        void  onClick(View v, int position);

    }

    class ViewHolder extends  RecyclerView.ViewHolder implements  View.OnClickListener{
        ImageView imageView;
        TextView textView, rowCountTextView;

        public  ViewHolder(@NonNull View itemView){
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.textView);
            rowCountTextView=itemView.findViewById(R.id.rowCountTextView);

            itemView.setOnClickListener(this);
        }

        @Override
        public  void  onClick(View view){
            listener.onClick(itemView, getAdapterPosition());

            Toast.makeText(view.getContext(), doctorsList.get(getAdapterPosition()), Toast.LENGTH_SHORT).show();
        }
    }
}


