package com.bytedance.common.wschannel.channel.impl.p007ok.policy;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.channel.impl.p007ok.OkChannelImpl;
import okhttp3.Response;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class RetryIntervalPolicy implements RetryPolicy {
    private static final long INIT_RETRY_INTERVAL = 5000;
    private static final long MAX_RETRY_INTERVAL = 120000;
    private final Context mContext;
    private int mReconnectTimes = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RetryIntervalPolicy(Context context) {
        this.mContext = context;
    }

    private static boolean isNetworkAvailable(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public long getNextRetryInterval() {
        if (!isNetworkAvailable(this.mContext)) {
            return -1L;
        }
        this.mReconnectTimes = this.mReconnectTimes + 1;
        return (long) (Math.min((1 << r0) * 5000, 120000L) + (Math.random() * 10.0d * 1000.0d));
    }

    @Override // com.bytedance.common.wschannel.channel.impl.p007ok.policy.RetryPolicy
    public long getRandomInterval() {
        return (long) ((Math.random() * 4500.0d) + 500.0d);
    }

    @Override // com.bytedance.common.wschannel.channel.impl.p007ok.policy.RetryPolicy
    public void reset() {
        this.mReconnectTimes = 0;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.p007ok.policy.RetryPolicy
    public long getRetryIntervalWithResponse(Response response) {
        int code;
        String header;
        long nextRetryInterval = getNextRetryInterval();
        if (nextRetryInterval == -1) {
            return -1L;
        }
        if (response != null) {
            try {
                if (!response.isSuccessful() && (((code = response.code()) == 414 || code == 511 || code == 512) && (header = response.header("Handshake-Options")) != null)) {
                    for (String str : header.split(";")) {
                        if (!TextUtils.isEmpty(str)) {
                            String[] split = str.split("=");
                            if ("reconnect-interval".equals(split[0])) {
                                String str2 = split[1];
                                Logger.m190d(OkChannelImpl.TAG, "override retry interval");
                                try {
                                    nextRetryInterval = Long.parseLong(str2) * 1000;
                                    Logger.m190d(OkChannelImpl.TAG, "read response hand shake option : reconnect-interval:" + nextRetryInterval + " ms");
                                    break;
                                } catch (NumberFormatException unused) {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return nextRetryInterval;
    }
}
