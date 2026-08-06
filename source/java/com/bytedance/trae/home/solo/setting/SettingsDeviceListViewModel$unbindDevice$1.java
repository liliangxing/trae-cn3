package com.bytedance.trae.home.solo.setting;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsDeviceListViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel$unbindDevice$1", f = "SettingsDeviceListViewModel.kt", i = {}, l = {131, 132}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsDeviceListViewModel$unbindDevice$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cliId;
    final /* synthetic */ long $requestId;
    int label;
    final /* synthetic */ SettingsDeviceListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsDeviceListViewModel$unbindDevice$1(SettingsDeviceListViewModel settingsDeviceListViewModel, String str, long j, Continuation<? super SettingsDeviceListViewModel$unbindDevice$1> continuation) {
        super(2, continuation);
        this.this$0 = settingsDeviceListViewModel;
        this.$cliId = str;
        this.$requestId = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsDeviceListViewModel$unbindDevice$1(this.this$0, this.$cliId, this.$requestId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        SettingsDeviceRepository settingsDeviceRepository;
        Map map;
        Map map2;
        Set set;
        MutableLiveData mutableLiveData;
        Object refreshDevicesAfterMutation;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            settingsDeviceRepository = this.this$0.repository;
            this.label = 1;
            obj = settingsDeviceRepository.unregisterCli(this.$cliId, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            this.label = 2;
            refreshDevicesAfterMutation = this.this$0.refreshDevicesAfterMutation((Continuation) this);
            if (refreshDevicesAfterMutation == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        map = this.this$0.pendingUnbinds;
        SettingsDeviceListViewModel.PendingUnbind pendingUnbind = (SettingsDeviceListViewModel.PendingUnbind) map.get(this.$cliId);
        boolean z = false;
        if (pendingUnbind != null && pendingUnbind.getRequestId() == this.$requestId) {
            z = true;
        }
        if (z) {
            map2 = this.this$0.pendingUnbinds;
            map2.remove(this.$cliId);
            this.this$0.restorePairing(this.$cliId, pendingUnbind);
            SettingsDeviceListViewModel settingsDeviceListViewModel = this.this$0;
            set = settingsDeviceListViewModel.previousPairedDeviceIds;
            settingsDeviceListViewModel.previousPairedDeviceIds = SetsKt.plus(set, this.$cliId);
            mutableLiveData = this.this$0._unbindFailed;
            mutableLiveData.postValue(Boxing.boxBoolean(true));
        }
        return Unit.INSTANCE;
    }
}
