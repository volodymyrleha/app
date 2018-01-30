package ua.org.best_lviv.best;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Volodymyr on 30.01.2018.
 */

public class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView name_TextView;
    public TextView phone_TextView;

    Context context;

    private static final int MAKE_CALL_PERMISSION_REQUEST_CODE = 1;

    public PersonViewHolder(View itemView, Context context) {
        super(itemView);
        itemView.setOnClickListener(this);
        this.context = context;

        name_TextView = (TextView) itemView.findViewById(R.id.contact_list_textview_name_id);
        phone_TextView = (TextView) itemView.findViewById(R.id.contact_list_textview_phone_id);
    }

    public void bind(Person person) {
        name_TextView.setText(person.getName());
        phone_TextView.setText(person.getNumber());
    }


    @Override
    public void onClick(View view) {
        int position = getAdapterPosition();
        final Person person = test.personList.get(position);
        final boolean[] to_call = {false};

        //Start call to contact
        ImageView imageView = view.findViewById(R.id.call_to_contact);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to_call[0] = true;
                Intent call_to_contact_intent = new Intent(Intent.ACTION_CALL);
                call_to_contact_intent.setData(Uri.parse("tel:" + person.getNumber()));

                if (checkPermission(Manifest.permission.CALL_PHONE)) {
                    view.getContext().startActivity(call_to_contact_intent);
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CALL_PHONE}, MAKE_CALL_PERMISSION_REQUEST_CODE);
                }
            }
        });
        //End call to contact

        if(!to_call[0]) {
            Intent open_contact_details_intent = new Intent(view.getContext(), PersonDetails.class);
            open_contact_details_intent.putExtra("name", person.getName());
            open_contact_details_intent.putExtra("phone", person.getNumber());
            view.getContext().startActivity(open_contact_details_intent);
        }
    }

    private boolean checkPermission(String permission) {
        return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }
}
