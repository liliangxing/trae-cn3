package com.bytedance.trae.push.impl;

import android.content.Context;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.push.BDPush;
import com.bytedance.push.interfaze.IPushService;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushEventManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.push.impl.PushEventManager$reportAppLaunchStatus$1", f = "PushEventManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PushEventManager$reportAppLaunchStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushEventManager$reportAppLaunchStatus$1(Context context, Continuation<? super PushEventManager$reportAppLaunchStatus$1> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PushEventManager$reportAppLaunchStatus$1(this.$context, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        IPushService pushService = BDPush.getPushService();
        boolean z = false;
        if (pushService != null && pushService.isPushInit()) {
            z = true;
        }
        if (z && PushServiceManager.get().getIRedBadgeExternalService().isSupportGetCurRedBadgeNumber()) {
            Context context = this.$context;
            try {
                Result.Companion companion = Result.Companion;
                obj2 = Result.constructor-impl(Boxing.boxInt(PushServiceManager.get().getIRedBadgeExternalService().getCurRedBadgeNumber(context)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable th2 = Result.exceptionOrNull-impl(obj2);
            if (th2 != null) {
                FLogger.INSTANCE.mo426e("PushEventManager", "getCurRedBadgeNumber error = " + th2.getLocalizedMessage());
                obj2 = Boxing.boxInt(-3);
            }
            int intValue = ((Number) obj2).intValue();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("red_botshow_cnt", intValue);
            IApplog.Companion.reportEvent("app_launch_status", jSONObject);
            PushEventManager.INSTANCE.reportPushMonitorEvent("launch_status", jSONObject);
        }
        return Unit.INSTANCE;
    }
}
