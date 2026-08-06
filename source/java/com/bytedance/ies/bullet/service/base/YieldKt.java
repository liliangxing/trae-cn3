package com.bytedance.ies.bullet.service.base;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Yield.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0013\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0086\b\u001a/\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\u0002H\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\b0\u0007H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\t\u001a4\u0010\n\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\u0002H\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\t\u001a7\u0010\f\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\r*\u0002H\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\r0\u0007H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\t\u001a1\u0010\u000e\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\r*\u0002H\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\r0\u000fH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a<\u0010\u000e\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\r*\u0002H\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\r0\u0007¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\t*\n\u0010\u0011\"\u00020\u00122\u00020\u0012\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"yieldReturn", "", "message", "", "yieldSafeAlso", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "yieldSafeApply", "Lkotlin/ExtensionFunctionType;", "yieldSafeLet", "R", "yieldSafeRun", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "YieldSignal", "Lcom/bytedance/ies/bullet/service/base/YieldError;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class YieldKt {
    public static final <T> T yieldSafeApply(T t, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            block.invoke(t);
        } catch (YieldError unused) {
        }
        return t;
    }

    public static final <T, R> R yieldSafeRun(T t, Function0<? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return block.invoke();
        } catch (YieldError unused) {
            return null;
        }
    }

    public static final <T, R> R yieldSafeRun(T t, Function1<? super T, ? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return block.invoke(t);
        } catch (YieldError unused) {
            return null;
        }
    }

    public static final <T> T yieldSafeAlso(T t, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            block.invoke(t);
        } catch (YieldError unused) {
        }
        return t;
    }

    public static final <T, R> R yieldSafeLet(T t, Function1<? super T, ? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return block.invoke(t);
        } catch (YieldError unused) {
            return null;
        }
    }

    public static final Void yieldReturn(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        throw new YieldError(message);
    }

    public static /* synthetic */ Void yieldReturn$default(String message, int i, Object obj) {
        if ((i & 1) != 0) {
            message = "An operation is not implemented";
        }
        Intrinsics.checkNotNullParameter(message, "message");
        throw new YieldError(message);
    }
}
