package ua.org.best_lviv.best;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import static ua.org.best_lviv.best.test.projectsList;

/**
 * Created by Volodymyr on 29.01.2018.
 */

public class ProjectsTabFragment extends Fragment {
    private RecyclerView recyclerView;
    private ProjectAdapter projectAdapter;

    public static String[] PROJECT_NAMES = {"Hackathon", "Ebec", "BTW", "Summer Courses", "ІЯК",
            "Hackathon", "Ebec", "BTW", "Summer Courses", "ІЯК", "Hackathon", "Ebec", "BTW", "Summer Courses", "ІЯК",
            "Hackathon", "Ebec", "BTW", "Summer Courses", "ІЯК", "Hackathon", "Ebec", "BTW", "Summer Courses", "ІЯК"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_fragment_projects, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.projects_recyclerView_id);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return rootView;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);
        projectsList = new ArrayList<>();

        for (int i = 0; i < PROJECT_NAMES.length; i++) {
            projectsList.add(new Project(PROJECT_NAMES[i], "short description"));
        }

        projectAdapter = new ProjectAdapter(projectsList, view.getContext());
        recyclerView.setAdapter(projectAdapter);

    }
}
