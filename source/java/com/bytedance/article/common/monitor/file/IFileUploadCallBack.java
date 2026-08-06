package com.bytedance.article.common.monitor.file;

import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public interface IFileUploadCallBack {
    List<String> getUploadFileList();

    void notifyUploadBegin(String str);

    void notifyUploadEnd(String str, boolean z);
}
