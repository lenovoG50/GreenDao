package com.example.demo.greendao;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

/**
 * 数据库升级可以用到
 * Created by 59246 on 2018/3/18.
 */

public class DbHelper extends DaoMaster.OpenHelper {
    public static final String DBNAME = "Demo.db";


    public DbHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }
}
