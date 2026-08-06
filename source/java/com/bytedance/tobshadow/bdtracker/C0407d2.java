package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.tobshadow.applog.InitConfig;
import com.bytedance.tobshadow.applog.log.EventBus;
import com.bytedance.tobshadow.applog.log.LogUtils;
import com.bytedance.tobshadow.applog.store.p007kv.IKVStore;
import com.bytedance.trae.conversation.imageupload.ImageUploadConstants;
import com.bytedance.trae.conversation.voice.subtask.SubTaskUiState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.d2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0407d2 {

    /* renamed from: a */
    public final Context f500a;

    /* renamed from: b */
    public final C0467m f501b;

    /* renamed from: c */
    public final InitConfig f502c;

    /* renamed from: d */
    public final IKVStore f503d;

    /* renamed from: e */
    public final IKVStore f504e;

    /* renamed from: f */
    public final IKVStore f505f;

    /* renamed from: g */
    public volatile JSONObject f506g;

    /* renamed from: h */
    public volatile String f507h;

    /* renamed from: i */
    public volatile JSONObject f508i;

    /* renamed from: j */
    public final Set<String> f509j;

    /* renamed from: k */
    public volatile HashSet<String> f510k;

    /* renamed from: l */
    public int f511l;

    /* renamed from: m */
    public int f512m;

    /* renamed from: n */
    public long f513n;

    /* renamed from: o */
    public int f514o;

    /* renamed from: p */
    public long f515p;

    /* renamed from: q */
    public boolean f516q;

    /* renamed from: r */
    public boolean f517r;

    /* renamed from: s */
    public int f518s;

    /* renamed from: t */
    public final C0546x1 f519t;

    /* renamed from: com.bytedance.tobshadow.bdtracker.d2$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class a implements EventBus.DataFetcher {
        public a() {
        }

        @Override // com.bytedance.tobshadow.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("appId", C0407d2.this.f501b.f784m);
                long j = C0407d2.this.f505f.getLong("session_interval", 0L);
                jSONObject2.put("后台会话时长", j > 0 ? j + "ms" : "--");
                long j2 = C0407d2.this.f505f.getLong("batch_event_interval", 0L);
                jSONObject2.put("事件上报周期", j2 > 0 ? j2 + "ms" : "--");
                long j3 = C0407d2.this.f505f.getLong("abtest_fetch_interval", 0L);
                jSONObject2.put("AB实验更新周期", j3 > 0 ? j3 + "ms" : "--");
                jSONObject2.put("全埋点开关", C0407d2.this.f505f.getBoolean("bav_log_collect", false));
                jSONObject2.put("AB实验开关", C0407d2.this.f505f.getBoolean("bav_ab_config", false));
                jSONObject2.put("实时埋点事件", C0407d2.this.f505f.getString("real_time_events", "[]"));
                long j4 = C0407d2.this.f505f.getLong("fetch_interval", 0L);
                jSONObject2.put("服务端配置更新周期", j4 > 0 ? j4 + "ms" : "--");
                jSONObject2.put("禁止内部监控开关", C0407d2.this.f505f.getBoolean("applog_disable_monitor", false));
                int i = C0407d2.this.f505f.getInt("batch_event_size", -1);
                jSONObject2.put("事件累计上报数量", (i >= 0 ? Integer.valueOf(i) : "--") + "条");
                jSONObject2.put("禁止采集的敏感字段", C0407d2.this.f505f.getString("sensitive_fields", "--"));
                jSONObject2.put("服务端黑名单事件", C0407d2.this.f509j);
                jSONObject.put("config", jSONObject2);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public C0407d2(C0467m c0467m, Context context, InitConfig initConfig) {
        new HashSet();
        this.f509j = new HashSet();
        this.f511l = 0;
        this.f512m = 27;
        this.f513n = 0L;
        this.f514o = 0;
        this.f515p = 0L;
        this.f516q = false;
        this.f517r = false;
        this.f518s = 1;
        this.f501b = c0467m;
        this.f500a = context;
        this.f502c = initConfig;
        IKVStore m439a = C0424f5.m439a(initConfig, context, initConfig.getSpName());
        this.f505f = m439a;
        this.f503d = C0424f5.m439a(initConfig, context, C0453k.m492a(c0467m, "header_custom"));
        this.f504e = C0424f5.m439a(initConfig, context, C0453k.m492a(c0467m, "last_sp_session"));
        this.f519t = new C0546x1(m439a, c0467m.f764D);
        this.f517r = m439a.getBoolean("page_pack_upload", true);
        m439a.putBoolean("page_pack_upload", false);
        if (m322i()) {
            this.f517r = false;
        }
        c0467m.f764D.debug("loadPagePackFirst isPagePackUpdate: {}", Boolean.valueOf(this.f517r));
    }

    /* renamed from: a */
    public List<AbstractC0479n4> m309a(List<AbstractC0479n4> list) {
        Iterator<AbstractC0479n4> it = list.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            AbstractC0479n4 next = it.next();
            if (next instanceof C0528u4) {
                C0528u4 c0528u4 = (C0528u4) next;
                HashSet<String> hashSet = this.f510k;
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    try {
                        JSONArray jSONArray = new JSONArray(this.f505f.getString("real_time_events", "[]"));
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            String string = jSONArray.getString(i);
                            if (!TextUtils.isEmpty(string)) {
                                hashSet.add(string);
                            }
                        }
                    } catch (Throwable th) {
                        this.f501b.f764D.error(Collections.singletonList("ConfigManager"), "getRealTimeEvents failed", th, new Object[0]);
                        this.f501b.m522b().mo639a(th, "getRealTimeEvents");
                    }
                }
                this.f510k = hashSet;
                if (hashSet.contains(c0528u4.f1104u)) {
                    it.remove();
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0024 A[Catch: all -> 0x002d, TryCatch #1 {, blocks: (B:8:0x0024, B:9:0x0029, B:10:0x002b, B:15:0x0017, B:5:0x0005), top: B:4:0x0005, inners: #0 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject m310a() {
        JSONObject jSONObject = this.f506g;
        if (jSONObject == null) {
            synchronized (this) {
                try {
                    jSONObject = new JSONObject(this.f503d.getString("ab_configure", ""));
                } finally {
                    if (jSONObject == null) {
                    }
                    this.f506g = jSONObject;
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                this.f506g = jSONObject;
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    public boolean m312a(int i) {
        long j = i;
        return j >= 50 && j <= 9999;
    }

    /* renamed from: a */
    public final boolean m313a(long j) {
        return j >= SubTaskUiState.LONG_RUNNING_THRESHOLD_MS && j <= ImageUploadConstants.TOKEN_SAFETY_THRESHOLD_MS;
    }

    /* renamed from: a */
    public final boolean m314a(String str) {
        String string = this.f505f.getString("sensitive_fields", "");
        return !TextUtils.isEmpty(string) && string.contains(str);
    }

    /* renamed from: b */
    public String m315b() {
        String channel = this.f502c.getChannel();
        if (TextUtils.isEmpty(channel)) {
            channel = this.f502c.getTweakedChannel();
        }
        if (!TextUtils.isEmpty(channel)) {
            return channel;
        }
        try {
            return this.f500a.getPackageManager().getApplicationInfo(this.f500a.getPackageName(), 128).metaData.getString("UMENG_CHANNEL");
        } catch (Throwable th) {
            this.f501b.f764D.error(Collections.singletonList("ConfigManager"), "getChannel failed", th, new Object[0]);
            return channel;
        }
    }

    /* renamed from: c */
    public String m316c() {
        String str = this.f507h;
        if (TextUtils.isEmpty(str)) {
            synchronized (this) {
                str = this.f503d.getString("external_ab_version", "");
                this.f507h = str;
            }
        }
        return str;
    }

    /* renamed from: d */
    public long m317d() {
        return this.f505f.getLong("session_interval", 30000L);
    }

    /* renamed from: e */
    public String m318e() {
        return C0380a.m252a("ssid_").append(this.f502c.getAid()).toString();
    }

    /* renamed from: f */
    public String m319f() {
        return this.f503d.getString("user_unique_id", "");
    }

    /* renamed from: g */
    public String m320g() {
        return this.f503d.getString("user_unique_id_type", null);
    }

    /* renamed from: h */
    public boolean m321h() {
        return this.f502c.isAbEnable() && this.f505f.getBoolean("bav_ab_config", this.f502c.isAbEnable());
    }

    /* renamed from: i */
    public boolean m322i() {
        return this.f505f.getBoolean("is_first_app_launch", true);
    }

    /* renamed from: j */
    public boolean m323j() {
        if (this.f502c.getProcess() == 0) {
            String m368b = C0411e.m368b();
            if (TextUtils.isEmpty(m368b)) {
                this.f502c.setProcess(0);
            } else {
                this.f502c.setProcess(m368b.contains(":") ? 2 : 1);
            }
        }
        return this.f502c.getProcess() == 1;
    }

    /* renamed from: k */
    public boolean m324k() {
        return this.f505f.getBoolean("monitor_enabled", this.f502c.isMonitorEnabled());
    }

    /* renamed from: l */
    public boolean m325l() {
        return this.f502c.isOaidEnabled() && !m314a("oaid");
    }

    /* renamed from: m */
    public boolean m326m() {
        return this.f502c.isOperatorInfoEnabled() && !m314a("carrier");
    }

    /* renamed from: n */
    public void m327n() {
        if (LogUtils.isDisabled() || this.f505f.getLong("app_log_last_config_time", 0L) <= 0) {
            return;
        }
        LogUtils.sendJsonFetcher("remote_settings", new a());
    }

    /* renamed from: a */
    public void m311a(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("backoff_ratio", 0);
        this.f511l = optInt;
        if (optInt < 0 || optInt > 10000) {
            this.f511l = 0;
        }
        int i = this.f511l > 0 ? 1 : 27;
        int optInt2 = jSONObject.optInt("max_request_frequency", i);
        this.f512m = optInt2;
        if (optInt2 < 1 || optInt2 > 27) {
            this.f512m = i;
        }
        int i2 = this.f511l;
        if (i2 > 0 && this.f513n == 0) {
            this.f513n = System.currentTimeMillis();
            this.f514o = 1;
        } else if (i2 == 0) {
            this.f513n = 0L;
            this.f514o = 0;
        }
        this.f515p = jSONObject.optLong("batch_event_interval", 0L) * 1000;
        this.f516q = jSONObject.optInt("enter_background_not_send") == 1;
        this.f501b.f764D.debug(Collections.singletonList("ConfigManager"), C0380a.m252a("updateLogRespConfig mBackoffRatio: ").append(this.f511l).append(", mMaxRequestFrequency: ").append(this.f512m).append(", mBackoffWindowStartTime: ").append(this.f513n).append(", mBackoffWindowSendCount: ").append(this.f514o).append(", mEventIntervalFromLogResp: ").append(this.f515p).toString(), new Object[0]);
    }
}
