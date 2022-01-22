package com.example.hometaskandroid_03_05;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hometaskandroid_03_05.continents.Africa;
import com.example.hometaskandroid_03_05.continents.Asia;
import com.example.hometaskandroid_03_05.continents.Australia;
import com.example.hometaskandroid_03_05.continents.Europe;
import com.example.hometaskandroid_03_05.continents.NorthAmerica;
import com.example.hometaskandroid_03_05.continents.SouthAmerica;
import com.example.hometaskandroid_03_05.world.World;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment implements OnClick{
    private RecyclerView recyclerView;
    private Adaptor adaptor;
    public static List<World> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        recyclerView=view.findViewById(R.id.recycler);
        adaptor=new Adaptor(list, this);
        recyclerView.setAdapter(adaptor);
    }

    private void loadData() {
        list = new ArrayList<>();
        list.add(new World("Africa", R.drawable.ic_africa));
        list.add(new World("Asia", R.drawable.ic_asia));
        list.add(new World("Australia", R.drawable.ic_australia));
        list.add(new World("Europe", R.drawable.ic_europe));
        list.add(new World("North America", R.drawable.ic_north_america));
        list.add(new World("South America", R.drawable.ic_south_america));
    }


    @Override
    public void onClick(World world) {
        Toast.makeText(requireActivity(), "Hlick "+world.getName(),
                Toast.LENGTH_SHORT).show();
        switch (world.getName()){
            case "Africa":
                list=new ArrayList<>();
                list.add(new Africa("Нигерия", R.drawable.ic_nigeria));
                list.add(new Africa("Южная африка", R.drawable.ic_south_africa));
                list.add(new Africa("Египет", R.drawable.ic_egypt));
                list.add(new Africa("Алжир", R.drawable.ic_algeria));
                list.add(new Africa("Ангола", R.drawable.ic_angola));
                sendData();
                break;
            case "Asia":
                list=new ArrayList<>();
                list.add(new Asia("Кыргызстан", R.drawable.ic_kg));
                list.add(new Asia("Казакстан", R.drawable.ic_kazakstan));
                list.add(new Asia("Россия", R.drawable.ic_ru_3x));
                list.add(new Asia("Кытай", R.drawable.ic_cn));
                list.add(new Asia("Туркменстан", R.drawable.ic_tm_3x));
                sendData();
                break;
            case "Australia":
                list=new ArrayList<>();
                list.add(new Australia("Австралия", R.drawable.ic_au_3x));
                list.add(new Australia("Фиджи", R.drawable.ic_fj_3x));
                list.add(new Australia("Папуа Новая Гвинея", R.drawable.ic_pg_3x));
                list.add(new Australia("Вануату", R.drawable.ic_vu_3x));
                list.add(new Australia("Новая Зеландия", R.drawable.ic_nz_3x));
                sendData();
                break;
            case "Europe":
                list=new ArrayList<>();
                list.add(new Europe("Англия", R.drawable.ic_gb_3x));
                list.add(new Europe("Германия", R.drawable.ic_de_3x));
                list.add(new Europe("Италия", R.drawable.ic_it_3x));
                list.add(new Europe("Франция", R.drawable.ic_fr_3x));
                list.add(new Europe("Турция", R.drawable.ic_tr_3x));
                sendData();
                break;
            case "North America":
                list=new ArrayList<>();
                list.add(new NorthAmerica("Канада", R.drawable.ic_ca_3x));
                list.add(new NorthAmerica("Куба", R.drawable.ic_cu_3x));
                list.add(new NorthAmerica("США", R.drawable.ic_us_3x));
                list.add(new NorthAmerica("Мексика", R.drawable.ic_mx_3x));
                list.add(new NorthAmerica("Тринидат и Табако", R.drawable.ic_tt_3x));
                sendData();
                break;
            case "South America":
                list=new ArrayList<>();
                list.add(new SouthAmerica("Бразилия", R.drawable.ic_br_3x));
                list.add(new SouthAmerica("Чили", R.drawable.ic_cl_3x));
                list.add(new SouthAmerica("Венесуела", R.drawable.ic_ve_3x));
                list.add(new SouthAmerica("Аргентина", R.drawable.ic_ar_3x));
                list.add(new SouthAmerica("Боливия", R.drawable.ic_bo_3x));
                sendData();
                break;
        }
    }

    private void sendData() {
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new CountriesFragment()).commit();
    }
}