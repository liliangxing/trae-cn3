package com.huawei.hms.update.p031ui;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class UpdateBean implements Serializable {

    /* renamed from: a */
    private boolean f1855a;

    /* renamed from: b */
    private boolean f1856b;

    /* renamed from: c */
    private String f1857c;

    /* renamed from: d */
    private int f1858d;

    /* renamed from: e */
    private String f1859e;

    /* renamed from: f */
    private String f1860f;

    /* renamed from: g */
    private ArrayList f1861g;

    /* renamed from: h */
    private boolean f1862h = true;

    /* renamed from: a */
    private static <T> T m2132a(T t) {
        return t;
    }

    public String getClientAppId() {
        return (String) m2132a(this.f1859e);
    }

    public String getClientAppName() {
        return (String) m2132a(this.f1860f);
    }

    public String getClientPackageName() {
        return (String) m2132a(this.f1857c);
    }

    public int getClientVersionCode() {
        return ((Integer) m2132a(Integer.valueOf(this.f1858d))).intValue();
    }

    public boolean getResolutionInstallHMS() {
        return this.f1856b;
    }

    public ArrayList getTypeList() {
        return (ArrayList) m2132a(this.f1861g);
    }

    public boolean isHmsOrApkUpgrade() {
        return ((Boolean) m2132a(Boolean.valueOf(this.f1855a))).booleanValue();
    }

    public boolean isNeedConfirm() {
        return ((Boolean) m2132a(Boolean.valueOf(this.f1862h))).booleanValue();
    }

    public void setClientAppId(String str) {
        this.f1859e = str;
    }

    public void setClientAppName(String str) {
        this.f1860f = str;
    }

    public void setClientPackageName(String str) {
        this.f1857c = str;
    }

    public void setClientVersionCode(int i) {
        this.f1858d = i;
    }

    public void setHmsOrApkUpgrade(boolean z) {
        this.f1855a = z;
    }

    public void setNeedConfirm(boolean z) {
        this.f1862h = z;
    }

    public void setResolutionInstallHMS(boolean z) {
        this.f1856b = z;
    }

    public void setTypeList(ArrayList arrayList) {
        this.f1861g = arrayList;
    }
}
