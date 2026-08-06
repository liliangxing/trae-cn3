package com.bytedance.trae.conversation.devices;

import com.bytedance.trae.conversation.DeviceDiscoveryRefreshResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: ConnectComputerGuideViewModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/trae/conversation/devices/BindingDeviceDiscovery;", "", "refresh", "Lcom/bytedance/trae/conversation/DeviceDiscoveryRefreshResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface BindingDeviceDiscovery {
    Object refresh(Continuation<? super DeviceDiscoveryRefreshResult> continuation);
}
