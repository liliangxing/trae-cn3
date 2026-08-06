package com.bytedance.trae.home.solo.setting.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceManagementViewModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementViewModel", f = "DeviceManagementViewModel.kt", i = {0}, l = {151}, m = "refreshDevices", n = {"this"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceManagementViewModel$refreshDevices$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceManagementViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceManagementViewModel$refreshDevices$1(DeviceManagementViewModel deviceManagementViewModel, Continuation<? super DeviceManagementViewModel$refreshDevices$1> continuation) {
        super(continuation);
        this.this$0 = deviceManagementViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        Object refreshDevices;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        refreshDevices = this.this$0.refreshDevices(false, (Continuation) this);
        return refreshDevices;
    }
}
