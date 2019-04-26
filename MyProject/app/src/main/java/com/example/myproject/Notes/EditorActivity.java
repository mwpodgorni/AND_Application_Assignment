package com.example.myproject.Notes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.myproject.Notes.data.NoteContract;
import com.example.myproject.Notes.data.NoteDbHelper;
import com.example.myproject.R;

public class EditorActivity extends AppCompatActivity {
    SQLiteDatabase wdb;
    SQLiteDatabase rdb;

    private EditText mTitleEditText;
    private EditText mNoteEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        NoteDbHelper noteDbHelper = new NoteDbHelper(this);
        wdb = noteDbHelper.getWritableDatabase();
        rdb = noteDbHelper.getReadableDatabase();
        mTitleEditText = (EditText) findViewById(R.id.edit_note_title);
        mNoteEditText = (EditText) findViewById(R.id.edit_note_note);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_save:
                insertNote();
                finish();
                return true;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void insertNote(){
        String titleString = mTitleEditText.getText().toString().trim();
        String noteString = mNoteEditText.getText().toString().trim();

        ContentValues values = new ContentValues();
        values.put(NoteContract.NoteEntry.COLUMN_NOTE_TITLE, titleString);
        values.put(NoteContract.NoteEntry.COLUMN_NOTE_NOTE, noteString);

        wdb.insert(NoteContract.NoteEntry.TABLE_NAME, null, values);
    }
}
