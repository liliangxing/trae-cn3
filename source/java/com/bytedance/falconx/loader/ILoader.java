package com.bytedance.falconx.loader;

import java.io.InputStream;
import java.util.Map;

/* loaded from: classes3.dex */
public interface ILoader {
    boolean exist(String str) throws Throwable;

    Map<String, Long> getChannelVersion();

    InputStream getInputStream(String str) throws Throwable;

    String getResRootDir();

    void release() throws Throwable;
}
