package com.example.hometaskandroid_03_05;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hometaskandroid_03_05.world.World;
import com.google.gson.Gson;

import java.util.ArrayList;

public class CountriesFragment extends Fragment implements OnClick{
    private RecyclerView recyclerViewCountries;
    private Adaptor adaptorCountries;
    private ArrayList<World> list= (ArrayList<World>) MainFragment.list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_countries, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MainActivity.isCountriesFragment=false;
        recyclerViewCountries=view.findViewById(R.id.recycler_countries);
        adaptorCountries=new Adaptor(list, this);
        try {
            recyclerViewCountries.setAdapter(adaptorCountries);
        } catch (Exception e) {
            System.out.println("figushki");
        }
    }

    @Override
    public void onClick(World world) {

    }
}