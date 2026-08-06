package com.bytedance.crash;

import java.util.Map;

/* loaded from: classes3.dex */
public interface ITagCacheService {
    Map<String, String> getAll(String str);

    void removeTag(String str, String str2);

    void saveTag(String str, String str2, String str3);
}
