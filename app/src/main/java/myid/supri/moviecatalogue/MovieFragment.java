package myid.supri.moviecatalogue;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment  {

    private RecyclerView rvMovie;
    private ArrayList<MovieParcel>list= new ArrayList<>();

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        rvMovie = view.findViewById(R.id.rv_movie);
        rvMovie.setHasFixedSize(true);

        list.addAll(getListMovie());
        showRecyclerList();



    }

    public ArrayList<MovieParcel> getListMovie() {
        String[] dataName = getResources().getStringArray(R.array.name_movie);
        String[] dataDescription = getResources().getStringArray(R.array.data_overview);
        String[] dataCast = getResources().getStringArray(R.array.cast);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.poster_photo);

        ArrayList<MovieParcel> listMovie = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            MovieParcel movie= new MovieParcel();
            movie.setName(dataName[i]);
            movie.setDescription(dataDescription[i]);
            movie.setCast(dataCast[i]);
            movie.setPoster(dataPhoto.getResourceId(i,-1));

            listMovie.add(movie);
        }
        return listMovie;

    }



    private void showRecyclerList(){
        rvMovie.setLayoutManager(new LinearLayoutManager(getActivity()));
        final ListMovieAdapter listMovieAdapter = new ListMovieAdapter(list);
        rvMovie.setAdapter(listMovieAdapter);
    }

}
