package myid.supri.moviecatalogue;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.ListViewHolder>  {

    private ArrayList<MovieParcel> listMovie;



    public ListMovieAdapter(ArrayList<MovieParcel> list){
        this.listMovie = list;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_film, viewGroup, false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, final int position) {
        final MovieParcel movieParcel=listMovie.get(position);
        Glide.with(holder.itemView.getContext())
                .load(movieParcel.getPoster())
                .apply(new RequestOptions())
                .into(holder.imgPoster);


        holder.tvName.setText(movieParcel.getName());
        holder.tvDescription.setText(movieParcel.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              // onItemClickCallback.onItemClicked(listMovie.get(holder.getAdapterPosition()));

                //Toast.makeText(holder.itemView.getContext(),"kamu memilih "+ listMovie.get(holder.getAdapterPosition()).getName(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(holder.itemView.getContext(),DetailMovie.class);

                MovieParcel mv = new MovieParcel();
                mv.setName(listMovie.get(position).getName());
                mv.setDescription(listMovie.get(position).getDescription());
                mv.setPoster(listMovie.get(position).getPoster());
                mv.setCast(listMovie.get(position).getCast());
                intent.putExtra(DetailMovie.EXTRA_MOVIE,mv);
                holder.itemView.getContext().startActivity(intent);


            }
        });

    }



    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPoster;
        TextView tvName, tvDescription, tvCast;

        ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.img_photo);
            tvName =itemView.findViewById(R.id.txt_name);
            tvCast = itemView.findViewById(R.id.txt_cast);
            tvDescription =itemView.findViewById(R.id.txt_description);
        }
    }
}
