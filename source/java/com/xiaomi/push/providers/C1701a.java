package com.xiaomi.push.providers;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.Constants;

/* renamed from: com.xiaomi.push.providers.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1701a extends SQLiteOpenHelper {

    /* renamed from: a */
    private static int f2829a = 1;

    /* renamed from: a */
    public static final Object f2830a = new Object();

    /* renamed from: a */
    private static final String[] f2831a = {Constants.PACKAGE_NAME, "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", "network_type", " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", "imsi", "TEXT"};

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public C1701a(Context context) {
        super(context, "traffic.db", (SQLiteDatabase.CursorFactory) null, f2829a);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (f2830a) {
            try {
                m3460a(sQLiteDatabase);
            } catch (SQLException e) {
                AbstractC1417b.m1093a(e);
            }
        }
    }

    /* renamed from: a */
    private void m3460a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
        int i = 0;
        while (true) {
            String[] strArr = f2831a;
            if (i < strArr.length - 1) {
                if (i != 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(strArr[i]).append(" ").append(strArr[i + 1]);
                i += 2;
            } else {
                sb.append(");");
                sQLiteDatabase.execSQL(sb.toString());
                return;
            }
        }
    }
}
