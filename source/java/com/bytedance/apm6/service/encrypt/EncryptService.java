package com.bytedance.apm6.service.encrypt;

import android.util.Pair;
import java.util.List;

/* loaded from: classes3.dex */
public interface EncryptService {
    String tryEncryptRequest(String str, List<Pair<String, String>> list);
}
