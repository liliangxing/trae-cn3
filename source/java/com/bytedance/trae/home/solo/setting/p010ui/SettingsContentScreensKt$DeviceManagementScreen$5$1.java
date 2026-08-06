package com.bytedance.trae.home.solo.setting.p010ui;

import androidx.compose.runtime.State;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementEffect;
import com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementViewModel;
import com.bytedance.trae.kmp.host.KmpHostActions;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsContentScreens.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.ui.SettingsContentScreensKt$DeviceManagementScreen$5$1", f = "SettingsContentScreens.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsContentScreensKt$DeviceManagementScreen$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<String> $latestCopySuccessMessage$delegate;
    final /* synthetic */ Function0<Unit> $onRefreshDeviceCache;
    final /* synthetic */ DeviceManagementViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsContentScreensKt$DeviceManagementScreen$5$1(DeviceManagementViewModel deviceManagementViewModel, Function0<Unit> function0, State<String> state, Continuation<? super SettingsContentScreensKt$DeviceManagementScreen$5$1> continuation) {
        super(2, continuation);
        this.$viewModel = deviceManagementViewModel;
        this.$onRefreshDeviceCache = function0;
        this.$latestCopySuccessMessage$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsContentScreensKt$DeviceManagementScreen$5$1(this.$viewModel, this.$onRefreshDeviceCache, this.$latestCopySuccessMessage$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow<DeviceManagementEffect> effects = this.$viewModel.getEffects();
            final Function0<Unit> function0 = this.$onRefreshDeviceCache;
            final State<String> state = this.$latestCopySuccessMessage$delegate;
            this.label = 1;
            if (effects.collect(new FlowCollector() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsContentScreensKt$DeviceManagementScreen$5$1.1
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((DeviceManagementEffect) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(DeviceManagementEffect deviceManagementEffect, Continuation<? super Unit> continuation) {
                    String DeviceManagementScreen$lambda$7;
                    if (deviceManagementEffect instanceof DeviceManagementEffect.CopyToClipboard) {
                        KmpHostActions.INSTANCE.copyToClipboard(((DeviceManagementEffect.CopyToClipboard) deviceManagementEffect).getText());
                    } else if (Intrinsics.areEqual(deviceManagementEffect, DeviceManagementEffect.ShowCopySuccessToast.INSTANCE)) {
                        KmpHostActions kmpHostActions = KmpHostActions.INSTANCE;
                        DeviceManagementScreen$lambda$7 = SettingsContentScreensKt.DeviceManagementScreen$lambda$7(state);
                        kmpHostActions.showToast(DeviceManagementScreen$lambda$7);
                    } else {
                        if (!Intrinsics.areEqual(deviceManagementEffect, DeviceManagementEffect.RefreshDeviceCache.INSTANCE)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        function0.invoke();
                    }
                    return Unit.INSTANCE;
                }
            }, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
