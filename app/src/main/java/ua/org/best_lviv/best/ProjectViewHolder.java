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

public class ProjectViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView name_TextView;
    public TextView description_TextView;

    Context context;

    public ProjectViewHolder(View itemView, Context context) {
        super(itemView);
        itemView.setOnClickListener(this);
        this.context = context;

        name_TextView = (TextView) itemView.findViewById(R.id.project_name_textview_id);
        description_TextView = (TextView) itemView.findViewById(R.id.project_short_description_textview_id);
    }

    public void bind(Project project) {
        name_TextView.setText(project.getName());
        description_TextView.setText(project.getDescription());
    }


    @Override
    public void onClick(View view) {

    }
}
