package com.bytedance.android.monitorV2;

import android.util.Log;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AnnieXMonitorConstants.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/monitorV2/AnnieXMonitorConstants;", "", "()V", "ANNIEX_VERSION", "", "ANNIEX_VERSION_CODE", "", "getANNIEX_VERSION_CODE", "()J", "ANNIEX_VERSION_CODE$delegate", "Lkotlin/Lazy;", "getVersionCode", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class AnnieXMonitorConstants {
    public static final String ANNIEX_VERSION = "9.0.0";
    public static final AnnieXMonitorConstants INSTANCE = new AnnieXMonitorConstants();

    /* renamed from: ANNIEX_VERSION_CODE$delegate, reason: from kotlin metadata */
    private static final Lazy ANNIEX_VERSION_CODE = LazyKt.lazy(new Function0<Long>() { // from class: com.bytedance.android.monitorV2.AnnieXMonitorConstants$ANNIEX_VERSION_CODE$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Long m322invoke() {
            long versionCode;
            versionCode = AnnieXMonitorConstants.INSTANCE.getVersionCode();
            return Long.valueOf(versionCode);
        }
    });

    private AnnieXMonitorConstants() {
    }

    public final long getANNIEX_VERSION_CODE() {
        return ((Number) ANNIEX_VERSION_CODE.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getVersionCode() {
        try {
            Result.Companion companion = Result.Companion;
            List split$default = StringsKt.split$default(ANNIEX_VERSION, new String[]{"."}, false, 0, 6, (Object) null);
            StringBuilder sb = new StringBuilder();
            if (split$default.size() >= 3) {
                int i = 0;
                for (Object obj : split$default) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    String str = (String) obj;
                    if (i == 0) {
                        sb.append(str);
                    } else if (i == 2) {
                        String str2 = (String) StringsKt.split$default(str, new String[]{"-"}, false, 0, 6, (Object) null).get(0);
                        if (Integer.parseInt(str2) <= 9) {
                            sb.append('0' + str2);
                        } else {
                            sb.append(str2);
                        }
                    } else {
                        if (str.length() < 2) {
                            str = '0' + str;
                        }
                        sb.append(str);
                    }
                    i = i2;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "codeSb.toString()");
            return Long.parseLong(sb2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Throwable th2 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
            if (th2 == null) {
                return 0L;
            }
            String message = th2.getMessage();
            if (message == null) {
                message = "";
            }
            Log.e("AnnieXMonitorConstants", message);
            return 0L;
        }
    }
}
