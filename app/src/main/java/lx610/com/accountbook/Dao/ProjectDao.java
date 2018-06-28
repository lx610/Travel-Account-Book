package lx610.com.accountbook.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import lx610.com.accountbook.bean.ProjectListBean;


public class ProjectDao {
    private final static String TABLE_NAME_PROJECT = "table_project";
    public final static String PROJECT_ID = "project_id";
    public final static String PROJECT_NAME = "project_name";
    public final static String PROJECT_CREAT_DATE = "project_creat_date";
    public final static String ID = "id";

    private final static String TABLE_NAME_PERSON = "person_table";
    public final static String  PERSON_NAME = "person_name";
    private final SQLiteDatabase mDb;

    public ProjectDao(Context context) {
        ProjectListDaoHelper daoHelper = new ProjectListDaoHelper(context,TABLE_NAME_PROJECT,null,ProjectListDaoHelper.DATABASE_VERSION);
        mDb = daoHelper.getWritableDatabase();
    }

    //增加操作
    public long insert_project_table(String projectName,String creat_time)
    {
        /* ContentValues */
        ContentValues cv = new ContentValues();
        cv.put(PROJECT_NAME, projectName);
        cv.put(PROJECT_CREAT_DATE, creat_time);
        long row = mDb.insert(TABLE_NAME_PROJECT, null, cv);
        return row;
    }

    public List<ProjectListBean> query_project(){
        List<ProjectListBean> projectList = new ArrayList<>();
        Cursor cursor = mDb.query(TABLE_NAME_PROJECT,null,null,null,null,null,null);
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
}
