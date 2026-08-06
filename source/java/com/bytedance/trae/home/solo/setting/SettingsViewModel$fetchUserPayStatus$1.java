package com.bytedance.trae.home.solo.setting;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.TocCreditsPolicy;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.SettingsViewModel$fetchUserPayStatus$1", f = "SettingsViewModel.kt", i = {}, l = {88, 91, 94}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsViewModel$fetchUserPayStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SettingsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsViewModel$fetchUserPayStatus$1(SettingsViewModel settingsViewModel, Continuation<? super SettingsViewModel$fetchUserPayStatus$1> continuation) {
        super(2, continuation);
        this.this$0 = settingsViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsViewModel$fetchUserPayStatus$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0092 A[Catch: Exception -> 0x0027, TryCatch #0 {Exception -> 0x0027, blocks: (B:7:0x0012, B:8:0x008e, B:10:0x0092, B:12:0x0097, B:15:0x009a, B:20:0x001f, B:21:0x006f, B:23:0x0073, B:25:0x0076, B:26:0x0023, B:27:0x0043, B:29:0x0047, B:31:0x004c, B:33:0x004f, B:35:0x002d, B:37:0x0035, B:40:0x0059, B:42:0x0061, B:45:0x0080), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0097 A[Catch: Exception -> 0x0027, TryCatch #0 {Exception -> 0x0027, blocks: (B:7:0x0012, B:8:0x008e, B:10:0x0092, B:12:0x0097, B:15:0x009a, B:20:0x001f, B:21:0x006f, B:23:0x0073, B:25:0x0076, B:26:0x0023, B:27:0x0043, B:29:0x0047, B:31:0x004c, B:33:0x004f, B:35:0x002d, B:37:0x0035, B:40:0x0059, B:42:0x0061, B:45:0x0080), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009a A[Catch: Exception -> 0x0027, TRY_LEAVE, TryCatch #0 {Exception -> 0x0027, blocks: (B:7:0x0012, B:8:0x008e, B:10:0x0092, B:12:0x0097, B:15:0x009a, B:20:0x001f, B:21:0x006f, B:23:0x0073, B:25:0x0076, B:26:0x0023, B:27:0x0043, B:29:0x0047, B:31:0x004c, B:33:0x004f, B:35:0x002d, B:37:0x0035, B:40:0x0059, B:42:0x0061, B:45:0x0080), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0073 A[Catch: Exception -> 0x0027, TryCatch #0 {Exception -> 0x0027, blocks: (B:7:0x0012, B:8:0x008e, B:10:0x0092, B:12:0x0097, B:15:0x009a, B:20:0x001f, B:21:0x006f, B:23:0x0073, B:25:0x0076, B:26:0x0023, B:27:0x0043, B:29:0x0047, B:31:0x004c, B:33:0x004f, B:35:0x002d, B:37:0x0035, B:40:0x0059, B:42:0x0061, B:45:0x0080), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0076 A[Catch: Exception -> 0x0027, TryCatch #0 {Exception -> 0x0027, blocks: (B:7:0x0012, B:8:0x008e, B:10:0x0092, B:12:0x0097, B:15:0x009a, B:20:0x001f, B:21:0x006f, B:23:0x0073, B:25:0x0076, B:26:0x0023, B:27:0x0043, B:29:0x0047, B:31:0x004c, B:33:0x004f, B:35:0x002d, B:37:0x0035, B:40:0x0059, B:42:0x0061, B:45:0x0080), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0047 A[Catch: Exception -> 0x0027, TryCatch #0 {Exception -> 0x0027, blocks: (B:7:0x0012, B:8:0x008e, B:10:0x0092, B:12:0x0097, B:15:0x009a, B:20:0x001f, B:21:0x006f, B:23:0x0073, B:25:0x0076, B:26:0x0023, B:27:0x0043, B:29:0x0047, B:31:0x004c, B:33:0x004f, B:35:0x002d, B:37:0x0035, B:40:0x0059, B:42:0x0061, B:45:0x0080), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004c A[Catch: Exception -> 0x0027, TryCatch #0 {Exception -> 0x0027, blocks: (B:7:0x0012, B:8:0x008e, B:10:0x0092, B:12:0x0097, B:15:0x009a, B:20:0x001f, B:21:0x006f, B:23:0x0073, B:25:0x0076, B:26:0x0023, B:27:0x0043, B:29:0x0047, B:31:0x004c, B:33:0x004f, B:35:0x002d, B:37:0x0035, B:40:0x0059, B:42:0x0061, B:45:0x0080), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x004f A[Catch: Exception -> 0x0027, TryCatch #0 {Exception -> 0x0027, blocks: (B:7:0x0012, B:8:0x008e, B:10:0x0092, B:12:0x0097, B:15:0x009a, B:20:0x001f, B:21:0x006f, B:23:0x0073, B:25:0x0076, B:26:0x0023, B:27:0x0043, B:29:0x0047, B:31:0x004c, B:33:0x004f, B:35:0x002d, B:37:0x0035, B:40:0x0059, B:42:0x0061, B:45:0x0080), top: B:2:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        MutableLiveData mutableLiveData;
        CNUserPayStatusData cNUserPayStatusData;
        MutableLiveData mutableLiveData2;
        MutableLiveData mutableLiveData3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Exception e) {
            FLogger.INSTANCE.e("SettingsViewModel", "fetchUserPayStatus failed: " + e.getMessage());
        }
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                obj2 = obj instanceof UserPayStatusData ? (UserPayStatusData) obj : null;
                if (obj2 != null) {
                    return Unit.INSTANCE;
                }
                mutableLiveData = this.this$0._userPayStatus;
                mutableLiveData.postValue(obj2);
                return Unit.INSTANCE;
            }
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                cNUserPayStatusData = (CNUserPayStatusData) obj;
                if (cNUserPayStatusData != null) {
                    return Unit.INSTANCE;
                }
                mutableLiveData2 = this.this$0._userCNPayStatus;
                mutableLiveData2.postValue(cNUserPayStatusData);
                return Unit.INSTANCE;
            }
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            obj2 = obj instanceof CNUserPayStatusData ? (CNUserPayStatusData) obj : null;
            if (obj2 != null) {
                return Unit.INSTANCE;
            }
            mutableLiveData3 = this.this$0._userCNPayStatus;
            mutableLiveData3.postValue(obj2);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        if (AppHost.INSTANCE.isOversea()) {
            this.label = 1;
            obj = UserPayIdentityCache.INSTANCE.fetchAndCache((Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (obj instanceof UserPayStatusData) {
            }
            if (obj2 != null) {
            }
        } else if (TocCreditsPolicy.INSTANCE.isEnabled()) {
            this.label = 2;
            obj = UserPayIdentityCache.INSTANCE.fetchFreshCNPayStatus((Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            cNUserPayStatusData = (CNUserPayStatusData) obj;
            if (cNUserPayStatusData != null) {
            }
        } else {
            this.label = 3;
            obj = UserPayIdentityCache.INSTANCE.fetchAndCache((Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (obj instanceof CNUserPayStatusData) {
            }
            if (obj2 != null) {
            }
        }
    }
}
