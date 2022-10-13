package isabelcalzadilla.ioc.recyclerviewlab;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import isabelcalzadilla.ioc.recyclerviewlab.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // LAB SECTION

    // LISTA INICIAL DE PERSONAJES
    private List<String> lista = Arrays.asList("Superman", "Batman", "WonderWoman", "Aquaman", "Hulk", "Doctor Dooom", "SpiderMan", "Thor", "Joker", "Captain America", "Lex Luthor", "Wolverine", "Iron Man", "Flash", "HellBoy", "DeadPool", "Storm", "Punisher", "CatWoman", "Two Faces");
    private LinkedList <String> mWordList = new LinkedList<>();
    private RecyclerView recicler;
    private WordListAdapter adapter;
    private FloatingActionButton floater;
    private FloatingActionButton reset;
    // DEFAULT ELEMENTS
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        // ADICIÓN DEL BLOQUE DE CÓDIGO DEL CODELAB (LINKEDLIST SECTION)

        mWordList.addAll(lista);

        recicler = findViewById(R.id.reciclerView);
        adapter = new WordListAdapter(this, mWordList);
        recicler.setAdapter(adapter);
        recicler.setLayoutManager(new LinearLayoutManager(this));

        // BUTTOMS LISTENERS
        floater = findViewById(R.id.floating);
        floater.setOnClickListener(this);
        reset = findViewById(R.id.reset);
        reset.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.reset :
                mWordList.clear();
                recicler = findViewById(R.id.reciclerView);
                adapter = new WordListAdapter(this, mWordList);
                recicler.setAdapter(adapter);
                recicler.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.floating :
                int longitude = mWordList.size();

                // GENERAMOS NÚMEROS AL AZAR PARA QUE AL PULSAR NOS AGREGUE CUALQUIER SUPER HEROE DE LA LISTA
                String neo = mWordList.get(new Random().nextInt(20));
                mWordList.addLast(neo);

                recicler.getAdapter().notifyItemInserted(longitude);

                recicler.smoothScrollToPosition(longitude);
                break;
        }

    }
}