package michel566.androidmodules.saveinstancestatetest;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> testList;
    private EditText editText;
    private ImageView sendButton;
    private RemoveItem removeItemListener;
    private TestViewModel testViewModel;

    private TestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testViewModel = new ViewModelProvider(this).get(TestViewModel.class);

        editText = findViewById(R.id.editTest);
        sendButton = findViewById(R.id.send_button);
        testList = new ArrayList<>();

        listenerSetup();
        observerSetup();

        recyclerViewSetup();


    }

    private void listenerSetup() {
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorDigitado = editText.getText().toString();
               /* if (!valorDigitado.equals("")) {
                    testList.add(valorDigitado);
                }
                adapter.notifyDataSetChanged();

                */
               testViewModel.addValue(valorDigitado);
               editText.setText("");
               adapter.notifyDataSetChanged();
            }
        });

        removeItemListener = new RemoveItem() {
            @Override
            public void onClick(View view, int adapterPosition) {
              /*  if (adapter.getItemCount() > 0) {
                    adapter.removeItem(adapterPosition);
                }

               */

              testViewModel.removeValue(adapterPosition);
              adapter.notifyDataSetChanged();
            }
        };
    }

    private void observerSetup() {
        testViewModel.getResults().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                adapter.loadList(strings);
            }
        });
    }

    private void recyclerViewSetup() {
        RecyclerView rv = findViewById(R.id.contentPanel);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new TestAdapter(testList, removeItemListener);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);
    }

}
