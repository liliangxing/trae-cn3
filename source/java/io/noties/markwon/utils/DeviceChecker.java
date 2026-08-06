package io.noties.markwon.utils;

import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DeviceChecker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lio/noties/markwon/utils/DeviceChecker;", "", "()V", "isXiaomiDevice", "", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class DeviceChecker {
    public static final DeviceChecker INSTANCE = new DeviceChecker();

    private DeviceChecker() {
    }

    public final boolean isXiaomiDevice() {
        String str = Build.MANUFACTURER;
        String str2 = Build.BRAND;
        String str3 = Build.MODEL;
        if (StringsKt.equals(str, "Xiaomi", true) || StringsKt.equals(str2, "Xiaomi", true) || StringsKt.equals(str2, "Redmi", true)) {
            return true;
        }
        Intrinsics.checkExpressionValueIsNotNull(str3, "model");
        return StringsKt.startsWith(str3, "Mi", true) || StringsKt.startsWith(str3, "Redmi", true);
    }
}
