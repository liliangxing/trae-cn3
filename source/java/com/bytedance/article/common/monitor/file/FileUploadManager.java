package com.bytedance.article.common.monitor.file;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
/* loaded from: classes3.dex */
public class FileUploadManager {
    private static ConcurrentHashMap<String, IFileUploadCallBack> sAllFileUploadCallBack = new ConcurrentHashMap<>();

    public static void registerFileCallBack(String str, IFileUploadCallBack iFileUploadCallBack) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str) || iFileUploadCallBack == null) {
            throw new IllegalArgumentException("type not be null or callback not be null");
        }
        if (sAllFileUploadCallBack.containsKey(str)) {
            return;
        }
        sAllFileUploadCallBack.put(str, iFileUploadCallBack);
    }

    public static void registerFileCallBack(String str, IFileUploadConfigCallback iFileUploadConfigCallback) throws IllegalArgumentException {
        registerFileCallBack(str, (IFileUploadCallBack) iFileUploadConfigCallback);
    }

    public static void unRegisterFileCallBack(String str) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("type must not be null");
        }
        sAllFileUploadCallBack.remove(str);
    }

    public static IFileUploadCallBack getFileCallBackForType(String str) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("type must not be null");
        }
        return sAllFileUploadCallBack.get(str);
    }
}
