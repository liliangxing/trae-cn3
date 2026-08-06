package com.bytedance.tobshadow.bdtracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.api.IAppAuthService;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.tobshadow.applog.log.LogUtils;
import com.bytedance.tobshadow.applog.store.IEventDropStrategy;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.t4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0521t4 {

    /* renamed from: a */
    public final C0507r4 f1070a;

    /* renamed from: b */
    public final C0475n0 f1071b;

    /* renamed from: c */
    public final C0514s4 f1072c;

    public C0521t4(C0475n0 c0475n0, String str) {
        C0507r4 c0507r4 = new C0507r4(c0475n0, str, null, 51);
        this.f1070a = c0507r4;
        this.f1071b = c0475n0;
        this.f1072c = new C0514s4(c0475n0, c0507r4);
    }

    /* renamed from: a */
    public final List<Long> m685a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && optJSONObject.has("local_time_ms")) {
                    try {
                        arrayList.add(Long.valueOf(optJSONObject.getLong("local_time_ms")));
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void m687a() {
        IEventDropStrategy eventDropStrategy = this.f1071b.f835e.f502c.getEventDropStrategy();
        if (eventDropStrategy == null) {
            this.f1071b.f834d.f764D.debug("[event_process][delete] checkNeedClearExpiredEvent return, because no strategy", new Object[0]);
            return;
        }
        if (eventDropStrategy.reportTimeoutInDay() < 1) {
            this.f1071b.f834d.f764D.debug(5, "[event_process][delete] checkNeedClearExpiredEvent return, reportTimeoutInDay < 1 no limit", new Object[0]);
            return;
        }
        int reportTimeoutInDay = eventDropStrategy.reportTimeoutInDay();
        this.f1071b.f834d.f764D.debug("[event_process][delete] checkNeedClearExpiredEvent custom timeoutInDay:" + reportTimeoutInDay, new Object[0]);
        synchronized (this) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = this.f1070a.getWritableDatabase();
                sQLiteDatabase.beginTransaction();
                long currentTimeMillis = System.currentTimeMillis() - ((((reportTimeoutInDay * 24) * 60) * 60) * 1000);
                for (AbstractC0479n4 abstractC0479n4 : AbstractC0479n4.m569j().values()) {
                    if (C0411e.m379d(abstractC0479n4.m572a())) {
                        this.f1071b.f834d.f764D.debug("[event_process][delete] checkNeedClearExpiredEvent delete: {}, count: {}" + abstractC0479n4.mo271f(), Integer.valueOf(sQLiteDatabase.delete(abstractC0479n4.mo271f(), "local_time_ms < ?", new String[]{String.valueOf(currentTimeMillis)})));
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                C0411e.m353a(sQLiteDatabase);
            } catch (Throwable th) {
                try {
                    this.f1071b.f834d.f764D.error("[event_process][delete] checkNeedClearExpiredEvent failed", th, new Object[0]);
                    C0547x2.m746a(this.f1071b.f847q, th);
                } finally {
                    if (sQLiteDatabase != null) {
                        C0411e.m353a(sQLiteDatabase);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void m691a(JSONObject jSONObject) {
        m704e(m685a(jSONObject.optJSONArray("launch")));
        m704e(m685a(jSONObject.optJSONArray("terminate")));
        m704e(m685a(jSONObject.optJSONArray("event_v3")));
    }

    /* renamed from: b */
    public synchronized boolean m698b() {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        boolean z;
        try {
            sQLiteDatabase = this.f1070a.getWritableDatabase();
            try {
                sQLiteDatabase.beginTransaction();
                for (AbstractC0479n4 abstractC0479n4 : AbstractC0479n4.m569j().values()) {
                    if (C0411e.m379d(abstractC0479n4.m572a())) {
                        sQLiteDatabase.delete(abstractC0479n4.mo271f(), null, null);
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                C0411e.m353a(sQLiteDatabase);
                z = true;
            } catch (Throwable th2) {
                th = th2;
                try {
                    this.f1071b.f834d.f764D.error(5, "Clear database failed", th, new Object[0]);
                    this.f1071b.f834d.m522b().mo639a(th, "db clear");
                    C0547x2.m746a(this.f1071b.f847q, th);
                    z = false;
                    return z;
                } finally {
                    if (sQLiteDatabase != null) {
                        C0411e.m353a(sQLiteDatabase);
                    }
                }
            }
        } catch (Throwable th3) {
            sQLiteDatabase = null;
            th = th3;
        }
        return z;
    }

    /* renamed from: c */
    public final List<C0549x4> m700c(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        boolean z = false;
        try {
            cursor = str2 == null ? sQLiteDatabase.rawQuery("SELECT * FROM page WHERE _app_id= ? and user_unique_id is null order by duration desc", new String[]{str}) : sQLiteDatabase.rawQuery("SELECT * FROM page WHERE _app_id= ? and user_unique_id = ? order by duration desc", new String[]{str, str2});
            while (cursor.moveToNext()) {
                C0549x4 c0549x4 = new C0549x4();
                c0549x4.mo570a(cursor);
                arrayList.add(c0549x4);
            }
        } catch (Throwable th) {
            try {
                this.f1071b.f834d.m522b().mo639a(th, "queryAllPageByUuid");
                boolean z2 = th instanceof SQLiteBlobTooBigException;
                this.f1071b.f834d.f764D.error(5, "Query pages by userId:{} failed", th, str2);
                C0547x2.m746a(this.f1071b.f847q, th);
                C0411e.m352a(cursor);
                z = z2;
            } finally {
                C0411e.m352a(cursor);
            }
        }
        if (z) {
            m701c();
        }
        return arrayList;
    }

    /* renamed from: c */
    public synchronized void m702c(List<AbstractC0479n4> list) {
        this.f1072c.m659b(list);
    }

    /* renamed from: d */
    public synchronized void m703d(List<C0556y4> list) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase sQLiteDatabase2 = this.f1070a.getWritableDatabase();
            try {
                sQLiteDatabase2.beginTransaction();
                Iterator<C0556y4> it = list.iterator();
                ContentValues contentValues = null;
                while (it.hasNext()) {
                    contentValues = it.next().m571a(contentValues);
                    sQLiteDatabase2.insert(IAppAuthService.Scope.PROFILE, null, contentValues);
                }
                sQLiteDatabase2.setTransactionSuccessful();
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = sQLiteDatabase2;
                try {
                    this.f1071b.f834d.m522b().mo639a(th, "saveProfiles");
                    this.f1071b.f834d.f764D.error(5, "Save profiles failed", th, new Object[0]);
                    C0547x2.m746a(this.f1071b.f847q, th);
                    sQLiteDatabase2 = sQLiteDatabase;
                } finally {
                    C0411e.m353a(sQLiteDatabase);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: e */
    public final void m704e(List<Long> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (Long l : list) {
            InterfaceC0526u2 interfaceC0526u2 = this.f1071b.f847q;
            long longValue = currentTimeMillis - l.longValue();
            if (interfaceC0526u2 != null) {
                ((C0561z2) interfaceC0526u2).m763a(new C0450j3(longValue));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00ba A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x001e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d8 A[ADDED_TO_REGION, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void m697b(List<C0542w4> list) {
        int i;
        boolean z;
        boolean z2;
        if (list == null) {
            return;
        }
        IEventDropStrategy eventDropStrategy = this.f1071b.f835e.f502c.getEventDropStrategy();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.f1070a.getWritableDatabase();
            sQLiteDatabase.beginTransaction();
            for (C0542w4 c0542w4 : list) {
                if (c0542w4.f1188A == 0) {
                    sQLiteDatabase.execSQL("DELETE FROM packV2 WHERE _id=?", new Object[]{Long.valueOf(c0542w4.f871b)});
                    this.f1071b.f834d.f764D.debug("[event_process][delete] doAfterPackSend send success delete", new Object[0]);
                } else if (eventDropStrategy != null) {
                    long j = c0542w4.f872c;
                    if (eventDropStrategy.reportTimeoutInDay() >= 1 && Math.abs(System.currentTimeMillis() - j) > eventDropStrategy.reportTimeoutInDay() * 86400000) {
                        z = true;
                        int i2 = c0542w4.f1188A;
                        if (eventDropStrategy.reportMaxRetryTimes() >= 1 && i2 > eventDropStrategy.reportMaxRetryTimes()) {
                            z2 = true;
                            if (!z && !z2) {
                                i = c0542w4.f1188A;
                                if (i > 0) {
                                }
                            }
                            sQLiteDatabase.execSQL("DELETE FROM packV2 WHERE _id=?", new Object[]{Long.valueOf(c0542w4.f871b)});
                            this.f1071b.f834d.f764D.debug("[event_process][delete] doAfterPackSend trigger custom drop strategy, reportTimeoutInDay: {}, reportMaxRetryTimes: {}", Boolean.valueOf(z), Boolean.valueOf(z2));
                        }
                        z2 = false;
                        if (!z) {
                            i = c0542w4.f1188A;
                            if (i > 0) {
                            }
                        }
                        sQLiteDatabase.execSQL("DELETE FROM packV2 WHERE _id=?", new Object[]{Long.valueOf(c0542w4.f871b)});
                        this.f1071b.f834d.f764D.debug("[event_process][delete] doAfterPackSend trigger custom drop strategy, reportTimeoutInDay: {}, reportMaxRetryTimes: {}", Boolean.valueOf(z), Boolean.valueOf(z2));
                    }
                    z = false;
                    int i22 = c0542w4.f1188A;
                    if (eventDropStrategy.reportMaxRetryTimes() >= 1) {
                        z2 = true;
                        if (!z) {
                        }
                        sQLiteDatabase.execSQL("DELETE FROM packV2 WHERE _id=?", new Object[]{Long.valueOf(c0542w4.f871b)});
                        this.f1071b.f834d.f764D.debug("[event_process][delete] doAfterPackSend trigger custom drop strategy, reportTimeoutInDay: {}, reportMaxRetryTimes: {}", Boolean.valueOf(z), Boolean.valueOf(z2));
                    }
                    z2 = false;
                    if (!z) {
                    }
                    sQLiteDatabase.execSQL("DELETE FROM packV2 WHERE _id=?", new Object[]{Long.valueOf(c0542w4.f871b)});
                    this.f1071b.f834d.f764D.debug("[event_process][delete] doAfterPackSend trigger custom drop strategy, reportTimeoutInDay: {}, reportMaxRetryTimes: {}", Boolean.valueOf(z), Boolean.valueOf(z2));
                } else {
                    if (c0542w4.f1188A > 0 && Math.abs(System.currentTimeMillis() - c0542w4.f872c) > 2592000000L) {
                        sQLiteDatabase.execSQL("DELETE FROM packV2 WHERE _id=?", new Object[]{Long.valueOf(c0542w4.f871b)});
                        this.f1071b.f834d.f764D.debug("[event_process][delete] doAfterPackSend old delete way, failed pack > 0 & day > LIMIT_INTERVAL_SEND_FAIL", new Object[0]);
                    }
                    i = c0542w4.f1188A;
                    if (i > 0) {
                        sQLiteDatabase.execSQL("UPDATE packV2 SET _fail= ? WHERE _id= ?", new Object[]{Integer.valueOf(i), Long.valueOf(c0542w4.f871b)});
                    }
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int m699c(String str) {
        int i;
        boolean z = false;
        Cursor cursor = null;
        try {
            cursor = this.f1070a.getReadableDatabase().rawQuery("SELECT * FROM packV2 WHERE _app_id= ? ORDER BY _id DESC LIMIT 8", new String[]{str});
        } catch (Throwable th) {
            th = th;
            i = 0;
        }
        if (cursor == null) {
            return 0;
        }
        i = 0;
        while (cursor.moveToNext()) {
            try {
                i++;
            } catch (Throwable th2) {
                th = th2;
                try {
                    this.f1071b.f834d.m522b().mo639a(th, "queryPackCount");
                    boolean z2 = th instanceof SQLiteBlobTooBigException;
                    this.f1071b.f834d.f764D.error(5, "Query event packs count failed", th, new Object[0]);
                    C0547x2.m746a(this.f1071b.f847q, th);
                    C0411e.m352a(cursor);
                    z = z2;
                    if (z) {
                    }
                    return i;
                } finally {
                    C0411e.m352a(cursor);
                }
            }
        }
        if (z) {
            m701c();
        }
        return i;
    }

    /* renamed from: c */
    public final void m701c() {
        try {
            Field declaredField = CursorWindow.class.getDeclaredField("sCursorWindowSize");
            declaredField.setAccessible(true);
            int i = declaredField.getInt(null);
            if (i > 0 && i <= 8388608) {
                int i2 = i * 2;
                declaredField.setInt(null, i2);
                this.f1071b.f834d.f764D.debug("tryIncreaseCursorWindowSize set new curCursorWindowSize = " + i2, new Object[0]);
            } else {
                this.f1071b.f834d.f764D.debug("tryIncreaseCursorWindowSize curCursorWindowSize invalid = " + i, new Object[0]);
            }
        } catch (Throwable th) {
            this.f1071b.f834d.m522b().mo639a(th, "tryIncreaseCursorWindowSize");
            this.f1071b.f834d.f764D.error(5, "tryIncreaseCursorWindowSize", th, new Object[0]);
        }
    }

    /* renamed from: a */
    public final List<C0386a5> m684a(List<C0549x4> list, List<C0549x4> list2, boolean z) {
        ArrayList arrayList;
        Iterator it;
        Iterator it2;
        String m552d = this.f1071b.m552d();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        for (C0549x4 c0549x4 : list) {
            if (!C0411e.m362a(c0549x4.f874e, m552d)) {
                String m347a = C0411e.m347a((Object) c0549x4.f874e);
                List list3 = (List) hashMap.get(m347a);
                if (list3 == null) {
                    list3 = new ArrayList();
                    hashMap.put(m347a, list3);
                }
                list3.add(c0549x4);
            }
        }
        Iterator it3 = hashMap.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            HashMap hashMap2 = new HashMap();
            C0549x4 c0549x42 = (C0549x4) ((List) entry.getValue()).get(0);
            Iterator it4 = ((List) entry.getValue()).iterator();
            long j = 0;
            long j2 = 0;
            while (it4.hasNext()) {
                C0549x4 c0549x43 = (C0549x4) it4.next();
                Integer num = (Integer) hashMap2.get(c0549x43.f1243u);
                if (c0549x43.m752k()) {
                    if (num != null) {
                        Integer valueOf = Integer.valueOf(num.intValue() - 1);
                        if (valueOf.intValue() > 0) {
                            hashMap2.put(c0549x43.f1243u, valueOf);
                        } else {
                            hashMap2.remove(c0549x43.f1243u);
                        }
                    } else {
                        c0549x43.f1241s = 1000L;
                        if (!c0549x43.f1239D) {
                            j += c0549x43.f1241s;
                        }
                        list2.add(c0549x43);
                    }
                    arrayList = arrayList2;
                    it = it3;
                    it2 = it4;
                } else {
                    arrayList = arrayList2;
                    it = it3;
                    it2 = it4;
                    c0549x43.f1241s = Math.max(1000L, c0549x43.f1241s);
                    if (!c0549x43.f1239D) {
                        j += c0549x43.f1241s;
                    }
                    hashMap2.put(c0549x43.f1243u, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
                    list2.add(c0549x43);
                }
                long j3 = !c0549x43.m752k() ? c0549x43.f872c : c0549x43.f872c + c0549x43.f1241s;
                if (!c0549x43.f1239D && j3 > j2) {
                    j2 = j3;
                    c0549x42 = c0549x43;
                }
                it4 = it2;
                arrayList2 = arrayList;
                it3 = it;
            }
            ArrayList arrayList3 = arrayList2;
            Iterator it5 = it3;
            C0407d2 c0407d2 = this.f1071b.f835e;
            if ((c0407d2 != null && c0407d2.f519t.f1223b.contains("app_terminate")) || !z) {
                this.f1071b.f834d.f764D.debug(5, "Terminate event block", new Object[0]);
                arrayList2 = arrayList3;
            } else {
                C0386a5 c0386a5 = new C0386a5();
                c0386a5.f874e = (String) entry.getKey();
                c0386a5.f445s = j;
                c0386a5.f872c = j2;
                c0386a5.f875f = c0549x42.f875f;
                c0386a5.f876g = c0549x42.f876g;
                c0386a5.f877h = c0549x42.f877h;
                c0386a5.f878i = c0549x42.f878i;
                c0386a5.f879j = c0549x42.f879j;
                c0386a5.f446t = j2;
                C0510s0 c0510s0 = this.f1071b.f844n;
                c0386a5.f873d = c0510s0 != null ? c0510s0.f999f.incrementAndGet() : 1000L;
                c0386a5.f447u = null;
                if (!TextUtils.isEmpty(c0549x42.f1237B)) {
                    c0386a5.f447u = c0549x42.f1237B;
                }
                JSONObject jSONObject = c0549x42.f884o;
                if (jSONObject != null && jSONObject.has("$screen_orientation")) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("$screen_orientation", c0549x42.f884o.optString("$screen_orientation"));
                        c0386a5.f884o = jSONObject2;
                    } catch (Throwable th) {
                        this.f1071b.f834d.f764D.warn(5, "JSON handle failed", th);
                    }
                }
                arrayList3.add(c0386a5);
                arrayList2 = arrayList3;
            }
            it3 = it5;
        }
        return arrayList2;
    }

    /* renamed from: b */
    public synchronized void m696b(String str, JSONObject jSONObject) {
        SQLiteDatabase writableDatabase;
        List<C0394b5> m682a;
        this.f1071b.f834d.f764D.debug(5, "Pack trace events for appId:{} start...", str);
        try {
            writableDatabase = this.f1070a.getWritableDatabase();
            m682a = m682a(writableDatabase, str);
        } catch (Throwable th) {
            this.f1071b.f834d.m522b().mo639a(th, "packTrace");
            this.f1071b.f834d.f764D.error(5, "Pack trace events for appId:{} failed", th, str);
            C0547x2.m746a(this.f1071b.f847q, th);
        }
        if (m682a.isEmpty()) {
            return;
        }
        C0542w4 c0542w4 = new C0542w4();
        JSONObject jSONObject2 = new JSONObject();
        C0411e.m351a(jSONObject2, jSONObject);
        jSONObject2.remove("user_unique_id");
        jSONObject2.remove("user_unique_id_type");
        c0542w4.f1197y = jSONObject2;
        c0542w4.f882m = str;
        c0542w4.f1196x = m682a;
        m688a(writableDatabase, c0542w4);
    }

    /* renamed from: a */
    public final int m680a(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) {
        if (sQLiteDatabase == null) {
            return 0;
        }
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT count(1) FROM " + str + " WHERE " + str2, strArr);
        } catch (Throwable th) {
            try {
                this.f1071b.f834d.m522b().mo639a(th, "countByTableWhere");
                this.f1071b.f834d.f764D.error(5, "Count table:{} failed", th, str);
                C0547x2.m746a(this.f1071b.f847q, th);
            } finally {
                C0411e.m352a(cursor);
            }
        }
        if (cursor.moveToNext()) {
            return cursor.getInt(0);
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0082  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<C0528u4> m694b(SQLiteDatabase sQLiteDatabase, String str, String str2, int i) {
        Throwable th;
        Cursor cursor;
        if (i <= 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        try {
            cursor = str2 == null ? sQLiteDatabase.rawQuery("SELECT * FROM eventv3 WHERE _app_id= ? and user_unique_id is null limit 0, ?", new String[]{str, String.valueOf(i)}) : sQLiteDatabase.rawQuery("SELECT * FROM eventv3 WHERE _app_id= ? and user_unique_id = ? limit 0, ?", new String[]{str, str2, String.valueOf(i)});
            while (cursor.moveToNext()) {
                try {
                    C0528u4 c0528u4 = new C0528u4();
                    c0528u4.mo570a(cursor);
                    arrayList.add(c0528u4);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        this.f1071b.f834d.m522b().mo639a(th, "queryAllEventV3ByUuid");
                        boolean z2 = th instanceof SQLiteBlobTooBigException;
                        this.f1071b.f834d.f764D.error(5, "Query v3 event by uuid:{} for appId:{} failed", th, str2, str);
                        C0547x2.m746a(this.f1071b.f847q, th);
                        C0411e.m352a(cursor);
                        z = z2;
                        if (z) {
                        }
                        return arrayList;
                    } finally {
                        C0411e.m352a(cursor);
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        if (z) {
            m701c();
        }
        return arrayList;
    }

    /* renamed from: a */
    public synchronized void m690a(List<C0556y4> list) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.f1070a.getWritableDatabase();
            sQLiteDatabase.beginTransaction();
            Iterator<C0556y4> it = list.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.delete(IAppAuthService.Scope.PROFILE, FConstants.SELECTION, new String[]{String.valueOf(it.next().f871b)});
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            try {
            } finally {
            }
        }
    }

    /* renamed from: b */
    public final List<C0535v4> m693b(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        boolean z = false;
        try {
            cursor = str2 == null ? sQLiteDatabase.rawQuery("SELECT * FROM launch WHERE _app_id= ? and user_unique_id is null", new String[]{str}) : sQLiteDatabase.rawQuery("SELECT * FROM launch WHERE _app_id= ? and user_unique_id = ?", new String[]{str, str2});
            while (cursor.moveToNext()) {
                C0535v4 c0535v4 = new C0535v4();
                c0535v4.mo570a(cursor);
                arrayList.add(c0535v4);
                c0535v4.f1137u = !(C0411e.m379d(c0535v4.f874e) && m680a(sQLiteDatabase, "page", "session_id = ? LIMIT 1", new String[]{c0535v4.f874e}) > 0);
            }
        } catch (Throwable th) {
            try {
                this.f1071b.f834d.m522b().mo639a(th, "queryAllLaunchByUuid");
                boolean z2 = th instanceof SQLiteBlobTooBigException;
                this.f1071b.f834d.f764D.error(5, "Query launch by uuid:{} for appId:{} failed", th, str2, str);
                C0547x2.m746a(this.f1071b.f847q, th);
                C0411e.m352a(cursor);
                z = z2;
            } finally {
                C0411e.m352a(cursor);
            }
        }
        if (z) {
            m701c();
        }
        return arrayList;
    }

    /* renamed from: a */
    public final Set<String> m686a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        HashSet hashSet = new HashSet();
        Cursor cursor = null;
        boolean z = false;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT `user_unique_id` FROM " + str + " WHERE _app_id= ?", new String[]{str2});
            while (cursor.moveToNext()) {
                hashSet.add(cursor.getString(0));
            }
        } catch (Throwable th) {
            try {
                this.f1071b.f834d.m522b().mo639a(th, "loadTableUuidSet");
                boolean z2 = th instanceof SQLiteBlobTooBigException;
                this.f1071b.f834d.f764D.error(5, "Query uuid set from table:{} for appId:{} failed", th, str, str2);
                C0547x2.m746a(this.f1071b.f847q, th);
                C0411e.m352a(cursor);
                z = z2;
            } finally {
                C0411e.m352a(cursor);
            }
        }
        if (z) {
            m701c();
        }
        return hashSet;
    }

    /* renamed from: b */
    public synchronized Map<String, List<C0556y4>> m695b(String str) {
        HashMap hashMap;
        hashMap = new HashMap();
        boolean z = false;
        Cursor cursor = null;
        try {
            cursor = this.f1070a.getWritableDatabase().rawQuery("SELECT * FROM profile WHERE _app_id=? ORDER BY _id DESC LIMIT 200", new String[]{str});
            while (cursor.moveToNext()) {
                C0556y4 c0556y4 = new C0556y4();
                c0556y4.mo570a(cursor);
                String m347a = C0411e.m347a((Object) c0556y4.f876g);
                List list = (List) hashMap.get(m347a);
                if (list == null) {
                    list = new ArrayList();
                    hashMap.put(m347a, list);
                }
                list.add(c0556y4);
            }
        } catch (Throwable th) {
            try {
                this.f1071b.f834d.m522b().mo639a(th, "queryAllProfiles");
                boolean z2 = th instanceof SQLiteBlobTooBigException;
                this.f1071b.f834d.f764D.error(5, "Query profiles for appId:{} failed", th, str);
                C0547x2.m746a(this.f1071b.f847q, th);
                C0411e.m352a(cursor);
                z = z2;
            } finally {
                C0411e.m352a(cursor);
            }
        }
        if (z) {
            m701c();
        }
        return hashMap;
    }

    /* renamed from: a */
    public synchronized boolean m692a(String str, JSONObject jSONObject) {
        SQLiteDatabase sQLiteDatabase;
        List<C0386a5> list;
        List<C0500q4> list2;
        this.f1071b.f834d.f764D.debug(5, "Pack events for appId:{} start...", str);
        try {
            sQLiteDatabase = this.f1070a.getReadableDatabase();
        } catch (Throwable th) {
            this.f1071b.f834d.m522b().mo639a(th, "queryAllUnionUuid");
            this.f1071b.f834d.f764D.error(5, "Open db failed", th, new Object[0]);
            C0547x2.m746a(this.f1071b.f847q, th);
            sQLiteDatabase = null;
        }
        HashSet<String> hashSet = new HashSet();
        if (sQLiteDatabase != null) {
            hashSet.addAll(m686a(sQLiteDatabase, "launch", str));
            hashSet.addAll(m686a(sQLiteDatabase, "page", str));
            hashSet.addAll(m686a(sQLiteDatabase, "eventv3", str));
            hashSet.addAll(m686a(sQLiteDatabase, "custom_event", str));
        }
        if (hashSet.isEmpty()) {
            return false;
        }
        HashSet hashSet2 = new HashSet();
        try {
            SQLiteDatabase writableDatabase = this.f1070a.getWritableDatabase();
            for (String str2 : hashSet) {
                C0542w4 c0542w4 = new C0542w4();
                c0542w4.f882m = str;
                JSONObject jSONObject2 = new JSONObject();
                C0411e.m351a(jSONObject2, jSONObject);
                jSONObject2.remove("ssid");
                jSONObject2.put("user_unique_id", C0411e.m376c(str2) ? JSONObject.NULL : str2);
                c0542w4.f1197y = jSONObject2;
                c0542w4.f1194v = m693b(writableDatabase, str, str2);
                List<C0549x4> m700c = m700c(writableDatabase, str, str2);
                ArrayList arrayList = new ArrayList();
                List<C0386a5> m684a = m684a(m700c, arrayList, this.f1071b.f835e.f502c.isLaunchTerminateEnabled());
                c0542w4.f1193u = arrayList;
                c0542w4.f1195w = m684a;
                if (!m684a.isEmpty()) {
                    C0407d2 c0407d2 = this.f1071b.f835e;
                    boolean z = c0407d2.f517r;
                    c0407d2.f517r = false;
                    c0542w4.f1190C = z;
                }
                c0542w4.f1192t = m683a(writableDatabase, str, str2, c0542w4.m729k());
                int m729k = c0542w4.m729k();
                List<C0500q4> list3 = c0542w4.f1192t;
                if (list3 != null) {
                    m729k -= list3.size();
                }
                c0542w4.f1191s = m694b(writableDatabase, str, str2, m729k);
                List<C0535v4> list4 = c0542w4.f1194v;
                if (!((list4 == null || list4.isEmpty()) && ((list = c0542w4.f1195w) == null || list.isEmpty()) && c0542w4.m726a((Set<String>) null).length() == 0 && ((list2 = c0542w4.f1192t) == null || list2.isEmpty()))) {
                    c0542w4.m731m();
                    c0542w4.m732n();
                    if (!this.f1071b.m544a(jSONObject2)) {
                        this.f1071b.f834d.f764D.warn(5, "Register to get ssid by temp header failed.", new Object[0]);
                    } else {
                        this.f1071b.f834d.f764D.debug(5, c0542w4.toString(), new Object[0]);
                        hashSet2.add(str2);
                        c0542w4.m728c(jSONObject);
                        m688a(writableDatabase, c0542w4);
                    }
                }
            }
        } catch (Throwable th2) {
            this.f1071b.f834d.m522b().mo639a(th2, "pack");
            this.f1071b.f834d.f764D.warn(5, "Pack events for appId:{} failed", th2, str);
            C0547x2.m746a(this.f1071b.f847q, th2);
        }
        return !hashSet2.isEmpty();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0082  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<C0500q4> m683a(SQLiteDatabase sQLiteDatabase, String str, String str2, int i) {
        Throwable th;
        Cursor cursor;
        if (i <= 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        try {
            cursor = str2 == null ? sQLiteDatabase.rawQuery("SELECT * FROM custom_event WHERE _app_id= ? and user_unique_id is null limit 0, ?", new String[]{str, String.valueOf(i)}) : sQLiteDatabase.rawQuery("SELECT * FROM custom_event WHERE _app_id= ? and user_unique_id = ? limit 0, ?", new String[]{str, str2, String.valueOf(i)});
            while (cursor.moveToNext()) {
                try {
                    C0500q4 c0500q4 = new C0500q4();
                    c0500q4.mo570a(cursor);
                    arrayList.add(c0500q4);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        this.f1071b.f834d.m522b().mo639a(th, "queryAllCustomEventByUuid");
                        boolean z2 = th instanceof SQLiteBlobTooBigException;
                        this.f1071b.f834d.f764D.error(5, "Query custom event by uuid:{} for appId:{} failed", th, str2, str);
                        C0547x2.m746a(this.f1071b.f847q, th);
                        C0411e.m352a(cursor);
                        z = z2;
                        if (z) {
                        }
                        return arrayList;
                    } finally {
                        C0411e.m352a(cursor);
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        if (z) {
            m701c();
        }
        return arrayList;
    }

    /* renamed from: a */
    public int m681a(String str) {
        try {
            return m680a(this.f1070a.getWritableDatabase(), "eventv3", "_app_id= ? ", new String[]{str});
        } catch (Throwable th) {
            this.f1071b.f834d.f764D.error(5, "queryAllEventV3ByAppId appId:{} failed", th, str);
            return 0;
        }
    }

    /* renamed from: a */
    public final List<C0394b5> m682a(SQLiteDatabase sQLiteDatabase, String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        boolean z = false;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT * FROM trace WHERE _app_id= ? ", new String[]{str});
            while (cursor.moveToNext()) {
                C0394b5 c0394b5 = new C0394b5();
                c0394b5.mo570a(cursor);
                arrayList.add(c0394b5);
            }
        } catch (Throwable th) {
            try {
                this.f1071b.f834d.m522b().mo639a(th, "queryAllTrace");
                boolean z2 = th instanceof SQLiteBlobTooBigException;
                this.f1071b.f834d.f764D.error(5, "Query trace for appId:{} failed", th, str);
                C0547x2.m746a(this.f1071b.f847q, th);
                C0411e.m352a(cursor);
                z = z2;
            } finally {
                C0411e.m352a(cursor);
            }
        }
        if (z) {
            m701c();
        }
        return arrayList;
    }

    /* renamed from: a */
    public final synchronized void m688a(SQLiteDatabase sQLiteDatabase, C0542w4 c0542w4) {
        try {
            sQLiteDatabase.beginTransaction();
        } finally {
            try {
            } finally {
            }
        }
        if (sQLiteDatabase.insert("packV2", null, c0542w4.m571a((ContentValues) null)) < 0) {
            return;
        }
        List<C0535v4> list = c0542w4.f1194v;
        if (list != null) {
            for (C0535v4 c0535v4 : list) {
                sQLiteDatabase.delete("launch", "_id = ?", new String[]{String.valueOf(c0535v4.f871b)});
                LogUtils.sendObject("event_pack", c0535v4);
            }
        }
        List<C0549x4> list2 = c0542w4.f1193u;
        if (list2 != null) {
            for (C0549x4 c0549x4 : list2) {
                sQLiteDatabase.delete("page", "session_id = ? and page_key = ?", new String[]{String.valueOf(c0549x4.f874e), C0411e.m347a((Object) c0549x4.f1243u)});
                LogUtils.sendObject("event_pack", c0549x4);
            }
        }
        List<C0500q4> list3 = c0542w4.f1192t;
        if (list3 != null) {
            for (C0500q4 c0500q4 : list3) {
                sQLiteDatabase.delete("custom_event", "_id = ?", new String[]{String.valueOf(c0500q4.f871b)});
                LogUtils.sendObject("event_pack", c0500q4);
            }
        }
        List<C0528u4> list4 = c0542w4.f1191s;
        if (list4 != null) {
            for (C0528u4 c0528u4 : list4) {
                sQLiteDatabase.delete("eventv3", "_id = ?", new String[]{String.valueOf(c0528u4.f871b)});
                LogUtils.sendObject("event_pack", c0528u4);
            }
        }
        if (c0542w4.f1196x != null) {
            sQLiteDatabase.delete("trace", "_app_id= ? ", new String[]{String.valueOf(c0542w4.f882m)});
            if (!LogUtils.isDisabled()) {
                Iterator<C0394b5> it = c0542w4.f1196x.iterator();
                while (it.hasNext()) {
                    LogUtils.sendObject("event_pack", it.next());
                }
            }
        }
        sQLiteDatabase.setTransactionSuccessful();
    }

    /* renamed from: a */
    public synchronized void m689a(String str, String str2) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.f1070a.getWritableDatabase();
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("UPDATE launch SET ssid = ? WHERE user_unique_id = ? AND LENGTH(ssid) = 0", new String[]{str2, str});
            sQLiteDatabase.execSQL("UPDATE page SET ssid = ? WHERE user_unique_id = ? AND LENGTH(ssid) = 0", new String[]{str2, str});
            sQLiteDatabase.execSQL("UPDATE eventv3 SET ssid = ? WHERE user_unique_id = ? AND LENGTH(ssid) = 0", new String[]{str2, str});
            sQLiteDatabase.execSQL("UPDATE profile SET ssid = ? WHERE user_unique_id = ? AND LENGTH(ssid) = 0", new String[]{str2, str});
            sQLiteDatabase.execSQL("UPDATE trace SET ssid = ? WHERE user_unique_id = ? AND LENGTH(ssid) = 0", new String[]{str2, str});
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            try {
            } finally {
            }
        }
    }
}
