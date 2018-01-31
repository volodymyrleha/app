package ua.org.best_lviv.best;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Volodymyr on 29.01.2018.
 */


public class ProjectAdapter extends RecyclerView.Adapter<ProjectViewHolder> {
    private List<Project> projectsList;
    Context context;

    public ProjectAdapter(List<Project> projectsList, Context context) {
        this.projectsList = projectsList;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(ProjectViewHolder holder, int position) {
        final Project project = projectsList.get(position);
        holder.bind(project);
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_projects, parent, false);
        return new ProjectViewHolder(view, context);
    }

    @Override
    public int getItemCount() {
        return projectsList.size();
    }

    public void setFilter(List<Project> projectsList) {
        this.projectsList = new ArrayList<>();
        this.projectsList.addAll(projectsList);
        notifyDataSetChanged();
    }
}
















