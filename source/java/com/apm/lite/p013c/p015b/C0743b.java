package com.apm.lite.p013c.p015b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.apm.lite.p013c.p014a.C0740a;
import com.apm.lite.p023k.C0794q;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.HashMap;

/* renamed from: com.apm.lite.c.b.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0743b extends AbstractC0742a<C0740a> {
    public C0743b() {
        super("duplicatelog");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.apm.lite.p013c.p015b.AbstractC0742a
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public ContentValues mo444a(C0740a c0740a) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(StrategyConstants.PATH, c0740a.f396a);
        contentValues.put("insert_time", Long.valueOf(c0740a.f397b));
        return contentValues;
    }

    @Override // com.apm.lite.p013c.p015b.AbstractC0742a
    /* renamed from: a */
    protected HashMap<String, String> mo445a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(StrategyConstants.PATH, "TEXT");
        hashMap.put("insert_time", "INTEGER");
        hashMap.put("ext1", "TEXT");
        hashMap.put("ext2", "TEXT");
        return hashMap;
    }

    @Override // com.apm.lite.p013c.p015b.AbstractC0742a
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo447a(SQLiteDatabase sQLiteDatabase, C0740a c0740a) {
        if (c0740a == null || m448a(sQLiteDatabase, c0740a.f396a)) {
            return;
        }
        super.mo447a(sQLiteDatabase, (SQLiteDatabase) c0740a);
        try {
            sQLiteDatabase.execSQL("delete from " + this.f399b + " where _id in (select _id from " + this.f399b + " order by insert_time desc limit 1000 offset 500)");
        } catch (Exception e) {
            C0794q.m893b(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m448a(SQLiteDatabase sQLiteDatabase, String str) {
        int i;
        if (sQLiteDatabase == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Cursor query = sQLiteDatabase.query(this.f399b, null, "path=?", new String[]{str}, null, null, null);
            i = query.getCount();
            try {
                query.close();
            } catch (Throwable th) {
                th = th;
                C0794q.m893b(th);
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
