package com.bytedance.sdk.account.platform.base;

import android.os.Bundle;

/* loaded from: classes5.dex */
public interface AuthorizeCallback {
    void onError(AuthorizeErrorResponse authorizeErrorResponse);

    void onSuccess(Bundle bundle);
}
