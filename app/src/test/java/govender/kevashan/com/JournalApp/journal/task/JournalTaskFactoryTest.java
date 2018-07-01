package govender.kevashan.com.JournalApp.journal.task;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import govender.kevashan.com.JournalApp.database.JournalEntry;
import govender.kevashan.com.JournalApp.journal.repo.JournalRepo;

import static org.junit.Assert.*;

public class JournalTaskFactoryTest {

    @Mock
    private JournalEntry entry;
    @Mock
    private JournalRepo repo;

    private JournalTaskFactory taskFactory;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        taskFactory = new JournalTaskFactory(repo);
    }

    @Test
    public void getInsertTask(){
        assertTrue(taskFactory.getInsertTask(entry) instanceof InsertJournalEntryTask);
    }

    @Test
    public void getUpdateTask(){
        assertTrue(taskFactory.getUpdateInsertTask(entry) instanceof UpdateJournalEntryTask);
    }

    @Test
    public void getAllEntriesTask(){
        assertTrue(taskFactory.getAllEntriesTask() instanceof GetAllEntriesTask);
    }
}