package com.bytedance.tobshadow.bdtracker;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class o2 extends y1 {
    public o2() {
        super(true, false);
    }

    @Override // com.bytedance.tobshadow.bdtracker.y1
    public String a() {
        return "Rom";
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ca, code lost:
    
        if (r0.toLowerCase().contains("flyme") != false) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x008f  */
    @Override // com.bytedance.tobshadow.bdtracker.y1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        StringBuilder sb = new StringBuilder(16);
        boolean z = false;
        if (w5.f()) {
            str = "MIUI-";
        } else {
            if (!w5.c()) {
                String a = w5.a("ro.build.version.emui");
                String a2 = TextUtils.isEmpty(a) ? w5.a("ro.build.version.emui") : a;
                if ((!TextUtils.isEmpty(a2) && (a2.toLowerCase().contains("emotionui") || a2.toLowerCase().contains("magicui"))) || w5.e() || w5.d()) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(a)) {
                    sb.append(a).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
                sb.append(Build.VERSION.INCREMENTAL);
                jSONObject.put(Api.KEY_ROM, sb.toString());
                str2 = "";
                if (!w5.f()) {
                    if (w5.f()) {
                        str2 = a.a("miui_").append(w5.a("ro.miui.ui.version.name")).append("_").append(Build.VERSION.INCREMENTAL).toString();
                    }
                } else if (w5.c()) {
                    str3 = Build.DISPLAY;
                    if (str3 != null) {
                    }
                } else if (w5.b()) {
                    if (w5.b()) {
                        str2 = a.a("coloros_").append(w5.a("ro.build.version.opporom")).append("_").append(Build.DISPLAY).toString();
                    }
                } else {
                    String a3 = w5.a("ro.build.version.emui");
                    str3 = (a3 == null || !(a3.toLowerCase().contains("emotionui") || a3.toLowerCase().contains("magicui"))) ? "" : a3 + "_" + Build.DISPLAY;
                    if (TextUtils.isEmpty(str3)) {
                        String a4 = w5.a("ro.vivo.os.build.display.id");
                        if (!TextUtils.isEmpty(a4) && a4.toLowerCase().contains(w5.b)) {
                            str2 = w5.a("ro.vivo.os.build.display.id") + "_" + w5.a("ro.vivo.product.version");
                        } else {
                            if (!TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(w5.a)) {
                                str2 = Build.DISPLAY + "_" + w5.a("ro.gn.sv.version");
                            } else {
                                String str4 = Build.MANUFACTURER + Build.BRAND;
                                if (!TextUtils.isEmpty(str4)) {
                                    String lowerCase = str4.toLowerCase();
                                    if (lowerCase.contains("360") || lowerCase.contains("qiku")) {
                                        z = true;
                                    }
                                }
                                if (z) {
                                    str2 = w5.a("ro.build.uiversion") + "_" + Build.DISPLAY;
                                } else {
                                    str2 = TextUtils.isEmpty(w5.a("ro.letv.release.version")) ^ true ? a.a("eui_").append(w5.a("ro.letv.release.version")).append("_").append(Build.DISPLAY).toString() : "";
                                    if (TextUtils.isEmpty(str2)) {
                                        str2 = Build.DISPLAY;
                                    }
                                }
                            }
                        }
                    }
                    str2 = str3;
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("rom_version", str2);
                }
                return true;
            }
            str = "FLYME-";
        }
        sb.append(str);
        sb.append(Build.VERSION.INCREMENTAL);
        jSONObject.put(Api.KEY_ROM, sb.toString());
        str2 = "";
        if (!w5.f()) {
        }
        if (!TextUtils.isEmpty(str2)) {
        }
        return true;
    }
}
