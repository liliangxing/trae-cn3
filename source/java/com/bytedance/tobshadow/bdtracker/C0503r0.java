package com.bytedance.tobshadow.bdtracker;

import android.database.Cursor;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.os.Bundle;
import com.bytedance.tobshadow.applog.IHeaderCustomTimelyCallback;
import com.bytedance.tobshadow.applog.log.EventBus;
import com.bytedance.tobshadow.applog.log.LogUtils;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.conversation.voice.subtask.SubTaskUiState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.r0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0503r0 extends AbstractC0461l0 {

    /* renamed from: h */
    public static final long[] f968h = {SubTaskUiState.LONG_RUNNING_THRESHOLD_MS};

    /* renamed from: g */
    public final C0548x3 f969g;

    /* renamed from: com.bytedance.tobshadow.bdtracker.r0$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class a implements EventBus.DataFetcher {

        /* renamed from: a */
        public final /* synthetic */ Set f970a;

        /* renamed from: b */
        public final /* synthetic */ boolean f971b;

        public a(Set set, boolean z) {
            this.f970a = set;
            this.f971b = z;
        }

        @Override // com.bytedance.tobshadow.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("$$APP_ID", C0503r0.this.f735f.f784m);
                JSONArray jSONArray = new JSONArray();
                Iterator it = this.f970a.iterator();
                while (it.hasNext()) {
                    jSONArray.put((String) it.next());
                }
                jSONObject.put("$$EVENT_LOCAL_ID_ARRAY", jSONArray);
                jSONObject.put("$$UPLOAD_STATUS", this.f971b ? "success" : "failed");
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    public C0503r0(C0475n0 c0475n0) {
        super(c0475n0);
        this.f969g = new C0548x3("sender_", c0475n0.f835e);
    }

    /* renamed from: a */
    public final void m627a(Set<String> set, boolean z) {
        if (LogUtils.isDisabled() || set == null || set.isEmpty()) {
            return;
        }
        LogUtils.sendJsonFetcher("event_upload_eid", new a(set, z));
    }

    /* renamed from: a */
    public boolean m628a(C0542w4 c0542w4) {
        boolean z;
        int i;
        InterfaceC0506r3 m522b;
        String str;
        InterfaceC0506r3 m522b2;
        String str2;
        C0458k4 c0458k4 = this.f735f.f781j;
        C0475n0 c0475n0 = this.f734e;
        String[] m503a = c0458k4.m503a(c0475n0, c0475n0.f839i.m420f(), c0542w4.f881l);
        try {
            JSONObject jSONObject = new JSONObject(new String(c0542w4.f1198z));
            jSONObject.put("local_time", System.currentTimeMillis() / 1000);
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("event_v3");
                i = optJSONArray != null ? optJSONArray.length() : 0;
                try {
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("launch");
                    if (optJSONArray2 != null) {
                        i += optJSONArray2.length();
                    }
                    JSONArray optJSONArray3 = jSONObject.optJSONArray("terminate");
                    if (optJSONArray3 != null) {
                        i += optJSONArray3.length();
                    }
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                i = 0;
            }
            this.f734e.f834d.m522b().mo638a("net_event", (String) Integer.valueOf(i));
            int m462a = this.f735f.f782k.m462a(m503a, jSONObject, this.f734e.f835e);
            z = true;
            if (m462a == 200) {
                this.f969g.m751c();
                c0542w4.f1188A = 0;
                try {
                    m627a(c0542w4.m730l(), true);
                    this.f734e.m550c().m691a(jSONObject);
                    m522b2 = this.f734e.f834d.m522b();
                    str2 = Fields.EVENT;
                } catch (Throwable th) {
                    th = th;
                    this.f734e.f834d.f764D.error(4, "Send pack failed", th, new Object[0]);
                    m627a(c0542w4.m730l(), false);
                    return z;
                }
            } else {
                if (m462a >= 500 && m462a < 600) {
                    this.f969g.m750b();
                    m522b = this.f734e.f834d.m522b();
                    str = "f_5xx";
                } else {
                    if (m462a >= 400 && m462a < 500) {
                        m522b = this.f734e.f834d.m522b();
                        str = "f_4xx";
                    }
                    C0547x2.m744a(this.f734e.f847q, 13L, this.f734e.m552d(), m462a);
                    this.f734e.f834d.f764D.error(4, "Send pack failed:{}", Integer.valueOf(m462a));
                    c0542w4.f1188A++;
                    m627a(c0542w4.m730l(), false);
                    m522b2 = this.f734e.f834d.m522b();
                    str2 = "f_net_event";
                    z = false;
                }
                m522b.mo638a(str, (String) 1);
                C0547x2.m744a(this.f734e.f847q, 13L, this.f734e.m552d(), m462a);
                this.f734e.f834d.f764D.error(4, "Send pack failed:{}", Integer.valueOf(m462a));
                c0542w4.f1188A++;
                m627a(c0542w4.m730l(), false);
                m522b2 = this.f734e.f834d.m522b();
                str2 = "f_net_event";
                z = false;
            }
            m522b2.mo638a(str2, (String) Integer.valueOf(i));
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean mo485c() {
        boolean z;
        boolean z2;
        Cursor rawQuery;
        Bundle m648a;
        long currentTimeMillis = System.currentTimeMillis();
        C0510s0 c0510s0 = this.f734e.f844n;
        if (c0510s0 != null && (m648a = c0510s0.m648a(currentTimeMillis, 50000L)) != null) {
            this.f734e.f834d.f764D.debug(4, "New play session event", new Object[0]);
            this.f735f.onEventV3("play_session", m648a, 1);
            this.f735f.flush();
        }
        C0421f2 c0421f2 = this.f734e.f839i;
        if (c0421f2.m426i() != 0) {
            c0421f2.m407a("access", (Object) C0501q5.m622a(c0421f2.f585b, this.f734e.f844n.m653a()));
            JSONObject m370b = C0411e.m370b(c0421f2.m420f());
            if (m370b != null) {
                IHeaderCustomTimelyCallback headerCustomCallback = this.f735f.getHeaderCustomCallback();
                if (headerCustomCallback != null) {
                    headerCustomCallback.updateHeader(m370b);
                }
                this.f734e.f834d.f764D.debug(4, "Send events with header:{}", m370b);
                C0521t4 m550c = this.f734e.m550c();
                String str = this.f735f.f784m;
                C0548x3 c0548x3 = this.f969g;
                if (c0548x3.m749a()) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    long j = currentTimeMillis2 - c0548x3.f1234f;
                    long[][] jArr = C0548x3.f1228h;
                    int i = c0548x3.f1231c;
                    if (j >= jArr[i][0]) {
                        c0548x3.f1232d = 1;
                        c0548x3.f1234f = currentTimeMillis2;
                    } else {
                        int i2 = c0548x3.f1232d;
                        if (i2 < jArr[i][2]) {
                            c0548x3.f1232d = i2 + 1;
                        } else {
                            z = false;
                            if (z) {
                                return true;
                            }
                            int m699c = m550c.m699c(str);
                            if (m699c < 8) {
                                int i3 = 8 - m699c;
                                for (int i4 = 0; i4 < i3 && m550c.m692a(str, m370b); i4++) {
                                }
                            }
                            ArrayList arrayList = new ArrayList();
                            try {
                                rawQuery = m550c.f1070a.getReadableDatabase().rawQuery("SELECT * FROM packV2 WHERE _app_id= ? ORDER BY _id DESC LIMIT 8", new String[]{str});
                            } catch (Throwable th) {
                                try {
                                    m550c.f1071b.f834d.m522b().mo639a(th, "queryPacks");
                                    z2 = th instanceof SQLiteBlobTooBigException;
                                    m550c.f1071b.f834d.f764D.error(5, "Query event packs failed", th, new Object[0]);
                                    C0547x2.m746a(m550c.f1071b.f847q, th);
                                } finally {
                                    C0411e.m352a((Cursor) null);
                                }
                            }
                            if (rawQuery == null) {
                                C0411e.m352a(rawQuery);
                                this.f734e.f834d.f764D.debug(4, "{} packs to be sent", Integer.valueOf(arrayList.size()));
                                if (!arrayList.isEmpty()) {
                                    return true;
                                }
                                int i5 = 0;
                                for (C0542w4 c0542w4 : arrayList) {
                                    byte[] bArr = c0542w4.f1198z;
                                    if (bArr == null || bArr.length <= 0) {
                                        c0542w4.f1188A = 0;
                                    } else if (m628a(c0542w4)) {
                                    }
                                    i5++;
                                }
                                m550c.m697b(arrayList);
                                this.f734e.f834d.m522b().mo638a("net", (String) Integer.valueOf(arrayList.size()));
                                this.f734e.f834d.m522b().mo638a("f_net", (String) Integer.valueOf(arrayList.size() - i5));
                                this.f734e.f834d.f764D.debug(4, "sender successfully send " + i5 + " packs (total: " + arrayList.size() + ")", new Object[0]);
                                return true;
                            }
                            while (rawQuery.moveToNext()) {
                                C0542w4 c0542w42 = new C0542w4();
                                c0542w42.mo570a(rawQuery);
                                arrayList.add(c0542w42);
                            }
                            C0411e.m352a(rawQuery);
                            z2 = false;
                            if (z2) {
                                m550c.m701c();
                            }
                            this.f734e.f834d.f764D.debug(4, "{} packs to be sent", Integer.valueOf(arrayList.size()));
                            if (!arrayList.isEmpty()) {
                            }
                        }
                    }
                }
                z = true;
                if (z) {
                }
            } else {
                this.f734e.f834d.f764D.error(4, "Header is empty", new Object[0]);
            }
        }
        return false;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: d */
    public String mo486d() {
        return "sender";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: e */
    public long[] mo487e() {
        return f968h;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: f */
    public boolean mo488f() {
        return true;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: g */
    public long mo489g() {
        C0407d2 c0407d2 = this.f734e.f835e;
        return c0407d2.m313a(c0407d2.f515p) ? c0407d2.f515p : c0407d2.f505f.getLong("batch_event_interval", 60000L);
    }
}
