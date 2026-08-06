package com.bytedance.ies.argus.api;

import android.webkit.WebView;
import com.bytedance.ies.argus.api.interfaces.service.IArgusWebSecureService;
import com.bytedance.ies.argus.api.params.WebLoadUrlParams;
import com.bytedance.ies.argus.api.params.WebLoadUrlRewritePayload;
import com.bytedance.ies.argus.aspect.ArgusWebDefaultDelegateKt;
import com.bytedance.ies.argus.aspect.eventCenter.BaseEventCenter;
import com.bytedance.ies.argus.base.ArgusServiceManager;
import com.bytedance.ies.argus.bean.AspectContext;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: ArgusWebDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.ies.argus.api.ArgusWebDelegate$innerVerifyLoadUrl$finalResult$1$1$deferredTask$1", f = "ArgusWebDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.bytedance.ies.argus.api.ArgusWebDelegate$innerVerifyLoadUrl$finalResult$1$1$deferredTask$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
final class C1158x6729853 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AspectContext<WebLoadUrlParams, WebLoadUrlRewritePayload> $context;
    final /* synthetic */ Ref.ObjectRef<String> $lastCheckSeclinkScene;
    final /* synthetic */ WebLoadUrlParams $params;
    final /* synthetic */ BaseEventCenter.VerifyHandler<WebLoadUrlParams, WebLoadUrlRewritePayload> $this_apply;
    final /* synthetic */ WebView $webView;
    int label;
    final /* synthetic */ ArgusWebDelegate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1158x6729853(BaseEventCenter.VerifyHandler<WebLoadUrlParams, WebLoadUrlRewritePayload> verifyHandler, WebView webView, WebLoadUrlParams webLoadUrlParams, ArgusWebDelegate argusWebDelegate, Ref.ObjectRef<String> objectRef, AspectContext<WebLoadUrlParams, WebLoadUrlRewritePayload> aspectContext, Continuation<? super C1158x6729853> continuation) {
        super(2, continuation);
        this.$this_apply = verifyHandler;
        this.$webView = webView;
        this.$params = webLoadUrlParams;
        this.this$0 = argusWebDelegate;
        this.$lastCheckSeclinkScene = objectRef;
        this.$context = aspectContext;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C1158x6729853(this.$this_apply, this.$webView, this.$params, this.this$0, this.$lastCheckSeclinkScene, this.$context, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r8v9, types: [com.bytedance.ies.argus.aspect.eventCenter.WebViewContext] */
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        BaseEventCenter.VerifyHandler<WebLoadUrlParams, WebLoadUrlRewritePayload> verifyHandler = this.$this_apply;
        WebView webView = this.$webView;
        WebLoadUrlParams webLoadUrlParams = this.$params;
        ArgusWebDelegate argusWebDelegate = this.this$0;
        Ref.ObjectRef<String> objectRef = this.$lastCheckSeclinkScene;
        AspectContext<WebLoadUrlParams, WebLoadUrlRewritePayload> aspectContext = this.$context;
        Iterator<IArgusWebSecureService> it = ArgusServiceManager.INSTANCE.getInstance().getWebServiceList().iterator();
        while (it.hasNext()) {
            IArgusWebSecureService next = it.next();
            String serviceName = next.serviceName();
            verifyHandler.getContext().recordCost(AspectContext.Companion.TraceType.SERVICE_VERIFY, AspectContext.Companion.TraceStage.START, serviceName);
            Intrinsics.checkNotNullExpressionValue(next, "service");
            next.verifyLoadUrl(webView, webLoadUrlParams.getOriginUrl(), verifyHandler.getVerifyResult());
            if (verifyHandler.getVerifyResult().isRewrite() && argusWebDelegate.getViewContext$anniex_release().getReloadUrl() == null) {
                Object obj2 = objectRef.element;
                WebLoadUrlRewritePayload rewritePayload = verifyHandler.getVerifyResult().getRewritePayload();
                if (!Intrinsics.areEqual(obj2, rewritePayload != null ? rewritePayload.getSecLinkScene() : null)) {
                    verifyHandler.getVerifyResult().addExtra("extern_force_rewrite", "1");
                    Function0<String> usePluginVerifyLoadUrl = ArgusWebDefaultDelegateKt.usePluginVerifyLoadUrl(argusWebDelegate, aspectContext);
                    if (usePluginVerifyLoadUrl != null) {
                        ((BaseEventCenter.VerifyHandler) verifyHandler).reportAwaitTask.add(BuildersKt.async$default(((BaseEventCenter.VerifyHandler) verifyHandler).this$0.getReportScope(), (CoroutineContext) null, (CoroutineStart) null, new C1150x70b4bb0f(null, usePluginVerifyLoadUrl, argusWebDelegate), 3, (Object) null));
                    }
                }
            }
            AspectContext.recordVerifyResult$default(verifyHandler.getContext(), serviceName, verifyHandler.getVerifyResult().toString(), null, 4, null);
            verifyHandler.getContext().recordCost(AspectContext.Companion.TraceType.SERVICE_VERIFY, AspectContext.Companion.TraceStage.END, serviceName);
            if (verifyHandler.getVerifyResult().isBlock()) {
                break;
            }
        }
        return Unit.INSTANCE;
    }
}
