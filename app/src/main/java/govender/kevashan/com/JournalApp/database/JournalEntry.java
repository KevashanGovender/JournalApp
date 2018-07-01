package govender.kevashan.com.JournalApp.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "journal_entry")
public class JournalEntry {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "entry")
    private String entry;
    @ColumnInfo(name = "date")
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
