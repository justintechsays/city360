package com.msg91.sendotp.sample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Chequeadapter extends RecyclerView.Adapter<Chequeadapter.ProductViewHolder> {

    private Context mCtx;
    private List<Cheque> productList;

    public Chequeadapter(Context mCtx, List<Cheque> productList) {

        this.mCtx = mCtx;
        this.productList = productList;
// sh=mCtx.getSharedPreferences("Official1",MODE_PRIVATE);
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.recycler, null);
        return new ProductViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
        final Cheque cheque = productList.get(position);


        //Picasso.get().load(cheque.getStatus()).into(holder.imageView);
        holder.name.setText(cheque.getName());
        holder.job.setText(cheque.getWork());
        holder.phonenum.setText(cheque.getPhone());
        holder.address.setText(cheque.getAddress());
    }


    @Override
    public int getItemCount() {
        return productList.size();
    }



    class ProductViewHolder extends RecyclerView.ViewHolder {



//        ImageView imageView;
        TextView name,job,phonenum,address;
        Button btn;


        public ProductViewHolder(View itemView) {
            super(itemView);

//            imageView=itemView.findViewById(R.id.imageView);
            name=itemView.findViewById(R.id. nameemp);
            job= itemView.findViewById(R.id.empwork);
            phonenum=itemView.findViewById(R.id.empphone);
            address=itemView.findViewById(R.id.empaddress);


        }


    }

    public void filterList(ArrayList<Cheque> filteredList) {
        productList = filteredList;
        notifyDataSetChanged();
    }

}
