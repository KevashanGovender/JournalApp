package govender.kevashan.com.JournalApp.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface JournalEntryDao {

    @Insert
    void insertEntry(JournalEntry journalEntry);

    @Query("SELECT * FROM journal_entry ORDER BY id ASC")
    LiveData<List<JournalEntry>> getAllEntries();

    @Update
    void updateEntry(JournalEntry journalEntry);
}
