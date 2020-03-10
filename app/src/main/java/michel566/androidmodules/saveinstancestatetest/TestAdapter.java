package michel566.androidmodules.saveinstancestatetest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestHolder>{

    private List<String> lista;
    private RemoveItem removeItemListener;

    TestAdapter(List<String> lista, RemoveItem removeItemListener) {
        this.lista = lista;
        this.removeItemListener = removeItemListener;
    }

    @NonNull
    @Override
    public TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
       return new TestHolder(view, removeItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TestHolder holder, int position) {
        String text = lista.get(position);
        holder.textView.setText(text);
    }

    @Override
    public int getItemCount() {
        return lista != null ? lista.size() : 0;
    }

    void loadList(List<String> list){
        this.lista = list;
        notifyDataSetChanged();
    }

}
