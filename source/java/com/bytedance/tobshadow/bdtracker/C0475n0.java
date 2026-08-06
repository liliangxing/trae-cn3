package com.bytedance.tobshadow.bdtracker;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.tobshadow.applog.IHeaderCustomTimelyCallback;
import com.bytedance.tobshadow.applog.IPullAbTestConfigCallback;
import com.bytedance.tobshadow.applog.InitConfig;
import com.bytedance.tobshadow.applog.UriConfig;
import com.bytedance.tobshadow.applog.collector.Collector;
import com.bytedance.tobshadow.applog.log.EventBus;
import com.bytedance.tobshadow.applog.log.LogUtils;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.applog.network.RangersHttpTimeoutException;
import com.bytedance.tobshadow.applog.store.p007kv.IKVStore;
import com.bytedance.tobshadow.applog.util.UriConstants;
import com.bytedance.tobshadow.bdtracker.C0510s0;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.conversation.voice.subtask.SubTaskUiState;
import com.bytedance.trae.home.solo.sitemessage.SiteMessageParams;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.n0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0475n0 implements Handler.Callback, Comparator<AbstractC0479n4> {

    /* renamed from: A */
    public final C0409d4 f823A;

    /* renamed from: B */
    public final C0509s f824B;

    /* renamed from: C */
    public final C0539w1 f825C;

    /* renamed from: D */
    public long f826D;

    /* renamed from: H */
    public final C0385a4 f830H;

    /* renamed from: b */
    public C0454k0 f832b;

    /* renamed from: c */
    public boolean f833c;

    /* renamed from: d */
    public final C0467m f834d;

    /* renamed from: e */
    public final C0407d2 f835e;

    /* renamed from: f */
    public C0468m0 f836f;

    /* renamed from: h */
    public volatile C0521t4 f838h;

    /* renamed from: i */
    public final C0421f2 f839i;

    /* renamed from: j */
    public volatile Handler f840j;

    /* renamed from: k */
    public C0496q0 f841k;

    /* renamed from: l */
    public C0503r0 f842l;

    /* renamed from: m */
    public volatile C0447j0 f843m;

    /* renamed from: o */
    public UriConfig f845o;

    /* renamed from: p */
    public final Handler f846p;

    /* renamed from: q */
    public InterfaceC0526u2 f847q;

    /* renamed from: r */
    public volatile boolean f848r;

    /* renamed from: s */
    public AbstractC0461l0 f849s;

    /* renamed from: t */
    public volatile C0489p0 f850t;

    /* renamed from: v */
    public volatile boolean f852v;

    /* renamed from: w */
    public volatile long f853w;

    /* renamed from: y */
    public volatile AbstractC0476n1 f855y;

    /* renamed from: z */
    public volatile InitConfig.IpcDataChecker f856z;

    /* renamed from: a */
    public long f831a = SubTaskUiState.LONG_RUNNING_THRESHOLD_MS;

    /* renamed from: g */
    public final ArrayList<AbstractC0479n4> f837g = new ArrayList<>(32);

    /* renamed from: u */
    public final CopyOnWriteArrayList<AbstractC0461l0> f851u = new CopyOnWriteArrayList<>();

    /* renamed from: x */
    public final List<d> f854x = new ArrayList();

    /* renamed from: E */
    public volatile boolean f827E = false;

    /* renamed from: F */
    public volatile boolean f828F = false;

    /* renamed from: n */
    public final C0510s0 f844n = new C0510s0(this);

    /* renamed from: G */
    public final C0482o0 f829G = new C0482o0(this);

    /* renamed from: com.bytedance.tobshadow.bdtracker.n0$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class a implements EventBus.DataFetcher {
        public a() {
        }

        @Override // com.bytedance.tobshadow.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appId", C0475n0.this.f834d.f784m);
                jSONObject.put("isMainProcess", C0475n0.this.f835e.m323j());
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.n0$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class b implements InterfaceC0488p {
        public b() {
        }

        /* renamed from: a */
        public void m561a(Map<String, String> map) {
            if (C0475n0.this.f839i.m420f() == null || C0475n0.this.f839i.m420f().opt("oaid") != null || map == null) {
                return;
            }
            C0475n0.this.f840j.obtainMessage(17, map).sendToTarget();
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.n0$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ List f859a;

        public c(List list) {
            this.f859a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0503r0 c0503r0 = C0475n0.this.f842l;
            List list = this.f859a;
            if (list == null || list.size() <= 0) {
                return;
            }
            C0542w4 c0542w4 = new C0542w4();
            C0475n0 c0475n0 = C0475n0.this;
            C0503r0 c0503r02 = c0475n0.f842l;
            JSONObject m370b = C0411e.m370b(c0475n0.f839i.m420f());
            IHeaderCustomTimelyCallback headerCustomCallback = c0503r02.f735f.getHeaderCustomCallback();
            if (headerCustomCallback != null) {
                headerCustomCallback.updateHeader(m370b);
            }
            c0542w4.f1197y = m370b;
            c0542w4.f882m = C0475n0.this.f834d.f784m;
            ArrayList arrayList = new ArrayList();
            for (AbstractC0479n4 abstractC0479n4 : this.f859a) {
                if (abstractC0479n4 instanceof C0528u4) {
                    arrayList.add((C0528u4) abstractC0479n4);
                }
            }
            c0542w4.f1191s = arrayList;
            c0542w4.m731m();
            c0542w4.m732n();
            c0542w4.f1198z = c0542w4.m733o();
            if (c0503r0 != null && c0503r0.m628a(c0542w4)) {
                C0475n0 c0475n02 = C0475n0.this;
                c0475n02.f826D = 0L;
                C0521t4 m550c = c0475n02.m550c();
                m550c.f1072c.m657a(this.f859a);
                return;
            }
            C0475n0.this.f826D = System.currentTimeMillis();
            C0475n0.this.f846p.obtainMessage(8, this.f859a).sendToTarget();
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.n0$d */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static abstract class d<T> {

        /* renamed from: a */
        public T f861a;

        public d(T t) {
            this.f861a = t;
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.n0$e */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class e extends d<String> {
        public e(String str) {
            super(str);
        }
    }

    public C0475n0(C0467m c0467m, C0407d2 c0407d2, C0421f2 c0421f2, C0539w1 c0539w1) {
        this.f834d = c0467m;
        this.f835e = c0407d2;
        this.f839i = c0421f2;
        this.f825C = c0539w1;
        HandlerThread handlerThread = new HandlerThread(C0380a.m252a("bd_tracker_w:").append(c0467m.f784m).toString());
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.f846p = handler;
        C0509s c0509s = new C0509s(this);
        this.f824B = c0509s;
        if (c0407d2.f502c.isDeferredALinkEnabled()) {
            c0467m.addDataObserver(c0509s);
        }
        c0421f2.f591h.f753b.m594a(handler);
        if (c0421f2.f586c.f502c.isMigrateEnabled()) {
            Context context = c0421f2.f585b;
            try {
                try {
                    if (C0519t2.m670a(context).f1051c) {
                        C0407d2 c0407d22 = c0421f2.f586c;
                        if (c0407d22 != null) {
                            c0407d22.f505f.remove("google_aid");
                        }
                        IKVStore iKVStore = c0421f2.f590g;
                        String m512b = c0421f2.f591h.m512b();
                        if (iKVStore != null) {
                            iKVStore.putString("old_did", m512b);
                            iKVStore.putBoolean("is_migrate", true);
                        }
                        c0421f2.f591h.m511a("openudid");
                        c0421f2.f591h.m511a("clientudid");
                        c0421f2.f591h.m511a("serial_number");
                        c0421f2.f591h.m511a("sim_serial_number");
                        c0421f2.f591h.m511a("udid");
                        c0421f2.f591h.m511a("udid_list");
                        c0421f2.f591h.m511a("device_id");
                        c0421f2.m410b("clearMigrationInfo");
                    }
                } catch (Exception e2) {
                    LoggerImpl.global().debug("detect migrate is error, ", e2);
                }
                try {
                    C0519t2.m670a(context).m672a();
                } catch (Throwable unused) {
                }
            } catch (Throwable th) {
                try {
                    C0519t2.m670a(context).m672a();
                } catch (Throwable unused2) {
                }
                throw th;
            }
        }
        this.f823A = new C0409d4(this);
        if (this.f835e.f502c.isClearDidAndIid()) {
            this.f839i.m410b(this.f835e.f502c.getClearKey());
        }
        if (this.f835e.f502c.getIpcDataChecker() != null && !this.f835e.m323j()) {
            this.f856z = this.f835e.f502c.getIpcDataChecker();
        }
        if (this.f835e.m324k()) {
            this.f847q = new C0561z2(this);
        }
        this.f846p.sendEmptyMessage(10);
        if (this.f835e.f502c.autoStart()) {
            m560i();
        }
        this.f830H = new C0385a4(this);
    }

    /* renamed from: a */
    public void m536a() {
        C0404d.m306a(new b());
    }

    /* renamed from: a */
    public void m539a(Long l) {
        long j = 0;
        if (l != null && l.longValue() > 0) {
            j = l.longValue();
        }
        this.f831a = j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:
    
        if (com.bytedance.tobshadow.bdtracker.C0411e.m361a(r2) == false) goto L14;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m544a(JSONObject jSONObject) {
        String optString;
        if (jSONObject == null) {
            return false;
        }
        if (C0411e.m379d(jSONObject.optString("ssid", ""))) {
            return true;
        }
        this.f834d.f764D.debug("Register to get ssid by temp header...", new Object[0]);
        try {
            JSONObject jSONObject2 = new JSONObject();
            C0411e.m351a(jSONObject2, jSONObject);
            JSONObject m614b = this.f841k.m614b(jSONObject2);
            if (m614b != null) {
                optString = m614b.optString("ssid", "");
            }
            optString = null;
            if (C0411e.m379d(optString)) {
                this.f834d.f764D.debug("Register to get ssid by header success.", new Object[0]);
                jSONObject.put("ssid", optString);
                return true;
            }
        } catch (Throwable th) {
            this.f834d.f764D.error("JSON handle failed", th, new Object[0]);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m545a(boolean z) {
        if ((!this.f833c || z) && this.f840j != null) {
            this.f833c = true;
            this.f840j.removeMessages(11);
            this.f840j.sendEmptyMessage(11);
        }
        return this.f833c;
    }

    /* renamed from: b */
    public Context m546b() {
        return this.f834d.f785n;
    }

    /* renamed from: b */
    public void m549b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f823A.m331a(jSONObject);
    }

    /* renamed from: c */
    public C0521t4 m550c() {
        if (this.f838h == null) {
            synchronized (this) {
                C0521t4 c0521t4 = this.f838h;
                if (c0521t4 == null) {
                    c0521t4 = new C0521t4(this, this.f835e.f502c.getDbName());
                }
                this.f838h = c0521t4;
            }
        }
        return this.f838h;
    }

    /* renamed from: c */
    public void m551c(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f823A.m333b(jSONObject);
    }

    @Override // java.util.Comparator
    public int compare(AbstractC0479n4 abstractC0479n4, AbstractC0479n4 abstractC0479n42) {
        long j = abstractC0479n4.f872c - abstractC0479n42.f872c;
        if (j < 0) {
            return -1;
        }
        return j > 0 ? 1 : 0;
    }

    /* renamed from: d */
    public String m552d() {
        C0510s0 c0510s0 = this.f844n;
        if (c0510s0 != null) {
            return c0510s0.f998e;
        }
        return null;
    }

    /* renamed from: d */
    public void m553d(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f823A.m334c(jSONObject);
    }

    /* renamed from: e */
    public UriConfig m554e() {
        if (this.f845o == null) {
            UriConfig uriConfig = this.f835e.f502c.getUriConfig();
            this.f845o = uriConfig;
            if (uriConfig == null) {
                this.f845o = UriConstants.createUriConfig(0);
            }
        }
        return this.f845o;
    }

    /* renamed from: e */
    public void m555e(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f823A.m335d(jSONObject);
    }

    /* renamed from: f */
    public void m556f(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f823A.m336e(jSONObject);
    }

    /* renamed from: f */
    public final boolean m557f() {
        return this.f835e.m321h() && !TextUtils.isEmpty(m554e().getAbUri());
    }

    /* renamed from: g */
    public boolean m558g() {
        C0407d2 c0407d2 = this.f835e;
        return c0407d2.f518s == 1 && c0407d2.f502c.isAutoTrackEnabled();
    }

    /* renamed from: h */
    public void m559h() {
        this.f846p.sendEmptyMessage(10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.bytedance.tobshadow.bdtracker.s0$a] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.bytedance.tobshadow.bdtracker.n1] */
    /* JADX WARN: Type inference failed for: r3v5 */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Map<String, ?> map;
        Set set;
        Set set2;
        String str;
        String str2;
        ?? r3 = 0;
        String[] strArr = null;
        r3 = 0;
        r3 = 0;
        switch (message.what) {
            case 1:
                this.f834d.f764D.info("AppLog is starting...", new Object[0]);
                C0407d2 c0407d2 = this.f835e;
                c0407d2.f518s = c0407d2.f505f.getBoolean("bav_log_collect", c0407d2.f502c.isAutoTrackEnabled()) ? 1 : 0;
                if (this.f839i.m437r()) {
                    if (this.f835e.m323j()) {
                        HandlerThread handlerThread = new HandlerThread(C0380a.m252a("bd_tracker_n:").append(this.f834d.f784m).toString());
                        handlerThread.start();
                        this.f840j = new Handler(handlerThread.getLooper(), this);
                        this.f840j.sendEmptyMessage(2);
                        if (this.f837g.size() > 0) {
                            this.f846p.removeMessages(4);
                            this.f846p.sendEmptyMessageDelayed(4, 1000L);
                        }
                        Application application = this.f834d.f785n;
                        C0522t5.f1073a = true;
                        C0426g0.f610a.submit(new RunnableC0529u5(application));
                        this.f834d.f764D.info("AppLog started on main process.", new Object[0]);
                    } else {
                        this.f834d.f764D.info("AppLog started on secondary process.", new Object[0]);
                    }
                    m550c().m687a();
                    if (!LogUtils.isDisabled()) {
                        LogUtils.sendJsonFetcher("start_end", new a());
                    }
                } else {
                    this.f834d.f764D.info("AppLog is not ready, will try start again after 1 second...", new Object[0]);
                    this.f846p.removeMessages(1);
                    this.f846p.sendEmptyMessageDelayed(1, 1000L);
                }
                return true;
            case 2:
                C0496q0 c0496q0 = new C0496q0(this);
                this.f841k = c0496q0;
                this.f851u.add(c0496q0);
                InitConfig initConfig = this.f835e.f502c;
                if (!((initConfig == null || initConfig.isTrackEventEnabled()) ? false : true)) {
                    C0503r0 c0503r0 = new C0503r0(this);
                    this.f842l = c0503r0;
                    this.f851u.add(c0503r0);
                    this.f827E = true;
                }
                UriConfig m554e = m554e();
                if (!TextUtils.isEmpty(m554e.getSettingUri())) {
                    C0468m0 c0468m0 = new C0468m0(this);
                    this.f836f = c0468m0;
                    this.f851u.add(c0468m0);
                }
                if (!TextUtils.isEmpty(m554e.getProfileUri())) {
                    Handler handler = this.f823A.f522b;
                    handler.sendMessage(handler.obtainMessage(106));
                }
                this.f840j.removeMessages(13);
                this.f840j.sendEmptyMessage(13);
                String m492a = C0453k.m492a(this.f834d, "sp_filter_name");
                if ((this.f839i.f590g.getInt("version_code", 0) == this.f839i.m433n() && TextUtils.equals(this.f835e.f505f.getString(Constant.KEY_CHANNEL, ""), this.f835e.m315b())) ? false : true) {
                    C0496q0 c0496q02 = this.f841k;
                    if (c0496q02 != null) {
                        c0496q02.f731b = true;
                    }
                    C0468m0 c0468m02 = this.f836f;
                    if (c0468m02 != null) {
                        c0468m02.f731b = true;
                    }
                    if (this.f835e.f502c.isEventFilterEnable()) {
                        this.f855y = AbstractC0476n1.m562a(this.f834d.f785n, m492a, null);
                    }
                } else if (this.f835e.f502c.isEventFilterEnable()) {
                    try {
                        IKVStore m438a = C0424f5.m438a(this.f834d.f785n, m492a);
                        HashSet hashSet = new HashSet();
                        HashMap hashMap = new HashMap();
                        try {
                            map = m438a.getAll();
                        } catch (Throwable unused) {
                            map = null;
                        }
                        if (map != null && map.size() > 0) {
                            int i = 0;
                            for (Map.Entry<String, ?> entry : map.entrySet()) {
                                if (entry != null) {
                                    String key = entry.getKey();
                                    if ("is_block".equals(key)) {
                                        i = m438a.getInt("is_block", 0);
                                    } else if ("events".equals(key)) {
                                        try {
                                            set2 = (Set) entry.getValue();
                                        } catch (Throwable unused2) {
                                            set2 = null;
                                        }
                                        if (set2 != null && set2.size() > 0) {
                                            hashSet.addAll(set2);
                                        }
                                    } else if (!TextUtils.isEmpty(key)) {
                                        HashSet hashSet2 = new HashSet();
                                        try {
                                            set = (Set) entry.getValue();
                                        } catch (Throwable unused3) {
                                            set = null;
                                        }
                                        if (set != null && set.size() > 0) {
                                            hashSet2.addAll(set);
                                        }
                                        if (hashSet2.size() > 0) {
                                            hashMap.put(key, hashSet2);
                                        }
                                    }
                                }
                            }
                            r3 = i > 0 ? new C0490p1(hashSet, hashMap) : new C0483o1(hashSet, hashMap);
                        }
                    } catch (Throwable unused4) {
                    }
                    this.f855y = r3;
                }
                this.f840j.removeMessages(6);
                this.f840j.sendEmptyMessage(6);
                InterfaceC0526u2 interfaceC0526u2 = this.f847q;
                if (interfaceC0526u2 != null) {
                    C0561z2 c0561z2 = (C0561z2) interfaceC0526u2;
                    C0407d2 c0407d22 = c0561z2.f1272c.f835e;
                    Intrinsics.checkExpressionValueIsNotNull(c0407d22, "mEngine.config");
                    if (c0407d22.m324k()) {
                        c0561z2.f1271b.m718a(new C0554y2(c0561z2));
                    }
                }
                return true;
            case 3:
            case 5:
            default:
                this.f834d.f764D.error("Unknown handler message type", new Object[0]);
                return true;
            case 4:
                m543a((String[]) message.obj, false);
                return true;
            case 6:
                this.f840j.removeMessages(6);
                long j = 5000;
                if (!this.f834d.f795x && (!this.f835e.f502c.isSilenceInBackground() || this.f844n.m653a())) {
                    Iterator<AbstractC0461l0> it = this.f851u.iterator();
                    long j2 = Long.MAX_VALUE;
                    while (it.hasNext()) {
                        AbstractC0461l0 next = it.next();
                        if (!next.f733d) {
                            long m505a = next.m505a();
                            if (m505a < j2) {
                                j2 = m505a;
                            }
                        }
                    }
                    long currentTimeMillis = j2 - System.currentTimeMillis();
                    if (currentTimeMillis <= 5000) {
                        j = currentTimeMillis;
                    }
                }
                this.f840j.sendEmptyMessageDelayed(6, j);
                if (this.f854x.size() > 0) {
                    synchronized (this.f854x) {
                        for (d dVar : this.f854x) {
                            if (dVar != null) {
                                e eVar = (e) dVar;
                                C0475n0.this.m540a((String) eVar.f861a);
                            }
                        }
                        this.f854x.clear();
                    }
                }
                return true;
            case 7:
                synchronized (this.f837g) {
                    ArrayList<AbstractC0479n4> arrayList = this.f837g;
                    if (C0510s0.f993q == null) {
                        C0510s0.f993q = new C0510s0.b(r3);
                    }
                    C0510s0.f993q.m573a(0L);
                    arrayList.add(C0510s0.f993q);
                }
                m543a((String[]) null, false);
                return true;
            case 8:
                m550c().m702c((ArrayList) message.obj);
                return true;
            case 9:
                AbstractC0461l0 abstractC0461l0 = this.f849s;
                if (abstractC0461l0 != null && !abstractC0461l0.f733d) {
                    long m505a2 = abstractC0461l0.m505a();
                    if (!abstractC0461l0.f733d) {
                        this.f840j.sendEmptyMessageDelayed(9, m505a2 - System.currentTimeMillis());
                    }
                }
                return true;
            case 10:
                synchronized (this.f837g) {
                    this.f834d.f764D.debug("[event_process][receive] dumpData size: " + this.f825C.m721a(this.f837g, this.f834d, this.f844n), new Object[0]);
                }
                C0539w1 c0539w1 = this.f825C;
                int size = c0539w1.f1182b.size();
                if (size > 0) {
                    strArr = new String[size];
                    c0539w1.f1182b.toArray(strArr);
                    c0539w1.f1182b.clear();
                }
                m543a(strArr, false);
                return true;
            case 11:
                C0454k0 c0454k0 = this.f832b;
                if (c0454k0 == null) {
                    C0454k0 c0454k02 = new C0454k0(this);
                    this.f832b = c0454k02;
                    this.f851u.add(c0454k02);
                } else {
                    c0454k0.f733d = false;
                }
                m537a(this.f832b);
                return true;
            case 12:
                Object obj = message.obj;
                m540a(obj != null ? obj.toString() : null);
                return true;
            case 13:
                if (m557f()) {
                    if (this.f843m == null) {
                        this.f843m = new C0447j0(this);
                    }
                    if (!this.f851u.contains(this.f843m)) {
                        this.f851u.add(this.f843m);
                    }
                    m537a(this.f843m);
                } else {
                    if (this.f843m != null) {
                        this.f843m.f733d = true;
                        this.f851u.remove(this.f843m);
                        this.f843m = null;
                    }
                    this.f839i.m402a();
                }
                return true;
            case 14:
                m543a((String[]) null, true);
                return true;
            case 15:
                Object[] objArr = (Object[]) message.obj;
                boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
                String str3 = (String) objArr[1];
                if (this.f850t != null) {
                    this.f850t.f733d = true;
                    this.f851u.remove(this.f850t);
                    this.f850t = null;
                }
                if (booleanValue) {
                    this.f850t = new C0489p0(this, str3);
                    this.f851u.add(this.f850t);
                    this.f840j.removeMessages(6);
                    this.f840j.sendEmptyMessage(6);
                }
                return true;
            case 16:
                m547b((AbstractC0479n4) message.obj);
                return true;
            case 17:
                Map map2 = (Map) message.obj;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("oaid", new JSONObject(map2));
                    String m415d = this.f839i.m415d();
                    String m422g = this.f839i.m422g();
                    jSONObject.put("bd_did", m415d);
                    jSONObject.put("install_id", m422g);
                    if (C0543w5.f1201c.m456b(new Object[0]).booleanValue()) {
                        str = "os";
                        str2 = "Harmony";
                    } else {
                        str = "os";
                        str2 = SiteMessageParams.platform;
                    }
                    jSONObject.put(str, str2);
                    jSONObject.put(Constant.KEY_AID, this.f839i.m412c());
                    this.f834d.f764D.debug("Report oaid success: {}", this.f841k.m615c(jSONObject));
                } catch (Throwable th) {
                    this.f834d.f764D.error("Report oaid failed", th, new Object[0]);
                }
                return true;
            case 18:
                Object obj2 = message.obj;
                if (obj2 instanceof IPullAbTestConfigCallback) {
                    int i2 = message.arg1;
                    IPullAbTestConfigCallback iPullAbTestConfigCallback = (IPullAbTestConfigCallback) obj2;
                    if (!m557f()) {
                        this.f834d.f764D.warn("ABTest is not enabled", new Object[0]);
                    } else {
                        if (this.f843m == null) {
                            this.f843m = new C0447j0(this);
                        }
                        try {
                            JSONObject m484a = this.f843m.m484a(i2);
                            if (iPullAbTestConfigCallback != null) {
                                iPullAbTestConfigCallback.onRemoteConfig(m484a);
                            }
                        } catch (RangersHttpTimeoutException e2) {
                            if (iPullAbTestConfigCallback != null) {
                                iPullAbTestConfigCallback.onTimeoutError();
                            }
                            this.f834d.m522b().mo639a(e2, "doFetchAbConfig timeout");
                        } catch (Throwable th2) {
                            this.f834d.m522b().mo639a(th2, "doFetchAbConfig");
                        }
                    }
                } else {
                    m537a(this.f843m);
                }
                return true;
        }
    }

    /* renamed from: i */
    public final void m560i() {
        this.f848r = true;
        C0421f2 c0421f2 = this.f839i;
        if (c0421f2.f586c.m325l()) {
            C0404d.m307b(c0421f2.f585b);
        }
        this.f846p.sendEmptyMessage(1);
    }

    /* renamed from: b */
    public void m547b(AbstractC0479n4 abstractC0479n4) {
        C0489p0 c0489p0 = this.f850t;
        if (c0489p0 == null) {
            return;
        }
        String str = c0489p0.f907g;
        if (!(abstractC0479n4 instanceof C0535v4) && !(abstractC0479n4 instanceof C0386a5) && !(abstractC0479n4 instanceof C0556y4) && !(abstractC0479n4 instanceof C0549x4)) {
            AbstractC0479n4.m567a(abstractC0479n4, this.f839i.m434o());
        }
        if ((abstractC0479n4 instanceof C0528u4) || (abstractC0479n4 instanceof C0500q4) || (abstractC0479n4 instanceof C0556y4)) {
            JSONObject m579h = abstractC0479n4.m579h();
            if ((abstractC0479n4 instanceof C0500q4) && !m579h.has(Fields.EVENT)) {
                try {
                    m579h.put(Fields.EVENT, m579h.optString("log_type", ((C0500q4) abstractC0479n4).f948s));
                } catch (Throwable unused) {
                }
            }
            this.f834d.f782k.m470a(m579h, str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x01b1, code lost:
    
        if ((r10.f835e.m312a(r11) && m550c().m681a(r10.f834d.f784m) >= r11) != false) goto L97;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m543a(String[] strArr, boolean z) {
        ArrayList<AbstractC0479n4> arrayList;
        Handler handler;
        List<AbstractC0479n4> m309a;
        InitConfig initConfig = this.f835e.f502c;
        boolean z2 = (initConfig == null || initConfig.isTrackEventEnabled()) ? false : true;
        if (this.f834d.f795x || z2) {
            return;
        }
        synchronized (this.f837g) {
            arrayList = (ArrayList) this.f837g.clone();
            this.f837g.clear();
        }
        if (strArr != null) {
            arrayList.ensureCapacity(arrayList.size() + strArr.length);
            for (String str : strArr) {
                AbstractC0479n4 m566a = AbstractC0479n4.m566a(str);
                this.f844n.m650a(this.f834d, m566a);
                arrayList.add(m566a);
            }
        }
        if (!arrayList.isEmpty()) {
            boolean isEventFilterEnable = this.f835e.f502c.isEventFilterEnable();
            AbstractC0476n1 abstractC0476n1 = this.f855y;
            AbstractC0476n1 abstractC0476n12 = this.f834d.f794w;
            if ((isEventFilterEnable && abstractC0476n1 != null) || abstractC0476n12 != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    AbstractC0479n4 abstractC0479n4 = (AbstractC0479n4) it.next();
                    if (abstractC0479n4 instanceof C0528u4) {
                        C0528u4 c0528u4 = (C0528u4) abstractC0479n4;
                        String str2 = c0528u4.f1104u;
                        String mo577e = c0528u4.mo577e();
                        if ((abstractC0476n12 != null && !abstractC0476n12.m564a(str2, mo577e)) || (abstractC0476n1 != null && !abstractC0476n1.m564a(str2, mo577e))) {
                            it.remove();
                        }
                    }
                }
            }
        }
        this.f835e.f519t.m741a(arrayList, this);
        if (arrayList.size() > 0) {
            if (this.f835e.m323j()) {
                Collections.sort(arrayList, this);
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                boolean z3 = false;
                boolean z4 = false;
                for (AbstractC0479n4 abstractC0479n42 : arrayList) {
                    this.f844n.m652a(abstractC0479n42, arrayList2, this.f834d);
                    if (abstractC0479n42 instanceof C0549x4) {
                        z4 = C0510s0.m647a(abstractC0479n42);
                        z3 = true;
                    }
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        m547b(abstractC0479n42);
                    } else if (this.f840j != null) {
                        this.f840j.obtainMessage(16, abstractC0479n42).sendToTarget();
                    }
                    LogUtils.sendObject("event_process", abstractC0479n42);
                }
                if (!this.f827E) {
                    this.f834d.f764D.warn("can't not use realtime event", new Object[0]);
                } else if (this.f839i.m435p() && System.currentTimeMillis() - this.f826D >= 60000 && (m309a = this.f835e.m309a(arrayList2)) != null && m309a.size() > 0) {
                    if (m309a.size() <= 200) {
                        m542a(m309a);
                    } else {
                        int size = (m309a.size() / 200) + (m309a.size() % 200 == 0 ? 0 : 1);
                        for (int i = 0; i < size; i++) {
                            int i2 = i * 200;
                            m542a(m309a.subList(i2, Math.min(i2 + 200, m309a.size())));
                        }
                    }
                }
                m550c().m702c(arrayList2);
                if (z3 && (handler = this.f846p) != null) {
                    if (z4) {
                        handler.removeMessages(7);
                    } else {
                        handler.sendEmptyMessageDelayed(7, this.f835e.m317d());
                    }
                }
                C0510s0 c0510s0 = this.f844n;
                boolean z5 = c0510s0.f1009p;
                c0510s0.f1009p = false;
                if (!z5) {
                    int i3 = this.f835e.f505f.getInt("batch_event_size", -1);
                }
                m537a(this.f842l);
                if (!this.f833c && this.f844n.f1003j && this.f840j != null && this.f835e.f502c.isAutoActive()) {
                    m545a(false);
                }
            } else {
                Intent intent = new Intent(this.f834d.f785n, (Class<?>) Collector.class);
                int size2 = arrayList.size();
                String[] strArr2 = new String[size2];
                int i4 = 0;
                for (int i5 = 0; i5 < size2; i5++) {
                    String jSONObject = ((AbstractC0479n4) arrayList.get(i5)).m578g().toString();
                    strArr2[i5] = jSONObject;
                    i4 += jSONObject.length();
                }
                if (i4 >= 307200 && this.f856z != null) {
                    try {
                        r1 = this.f856z.checkIpcData(strArr2);
                    } catch (Throwable th) {
                        this.f834d.f764D.warn("check ipc data", th);
                    }
                }
                if (r1) {
                    intent.putExtra("K_DATA", strArr2);
                    this.f834d.f785n.sendBroadcast(intent);
                }
            }
        }
        if (z && this.f835e.m323j()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.f853w) > SubTaskUiState.LONG_RUNNING_THRESHOLD_MS) {
                this.f853w = currentTimeMillis;
                m537a(this.f842l);
            }
        }
    }

    /* renamed from: b */
    public final void m548b(String str, String str2) {
        boolean isEmpty = TextUtils.isEmpty(this.f839i.m431l());
        this.f828F = true;
        this.f839i.m427i(str);
        this.f839i.m429j(str2);
        this.f839i.m425h("");
        this.f828F = false;
        this.f839i.m416d("$tr_web_ssid");
        if (this.f835e.f502c.isClearABCacheOnUserChange() && !isEmpty) {
            this.f839i.m421f(null);
            this.f839i.f595l.clear();
        }
        C0447j0 c0447j0 = this.f843m;
        if (c0447j0 != null) {
            c0447j0.f696g.set(0L);
        }
        this.f852v = true;
        if (this.f840j != null) {
            this.f840j.sendMessage(this.f840j.obtainMessage(12, str));
            return;
        }
        synchronized (this.f854x) {
            this.f854x.add(new e(str));
        }
    }

    /* renamed from: a */
    public void m538a(AbstractC0479n4 abstractC0479n4) {
        int size;
        if (abstractC0479n4.f872c == 0) {
            this.f834d.f764D.warn("Data ts is 0", new Object[0]);
        }
        synchronized (this.f837g) {
            size = this.f837g.size();
            this.f837g.add(abstractC0479n4);
            this.f844n.m651a(this.f834d, abstractC0479n4, this.f837g);
        }
        boolean z = abstractC0479n4 instanceof C0549x4;
        if (size % 10 == 0 || z) {
            this.f846p.removeMessages(4);
            if (z || size != 0) {
                this.f846p.sendEmptyMessage(4);
            } else {
                this.f846p.sendEmptyMessageDelayed(4, 200L);
            }
        }
    }

    /* renamed from: a */
    public final void m540a(String str) {
        JSONObject jSONObject = new JSONObject();
        C0411e.m351a(jSONObject, this.f839i.m420f());
        try {
            C0496q0 c0496q0 = this.f841k;
            if (c0496q0 == null || !c0496q0.m613a(jSONObject)) {
                return;
            }
            if (C0411e.m379d(str)) {
                this.f835e.f505f.putInt("is_first_time_launch", 1);
            }
            m545a(true);
        } catch (Throwable th) {
            this.f834d.f764D.error("Register new uuid:{} failed", th, str);
        }
    }

    /* renamed from: a */
    public final void m542a(List<AbstractC0479n4> list) {
        C0426g0.f610a.execute(new c(list));
    }

    /* renamed from: a */
    public void m541a(String str, String str2) {
        String m431l = this.f839i.m431l();
        String m432m = this.f839i.m432m();
        boolean z = false;
        if (C0411e.m362a(str, m431l) && C0411e.m362a(str2, m432m)) {
            this.f834d.f764D.debug("setUserUniqueId not change", new Object[0]);
            return;
        }
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        C0549x4 m279a = C0389b0.m279a();
        boolean m379d = C0411e.m379d(this.f844n.f998e);
        if (m379d && m279a != null) {
            m279a = (C0549x4) m279a.m1094clone();
            m279a.f882m = this.f834d.f784m;
            long j = currentTimeMillis - m279a.f872c;
            m279a.m573a(currentTimeMillis);
            if (j < 0) {
                j = 0;
            }
            m279a.f1241s = j;
            m279a.f1237B = this.f844n.f1007n;
            this.f844n.m650a(this.f834d, m279a);
            arrayList.add(m279a);
        }
        m548b(str, str2);
        if (m279a == null) {
            m279a = C0389b0.f461j;
        } else {
            z = true;
        }
        if (m379d && m279a != null) {
            C0549x4 c0549x4 = (C0549x4) m279a.m1094clone();
            c0549x4.m573a(currentTimeMillis + 1);
            c0549x4.f1241s = -1L;
            this.f844n.m649a(this.f834d, c0549x4, arrayList, true).f1138v = this.f844n.f1007n;
            if (z) {
                this.f844n.m650a(this.f834d, c0549x4);
                arrayList.add(c0549x4);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            m538a((AbstractC0479n4) it.next());
        }
        this.f846p.sendEmptyMessage(14);
    }

    /* renamed from: a */
    public final void m537a(AbstractC0461l0 abstractC0461l0) {
        if (this.f840j == null || abstractC0461l0 == null || this.f834d.f795x) {
            return;
        }
        abstractC0461l0.f731b = true;
        if (Looper.myLooper() == this.f840j.getLooper()) {
            abstractC0461l0.m505a();
        } else {
            this.f840j.removeMessages(6);
            this.f840j.sendEmptyMessage(6);
        }
    }
}
