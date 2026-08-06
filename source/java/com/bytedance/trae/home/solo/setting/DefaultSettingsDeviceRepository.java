package com.bytedance.trae.home.solo.setting;

import com.bytedance.trae.conversation.CliListRepository;
import com.bytedance.trae.conversation.DeviceDiscoveryRefreshResult;
import com.bytedance.trae.conversation.devices.MobileDevice;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsDeviceListViewModel.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0006\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u00070\tH\u0096@¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository;", "Lcom/bytedance/trae/home/solo/setting/SettingsDeviceRepository;", "<init>", "()V", "cliRepository", "Lcom/bytedance/trae/conversation/CliListRepository;", "fetchDevices", "", "onResult", "Lkotlin/Function1;", "", "Lcom/bytedance/trae/conversation/devices/MobileDevice;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCachedDevices", "renameCli", "", "cliId", "", "name", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterCli", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DefaultSettingsDeviceRepository implements SettingsDeviceRepository {
    public static final DefaultSettingsDeviceRepository INSTANCE = new DefaultSettingsDeviceRepository();
    private static final CliListRepository cliRepository = CliListRepository.INSTANCE.getInstance();

    private DefaultSettingsDeviceRepository() {
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.bytedance.trae.home.solo.setting.SettingsDeviceRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fetchDevices(Function1<? super List<MobileDevice>, Unit> function1, Continuation<? super Unit> continuation) {
        DefaultSettingsDeviceRepository$fetchDevices$1 defaultSettingsDeviceRepository$fetchDevices$1;
        int i;
        if (continuation instanceof DefaultSettingsDeviceRepository$fetchDevices$1) {
            defaultSettingsDeviceRepository$fetchDevices$1 = (DefaultSettingsDeviceRepository$fetchDevices$1) continuation;
            if ((defaultSettingsDeviceRepository$fetchDevices$1.label & Integer.MIN_VALUE) != 0) {
                defaultSettingsDeviceRepository$fetchDevices$1.label -= Integer.MIN_VALUE;
                Object obj = defaultSettingsDeviceRepository$fetchDevices$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = defaultSettingsDeviceRepository$fetchDevices$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CliListRepository cliListRepository = cliRepository;
                    defaultSettingsDeviceRepository$fetchDevices$1.L$0 = function1;
                    defaultSettingsDeviceRepository$fetchDevices$1.label = 1;
                    obj = cliListRepository.refreshDiscoverableDevices(defaultSettingsDeviceRepository$fetchDevices$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function1 = (Function1) defaultSettingsDeviceRepository$fetchDevices$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                function1.invoke(((DeviceDiscoveryRefreshResult) obj).getDevices());
                return Unit.INSTANCE;
            }
        }
        defaultSettingsDeviceRepository$fetchDevices$1 = new DefaultSettingsDeviceRepository$fetchDevices$1(this, continuation);
        Object obj2 = defaultSettingsDeviceRepository$fetchDevices$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = defaultSettingsDeviceRepository$fetchDevices$1.label;
        if (i != 0) {
        }
        function1.invoke(((DeviceDiscoveryRefreshResult) obj2).getDevices());
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.trae.home.solo.setting.SettingsDeviceRepository
    public List<MobileDevice> getCachedDevices() {
        return cliRepository.getCachedDiscoverableDevices();
    }

    @Override // com.bytedance.trae.home.solo.setting.SettingsDeviceRepository
    public Object renameCli(String str, String str2, Continuation<? super Boolean> continuation) {
        return cliRepository.renameCli(str, str2, continuation);
    }

    @Override // com.bytedance.trae.home.solo.setting.SettingsDeviceRepository
    public Object unregisterCli(String str, Continuation<? super Boolean> continuation) {
        return cliRepository.unregisterCli(str, continuation);
    }
}
