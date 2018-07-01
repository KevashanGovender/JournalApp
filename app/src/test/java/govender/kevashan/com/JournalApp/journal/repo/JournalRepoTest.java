package govender.kevashan.com.JournalApp.journal.repo;

import android.arch.lifecycle.LiveData;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import govender.kevashan.com.JournalApp.database.JournalDatabase;
import govender.kevashan.com.JournalApp.database.JournalEntry;
import govender.kevashan.com.JournalApp.database.JournalEntryDao;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

public class JournalRepoTest {

    @Mock
    private JournalDatabase journalDatabase;
    @Mock
    private JournalEntry journalEntry;
    @Mock
    private JournalEntryDao dao;
    @Mock
    private LiveData<List<JournalEntry>> entries;


    private JournalRepo repo;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        doReturn(dao).when(journalDatabase).dao();
        repo = new JournalRepo(journalDatabase);
    }

    @Test
    public void insertEntry(){
        repo.insertEntry(journalEntry);

        verify(dao).insertEntry(journalEntry);
    }

    @Test
    public void updateEntry(){
        repo.updateEntry(journalEntry);

        verify(dao).updateEntry(journalEntry);
    }

    @Test
    public void getAllEntries(){
        repo.getAllEntries();

        doReturn(entries).when(dao).getAllEntries();

        verify(dao).getAllEntries();
    }

}