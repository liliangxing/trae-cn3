package com.bytedance.trae.home.solo.setting.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: DeviceManagementRepository.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\u000e\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u0011R\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository;", "", "devices", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;", "getDevices", "()Lkotlinx/coroutines/flow/StateFlow;", "refresh", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "renameDevice", "cliId", "", "name", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDevice", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface DeviceManagementRepository {
    Object deleteDevice(String str, Continuation<? super Boolean> continuation);

    StateFlow<List<DeviceManagementDevice>> getDevices();

    Object refresh(Continuation<? super Boolean> continuation);

    Object renameDevice(String str, String str2, Continuation<? super Boolean> continuation);
}
