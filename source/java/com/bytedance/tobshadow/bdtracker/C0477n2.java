package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.n2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0477n2 extends AbstractC0553y1 {

    /* renamed from: e */
    public final Context f865e;

    /* renamed from: f */
    public final C0467m f866f;

    /* renamed from: g */
    public final C0407d2 f867g;

    public C0477n2(C0467m c0467m, Context context, C0407d2 c0407d2) {
        super(false, false);
        this.f866f = c0467m;
        this.f865e = context;
        this.f867g = c0407d2;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public String mo253a() {
        return "Package";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public boolean mo255a(JSONObject jSONObject) {
        Object m643b;
        ApplicationInfo applicationInfo;
        String packageName = this.f865e.getPackageName();
        if (TextUtils.isEmpty(this.f867g.f502c.getZiJieCloudPkg())) {
            jSONObject.put("package", packageName);
        } else {
            this.f866f.f764D.debug("has zijie pkg", new Object[0]);
            jSONObject.put("package", this.f867g.f502c.getZiJieCloudPkg());
            jSONObject.put("real_package_name", packageName);
        }
        try {
            int m640a = C0508r5.m640a(this.f865e);
            if (!TextUtils.isEmpty(this.f867g.f502c.getVersion())) {
                m643b = this.f867g.f502c.getVersion();
            } else {
                m643b = C0508r5.m643b(this.f865e);
            }
            jSONObject.put(Constant.KEY_APP_VERSION, m643b);
            jSONObject.put("app_version_minor", !TextUtils.isEmpty(this.f867g.f502c.getVersionMinor()) ? this.f867g.f502c.getVersionMinor() : "");
            if (this.f867g.f502c.getVersionCode() != 0) {
                jSONObject.put("version_code", this.f867g.f502c.getVersionCode());
            } else {
                jSONObject.put("version_code", m640a);
            }
            if (this.f867g.f502c.getUpdateVersionCode() != 0) {
                jSONObject.put(Constant.KEY_UPDATE_VERSION_CODE, this.f867g.f502c.getUpdateVersionCode());
            } else {
                jSONObject.put(Constant.KEY_UPDATE_VERSION_CODE, m640a);
            }
            if (this.f867g.f502c.getManifestVersionCode() != 0) {
                jSONObject.put("manifest_version_code", this.f867g.f502c.getManifestVersionCode());
            } else {
                jSONObject.put("manifest_version_code", m640a);
            }
            if (!TextUtils.isEmpty(this.f867g.f502c.getAppName())) {
                jSONObject.put("app_name", this.f867g.f502c.getAppName());
            }
            if (!TextUtils.isEmpty(this.f867g.f502c.getTweakedChannel())) {
                jSONObject.put("tweaked_channel", this.f867g.f502c.getTweakedChannel());
            }
            PackageInfo m641a = C0508r5.m641a(this.f865e, packageName, 0);
            if (m641a == null || (applicationInfo = m641a.applicationInfo) == null) {
                return true;
            }
            int i = applicationInfo.labelRes;
            if (i <= 0) {
                return true;
            }
            try {
                jSONObject.put(IGoogleService.ResponseKey.DISPLAY_NAME, this.f865e.getString(i));
                return true;
            } catch (Throwable unused) {
                return true;
            }
        } catch (Throwable th) {
            this.f866f.f764D.error("Load package info failed.", th, new Object[0]);
            return false;
        }
    }
}
