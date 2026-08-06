package com.bytedance.tobshadow.bdtracker;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.tobshadow.applog.log.IAppLogLogger;
import java.util.Iterator;

/* renamed from: com.bytedance.tobshadow.bdtracker.r4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0507r4 extends SQLiteOpenHelper {

    /* renamed from: a */
    public final C0475n0 f978a;

    public C0507r4(C0475n0 c0475n0, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(c0475n0.m546b(), str, cursorFactory, i);
        this.f978a = c0475n0;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            Iterator<AbstractC0479n4> it = AbstractC0479n4.m569j().values().iterator();
            while (it.hasNext()) {
                String m572a = it.next().m572a();
                if (m572a != null) {
                    sQLiteDatabase.execSQL(m572a);
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        IAppLogLogger iAppLogLogger = this.f978a.f834d.f764D;
        Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
        iAppLogLogger.debug(5, "Database upgrade from:{} to:{}", objArr);
        try {
            sQLiteDatabase.beginTransaction();
            Iterator<AbstractC0479n4> it = AbstractC0479n4.m569j().values().iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + it.next().mo271f());
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            try {
                C0411e.m353a(sQLiteDatabase);
                onCreate(sQLiteDatabase);
            } catch (Throwable th) {
            }
        }
        C0411e.m353a(sQLiteDatabase);
        onCreate(sQLiteDatabase);
    }
}
