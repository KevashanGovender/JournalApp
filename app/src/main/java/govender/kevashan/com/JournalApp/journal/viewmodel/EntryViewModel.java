package govender.kevashan.com.JournalApp.journal.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import govender.kevashan.com.JournalApp.database.JournalDatabase;
import govender.kevashan.com.JournalApp.database.JournalEntry;
import govender.kevashan.com.JournalApp.journal.repo.JournalRepo;
import govender.kevashan.com.JournalApp.journal.task.JournalTaskFactory;

public class EntryViewModel extends AndroidViewModel{

    private final JournalRepo repo;
    private final JournalTaskFactory taskFactory;

    public EntryViewModel(@NonNull Application application) {
        super(application);
        repo = new JournalRepo(JournalDatabase.getDatabase(application));
        taskFactory = new JournalTaskFactory(repo);
    }

    public void addEntry(JournalEntry entryToAdd){
        taskFactory.getInsertTask(entryToAdd).execute();
    }

    public void updateEntry(JournalEntry entryToUpdate){
        taskFactory.getUpdateInsertTask(entryToUpdate).execute();
    }
}
