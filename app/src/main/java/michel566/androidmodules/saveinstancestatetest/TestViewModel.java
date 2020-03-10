package michel566.androidmodules.saveinstancestatetest;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class TestViewModel extends ViewModel {

    private List<String> values;
    private MutableLiveData<List<String>> results;

    public TestViewModel() {
        this.values = new ArrayList<>();
    }

    MutableLiveData<List<String>> getResults() {
        if (results == null) {
            results = new MutableLiveData<>();
            loadValues();
        }
        return results;
    }

    //Aqui posso recuperar os dados de alguma fonte para exibir no observer responsável na view.
    private void loadValues() {
        results.setValue(this.values);
    }

    void addValue(String value) {
        this.values.add(value);
    }

    void removeValue(int index) {
        this.values.remove(index);
    }

}
