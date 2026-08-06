package com.bytedance.article.common.monitor.debug;

import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public class DebugLogUploadManager {
    public static String formatLog(String str) {
        return null;
    }

    public static boolean registerModule(String str, IDebugLogUploadCallBack iDebugLogUploadCallBack) {
        return true;
    }

    public static boolean unRegisterUploadContentModule(String str) {
        return true;
    }

    public static IDebugLogUploadCallBack getFileUploadModuleForType(String str) throws IllegalArgumentException {
        return new IDebugLogUploadCallBack() { // from class: com.bytedance.article.common.monitor.debug.DebugLogUploadManager.1
            @Override // com.bytedance.article.common.monitor.debug.IDebugLogUploadCallBack
            public List<String> getUploadContentFileNameList() {
                return null;
            }

            @Override // com.bytedance.article.common.monitor.debug.IDebugLogUploadCallBack
            public void notifyBeginUpload(String str2) {
            }

            @Override // com.bytedance.article.common.monitor.debug.IDebugLogUploadCallBack
            public void notifyEndUpload(String str2, boolean z) {
            }
        };
    }
}
