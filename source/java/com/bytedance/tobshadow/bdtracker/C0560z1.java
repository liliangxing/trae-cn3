package com.bytedance.tobshadow.bdtracker;

import android.os.Build;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.trae.home.solo.sitemessage.SiteMessageParams;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.z1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0560z1 extends AbstractC0553y1 {

    /* renamed from: e */
    public final C0407d2 f1268e;

    /* renamed from: f */
    public final C0467m f1269f;

    public C0560z1(C0467m c0467m, C0407d2 c0407d2) {
        super(true, false);
        this.f1269f = c0467m;
        this.f1268e = c0407d2;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public String mo253a() {
        return "Build";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public boolean mo255a(JSONObject jSONObject) {
        jSONObject.put("platform", SiteMessageParams.platform);
        jSONObject.put("sdk_lib", SiteMessageParams.platform);
        jSONObject.put(Constant.KEY_DEVICE_MODEL, Build.MODEL);
        jSONObject.put(Constant.KEY_DEVICE_BRAND, Build.BRAND);
        jSONObject.put(Constant.KEY_DEVICE_MANUFACTURER, Build.MANUFACTURER);
        if (this.f1268e.f502c.isCPUAbiEnabled()) {
            jSONObject.put("cpu_abi", Build.CPU_ABI);
        }
        jSONObject.put("sdk_target_version", 29);
        jSONObject.put("git_hash", "f977bc2");
        if (!C0543w5.f1201c.m456b(new Object[0]).booleanValue() || !this.f1268e.f502c.isHarmonyEnabled()) {
            jSONObject.put("os", SiteMessageParams.platform);
            jSONObject.put(Constant.KEY_OS_API, Build.VERSION.SDK_INT);
            jSONObject.put(Constant.KEY_OS_VERSION, Build.VERSION.RELEASE);
            return true;
        }
        jSONObject.put("os", "Harmony");
        try {
            jSONObject.put(Constant.KEY_OS_API, C0557y5.m756a("hw_sc.build.os.apiversion"));
            jSONObject.put(Constant.KEY_OS_VERSION, C0557y5.m756a("hw_sc.build.platform.version"));
            return true;
        } catch (Throwable th) {
            this.f1269f.f764D.error("loadHarmonyInfo failed", th, new Object[0]);
            return true;
        }
    }
}
