package com.apm.lite.c.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.apm.lite.k.q;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class b extends a<com.apm.lite.c.a.a> {
    public b() {
        super("duplicatelog");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.apm.lite.c.b.a
    public ContentValues a(com.apm.lite.c.a.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("path", aVar.a);
        contentValues.put("insert_time", Long.valueOf(aVar.b));
        return contentValues;
    }

    @Override // com.apm.lite.c.b.a
    protected HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("path", "TEXT");
        hashMap.put("insert_time", "INTEGER");
        hashMap.put("ext1", "TEXT");
        hashMap.put("ext2", "TEXT");
        return hashMap;
    }

    @Override // com.apm.lite.c.b.a
    public void a(SQLiteDatabase sQLiteDatabase, com.apm.lite.c.a.a aVar) {
        if (aVar == null || a(sQLiteDatabase, aVar.a)) {
            return;
        }
        super.a(sQLiteDatabase, (SQLiteDatabase) aVar);
        try {
            sQLiteDatabase.execSQL("delete from " + this.b + " where _id in (select _id from " + this.b + " order by insert_time desc limit 1000 offset 500)");
        } catch (Exception e) {
            q.b(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(SQLiteDatabase sQLiteDatabase, String str) {
        int i;
        if (sQLiteDatabase == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Cursor query = sQLiteDatabase.query(this.b, null, "path=?", new String[]{str}, null, null, null);
            i = query.getCount();
            try {
                query.close();
            } catch (Throwable th) {
                th = th;
                q.b(th);
                if (i <= 0) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            i = 0;
        }
        return i <= 0;
    }
}
