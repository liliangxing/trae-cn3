package com.bytedance.pitaya.api;

import android.content.Context;
import com.bytedance.pitaya.api.bean.PTYCleanStrategy;
import com.bytedance.pitaya.api.bean.PTYNativeTaskConfig;
import com.bytedance.pitaya.api.bean.PTYNativeTaskData;
import com.bytedance.pitaya.api.bean.PTYRequestConfig;
import com.bytedance.pitaya.api.bean.PTYSetupInfo;
import com.bytedance.pitaya.api.bean.PTYTaskConfig;
import com.bytedance.pitaya.api.bean.PTYTaskData;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import kotlin.Metadata;

/* compiled from: IPitayaCore.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH'J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0015H&J\b\u0010\u0017\u001a\u00020\tH&J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0019\u001a\u00020\tH&J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0003H&J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0003H&J(\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\b\u0010\u001f\u001a\u00020\tH&J*\u0010 \u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H&J.\u0010'\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010#\u001a\u00020)2\u0006\u0010%\u001a\u00020&H&J\"\u0010*\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,2\b\u0010\u000e\u001a\u0004\u0018\u00010-H&J\u0010\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u0003H&J\u0010\u00100\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u0003H&J\u0010\u00101\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u0003H&J\b\u00102\u001a\u00020\tH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u00063"}, d2 = {"Lcom/bytedance/pitaya/api/IPitayaCore;", "Lcom/bytedance/pitaya/api/PitayaFE;", CommonConstants.KEY_AID, "", "getAid", "()Ljava/lang/String;", "setAid", "(Ljava/lang/String;)V", "cleanStorage", "", "context", "Landroid/content/Context;", "strategy", "Lcom/bytedance/pitaya/api/bean/PTYCleanStrategy;", "callback", "Lcom/bytedance/pitaya/api/PTYNormalCallback;", "downloadPackage", "businessName", "packageCallback", "Lcom/bytedance/pitaya/api/PTYPackageCallback;", "isPreloadReady", "", "isReady", "preDownloadAllPackage", "queryPackage", "releaseAllEngines", "releaseEngine", "releaseNativeEngine", "requestUpdate", "requestConfig", "Lcom/bytedance/pitaya/api/bean/PTYRequestConfig;", "requestUpdateAll", "runNativeTask", "input", "Lcom/bytedance/pitaya/api/bean/PTYNativeTaskData;", "taskConfig", "Lcom/bytedance/pitaya/api/bean/PTYNativeTaskConfig;", "resultCallback", "Lcom/bytedance/pitaya/api/PTYTaskResultCallback;", "runTask", "Lcom/bytedance/pitaya/api/bean/PTYTaskData;", "Lcom/bytedance/pitaya/api/bean/PTYTaskConfig;", "setup", "ptySetupInfo", "Lcom/bytedance/pitaya/api/bean/PTYSetupInfo;", "Lcom/bytedance/pitaya/api/PTYSetupCallback;", "socketLogError", "content", "socketLogInfo", "socketLogWarn", "stopAllDownloadTask", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IPitayaCore extends PitayaFE {
    void cleanStorage(Context context, PTYCleanStrategy strategy, PTYNormalCallback callback);

    void downloadPackage(String businessName, PTYPackageCallback packageCallback);

    String getAid();

    boolean isPreloadReady();

    boolean isReady();

    void preDownloadAllPackage();

    void queryPackage(String businessName, PTYPackageCallback packageCallback);

    void releaseAllEngines();

    void releaseEngine(String businessName);

    void releaseNativeEngine(String businessName);

    void requestUpdate(String businessName, PTYRequestConfig requestConfig, PTYPackageCallback packageCallback);

    void requestUpdateAll();

    void runNativeTask(String businessName, PTYNativeTaskData input, PTYNativeTaskConfig taskConfig, PTYTaskResultCallback resultCallback);

    void runTask(String businessName, PTYTaskData input, PTYTaskConfig taskConfig, PTYTaskResultCallback resultCallback);

    void setAid(String str);

    void setup(Context context, PTYSetupInfo ptySetupInfo, PTYSetupCallback callback);

    void socketLogError(String content);

    void socketLogInfo(String content);

    void socketLogWarn(String content);

    void stopAllDownloadTask();

    /* compiled from: IPitayaCore.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void requestUpdate$default(IPitayaCore iPitayaCore, String str, PTYRequestConfig pTYRequestConfig, PTYPackageCallback pTYPackageCallback, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestUpdate");
            }
            if ((i & 2) != 0) {
                pTYRequestConfig = new PTYRequestConfig(false, null, 3, null);
            }
            if ((i & 4) != 0) {
                pTYPackageCallback = null;
            }
            iPitayaCore.requestUpdate(str, pTYRequestConfig, pTYPackageCallback);
        }

        public static /* synthetic */ void runTask$default(IPitayaCore iPitayaCore, String str, PTYTaskData pTYTaskData, PTYTaskConfig pTYTaskConfig, PTYTaskResultCallback pTYTaskResultCallback, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: runTask");
            }
            if ((i & 2) != 0) {
                pTYTaskData = null;
            }
            if ((i & 4) != 0) {
                pTYTaskConfig = new PTYTaskConfig(false, null, 0.0f, 7, null);
            }
            iPitayaCore.runTask(str, pTYTaskData, pTYTaskConfig, pTYTaskResultCallback);
        }
    }
}
