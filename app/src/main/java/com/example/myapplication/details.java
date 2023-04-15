package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONObject;

import java.util.Random;

public class details extends AppCompatActivity {
    public String value;
    public String name;
    private RecyclerView.Adapter adapter;
    public String  url_data;
    public String  url_stats;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_details);
        Bundle extras = getIntent().getExtras();


        ImageButton button = (ImageButton) findViewById(R.id.goBack);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        if (extras != null) {
            value = extras.getString("id");
            name = extras.getString("name");
            url_data = "https://pokeapi.co/api/v2/pokemon/" + value;
            url_stats = "https://pokeapi.co/api/v2/stat/" + value;

            ImageView img = (ImageView) findViewById(R.id.charachterImg);
            Glide
                    .with(getBaseContext())
                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + value + ".png")
                    .fitCenter()
                    .placeholder(new ColorDrawable(Color.TRANSPARENT))
                    .into(img);
            TextView cn = findViewById(R.id.charachterName);
            cn.setText(name);

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url_data, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                TextView height = findViewById(R.id.Height);
                                TextView weight = findViewById(R.id.Weight);

                                String heightValue = response.getString("height");
                                height.setText(heightValue + "M");

                                String weightValue = response.getString("weight");
                                weight.setText(weightValue + "KG");

                                ProgressBar hp = findViewById(R.id.progress_hp);
                                ProgressBar atk = findViewById(R.id.progress_ATK);
                                ProgressBar def = findViewById(R.id.progress_DEF);
                                ProgressBar spd = findViewById(R.id.progress_SPD);
                                ProgressBar exp = findViewById(R.id.progress_EXP);

                                hp.setProgress(new Random().nextInt(100));
                                atk.setProgress(new Random().nextInt(100));
                                def.setProgress(new Random().nextInt(100));
                                spd.setProgress(new Random().nextInt(100));
                                exp.setProgress(new Random().nextInt(100));

                                TextView num = findViewById(R.id.Number);
                                num.setText("#"+value);

                            } catch (Exception e) {

                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            Volley.newRequestQueue(this).add(request);
        }

    }
}
