package com.bytedance.tobshadow.bdtracker;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sync.SyncConstants;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.o2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0484o2 extends AbstractC0553y1 {
    public C0484o2() {
        super(true, false);
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public String mo253a() {
        return "Rom";
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ca, code lost:
    
        if (r0.toLowerCase().contains("flyme") != false) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x008f  */
    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean mo255a(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        StringBuilder sb = new StringBuilder(16);
        boolean z = false;
        if (C0543w5.m740f()) {
            str = "MIUI-";
        } else {
            if (!C0543w5.m737c()) {
                String m734a = C0543w5.m734a("ro.build.version.emui");
                String m734a2 = TextUtils.isEmpty(m734a) ? C0543w5.m734a("ro.build.version.emui") : m734a;
                if ((!TextUtils.isEmpty(m734a2) && (m734a2.toLowerCase().contains("emotionui") || m734a2.toLowerCase().contains("magicui"))) || C0543w5.m739e() || C0543w5.m738d()) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(m734a)) {
                    sb.append(m734a).append("-");
                }
                sb.append(Build.VERSION.INCREMENTAL);
                jSONObject.put("rom", sb.toString());
                str2 = "";
                if (!C0543w5.m740f()) {
                    if (C0543w5.m740f()) {
                        str2 = C0380a.m252a("miui_").append(C0543w5.m734a("ro.miui.ui.version.name")).append(SyncConstants.SEPARATOR).append(Build.VERSION.INCREMENTAL).toString();
                    }
                } else if (C0543w5.m737c()) {
                    str3 = Build.DISPLAY;
                    if (str3 != null) {
                    }
                } else if (C0543w5.m736b()) {
                    if (C0543w5.m736b()) {
                        str2 = C0380a.m252a("coloros_").append(C0543w5.m734a("ro.build.version.opporom")).append(SyncConstants.SEPARATOR).append(Build.DISPLAY).toString();
                    }
                } else {
                    String m734a3 = C0543w5.m734a("ro.build.version.emui");
                    str3 = (m734a3 == null || !(m734a3.toLowerCase().contains("emotionui") || m734a3.toLowerCase().contains("magicui"))) ? "" : m734a3 + SyncConstants.SEPARATOR + Build.DISPLAY;
                    if (TextUtils.isEmpty(str3)) {
                        String m734a4 = C0543w5.m734a("ro.vivo.os.build.display.id");
                        if (!TextUtils.isEmpty(m734a4) && m734a4.toLowerCase().contains(C0543w5.f1200b)) {
                            str2 = C0543w5.m734a("ro.vivo.os.build.display.id") + SyncConstants.SEPARATOR + C0543w5.m734a("ro.vivo.product.version");
                        } else {
                            if (!TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(C0543w5.f1199a)) {
                                str2 = Build.DISPLAY + SyncConstants.SEPARATOR + C0543w5.m734a("ro.gn.sv.version");
                            } else {
                                String str4 = Build.MANUFACTURER + Build.BRAND;
                                if (!TextUtils.isEmpty(str4)) {
                                    String lowerCase = str4.toLowerCase();
                                    if (lowerCase.contains("360") || lowerCase.contains("qiku")) {
                                        z = true;
                                    }
                                }
                                if (z) {
                                    str2 = C0543w5.m734a("ro.build.uiversion") + SyncConstants.SEPARATOR + Build.DISPLAY;
                                } else {
                                    str2 = TextUtils.isEmpty(C0543w5.m734a("ro.letv.release.version")) ^ true ? C0380a.m252a("eui_").append(C0543w5.m734a("ro.letv.release.version")).append(SyncConstants.SEPARATOR).append(Build.DISPLAY).toString() : "";
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
        jSONObject.put("rom", sb.toString());
        str2 = "";
        if (!C0543w5.m740f()) {
        }
        if (!TextUtils.isEmpty(str2)) {
        }
        return true;
    }
}
