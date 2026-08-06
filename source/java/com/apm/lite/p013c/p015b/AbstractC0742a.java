package com.apm.lite.p013c.p015b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.apm.lite.C0738c;
import com.apm.lite.p023k.C0794q;
import java.util.HashMap;

/* renamed from: com.apm.lite.c.b.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class AbstractC0742a<T> {

    /* renamed from: a */
    protected final String f398a = "_id";

    /* renamed from: b */
    protected final String f399b;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0742a(String str) {
        this.f399b = str;
    }

    /* renamed from: a */
    protected abstract ContentValues mo444a(T t);

    /* renamed from: a */
    protected abstract HashMap<String, String> mo445a();

    /* renamed from: a */
    public void m446a(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ").append(this.f399b).append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            HashMap<String, String> mo445a = mo445a();
            if (mo445a != null) {
                for (String str : mo445a.keySet()) {
                    sb.append(str).append(" ").append(mo445a.get(str)).append(",");
                }
                sb.delete(sb.length() - 1, sb.length());
                sb.append(")");
                sQLiteDatabase.execSQL(sb.toString());
            }
        } catch (Throwable th) {
            C0738c.m435a();
            C0738c.m436a("NPTH_CATCH", th);
        }
    }

    /* renamed from: a */
    public void mo447a(SQLiteDatabase sQLiteDatabase, T t) {
        if (sQLiteDatabase == null || t == null) {
            return;
        }
        try {
            sQLiteDatabase.insert(this.f399b, null, mo444a((AbstractC0742a<T>) t));
        } catch (Throwable th) {
            C0794q.m893b(th);
        }
    }
}
