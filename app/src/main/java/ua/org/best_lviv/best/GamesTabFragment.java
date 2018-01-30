package ua.org.best_lviv.best;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Volodymyr on 29.01.2018.
 */

public class GamesTabFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_fragment_games, container, false);
        Button button = (Button) rootView.findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "bla bla", Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }
}
