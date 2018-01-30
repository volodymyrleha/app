package ua.org.best_lviv.best;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PersonDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);
        Intent intent = this.getIntent();

        TextView textView_name = (TextView) findViewById(R.id.contact_details_name_textview_id);
        TextView textView_phone = (TextView) findViewById(R.id.contact_details_number_textview_id);
        textView_name.setText(intent.getStringExtra("name"));
        textView_phone.setText(intent.getStringExtra("phone"));
    }
}
