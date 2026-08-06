package com.bytedance.crash.util;

import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public class FdCollector {
    public static List<String> collect() {
        return NativeTools.get().getFdListForAPM();
    }
}
