package ua.org.best_lviv.best;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Volodymyr on 29.01.2018.
 */


public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {
    private List<Person> personList;

    public PersonAdapter(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        final Person person = personList.get(position);
        holder.bind(person);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_contacts, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public void setFilter(List<Person> personList) {
        this.personList = new ArrayList<>();
        this.personList.addAll(personList);
        notifyDataSetChanged();
    }
}
















