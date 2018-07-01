package govender.kevashan.com.JournalApp.journal.task;

import android.os.AsyncTask;

import govender.kevashan.com.JournalApp.database.JournalEntry;
import govender.kevashan.com.JournalApp.journal.repo.JournalRepo;

public class InsertJournalEntryTask extends AsyncTask<Void, Void, Void> {

    private JournalEntry journalEntry;
    private JournalRepo repo;

    public InsertJournalEntryTask(JournalEntry journalEntry, JournalRepo repo) {
        this.journalEntry = journalEntry;
        this.repo = repo;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        repo.insertEntry(journalEntry);
        return null;
    }
}
