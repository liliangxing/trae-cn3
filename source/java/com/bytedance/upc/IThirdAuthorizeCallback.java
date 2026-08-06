package com.bytedance.upc;

import android.os.Bundle;
import kotlin.Metadata;

/* compiled from: IThirdAuthorizeService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/upc/IThirdAuthorizeCallback;", "", "onFailed", "", "error", "", "msg", "", "onSuccess", "bundle", "Landroid/os/Bundle;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public interface IThirdAuthorizeCallback {
    void onFailed(int error, String msg);

    void onSuccess(Bundle bundle);
}
