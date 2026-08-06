package com.bytedance.sdk.account.bdplatform.utils;

import android.util.Log;
import com.bytedance.sdk.account.bdplatform.api.BDAuthorizePlatformDepend;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.conn.ConnectTimeoutException;

/* loaded from: classes5.dex */
public final class NetUtils {
    public static final String TAG = "PlatformSdkNetUtils";

    public static int checkApiException(BDAuthorizePlatformDepend bDAuthorizePlatformDepend, Throwable th) {
        int i;
        int checkRequestException;
        if (bDAuthorizePlatformDepend != null && (checkRequestException = bDAuthorizePlatformDepend.checkRequestException(th)) < 0) {
            return checkRequestException;
        }
        if (th instanceof ConnectTimeoutException) {
            i = -13;
        } else if (th instanceof SocketTimeoutException) {
            i = -14;
        } else {
            if (th instanceof SocketException) {
                Log.v(TAG, "api socket exception: " + th);
            } else {
                if (th instanceof SSLPeerUnverifiedException) {
                    Log.v(TAG, "api ssl exception: " + th);
                } else if (th instanceof IOException) {
                    Log.v(TAG, "api io exception: " + th);
                } else if (!(th instanceof SSLHandshakeException)) {
                    if (th instanceof UnknownHostException) {
                        i = -16;
                    } else {
                        Log.w(TAG, "api exception: " + th);
                        i = -1;
                    }
                }
                i = -21;
            }
            i = -15;
        }
        if ((i != -15 && i != -14) || bDAuthorizePlatformDepend == null || bDAuthorizePlatformDepend.isNetworkEnable()) {
            return i;
        }
        return -12;
    }
}
