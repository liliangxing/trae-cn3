package com.bytedance.services.apm.api;

import android.util.Pair;

/* loaded from: classes5.dex */
public interface IZstdDict {
    Pair<byte[], String> getDictAndDictVersion();

    void setDomain(String str);
}
