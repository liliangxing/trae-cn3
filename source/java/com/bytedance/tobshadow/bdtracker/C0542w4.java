package com.bytedance.tobshadow.bdtracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.api.IWeiboService;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.tobshadow.applog.event.AutoTrackEventType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.w4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0542w4 extends AbstractC0479n4 {

    /* renamed from: A */
    public int f1188A;

    /* renamed from: B */
    public String f1189B;

    /* renamed from: C */
    public boolean f1190C = false;

    /* renamed from: s */
    public List<C0528u4> f1191s;

    /* renamed from: t */
    public List<C0500q4> f1192t;

    /* renamed from: u */
    public List<C0549x4> f1193u;

    /* renamed from: v */
    public List<C0535v4> f1194v;

    /* renamed from: w */
    public List<C0386a5> f1195w;

    /* renamed from: x */
    public List<C0394b5> f1196x;

    /* renamed from: y */
    public JSONObject f1197y;

    /* renamed from: z */
    public byte[] f1198z;

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: a */
    public int mo570a(Cursor cursor) {
        this.f871b = cursor.getLong(0);
        this.f872c = cursor.getLong(1);
        this.f1198z = cursor.getBlob(2);
        this.f1188A = cursor.getInt(3);
        this.f881l = cursor.getInt(4);
        this.f882m = cursor.getString(5);
        this.f1189B = cursor.getString(6);
        this.f874e = "";
        return 7;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: a */
    public AbstractC0479n4 mo266a(JSONObject jSONObject) {
        m576d().error(4, this.f870a, "Not allowed", new Object[0]);
        return null;
    }

    /* renamed from: a */
    public final JSONArray m726a(Set<String> set) {
        JSONArray jSONArray = new JSONArray();
        if (this.f1190C) {
            C0467m m491a = C0453k.m491a(this.f882m);
            if (m491a == null || !m491a.isBavEnabled()) {
                List<C0549x4> list = this.f1193u;
                if (list != null) {
                    for (C0549x4 c0549x4 : list) {
                        if (c0549x4.f1238C) {
                            jSONArray.put(c0549x4.m579h());
                            if (set != null) {
                                set.add(c0549x4.f885p);
                            }
                        }
                    }
                }
            } else if (this.f1193u != null) {
                if (!((m491a.getInitConfig() == null || AutoTrackEventType.m227a(m491a.getInitConfig().getAutoTrackEventType(), 2)) ? false : true)) {
                    for (C0549x4 c0549x42 : this.f1193u) {
                        jSONArray.put(c0549x42.m579h());
                        if (set != null) {
                            set.add(c0549x42.f885p);
                        }
                    }
                }
            }
        }
        List<C0528u4> list2 = this.f1191s;
        if (list2 != null && !list2.isEmpty()) {
            for (C0528u4 c0528u4 : this.f1191s) {
                jSONArray.put(c0528u4.m579h());
                if (set != null) {
                    set.add(c0528u4.f885p);
                }
            }
        }
        List<C0394b5> list3 = this.f1196x;
        if (list3 != null && !list3.isEmpty()) {
            for (C0394b5 c0394b5 : this.f1196x) {
                jSONArray.put(c0394b5.m579h());
                if (set != null) {
                    set.add(c0394b5.f885p);
                }
            }
        }
        return jSONArray;
    }

    /* renamed from: a */
    public void m727a(List<? extends AbstractC0479n4> list, C0402c5 c0402c5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<? extends AbstractC0479n4> it = list.iterator();
        boolean z = true;
        while (it.hasNext()) {
            AbstractC0479n4 next = it.next();
            if (c0402c5.m299a(next.m579h(), z)) {
                m576d().debug("calcEventList pack, data: {}", next);
            } else {
                it.remove();
                m576d().debug("calcEventList discard, data: {}", next);
            }
            z = false;
        }
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: b */
    public List<String> mo267b() {
        return Arrays.asList("_id", "integer primary key autoincrement", "local_time_ms", "integer", FConstants.DATA_COLUMN, "blob", "_fail", "integer", "event_type", "integer", "_app_id", "varchar", "e_ids", "varchar");
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: b */
    public void mo268b(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.f872c));
        contentValues.put(FConstants.DATA_COLUMN, m733o());
        contentValues.put("event_type", Integer.valueOf(this.f881l));
        contentValues.put("_app_id", this.f882m);
        contentValues.put("e_ids", this.f1189B);
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: b */
    public void mo269b(JSONObject jSONObject) {
        m576d().error(4, this.f870a, "Not allowed", new Object[0]);
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: c */
    public String mo270c() {
        return String.valueOf(this.f871b);
    }

    /* renamed from: c */
    public void m728c(JSONObject jSONObject) {
        try {
            C0402c5 c0402c5 = new C0402c5();
            if (c0402c5.f485c) {
                c0402c5.f484b = C0402c5.m296a(jSONObject);
                c0402c5.f484b += 20480;
                c0402c5.f483a = c0402c5.f484b;
            }
            m727a(this.f1194v, c0402c5);
            m727a(this.f1195w, c0402c5);
            m727a(this.f1191s, c0402c5);
            m727a(this.f1192t, c0402c5);
            m727a(this.f1196x, c0402c5);
        } catch (Throwable th) {
            m576d().error("calcPackLength failed", th, new Object[0]);
        }
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: f */
    public String mo271f() {
        return "packV2";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    /* renamed from: i */
    public JSONObject mo272i() {
        int i;
        C0467m m491a = C0453k.m491a(this.f882m);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", this.f1197y);
        jSONObject.put("time_sync", C0444i4.f666d);
        HashSet hashSet = new HashSet();
        List<C0535v4> list = this.f1194v;
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (C0535v4 c0535v4 : this.f1194v) {
                jSONArray.put(c0535v4.m579h());
                hashSet.add(c0535v4.f885p);
            }
            jSONObject.put("launch", jSONArray);
        }
        List<C0386a5> list2 = this.f1195w;
        int i2 = 0;
        if (list2 != null && !list2.isEmpty()) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<C0386a5> it = this.f1195w.iterator();
            while (it.hasNext()) {
                C0386a5 next = it.next();
                JSONObject m579h = next.m579h();
                if (m491a != null && (i = m491a.f783l) > 0) {
                    m579h.put("launch_from", i);
                    m491a.f783l = i2;
                }
                if (this.f1193u != null) {
                    ArrayList arrayList = new ArrayList();
                    for (C0549x4 c0549x4 : this.f1193u) {
                        if (C0411e.m362a(c0549x4.f874e, next.f874e)) {
                            arrayList.add(c0549x4);
                        }
                    }
                    if (arrayList.size() != 0) {
                        int size = arrayList.size();
                        long j = 0;
                        int i3 = i2;
                        while (i3 < size) {
                            C0549x4 c0549x42 = (C0549x4) arrayList.get(i3);
                            Iterator<C0386a5> it2 = it;
                            long j2 = c0549x42.f872c;
                            if (j2 > j) {
                                m579h.put("$page_title", C0411e.m347a((Object) c0549x42.f1244v));
                                m579h.put("$page_key", C0411e.m347a((Object) c0549x42.f1243u));
                                j = j2;
                            }
                            i3++;
                            it = it2;
                        }
                        jSONArray2.put(m579h);
                        hashSet.add(next.f885p);
                        i2 = 0;
                    }
                }
            }
            jSONObject.put("terminate", jSONArray2);
        }
        JSONArray m726a = m726a(hashSet);
        if (m726a.length() > 0) {
            jSONObject.put("event_v3", m726a);
        }
        List<C0500q4> list3 = this.f1192t;
        if (list3 != null && !list3.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (C0500q4 c0500q4 : this.f1192t) {
                JSONArray jSONArray3 = (JSONArray) hashMap.get(c0500q4.f948s);
                if (jSONArray3 == null) {
                    jSONArray3 = new JSONArray();
                    hashMap.put(c0500q4.f948s, jSONArray3);
                }
                jSONArray3.put(c0500q4.m579h());
                hashSet.add(c0500q4.f885p);
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
        }
        this.f1189B = TextUtils.join(IWeiboService.Scope.EMPTY_SCOPE, hashSet);
        m576d().debug(4, this.f870a, "Pack success ts:{}", Long.valueOf(this.f872c));
        return jSONObject;
    }

    /* renamed from: k */
    public int m729k() {
        C0467m m491a;
        List<C0549x4> list;
        List<C0535v4> list2 = this.f1194v;
        int size = list2 != null ? 200 - list2.size() : 200;
        List<C0386a5> list3 = this.f1195w;
        if (list3 != null) {
            size -= list3.size();
        }
        return (!this.f1190C || (m491a = C0453k.m491a(this.f882m)) == null || !m491a.isBavEnabled() || (list = this.f1193u) == null) ? size : size - list.size();
    }

    /* renamed from: l */
    public Set<String> m730l() {
        HashSet hashSet = new HashSet();
        if (TextUtils.isEmpty(this.f1189B)) {
            return hashSet;
        }
        hashSet.addAll(Arrays.asList(this.f1189B.split(IWeiboService.Scope.EMPTY_SCOPE)));
        return hashSet;
    }

    /* renamed from: m */
    public void m731m() {
        List<C0549x4> list;
        JSONObject jSONObject = this.f1197y;
        if (jSONObject == null) {
            return;
        }
        jSONObject.remove("ssid");
        try {
            List<C0535v4> list2 = this.f1194v;
            if (list2 != null) {
                for (C0535v4 c0535v4 : list2) {
                    if (C0411e.m379d(c0535v4.f878i)) {
                        this.f1197y.put("ssid", c0535v4.f878i);
                        return;
                    }
                }
            }
            if (this.f1190C && (list = this.f1193u) != null) {
                for (C0549x4 c0549x4 : list) {
                    if (C0411e.m379d(c0549x4.f878i)) {
                        this.f1197y.put("ssid", c0549x4.f878i);
                        return;
                    }
                }
            }
            List<C0500q4> list3 = this.f1192t;
            if (list3 != null) {
                for (C0500q4 c0500q4 : list3) {
                    if (C0411e.m379d(c0500q4.f878i)) {
                        this.f1197y.put("ssid", c0500q4.f878i);
                        return;
                    }
                }
            }
            List<C0528u4> list4 = this.f1191s;
            if (list4 != null) {
                for (C0528u4 c0528u4 : list4) {
                    if (C0411e.m379d(c0528u4.f878i)) {
                        this.f1197y.put("ssid", c0528u4.f878i);
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            m576d().error(4, this.f870a, "Reload ssid from event failed", th, new Object[0]);
        }
    }

    /* renamed from: n */
    public void m732n() {
        List<C0549x4> list;
        JSONObject jSONObject = this.f1197y;
        if (jSONObject == null) {
            return;
        }
        jSONObject.remove("user_unique_id_type");
        try {
            List<C0535v4> list2 = this.f1194v;
            if (list2 != null) {
                for (C0535v4 c0535v4 : list2) {
                    if (C0411e.m379d(c0535v4.f877h)) {
                        this.f1197y.put("user_unique_id_type", c0535v4.f877h);
                        return;
                    }
                }
            }
            if (this.f1190C && (list = this.f1193u) != null) {
                for (C0549x4 c0549x4 : list) {
                    if (C0411e.m379d(c0549x4.f877h)) {
                        this.f1197y.put("user_unique_id_type", c0549x4.f877h);
                        return;
                    }
                }
            }
            List<C0500q4> list3 = this.f1192t;
            if (list3 != null) {
                for (C0500q4 c0500q4 : list3) {
                    if (C0411e.m379d(c0500q4.f877h)) {
                        this.f1197y.put("user_unique_id_type", c0500q4.f877h);
                        return;
                    }
                }
            }
            List<C0528u4> list4 = this.f1191s;
            if (list4 != null) {
                for (C0528u4 c0528u4 : list4) {
                    if (C0411e.m379d(c0528u4.f877h)) {
                        this.f1197y.put("user_unique_id_type", c0528u4.f877h);
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            m576d().error(4, this.f870a, "Reload uuid type from event failed", th, new Object[0]);
        }
    }

    /* renamed from: o */
    public final byte[] m733o() {
        try {
            return m579h().toString().getBytes("UTF-8");
        } catch (Throwable th) {
            m576d().error(4, this.f870a, "Convert json to bytes failed", th, new Object[0]);
            return null;
        }
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0479n4
    public String toString() {
        StringBuilder sb = new StringBuilder("Pack detail:");
        List<C0528u4> list = this.f1191s;
        int size = list != null ? 0 + list.size() : 0;
        List<C0500q4> list2 = this.f1192t;
        if (list2 != null) {
            size += list2.size();
        }
        if (size > 0) {
            sb.append("\teventCount=").append(size);
        }
        List<C0549x4> list3 = this.f1193u;
        if (list3 != null && !list3.isEmpty()) {
            sb.append("\tpageCount=").append(this.f1193u.size());
        }
        List<C0535v4> list4 = this.f1194v;
        if (list4 != null && !list4.isEmpty()) {
            sb.append("\tlaunchCount=").append(this.f1194v.size());
        }
        List<C0386a5> list5 = this.f1195w;
        if (list5 != null && !list5.isEmpty()) {
            sb.append("\tterminateCount=").append(this.f1195w.size());
        }
        List<C0394b5> list6 = this.f1196x;
        if (list6 != null && !list6.isEmpty()) {
            sb.append("\ttraceCount=").append(this.f1196x.size());
        }
        if (this.f1188A > 0) {
            sb.append("\tfailCount=").append(this.f1188A);
        }
        return sb.toString();
    }
}
