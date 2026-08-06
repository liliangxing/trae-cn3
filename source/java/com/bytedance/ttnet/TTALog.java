package com.bytedance.ttnet;

import android.util.Log;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.ss.android.agilelogger.ALog;
import com.ss.android.agilelogger.INativeFuncAddrCallback;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TTALog {
    private static final String TAG = "TTNET_ALog";
    private static volatile long sALogFuncAddr;

    public static void init() {
        ensureALogInitialized();
    }

    public static long getALogFuncAddr() {
        return sALogFuncAddr;
    }

    private static void ensureALogInitialized() {
        sALogFuncAddr = ALog.getALogWriteFuncAddr();
        Log.i(TAG, "ALog function address is " + sALogFuncAddr);
        if (sALogFuncAddr == 0) {
            ALog.addNativeFuncAddrCallback(new INativeFuncAddrCallback() { // from class: com.bytedance.ttnet.TTALog$$ExternalSyntheticLambda0
                public final void onNativeFuncReady(long j) {
                    TTALog.lambda$ensureALogInitialized$0(j);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$ensureALogInitialized$0(long j) {
        if (sALogFuncAddr != 0) {
            Log.i(TAG, "ALog function address has initialized.");
            return;
        }
        if (j == 0) {
            Log.w(TAG, "Cannot get ALog function address in init callback.");
            return;
        }
        sALogFuncAddr = j;
        Log.i(TAG, "ALog function address is " + sALogFuncAddr + " from callback.");
        try {
            SsCronetHttpClient cronetHttpClient = getCronetHttpClient();
            if (cronetHttpClient != null) {
                cronetHttpClient.setAlogFuncAddr(sALogFuncAddr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static SsCronetHttpClient getCronetHttpClient() throws Exception {
        if (HttpClient.isCronetClientEnable()) {
            return SsCronetHttpClient.inst(TTNetInit.getTTNetDepend().getContext());
        }
        return null;
    }
}
