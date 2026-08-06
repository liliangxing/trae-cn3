package com.bytedance.lego.init;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitSchedulerExecutors.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¨\u0006\u0004"}, d2 = {"singleAsync", "", "runnable", "Lkotlin/Function0;", "initscheduler_release"}, k = 2, mv = {1, 1, 13})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class InitSchedulerExecutorsKt {
    public static final void singleAsync(final Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "runnable");
        InitSchedulerExecutors.INSTANCE.getThreadPoolExecutor$initscheduler_release().execute(new Runnable() { // from class: com.bytedance.lego.init.InitSchedulerExecutorsKt$sam$java_lang_Runnable$0
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                Intrinsics.checkExpressionValueIsNotNull(function0.invoke(), "invoke(...)");
            }
        });
    }
}
