package com.bytedance.android.live.pcdn.api;

import com.bytedance.webx.core.webview.WebViewContainer;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PCDNManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000*\u0001\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0004J\b\u0010\t\u001a\u00020\nH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/pcdn/api/PCDNManager;", "", "()V", "defaultDownloader", "Lcom/bytedance/android/live/pcdn/api/IPCDNDownloader;", "emptyDownloader", "com/bytedance/android/live/pcdn/api/PCDNManager$emptyDownloader$1", "Lcom/bytedance/android/live/pcdn/api/PCDNManager$emptyDownloader$1;", "getDownloader", "initDownloader", "", "livepcdn-api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class PCDNManager {
    private static IPCDNDownloader defaultDownloader;
    public static final PCDNManager INSTANCE = new PCDNManager();
    private static final PCDNManager$emptyDownloader$1 emptyDownloader = new IPCDNDownloader() { // from class: com.bytedance.android.live.pcdn.api.PCDNManager$emptyDownloader$1
        @Override // com.bytedance.android.live.pcdn.api.IPCDNDownloader
        public int init(String config, IPCDNDownloaderListener listener) {
            Intrinsics.checkParameterIsNotNull(config, "config");
            Intrinsics.checkParameterIsNotNull(listener, "listener");
            PCDNLogger.INSTANCE.i(PCDNManagerKt.TAG, "init");
            return -1;
        }

        @Override // com.bytedance.android.live.pcdn.api.IPCDNDownloader
        public void destroy() {
            PCDNLogger.INSTANCE.i(PCDNManagerKt.TAG, WebViewContainer.EVENT_destroy);
        }

        @Override // com.bytedance.android.live.pcdn.api.IPCDNDownloader
        public List<String> getAllCompleteFiles() {
            PCDNLogger.INSTANCE.i(PCDNManagerKt.TAG, "getAllCompleteFiles");
            return Collections.emptyList();
        }

        @Override // com.bytedance.android.live.pcdn.api.IPCDNDownloader
        public List<IPCDNDownloadTask> resumeAllUnfinishedTasks() {
            PCDNLogger.INSTANCE.i(PCDNManagerKt.TAG, "resumeAllUnfinishedTasks");
            return Collections.emptyList();
        }

        @Override // com.bytedance.android.live.pcdn.api.IPCDNDownloader
        public IPCDNDownloadTask createTask(String dloadUrl, String fileUniqId, String fileName) {
            PCDNLogger.INSTANCE.i(PCDNManagerKt.TAG, "createTask");
            return null;
        }

        @Override // com.bytedance.android.live.pcdn.api.IPCDNDownloader
        public int deleteTask(IPCDNDownloadTask task) {
            PCDNLogger.INSTANCE.i(PCDNManagerKt.TAG, "deleteTask");
            return 0;
        }

        @Override // com.bytedance.android.live.pcdn.api.IPCDNDownloader
        public int deleteFile(String fileName) {
            PCDNLogger.INSTANCE.i(PCDNManagerKt.TAG, "deleteFile");
            return 0;
        }

        @Override // com.bytedance.android.live.pcdn.api.IPCDNDownloader
        public int setStringValue(String strParamName, String strParamValue) {
            PCDNLogger.INSTANCE.i(PCDNManagerKt.TAG, "setStringValue");
            return 0;
        }

        @Override // com.bytedance.android.live.pcdn.api.IPCDNDownloader
        public String getStringValue(String strParamName) {
            PCDNLogger.INSTANCE.i(PCDNManagerKt.TAG, "getStringValue");
            return null;
        }
    };

    private PCDNManager() {
    }

    private final void initDownloader() {
        IPCDNDownloader iPCDNDownloader;
        try {
            Constructor<?> constructor = Class.forName("com.bytedance.android.live.pcdn.impl.PCDNDownloader").getConstructor(new Class[0]);
            Intrinsics.checkExpressionValueIsNotNull(constructor, "clazz.getConstructor()");
            Object newInstance = constructor.newInstance(new Object[0]);
            Intrinsics.checkExpressionValueIsNotNull(newInstance, "constructor.newInstance()");
            if (newInstance instanceof IPCDNDownloader) {
                PCDNLogger.INSTANCE.i(PCDNManagerKt.TAG, "initDownloader: obj is PCDNDownloader ");
                iPCDNDownloader = (IPCDNDownloader) newInstance;
            } else {
                PCDNLogger.INSTANCE.w(PCDNManagerKt.TAG, "initDownloader: obj not is PCDNDownloader");
                iPCDNDownloader = null;
            }
            defaultDownloader = iPCDNDownloader;
        } catch (Throwable th) {
            PCDNLogger.INSTANCE.e(PCDNManagerKt.TAG, "initDownloader failed", th);
        }
    }

    public final IPCDNDownloader getDownloader() {
        IPCDNDownloader iPCDNDownloader = defaultDownloader;
        if (iPCDNDownloader != null) {
            if (iPCDNDownloader != null) {
                return iPCDNDownloader;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.live.pcdn.api.IPCDNDownloader");
        }
        initDownloader();
        if (defaultDownloader != null) {
            PCDNLogger.INSTANCE.w(PCDNManagerKt.TAG, "getDownloader: defaultDownloader !=null");
            IPCDNDownloader iPCDNDownloader2 = defaultDownloader;
            if (iPCDNDownloader2 != null) {
                return iPCDNDownloader2;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.live.pcdn.api.IPCDNDownloader");
        }
        PCDNLogger.INSTANCE.w(PCDNManagerKt.TAG, "getDownloader: defaultDownloader == null, use emptyDownloader");
        return emptyDownloader;
    }
}
