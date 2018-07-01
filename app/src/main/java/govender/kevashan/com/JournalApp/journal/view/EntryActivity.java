package govender.kevashan.com.JournalApp.journal.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.Date;

import govender.kevashan.com.JournalApp.database.JournalEntry;
import govender.kevashan.com.JournalApp.journal.viewmodel.EntryViewModel;
import govender.kevashan.com.journalapp3.R;

public class EntryActivity extends AppCompatActivity {

    private EditText entry_ed;
    private EntryViewModel viewModel;
    private JournalEntry entryToUpdate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry_activity);

        entry_ed = findViewById(R.id.entry_et);

        viewModel = ViewModelProviders.of(this).get(EntryViewModel.class);

        Intent intent = getIntent();
        if(intent.getExtras() != null){
            Bundle bundle = intent.getBundleExtra("EDIT_ENTRY");
            entryToUpdate = bundle.getParcelable("ENTRY");
            entry_ed.setText(entryToUpdate.getEntry());
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem saveMenuItem = menu.findItem(R.id.save_btn);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.save_btn){
            JournalEntry entryToAdd = new JournalEntry();
            entryToAdd.setDate(new Date().toString());
            entryToAdd.setEntry(entry_ed.getText().toString());

            if(entryToUpdate != null){
                entryToUpdate.setDate(new Date().toString());
                entryToUpdate.setEntry(entry_ed.getText().toString());
                viewModel.updateEntry(entryToUpdate);
            } else {
                viewModel.addEntry(entryToAdd);
            }

            finish();
        }
        return true;
    }
}
