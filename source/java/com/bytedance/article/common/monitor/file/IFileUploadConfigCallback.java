package com.bytedance.article.common.monitor.file;

@Deprecated
/* loaded from: classes3.dex */
public interface IFileUploadConfigCallback extends IFileUploadCallBack {
    boolean isCompress();

    boolean isDelSourceFile();

    boolean isSkipUploadInternal();
}
