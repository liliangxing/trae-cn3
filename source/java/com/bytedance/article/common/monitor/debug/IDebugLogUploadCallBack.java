package com.bytedance.article.common.monitor.debug;

import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public interface IDebugLogUploadCallBack {
    List<String> getUploadContentFileNameList();

    void notifyBeginUpload(String str);

    void notifyEndUpload(String str, boolean z);
}
