package govender.kevashan.com.JournalApp.journal.task;

import govender.kevashan.com.JournalApp.database.JournalEntry;
import govender.kevashan.com.JournalApp.journal.repo.JournalRepo;

public class JournalTaskFactory {

    private JournalRepo repo;

    public JournalTaskFactory(JournalRepo repo) {
        this.repo = repo;
    }

    public InsertJournalEntryTask getInsertTask(JournalEntry entry) {
        return new InsertJournalEntryTask(entry, repo);
    }

    public UpdateJournalEntryTask getUpdateInsertTask(JournalEntry entry) {
        return new UpdateJournalEntryTask(repo, entry);
    }

    public GetAllEntriesTask getAllEntriesTask() {
        return new GetAllEntriesTask(repo);
    }
}
