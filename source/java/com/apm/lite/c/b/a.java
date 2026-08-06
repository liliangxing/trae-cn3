package com.apm.lite.c.b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.apm.lite.c;
import com.apm.lite.k.q;
import com.bytedance.crash.constants.Constants;
import java.util.HashMap;

/* loaded from: classes2.dex */
public abstract class a<T> {
    protected final String a = "_id";
    protected final String b;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(String str) {
        this.b = str;
    }

    protected abstract ContentValues a(T t);

    protected abstract HashMap<String, String> a();

    public void a(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ").append(this.b).append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            HashMap<String, String> a = a();
            if (a != null) {
                for (String str : a.keySet()) {
                    sb.append(str).append(" ").append(a.get(str)).append(",");
                }
                sb.delete(sb.length() - 1, sb.length());
                sb.append(")");
                sQLiteDatabase.execSQL(sb.toString());
            }
        } catch (Throwable th) {
            c.a();
            c.a(Constants.NPTH_CATCH, th);
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase, T t) {
        if (sQLiteDatabase == null || t == null) {
            return;
        }
        try {
            sQLiteDatabase.insert(this.b, null, a((a<T>) t));
        } catch (Throwable th) {
            q.b(th);
        }
    }
}
