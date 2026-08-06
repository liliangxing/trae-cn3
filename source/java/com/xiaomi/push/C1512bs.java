package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.xiaomi.push.C1515bv;

/* renamed from: com.xiaomi.push.bs */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1512bs extends C1515bv.e {

    /* renamed from: a */
    private String f1100a;

    public C1512bs(String str, ContentValues contentValues, String str2) {
        super(str, contentValues);
        this.f1100a = str2;
    }

    /* renamed from: a */
    public static C1512bs m1699a(Context context, String str, C1637gi c1637gi) {
        byte[] m3313a = C1670ho.m3313a(c1637gi);
        if (m3313a == null || m3313a.length <= 0) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 0);
        contentValues.put("messageId", "");
        contentValues.put("messageItemId", c1637gi.m2747d());
        contentValues.put("messageItem", m3313a);
        contentValues.put("appId", C1506bm.m1678a(context).m1690b());
        contentValues.put(DBDefinition.PACKAGE_NAME, C1506bm.m1678a(context).m1685a());
        contentValues.put("createTimeStamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("uploadTimestamp", (Integer) 0);
        return new C1512bs(str, contentValues, "a job build to insert message to db");
    }
}
