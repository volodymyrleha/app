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


public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {
    private List<Person> personList;
    Context context;

    public PersonAdapter(List<Person> personList, Context context) {
        this.personList = personList;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        final Person person = personList.get(position);
        holder.bind(person);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_contacts, parent, false);
        return new PersonViewHolder(view, context);
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
















