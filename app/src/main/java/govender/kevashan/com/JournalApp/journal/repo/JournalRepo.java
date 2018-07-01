package govender.kevashan.com.JournalApp.journal.repo;

import android.arch.lifecycle.LiveData;

import java.util.List;

import govender.kevashan.com.JournalApp.database.JournalDatabase;
import govender.kevashan.com.JournalApp.database.JournalEntry;
import govender.kevashan.com.JournalApp.database.JournalEntryDao;

public class JournalRepo {

    private JournalEntryDao dao;

    public JournalRepo(JournalDatabase journalDatabase) {
        this.dao = journalDatabase.dao();
    }

    public void insertEntry(JournalEntry journalEntry){
        dao.insertEntry(journalEntry);
    }

    public void updateEntry(JournalEntry journalEntry) {
        dao.updateEntry(journalEntry);
    }

    public LiveData<List<JournalEntry>> getAllEntries() {
        return dao.getAllEntries();
    }
}
