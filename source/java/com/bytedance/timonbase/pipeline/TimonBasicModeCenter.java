package com.bytedance.timonbase.pipeline;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimonBasicModeCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0005R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/bytedance/timonbase/pipeline/TimonBasicModeCenter;", "", "()V", "agreedPrivacy", "Lkotlin/Function0;", "", "getAgreedPrivacy", "()Lkotlin/jvm/functions/Function0;", "setAgreedPrivacy", "(Lkotlin/jvm/functions/Function0;)V", "basicMode", "getBasicMode", "setBasicMode", "isFuseForTimonBasic", "postSampleRate", "", "getPostSampleRate", "()J", "setPostSampleRate", "(J)V", "teenMode", "getTeenMode", "setTeenMode", "enableFuse", "", "isFuse", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class TimonBasicModeCenter {
    private static boolean isFuseForTimonBasic;
    public static final TimonBasicModeCenter INSTANCE = new TimonBasicModeCenter();
    private static Function0<Boolean> agreedPrivacy = new Function0<Boolean>() { // from class: com.bytedance.timonbase.pipeline.TimonBasicModeCenter$agreedPrivacy$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return false;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }
    };
    private static Function0<Boolean> basicMode = new Function0<Boolean>() { // from class: com.bytedance.timonbase.pipeline.TimonBasicModeCenter$basicMode$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return false;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }
    };
    private static Function0<Boolean> teenMode = new Function0<Boolean>() { // from class: com.bytedance.timonbase.pipeline.TimonBasicModeCenter$teenMode$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return false;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }
    };
    private static long postSampleRate = 100;

    private TimonBasicModeCenter() {
    }

    public final Function0<Boolean> getAgreedPrivacy() {
        return agreedPrivacy;
    }

    public final void setAgreedPrivacy(Function0<Boolean> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "<set-?>");
        agreedPrivacy = function0;
    }

    public final Function0<Boolean> getBasicMode() {
        return basicMode;
    }

    public final void setBasicMode(Function0<Boolean> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "<set-?>");
        basicMode = function0;
    }

    public final Function0<Boolean> getTeenMode() {
        return teenMode;
    }

    public final void setTeenMode(Function0<Boolean> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "<set-?>");
        teenMode = function0;
    }

    public final long getPostSampleRate() {
        return postSampleRate;
    }

    public final void setPostSampleRate(long j) {
        postSampleRate = j;
    }

    public final void enableFuse() {
        isFuseForTimonBasic = true;
    }

    public final boolean isFuse() {
        return isFuseForTimonBasic;
    }
}
