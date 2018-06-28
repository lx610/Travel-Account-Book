package lx610.com.accountbook.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

import lx610.com.accountbook.bean.PersonBean;
import lx610.com.accountbook.bean.ProjectListBean;

/**
 * 建立如下数据表格
 * 1.人员表：项目名-人员名称
 * 2.项目表：项目名-创建时间-人员数量-总花费
 * 3.开销详情表：项目名-花费名目-花销-花销人员-花销时间-花销类别
 */
public class ProjectListDaoHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "POJECT.db";
    public final static int DATABASE_VERSION = 1;

    private final static String TABLE_NAME_PROJECT = "table_project";
    public final static String PROJECT_ID = "project_id";
    public final static String PROJECT_NAME = "project_name";
    public final static String PROJECT_CREAT_DATE = "project_creat_date";
    public final static String ID = "id";

    private final static String TABLE_NAME_PERSON = "person_table";
    public final static String  PERSON_NAME = "person_name";


    private SQLiteDatabase dataBase;

    public ProjectListDaoHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    public void creatSql(String projectName) {

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dataBase = db;
        String create_project_table = "CREATE TABLE " + TABLE_NAME_PROJECT + " (" + ID
                + " INTEGER primary key autoincrement, " + PROJECT_NAME + " text, "+ PROJECT_CREAT_DATE +" text,"+ PROJECT_ID + " integer" + ");";
        dataBase.execSQL(create_project_table);

        dataBase = db;
        String create_person_table = "CREATE TABLE " + TABLE_NAME_PERSON + " (" + ID
                + " INTEGER primary key autoincrement, " + PROJECT_NAME + " text, "+ PERSON_NAME +" text);";
        dataBase.execSQL(create_person_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //增加操作
    public long insert_person_table(String projectName,String creat_time)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        /* ContentValues */
        ContentValues cv = new ContentValues();
        cv.put(PROJECT_NAME, projectName);
        cv.put(PROJECT_CREAT_DATE, creat_time);
        long row = db.insert(TABLE_NAME_PERSON, null, cv);
        return row;
    }

    //增加操作
    public long insert_project_table(String projectName,String personName)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        /* ContentValues */
        ContentValues cv = new ContentValues();
        cv.put(PROJECT_NAME, projectName);
        cv.put(PERSON_NAME, personName);
        long row = db.insert(TABLE_NAME_PROJECT, null, cv);
        return row;
    }

    public ArrayList<ProjectListBean> query_project(){
        ArrayList<ProjectListBean> projectList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME_PROJECT,null,null,null,null,null,null);
        if (cursor.moveToFirst()){
            do {
                ProjectListBean bean = new ProjectListBean();
                String projectName = cursor.getString(cursor.getColumnIndex(PROJECT_NAME));
                bean.setProjectName(projectName);
                projectList.add(bean);
            }while (cursor.moveToNext());
        }
        return projectList;
    }

    public ArrayList<PersonBean> query_person(String targetProjectName){
        ArrayList<PersonBean> personList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String[] selectColum = {PROJECT_NAME};
        String selectTion = "PROJECT_NAME = " + targetProjectName;
        Cursor cursor = db.query(TABLE_NAME_PERSON,selectColum,selectTion,null,null,null,null);
        if (cursor.moveToFirst()){
            do {
                PersonBean bean = new PersonBean();
                String projectName = cursor.getString(cursor.getColumnIndex(PROJECT_NAME));
                String personName = cursor.getString(cursor.getColumnIndex(PERSON_NAME));
                bean.setProjectName(projectName);
                bean.setPersonName(personName);
                personList.add(bean);
            }while (cursor.moveToNext());
        }
        return personList;
    }

    public void deletProject(String projectName){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] string = new String[]{projectName};
        db.delete(TABLE_NAME_PROJECT,PROJECT_NAME + "==",string);
    }
}
