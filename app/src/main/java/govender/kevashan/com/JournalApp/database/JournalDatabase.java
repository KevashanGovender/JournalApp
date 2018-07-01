package govender.kevashan.com.JournalApp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {JournalEntry.class}, version = 1)
public abstract class JournalDatabase extends RoomDatabase {

    public abstract JournalEntryDao dao();

    private static JournalDatabase INSTANCE;

    public static JournalDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (JournalDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            JournalDatabase.class, "journal_entry_database")
                            .build();

                }
            }
        }
        return INSTANCE;
    }
}
