package govender.kevashan.com.JournalApp.journal.task;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import govender.kevashan.com.JournalApp.database.JournalEntry;
import govender.kevashan.com.JournalApp.journal.repo.JournalRepo;

import static org.mockito.Mockito.verify;

public class UpdateJournalEntryTaskTest {

    @Mock
    private JournalRepo repo;
    @Mock
    private JournalEntry journalEntry;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void doInBackgroundShouldUpdateEntry(){

        UpdateJournalEntryTask task = new UpdateJournalEntryTask(repo, journalEntry);

        task.doInBackground();

        verify(repo).updateEntry(journalEntry);
    }
}