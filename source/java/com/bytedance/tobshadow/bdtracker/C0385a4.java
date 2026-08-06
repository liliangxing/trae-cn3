package com.bytedance.tobshadow.bdtracker;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.tobshadow.applog.UriConfig;
import com.bytedance.tobshadow.applog.log.IAppLogLogger;
import com.bytedance.tobshadow.applog.oneid.IDBindCallback;
import com.bytedance.tobshadow.applog.oneid.IDBindResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u001e\u0010\u0015\u001a\u00020\u000f*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0002J\u0014\u0010\u0019\u001a\u00020\u000f*\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/tobshadow/applog/oneid/OneIDManager;", "", "engine", "Lcom/bytedance/tobshadow/applog/engine/Engine;", "(Lcom/bytedance/tobshadow/applog/engine/Engine;)V", "appLogInstance", "Lcom/bytedance/tobshadow/applog/AppLogInstance;", "kotlin.jvm.PlatformType", "getEngine", "()Lcom/bytedance/tobshadow/applog/engine/Engine;", "logger", "Lcom/bytedance/tobshadow/applog/log/IAppLogLogger;", "mainHandler", "Landroid/os/Handler;", "bind", "", "identities", "", "", "callback", "Lcom/bytedance/tobshadow/applog/oneid/IDBindCallback;", "reportFail", "code", "", "message", "reportSuccess", "result", "Lcom/bytedance/tobshadow/applog/oneid/IDBindResult;", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* renamed from: com.bytedance.tobshadow.bdtracker.a4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0385a4 {

    /* renamed from: a */
    public final C0467m f438a;

    /* renamed from: b */
    public final Handler f439b;

    /* renamed from: c */
    public final IAppLogLogger f440c;

    /* renamed from: d */
    public final C0475n0 f441d;

    /* renamed from: com.bytedance.tobshadow.bdtracker.a4$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class a implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ Map f443b;

        /* renamed from: c */
        public final /* synthetic */ IDBindCallback f444c;

        public a(Map map, IDBindCallback iDBindCallback) {
            this.f443b = map;
            this.f444c = iDBindCallback;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x010a  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            JSONObject jSONObject;
            int i;
            String str;
            String str2;
            JSONObject jSONObject2 = new JSONObject();
            C0421f2 c0421f2 = C0385a4.this.f441d.f839i;
            Intrinsics.checkExpressionValueIsNotNull(c0421f2, "engine.dm");
            C0411e.m351a(jSONObject2, c0421f2.m420f());
            C0385a4.this.f440c.debug(15, "BindID identities: {}", this.f443b);
            Map map = this.f443b;
            JSONObject jSONObject3 = new JSONObject();
            for (Map.Entry entry : map.entrySet()) {
                jSONObject3.put((String) entry.getKey(), entry.getValue());
            }
            jSONObject2.put("identities", jSONObject3);
            JSONObject m461b = C0444i4.m461b(jSONObject2);
            UriConfig m554e = C0385a4.this.f441d.m554e();
            Intrinsics.checkExpressionValueIsNotNull(m554e, "engine.uriConfig");
            String iDBindUri = m554e.getIDBindUri();
            if (iDBindUri != null) {
                C0467m c0467m = C0385a4.this.f438a;
                Intrinsics.checkExpressionValueIsNotNull(c0467m, "appLogInstance");
                C0444i4 c0444i4 = c0467m.f782k;
                c0444i4.f668b.f764D.debug(11, "Start to bind id to uri:{} with request:{}...", iDBindUri, m461b);
                try {
                    i = 11;
                } catch (Exception e) {
                    e = e;
                    i = 11;
                }
                try {
                    str2 = new String(c0444i4.f668b.getNetClient().execute((byte) 1, c0444i4.f669c.m585a(iDBindUri), m461b, c0444i4.m464a(), (byte) 0, true, 60000));
                } catch (Exception e2) {
                    e = e2;
                    str = null;
                    c0444i4.f668b.f764D.error(i, "bindId error", e, new Object[0]);
                    c0444i4.f668b.m522b().mo639a(e, "bindID");
                    jSONObject = c0444i4.m465a(str);
                    if (jSONObject == null) {
                    }
                }
                try {
                    c0444i4.f668b.f764D.debug(11, "bindId success: {}", str2);
                    str = str2;
                } catch (Exception e3) {
                    e = e3;
                    str = str2;
                    c0444i4.f668b.f764D.error(i, "bindId error", e, new Object[0]);
                    c0444i4.f668b.m522b().mo639a(e, "bindID");
                    jSONObject = c0444i4.m465a(str);
                    if (jSONObject == null) {
                    }
                }
                jSONObject = c0444i4.m465a(str);
            } else {
                jSONObject = null;
            }
            if (jSONObject == null) {
                String m251a = C0380a.m251a("BindID http request error, url=", iDBindUri);
                C0385a4.this.f440c.warn(15, m251a, new Object[0]);
                IDBindCallback iDBindCallback = this.f444c;
                if (iDBindCallback != null) {
                    C0385a4.this.f439b.post(new RunnableC0393b4(iDBindCallback, -2, m251a));
                    return;
                }
                return;
            }
            int optInt = jSONObject.optInt("status_code");
            if (optInt != 200) {
                String optString = jSONObject.optString("status_message");
                C0385a4.this.f440c.warn(15, optString, new Object[0]);
                IDBindCallback iDBindCallback2 = this.f444c;
                if (iDBindCallback2 != null) {
                    C0385a4.this.f439b.post(new RunnableC0393b4(iDBindCallback2, optInt, optString));
                    return;
                }
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            IDBindResult iDBindResult = new IDBindResult(optJSONObject != null ? optJSONObject.optString("ssid") : null, optJSONObject != null ? optJSONObject.optString("failed_id_list") : null);
            C0385a4.this.f440c.debug(15, "BindID reportSuccess, result: {}", iDBindResult);
            IDBindCallback iDBindCallback3 = this.f444c;
            if (iDBindCallback3 != null) {
                C0385a4.this.f439b.post(new RunnableC0401c4(iDBindCallback3, iDBindResult));
            }
        }
    }

    public C0385a4(C0475n0 c0475n0) {
        Intrinsics.checkParameterIsNotNull(c0475n0, "engine");
        this.f441d = c0475n0;
        this.f438a = c0475n0.f834d;
        this.f439b = new Handler(Looper.getMainLooper());
        C0467m c0467m = c0475n0.f834d;
        Intrinsics.checkExpressionValueIsNotNull(c0467m, "engine.appLog");
        this.f440c = c0467m.f764D;
    }

    /* renamed from: a */
    public final void m265a(Map<String, String> map, IDBindCallback iDBindCallback) {
        Intrinsics.checkParameterIsNotNull(map, "identities");
        C0426g0.f610a.submit(new a(map, iDBindCallback));
    }
}
