package com.bytedance.android.live.setting;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LiveSettingConfigBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB \b\u0012\u0012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\u0010\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/setting/LiveSettingConfigBuilder;", "", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "()V", "liveSettingDepend", "Lcom/bytedance/android/live/setting/ILiveSettingDepend;", "getLiveSettingDepend", "()Lcom/bytedance/android/live/setting/ILiveSettingDepend;", "setLiveSettingDepend", "(Lcom/bytedance/android/live/setting/ILiveSettingDepend;)V", "Companion", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class LiveSettingConfigBuilder {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ILiveSettingDepend liveSettingDepend;

    private LiveSettingConfigBuilder() {
    }

    public /* synthetic */ LiveSettingConfigBuilder(Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1);
    }

    public final ILiveSettingDepend getLiveSettingDepend() {
        return this.liveSettingDepend;
    }

    public final void setLiveSettingDepend(ILiveSettingDepend iLiveSettingDepend) {
        this.liveSettingDepend = iLiveSettingDepend;
    }

    private LiveSettingConfigBuilder(Function1<? super LiveSettingConfigBuilder, Unit> function1) {
        this();
        function1.invoke(this);
    }

    /* compiled from: LiveSettingConfigBuilder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/setting/LiveSettingConfigBuilder$Companion;", "", "()V", "build", "Lcom/bytedance/android/live/setting/LiveSettingConfigBuilder;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "live-setting_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveSettingConfigBuilder build(Function1<? super LiveSettingConfigBuilder, Unit> init) {
            Intrinsics.checkNotNullParameter(init, "init");
            return new LiveSettingConfigBuilder(init, null);
        }
    }
}
