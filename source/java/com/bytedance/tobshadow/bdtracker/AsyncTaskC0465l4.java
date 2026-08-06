package com.bytedance.tobshadow.bdtracker;

import android.content.pm.PackageInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.widget.Toast;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.tobshadow.applog.IPicker;
import com.bytedance.tobshadow.applog.simulate.SimulateLaunchActivity;
import com.bytedance.trae.im.model.MessagePart;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.l4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class AsyncTaskC0465l4 extends AsyncTask<Void, Void, JSONObject> {

    /* renamed from: a */
    public int f739a;

    /* renamed from: b */
    public int f740b;

    /* renamed from: c */
    public String f741c;

    /* renamed from: d */
    public String f742d;

    /* renamed from: e */
    public String f743e;

    /* renamed from: f */
    public String f744f;

    /* renamed from: g */
    public final C0467m f745g;

    /* renamed from: a */
    public static void m507a(C0467m c0467m) {
        new AsyncTaskC0465l4(c0467m).execute(new Void[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01df A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject doInBackground(Void[] voidArr) {
        long currentTimeMillis;
        String str;
        JSONObject jSONObject;
        int i;
        if (SimulateLaunchActivity.entryMode == 0) {
            C0467m c0467m = this.f745g;
            C0444i4 c0444i4 = c0467m.f782k;
            String str2 = c0467m.f784m;
            String str3 = this.f742d;
            int i2 = this.f739a;
            int i3 = this.f740b;
            String str4 = this.f743e;
            String str5 = this.f741c;
            c0444i4.f668b.f764D.debug(11, "Start to login simulator with device id:{} and qrParam:{}...", str4, str5);
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONObject m459a = C0444i4.m459a(str2, str3);
                m459a.put("width", i2);
                m459a.put("height", i3);
                m459a.put("device_id", str4);
                jSONObject2.put("header", m459a);
                jSONObject2.put("qr_param", str5);
                try {
                    String str6 = new String(c0444i4.f668b.getNetClient().execute((byte) 1, c0444i4.f667a + "/simulator/mobile/login", jSONObject2, c0444i4.m464a(), (byte) 0, true, 10000));
                    c0444i4.f668b.f764D.debug(11, "Login simulator with response:{}", str6);
                    if (!C0411e.m376c(str6)) {
                        return new JSONObject(str6);
                    }
                } catch (Throwable th) {
                    c0444i4.f668b.f764D.error(11, "Login simulator failed", th, new Object[0]);
                    c0444i4.f668b.m522b().mo639a(th, "simulateLogin");
                }
            } catch (Throwable th2) {
                c0444i4.f668b.f764D.error(11, "JSON handle failed", th2, new Object[0]);
                c0444i4.f668b.m522b().mo639a(th2, "simulateLogin header");
            }
        } else {
            C0467m c0467m2 = this.f745g;
            C0444i4 c0444i42 = c0467m2.f782k;
            String str7 = c0467m2.f784m;
            String str8 = this.f742d;
            int i4 = this.f739a;
            int i5 = this.f740b;
            String str9 = this.f743e;
            c0444i42.f668b.f764D.debug(11, "Start to login simulator with device id:{}...", str9);
            JSONObject jSONObject3 = new JSONObject();
            try {
                JSONObject m459a2 = C0444i4.m459a(str7, str8);
                C0411e.m351a(m459a2, c0444i42.f668b.getHeader());
                m459a2.put("width", i4);
                m459a2.put("height", i5);
                m459a2.put("device_id", str9);
                m459a2.put(Constant.KEY_DEVICE_MODEL, Build.MODEL);
                jSONObject3.put("header", m459a2);
                HashMap<String, String> m464a = c0444i42.m464a();
                String str10 = "";
                String str11 = null;
                while (true) {
                    if (!isCancelled()) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        try {
                            jSONObject3.put("sync_id", str10);
                            str = new String(c0444i42.f668b.getNetClient().execute((byte) 1, c0444i42.f667a + "/simulator/limited_mobile/try_link", jSONObject3, m464a, (byte) 0, true, 10000));
                            try {
                                jSONObject = new JSONObject(str);
                                i = jSONObject.getJSONObject("data").getInt("retry");
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                        if (i == 0) {
                            break;
                        }
                        if (i == 2) {
                            str11 = str;
                            break;
                        }
                        try {
                            str10 = jSONObject.getJSONObject("data").getString("sync_id");
                            str11 = str;
                        } catch (Throwable th5) {
                            th = th5;
                            str11 = str;
                            c0444i42.f668b.f764D.error(11, "Post to simulate login failed", th, new Object[0]);
                            c0444i42.f668b.m522b().mo639a(th, "simulateLoginWithoutQR");
                            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                            if (currentTimeMillis >= 1000) {
                            }
                        }
                        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                        if (currentTimeMillis >= 1000) {
                            try {
                                Thread.sleep(1000 - currentTimeMillis);
                            } catch (InterruptedException e) {
                                c0444i42.f668b.f764D.error(11, "Sleep interrupted", e, new Object[0]);
                            }
                        }
                    } else {
                        break;
                    }
                }
                c0444i42.f668b.f764D.debug(11, "Login simulator with response:{}", str11);
                if (!C0411e.m376c(str11)) {
                    try {
                        return new JSONObject(str11);
                    } catch (Throwable th6) {
                        c0444i42.f668b.f764D.error(11, "JSON handle failed", th6, new Object[0]);
                        c0444i42.f668b.m522b().mo639a(th6, "simulateLoginWithoutQR json");
                    }
                }
            } catch (Throwable th7) {
                c0444i42.f668b.f764D.error(11, "JSON handle failed", th7, new Object[0]);
                c0444i42.f668b.m522b().mo639a(th7, "simulateLoginWithoutQR header");
            }
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject jSONObject2 = jSONObject;
        this.f745g.f764D.debug(Collections.singletonList("SimulateLoginTask"), "Simulate login with response: {}", jSONObject2);
        if (jSONObject2 == null) {
            Toast.makeText(this.f745g.f785n, "启动埋点验证|圈选失败，服务端无响应", 1).show();
            return;
        }
        String optString = jSONObject2.optString("message");
        String optString2 = jSONObject2.optString("Set-Cookie");
        int optInt = jSONObject2.optInt(PageDataManager.EXTRA_STATUS);
        if (SimulateLaunchActivity.entryMode == 1 && (optJSONObject = jSONObject2.optJSONObject("data")) != null) {
            this.f744f = optJSONObject.optString("mode", "").equals(MessagePart.TYPE_LOG) ? SimulateLaunchActivity.DEBUG_LOG : SimulateLaunchActivity.BIND_QUERY;
        }
        if (optInt != 0 || !"OK".equals(optString)) {
            if (optInt != 0 && C0411e.m379d(jSONObject2.optString("message"))) {
                Toast.makeText(this.f745g.f785n, C0380a.m252a("启动埋点验证|圈选失败: ").append(jSONObject2.optString("message")).toString(), 1).show();
                return;
            } else {
                this.f745g.f764D.warn(Collections.singletonList("SimulateLoginTask"), "Start simulator failed, please check server response: {}", jSONObject2);
                return;
            }
        }
        if (SimulateLaunchActivity.DEBUG_LOG.equals(this.f744f)) {
            this.f745g.setRangersEventVerifyEnable(true, optString2);
            return;
        }
        IPicker picker = (this.f745g.getInitConfig() == null || this.f745g.getInitConfig().getPicker() == null) ? null : this.f745g.getInitConfig().getPicker();
        if (picker != null) {
            picker.setMarqueeCookie(optString2);
        }
        this.f745g.startSimulator(optString2);
    }

    public AsyncTaskC0465l4(C0467m c0467m) {
        this.f745g = c0467m;
        c0467m.f782k.f667a = SimulateLaunchActivity.entryUrlPrefix;
        this.f744f = SimulateLaunchActivity.entryType;
        this.f741c = SimulateLaunchActivity.entryQrParam;
        this.f743e = c0467m.getDid();
        String str = (String) c0467m.getHeaderValue("resolution", null, String.class);
        if (C0411e.m379d(str)) {
            String[] split = str.split("x");
            this.f740b = Integer.parseInt(split[0]);
            this.f739a = Integer.parseInt(split[1]);
        }
        PackageInfo m641a = C0508r5.m641a(c0467m.f785n, c0467m.f785n.getApplicationInfo().packageName, 0);
        this.f742d = m641a != null ? m641a.versionName : "1.0.0";
        c0467m.f764D.debug(Collections.singletonList("SimulateLoginTask"), "Simulate task init success", new Object[0]);
    }
}
