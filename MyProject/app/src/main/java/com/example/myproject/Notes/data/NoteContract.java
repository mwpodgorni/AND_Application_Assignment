package com.example.myproject.Notes.data;

import android.provider.BaseColumns;

public class NoteContract {
    private NoteContract(){}

    public static final class NoteEntry implements BaseColumns {
        public final static String TABLE_NAME="notes";
        public final static String _ID = BaseColumns._ID;
        public final static String  COLUMN_NOTE_TITLE="title";
        public final static String COLUMN_NOTE_NOTE="note";
    }
}
