package ua.org.best_lviv.best;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProjectDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_details);
        Intent intent = this.getIntent();

        TextView textView_name = (TextView) findViewById(R.id.project_details_name_textview_id);
        textView_name.setText(intent.getStringExtra("name"));
    }
}
