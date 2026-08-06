package com.bytedance.upc.common.utils;

import android.net.Uri;
import com.bytedance.upc.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UriUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/upc/common/utils/UriUtils;", "", "()V", "getParam", "", "uriStr", "key", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes6.dex */
public final class UriUtils {
    public static final UriUtils INSTANCE = new UriUtils();

    private UriUtils() {
    }

    @JvmStatic
    public static final String getParam(String uriStr, String key) {
        Intrinsics.checkParameterIsNotNull(uriStr, "uriStr");
        Intrinsics.checkParameterIsNotNull(key, "key");
        try {
            return Uri.parse(uriStr).getQueryParameter(key);
        } catch (Throwable unused) {
            return null;
        }
    }
}
