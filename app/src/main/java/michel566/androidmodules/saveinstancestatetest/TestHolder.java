package michel566.androidmodules.saveinstancestatetest;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TestHolder extends RecyclerView.ViewHolder {

    final RemoveItem removeItemListener;

    TextView textView;
    ImageView imageView;

    public TestHolder(@NonNull View itemView, final RemoveItem removeItemListener) {
        super(itemView);
        textView = itemView.findViewById(R.id.item_textView);
        imageView = itemView.findViewById(R.id.item_imageView);
        this.removeItemListener = removeItemListener;

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItemListener.onClick(imageView, getAdapterPosition());
            }
        });
    }



}
