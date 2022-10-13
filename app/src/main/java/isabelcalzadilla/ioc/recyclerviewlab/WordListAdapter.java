package isabelcalzadilla.ioc.recyclerviewlab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

// DECLARACIÓN DEL ADAPTADOR DE LA WORDLIST CON LOS VALORES DETERMINADOS DESDE EL LAB
public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    //
    private final LinkedList <String> mWordList;
    private LayoutInflater mInflater;

    public WordListAdapter(Context context, LinkedList<String> mWordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = mWordList;
    }

    //CLASE INTERNA PAA EL WORDVIEWHOLDER
    // CONSTRUCTOR POR DEFECTO PARA LA CLASE INTERNA
    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView wordItemView;
        final WordListAdapter mAdapter;

        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);

            // recepción de los parámetros compuestos por el TextView de la lista de items
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;

            //LLAMADO AL ONCLICK LISTENER
            itemView.setOnClickListener(this);
        }

        // EVENTO ONCLICK DEL VIWHOLDER
        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();

            String element = mWordList.get(position);

            mWordList.set(position, "Got You" + element);

            mAdapter.notifyDataSetChanged();
        }
    }


    //METODOS PREDEFINIDOS POR ANDROID STUDIO PARA LA VIEW HOLDER
    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);

        // RETORNO DEL VIEW HOLDER CON ADAPTADOR
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {

        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    // RETORNA LA DIMENSIÓN DEL LINKEDLIST
    @Override
    public int getItemCount() {

        return mWordList.size();
    } // 'EL CECICLER VIEW ES GENÉRICO


}
