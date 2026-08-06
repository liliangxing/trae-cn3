package com.bytedance.sdk.account;

import android.content.Context;
import com.ss.android.TTHeader;
import com.ss.android.TTResponse;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public interface INetWork {
    int checkResponseException(Context context, Throwable th);

    TTResponse executeGet(int i, String str, List<TTHeader> list) throws Exception;

    TTResponse executePost(int i, String str, Map<String, String> map, List<TTHeader> list) throws Exception;

    TTResponse postFile(int i, String str, Map<String, String> map, String str2, String str3, List<TTHeader> list) throws Exception;
}
