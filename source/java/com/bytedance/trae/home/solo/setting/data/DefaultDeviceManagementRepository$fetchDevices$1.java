package com.bytedance.trae.home.solo.setting.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceManagementRepository.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository", f = "DeviceManagementRepository.kt", i = {0}, l = {176}, m = "fetchDevices", n = {"$this$fetchDevices_u24lambda_u243"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DefaultDeviceManagementRepository$fetchDevices$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultDeviceManagementRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultDeviceManagementRepository$fetchDevices$1(DefaultDeviceManagementRepository defaultDeviceManagementRepository, Continuation<? super DefaultDeviceManagementRepository$fetchDevices$1> continuation) {
        super(continuation);
        this.this$0 = defaultDeviceManagementRepository;
    }

    public final Object invokeSuspend(Object obj) {
        Object fetchDevices;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchDevices = this.this$0.fetchDevices((Continuation) this);
        return fetchDevices;
    }
}
