package com.bytedance.ies.tools.prefetch;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ProcessManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0012\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\n¢\u0006\u0002\b\t"}, d2 = {"tryConvertWithLog", "", "T", "Lcom/bytedance/ies/tools/prefetch/TypedParam$WithSpecifiedType;", "Lcom/bytedance/ies/tools/prefetch/TypedParam;", "", "exp", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "invoke"}, k = 3, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class ProcessManager$toSpecifiedType$1 extends Lambda implements Function2<String, Function1<? super String, ? extends Object>, Object> {
    public static final ProcessManager$toSpecifiedType$1 INSTANCE = new ProcessManager$toSpecifiedType$1();

    ProcessManager$toSpecifiedType$1() {
        super(2);
    }

    public final Object invoke(String str, Function1<? super String, ? extends Object> function1) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(str, "$this$tryConvertWithLog");
        Intrinsics.checkParameterIsNotNull(function1, "exp");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(function1.invoke(str));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            LogUtil.w$default(LogUtil.INSTANCE, "Failed to parse param value [" + str + "], keeping as String.", null, 2, null);
        }
        return Result.isFailure-impl(obj) ? str : obj;
    }
}
