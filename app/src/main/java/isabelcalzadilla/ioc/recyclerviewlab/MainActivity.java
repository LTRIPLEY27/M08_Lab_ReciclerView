package isabelcalzadilla.ioc.recyclerviewlab;

import android.os.Bundle;

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

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    // LAB SECTION
    private final LinkedList <String> mWordList = new LinkedList<>();
    private RecyclerView recicler;
    private WordListAdapter adapter;
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

        for(int i = 0; i < 20; i++){
            mWordList.add("Palabra " + i);
        }

        recicler = findViewById(R.id.reciclerView);
        adapter = new WordListAdapter(this, mWordList);
        recicler.setAdapter(adapter);
        recicler.setLayoutManager(new LinearLayoutManager(this));
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
}