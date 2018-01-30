package ua.org.best_lviv.best;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Volodymyr on 30.01.2018.
 */

public class PersonViewHolder extends RecyclerView.ViewHolder {

    public TextView name_TextView;
    public TextView phone_TextView;

    public PersonViewHolder(View itemView) {
        super(itemView);

        name_TextView = (TextView) itemView.findViewById(R.id.contact_list_textview_name_id);
        phone_TextView = (TextView) itemView.findViewById(R.id.contact_list_textview_phone_id);
    }

    public void bind(Person person) {
        name_TextView.setText(person.getName());
        phone_TextView.setText(person.getNumber());
    }
}
