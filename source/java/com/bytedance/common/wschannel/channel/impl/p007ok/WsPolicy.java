package com.bytedance.common.wschannel.channel.impl.p007ok;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.wschannel.channel.impl.p007ok.policy.RetryPolicy;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Response;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class WsPolicy {
    private int mIndex = 0;
    private RetryPolicy mRetryPolicy;
    private String mTargetUrl;
    private final List<String> mUrls;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WsPolicy(List<String> list, RetryPolicy retryPolicy) {
        ArrayList arrayList = new ArrayList();
        this.mUrls = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
        Logger.m190d(OkChannelImpl.TAG, "urls : " + arrayList);
        this.mRetryPolicy = retryPolicy;
        reset();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Pair<String, Long> getRetryUrlAndInterval(Response response) {
        String url;
        long retryIntervalWithResponse;
        url = getUrl();
        retryIntervalWithResponse = this.mRetryPolicy.getRetryIntervalWithResponse(response);
        if (retryIntervalWithResponse == -1) {
            this.mRetryPolicy.reset();
            url = getNextUrl();
            if (!TextUtils.isEmpty(url)) {
                retryIntervalWithResponse = this.mRetryPolicy.getRandomInterval();
            }
        }
        return new Pair<>(url, Long.valueOf(retryIntervalWithResponse));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String getNextUrl() {
        int i = this.mIndex + 1;
        this.mIndex = i;
        if (this.mUrls.size() <= i) {
            return "";
        }
        String str = this.mUrls.get(i);
        this.mTargetUrl = str;
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void reset() {
        this.mRetryPolicy.reset();
        this.mTargetUrl = null;
        this.mIndex = 0;
    }

    public synchronized String getUrl() {
        if (StringUtils.isEmpty(this.mTargetUrl)) {
            int size = this.mUrls.size();
            int i = this.mIndex;
            if (size > i) {
                this.mTargetUrl = this.mUrls.get(i);
            }
        }
        return this.mTargetUrl;
    }
}
