package com.micktaiwan.ptmdroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * DAO interface
 * 
 * @author <a href="mailto:vrocher@sqli.com">Valentin Rocher</a>
 * 
 */
public class TasksDao {

	public final static String ID = "_id";
	public final static String DATE = "date";
	public final static String PROJECT_ID = "projectId";
	public final static String TASK = "task";

	private final static String TASKS_TABLE = "tasks";

	private SQLiteDatabase db;
	private DatabaseHelper helper;
	private final Context context;

	/**
	 * Constructeur
	 * 
	 * @param context
	 *            contexte
	 */
	public TasksDao(Context context) {
		this.context = context;
	}

	/**
	 * Ouvrir la base.
	 */
	public void open() {
		helper = new DatabaseHelper(context);
		db = helper.getWritableDatabase();
	}

	/**
	 * Fermer la base
	 */
	public void close() {
		helper.close();
	}

	public long createTask(Task task) {
		ContentValues values = new ContentValues();
		values.put(TASK, task.task);
		return db.insert(TASKS_TABLE, null, values);
	}

	// public boolean deleteIncident(long id) {
	// return db.delete(INCIDENTS_TABLE, ID + "=" + id, null) > 0;
	// }

	// public boolean deleteAllTreated() {
	// return db.delete(INCIDENTS_TABLE, TREATED + "= 1", null) > 0;
	// }

	// public boolean markTreated(long id) {
	// ContentValues values = new ContentValues(1);
	// values.put(TREATED, 1);
	// return db.update(INCIDENTS_TABLE, values, ID + "=" + id, null) > 0;
	// }

	// public Cursor getAllIncidents() {
	// return db.query(INCIDENTS_TABLE, null, null, null, null, null, DATE
	// + " desc");
	// }

	// public Cursor getIncident(long id) {
	// Cursor cursor = db.query(true, INCIDENTS_TABLE, null, ID + "=" + id,
	// null, null, null, null, null);
	// if (cursor != null)
	// cursor.moveToFirst();
	// return cursor;
	// }

	private class DatabaseHelper extends SQLiteOpenHelper {
		private final static String DATABASE_NAME = "ptm_db";
		private final static int DATABASE_VERSION = 1;

		private final static String TASKS_TABLE_CREATE = "create table tasks ("
				+ "_id integer primary key autoincrement," + "task text);";
		private static final String TASKS_TABLE_DROP = "DROP TABLE IF EXISTS tasks";

		public DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(TASKS_TABLE_CREATE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// Log.w(SessionHolder.APPLICATION_TAG,
			// "Upgrading database from version " + oldVersion + " to "
			// + newVersion + ", which will destroy all old data");
			db.execSQL(TASKS_TABLE_DROP);
			onCreate(db);
		}
	}
}