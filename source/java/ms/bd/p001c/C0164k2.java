package ms.bd.p001c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mobsec.metasec.ml.MSManagerUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import net.openid.appauth.BuildConfig;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: ms.bd.c.k2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0164k2 implements InterfaceC0175m2 {

    /* renamed from: a */
    public final long f208a;

    /* renamed from: b */
    public final Context f209b;

    /* renamed from: c */
    public final AbstractC0116c2 f210c;

    public C0164k2(AbstractC0116c2 abstractC0116c2, Context context, long j) {
        if (context == null) {
            throw new NullPointerException("context could not be null");
        }
        this.f210c = abstractC0116c2;
        this.f209b = context.getApplicationContext();
        this.f208a = j;
    }

    /* renamed from: a */
    public static String m137a(Map map) {
        if (map == null || map.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry entry : map.entrySet()) {
            if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                jSONArray.put(entry.getKey());
                jSONArray.put(entry.getValue());
            }
        }
        return jSONArray.toString();
    }

    @Override // ms.bd.p001c.InterfaceC0175m2
    public final Map frameSign(String str, int i) {
        if (this.f208a == -1) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return Collections.emptyMap();
        }
        String[] strArr = (String[]) AbstractC0190p2.m166a(33554442, i, this.f208a, str, null);
        if ((strArr instanceof String[]) && strArr.length % 2 == 0) {
            for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                String str2 = strArr[i2];
                String str3 = strArr[i2 + 1];
                if (str2 != null && str3 != null) {
                    hashMap.put(str2, str3);
                }
            }
        }
        return hashMap;
    }

    @Override // ms.bd.p001c.InterfaceC0175m2
    public final Map getFeatureHash(String str, byte[] bArr) {
        String[] strArr;
        HashMap hashMap = new HashMap();
        if (str != null && str.length() != 0 && (strArr = (String[]) AbstractC0190p2.m166a(33554438, 0, this.f208a, str, bArr)) != null && strArr.length % 2 == 0) {
            for (int i = 0; i < strArr.length; i += 2) {
                String str2 = strArr[i];
                String str3 = strArr[i + 1];
                if (str2 != null && str3 != null) {
                    hashMap.put(str2, str3);
                }
            }
        }
        return hashMap;
    }

    @Override // ms.bd.p001c.InterfaceC0175m2
    public final Map getReportRaw(String str, int i, Map map) {
        if (this.f208a != -1) {
            Object m166a = AbstractC0190p2.m166a(33554440, i, this.f208a, str, m137a(map));
            if (m166a instanceof Object[]) {
                Object[] objArr = (Object[]) m166a;
                if (objArr.length >= 2 && objArr[0] != null && objArr[1] != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(objArr[0].toString(), objArr[1].toString());
                    return hashMap;
                }
            }
        }
        return Collections.emptyMap();
    }

    @Override // ms.bd.p001c.InterfaceC0175m2
    public final String getToken() {
        long j = this.f208a;
        return j != -1 ? (String) AbstractC0190p2.m166a(33554439, 0, j, null, null) : BuildConfig.FLAVOR;
    }

    @Override // ms.bd.p001c.InterfaceC0175m2
    public final void postEventMessage(MSManagerUtils.MSBusinessHelper mSBusinessHelper) {
        if (this.f208a != -1) {
            AbstractC0190p2.m166a(33554443, 0, 0L, null, mSBusinessHelper);
        }
    }

    @Override // ms.bd.p001c.InterfaceC0175m2
    public final void qurryMsRiskInfo(String str, MSManagerUtils.IMsBundleCallback iMsBundleCallback) {
        C0210t2 c0210t2 = C0210t2.f400b;
        if (c0210t2.f401a.size() < 20 && iMsBundleCallback != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(str, iMsBundleCallback);
            c0210t2.f401a.add(hashMap);
        }
        long j = this.f208a;
        if (j != -1) {
            AbstractC0190p2.m166a(33554450, 0, j, str, null);
        }
    }

    @Override // ms.bd.p001c.InterfaceC0175m2
    public final void report(String str, String str2) {
        if (this.f208a == -1 || TextUtils.isEmpty(str)) {
            return;
        }
        AbstractC0190p2.m166a(33554433, 0, this.f208a, str, str2);
    }

    @Override // ms.bd.p001c.InterfaceC0175m2
    public final void setBDDeviceID(String str) {
        this.f210c.mBDDeviceID = str;
        long j = this.f208a;
        if (j != -1) {
            AbstractC0190p2.m166a(33554437, 0, j, str, this.f209b);
        }
    }

    @Override // ms.bd.p001c.InterfaceC0175m2
    public final void setCollectMode(int i) {
        long j = this.f208a;
        if (j != -1) {
            AbstractC0190p2.m166a(33554441, i, j, null, null);
        }
    }

    @Override // ms.bd.p001c.InterfaceC0175m2
    public final void setCustomInfo(Map map, boolean z) {
        if (this.f208a != -1) {
            String m137a = m137a(map);
            AbstractC0190p2.m166a(33554448, z ? 1 : 0, this.f208a, m137a, null);
        }
    }

    @Override // ms.bd.p001c.InterfaceC0175m2
    public final void setDeviceID(String str) {
        this.f210c.mDeviceID = str;
        long j = this.f208a;
        if (j != -1) {
            AbstractC0190p2.m166a(33554434, 0, j, str, this.f209b);
        }
    }

    @Override // ms.bd.p001c.InterfaceC0175m2
    public final void setInstallID(String str) {
        this.f210c.mInstallID = str;
        long j = this.f208a;
        if (j != -1) {
            AbstractC0190p2.m166a(33554435, 0, j, str, this.f209b);
        }
    }

    @Override // ms.bd.p001c.InterfaceC0175m2
    public final void setMsSettingConfig(String str) {
        if (this.f208a != -1) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (str.contains("content")) {
                    str = new JSONObject(str).getString("content");
                }
                AbstractC0190p2.m166a(33554447, 0, this.f208a, str, this.f209b);
            } catch (Exception unused) {
            }
        }
    }

    @Override // ms.bd.p001c.InterfaceC0175m2
    public final void setSessionID(String str) {
        this.f210c.mSessionID = str;
        long j = this.f208a;
        if (j != -1) {
            AbstractC0190p2.m166a(33554436, 0, j, str, this.f209b);
        }
    }
}
