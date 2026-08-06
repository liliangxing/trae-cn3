package com.bytedance.trae.login.service;

import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.trae.login.api.LoginDeviceInfo;
import com.bytedance.trae.login.api.LoginDeviceListResult;
import com.bytedance.trae.login.traeauth.DeviceSummary;
import com.bytedance.trae.login.traeauth.ListDevicesResult;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: LoginServiceImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.service.LoginServiceImpl$listLoginDevices$1", f = "LoginServiceImpl.kt", i = {}, l = {377, 395, PatchException.ERR_INSTALL_PARSE_IO}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class LoginServiceImpl$listLoginDevices$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $onFail;
    final /* synthetic */ Function1<LoginDeviceListResult, Unit> $onSuccess;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LoginServiceImpl$listLoginDevices$1(Function1<? super LoginDeviceListResult, Unit> function1, Function1<? super String, Unit> function12, Continuation<? super LoginServiceImpl$listLoginDevices$1> continuation) {
        super(2, continuation);
        this.$onSuccess = function1;
        this.$onFail = function12;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginServiceImpl$listLoginDevices$1(this.$onSuccess, this.$onFail, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object listDevices;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Exception e) {
            FLogger.INSTANCE.mo426e("LoginServiceImpl", "listLoginDevices failed: " + e.getMessage());
            this.label = 3;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C08712(this.$onFail, e, null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            listDevices = TraeAuthManager.INSTANCE.listDevices((Continuation) this);
            if (listDevices == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            listDevices = obj;
        }
        ListDevicesResult listDevicesResult = (ListDevicesResult) listDevices;
        List<DeviceSummary> devices = listDevicesResult.getDevices();
        if (devices == null) {
            devices = CollectionsKt.emptyList();
        }
        List<DeviceSummary> list = devices;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (DeviceSummary deviceSummary : list) {
            String deviceId = deviceSummary.getDeviceId();
            String deviceName = deviceSummary.getDeviceName();
            String deviceType = deviceSummary.getDeviceType();
            String platformCode = deviceSummary.getPlatformCode();
            String clientVersion = deviceSummary.getClientVersion();
            String deviceModel = deviceSummary.getDeviceModel();
            String osVersion = deviceSummary.getOsVersion();
            String lastLoginIp = deviceSummary.getLastLoginIp();
            String status = deviceSummary.getStatus();
            Long firstBoundAt = deviceSummary.getFirstBoundAt();
            Long lastActiveAt = deviceSummary.getLastActiveAt();
            boolean areEqual = Intrinsics.areEqual(deviceSummary.getCurrentDevice(), Boxing.boxBoolean(true));
            List<String> boundProducts = deviceSummary.getBoundProducts();
            if (boundProducts == null) {
                boundProducts = CollectionsKt.emptyList();
            }
            arrayList.add(new LoginDeviceInfo(deviceId, deviceName, deviceType, platformCode, clientVersion, deviceModel, osVersion, lastLoginIp, status, firstBoundAt, lastActiveAt, areEqual, boundProducts));
        }
        CoroutineContext main = Dispatchers.getMain();
        Function1<LoginDeviceListResult, Unit> function1 = this.$onSuccess;
        this.label = 2;
        if (BuildersKt.withContext(main, new C08701(function1, arrayList, listDevicesResult, null), (Continuation) this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginServiceImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.login.service.LoginServiceImpl$listLoginDevices$1$1", f = "LoginServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.login.service.LoginServiceImpl$listLoginDevices$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class C08701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<LoginDeviceInfo> $devices;
        final /* synthetic */ Function1<LoginDeviceListResult, Unit> $onSuccess;
        final /* synthetic */ ListDevicesResult $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C08701(Function1<? super LoginDeviceListResult, Unit> function1, List<LoginDeviceInfo> list, ListDevicesResult listDevicesResult, Continuation<? super C08701> continuation) {
            super(2, continuation);
            this.$onSuccess = function1;
            this.$devices = list;
            this.$result = listDevicesResult;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08701(this.$onSuccess, this.$devices, this.$result, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$onSuccess.invoke(new LoginDeviceListResult(this.$devices, this.$result.getMaxDeviceCount()));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginServiceImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.login.service.LoginServiceImpl$listLoginDevices$1$2", f = "LoginServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.login.service.LoginServiceImpl$listLoginDevices$1$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class C08712 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: $e */
        final /* synthetic */ Exception f130$e;
        final /* synthetic */ Function1<String, Unit> $onFail;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C08712(Function1<? super String, Unit> function1, Exception exc, Continuation<? super C08712> continuation) {
            super(2, continuation);
            this.$onFail = function1;
            this.f130$e = exc;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08712(this.$onFail, this.f130$e, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$onFail.invoke(this.f130$e.getMessage());
            return Unit.INSTANCE;
        }
    }
}
