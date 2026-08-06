package com.bytedance.tobshadow.bdtracker;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.tobshadow.applog.log.EventBus;
import com.bytedance.tobshadow.applog.log.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.d4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0409d4 implements Handler.Callback {

    /* renamed from: a */
    public final C0475n0 f521a;

    /* renamed from: b */
    public final Handler f522b;

    /* renamed from: c */
    public final Map<String, b> f523c = new HashMap();

    /* renamed from: d */
    public final Set<String> f524d = new HashSet();

    /* renamed from: e */
    public String f525e = "";

    /* renamed from: f */
    public String f526f = null;

    /* renamed from: com.bytedance.tobshadow.bdtracker.d4$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class a implements EventBus.DataFetcher {

        /* renamed from: a */
        public final /* synthetic */ Set f527a;

        /* renamed from: b */
        public final /* synthetic */ String f528b;

        /* renamed from: c */
        public final /* synthetic */ boolean f529c;

        public a(C0409d4 c0409d4, Set set, String str, boolean z) {
            this.f527a = set;
            this.f528b = str;
            this.f529c = z;
        }

        @Override // com.bytedance.tobshadow.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                Iterator it = this.f527a.iterator();
                while (it.hasNext()) {
                    jSONArray.put((String) it.next());
                }
                jSONObject.put("$$APP_ID", this.f528b);
                jSONObject.put("$$EVENT_LOCAL_ID_ARRAY", jSONArray);
                jSONObject.put("$$UPLOAD_STATUS", this.f529c ? "success" : "failed");
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.d4$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class b {

        /* renamed from: a */
        public String f530a;

        /* renamed from: b */
        public JSONObject f531b;

        public b(String str, JSONObject jSONObject) {
            this.f530a = str;
            this.f531b = jSONObject;
        }

        public String toString() {
            return C0380a.m252a("ProfileDataWrapper{apiName='").append(this.f530a).append('\'').append(", jsonObject=").append(this.f531b).append('}').toString();
        }
    }

    public C0409d4(C0475n0 c0475n0) {
        this.f521a = c0475n0;
        HandlerThread handlerThread = new HandlerThread(C0380a.m252a("bd_tracker_profile:").append(c0475n0.f834d.f784m).toString());
        handlerThread.start();
        this.f522b = new Handler(handlerThread.getLooper(), this);
    }

    /* renamed from: a */
    public void m331a(JSONObject jSONObject) {
        m328a(105, new b("append", jSONObject));
    }

    /* renamed from: a */
    public final boolean m332a() {
        boolean z;
        String ssid = this.f521a.f834d.getSsid();
        String userUniqueID = this.f521a.f834d.getUserUniqueID();
        String str = this.f525e;
        boolean equals = str != null ? str.equals(ssid) : false;
        this.f525e = ssid;
        if (equals && TextUtils.isEmpty(ssid)) {
            z = Objects.equals(this.f526f, userUniqueID);
            this.f521a.f834d.f764D.debug(9, "ssid both = \"\", uuid is equal: " + z, new Object[0]);
        } else {
            z = true;
        }
        this.f526f = userUniqueID;
        return (equals && z) ? false : true;
    }

    /* renamed from: b */
    public void m333b(JSONObject jSONObject) {
        m328a(103, new b("increment", jSONObject));
    }

    /* renamed from: c */
    public void m334c(JSONObject jSONObject) {
        m328a(100, new b("set", jSONObject));
    }

    /* renamed from: d */
    public void m335d(JSONObject jSONObject) {
        m328a(102, new b("set_once", jSONObject));
    }

    /* renamed from: e */
    public void m336e(JSONObject jSONObject) {
        m328a(104, new b("unset", jSONObject));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x02a5, code lost:
    
        return true;
     */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 100:
                b bVar = (b) message.obj;
                this.f521a.f834d.f764D.debug(9, "Handle set:{}", bVar);
                boolean m332a = m332a();
                Iterator<String> keys = bVar.f531b.keys();
                boolean z = true;
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (this.f523c.containsKey(next) && this.f523c.get(next) != null) {
                        b bVar2 = this.f523c.get(next);
                        if (bVar2 != null) {
                            try {
                                if (C0411e.m363a(bVar.f531b, bVar2.f531b, (String) null)) {
                                }
                            } catch (Throwable th) {
                                this.f521a.f834d.f764D.error(9, "JSON handle failed", th, new Object[0]);
                            }
                        }
                        this.f523c.put(next, bVar);
                    }
                    z = false;
                    this.f523c.put(next, bVar);
                }
                if (!m332a && z) {
                    this.f521a.f834d.f764D.debug(9, "profileSet pass, same filter", new Object[0]);
                    break;
                } else {
                    this.f521a.f834d.f764D.debug(9, "invoke profile set.", new Object[0]);
                    m329a(bVar);
                    break;
                }
                break;
            case 102:
                b bVar3 = (b) message.obj;
                this.f521a.f834d.f764D.debug(9, "Handle setOnce:{}", bVar3);
                boolean m332a2 = m332a();
                Iterator<String> keys2 = bVar3.f531b.keys();
                boolean z2 = true;
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (!this.f524d.contains(next2)) {
                        z2 = false;
                    }
                    this.f524d.add(next2);
                }
                if (!m332a2 && z2) {
                    this.f521a.f834d.f764D.debug(9, "profileSetOnce pass, same filter", new Object[0]);
                    break;
                } else {
                    this.f521a.f834d.f764D.debug(9, "invoke profile set once.", new Object[0]);
                    m329a(bVar3);
                    break;
                }
            case 103:
                b bVar4 = (b) message.obj;
                this.f521a.f834d.f764D.debug(9, "Handle increment:{}", bVar4);
                m329a(bVar4);
                break;
            case 104:
                b bVar5 = (b) message.obj;
                this.f521a.f834d.f764D.debug(9, "Handle unset:{}", bVar5);
                m329a(bVar5);
                break;
            case 105:
                b bVar6 = (b) message.obj;
                this.f521a.f834d.f764D.debug(9, "Handle append:{}", bVar6);
                m329a(bVar6);
                break;
            case 106:
                C0475n0 c0475n0 = this.f521a;
                if (c0475n0 != null) {
                    c0475n0.f834d.f764D.debug(9, "Handle flush with dr state:{}", Integer.valueOf(c0475n0.f839i.m426i()));
                    if (this.f521a.f839i.m426i() != 0) {
                        Map<String, List<C0556y4>> m695b = this.f521a.m550c().m695b(this.f521a.f834d.f784m);
                        if (!m695b.isEmpty()) {
                            HashSet hashSet = new HashSet();
                            for (Map.Entry<String, List<C0556y4>> entry : m695b.entrySet()) {
                                String key = entry.getKey();
                                JSONArray jSONArray = new JSONArray();
                                try {
                                    JSONObject jSONObject = new JSONObject();
                                    C0411e.m351a(jSONObject, this.f521a.f834d.getHeader());
                                    boolean m376c = C0411e.m376c(key);
                                    Object obj = key;
                                    if (m376c) {
                                        obj = JSONObject.NULL;
                                    }
                                    jSONObject.put("user_unique_id", obj);
                                    jSONObject.remove("ssid");
                                    JSONObject jSONObject2 = new JSONObject();
                                    for (C0556y4 c0556y4 : entry.getValue()) {
                                        jSONArray.put(c0556y4.m579h());
                                        if (C0411e.m379d(c0556y4.f878i) && !jSONObject.has("ssid")) {
                                            jSONObject.put("ssid", c0556y4.f878i);
                                        }
                                        hashSet.add(c0556y4.f885p);
                                    }
                                    if (!this.f521a.m544a(jSONObject)) {
                                        this.f521a.f834d.f764D.warn(9, "Register to get ssid by temp header failed.", new Object[0]);
                                    } else {
                                        jSONObject2.put("event_v3", jSONArray);
                                        jSONObject2.put("magic_tag", "ss_app_log");
                                        jSONObject2.put("header", jSONObject);
                                        jSONObject2.put("time_sync", C0444i4.f666d);
                                        jSONObject2.put("local_time", System.currentTimeMillis() / 1000);
                                        this.f521a.m550c().m690a(entry.getValue());
                                        if (this.f521a.f834d.f782k.m462a(new String[]{this.f521a.m554e().getProfileUri()}, jSONObject2, this.f521a.f835e) != 200) {
                                            this.f521a.m550c().m703d(entry.getValue());
                                            m330a((Set<String>) hashSet, false);
                                        } else {
                                            m330a((Set<String>) hashSet, true);
                                        }
                                    }
                                } catch (Throwable th2) {
                                    this.f521a.f834d.f764D.error(9, "Flush failed", th2, new Object[0]);
                                    this.f521a.f834d.m522b().mo639a(th2, "profile flush");
                                    m330a((Set<String>) hashSet, false);
                                }
                            }
                            break;
                        }
                    }
                }
                break;
        }
    }

    /* renamed from: a */
    public final void m329a(b bVar) {
        if (this.f521a == null) {
            return;
        }
        C0556y4 c0556y4 = new C0556y4(C0380a.m252a("__profile_").append(bVar.f530a).toString(), bVar.f531b.toString());
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(this.f521a.m552d())) {
            C0475n0 c0475n0 = this.f521a;
            c0475n0.f844n.m651a(c0475n0.f834d, c0556y4, arrayList);
        } else {
            C0475n0 c0475n02 = this.f521a;
            c0475n02.f844n.m650a(c0475n02.f834d, c0556y4);
        }
        this.f521a.m547b(c0556y4);
        arrayList.add(c0556y4);
        this.f521a.m550c().m702c(arrayList);
        this.f522b.sendMessageDelayed(this.f522b.obtainMessage(106), 500L);
    }

    /* renamed from: a */
    public final void m328a(int i, b bVar) {
        if (this.f521a.f834d.f795x) {
            return;
        }
        Handler handler = this.f522b;
        handler.sendMessage(handler.obtainMessage(i, bVar));
    }

    /* renamed from: a */
    public final void m330a(Set<String> set, boolean z) {
        if (LogUtils.isDisabled() || set == null || set.isEmpty()) {
            return;
        }
        LogUtils.sendJsonFetcher("event_upload_eid", new a(this, set, this.f521a.f834d.f784m, z));
    }
}
