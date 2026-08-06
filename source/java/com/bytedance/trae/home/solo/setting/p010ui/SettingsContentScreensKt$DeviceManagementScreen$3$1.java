package com.bytedance.trae.home.solo.setting.p010ui;

import com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementAction;
import com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsContentScreens.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public /* synthetic */ class SettingsContentScreensKt$DeviceManagementScreen$3$1 extends FunctionReferenceImpl implements Function1<DeviceManagementAction, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SettingsContentScreensKt$DeviceManagementScreen$3$1(Object obj) {
        super(1, obj, DeviceManagementViewModel.class, "onAction", "onAction(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DeviceManagementAction) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DeviceManagementAction deviceManagementAction) {
        Intrinsics.checkNotNullParameter(deviceManagementAction, "p0");
        ((DeviceManagementViewModel) this.receiver).onAction(deviceManagementAction);
    }
}
