package com.dream.kotlinvsjava;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Movie movie1 = new Movie();

        System.out.println("Movie 1 : " + movie1);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2012, 3, 25);

        Movie movie2 = new Movie(2, "Avengers", calendar.getTime());

        System.out.println("Movie 2 : " + movie2);

        Movie movie3 = new Movie();
        movie3.setId(3);
        movie3.setName("Avengers");
        movie3.setReleaseDate(calendar.getTime());

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);

        for (Movie movie: movies) {
            System.out.println("Movie : " + movie);
        }

        int sumOfIds = 0;

        for (Movie movie: movies) {
            sumOfIds += movie.getId();
        }
        System.out.println("sumOfIds : " + sumOfIds);

        System.out.println("getMovieByName : " + getMovieByName(movies, "Avengers").getName());

       // System.out.println("getMovieByName : " + getMovieByName(movies, "Black Panther").getName());

        popup();

        actionButton();

        textWatcher();

    }

    private int getSumOfIds(ArrayList<Movie> movies) {
        int sumOfIds = 0;
        for (Movie movie: movies) {
            sumOfIds += movie.getId();
        }
        return sumOfIds;
    }

    private Movie getMovieByName(ArrayList<Movie> movies, String name) {
        Movie movieToReturn = null;
        for (Movie movie: movies) {
            if (movie.getName() == name) {
                movieToReturn = movie;
            }
        }
        return movieToReturn;
    }

    private String getMonthName(int month){
        String monthName;
        switch (month){
            case 1:
                monthName = "Janvier";
                break;
            case 2:
                monthName = "Février";
                break;
            case 3:
                monthName = "Mars";
                break;
            case 4:
                monthName = "Avril";
                break;
            case 5:
                monthName = "Mai";
                break;
            case 6:
                monthName = "Juin";
                break;
            case 7:
                monthName = "Juillet";
                break;
            case 8:
                monthName = "Aout";
                break;
            case 9:
                monthName = "Septembre";
                break;
            case 10:
                monthName = "Octobre";
                break;
            case 11:
                monthName = "Novembre";
                break;
            case 12:
                monthName = "Décembre";
                break;
            default:
                monthName = "Erreur";
                break;
        }
        return monthName;
    }

    private void popup() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Supprimer");
        builder.setMessage("Confirmez vous la suppression?");
        builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //delete something
            }
        });
        builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void actionButton() {
        Button actionButton = findViewById(R.id.actionButton);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchNextActivity();
            }
        });
    }

    private void launchNextActivity() {
        Intent intent = new Intent(MainActivity.this, ActivityDetail.class);
        intent.putExtra("id", 1);
        startActivity(intent);
    }

    String name = "";

    private void textWatcher() {
        EditText nameEditText = findViewById(R.id.nameEditText);
        nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                name = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}