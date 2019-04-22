<<<<<<< HEAD
package com.swish.eduin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    ModuleClass moduleclass;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private static final int DATABASE_VERSION = 5;

    private static final String DATABASE_NAME = "SchoolDB";

    private static final String TABLE_NAME = "schoolapp";

    private static final String SL_NO = "slno";

    private static final String NAME = "name";

    private static final String LOCATION = "location";

    private static final String AREA = "area";

    private static final String TYPE = "type";

    private static final String CATEGORY = "category";

    private static final String SYLLABUS = "syllabus";

    private static final String PH_NO = "phno";

    private static final String IMG= "img";

    private static final String ISFAV = "fav";

    private static final String CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + "("
            + SL_NO + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT," + LOCATION + " TEXT," + AREA + " TEXT," + TYPE + " TEXT,"
            + CATEGORY + " TEXT," + SYLLABUS + " TEXT," + PH_NO + " TEXT," + IMG + " TEXT ," + ISFAV + " BOOLEAN "+")";

    private static final String DROP_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String SELECT_QUERY = "SELECT * FROM " + TABLE_NAME;

   private static final String FAVORITE_TABLE = "fav_list";

  private static final String UPDATE_QUERY = "UPDATE "+ FAVORITE_TABLE ;

  private static final String CREATE_QUERY1= " CREATE TABLE " + FAVORITE_TABLE + "("
          + SL_NO + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT," + LOCATION + " TEXT," + AREA + " TEXT," + TYPE + " TEXT,"
        + CATEGORY + " TEXT," + SYLLABUS + " TEXT," + PH_NO + " TEXT," + ISFAV + " BOOLEAN " + ")";

    private static String[] columns = {SL_NO, NAME, LOCATION, AREA, TYPE, CATEGORY, SYLLABUS, PH_NO};

    ModuleClass moduleClass = new ModuleClass();

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        db.execSQL(CREATE_QUERY1);
        addDetails(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+TABLE_NAME);
        db.execSQL("DROP TABLE "+FAVORITE_TABLE);
        onCreate(db);
    }



    public void addDetails(SQLiteDatabase database) {
     // SQLiteDatabase database = this.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put(NAME, "AQUA SWIMMING ACADEMY");
        value.put(LOCATION, "South");
        value.put(AREA, "Vinoba road");
        value.put(TYPE, "Institute");
        value.put(CATEGORY, "Sports");
        value.put(PH_NO, "9738460417");
        value.put(ISFAV,0);
        database.insert(TABLE_NAME, null, value);
        database.insert(FAVORITE_TABLE, null, value);


        ContentValues value1 = new ContentValues();
        value1.put(NAME, "ART PLANET");
        value1.put(LOCATION, "South");
        value1.put(AREA, "Kuvempu Nagar");
        value1.put(TYPE, "Institute");
        value1.put(CATEGORY, "Drawing,Painting,Music,Dancing");
        value1.put(PH_NO, "08722799997");
        value1.put(ISFAV,0);
        database.insert(TABLE_NAME, null, value1);
        database.insert(FAVORITE_TABLE, null, value1);


        ContentValues value2 = new ContentValues();
        value2.put(NAME, "Bollywood Studio");
        value2.put(LOCATION, "South");
        value2.put(AREA, "Lakshmipuram");
        value2.put(TYPE, "Institue");
        value2.put(CATEGORY, "Dancing,Music");
        value2.put(PH_NO, "08212331668");
        value2.put(ISFAV,0);
        database.insert(TABLE_NAME, null, value2);
        database.insert(FAVORITE_TABLE, null, value2);



        ContentValues value3 = new ContentValues();
        value3.put(NAME, "Champaka Academy");
        value3.put(LOCATION, "South");
        value3.put(AREA, "Ramakrishna nagara");
        value3.put(TYPE, "Institute");
        value3.put(CATEGORY, "Music,Dancing,Drawing,Acting");
        value3.put(PH_NO, "08212340305");
        value3.put(ISFAV,0);
        database.insert(TABLE_NAME, null, value3);
        database.insert(FAVORITE_TABLE, null, value3);



        ContentValues value4 = new ContentValues();
        value4.put(NAME, "GSS School of music and technology");
        value4.put(LOCATION, "North");
        value4.put(AREA, "Kuvempu Nagar");
        value4.put(TYPE, "Institute");
        value4.put(CATEGORY, "Music");
        value4.put(PH_NO, "08197236500");
        value4.put(ISFAV,0);
        database.insert(TABLE_NAME, null, value4);
        database.insert(FAVORITE_TABLE, null, value4);



        ContentValues value5 = new ContentValues();
        value5.put(NAME, "T.I.M.E");
        value5.put(LOCATION, "North");
        value5.put(AREA, "Vijayanagar");
        value5.put(TYPE, "Institute");
        value5.put(CATEGORY, "Tutorials,Abacus");
        value5.put(PH_NO, "08123572551");
        value5.put(ISFAV,0);
        database.insert(TABLE_NAME, null, value5);
        database.insert(FAVORITE_TABLE, null, value5);



        ContentValues value6 = new ContentValues();
        value6.put(NAME, "SIP Abacus Academy");
        value6.put(LOCATION, "North");
        value6.put(AREA, "Banashankari");
        value6.put(TYPE, "Institute");
        value6.put(CATEGORY, "Abacus,Tutorials");
        value6.put(PH_NO, "9167895570");
        value6.put(ISFAV,0);
        database.insert(TABLE_NAME, null, value6);
        database.insert(FAVORITE_TABLE, null, value6);



        ContentValues value7 = new ContentValues();
        value7.put(NAME, "Curiocity-School of creative art and design");
        value7.put(LOCATION, "North");
        value7.put(AREA, "Narasimha mohala");
        value7.put(TYPE, "Institute");
        value7.put(CATEGORY, "Music,Dancing,Drawing,Acting,Drama");
        value7.put(PH_NO, "91352789767");
        value7.put(ISFAV,0);
        database.insert(TABLE_NAME, null, value7);
        database.insert(FAVORITE_TABLE, null, value7);



        ContentValues value8 = new ContentValues();
        value8.put(NAME, "All Stars Basketball Academy");
        value8.put(LOCATION, "North");
        value8.put(AREA, "JP Nagar");
        value8.put(TYPE, "Institute");
        value8.put(CATEGORY, "Sports");
        value8.put(PH_NO, "9611662111");
        value8.put(ISFAV,0);
        database.insert(TABLE_NAME, null, value8);
        database.insert(FAVORITE_TABLE, null, value8);



        ContentValues value9 = new ContentValues();
        value9.put(NAME, "Kalaspandana");
        value9.put(LOCATION, "North");
        value9.put(AREA, "Lakshmipuram");
        value9.put(TYPE, "Institute");
        value9.put(CATEGORY, "Music,Dancing,Acting");
        value9.put(PH_NO, "9152574920");
        value9.put(ISFAV,0);
        database.insert(TABLE_NAME, null, value9);
        database.insert(FAVORITE_TABLE, null, value9);



        ContentValues values = new ContentValues();
        values.put(NAME, "MALAD CAMPUS");
        values.put(LOCATION, "North");
        values.put(AREA, "Marve Road");
        values.put(TYPE, "School");
        values.put(CATEGORY, "Nursery");
        values.put(CATEGORY,"Primary");
        values.put(CATEGORY, "Highschool");
        values.put(SYLLABUS, "Icse");
        values.put(SYLLABUS, "Cbse");
        values.put(SYLLABUS, "State");
        values.put(PH_NO, "7777016450");
        values.put(ISFAV,0);
        database.insert(TABLE_NAME, null, values);
        database.insert(FAVORITE_TABLE, null, values);


        ContentValues values1 = new ContentValues();
        values1.put(NAME, "BORIVALLI CAMPUS");
        //values1.put(LOCATION, "Plot no 3/3A R.S.C-5,opp Sridarshan Society,Haridas nagar,Borivali west,Mumbai-400092");
        values1.put(LOCATION, "North");
        values1.put(AREA, "Haridas nagar");
        values1.put(TYPE, "school");
        values1.put(CATEGORY, "Nursery");
        values1.put(CATEGORY, "Primary");
        values1.put(CATEGORY, "Highschool");
        values1.put(SYLLABUS, "Icse");
        values1.put(SYLLABUS,"Cbse");
        values1.put(PH_NO, "8454015666");
        values1.put(ISFAV,0);
        database.insert(TABLE_NAME, null, values1);
        database.insert(FAVORITE_TABLE, null, values1);

        ContentValues values2 = new ContentValues();
        values2.put(NAME, "ORCHIDS THE INTERNATIONAL SCHOOL");
        values2.put(LOCATION, "North");
        values2.put(AREA, "Samuel Street");
        values2.put(TYPE, "school");
        values2.put(CATEGORY, "Nursery");
        values2.put(CATEGORY, "Primary");
        values2.put(SYLLABUS, "Icse");
        values2.put(SYLLABUS, "State");
        values2.put(PH_NO, "022-65017104");
        values2.put(ISFAV,0);
        database.insert(TABLE_NAME, null, values2);
        database.insert(FAVORITE_TABLE, null, values2);

        ContentValues values3 = new ContentValues();
        values3.put(NAME, "DSB INTERNATIONAL SCHOOL");
        values3.put(LOCATION, "North");
        values3.put(AREA, "Kumballa hill");
        values3.put(TYPE, "school");
        values3.put(CATEGORY, "Nursery");
        values3.put(CATEGORY, "Primary");
        values3.put(CATEGORY, "Highschool");
        values3.put(SYLLABUS, "Cbse");
        values3.put(PH_NO, "022-23620110");
        values3.put(ISFAV,0);
        database.insert(TABLE_NAME, null, values3);
        database.insert(FAVORITE_TABLE, null, values3);

        ContentValues values4 = new ContentValues();
        values4.put(NAME, "BOMBAY SCOTTISH SCHOOL");
        values4.put(LOCATION, "North");
        values4.put(AREA, "Powai");
        values4.put(TYPE, "school");
        values4.put(CATEGORY, "Primary");
        values4.put(CATEGORY, "Highschool");
        values4.put(SYLLABUS, "Icse");
        values4.put(SYLLABUS, "Cbse");
        values4.put(SYLLABUS, "State");
        values4.put(PH_NO, "022-28573205");
        values4.put(ISFAV,0);
        database.insert(TABLE_NAME, null, values4);
        database.insert(FAVORITE_TABLE, null, values4);

        ContentValues values5 = new ContentValues();
        values5.put(NAME, "BACHPAN PLAY SCHOOL");
        values5.put(LOCATION, "South");
        values5.put(AREA, "N.R Mohalla");
        values5.put(TYPE, "school");
        values5.put(CATEGORY, "Nursery");
        values5.put(CATEGORY, "Primary");
        values5.put(SYLLABUS, "Icse");
        values5.put(SYLLABUS, "Cbse");
        values5.put(SYLLABUS, "State");
        values5.put(PH_NO, "08214244805");
        values5.put(ISFAV,0);
        database.insert(TABLE_NAME, null, values5);
        database.insert(FAVORITE_TABLE, null, values5);

        ContentValues values6 = new ContentValues();
        values6.put(NAME, "KANGAROO KIDS CLUB(Preschool and Day-care)");
        values6.put(LOCATION, "South");
        values6.put(AREA, "T.K Layout");
        values6.put(TYPE, "school");
        values6.put(CATEGORY, "Nursery");
        values6.put(SYLLABUS, "State");
        values6.put(PH_NO, "09108656644");
        values6.put(ISFAV,0);
        database.insert(TABLE_NAME, null, values6);
        database.insert(FAVORITE_TABLE, null, values6);

        ContentValues values7 = new ContentValues();
        values7.put(NAME, "KIDS CAMPUS");
        values7.put(LOCATION, "South");
        values7.put(AREA, "Gokulam");
        values7.put(TYPE, "school");
        values7.put(CATEGORY, "Nursery");
        values7.put(CATEGORY, "Primary");
        values7.put(SYLLABUS, "Icse");
        values7.put(SYLLABUS, "Cbse");
        values7.put(PH_NO, "09900923479");
        values7.put(ISFAV,0);
        database.insert(TABLE_NAME, null, values7);
        database.insert(FAVORITE_TABLE, null, values7);

        ContentValues values8 = new ContentValues();
        values8.put(NAME, "TOM and JERRY PLAY HOME");
        values8.put(LOCATION, "South");
        values8.put(AREA, "BMT road");
        values8.put(TYPE, "school");
        values8.put(CATEGORY, "Nursery");
        values8.put(SYLLABUS, "Icse");
        values8.put(SYLLABUS, "State");
        values8.put(PH_NO, "08212342134");
        values8.put(ISFAV,0);
        database.insert(TABLE_NAME, null, values8);
        database.insert(FAVORITE_TABLE, null, values8);

        ContentValues values9 = new ContentValues();
        values9.put(NAME, "KIDDIE LAND");
        values9.put(LOCATION, "South");
        values9.put(AREA, "Jayalakshmipuram");
        values9.put(TYPE, "school");
        values9.put(CATEGORY, "Nursery");
        values9.put(SYLLABUS, "State");
        values9.put(PH_NO, "23118976");
        values9.put(ISFAV,0);
        database.insert(TABLE_NAME, null, values9);
        database.insert(FAVORITE_TABLE, null, values9);

    }

    public ArrayList<ModuleClass> retriveData(String type) {
        SQLiteDatabase database = this.getWritableDatabase();
        ArrayList<ModuleClass> arrayList = new ArrayList<>();
//    Cursor cursor = database.rawQuery("SELECT  * FROM " + TABLE_NAME + " WHERE type = "+type, null);
        Cursor cursor = database.query(TABLE_NAME, columns, "type=?", new String[]{type}, null, null, null);

        if (cursor.moveToFirst())
        //adding a contact to list
        {
            for (int i = 0; i < cursor.getCount(); i++) {
                ModuleClass moduleclass = new ModuleClass();//import line of code
                moduleclass.Slno = Integer.parseInt(cursor.getString(0));
                moduleclass.name = (cursor.getString(1));
                moduleclass.location = (cursor.getString(2));
                moduleclass.area = (cursor.getString(3));
                moduleclass.type = (cursor.getString(4));
                moduleclass.category = (cursor.getString(5));
                moduleclass.syllabus = (cursor.getString(6));
                moduleclass.phno = (cursor.getString(7));
                arrayList.add(moduleclass);
                cursor.moveToNext();
            }
        }
        cursor.close();
        database.close();
        return arrayList;
    }

    public ArrayList<ModuleClass> retriveData(String Location, String Syallabus, String Category) {
        SQLiteDatabase database = this.getWritableDatabase();
        ArrayList<ModuleClass> arrayList = new ArrayList<>();
        Cursor cursor = database.rawQuery("select * from " + TABLE_NAME + " where Location = " + Location + ",where Syallabus= " + Syallabus + ",where Category=" + Category, null);
        if (cursor.moveToFirst())
        //adding a contact to list
        {
            for (int i = 0; i < cursor.getCount(); i++) {
                ModuleClass moduleclass = new ModuleClass();//import line of code
                moduleclass.Slno = Integer.parseInt(cursor.getString(0));
                moduleclass.name = (cursor.getString(1));
                moduleclass.location = (cursor.getString(2));
                moduleclass.area = (cursor.getString(3));
                moduleclass.type = (cursor.getString(4));
                moduleclass.category = (cursor.getString(5));
                moduleclass.syllabus = (cursor.getString(6));
                moduleclass.phno = (cursor.getString(7));

                arrayList.add(moduleclass);
                cursor.moveToNext();
            }
        }
        cursor.close();
        database.close();
        return arrayList;
    }

    public ArrayList<ModuleClass>  retriveData1(int location){
        SQLiteDatabase database = this.getWritableDatabase();
        ArrayList<ModuleClass> arrList=new ArrayList<>();
        Cursor cur = database.rawQuery("select * from "+ TABLE_NAME +" where slno = "+ location ,null);
        if(cur.moveToFirst())
        {
            for (int i=0; i < cur.getCount(); i++){
                ModuleClass modClass=new ModuleClass();
                modClass.Slno=Integer.parseInt(cur.getString(0));
                modClass.name = (cur.getString(1));
                modClass.location = (cur.getString(2));
                modClass.area = (cur.getString(3));
                modClass.type = (cur.getString(4));
                modClass.category = (cur.getString(5));
                modClass.syllabus = (cur.getString(6));
                modClass.phno = (cur.getString(7));

                arrList.add(modClass);
            }
        }
        cur.close();
        database.close();
        return arrList;
    }

    public  void addToFavorites(String favData)
    {
        SQLiteDatabase database= getReadableDatabase();
        String query = String.format("INSERT INFO Favorites(favData) VALUES('%S');",favData);
    }
    public  void removeFromFavorites(String favData)
    {
        SQLiteDatabase database= getReadableDatabase();
        String query = String.format("DELETE FROM Favorites WHERE  favData='%s';",favData);
    }

    public boolean isfavorite(String favData)
    {


            SQLiteDatabase database= getReadableDatabase();
            String query = String.format("SELECT * FROM Favorites WHERE favData='%s';",favData);
            Cursor cursor = database.rawQuery(query,null);
            if(cursor.getCount() <= 0)
            {
                cursor.close();
                return false;
            }
            cursor.close();
            return true;
        }


    public ArrayList<ModuleClass> favretriveData(int mySlNo) {
        SQLiteDatabase database = this.getWritableDatabase();
        ArrayList<ModuleClass> arrayList = new ArrayList<>();
       //Cursor cursor = database.rawQuery("SELECT  * FROM " + TABLE_NAME + " WHERE type = "+type, null);
        String query="UPDATE "+FAVORITE_TABLE + " SET " + ISFAV+" = 1 WHERE slno = "+mySlNo;
        database.execSQL(query);
        database.close();
        return arrayList;
    }
    public ArrayList<ModuleClass> favoritelist() {
        SQLiteDatabase database = this.getWritableDatabase();        Cursor cursor = database.rawQuery(" SELECT  * FROM " + FAVORITE_TABLE + " WHERE fav = 1", null);

        ArrayList<ModuleClass> arrayList = new ArrayList<>();
        if (cursor.moveToFirst())

        //adding a contact to list
        {
            for (int i = 0; i < cursor.getCount(); i++) {
                ModuleClass moduleclass = new ModuleClass();//import line of code
                moduleclass.Slno = Integer.parseInt(cursor.getString(0));
                moduleclass.name = (cursor.getString(1));
                moduleclass.location = (cursor.getString(2));
                moduleclass.area = (cursor.getString(3));
                moduleclass.type = (cursor.getString(4));
                moduleclass.category = (cursor.getString(5));
                moduleclass.syllabus = (cursor.getString(6));
                moduleclass.phno = (cursor.getString(7));

                arrayList.add(moduleclass);
                cursor.moveToNext();
            }
        }
        cursor.close();
        database.close();
        return arrayList;
    }
    public List<ModuleClass> getAllNotes(String location, String syallabus, String category) {
        List<ModuleClass> filter = new ArrayList<>();

        // Select All Query
        //String selectQuery = "SELECT  * FROM " + FilterClass.TABLE_NAME + " ORDER BY " +
        //FilterClass.CATEGORY + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE location = '" + location + "' AND syllabus= '" + syallabus + "' AND  category = '" + category + "'", null);


        // looping through all rows and adding to list
        Log.e("Row Count",cursor.getCount()+"");
        if (cursor.moveToFirst()) {
            do {
               FilterClass filterClass = new FilterClass();
              filterClass.setLocation(cursor.getString(cursor.getColumnIndex(FilterClass.LOCATION)));
             //filterClass.setSyllabus(cursor.getString(cursor.getColumnIndex(FilterClass.SYLLABUS)));
             // filterClass.setCategory(cursor.getString(cursor.getColumnIndex(FilterClass.CATEGORY)));

                ModuleClass moduleClass=new ModuleClass();
                moduleClass.setName(cursor.getString(cursor.getColumnIndex(FilterClass.NAME)));
                moduleClass.setLocation(cursor.getString(cursor.getColumnIndex(FilterClass.LOCATION)));
                moduleClass.setPhno(cursor.getString(cursor.getColumnIndex(FilterClass.PH_NO)));

                filter.add(moduleClass);



                //New Code
                Log.e("Values :", cursor.getString(cursor.getColumnIndex(FilterClass.LOCATION)));
            } while (cursor.moveToNext());
        }

        cursor.close();

        // close db connection
        db.close();

        // return notes list
        return filter;
    }


}

