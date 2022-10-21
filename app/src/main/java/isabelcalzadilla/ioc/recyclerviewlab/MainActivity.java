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

//*******    TASK 1 : CREACIÓN DEL ACTIVITY MAIN PARA INICIALIZAR LOS VALORES  *******
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // LAB SECTION

    // LISTA INICIAL DE PERSONAJES
    private List<String> lista = Arrays.asList("Philip J Fry", "Turanga Leela", "John A. Zoidberg", "Bender Doblador Rodríguez", "Profesor Hubert J. Farnsworth", "Dra. Amy Wong", "Hermes Conrad", "Zapp Brannigan", "Beelzebot", "Scruffy", "Nixon", "Seymour III", "Morbo", "Hipnosapo", "Robot Hedonista", "Calculon", "Mafia Robot", "Globetrotters", "Nibbler", "Abogada Soltera");
    private LinkedList <String> mWordList;

    // CREACIÓN DE LAS VARIABLES DEL ADAPTADOR, RECYCLER Y BUTTONS
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

        starting();
    }

    // MÉTODOS PROPIOS DE LA ACTIVITY
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

    void starting(){
       // declaración de la linkedlist e inserción de la lista de superhéroes
        mWordList = new LinkedList<>(lista);

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

    //*******    TASK 3.2 : INDICACIÓN DE ACCIONES EN LOS BOTONES FLOTANTES  *******
    // método on click para disparar la acción
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.reset :
                // EN CASO DE PREIONAR EL BUTTON RESET NOS INICIALIZA LA APP DESDE CERO
                starting();
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