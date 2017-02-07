package com.example.whankung.socialherb.activity;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Whankung on 5/2/2560.
 */

public class ConnectionClass {
    private String un, pass, db, ip;

    @SuppressLint("NewApi")
    public Connection connection() {
        ip = "172.19.131.73";
        db = "Andro";
        un = "Whan/Whankung";
        pass = "";


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConnectionURL = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
//        ConnectionURL = "jdbc:jtds:sqlserver://" + ip + ";"
//                    + "databaseName=" + db + ";user=" + un + ";password="
//                    + pass + ";";
            //jdbc:sqlserver://localhost\\SQL2008R2;databaseName=SocialHerb;user=sa;password=0000
            // ConnectionURL = "jdbc:jtds:sqlserver://172.19.53.151:1433/Andro;user=Whan\\Whankung;password=";
            ConnectionURL = "jdbc:jtds:sqlserver://172.19.53.151/SocialHerb;user=sa;password=1234";
            connection = DriverManager.getConnection(ConnectionURL);
        } catch (SQLException se) {
            Log.e("error here 1 : ", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("error here 2 : ", e.getMessage());
        } catch (Exception e) {
            Log.e("error here 3 : ", e.getMessage());
        }
        return connection;
    }
}
