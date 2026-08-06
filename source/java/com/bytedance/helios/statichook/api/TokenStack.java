package com.bytedance.helios.statichook.api;

import java.util.Map;

/* loaded from: classes3.dex */
public interface TokenStack {
    void pop(String str);

    void push(String str, Map<String, String> map);
}
