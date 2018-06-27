package lx610.com.accountbook.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * 建立如下数据表格
 * 1.人员表：项目名-人员名称
 * 2.项目表：项目名-创建时间-人员数量-总花费
 * 3.开销详情表：项目名-花费名目-花销-花销人员-花销时间-花销类别
 */
public class ProjectListDaoHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "POJECT.db";
    private final static int DATABASE_VERSION = 1;
    private final static String TABLE_NAME = "PROJECT_TABLE";
    public final static String PROJECT_ID = "project_id";
    public final static String PROJECT_NAME = "project_name";
    public final static String PROJECT_CREAT_DATE = "project_creat_date";


    private SQLiteDatabase dataBase;

    public ProjectListDaoHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    public void creatSql(String projectName) {

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dataBase = db;
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + PROJECT_ID
                + " INTEGER primary key autoincrement, " + PROJECT_NAME + " text, "+ PROJECT_CREAT_DATE +" text);";
        dataBase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //增加操作
    public long insert(String projectName,String creatDate)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        /* ContentValues */
        ContentValues cv = new ContentValues();
        cv.put(PROJECT_NAME, projectName);
        cv.put(PROJECT_CREAT_DATE, creatDate);
        long row = db.insert(TABLE_NAME, null, cv);
        return row;
    }

    public void getTableName(){
        SQLiteDatabase db = this.getWritableDatabase();
        // 相当于 select * from students 语句
        Cursor cursor = db.query(TABLE_NAME, null,
                "cls_id > ? and id >= 1", new String[]{"3"},
                null, null, null, null);

        // 不断移动光标获取值
        while (cursor.moveToNext()) {
            // 直接通过索引获取字段值
            int stuId = cursor.getInt(0);

            // 先获取 name 的索引值，然后再通过索引获取字段值
            String stuName = cursor.getString(cursor.getColumnIndex("name"));
            Log.e("", "id: " + stuId + " name: " + stuName);
        }
        // 关闭光标
        cursor.close();
    }
}
