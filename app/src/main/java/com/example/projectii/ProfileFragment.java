package com.example.projectii;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {
    ImageSlider imageSlider;

    Toolbar toolbar;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile,container,false);


        imageSlider =view.findViewById(R.id.imageSlider);


        List<SlideModel> slides= new ArrayList<>();

        slides.add(new SlideModel(R.drawable.mixblue,"Qachi"));
        slides.add(new SlideModel(R.drawable.whiteslide,"Kachi"));
        slides.add(new SlideModel(R.drawable.mixgreen,"Afone"));
        slides.add(new SlideModel(R.drawable.black,"Ejike"));

        imageSlider.setImageList(slides,false);


        toolbar =view.findViewById(R.id.toolbar);
        toolbar =view.findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.toolbar_menu);
        toolbar.setTitle("Qachi");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.holo_orange_dark));
        toolbar.setLogo(R.drawable.ic_notifications_black_24dp);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.about_Us) {
                    Toast.makeText(getActivity(), "About Us Clicked", Toast.LENGTH_SHORT).show();

                } else if (item.getItemId() == R.id.transactions) {
                    Toast.makeText(getActivity(), "Transactions Clicked", Toast.LENGTH_SHORT).show();                }

                return true;
            }

        });

        return  view;
    }

}
