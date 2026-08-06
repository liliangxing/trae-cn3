package com.bytedance.ug.sdk.deeplink;

import java.util.List;

/* loaded from: classes4.dex */
public interface CallBackForAppLink {
    boolean dealWithSchema(String str);

    List<String> getHostList();
}
