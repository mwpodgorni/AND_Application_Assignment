package com.example.myproject.Notes;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.myproject.Notes.data.NoteContract;
import com.example.myproject.Notes.data.NoteDbHelper;
import com.example.myproject.R;

public class SeeNotesActivity extends AppCompatActivity {
    SQLiteDatabase wdb;
    SQLiteDatabase rdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_notes);

        NoteDbHelper noteDbHelper = new NoteDbHelper(this);
        wdb = noteDbHelper.getWritableDatabase();
        rdb = noteDbHelper.getReadableDatabase();

        //Setup FAB to open EditorActivity
        FloatingActionButton fab= (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeeNotesActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onResume() {
        read();
        super.onResume();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete_all_entries:
                deleteAllNotes();
                read();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void displayDatabaseInfo(){
        Cursor cursor= rdb.rawQuery("SELECT * FROM " + NoteContract.NoteEntry.TABLE_NAME, null);
        try{
            TextView displayView = (TextView) findViewById(R.id.text_view_note);
            displayView.setText("Number of rows in notes database table: "+ cursor.getCount());
        } finally {
            cursor.close();
        }
    }
    private void read(){
        NoteDbHelper noteDbHelper = new NoteDbHelper(this);
        SQLiteDatabase db = noteDbHelper.getReadableDatabase();

        String [] projection = {
                NoteContract.NoteEntry._ID,
                NoteContract.NoteEntry.COLUMN_NOTE_TITLE,
                NoteContract.NoteEntry.COLUMN_NOTE_NOTE};
        Cursor cursor = db.query(
                NoteContract.NoteEntry.TABLE_NAME, projection, null, null, null, null, null);
        TextView displayView = (TextView) findViewById(R.id.text_view_note);
        try{
            displayView.setText("The notes table contains " + cursor.getCount() + " notes.\n\n");
            displayView.append(NoteContract.NoteEntry._ID + "  |  " +
                    NoteContract.NoteEntry.COLUMN_NOTE_TITLE + "  |  " +
                    NoteContract.NoteEntry.COLUMN_NOTE_NOTE + "\n");

            while(cursor.moveToNext()){
                int currentID = cursor.getInt(cursor.getColumnIndex(NoteContract.NoteEntry._ID));
                String currentTitle = cursor.getString(cursor.getColumnIndex(NoteContract.NoteEntry.COLUMN_NOTE_TITLE));
                String currentNote = cursor.getString(cursor.getColumnIndex(NoteContract.NoteEntry.COLUMN_NOTE_NOTE));

                displayView.append(("\n" + currentID + "  |  " +
                        currentTitle + "  |  " +
                        currentNote));
            }
        }finally {
            cursor.close();
        }
    }
    private void deleteAllNotes(){ wdb.delete(NoteContract.NoteEntry.TABLE_NAME, null, null);}
}
