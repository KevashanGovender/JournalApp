package govender.kevashan.com.JournalApp.journal.view;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import govender.kevashan.com.JournalApp.database.JournalEntry;
import govender.kevashan.com.JournalApp.journal.view.adapter.EntryListAdapter;
import govender.kevashan.com.JournalApp.journal.viewmodel.GetEntriesViewModel;
import govender.kevashan.com.journalapp3.R;

public class HomeActivity extends AppCompatActivity implements IEntriesView {

    private FloatingActionButton addBtn;
    private TextView noEntriesTv;
    private GetEntriesViewModel viewModel;
    private EntryListAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entries);

        adapter = new EntryListAdapter(this);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addBtn = findViewById(R.id.add_btn);
        noEntriesTv = findViewById(R.id.no_entries_tv);

        viewModel = ViewModelProviders.of(this).get(GetEntriesViewModel.class);
        viewModel.setView(this);
        viewModel.getEntries().observe(this, new Observer<List<JournalEntry>>() {
            @Override
            public void onChanged(@Nullable List<JournalEntry> journalEntries) {
                viewModel.isDataValid(journalEntries);
            }
        });

        addBtn.setOnClickListener(view ->
                startActivity(new Intent(this, EntryActivity.class))
        );
    }

    @Override
    public void showNoEntries() {
        noEntriesTv.setVisibility(View.VISIBLE);
    }

    @Override
    public void showEntries(List<JournalEntry> journalEntries) {
        noEntriesTv.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        adapter.setJournalEntries(journalEntries);
    }

}
