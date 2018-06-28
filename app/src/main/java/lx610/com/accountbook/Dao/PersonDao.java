package lx610.com.accountbook.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import lx610.com.accountbook.bean.PersonBean;


public class PersonDao {
    private final static String TABLE_NAME_PROJECT = "table_project";
    public final static String PROJECT_ID = "project_id";
    public final static String PROJECT_NAME = "project_name";
    public final static String PROJECT_CREAT_DATE = "project_creat_date";
    public final static String ID = "id";

    private final static String TABLE_NAME_PERSON = "person_table";
    public final static String  PERSON_NAME = "person_name";
    private final SQLiteDatabase mDb;

    public PersonDao(Context context) {
        ProjectListDaoHelper daoHelper = new ProjectListDaoHelper(context,TABLE_NAME_PROJECT,null,ProjectListDaoHelper.DATABASE_VERSION);
        mDb = daoHelper.getWritableDatabase();
    }


    //增加操作
    public long insert_person_table(String projectName,String personName)
    {
        /* ContentValues */
        ContentValues cv = new ContentValues();
        cv.put(PROJECT_NAME, projectName);
        cv.put(PERSON_NAME, personName);
        long row = mDb.insert(TABLE_NAME_PERSON, null, cv);
        return row;
    }

    public ArrayList<PersonBean> query_person(String targetProjectName){
        ArrayList<PersonBean> personList = new ArrayList<>();
        String[] selectColum = {PROJECT_NAME};
        String selectTion = "PROJECT_NAME = " + targetProjectName;
        Cursor cursor = mDb.query(TABLE_NAME_PERSON,selectColum,selectTion,null,null,null,null);
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
}
