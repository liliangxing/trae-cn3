package com.monitor.cloudmessage.upload.callback;

import java.util.List;

/* loaded from: classes7.dex */
public interface IFileUploadCallback {
    List<String> getUploadFileList();

    void notifyUploadBegin(String str);

    void notifyUploadEnd(String str, boolean z);
}
