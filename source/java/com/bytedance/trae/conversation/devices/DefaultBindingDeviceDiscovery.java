package com.bytedance.trae.conversation.devices;

import com.bytedance.trae.conversation.CliListRepository;
import com.bytedance.trae.conversation.DeviceDiscoveryRefreshResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConnectComputerGuideViewModel.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DefaultBindingDeviceDiscovery;", "Lcom/bytedance/trae/conversation/devices/BindingDeviceDiscovery;", "<init>", "()V", "refresh", "Lcom/bytedance/trae/conversation/DeviceDiscoveryRefreshResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DefaultBindingDeviceDiscovery implements BindingDeviceDiscovery {
    public static final DefaultBindingDeviceDiscovery INSTANCE = new DefaultBindingDeviceDiscovery();

    private DefaultBindingDeviceDiscovery() {
    }

    @Override // com.bytedance.trae.conversation.devices.BindingDeviceDiscovery
    public Object refresh(Continuation<? super DeviceDiscoveryRefreshResult> continuation) {
        return CliListRepository.INSTANCE.getInstance().refreshDiscoverableDevices(continuation);
    }
}
