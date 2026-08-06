package com.bytedance.crash.runtime;

import android.text.TextUtils;
import com.bytedance.crash.util.NpthLog;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public class AllDefaultUrls {
    private static String PREFIX = "http";
    private static String domainName = "https://mon.zijieapi.com";

    public static void setDomainName(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        NpthLog.i("setDomainName:" + str);
        if (!str.startsWith(PREFIX)) {
            domainName = "https://" + str;
        } else {
            domainName = str;
        }
        NpthLog.i("setDomainName:" + domainName);
    }

    public static void setDomainName(String str, JSONArray jSONArray) {
        if (TextUtils.isEmpty(str) || jSONArray == null || jSONArray.length() == 0) {
            NpthLog.i("setDomainName: invalid param");
            return;
        }
        if (str.equals(domainName)) {
            NpthLog.i("setDomainName: same domain");
            return;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= jSONArray.length()) {
                break;
            }
            if (str.equals(jSONArray.optString(i))) {
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            NpthLog.i("setDomainName: check valid fail");
        } else {
            NpthLog.i("setDomainName begin:" + str);
            domainName = str;
        }
    }

    public static String getDomainName() {
        return domainName;
    }
}
