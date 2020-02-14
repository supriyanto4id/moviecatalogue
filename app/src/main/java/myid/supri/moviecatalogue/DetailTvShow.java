package myid.supri.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailTvShow extends AppCompatActivity {
    public static final String EXTRA_TV = "extra_tv";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);

        TextView tvTitleTvShow=findViewById(R.id.txt_title_tv_show);
        TextView tvOveriview =findViewById(R.id.txt_overiview_tv_show);
        TextView tvCast= findViewById(R.id.txt_cast_tv_show);
        ImageView imgPoster =findViewById(R.id.img_poster_tv_show);

        TvShowParcel tvShowParcel =getIntent().getParcelableExtra(EXTRA_TV);

        String text_name = tvShowParcel.getName_tv_show();
        String text_overiview= tvShowParcel.getOverivew_tv_show();
        String text_cast = tvShowParcel.getCast_tv_show();
        int img_poster = tvShowParcel.getPoster_tv_show();

        tvTitleTvShow.setText(text_name);
        tvOveriview.setText(text_overiview);
        tvCast.setText(text_cast);
        imgPoster.setImageResource(img_poster);

    }



}
