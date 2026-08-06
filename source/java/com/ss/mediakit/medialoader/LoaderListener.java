package com.ss.mediakit.medialoader;

/* loaded from: classes7.dex */
public interface LoaderListener {
    void onLoaderTaskCancel(LoaderEventInfo loaderEventInfo);

    void onLoaderTaskCompleted(LoaderEventInfo loaderEventInfo);

    void onLoaderTaskStart(LoaderEventInfo loaderEventInfo);
}
