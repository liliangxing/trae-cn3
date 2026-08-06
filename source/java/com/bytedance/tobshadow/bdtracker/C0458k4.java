package com.bytedance.tobshadow.bdtracker;

import android.app.Application;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.tobshadow.applog.IExtraParams;
import com.bytedance.tobshadow.applog.Level;
import com.bytedance.tobshadow.applog.UriConfig;
import com.bytedance.tobshadow.applog.encryptor.IEncryptorType;
import com.bytedance.tobshadow.applog.util.SensitiveUtils;
import com.bytedance.trae.home.solo.setting.SettingsTracker;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.k4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0458k4 {

    /* renamed from: c */
    public static final a[] f722c = {new a(Constant.KEY_AID, Constant.KEY_AID, String.class), new a("google_aid", "google_aid", String.class), new a("carrier", "carrier", String.class), new a("sim_region", "sim_region", String.class), new a("device_id", "device_id", String.class), new a("bd_did", "bd_did", String.class), new a("install_id", "iid", String.class), new a("clientudid", "clientudid", String.class), new a("app_name", "app_name", String.class), new a(Constant.KEY_APP_VERSION, "version_name", String.class), new a("version_code", "version_code", Integer.class), new a("manifest_version_code", "manifest_version_code", Integer.class), new a(Constant.KEY_UPDATE_VERSION_CODE, Constant.KEY_UPDATE_VERSION_CODE, Integer.class), new a("sdk_version_code", "sdk_version_code", Integer.class)};

    /* renamed from: a */
    public volatile IExtraParams f723a;

    /* renamed from: b */
    public final C0467m f724b;

    /* renamed from: com.bytedance.tobshadow.bdtracker.k4$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class a {

        /* renamed from: a */
        public final String f725a;

        /* renamed from: b */
        public final String f726b;

        /* renamed from: c */
        public final Class f727c;

        public a(String str, String str2, Class cls) {
            this.f725a = str;
            this.f726b = str2;
            this.f727c = cls;
        }
    }

    public C0458k4(C0467m c0467m) {
        this.f724b = c0467m;
    }

    /* renamed from: a */
    public String m501a(JSONObject jSONObject, String str, boolean z, Level level) {
        if (this.f724b.f785n == null || TextUtils.isEmpty(str)) {
            return str;
        }
        Uri parse = Uri.parse(str);
        Set<String> queryParameterNames = parse.getQueryParameterNames();
        Uri.Builder buildUpon = parse.buildUpon();
        HashMap hashMap = new HashMap();
        m502a(jSONObject, z, hashMap, level);
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!queryParameterNames.contains(key) && !TextUtils.isEmpty(value)) {
                buildUpon.appendQueryParameter(key, entry.getValue());
            }
        }
        return buildUpon.build().toString();
    }

    /* renamed from: a */
    public void m502a(JSONObject jSONObject, boolean z, Map<String, String> map, Level level) {
        HashMap<String, String> hashMap;
        Application application = this.f724b.f785n;
        if (application == null || map == null || level == null) {
            return;
        }
        map.put("_rticket", String.valueOf(System.currentTimeMillis()));
        map.put("device_platform", "android");
        if (z) {
            map.put("ssmix", IEncryptorType.DEFAULT_ENCRYPTOR);
        }
        if (TextUtils.isEmpty(C0564z5.f1277a)) {
            DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();
            int i = displayMetrics == null ? 0 : displayMetrics.widthPixels;
            DisplayMetrics displayMetrics2 = application.getResources().getDisplayMetrics();
            int i2 = displayMetrics2 == null ? 0 : displayMetrics2.heightPixels;
            if (i > 0 && i2 > 0) {
                C0564z5.f1277a = i + "*" + i2;
            }
        }
        String str = C0564z5.f1277a;
        if (!TextUtils.isEmpty(str)) {
            map.put("resolution", str);
        }
        if (C0564z5.f1278b == -1) {
            C0564z5.f1278b = application.getApplicationContext().getResources().getDisplayMetrics().densityDpi;
        }
        int i3 = C0564z5.f1278b;
        if (i3 > 0) {
            map.put("dpi", String.valueOf(i3));
        }
        map.put(Constant.KEY_DEVICE_TYPE, Build.MODEL);
        map.put(Constant.KEY_DEVICE_BRAND, Build.BRAND);
        map.put(SettingsTracker.TYPE_LANGUAGE, application.getResources().getConfiguration().locale.getLanguage());
        map.put(Constant.KEY_OS_API, String.valueOf(Build.VERSION.SDK_INT));
        String str2 = Build.VERSION.RELEASE;
        if (str2 != null && str2.length() > 10) {
            str2 = str2.substring(0, 10);
        }
        map.put(Constant.KEY_OS_VERSION, str2);
        String m622a = C0501q5.m622a(application, false);
        if (!TextUtils.isEmpty(m622a)) {
            map.put("ac", m622a);
        }
        int i4 = 0;
        while (true) {
            a[] aVarArr = f722c;
            hashMap = null;
            if (i4 >= aVarArr.length) {
                break;
            }
            a aVar = aVarArr[i4];
            Object m500a = m500a(jSONObject, aVar.f725a, (String) null, (Class<String>) aVar.f727c);
            if (m500a != null) {
                map.put(aVar.f726b, m500a.toString());
            }
            i4++;
        }
        String str3 = (String) m500a(jSONObject, "tweaked_channel", "", (Class<String>) String.class);
        if (TextUtils.isEmpty(str3)) {
            str3 = (String) m500a(jSONObject, Constant.KEY_CHANNEL, "", (Class<String>) String.class);
        }
        if (!TextUtils.isEmpty(str3)) {
            map.put(Constant.KEY_CHANNEL, str3);
        }
        String str4 = (String) m500a(jSONObject, "cdid", (String) null, (Class<String>) String.class);
        if (!TextUtils.isEmpty(str4)) {
            map.put("cdid", str4);
        }
        SensitiveUtils.appendSensitiveParams(this, jSONObject, map, C0522t5.m705a(application), level);
        if (level == Level.L0) {
            String str5 = (String) m500a(jSONObject, "openudid", (String) null, (Class<String>) String.class);
            if (!TextUtils.isEmpty(str5)) {
                map.put("openudid", str5);
            }
        }
        this.f724b.getAppContext();
        try {
            if (this.f723a != null) {
                hashMap = this.f723a.getExtraParams(level);
            }
            if (hashMap == null || hashMap.isEmpty()) {
                return;
            }
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value) && !map.containsKey(key)) {
                        map.put(key, value);
                    }
                }
            }
        } catch (Throwable th) {
            this.f724b.f764D.error(11, "Add extra params failed.", th, new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002e  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String[] m503a(C0475n0 c0475n0, JSONObject jSONObject, int i) {
        String[] sendUris;
        int length;
        UriConfig m554e = c0475n0.m554e();
        if (i != 0) {
            if (i != 1) {
                sendUris = new String[0];
            } else if (!TextUtils.isEmpty(m554e.getBusinessUri())) {
                sendUris = new String[]{m554e.getBusinessUri()};
            }
            length = sendUris.length;
            String[] strArr = new String[length];
            boolean z = this.f724b.f765E;
            for (int i2 = 0; i2 < length; i2++) {
                strArr[i2] = sendUris[i2];
                if (z) {
                    strArr[i2] = strArr[i2] + "?tt_data=a";
                }
                String m501a = m501a(jSONObject, strArr[i2], true, Level.L1);
                strArr[i2] = m501a;
                strArr[i2] = C0444i4.m458a(m501a, C0480n5.f887c);
            }
            return strArr;
        }
        sendUris = m554e.getSendUris();
        length = sendUris.length;
        String[] strArr2 = new String[length];
        boolean z2 = this.f724b.f765E;
        while (i2 < length) {
        }
        return strArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T m500a(JSONObject jSONObject, String str, T t, Class<T> cls) {
        T t2;
        if (jSONObject == null) {
            return (T) this.f724b.getHeaderValue(str, t, cls);
        }
        Object opt = jSONObject.opt(str);
        if (opt != null && cls != null) {
            try {
                t2 = cls.cast(opt);
            } catch (Throwable th) {
                this.f724b.f764D.error(11, "Cast type failed.", th, new Object[0]);
            }
            return t2 != null ? t : t2;
        }
        t2 = null;
        if (t2 != null) {
        }
    }
}
