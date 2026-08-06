package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.Level;
import com.bytedance.tobshadow.applog.network.RangersHttpTimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.j0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0447j0 extends AbstractC0461l0 {

    /* renamed from: g */
    public final AtomicLong f696g;

    /* renamed from: h */
    public JSONObject f697h;

    public C0447j0(C0475n0 c0475n0) {
        super(c0475n0);
        this.f696g = new AtomicLong(0L);
        this.f697h = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00f9 A[Catch: all -> 0x0128, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x000e, B:7:0x0014, B:9:0x0024, B:11:0x002e, B:15:0x003d, B:18:0x006f, B:21:0x00ab, B:23:0x00be, B:27:0x00d4, B:29:0x00f9, B:31:0x011e, B:38:0x00dc, B:40:0x0123, B:41:0x0125, B:44:0x0064, B:17:0x0049, B:20:0x00a7), top: B:2:0x0001, inners: #0, #2 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized JSONObject m484a(int i) {
        boolean z;
        RangersHttpTimeoutException rangersHttpTimeoutException;
        JSONObject jSONObject;
        JSONObject m465a;
        C0475n0 c0475n0 = this.f734e;
        C0407d2 c0407d2 = c0475n0.f835e;
        C0421f2 c0421f2 = c0475n0.f839i;
        if (c0421f2.m426i() != 0 && c0421f2.m420f() != null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f696g.get();
            if (this.f697h != null && currentTimeMillis - j < this.f734e.f831a) {
                this.f735f.f764D.debug(2, "getAbConfig use cache.", new Object[0]);
                return this.f697h;
            }
            this.f696g.set(currentTimeMillis);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("header", c0421f2.m420f());
                jSONObject2.put("magic_tag", "ss_app_log");
                jSONObject2.put("_gen_time", currentTimeMillis);
                C0480n5.m582a(this.f735f, jSONObject2);
            } catch (Throwable th) {
                this.f735f.f764D.error(2, "Set header failed", th, new Object[0]);
            }
            String m501a = this.f735f.f781j.m501a(c0421f2.m420f(), this.f734e.m554e().getAbUri(), true, Level.L1);
            C0444i4 c0444i4 = this.f735f.f782k;
            String m458a = C0444i4.m458a(m501a, C0480n5.f886b);
            c0444i4.f668b.f764D.debug(11, "Start to get ab config to uri:{} with request:{}...", m458a, jSONObject2);
            try {
                String m463a = c0444i4.m463a(jSONObject2, m458a, c0444i4.m464a(), i);
                c0444i4.f668b.f764D.debug(11, "Get ab config with response:{}", m463a);
                m465a = c0444i4.m465a(m463a);
            } finally {
                if (z) {
                }
                jSONObject = null;
                if (jSONObject != null) {
                }
            }
            if (m465a != null && "success".equals(m465a.optString("message", ""))) {
                jSONObject = m465a.optJSONObject("data");
                if (jSONObject != null) {
                    this.f697h = jSONObject;
                    boolean z2 = !C0411e.m372b(c0407d2.m310a(), jSONObject);
                    this.f735f.f764D.debug(2, "getAbConfig changed:{}", Boolean.valueOf(z2));
                    c0421f2.m406a(jSONObject);
                    C0497q1 c0497q1 = this.f735f.f796y;
                    if (c0497q1 != null) {
                        c0497q1.onRemoteAbConfigGet(z2, jSONObject);
                    }
                    return jSONObject;
                }
            }
            jSONObject = null;
            if (jSONObject != null) {
            }
        }
        return null;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: c */
    public boolean mo485c() {
        try {
            return m484a(60000) != null;
        } catch (Throwable th) {
            this.f735f.f764D.error(2, "Do fetch config failed", th, new Object[0]);
            return false;
        }
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: d */
    public String mo486d() {
        return "AbConfigure";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: e */
    public long[] mo487e() {
        return C0496q0.f935h;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: f */
    public boolean mo488f() {
        return true;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: g */
    public long mo489g() {
        long j = this.f734e.f835e.f505f.getLong("abtest_fetch_interval", 0L);
        if (j < 600000) {
            return 600000L;
        }
        return j;
    }
}
