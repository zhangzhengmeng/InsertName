package com.projectandroid.ricm4.insertname;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.projectandroid.ricm4.insertname.dummy.DummyContent;


/**
 * Created by Jérémy Zhang on 04/01/2015.
 */

public class MainActivity extends Activity {

    EditText cityname;
    EditText moviename;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        cityname = (EditText) findViewById(R.id.cityname);
        moviename = (EditText) findViewById(R.id.moviename);

        Button btnNextScreen = (Button) findViewById(R.id.citybutton);

        btnNextScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent nextScreen = new Intent(getApplicationContext(), ItemListActivity.class);
                Intent findCity = new Intent(getApplicationContext(),DummyContent.class);
                moviename = (EditText) findViewById(R.id.moviename);
                cityname = (EditText) findViewById(R.id.cityname);
                findCity.putExtra("ville", cityname.getText().toString());
                //Sending data to another Activity
                nextScreen.putExtra("film", moviename.getText().toString());
                nextScreen.putExtra("ville", cityname.getText().toString());
                Informations.setFilm(moviename.getText().toString());
                Informations.setVille(cityname.getText().toString());
                System.out.println(Informations.getFilm());
                //startActivity(findCity);
                startActivity(nextScreen);
            }
        });
    }
}
