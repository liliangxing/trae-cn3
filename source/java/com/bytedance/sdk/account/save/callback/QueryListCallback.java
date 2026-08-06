package com.bytedance.sdk.account.save.callback;

import com.bytedance.sdk.account.save.entity.LoginInfo;
import java.util.List;

/* loaded from: classes5.dex */
public interface QueryListCallback {
    void onError(int i, String str);

    void onSuccess(List<LoginInfo> list);
}
