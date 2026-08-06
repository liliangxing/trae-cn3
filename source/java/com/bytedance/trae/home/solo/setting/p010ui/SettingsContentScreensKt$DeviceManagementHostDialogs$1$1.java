package com.bytedance.trae.home.solo.setting.p010ui;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementAction;
import com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementDeleteState;
import com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementRenameState;
import com.bytedance.trae.kmp.host.KmpHostDialogs;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsContentScreens.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.ui.SettingsContentScreensKt$DeviceManagementHostDialogs$1$1", f = "SettingsContentScreens.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsContentScreensKt$DeviceManagementHostDialogs$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cancelText;
    final /* synthetic */ String $confirmText;
    final /* synthetic */ DeviceManagementDeleteState $deleteDialog;
    final /* synthetic */ String $deleteMessage;
    final /* synthetic */ String $deleteText;
    final /* synthetic */ String $deleteTitle;
    final /* synthetic */ Function1<DeviceManagementAction, Unit> $onAction;
    final /* synthetic */ DeviceManagementRenameState $renameDialog;
    final /* synthetic */ String $renameTitle;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SettingsContentScreensKt$DeviceManagementHostDialogs$1$1(DeviceManagementRenameState deviceManagementRenameState, String str, String str2, String str3, DeviceManagementDeleteState deviceManagementDeleteState, String str4, String str5, String str6, Function1<? super DeviceManagementAction, Unit> function1, Continuation<? super SettingsContentScreensKt$DeviceManagementHostDialogs$1$1> continuation) {
        super(2, continuation);
        this.$renameDialog = deviceManagementRenameState;
        this.$renameTitle = str;
        this.$cancelText = str2;
        this.$confirmText = str3;
        this.$deleteDialog = deviceManagementDeleteState;
        this.$deleteTitle = str4;
        this.$deleteMessage = str5;
        this.$deleteText = str6;
        this.$onAction = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsContentScreensKt$DeviceManagementHostDialogs$1$1(this.$renameDialog, this.$renameTitle, this.$cancelText, this.$confirmText, this.$deleteDialog, this.$deleteTitle, this.$deleteMessage, this.$deleteText, this.$onAction, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.$renameDialog != null) {
            KmpHostDialogs kmpHostDialogs = KmpHostDialogs.INSTANCE;
            String str = this.$renameTitle;
            String name = this.$renameDialog.getDevice().getName();
            String str2 = this.$cancelText;
            String str3 = this.$confirmText;
            final Function1<DeviceManagementAction, Unit> function1 = this.$onAction;
            final DeviceManagementRenameState deviceManagementRenameState = this.$renameDialog;
            Function1 function12 = new Function1() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsContentScreensKt$DeviceManagementHostDialogs$1$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    Unit invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = SettingsContentScreensKt$DeviceManagementHostDialogs$1$1.invokeSuspend$lambda$0(function1, deviceManagementRenameState, (String) obj2);
                    return invokeSuspend$lambda$0;
                }
            };
            final Function1<DeviceManagementAction, Unit> function13 = this.$onAction;
            kmpHostDialogs.showTextInputDialog(str, name, (String) null, str2, str3, function12, new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsContentScreensKt$DeviceManagementHostDialogs$1$1$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = SettingsContentScreensKt$DeviceManagementHostDialogs$1$1.invokeSuspend$lambda$1(function13);
                    return invokeSuspend$lambda$1;
                }
            });
        } else if (this.$deleteDialog != null) {
            KmpHostDialogs kmpHostDialogs2 = KmpHostDialogs.INSTANCE;
            String str4 = this.$deleteTitle;
            String str5 = this.$deleteMessage;
            String str6 = this.$cancelText;
            String str7 = this.$deleteText;
            final Function1<DeviceManagementAction, Unit> function14 = this.$onAction;
            final DeviceManagementDeleteState deviceManagementDeleteState = this.$deleteDialog;
            Function0 function0 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsContentScreensKt$DeviceManagementHostDialogs$1$1$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit invokeSuspend$lambda$2;
                    invokeSuspend$lambda$2 = SettingsContentScreensKt$DeviceManagementHostDialogs$1$1.invokeSuspend$lambda$2(function14, deviceManagementDeleteState);
                    return invokeSuspend$lambda$2;
                }
            };
            final Function1<DeviceManagementAction, Unit> function15 = this.$onAction;
            kmpHostDialogs2.showConfirmDialog(str4, str5, str6, str7, true, function0, new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsContentScreensKt$DeviceManagementHostDialogs$1$1$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit invokeSuspend$lambda$3;
                    invokeSuspend$lambda$3 = SettingsContentScreensKt$DeviceManagementHostDialogs$1$1.invokeSuspend$lambda$3(function15);
                    return invokeSuspend$lambda$3;
                }
            });
        } else {
            KmpHostDialogs.INSTANCE.dismiss();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(Function1 function1, DeviceManagementRenameState deviceManagementRenameState, String str) {
        function1.invoke(new DeviceManagementAction.SubmitRename(deviceManagementRenameState.getDevice(), str));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(Function1 function1) {
        function1.invoke(DeviceManagementAction.CloseRename.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$2(Function1 function1, DeviceManagementDeleteState deviceManagementDeleteState) {
        function1.invoke(new DeviceManagementAction.ConfirmDelete(deviceManagementDeleteState.getDevice()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$3(Function1 function1) {
        function1.invoke(DeviceManagementAction.CloseDelete.INSTANCE);
        return Unit.INSTANCE;
    }
}
