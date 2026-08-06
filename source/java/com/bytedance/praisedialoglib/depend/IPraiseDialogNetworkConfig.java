package com.bytedance.praisedialoglib.depend;

import java.util.Map;

/* loaded from: classes4.dex */
public interface IPraiseDialogNetworkConfig {
    int checkResponseException(Throwable th);

    String executeGet(int i, String str) throws Exception;

    String executePost(int i, String str, Map<String, String> map) throws Exception;
}
