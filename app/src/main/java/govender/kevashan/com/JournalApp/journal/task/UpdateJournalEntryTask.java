package govender.kevashan.com.JournalApp.journal.task;

import android.os.AsyncTask;

import govender.kevashan.com.JournalApp.database.JournalEntry;
import govender.kevashan.com.JournalApp.journal.repo.JournalRepo;

public class UpdateJournalEntryTask extends AsyncTask<Void, Void, Void>{

    private JournalRepo repo;
    private JournalEntry journalEntry;

    public UpdateJournalEntryTask(JournalRepo repo, JournalEntry journalEntry) {
        this.repo = repo;
        this.journalEntry = journalEntry;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        repo.updateEntry(journalEntry);
        return null;
    }
}
