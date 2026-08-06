package com.bytedance.mobsec.metasec.ml;

import android.text.TextUtils;
import com.bytedance.mobsec.metasec.ml.MSConfig;
import com.bytedance.mobsec.metasec.ml.MSManagerUtils;
import java.util.Map;
import ms.bd.c.k2;
import ms.bd.c.m2;
import ms.bd.c.p2;
import ms.bd.c.v2;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class MSManager implements m2 {

    /* renamed from: a */
    private final m2 f55a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MSManager(k2 k2Var) {
        this.f55a = k2Var;
    }

    public Map<String, String> frameSign(String str, int i) {
        return this.f55a.frameSign(str, i);
    }

    public Map<String, String> getFeatureHash(String str, byte[] bArr) {
        return this.f55a.getFeatureHash(str, bArr);
    }

    public Map<String, String> getReportRaw(String str, int i, Map<String, String> map) {
        return this.f55a.getReportRaw(str, i, map);
    }

    public String getToken() {
        return this.f55a.getToken();
    }

    public void postEventMessage(MSManagerUtils.MSBusinessHelper mSBusinessHelper) {
        this.f55a.postEventMessage(mSBusinessHelper);
    }

    public void qurryMsRiskInfo(String str, MSManagerUtils.IMsBundleCallback iMsBundleCallback) {
        this.f55a.qurryMsRiskInfo(str, iMsBundleCallback);
    }

    public void report(String str) {
        report(str, "");
    }

    public void setBDDeviceID(String str) {
        this.f55a.setBDDeviceID(str);
    }

    public void setCollectMode(int i) {
        this.f55a.setCollectMode(i);
    }

    public void setCustomInfo(Map<String, String> map, boolean z) {
        this.f55a.setCustomInfo(map, z);
    }

    public void setDeviceID(String str) {
        this.f55a.setDeviceID(str);
    }

    public void setInstallID(String str) {
        this.f55a.setInstallID(str);
    }

    public void setMsSettingConfig(String str) {
        this.f55a.setMsSettingConfig(str);
    }

    public void setSessionID(String str) {
        this.f55a.setSessionID(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x009d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0096 -> B:14:0x0097). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void report(String str, String str2) {
        String str3;
        String str4;
        MSConfig.Builder.IMsSettingConfig iMsSettingConfig = v2.b.a;
        if (iMsSettingConfig != null && !v2.c) {
            try {
                v2.c = true;
                str4 = iMsSettingConfig.settingConfig();
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(str4) && str4.trim().length() > 3) {
                str3 = str4.contains((String) p2.a(16777217, 0, 0L, "c7679e", new byte[]{113, 58, 75, 87, 3, 124, 116})) ? new JSONObject(str4).getString((String) p2.a(16777217, 0, 0L, "404e20", new byte[]{38, 61, 73, 5, 8, 41, 35})) : str4.trim();
                if (!TextUtils.isEmpty(str3)) {
                    this.f55a.setMsSettingConfig(str3);
                }
                this.f55a.report(str, str2);
            }
        }
        str3 = null;
        if (!TextUtils.isEmpty(str3)) {
        }
        this.f55a.report(str, str2);
    }
}
