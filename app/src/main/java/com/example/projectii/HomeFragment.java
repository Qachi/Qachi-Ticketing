package com.example.projectii;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
 CardView tickets;
 CardView expolre;
    ImageSlider imageSlider;

    Toolbar toolbar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);


        imageSlider = view.findViewById(R.id.imageSlider);

        List<SlideModel> slides = new ArrayList<>();

        slides.add(new SlideModel(R.drawable.whiteslide,"Qachi"));
        slides.add(new SlideModel(R.drawable.mixgreen,"Kachi"));
        slides.add(new SlideModel(R.drawable.mixblack,"Afone"));
        slides.add(new SlideModel(R.drawable.mixblue,"Ejike"));

        imageSlider.setImageList(slides, false);

        tickets = view.findViewById(R.id.tickets);
        expolre = view.findViewById(R.id.explore);

        toolbar = view.findViewById(R.id.toolbar);
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
                    Toast.makeText(getActivity(), "Transactions Clicked", Toast.LENGTH_SHORT).show();
                }

                return true;

            }


        });

        View.OnClickListener cardView = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = v.getId();

                switch (id){

                    case R.id.tickets :
                        Toast.makeText(getActivity(), "Tickets Clicked", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.explore :
                        Toast.makeText(getActivity(), "Explore Clicked", Toast.LENGTH_SHORT).show();
                }
            }

        };
        tickets.setOnClickListener(cardView);
        expolre.setOnClickListener(cardView);

        return view;

    }
}
