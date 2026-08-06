package com.bytedance.ies.argus.api;

import android.webkit.WebView;
import com.bytedance.ies.argus.api.interfaces.service.IArgusWebSecureService;
import com.bytedance.ies.argus.api.params.WebLoadUrlParams;
import com.bytedance.ies.argus.api.params.WebLoadUrlRewritePayload;
import com.bytedance.ies.argus.aspect.ArgusWebDefaultDelegateKt;
import com.bytedance.ies.argus.aspect.eventCenter.BaseEventCenter;
import com.bytedance.ies.argus.base.ArgusReportPlatform;
import com.bytedance.ies.argus.base.ArgusServiceManager;
import com.bytedance.ies.argus.bean.ArgusWebViewAspect;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.IArgusAspect;
import com.bytedance.ies.argus.util.CommonUtils;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

/* compiled from: BaseEventCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/bytedance/ies/argus/aspect/eventCenter/BaseEventCenter$triggerAsyncEvent$job$1", "com/bytedance/ies/argus/aspect/eventCenter/BaseEventCenter$VerifyHandler$asyncVerify$$inlined$triggerAsyncEvent$1"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.ies.argus.api.ArgusWebDelegate$verifyShouldOverrideUrlLoading$$inlined$verify$default$1", f = "ArgusWebDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.bytedance.ies.argus.api.ArgusWebDelegate$verifyShouldOverrideUrlLoading$$inlined$verify$default$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class C1155x43acd420 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IArgusAspect $aspect;
    final /* synthetic */ ArgusWebViewAspect $callingAspect$inlined;
    final /* synthetic */ WebLoadUrlParams $params$inlined;
    final /* synthetic */ boolean $saveEvent;
    final /* synthetic */ WebView $webView$inlined;
    int label;
    final /* synthetic */ ArgusWebDelegate this$0;
    final /* synthetic */ BaseEventCenter this$0$inline_fun;
    final /* synthetic */ BaseEventCenter.VerifyHandler this$0$inline_fun$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1155x43acd420(boolean z, BaseEventCenter baseEventCenter, IArgusAspect iArgusAspect, Continuation continuation, BaseEventCenter.VerifyHandler verifyHandler, ArgusWebDelegate argusWebDelegate, WebLoadUrlParams webLoadUrlParams, WebView webView, ArgusWebViewAspect argusWebViewAspect) {
        super(2, continuation);
        this.$saveEvent = z;
        this.$aspect = iArgusAspect;
        this.this$0$inline_fun$1 = verifyHandler;
        this.this$0 = argusWebDelegate;
        this.$params$inlined = webLoadUrlParams;
        this.$webView$inlined = webView;
        this.$callingAspect$inlined = argusWebViewAspect;
        this.this$0$inline_fun = baseEventCenter;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C1155x43acd420(this.$saveEvent, this.this$0$inline_fun, this.$aspect, continuation, this.this$0$inline_fun$1, this.this$0, this.$params$inlined, this.$webView$inlined, this.$callingAspect$inlined);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Function0<String> usePluginVerifyLoadUrl;
        ConcurrentHashMap concurrentHashMap;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0$inline_fun$1.getContext().recordCost(AspectContext.Companion.TraceType.INNER_ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, "");
        BaseEventCenter.VerifyHandler verifyHandler = this.this$0$inline_fun$1;
        AspectContext<?, ?> context = verifyHandler.getContext();
        this.this$0$inline_fun$1.getVerifyResult();
        if (this.this$0.isHighRiskScene()) {
            Iterator<IArgusWebSecureService> it = ArgusServiceManager.INSTANCE.getInstance().getWebServiceList().iterator();
            while (it.hasNext()) {
                IArgusWebSecureService next = it.next();
                String serviceName = next.serviceName();
                verifyHandler.getContext().recordCost(AspectContext.Companion.TraceType.SERVICE_VERIFY, AspectContext.Companion.TraceStage.START, serviceName);
                Intrinsics.checkNotNullExpressionValue(next, "service");
                next.verifyShouldOverrideUrlLoading(this.$webView$inlined, this.$params$inlined.getOriginUrl(), verifyHandler.getVerifyResult());
                AspectContext.recordVerifyResult$default(verifyHandler.getContext(), serviceName, verifyHandler.getVerifyResult().toString(), null, 4, null);
                verifyHandler.getContext().recordCost(AspectContext.Companion.TraceType.SERVICE_VERIFY, AspectContext.Companion.TraceStage.END, serviceName);
                if (verifyHandler.getVerifyResult().isBlock()) {
                    break;
                }
            }
            verifyHandler.getContext().recordCost(AspectContext.Companion.TraceType.INNER_ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, "");
            this.this$0.calculate$anniex_release(context);
            verifyHandler.getContext().recordCost(AspectContext.Companion.TraceType.INNER_ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, "");
        } else {
            Deferred<?> async$default = BuildersKt.async$default(this.this$0.getEventCenter$anniex_release().getAspectAsyncScope(), (CoroutineContext) null, (CoroutineStart) null, new C1159xd4289448(verifyHandler, this.$webView$inlined, this.$params$inlined, null), 3, (Object) null);
            verifyHandler.getContext().recordCost(AspectContext.Companion.TraceType.INNER_ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, "");
            this.this$0.calculate$anniex_release(context);
            verifyHandler.getContext().recordCost(AspectContext.Companion.TraceType.INNER_ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, "");
            if (verifyHandler.getVerifyResult().getHasSetRealResult()) {
                verifyHandler.setAsyncReportAwaitTask(async$default);
                context.getVerifyResult().addExtra("service_async", "1");
            } else {
                CommonUtils.INSTANCE.safelyAwait(async$default);
            }
        }
        if (verifyHandler.getVerifyResult().isBlock()) {
            WebLoadUrlRewritePayload webLoadUrlRewritePayload = (WebLoadUrlRewritePayload) verifyHandler.getVerifyResult().getRewritePayload();
            String url = webLoadUrlRewritePayload != null ? webLoadUrlRewritePayload.getUrl() : null;
            boolean z = false;
            if (url != null) {
                if (url.length() > 0) {
                    z = true;
                }
            }
            if (z) {
                ArgusWebDefaultDelegateKt.reloadMiddlePageInMain$default(this.this$0, url, null, 2, null);
            } else {
                ArgusWebDefaultDelegateKt.showBlockToast(this.this$0, "命中安全拦截", "检测到跳转存在安全风险，已被拦截: " + this.$params$inlined.getOriginUrl());
            }
        } else if (this.$params$inlined.getIsHttp() && (usePluginVerifyLoadUrl = ArgusWebDefaultDelegateKt.usePluginVerifyLoadUrl(this.this$0, context)) != null) {
            verifyHandler.reportAwaitTask.add(BuildersKt.async$default(verifyHandler.this$0.getReportScope(), (CoroutineContext) null, (CoroutineStart) null, new C1157xebdbfa10(null, usePluginVerifyLoadUrl, this.this$0), 3, (Object) null));
        }
        CopyOnWriteArrayList<IArgusWebSecureService> webServiceList = ArgusServiceManager.INSTANCE.getInstance().getWebServiceList();
        if (!webServiceList.isEmpty()) {
            verifyHandler.reportAwaitTask.add(BuildersKt.async$default(verifyHandler.this$0.getReportScope(), (CoroutineContext) null, (CoroutineStart) null, new C1156xbcf7c2e8(null, webServiceList, this.this$0, this.$callingAspect$inlined, verifyHandler), 3, (Object) null));
        }
        if (this.$params$inlined.getReservedProtocol()) {
            context.getReportParams().setReportPlatform(ArgusReportPlatform.NONE);
        }
        verifyHandler.getVerifyResult().addExtra("view_class", this.this$0.getViewContext$anniex_release().getViewClassName());
        this.this$0$inline_fun$1.getContext().recordCost(AspectContext.Companion.TraceType.INNER_ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, "");
        if (this.$saveEvent) {
            concurrentHashMap = this.this$0$inline_fun.finishEvent;
            concurrentHashMap.put(this.$aspect, Boxing.boxBoolean(true));
            this.this$0$inline_fun.awaitEventJobs.remove(this.$aspect);
        }
        return Unit.INSTANCE;
    }
}
