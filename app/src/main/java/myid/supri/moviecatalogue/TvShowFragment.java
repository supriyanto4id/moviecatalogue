package myid.supri.moviecatalogue;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {

    private RecyclerView rvTvShow;
    private ArrayList<TvShowParcel> listTv= new ArrayList<>();
    public TvShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvTvShow =view.findViewById(R.id.rvTvShow);
        rvTvShow.setHasFixedSize(true);

        listTv.addAll(getListTvShow());
        showRecyclerList();



    }

    public ArrayList<TvShowParcel>getListTvShow(){
        String[] data_title= getResources().getStringArray(R.array.name_tv_show);
        String[] data_overiviview= getResources().getStringArray(R.array.tv_show_overview);
        String[] data_cast=getResources().getStringArray(R.array.tv_show_cast);
        TypedArray dataPoster = getResources().obtainTypedArray(R.array.tv_show_poster);

        ArrayList<TvShowParcel> listTvShow = new ArrayList<>();
        for (int i=0;i<data_title.length;i++){
            TvShowParcel tvShowParcel= new TvShowParcel();

            tvShowParcel.setName_tv_show(data_title[i]);
            tvShowParcel.setOverivew_tv_show(data_overiviview[i]);
            tvShowParcel.setCast_tv_show(data_cast[i]);
            tvShowParcel.setPoster_tv_show(dataPoster.getResourceId(i,-1));

            listTvShow.add(tvShowParcel);
        }
        return listTvShow;
    }

    private void showRecyclerList(){
        rvTvShow.setLayoutManager(new LinearLayoutManager(getActivity()));
        ListTvAdapter listTvAdapter = new ListTvAdapter(listTv);
        rvTvShow.setAdapter(listTvAdapter);
    }
}
