package com.bytedance.trae.home.solo.setting;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsDeviceListViewModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.DefaultSettingsDeviceRepository", f = "SettingsDeviceListViewModel.kt", i = {}, l = {292}, m = "fetchDevices", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DefaultSettingsDeviceRepository$fetchDevices$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultSettingsDeviceRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultSettingsDeviceRepository$fetchDevices$1(DefaultSettingsDeviceRepository defaultSettingsDeviceRepository, Continuation<? super DefaultSettingsDeviceRepository$fetchDevices$1> continuation) {
        super(continuation);
        this.this$0 = defaultSettingsDeviceRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchDevices(null, (Continuation) this);
    }
}
