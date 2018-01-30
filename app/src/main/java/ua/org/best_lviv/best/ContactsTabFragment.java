package ua.org.best_lviv.best;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import static ua.org.best_lviv.best.test.personList;

/**
 * Created by Volodymyr on 29.01.2018.
 */

public class ContactsTabFragment extends Fragment implements SearchView.OnQueryTextListener {

    private RecyclerView recyclerView;
    private PersonAdapter personAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_fragment_contacts, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return rootView;
    }

    //search and list contacts starts
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);
        personList = new ArrayList<>();

        for (int i = 0; i < test.NAMES.length; i++) {
            personList.add(new Person(test.NAMES[i], test.NUMBERS[i]));
        }

        personAdapter = new PersonAdapter(personList, view.getContext());
        recyclerView.setAdapter(personAdapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);


        MenuItemCompat.setOnActionExpandListener(item, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                personAdapter.setFilter(personList);
                return true;
            }
        });
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        final List<Person> filteredList = filter(personList, newText);
        personAdapter.setFilter(filteredList);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    private List<Person> filter(List<Person> models, String query) {
        query = query.toLowerCase();
        final List<Person> filteredList = new ArrayList<>();

        for (Person person : models) {
            final String text = person.getName().toLowerCase();
            if (text.contains(query))
                filteredList.add(person);
        }

        return filteredList;
    }
    //search and list contacts ends
}
