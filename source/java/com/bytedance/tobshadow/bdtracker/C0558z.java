package com.bytedance.tobshadow.bdtracker;

import android.net.Uri;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.tobshadow.applog.InitConfig;
import com.bytedance.tobshadow.applog.log.EventBus;
import com.bytedance.tobshadow.applog.network.INetworkClient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.z */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0558z {

    /* renamed from: a */
    public C0467m f1263a;

    public C0558z(C0467m c0467m) {
        Intrinsics.checkParameterIsNotNull(c0467m, "appLogInstance");
        this.f1263a = c0467m;
    }

    /* renamed from: a */
    public final C0530v<C0516t> m757a(String str, C0523u c0523u) {
        Intrinsics.checkParameterIsNotNull(str, "uri");
        Intrinsics.checkParameterIsNotNull(c0523u, "queryParam");
        try {
            INetworkClient netClient = this.f1263a.getNetClient();
            C0444i4 c0444i4 = this.f1263a.f782k;
            Intrinsics.checkExpressionValueIsNotNull(c0444i4, "appLogInstance.api");
            byte[] execute = netClient.execute((byte) 0, c0444i4.f669c.m585a(m759a(str, c0523u.mo665a())), null, m760a(), (byte) 0, true, 60000);
            Intrinsics.checkExpressionValueIsNotNull(execute, "appLogInstance.netClient…TIMEOUT\n                )");
            return C0530v.f1106c.m714a(new String(execute, Charsets.UTF_8), C0516t.class);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public final String m759a(String str, JSONObject jSONObject) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject.optString(next);
            if (!(optString == null || optString.length() == 0)) {
                buildUpon.appendQueryParameter(next, jSONObject.optString(next));
            }
        }
        return buildUpon.build().toString();
    }

    /* renamed from: a */
    public final HashMap<String, String> m760a() {
        HashMap hashMap = new HashMap(2);
        InitConfig initConfig = this.f1263a.getInitConfig();
        if (initConfig != null) {
            Map<String, String> httpHeaders = initConfig.getHttpHeaderCallback() != null ? initConfig.getHttpHeaderCallback().get() : initConfig.getHttpHeaders();
            if (httpHeaders != null && (!httpHeaders.isEmpty())) {
                hashMap.putAll(httpHeaders);
            }
        }
        return C0480n5.m581a((HashMap<String, String>) hashMap, this.f1263a);
    }

    /* renamed from: a */
    public final C0530v<C0537w> m758a(String str, C0544x c0544x, C0523u c0523u) {
        Intrinsics.checkParameterIsNotNull(str, "uri");
        Intrinsics.checkParameterIsNotNull(c0544x, OauthTokenTriggerScene.REQUEST);
        Intrinsics.checkParameterIsNotNull(c0523u, "queryParam");
        JSONObject mo665a = c0544x.mo665a();
        JSONObject mo665a2 = c0523u.mo665a();
        Intrinsics.checkParameterIsNotNull(this, "$this$notifyDeferDeepLink");
        Intrinsics.checkParameterIsNotNull(mo665a, OauthTokenTriggerScene.REQUEST);
        Intrinsics.checkParameterIsNotNull(mo665a2, "queryParam");
        try {
            this.f1263a.f764D.debug("Notify DeferDeepLink trigger.", new Object[0]);
            EventBus eventBus = EventBus.global.get(new Object[0]);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(OauthTokenTriggerScene.REQUEST, mo665a);
            jSONObject.put("queryParam", mo665a2);
            eventBus.emit("ALink_DeferDeepLink_App_Log", jSONObject);
        } catch (Exception e) {
            this.f1263a.f764D.error("Notify DeferDeepLink trigger failed.", e, new Object[0]);
        }
        try {
            INetworkClient netClient = this.f1263a.getNetClient();
            C0444i4 c0444i4 = this.f1263a.f782k;
            Intrinsics.checkExpressionValueIsNotNull(c0444i4, "appLogInstance.api");
            byte[] execute = netClient.execute((byte) 1, c0444i4.f669c.m585a(m759a(str, mo665a2)), mo665a, m760a(), (byte) 0, true, 60000);
            Intrinsics.checkExpressionValueIsNotNull(execute, "appLogInstance.netClient…OUT\n                    )");
            return C0530v.f1106c.m714a(new String(execute, Charsets.UTF_8), C0537w.class);
        } catch (Throwable th) {
            return C0530v.f1106c.m715a(th);
        }
    }
}
