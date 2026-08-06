package com.bytedance.geckox.loader;

import java.io.InputStream;

@Deprecated
/* loaded from: classes3.dex */
public interface ILoader {
    boolean exist(String str) throws Throwable;

    String getBundlePath(String str) throws Throwable;

    InputStream getInputStream(String str) throws Throwable;

    InputStream getPrefetchData(String str) throws Throwable;

    void release() throws Throwable;
}
