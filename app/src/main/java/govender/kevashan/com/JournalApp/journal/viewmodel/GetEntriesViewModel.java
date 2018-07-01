package govender.kevashan.com.JournalApp.journal.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import govender.kevashan.com.JournalApp.database.JournalDatabase;
import govender.kevashan.com.JournalApp.database.JournalEntry;
import govender.kevashan.com.JournalApp.journal.repo.JournalRepo;
import govender.kevashan.com.JournalApp.journal.view.IEntriesView;

public class GetEntriesViewModel extends AndroidViewModel {

    private JournalRepo repo;
    private IEntriesView view;

    public GetEntriesViewModel(@NonNull Application application) {
        super(application);
        repo = new JournalRepo(JournalDatabase.getDatabase(application));
    }

    public LiveData<List<JournalEntry>> getEntries() {
        return repo.getAllEntries();
    }

    public void setView(IEntriesView view) {
        this.view = view;
    }

    public void isDataValid(List<JournalEntry> liveData){
        if(!liveData.isEmpty()){
            view.showEntries(liveData);
        } else {
            view.showNoEntries();
        }
    }
}
