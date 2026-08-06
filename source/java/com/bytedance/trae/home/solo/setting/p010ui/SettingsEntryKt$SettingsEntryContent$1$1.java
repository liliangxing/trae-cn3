package com.bytedance.trae.home.solo.setting.p010ui;

import androidx.compose.runtime.MutableState;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.kmp.host.KmpHostDialogs;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsEntry.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$SettingsEntryContent$1$1", f = "SettingsEntry.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsEntryKt$SettingsEntryContent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cancelText;
    final /* synthetic */ String $confirmText;
    final /* synthetic */ MutableState<Boolean> $logoutDialogVisible$delegate;
    final /* synthetic */ String $logoutMessage;
    final /* synthetic */ String $logoutTitle;
    final /* synthetic */ Function0<Unit> $onLogoutConfirmed;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsEntryKt$SettingsEntryContent$1$1(String str, String str2, String str3, String str4, MutableState<Boolean> mutableState, Function0<Unit> function0, Continuation<? super SettingsEntryKt$SettingsEntryContent$1$1> continuation) {
        super(2, continuation);
        this.$logoutTitle = str;
        this.$logoutMessage = str2;
        this.$cancelText = str3;
        this.$confirmText = str4;
        this.$logoutDialogVisible$delegate = mutableState;
        this.$onLogoutConfirmed = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsEntryKt$SettingsEntryContent$1$1(this.$logoutTitle, this.$logoutMessage, this.$cancelText, this.$confirmText, this.$logoutDialogVisible$delegate, this.$onLogoutConfirmed, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        boolean SettingsEntryContent$lambda$10;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SettingsEntryContent$lambda$10 = SettingsEntryKt.SettingsEntryContent$lambda$10(this.$logoutDialogVisible$delegate);
            if (SettingsEntryContent$lambda$10) {
                KmpHostDialogs kmpHostDialogs = KmpHostDialogs.INSTANCE;
                String str = this.$logoutTitle;
                String str2 = this.$logoutMessage;
                String str3 = this.$cancelText;
                String str4 = this.$confirmText;
                final Function0<Unit> function0 = this.$onLogoutConfirmed;
                final MutableState<Boolean> mutableState = this.$logoutDialogVisible$delegate;
                Function0 function02 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$SettingsEntryContent$1$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = SettingsEntryKt$SettingsEntryContent$1$1.invokeSuspend$lambda$0(function0, mutableState);
                        return invokeSuspend$lambda$0;
                    }
                };
                final MutableState<Boolean> mutableState2 = this.$logoutDialogVisible$delegate;
                kmpHostDialogs.showConfirmDialog(str, str2, str3, str4, true, function02, new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsEntryKt$SettingsEntryContent$1$1$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = SettingsEntryKt$SettingsEntryContent$1$1.invokeSuspend$lambda$1(mutableState2);
                        return invokeSuspend$lambda$1;
                    }
                });
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(Function0 function0, MutableState mutableState) {
        SettingsEntryKt.SettingsEntryContent$lambda$11(mutableState, false);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(MutableState mutableState) {
        SettingsEntryKt.SettingsEntryContent$lambda$11(mutableState, false);
        return Unit.INSTANCE;
    }
}
