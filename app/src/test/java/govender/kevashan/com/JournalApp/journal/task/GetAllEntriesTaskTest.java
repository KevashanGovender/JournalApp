package govender.kevashan.com.JournalApp.journal.task;

import android.arch.lifecycle.LiveData;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import govender.kevashan.com.JournalApp.database.JournalEntry;
import govender.kevashan.com.JournalApp.database.JournalEntryDao;
import govender.kevashan.com.JournalApp.journal.repo.JournalRepo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class GetAllEntriesTaskTest {

    @Mock
    private LiveData<List<JournalEntry>> entries;
    @Mock
    private JournalRepo repo;
    @Mock
    private JournalEntryDao dao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void doInBackgroundShouldGetAllEntries(){
        GetAllEntriesTask task = new GetAllEntriesTask(repo);

        task.doInBackground();

        verify(repo).getAllEntries();
    }
}