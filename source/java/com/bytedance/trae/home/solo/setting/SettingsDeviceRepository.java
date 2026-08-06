package com.bytedance.trae.home.solo.setting;

import com.bytedance.trae.conversation.devices.MobileDevice;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* compiled from: SettingsDeviceListViewModel.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u00030\u0005H¦@¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/SettingsDeviceRepository;", "", "fetchDevices", "", "onResult", "Lkotlin/Function1;", "", "Lcom/bytedance/trae/conversation/devices/MobileDevice;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCachedDevices", "renameCli", "", "cliId", "", "name", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterCli", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SettingsDeviceRepository {
    Object fetchDevices(Function1<? super List<MobileDevice>, Unit> function1, Continuation<? super Unit> continuation);

    List<MobileDevice> getCachedDevices();

    Object renameCli(String str, String str2, Continuation<? super Boolean> continuation);

    Object unregisterCli(String str, Continuation<? super Boolean> continuation);
}
