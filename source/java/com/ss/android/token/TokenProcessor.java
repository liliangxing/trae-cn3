package com.ss.android.token;

import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public interface TokenProcessor {
    Map<String, String> processRequest(String str);

    void processResponse(String str, List<TTTokenHeader> list);
}
