package com.bytedance.tobshadow.bdtracker;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.sdk.account.api.AccountErrorCode;
import com.bytedance.tobshadow.applog.InitConfig;
import com.bytedance.tobshadow.applog.event.EventBasicData;
import com.bytedance.tobshadow.applog.event.EventPolicy;
import com.bytedance.tobshadow.applog.event.EventType;
import com.bytedance.tobshadow.applog.event.IEventHandler;
import com.bytedance.tobshadow.applog.log.LogUtils;
import com.bytedance.tobshadow.applog.store.IEventDropStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.s4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0514s4 {

    /* renamed from: a */
    public final C0475n0 f1018a;

    /* renamed from: b */
    public final C0507r4 f1019b;

    public C0514s4(C0475n0 c0475n0, C0507r4 c0507r4) {
        this.f1018a = c0475n0;
        this.f1019b = c0507r4;
    }

    /* renamed from: a */
    public final EventPolicy m656a(IEventHandler iEventHandler, int i, String str, AbstractC0479n4 abstractC0479n4, JSONObject jSONObject) {
        abstractC0479n4.m579h();
        String m297a = C0402c5.m297a(abstractC0479n4.mo577e());
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(m297a)) {
            try {
                jSONObject2 = new JSONObject(m297a);
            } catch (Throwable unused) {
                this.f1018a.f834d.f764D.error(5, "Param:[{}] is not a json string", m297a);
            }
        }
        if (jSONObject != null) {
            C0411e.m375c(jSONObject, jSONObject2);
        }
        EventPolicy onReceive = iEventHandler.onReceive(i, str, jSONObject2, new EventBasicData(abstractC0479n4));
        abstractC0479n4.f884o = jSONObject2;
        return onReceive;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x022d A[Catch: all -> 0x0271, TryCatch #1 {all -> 0x0271, blocks: (B:101:0x0223, B:102:0x0227, B:104:0x022d, B:106:0x024c, B:107:0x0259, B:110:0x0265), top: B:100:0x0223 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x029b A[Catch: all -> 0x0345, TRY_LEAVE, TryCatch #3 {all -> 0x0345, blocks: (B:115:0x0283, B:117:0x028d, B:120:0x0295, B:122:0x029b, B:124:0x02a4), top: B:114:0x0283 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a0 A[Catch: all -> 0x0211, TryCatch #2 {all -> 0x0211, blocks: (B:74:0x0196, B:75:0x019a, B:77:0x01a0, B:91:0x01ae, B:93:0x01ba, B:94:0x01c7, B:97:0x01d3, B:80:0x01df, B:82:0x01eb, B:83:0x01f9, B:86:0x0205), top: B:73:0x0196 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m659b(List<AbstractC0479n4> list) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2;
        SQLiteDatabase sQLiteDatabase3;
        InitConfig initConfig;
        IEventDropStrategy eventDropStrategy;
        Iterator it;
        Iterator it2;
        InitConfig initConfig2;
        if (list == null || list.isEmpty()) {
            return;
        }
        C0407d2 c0407d2 = this.f1018a.f835e;
        if ((c0407d2 == null || (initConfig2 = c0407d2.f502c) == null || initConfig2.isTrackEventEnabled()) ? false : true) {
            return;
        }
        ArrayList arrayList = new ArrayList(4);
        ArrayList arrayList2 = new ArrayList(4);
        ArrayList arrayList3 = new ArrayList(4);
        IEventHandler iEventHandler = this.f1018a.f834d.f763C;
        try {
            sQLiteDatabase = this.f1019b.getWritableDatabase();
            try {
                sQLiteDatabase.beginTransaction();
                ContentValues contentValues = null;
                for (AbstractC0479n4 abstractC0479n4 : list) {
                    if (!m658a(iEventHandler, abstractC0479n4, this.f1018a.f835e.f502c.isLaunchTerminateEnabled())) {
                        C0547x2.m744a(this.f1018a.f847q, 2L, this.f1018a.m552d(), AccountErrorCode.UNBIND_PHONE_ERROR);
                        this.f1018a.f834d.f764D.debug(5, "[event_process][delete] filterByEventHandler: {}", abstractC0479n4);
                    } else {
                        if (TextUtils.isEmpty(abstractC0479n4.f882m)) {
                            abstractC0479n4.f882m = this.f1018a.f834d.f784m;
                        }
                        if (!(abstractC0479n4 instanceof C0535v4) && !(abstractC0479n4 instanceof C0386a5) && !(abstractC0479n4 instanceof C0556y4) && !(abstractC0479n4 instanceof C0549x4)) {
                            AbstractC0479n4.m567a(abstractC0479n4, this.f1018a.f839i.m434o());
                        }
                        this.f1018a.f829G.m587a(abstractC0479n4);
                        String mo271f = abstractC0479n4.mo271f();
                        contentValues = abstractC0479n4.m571a(contentValues);
                        abstractC0479n4.f871b = sQLiteDatabase.insert(mo271f, null, contentValues);
                        this.f1018a.f834d.m522b().mo638a("make_event", (String) 1);
                        if ("eventv3".equals(abstractC0479n4.mo271f())) {
                            arrayList3.add(abstractC0479n4);
                        } else if (abstractC0479n4 instanceof C0535v4) {
                            arrayList.add((C0535v4) abstractC0479n4);
                        } else if (abstractC0479n4 instanceof C0549x4) {
                            arrayList2.add((C0549x4) abstractC0479n4);
                        }
                        LogUtils.sendObject("event_save_db", abstractC0479n4);
                        this.f1018a.f834d.f764D.debug(5, "[event_process][save] event_save_db: {}, id: {}", abstractC0479n4, Long.valueOf(abstractC0479n4.f871b));
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                InterfaceC0526u2 interfaceC0526u2 = this.f1018a.f847q;
                String m552d = this.f1018a.m552d();
                int size = list.size();
                if (interfaceC0526u2 != null) {
                    ((C0561z2) interfaceC0526u2).m763a(new C0415e3(size));
                }
                if (interfaceC0526u2 != null) {
                    if (m552d == null) {
                        m552d = "";
                    }
                    ((C0561z2) interfaceC0526u2).m763a(new C0429g3(1L, m552d, 1L));
                }
            } catch (Throwable th) {
                th = th;
                try {
                    this.f1018a.f834d.f764D.debug(5, "[event_process][save] Insert to table failed", th);
                    this.f1018a.f834d.m522b().mo639a(th, "db insert");
                    if (list.size() > 0 && !(list.get(0) instanceof C0394b5)) {
                        C0547x2.m746a(this.f1018a.f847q, th);
                    }
                    C0411e.m353a(sQLiteDatabase);
                    m657a(arrayList3);
                    it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                    }
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                    }
                    initConfig = this.f1018a.f834d.getInitConfig();
                    if (initConfig != null) {
                        if (eventDropStrategy.eventDBCacheSize() >= 1) {
                        }
                    }
                    sQLiteDatabase2 = null;
                    sQLiteDatabase3 = sQLiteDatabase2;
                } finally {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = null;
        }
        C0411e.m353a(sQLiteDatabase);
        m657a(arrayList3);
        try {
            it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                C0549x4 c0549x4 = (C0549x4) it2.next();
                if (c0549x4.f1241s == -1) {
                    if (this.f1018a.f834d.f774c.m632a()) {
                        this.f1018a.f834d.f774c.pageJson(c0549x4.m579h(), true);
                    }
                    if (this.f1018a.f834d.f774c.m636b()) {
                        this.f1018a.f834d.f774c.onPageEnter(c0549x4.f884o);
                    }
                } else {
                    if (this.f1018a.f834d.f774c.m632a()) {
                        this.f1018a.f834d.f774c.pageJson(c0549x4.m579h(), false);
                    }
                    if (this.f1018a.f834d.f774c.m636b()) {
                        this.f1018a.f834d.f774c.onPageLeave(c0549x4.f884o);
                    }
                }
            }
        } catch (Throwable th3) {
            this.f1018a.f834d.f764D.debug(5, "Notify event observer failed", th3);
        }
        try {
            it = arrayList.iterator();
            while (it.hasNext()) {
                C0535v4 c0535v4 = (C0535v4) it.next();
                this.f1018a.f834d.f773b.onSessionStart(c0535v4.f871b, c0535v4.f874e);
                if (this.f1018a.f834d.f774c.m632a()) {
                    this.f1018a.f834d.f774c.launchJson(c0535v4.m579h());
                }
                if (this.f1018a.f834d.f774c.m636b()) {
                    this.f1018a.f834d.f774c.onLaunch(c0535v4.f884o);
                }
            }
        } catch (Throwable th4) {
            this.f1018a.f834d.f764D.debug(5, "Notify session observer failed ", th4);
        }
        try {
            initConfig = this.f1018a.f834d.getInitConfig();
            if (initConfig != null && (eventDropStrategy = initConfig.getEventDropStrategy()) != null) {
                if (eventDropStrategy.eventDBCacheSize() >= 1) {
                    this.f1018a.f834d.f764D.debug(5, "[event_process][delete] checkDbFileSizeAndClear return, eventDBCacheSize < 1 no limit", new Object[0]);
                    C0411e.m353a((SQLiteDatabase) null);
                    return;
                }
                sQLiteDatabase2 = null;
                try {
                    long length = this.f1018a.m546b().getDatabasePath(initConfig.getDbName()).length();
                    long eventDBCacheSize = eventDropStrategy.eventDBCacheSize() * 1048576;
                    if (length > eventDBCacheSize) {
                        sQLiteDatabase3 = this.f1019b.getWritableDatabase();
                        try {
                            sQLiteDatabase3.beginTransaction();
                            sQLiteDatabase3.execSQL("DELETE FROM eventv3 WHERE _id IN (SELECT _id FROM eventv3 ORDER BY _id LIMIT 200)");
                            sQLiteDatabase3.setTransactionSuccessful();
                            this.f1018a.f834d.f764D.debug(5, "[event_process][delete] checkDbFileSizeAndClear trigger delete, fileSize: {}, custom size: {}, delete count: {}", Long.valueOf(length), Long.valueOf(eventDBCacheSize), 200);
                        } catch (Throwable th5) {
                            th = th5;
                            try {
                                this.f1018a.f834d.f764D.error(5, "[event_process][delete] checkDbFileSizeAndClear failed", th, new Object[0]);
                                return;
                            } finally {
                            }
                        }
                    }
                    this.f1018a.f834d.f764D.debug(5, "[event_process][delete] checkDbFileSizeAndClear don't need trigger delete, fileSize: {}, custom size: {}", Long.valueOf(length), Long.valueOf(eventDBCacheSize));
                    sQLiteDatabase3 = sQLiteDatabase2;
                } catch (Throwable th6) {
                    th = th6;
                    sQLiteDatabase3 = sQLiteDatabase2;
                    this.f1018a.f834d.f764D.error(5, "[event_process][delete] checkDbFileSizeAndClear failed", th, new Object[0]);
                    return;
                }
            }
            sQLiteDatabase2 = null;
            sQLiteDatabase3 = sQLiteDatabase2;
        } catch (Throwable th7) {
            th = th7;
            sQLiteDatabase2 = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0074 A[RETURN] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m658a(IEventHandler iEventHandler, AbstractC0479n4 abstractC0479n4, boolean z) {
        EventPolicy eventPolicy;
        String str;
        int i;
        JSONObject jSONObject;
        String str2;
        if (abstractC0479n4 != null) {
            if (iEventHandler != null) {
                int acceptType = iEventHandler.acceptType();
                if (abstractC0479n4 instanceof C0493p4) {
                    if (EventType.m228a(acceptType, 8)) {
                        eventPolicy = m656a(iEventHandler, 8, "bav2b_click", abstractC0479n4, abstractC0479n4.f884o);
                        if (abstractC0479n4 instanceof C0535v4) {
                            eventPolicy = z ? EventPolicy.ACCEPT : EventPolicy.DENY;
                        }
                        if (eventPolicy == EventPolicy.DENY) {
                            return false;
                        }
                    }
                } else if (abstractC0479n4 instanceof C0528u4) {
                    if (EventType.m228a(acceptType, 1)) {
                        str = ((C0528u4) abstractC0479n4).f1104u;
                        i = 1;
                        str2 = C0411e.m347a((Object) str);
                        jSONObject = abstractC0479n4.f884o;
                        eventPolicy = m656a(iEventHandler, i, str2, abstractC0479n4, jSONObject);
                        if (abstractC0479n4 instanceof C0535v4) {
                        }
                        if (eventPolicy == EventPolicy.DENY) {
                        }
                    }
                } else if (abstractC0479n4 instanceof C0549x4) {
                    if (EventType.m228a(acceptType, 4)) {
                        jSONObject = abstractC0479n4.f884o;
                        i = 4;
                        str2 = "bav2b_page";
                        eventPolicy = m656a(iEventHandler, i, str2, abstractC0479n4, jSONObject);
                        if (abstractC0479n4 instanceof C0535v4) {
                        }
                        if (eventPolicy == EventPolicy.DENY) {
                        }
                    }
                } else if ((abstractC0479n4 instanceof C0556y4) && EventType.m228a(acceptType, 2)) {
                    str = ((C0556y4) abstractC0479n4).f1260t;
                    i = 2;
                    str2 = C0411e.m347a((Object) str);
                    jSONObject = abstractC0479n4.f884o;
                    eventPolicy = m656a(iEventHandler, i, str2, abstractC0479n4, jSONObject);
                    if (abstractC0479n4 instanceof C0535v4) {
                    }
                    if (eventPolicy == EventPolicy.DENY) {
                    }
                }
            }
            eventPolicy = null;
            if (abstractC0479n4 instanceof C0535v4) {
            }
            if (eventPolicy == EventPolicy.DENY) {
            }
        }
        return true;
    }

    /* renamed from: a */
    public void m657a(List<AbstractC0479n4> list) {
        try {
            for (AbstractC0479n4 abstractC0479n4 : list) {
                if ("eventv3".equals(abstractC0479n4.mo271f())) {
                    C0528u4 c0528u4 = (C0528u4) abstractC0479n4;
                    C0504r1 c0504r1 = this.f1018a.f834d.f774c;
                    String str = c0528u4.f1104u;
                    String str2 = c0528u4.f1102s;
                    c0504r1.onEventV3(str, str2 != null ? new JSONObject(str2) : null);
                    if (this.f1018a.f834d.f774c.m632a()) {
                        this.f1018a.f834d.f774c.eventJson(c0528u4.f1104u, c0528u4.m579h());
                    }
                }
            }
        } catch (Throwable th) {
            this.f1018a.f834d.f764D.debug(5, "Notify event observer failed", th);
        }
    }
}
