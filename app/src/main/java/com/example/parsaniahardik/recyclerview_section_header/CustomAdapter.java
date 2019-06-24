package com.example.parsaniahardik.recyclerview_section_header;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int LAYOUT_HEADER= 0;
    private static final int LAYOUT_CHILD= 1;

    private LayoutInflater inflater;
    private Context context;
    private ArrayList<MainActivity.ListItem> listItemArrayList;

    public CustomAdapter(Context context,ArrayList<MainActivity.ListItem> listItemArrayList){

        inflater = LayoutInflater.from(context);
        this.context = context;
        this.listItemArrayList = listItemArrayList;
    }

    @Override
    public int getItemCount() {
        return listItemArrayList.size();
    }

    @Override
    public int getItemViewType(int position)
    {
        if(listItemArrayList.get(position).isHeader()) {
            return LAYOUT_HEADER;
        }else
            return LAYOUT_CHILD;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder holder;
        if(viewType==LAYOUT_HEADER){
            View view = inflater.inflate(R.layout.rv_header, parent, false);
            holder = new MyViewHolderHeader(view);
        }else {
            View view = inflater.inflate(R.layout.rv_child, parent, false);
             holder = new MyViewHolderChild(view);
        }


        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if(holder.getItemViewType()== LAYOUT_HEADER)
        {
            MyViewHolderHeader vaultItemHolder = (MyViewHolderHeader) holder;
            vaultItemHolder.tvHeader.setText(listItemArrayList.get(position).getName());
        }
        else {

            MyViewHolderChild vaultItemHolder = (MyViewHolderChild) holder;
            vaultItemHolder.tvchild.setText(listItemArrayList.get(position).getName());

        }

    }


    class MyViewHolderHeader extends RecyclerView.ViewHolder{

        TextView tvHeader;

        public MyViewHolderHeader(View itemView) {
            super(itemView);

            tvHeader = (TextView) itemView.findViewById(R.id.tvHeader);
         }

    }

    class MyViewHolderChild extends RecyclerView.ViewHolder{

        TextView tvchild;

        public MyViewHolderChild(View itemView) {
            super(itemView);

            tvchild = (TextView) itemView.findViewById(R.id.tvChild);
        }

    }

}
