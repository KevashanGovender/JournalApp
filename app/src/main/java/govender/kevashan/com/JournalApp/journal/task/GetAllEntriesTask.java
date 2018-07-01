package govender.kevashan.com.JournalApp.journal.task;

import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import govender.kevashan.com.JournalApp.database.JournalEntry;
import govender.kevashan.com.JournalApp.journal.repo.JournalRepo;

public class GetAllEntriesTask extends AsyncTask<Void, Void, LiveData<List<JournalEntry>>> {

    private JournalRepo repo;

    public GetAllEntriesTask(JournalRepo repo) {
        this.repo = repo;
    }

    @Override
    protected LiveData<List<JournalEntry>> doInBackground(Void... voids) {
        return repo.getAllEntries();
    }
}
