package myid.supri.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMovie extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);


        TextView tv_name= findViewById(R.id.txt_name);
        TextView tv_description = findViewById(R.id.txt_description);
        TextView tv_cast = findViewById(R.id.txt_cast);
        ImageView img = findViewById(R.id.img_poster);

        MovieParcel mv =getIntent().getParcelableExtra(EXTRA_MOVIE);

        String text_name = mv.getName();
        String text_description = mv.getDescription();
        String text_cast = mv.getCast();
        int img_poster = mv.getPoster();


        tv_name.setText(text_name);
        tv_description.setText(text_description);
        tv_cast.setText(text_cast);
        img.setImageResource(img_poster);
    }
}
