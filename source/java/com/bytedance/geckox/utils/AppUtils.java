package com.bytedance.geckox.utils;

import android.content.Context;
import com.bytedance.geckox.logger.GeckoLogger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/geckox/utils/AppUtils;", "", "()V", "getVersion", "", "context", "Landroid/content/Context;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class AppUtils {
    public static final AppUtils INSTANCE = new AppUtils();

    private AppUtils() {
    }

    @JvmStatic
    public static final String getVersion(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            Intrinsics.checkExpressionValueIsNotNull(str, "packInfo.versionName");
            return str;
        } catch (Exception e) {
            GeckoLogger.w("getVersion:", e);
            return "null";
        }
    }
}
