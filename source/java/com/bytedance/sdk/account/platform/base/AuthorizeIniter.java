package com.bytedance.sdk.account.platform.base;

import android.content.Context;
import com.bytedance.sdk.account.platform.api.IAuthorizeService;

/* loaded from: classes5.dex */
public interface AuthorizeIniter<T extends IAuthorizeService> {
    void init(Context context);
}
