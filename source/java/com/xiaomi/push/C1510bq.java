package com.xiaomi.push;

import android.content.Context;
import android.database.Cursor;
import com.xiaomi.push.C1515bv;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.push.bq */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1510bq extends C1515bv.b<Long> {

    /* renamed from: a */
    private long f1097a;

    /* renamed from: a */
    private String f1098a;

    public C1510bq(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i, String str6) {
        super(str, list, str2, strArr, str3, str4, str5, i);
        this.f1097a = 0L;
        this.f1098a = str6;
    }

    /* renamed from: a */
    public static C1510bq m1694a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("count(*)");
        return new C1510bq(str, arrayList, null, null, null, null, null, 0, "job to get count of all message");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaomi.push.C1515bv.b
    /* renamed from: a */
    public Long mo1695a(Context context, Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    @Override // com.xiaomi.push.C1515bv.b
    /* renamed from: a */
    public void mo1697a(Context context, List<Long> list) {
        if (context == null || list == null || list.size() <= 0) {
            return;
        }
        this.f1097a = list.get(0).longValue();
    }

    @Override // com.xiaomi.push.C1515bv.a
    /* renamed from: a */
    public Object mo1696a() {
        return Long.valueOf(this.f1097a);
    }
}
