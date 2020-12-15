package com.example.sqlitetry2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MyDBHandler extends SQLiteOpenHelper {
    public static final int DB_VERSION =2;
    private static final String DB_NAME = "exampe.db";
    private static String DB_PATH = "/data/user/0/com.example.sqlitetry2/databases/";
    SQLiteDatabase myDatabase;
    private final Context mContext;



    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
        this.mContext= context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("increate");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

    private boolean checkDatabase(){
        try{
            final String mPath = DB_PATH + DB_NAME;
            final File file = new File(mPath);
            if(file.exists())
                return true;
                else
                    return false;

        }catch (SQLiteException e){
            e.printStackTrace();
            return false;
        }

    }

    private void copyDatabase() throws IOException{
        try{
            InputStream mInputStream = mContext.getAssets().open(DB_NAME);
            String outFileName = DB_PATH + DB_NAME;
            OutputStream mOutputStream = new FileOutputStream(outFileName);

            byte[] buffer = new byte [1024];
            int length;
            while ((length = mInputStream.read(buffer))> 0){
                mOutputStream.write(buffer, 0, length);
            }
            mOutputStream.flush();
            mOutputStream.close();
            mInputStream.close();

        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public void createDatabase() throws IOException{
        boolean mDatabaseExists = checkDatabase();
        if(!mDatabaseExists){
            this.getReadableDatabase();
            this.close();
            try{
                copyDatabase();


            }catch(IOException mIOException){
                mIOException.printStackTrace();
                throw new Error("Error copying Database");
            } finally {
                this.close();
            }
        }
    }

    @Override
    public synchronized void close(){
        if(myDatabase != null)
            myDatabase.close();
        SQLiteDatabase.releaseMemory();
        super.close();
    }

    public String loadHandler(){
        System.out.println("test1 ");
        try{
            createDatabase();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("test2 ");
        String result = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from internship", null);
        System.out.println("test3");

       while (c.moveToNext())
        {
            System.out.println("result "+ result);
            int result_id = c.getInt(0);
            String result_title = c.getString(1);
            int result_fullTime = c.getType(2);
            int result_wage = c.getInt(3);
            result += String.valueOf(result_id) + " " + result_title + " " + result_fullTime + " " + result_wage + System.getProperty("line.separator");
        }
        c.close();
        db.close();

        return result;
    }
}
