package com.ss.android.socialbase.downloader.network;

import android.util.Pair;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public abstract class AbsDownloadHttpConnection implements IDownloadHttpConnection {
    public String getHostIp() {
        return "";
    }

    public String getRedirectPartialUrlResults() {
        return "";
    }

    public String getRequestLog() {
        return "";
    }

    public List<Pair<String, String>> getResponseHeaders() {
        return null;
    }

    public boolean isOkhttp() {
        return false;
    }

    public void monitorNetworkInfo(JSONObject jSONObject, boolean z) {
    }

    public void onThrowable(Throwable th) {
    }

    public void setThrottleNetSpeedWhenRunning(long j) {
    }
}