=======
package com.swish.eduin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    ModuleClass moduleclass;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private static final int DATABASE_VERSION = 3;

    private static final String DATABASE_NAME = "SchoolDB";

    private static final String TABLE_NAME = "schoolapp";

    private static final String SL_NO = "slno";

    private static final String NAME = "name";

    private static final String LOCATION = "location";

    private static final String AREA = "area";

    private static final String TYPE = "type";

    private static final String CATEGORY = "category";

    private static final String SYLLABUS = "syllabus";

    private static final String PH_NO = "phno";

    private static final String CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + "("
            + SL_NO + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT," + LOCATION + " TEXT," + AREA + " TEXT," + TYPE + " TEXT,"
            + CATEGORY + " TEXT," + SYLLABUS + " TEXT," + PH_NO + " TEXT"  + ")";

    private static final String DROP_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String SELECT_QUERY = "SELECT * FROM " + TABLE_NAME;

    private static String[] columns = {SL_NO, NAME, LOCATION, AREA, TYPE, CATEGORY, SYLLABUS, PH_NO};

    ModuleClass moduleClass = new ModuleClass();

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        addDetails(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_QUERY);
        onCreate(db);
    }

    public void addDetails(SQLiteDatabase database) {
//        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put(NAME, "AQUA SWIMMING ACADEMY");
        value.put(LOCATION, "South");
        value.put(AREA, "Vinoba road");
        value.put(TYPE, "Institute");
        value.put(CATEGORY, "Sports");
        value.put(PH_NO, "9738460417");
        database.insert(TABLE_NAME, null, value);


        ContentValues value1 = new ContentValues();
        value1.put(NAME, "ART PLANET");
        value1.put(LOCATION, "South");
        value1.put(AREA, "Kuvempu Nagar");
        value1.put(TYPE, "Institute");
        value1.put(CATEGORY, "Drawing,Painting,Music,Dancing");
        value1.put(PH_NO, "08722799997");
        database.insert(TABLE_NAME, null, value1);


        ContentValues value2 = new ContentValues();
        value2.put(NAME, "Bollywood Studio");
        value2.put(LOCATION, "South");
        value2.put(AREA, "Lakshmipuram");
        value2.put(TYPE, "Institue");
        value2.put(CATEGORY, "Dancing,Music");
        value2.put(PH_NO, "08212331668");
        database.insert(TABLE_NAME, null, value2);


        ContentValues value3 = new ContentValues();
        value3.put(NAME, "Champaka Academy");
        value3.put(LOCATION, "South");
        value3.put(AREA, "Ramakrishna nagara");
        value3.put(TYPE, "Institute");
        value3.put(CATEGORY, "Music,Dancing,Drawing,Acting");
        value3.put(PH_NO, "08212340305");
        database.insert(TABLE_NAME, null, value3);


        ContentValues value4 = new ContentValues();
        value4.put(NAME, "GSS School of music and technology");
        value4.put(LOCATION, "North");
        value4.put(AREA, "Kuvempu Nagar");
        value4.put(TYPE, "Institute");
        value4.put(CATEGORY, "Music");
        value4.put(PH_NO, "08197236500");
        database.insert(TABLE_NAME, null, value4);


        ContentValues value5 = new ContentValues();
        value5.put(NAME, "T.I.M.E");
        value5.put(LOCATION, "North");
        value5.put(AREA, "Vijayanagar");
        value5.put(TYPE, "Institute");
        value5.put(CATEGORY, "Tutorials,Abacus");
        value5.put(PH_NO, "08123572551");
        database.insert(TABLE_NAME, null, value5);


        ContentValues value6 = new ContentValues();
        value6.put(NAME, "SIP Abacus Academy");
        value6.put(LOCATION, "North");
        value6.put(AREA, "Banashankari");
        value6.put(TYPE, "Institute");
        value6.put(CATEGORY, "Abacus,Tutorials");
        value6.put(PH_NO, "9167895570");
        database.insert(TABLE_NAME, null, value6);


        ContentValues value7 = new ContentValues();
        value7.put(NAME, "Curiocity-School of creative art and design");
        value7.put(LOCATION, "North");
        value7.put(AREA, "Narasimha mohala");
        value7.put(TYPE, "Institute");
        value7.put(CATEGORY, "Music,Dancing,Drawing,Acting,Drama");
        value7.put(PH_NO, "91352789767");
        database.insert(TABLE_NAME, null, value7);


        ContentValues value8 = new ContentValues();
        value8.put(NAME, "All Stars Basketball Academy");
        value8.put(LOCATION, "North");
        value8.put(AREA, "JP Nagar");
        value8.put(TYPE, "Institute");
        value8.put(CATEGORY, "Sports");
        value8.put(PH_NO, "9611662111");
        database.insert(TABLE_NAME, null, value8);


        ContentValues value9 = new ContentValues();
        value9.put(NAME, "Kalaspandana");
        value9.put(LOCATION, "North");
        value9.put(AREA, "Lakshmipuram");
        value9.put(TYPE, "Institute");
        value9.put(CATEGORY, "Music,Dancing,Acting");
        value9.put(PH_NO, "9152574920");
        database.insert(TABLE_NAME, null, value9);


        ContentValues values = new ContentValues();
        values.put(NAME, "MALAD CAMPUS");
        values.put(LOCATION, "North");
        values.put(AREA, "Marve Road");
        values.put(TYPE, "School");
        values.put(CATEGORY, "Nursery");
        values.put(CATEGORY,"Primary");
        values.put(CATEGORY,"Highschool");
        values.put(SYLLABUS, "Icse");
        values.put(SYLLABUS, "Cbse");
        values.put(SYLLABUS, "State");
        values.put(PH_NO, "7777016450");
        database.insert(TABLE_NAME, null, values);

        ContentValues values1 = new ContentValues();
        values1.put(NAME, "BORIVALLI CAMPUS");
        values1.put(LOCATION, "North");
        values1.put(AREA, "Haridas nagar");
        values1.put(TYPE, "school");
        values1.put(CATEGORY, "Nursery");
        values1.put(CATEGORY, "Primary");
        values1.put(CATEGORY, "Highschool");
        values1.put(SYLLABUS, "Icse");
        values1.put(SYLLABUS,"Cbse");
        values1.put(PH_NO, "8454015666");
        database.insert(TABLE_NAME, null, values1);

        ContentValues values2 = new ContentValues();
        values2.put(NAME, "ORCHIDS THE INTERNATIONAL SCHOOL");
        values2.put(LOCATION, "North");
        values2.put(AREA, "Samuel Street");
        values2.put(TYPE, "school");
        values2.put(CATEGORY, "Nursery");
        values2.put(CATEGORY,"Primary");
        values2.put(SYLLABUS, "Icse");
        values2.put(SYLLABUS, "State");
        values2.put(PH_NO, "022-65017104");
        database.insert(TABLE_NAME, null, values2);

        ContentValues values3 = new ContentValues();
        values3.put(NAME, "DSB INTERNATIONAL SCHOOL");
        values3.put(LOCATION, "North");
        values3.put(AREA, "Kumballa hill");
        values3.put(TYPE, "school");
        values3.put(CATEGORY, "Nursery");
        values3.put(CATEGORY, "Primary");
        values3.put(CATEGORY, "Highschool");
        values3.put(SYLLABUS, "Cbse");
        values3.put(PH_NO, "022-23620110");
        database.insert(TABLE_NAME, null, values3);

        ContentValues values4 = new ContentValues();
        values4.put(NAME, "BOMBAY SCOTTISH SCHOOL");
        values4.put(LOCATION, "North");
        values4.put(AREA, "Powai");
        values4.put(TYPE, "school");
        values4.put(CATEGORY, "Primary");
        values4.put(CATEGORY, "Highschool");
        values4.put(SYLLABUS, "Icse");
        values4.put(SYLLABUS, "Cbse");
        values4.put(SYLLABUS, "State");
        values4.put(PH_NO, "022-28573205");
        database.insert(TABLE_NAME, null, values4);

        ContentValues values5 = new ContentValues();
        values5.put(NAME, "BACHPAN PLAY SCHOOL");
        values5.put(LOCATION, "South");
        values5.put(AREA, "N.R Mohalla");
        values5.put(TYPE, "school");
        values5.put(CATEGORY, "Nursery");
        values5.put(CATEGORY, "Primary");
        values5.put(SYLLABUS, "Icse");
        values5.put(SYLLABUS, "Cbse");
        values5.put(SYLLABUS, "State");
        values5.put(PH_NO, "08214244805");
        database.insert(TABLE_NAME, null, values5);

        ContentValues values6 = new ContentValues();
        values6.put(NAME, "KANGAROO KIDS CLUB(Preschool and Day-care)");
        values6.put(LOCATION, "South");
        values6.put(AREA, "T.K Layout");
        values6.put(TYPE, "school");
        values6.put(CATEGORY, "Nursery");
        values6.put(SYLLABUS, "State");
        values6.put(PH_NO, "09108656644");
        database.insert(TABLE_NAME, null, values6);

        ContentValues values7 = new ContentValues();
        values7.put(NAME, "KIDS CAMPUS");
        values7.put(LOCATION, "South");
        values7.put(AREA, "Gokulam");
        values7.put(TYPE, "school");
        values7.put(CATEGORY, "Nursery");
        values7.put(CATEGORY, "Primary");
        values7.put(SYLLABUS, "Icse");
        values7.put(SYLLABUS, "Cbse");
        values7.put(PH_NO, "09900923479");
        database.insert(TABLE_NAME, null, values7);

        ContentValues values8 = new ContentValues();
        values8.put(NAME, "TOM and JERRY PLAY HOME");
        values8.put(LOCATION, "South");
        values8.put(AREA, "BMT road");
        values8.put(TYPE, "school");
        values8.put(CATEGORY, "Nursery");
        values8.put(SYLLABUS, "Icse");
        values8.put(SYLLABUS, "State");
        values8.put(PH_NO, "08212342134");
        database.insert(TABLE_NAME, null, values8);

        ContentValues values9 = new ContentValues();
        values9.put(NAME, "KIDDIE LAND");
        values9.put(LOCATION, "South");
        values9.put(AREA, "Jayalakshmipuram");
        values9.put(TYPE, "school");
        values9.put(CATEGORY, "Nursery");
        values9.put(SYLLABUS, "State");
        values9.put(PH_NO, "23118976");
        database.insert(TABLE_NAME, null, values9);


    }

    public ArrayList<ModuleClass> retriveData(String type) {
        SQLiteDatabase database = this.getWritableDatabase();
        ArrayList<ModuleClass> arrayList = new ArrayList<>();
//        Cursor cursor = database.rawQuery("SELECT  * FROM " + TABLE_NAME + " WHERE type = "+type, null);
        Cursor cursor = database.query(TABLE_NAME, columns, "type=?", new String[]{type}, null, null, null);

        if (cursor.moveToFirst())
        //adding a contact to list
        {
            for (int i = 0; i < cursor.getCount(); i++) {
                ModuleClass moduleclass = new ModuleClass();//import line of code
                moduleclass.Slno = Integer.parseInt(cursor.getString(0));
                moduleclass.name = (cursor.getString(1));
                moduleclass.location = (cursor.getString(2));
                moduleclass.area = (cursor.getString(3));
                moduleclass.type = (cursor.getString(4));
                moduleclass.category = (cursor.getString(5));
                moduleclass.syllabus = (cursor.getString(6));
                moduleclass.phno = (cursor.getString(7));
                arrayList.add(moduleclass);
                cursor.moveToNext();
            }
        }
        cursor.close();
        database.close();
        return arrayList;
    }

    public List<ModuleClass> getAllNotes(String location, String syallabus, String category) {
        List<ModuleClass> filter = new ArrayList<>();

        // Select All Query
        //String selectQuery = "SELECT  * FROM " + FilterClass.TABLE_NAME + " ORDER BY " +
                //FilterClass.CATEGORY + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE location = '" + location + "' AND syllabus= '" + syallabus + "' AND  category = '" + category + "'", null);


        // looping through all rows and adding to list
        Log.e("Row Count",cursor.getCount()+"");
        if (cursor.moveToFirst()) {
            do {
//                FilterClass filterClass = new FilterClass();
//                filterClass.setLocation(cursor.getString(cursor.getColumnIndex(FilterClass.LOCATION)));
//                filterClass.setSyllabus(cursor.getString(cursor.getColumnIndex(FilterClass.SYLLABUS)));
//                filterClass.setCategory(cursor.getString(cursor.getColumnIndex(FilterClass.CATEGORY)));

                ModuleClass moduleClass=new ModuleClass();
                moduleClass.setName(cursor.getString(cursor.getColumnIndex(FilterClass.NAME)));
                moduleClass.setLocation(cursor.getString(cursor.getColumnIndex(FilterClass.LOCATION)));
                moduleClass.setPhno(cursor.getString(cursor.getColumnIndex(FilterClass.PH_NO)));

                filter.add(moduleClass);



                //New Code
                Log.e("Values :", cursor.getString(cursor.getColumnIndex(FilterClass.LOCATION)));
            } while (cursor.moveToNext());
        }

        cursor.close();

        // close db connection
        db.close();

        // return notes list
        return filter;
    }

    public ArrayList<String> searchData() {
        SQLiteDatabase database = this.getWritableDatabase();
        ArrayList<String> arrayList = new ArrayList<>();
        Cursor cursor = database.rawQuery(" SELECT * FROM " + TABLE_NAME,null);

        if (cursor.moveToFirst())
        //adding a contact to list
        {
            for (int i = 0; i < cursor.getCount(); i++) {
//                ModuleClass moduleclass = new ModuleClass();//import line of code
//                moduleclass.Slno = Integer.parseInt(cursor.getString(0));
//                moduleclass.name = (cursor.getString(1));
//                moduleclass.location = (cursor.getString(2));
//                moduleclass.area = (cursor.getString(3));
//                moduleclass.type = (cursor.getString(4));
//                moduleclass.category = (cursor.getString(5));
//                moduleclass.syllabus = (cursor.getString(6));
//                moduleclass.phno = (cursor.getString(7));
//                arrayList.add(moduleclass);
                arrayList.add(cursor.getString(1));
                cursor.moveToNext();
            }
        }
        cursor.close();
        database.close();
        return arrayList;
    }


}
>>>>>>> origin/master
