package com.example.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.demo.greendao.DaoMaster;
import com.example.demo.greendao.DaoSession;
import com.example.demo.greendao.DbHelper;
import com.example.demo.greendao.R;
import com.example.demo.greendao.User;
import com.example.demo.greendao.UserDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //自定义dbHelper,数据库初始化
        DbHelper dbHelper = new DbHelper(this, "Demo.db");
        DaoMaster daoMaster1 = new DaoMaster(dbHelper.getWritableDb());
        DaoSession daoSession = daoMaster1.newSession();

        /*DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getApplicationContext(), "Demo.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();*/

        UserDao userDao = daoSession.getUserDao();
        User user = new User(null, "lihui", 12);
        userDao.insert(user);//添加数据
        //删除
        List<User> userList = userDao.queryBuilder().where(UserDao.Properties.Id.le(10)).build().list();//查询id小于等于10的数据
        for (User users : userList) {
            userDao.delete(users);
        }

        User users = userDao.queryBuilder().where(UserDao.Properties.Id.eq(16)).build().unique();//删除指定信息
        if (users == null) {
            Toast.makeText(MainActivity.this, "用户不存在", Toast.LENGTH_SHORT).show();
        } else {
            userDao.deleteByKey(users.getId());
        }
        //删除所有
        userDao.deleteAll();
        //修改信息
        User userG = userDao.queryBuilder()
                .where(UserDao.Properties.Id.ge(10), UserDao.Properties.Username.like("%90%")).build().unique();//id大于10
        if (users == null) {
            Toast.makeText(MainActivity.this, "用户不存在!", Toast.LENGTH_SHORT).show();
        } else {
            userG.setUsername("王五");
            userDao.update(userG);
        }

        List<User> list = userDao.queryBuilder()
                .where(UserDao.Properties.Id.between(2, 13)).limit(5).build().list();//id在2~13之间 5条数据
        for (int i = 0; i < list.size(); i++) {
            Log.d("google_lenve", "search: " + list.get(i).toString());
        }

    }
}
