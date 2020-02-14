package myid.supri.moviecatalogue;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListTvAdapter extends RecyclerView.Adapter<ListTvAdapter.ListViewHolder> {
    private ArrayList<TvShowParcel>listTvShow;

    public ListTvAdapter(ArrayList<TvShowParcel>list){
        this.listTvShow=list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tv_show, viewGroup, false );
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, final int position) {
        final TvShowParcel tvShowParcel= listTvShow.get(position);

        Glide.with(holder.itemView.getContext())
                .load(tvShowParcel.getPoster_tv_show())
                .apply(new RequestOptions())
                .into(holder.imgPoster);
        holder.tvName.setText(tvShowParcel.getName_tv_show());
        holder.tvOveriview.setText(tvShowParcel.getOverivew_tv_show());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(holder.itemView.getContext(),"kamu memilih" +listTvShow.get(holder.getAdapterPosition()).getName_tv_show(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(holder.itemView.getContext(),DetailTvShow.class);
                TvShowParcel tvShow = new TvShowParcel();
                tvShow.setName_tv_show(listTvShow.get(position).getName_tv_show());
                tvShow.setOverivew_tv_show(listTvShow.get(position).getOverivew_tv_show());
                tvShow.setCast_tv_show(listTvShow.get(position).getCast_tv_show());
                tvShow.setPoster_tv_show(listTvShow.get(position).getPoster_tv_show());
                intent.putExtra(DetailTvShow.EXTRA_TV,tvShow);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTvShow.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvName, tvOveriview, tvCast;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.img_item_poster);
            tvName = itemView.findViewById(R.id.tv_name_tv_show);
            tvOveriview = itemView.findViewById(R.id.tv_overiview_tv_show);
            tvCast = itemView.findViewById(R.id.txt_cast_tv_show);
        }
    }
}
