package com.bytedance.crash.monitor;

import android.text.TextUtils;
import com.bytedance.crash.util.Stack;
import org.json.JSONArray;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SdkMonitor extends CrashListener {
    private String[] mPackageNames;
    private String[] mSoList;

    public SdkMonitor(String str, String str2, long j, String[] strArr, String[] strArr2) {
        super(str, str2, j);
        this.mPackageNames = strArr;
        this.mSoList = strArr2;
    }

    public String[] getPackageName() {
        return this.mPackageNames;
    }

    public String[] getSoList() {
        return this.mSoList;
    }

    public void setSoList(String[] strArr) {
        this.mSoList = strArr;
    }

    public void setPackageName(String[] strArr) {
        this.mPackageNames = strArr;
    }

    public JSONArray acceptJavaStack(StackTraceElement[] stackTraceElementArr) {
        String[] strArr = this.mPackageNames;
        if (strArr == null || stackTraceElementArr == null) {
            return null;
        }
        return Stack.getMatchLines(stackTraceElementArr, strArr);
    }

    public boolean acceptSoLit(String str) {
        if (this.mSoList != null && !TextUtils.isEmpty(str)) {
            for (String str2 : this.mSoList) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
