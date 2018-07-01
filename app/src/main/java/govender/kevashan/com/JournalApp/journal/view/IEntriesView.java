package govender.kevashan.com.JournalApp.journal.view;

import android.arch.lifecycle.LiveData;

import java.util.List;

import govender.kevashan.com.JournalApp.database.JournalEntry;

public interface IEntriesView {

    void showNoEntries();
    void showEntries(List<JournalEntry> liveData);
}
