package govender.kevashan.com.JournalApp.journal.task;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import govender.kevashan.com.JournalApp.database.JournalEntry;
import govender.kevashan.com.JournalApp.database.JournalEntryDao;
import govender.kevashan.com.JournalApp.journal.repo.JournalRepo;

import static org.mockito.Mockito.verify;

public class InsertJournalEntryTaskTest {

    @Mock
    private JournalEntryDao dao;
    @Mock
    private JournalEntry journalEntry;
    @Mock
    private JournalRepo repo;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void doInBackgroundShouldInsertEntry(){
        InsertJournalEntryTask task = new InsertJournalEntryTask(journalEntry, repo);

        task.doInBackground();

        verify(repo).insertEntry(journalEntry);
    }

}