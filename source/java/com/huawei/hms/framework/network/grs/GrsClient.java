package com.huawei.hms.framework.network.grs;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class GrsClient {
    private static final String EMPTY_STRING = "";
    private final C1089c grsClientGlobal;
    private int queryTimeout;

    public GrsClient(Context context, GrsBaseInfo grsBaseInfo) {
        if (context == null || grsBaseInfo == null) {
            throw new NullPointerException("invalid init params for context is null or GrsBaseInfo instance is null Object.");
        }
        this.grsClientGlobal = C1090d.m1231a(grsBaseInfo, context);
        this.queryTimeout = grsBaseInfo.getQueryTimeout();
    }

    public void ayncGetGrsUrl(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack) {
        C1089c c1089c = this.grsClientGlobal;
        if (c1089c == null) {
            iQueryUrlCallBack.onCallBackFail(-8);
        } else {
            c1089c.m1228a(str, str2, iQueryUrlCallBack, this.queryTimeout);
        }
    }

    public void ayncGetGrsUrls(String str, IQueryUrlsCallBack iQueryUrlsCallBack) {
        C1089c c1089c = this.grsClientGlobal;
        if (c1089c == null) {
            iQueryUrlsCallBack.onCallBackFail(-8);
        } else {
            c1089c.m1227a(str, iQueryUrlsCallBack, this.queryTimeout);
        }
    }

    public void clearSp() {
        C1089c c1089c = this.grsClientGlobal;
        if (c1089c == null) {
            return;
        }
        c1089c.m1226a();
    }

    public boolean forceExpire() {
        C1089c c1089c = this.grsClientGlobal;
        if (c1089c == null) {
            return false;
        }
        return c1089c.m1230b();
    }

    public String synGetGrsUrl(String str, String str2) {
        C1089c c1089c = this.grsClientGlobal;
        return c1089c == null ? "" : c1089c.m1224a(str, str2, this.queryTimeout);
    }

    public Map<String, String> synGetGrsUrls(String str) {
        C1089c c1089c = this.grsClientGlobal;
        return c1089c == null ? new HashMap() : c1089c.m1225a(str, this.queryTimeout);
    }
}
