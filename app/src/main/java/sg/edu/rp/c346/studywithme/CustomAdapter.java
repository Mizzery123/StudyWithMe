package sg.edu.rp.c346.studywithme;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 17000719 on 3/1/2019.
 */

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<ToDoItem> toDoList;


    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<ToDoItem> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        toDoList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Obtain the LayoutInflater object.
        LayoutInflater inflater = (LayoutInflater) parent_context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Inflate a new view hierarchy from the specified xml resource (layout_id)
        // and return the root View of the inflated hierarchy.
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI elements and bind them to their respective Java variable.
        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvDate = rowView.findViewById(R.id.textViewDate);
        ImageView ivImpt = rowView.findViewById(R.id.imageViewImpt);
        TextView tvModule = rowView.findViewById(R.id.textViewModule);
        TextView tvAnswer = rowView.findViewById(R.id.textViewAnswer);

        // Obtain the property values from the Data Class object
        // and set them to the corresponding UI elements.
        ToDoItem currentItem = toDoList.get(position);
        tvTitle.setText(currentItem.getTitle());
        tvDate.setText(currentItem.getDateString());
        tvModule.setText(currentItem.getModule());
        tvAnswer.setText(currentItem.getAnswer());

        if (currentItem.isImportant()){
            ivImpt.setImageResource(R.drawable.soi);
        } else {
            ivImpt.setImageResource(R.drawable.sas);
        }

        // Return the View corresponding to the data at the specified position.
        return rowView;
    }
}
