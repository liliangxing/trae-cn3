package com.bytedance.trae.home.solo.setting.viewmodel;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.solo.setting.data.SettingsCreditsState;
import com.bytedance.trae.home.solo.setting.data.model.PayIdentity;
import com.bytedance.trae.home.solo.setting.platform.UserInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function6;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsEntryViewModel.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;", "userInfo", "Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;", "payIdentity", "Lcom/bytedance/trae/home/solo/setting/data/model/PayIdentity;", "unreadCount", "", "creditsState", "Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState;", "<unused var>"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryViewModel$state$1", f = "SettingsEntryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsEntryViewModel$state$1 extends SuspendLambda implements Function6<UserInfo, PayIdentity, Integer, SettingsCreditsState, Integer, Continuation<? super SettingsEntryState>, Object> {
    /* synthetic */ int I$0;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;
    final /* synthetic */ SettingsEntryViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsEntryViewModel$state$1(SettingsEntryViewModel settingsEntryViewModel, Continuation<? super SettingsEntryViewModel$state$1> continuation) {
        super(6, continuation);
        this.this$0 = settingsEntryViewModel;
    }

    public final Object invoke(UserInfo userInfo, PayIdentity payIdentity, int i, SettingsCreditsState settingsCreditsState, int i2, Continuation<? super SettingsEntryState> continuation) {
        SettingsEntryViewModel$state$1 settingsEntryViewModel$state$1 = new SettingsEntryViewModel$state$1(this.this$0, continuation);
        settingsEntryViewModel$state$1.L$0 = userInfo;
        settingsEntryViewModel$state$1.L$1 = payIdentity;
        settingsEntryViewModel$state$1.I$0 = i;
        settingsEntryViewModel$state$1.L$2 = settingsCreditsState;
        return settingsEntryViewModel$state$1.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return invoke((UserInfo) obj, (PayIdentity) obj2, ((Number) obj3).intValue(), (SettingsCreditsState) obj4, ((Number) obj5).intValue(), (Continuation<? super SettingsEntryState>) obj6);
    }

    public final Object invokeSuspend(Object obj) {
        SettingsEntryState buildUiState;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            buildUiState = this.this$0.buildUiState((UserInfo) this.L$0, (PayIdentity) this.L$1, this.I$0, (SettingsCreditsState) this.L$2);
            return buildUiState;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
