package govender.kevashan.com.JournalApp.journal.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import govender.kevashan.com.JournalApp.database.JournalEntry;
import govender.kevashan.com.JournalApp.journal.view.EntryActivity;
import govender.kevashan.com.journalapp3.R;

public class EntryListAdapter extends RecyclerView.Adapter<EntryListAdapter.EntryViewHolder> {

    private final LayoutInflater inflater;
    private List<JournalEntry> journalEntries;

    public EntryListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public EntryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.entry_item, parent, false);
        return new EntryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EntryViewHolder holder, int position) {
        if(journalEntries != null){
            JournalEntry currentEntry = journalEntries.get(position);
            holder.wordItemView.setText(currentEntry.getDate());
            holder.setCurrentEntry(currentEntry);
        } else {
            holder.wordItemView.setText(R.string.no_entries);
        }
    }

    @Override
    public int getItemCount() {
        if(journalEntries != null){
            return journalEntries.size();
        } else{
            return 0;
        }
    }

    public void setJournalEntries(List<JournalEntry> entries){
        journalEntries = entries;
        notifyDataSetChanged();
    }

    class EntryViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;
        private final TextView edit_btn;
        private JournalEntry currentEntry;

        private EntryViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
            edit_btn = itemView.findViewById(R.id.edit_btn);

            edit_btn.setOnClickListener(view ->{
                Intent intent = new Intent(inflater.getContext(), EntryActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("ENTRY", currentEntry);
                intent.putExtra("EDIT_ENTRY", bundle);
                inflater.getContext().startActivity(intent);
            });
        }

        void setCurrentEntry(JournalEntry currentEntry) {
            this.currentEntry = currentEntry;
        }
    }
}
