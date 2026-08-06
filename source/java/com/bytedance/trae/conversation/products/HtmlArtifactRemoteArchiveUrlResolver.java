package com.bytedance.trae.conversation.products;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.sdk.xbridge.cn.runtime.utils.XBridgeAPIRequestUtils;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.im.service.ChatSessionResponse;
import com.bytedance.trae.im.service.ChatSessionSandbox;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.TimeoutKt;

/* compiled from: HtmlArtifactRemoteArchiveUrlResolver.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000 42\u00020\u0001:\u00014B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ*\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0013\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010\u001aJ\f\u0010 \u001a\u00020\u0019*\u00020\u001cH\u0002J\f\u0010!\u001a\u00020\u0019*\u00020\u001cH\u0002J\"\u0010\"\u001a\u0004\u0018\u00010\n2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0002J\u001a\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\nJ\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\nH\u0002J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\nH\u0002J\u000e\u0010*\u001a\u00020\n*\u0004\u0018\u00010+H\u0002J\u001a\u0010,\u001a\u0004\u0018\u00010\n\"\u0004\b\u0000\u0010-*\b\u0012\u0004\u0012\u0002H-0.H\u0002J\u0017\u0010/\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u000101H\u0002¢\u0006\u0002\u00102J\u0010\u00103\u001a\u00020\n2\u0006\u00100\u001a\u000201H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u00065"}, d2 = {"Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;", "", "sessionClient", "Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSessionClient;", "sandboxStatusSource", "Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSandboxStatusSource;", "sandboxReadyTimeoutMs", "", "xttTokenProvider", "Lkotlin/Function0;", "", "<init>", "(Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSessionClient;Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSandboxStatusSource;JLkotlin/jvm/functions/Function0;)V", "workSpace", "getWorkSpace", "()Ljava/lang/String;", "setWorkSpace", "(Ljava/lang/String;)V", "resolve", "chatSessionId", "requestPath", "mode", "Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wakeupSandboxAndWaitForReady", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSessionOrNull", "Lcom/bytedance/trae/im/service/ChatSessionResponse;", "wakeupSandbox", "", "waitForSandboxReady", "isSandboxReady", "hasSandboxInfo", "buildArchiveUrl", "session", "normalizeFilePath", "filePath", "workspacePath", "logD", "message", "logE", "describeForLog", "Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;", "logIdForLog", "T", "Lcom/bytedance/trae/network/response/BizResponse;", "statusForLog", PageDataManager.EXTRA_STATUS, "", "(Ljava/lang/Integer;)Ljava/lang/String;", "statusName", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class HtmlArtifactRemoteArchiveUrlResolver {
    private static final Companion Companion = new Companion(null);
    private static final long DEFAULT_SANDBOX_READY_TIMEOUT_MS = 60000;
    private static final String TAG = "HtmlArtifactRemoteArchiveUrlResolver";
    private final long sandboxReadyTimeoutMs;
    private final HtmlArtifactRemoteSandboxStatusSource sandboxStatusSource;
    private final HtmlArtifactRemoteSessionClient sessionClient;
    private String workSpace;
    private final Function0<String> xttTokenProvider;

    public HtmlArtifactRemoteArchiveUrlResolver() {
        this(null, null, 0L, null, 15, null);
    }

    public HtmlArtifactRemoteArchiveUrlResolver(HtmlArtifactRemoteSessionClient htmlArtifactRemoteSessionClient, HtmlArtifactRemoteSandboxStatusSource htmlArtifactRemoteSandboxStatusSource, long j, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(htmlArtifactRemoteSessionClient, "sessionClient");
        Intrinsics.checkNotNullParameter(htmlArtifactRemoteSandboxStatusSource, "sandboxStatusSource");
        Intrinsics.checkNotNullParameter(function0, "xttTokenProvider");
        this.sessionClient = htmlArtifactRemoteSessionClient;
        this.sandboxStatusSource = htmlArtifactRemoteSandboxStatusSource;
        this.sandboxReadyTimeoutMs = j;
        this.xttTokenProvider = function0;
        this.workSpace = "";
    }

    public /* synthetic */ HtmlArtifactRemoteArchiveUrlResolver(DefaultHtmlArtifactRemoteSessionClient defaultHtmlArtifactRemoteSessionClient, DefaultHtmlArtifactRemoteSandboxStatusSource defaultHtmlArtifactRemoteSandboxStatusSource, long j, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DefaultHtmlArtifactRemoteSessionClient.INSTANCE : defaultHtmlArtifactRemoteSessionClient, (i & 2) != 0 ? DefaultHtmlArtifactRemoteSandboxStatusSource.INSTANCE : defaultHtmlArtifactRemoteSandboxStatusSource, (i & 4) != 0 ? 60000L : j, (i & 8) != 0 ? new Function0() { // from class: com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver$$ExternalSyntheticLambda0
            public final Object invoke() {
                String _init_$lambda$0;
                _init_$lambda$0 = HtmlArtifactRemoteArchiveUrlResolver._init_$lambda$0();
                return _init_$lambda$0;
            }
        } : function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$0() {
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        String xTToken = iLoginService != null ? iLoginService.getXTToken() : null;
        return xTToken == null ? "" : xTToken;
    }

    public final String getWorkSpace() {
        return this.workSpace;
    }

    public final void setWorkSpace(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.workSpace = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0122 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0076 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolve(String str, String str2, HtmlArtifactRemoteArchiveResolveMode htmlArtifactRemoteArchiveResolveMode, Continuation<? super String> continuation) {
        HtmlArtifactRemoteArchiveUrlResolver$resolve$1 htmlArtifactRemoteArchiveUrlResolver$resolve$1;
        int i;
        HtmlArtifactRemoteArchiveUrlResolver htmlArtifactRemoteArchiveUrlResolver;
        ChatSessionResponse chatSessionResponse;
        HtmlArtifactRemoteArchiveUrlResolver htmlArtifactRemoteArchiveUrlResolver2;
        String str3;
        ChatSessionResponse chatSessionResponse2;
        if (continuation instanceof HtmlArtifactRemoteArchiveUrlResolver$resolve$1) {
            htmlArtifactRemoteArchiveUrlResolver$resolve$1 = (HtmlArtifactRemoteArchiveUrlResolver$resolve$1) continuation;
            if ((htmlArtifactRemoteArchiveUrlResolver$resolve$1.label & Integer.MIN_VALUE) != 0) {
                htmlArtifactRemoteArchiveUrlResolver$resolve$1.label -= Integer.MIN_VALUE;
                Object obj = htmlArtifactRemoteArchiveUrlResolver$resolve$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = htmlArtifactRemoteArchiveUrlResolver$resolve$1.label;
                boolean z = true;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    htmlArtifactRemoteArchiveUrlResolver$resolve$1.L$0 = this;
                    htmlArtifactRemoteArchiveUrlResolver$resolve$1.L$1 = str;
                    htmlArtifactRemoteArchiveUrlResolver$resolve$1.L$2 = str2;
                    htmlArtifactRemoteArchiveUrlResolver$resolve$1.L$3 = htmlArtifactRemoteArchiveResolveMode;
                    htmlArtifactRemoteArchiveUrlResolver$resolve$1.label = 1;
                    obj = getSessionOrNull(str, htmlArtifactRemoteArchiveUrlResolver$resolve$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    htmlArtifactRemoteArchiveUrlResolver = this;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        chatSessionResponse2 = (ChatSessionResponse) htmlArtifactRemoteArchiveUrlResolver$resolve$1.L$3;
                        str2 = (String) htmlArtifactRemoteArchiveUrlResolver$resolve$1.L$2;
                        str3 = (String) htmlArtifactRemoteArchiveUrlResolver$resolve$1.L$1;
                        htmlArtifactRemoteArchiveUrlResolver2 = (HtmlArtifactRemoteArchiveUrlResolver) htmlArtifactRemoteArchiveUrlResolver$resolve$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        if (((Boolean) obj).booleanValue()) {
                            return null;
                        }
                        return htmlArtifactRemoteArchiveUrlResolver2.buildArchiveUrl(chatSessionResponse2, str2, str3);
                    }
                    htmlArtifactRemoteArchiveResolveMode = (HtmlArtifactRemoteArchiveResolveMode) htmlArtifactRemoteArchiveUrlResolver$resolve$1.L$3;
                    str2 = (String) htmlArtifactRemoteArchiveUrlResolver$resolve$1.L$2;
                    str = (String) htmlArtifactRemoteArchiveUrlResolver$resolve$1.L$1;
                    htmlArtifactRemoteArchiveUrlResolver = (HtmlArtifactRemoteArchiveUrlResolver) htmlArtifactRemoteArchiveUrlResolver$resolve$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                chatSessionResponse = (ChatSessionResponse) obj;
                if (chatSessionResponse != null) {
                    return null;
                }
                if (!htmlArtifactRemoteArchiveUrlResolver.isSandboxReady(chatSessionResponse) && (htmlArtifactRemoteArchiveResolveMode != HtmlArtifactRemoteArchiveResolveMode.DIRECT_ARCHIVE || !htmlArtifactRemoteArchiveUrlResolver.hasSandboxInfo(chatSessionResponse))) {
                    z = false;
                }
                if (z) {
                    StringBuilder append = new StringBuilder("resolve: skip sandbox wakeup, chatSessionId=").append(str).append(", mode=").append(htmlArtifactRemoteArchiveResolveMode).append(", sandboxPresent=").append(htmlArtifactRemoteArchiveUrlResolver.hasSandboxInfo(chatSessionResponse)).append(", allocationStatus=");
                    ChatSessionSandbox sandbox = chatSessionResponse.getSandbox();
                    htmlArtifactRemoteArchiveUrlResolver.logD(append.append(htmlArtifactRemoteArchiveUrlResolver.statusForLog(sandbox != null ? sandbox.getAllocationStatus() : null)).toString());
                    return htmlArtifactRemoteArchiveUrlResolver.buildArchiveUrl(chatSessionResponse, str2, str);
                }
                StringBuilder append2 = new StringBuilder("resolve: sandbox not ready, chatSessionId=").append(str).append(", allocationStatus=");
                ChatSessionSandbox sandbox2 = chatSessionResponse.getSandbox();
                htmlArtifactRemoteArchiveUrlResolver.logD(append2.append(htmlArtifactRemoteArchiveUrlResolver.statusForLog(sandbox2 != null ? sandbox2.getAllocationStatus() : null)).append(", request wakeup").toString());
                htmlArtifactRemoteArchiveUrlResolver$resolve$1.L$0 = htmlArtifactRemoteArchiveUrlResolver;
                htmlArtifactRemoteArchiveUrlResolver$resolve$1.L$1 = str;
                htmlArtifactRemoteArchiveUrlResolver$resolve$1.L$2 = str2;
                htmlArtifactRemoteArchiveUrlResolver$resolve$1.L$3 = chatSessionResponse;
                htmlArtifactRemoteArchiveUrlResolver$resolve$1.label = 2;
                Object wakeupSandboxAndWaitForReady = htmlArtifactRemoteArchiveUrlResolver.wakeupSandboxAndWaitForReady(str, htmlArtifactRemoteArchiveUrlResolver$resolve$1);
                if (wakeupSandboxAndWaitForReady == coroutine_suspended) {
                    return coroutine_suspended;
                }
                htmlArtifactRemoteArchiveUrlResolver2 = htmlArtifactRemoteArchiveUrlResolver;
                str3 = str;
                chatSessionResponse2 = chatSessionResponse;
                obj = wakeupSandboxAndWaitForReady;
                if (((Boolean) obj).booleanValue()) {
                }
            }
        }
        htmlArtifactRemoteArchiveUrlResolver$resolve$1 = new HtmlArtifactRemoteArchiveUrlResolver$resolve$1(this, continuation);
        Object obj2 = htmlArtifactRemoteArchiveUrlResolver$resolve$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = htmlArtifactRemoteArchiveUrlResolver$resolve$1.label;
        boolean z2 = true;
        if (i != 0) {
        }
        chatSessionResponse = (ChatSessionResponse) obj2;
        if (chatSessionResponse != null) {
        }
    }

    public static /* synthetic */ Object resolve$default(HtmlArtifactRemoteArchiveUrlResolver htmlArtifactRemoteArchiveUrlResolver, String str, String str2, HtmlArtifactRemoteArchiveResolveMode htmlArtifactRemoteArchiveResolveMode, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            htmlArtifactRemoteArchiveResolveMode = HtmlArtifactRemoteArchiveResolveMode.ENSURE_SANDBOX_READY;
        }
        return htmlArtifactRemoteArchiveUrlResolver.resolve(str, str2, htmlArtifactRemoteArchiveResolveMode, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object wakeupSandboxAndWaitForReady(String str, Continuation<? super Boolean> continuation) {
        return CoroutineScopeKt.coroutineScope(new C0763x3b809afa(this, str, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getSessionOrNull(String str, Continuation<? super ChatSessionResponse> continuation) {
        HtmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1 htmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1;
        int i;
        HtmlArtifactRemoteArchiveUrlResolver htmlArtifactRemoteArchiveUrlResolver;
        HttpDataResult.Success success;
        Class<?> cls;
        ChatSessionSandbox sandbox;
        ChatSessionSandbox sandbox2;
        if (continuation instanceof HtmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1) {
            htmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1 = (HtmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1) continuation;
            if ((htmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1.label & Integer.MIN_VALUE) != 0) {
                htmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1.label -= Integer.MIN_VALUE;
                Object obj = htmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = htmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    logD("GET /api/remote/v1/chat_sessions/" + str + " request");
                    HtmlArtifactRemoteSessionClient htmlArtifactRemoteSessionClient = this.sessionClient;
                    htmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1.L$0 = this;
                    htmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1.L$1 = str;
                    htmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1.label = 1;
                    obj = htmlArtifactRemoteSessionClient.getChatSession(str, htmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    htmlArtifactRemoteArchiveUrlResolver = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) htmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1.L$1;
                    htmlArtifactRemoteArchiveUrlResolver = (HtmlArtifactRemoteArchiveUrlResolver) htmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                success = (HttpDataResult) obj;
                if (success instanceof HttpDataResult.Success) {
                    if (!(success instanceof HttpDataResult.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    HttpDataResult.Error error = (HttpDataResult.Error) success;
                    StringBuilder append = new StringBuilder("GET /api/remote/v1/chat_sessions/").append(str).append(" failed: code=").append(error.getCode()).append(", msg=").append(error.getMsg()).append(", throwable=");
                    Throwable throwable = error.getThrowable();
                    StringBuilder append2 = append.append((throwable == null || (cls = throwable.getClass()) == null) ? null : cls.getName()).append(": ");
                    Throwable throwable2 = error.getThrowable();
                    htmlArtifactRemoteArchiveUrlResolver.logE(append2.append(throwable2 != null ? throwable2.getMessage() : null).toString());
                    return null;
                }
                BizResponse bizResp = success.getBizResp();
                ChatSessionResponse chatSessionResponse = (ChatSessionResponse) bizResp.getData();
                StringBuilder sb = new StringBuilder("GET /api/remote/v1/chat_sessions/");
                sb.append(str).append(" response: bizCode=").append(bizResp.getCode()).append(", msg=").append(bizResp.getMsg()).append(", message=").append(bizResp.getMessage()).append(", logId=").append(htmlArtifactRemoteArchiveUrlResolver.logIdForLog(bizResp)).append(", responseChatSessionId=").append(chatSessionResponse != null ? chatSessionResponse.getChatSessionId() : null).append(", title=").append(chatSessionResponse != null ? chatSessionResponse.getTitle() : null).append(", status=").append(chatSessionResponse != null ? chatSessionResponse.getStatus() : null).append(", mode=").append(chatSessionResponse != null ? chatSessionResponse.getMode() : null).append(", sandboxPresent=").append((chatSessionResponse != null ? chatSessionResponse.getSandbox() : null) != null).append(", sandboxName=").append((chatSessionResponse == null || (sandbox2 = chatSessionResponse.getSandbox()) == null) ? null : sandbox2.getName()).append(", allocationStatus=");
                StringBuilder append3 = sb.append(htmlArtifactRemoteArchiveUrlResolver.statusForLog((chatSessionResponse == null || (sandbox = chatSessionResponse.getSandbox()) == null) ? null : sandbox.getAllocationStatus())).append(", explorerUrlPresent=");
                String explorerUrl = chatSessionResponse != null ? chatSessionResponse.getExplorerUrl() : null;
                StringBuilder append4 = append3.append(!(explorerUrl == null || explorerUrl.length() == 0)).append(", previewUrlPresent=");
                String previewUrl = chatSessionResponse != null ? chatSessionResponse.getPreviewUrl() : null;
                append4.append(!(previewUrl == null || previewUrl.length() == 0)).append(", workspacePath=").append(chatSessionResponse != null ? chatSessionResponse.getWorkspacePath() : null);
                htmlArtifactRemoteArchiveUrlResolver.logD(sb.toString());
                String workspacePath = chatSessionResponse != null ? chatSessionResponse.getWorkspacePath() : null;
                if (workspacePath == null) {
                    workspacePath = "";
                }
                htmlArtifactRemoteArchiveUrlResolver.workSpace = workspacePath;
                return chatSessionResponse;
            }
        }
        htmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1 = new HtmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1(this, continuation);
        Object obj2 = htmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = htmlArtifactRemoteArchiveUrlResolver$getSessionOrNull$1.label;
        if (i != 0) {
        }
        success = (HttpDataResult) obj2;
        if (success instanceof HttpDataResult.Success) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object wakeupSandbox(String str, Continuation<? super Unit> continuation) {
        HtmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1 htmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1;
        int i;
        HtmlArtifactRemoteArchiveUrlResolver htmlArtifactRemoteArchiveUrlResolver;
        HttpDataResult.Success success;
        Class<?> cls;
        if (continuation instanceof HtmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1) {
            htmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1 = (HtmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1) continuation;
            if ((htmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1.label & Integer.MIN_VALUE) != 0) {
                htmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1.label -= Integer.MIN_VALUE;
                Object obj = htmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = htmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    logD("POST /api/remote/v1/chat_sessions/" + str + "/wakeup_sandbox request");
                    HtmlArtifactRemoteSessionClient htmlArtifactRemoteSessionClient = this.sessionClient;
                    htmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1.L$0 = this;
                    htmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1.L$1 = str;
                    htmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1.label = 1;
                    obj = htmlArtifactRemoteSessionClient.wakeupSandbox(str, htmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    htmlArtifactRemoteArchiveUrlResolver = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) htmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1.L$1;
                    htmlArtifactRemoteArchiveUrlResolver = (HtmlArtifactRemoteArchiveUrlResolver) htmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                success = (HttpDataResult) obj;
                if (!(success instanceof HttpDataResult.Success)) {
                    BizResponse bizResp = success.getBizResp();
                    htmlArtifactRemoteArchiveUrlResolver.logD("POST /api/remote/v1/chat_sessions/" + str + "/wakeup_sandbox response: bizCode=" + bizResp.getCode() + ", msg=" + bizResp.getMsg() + ", message=" + bizResp.getMessage() + ", logId=" + htmlArtifactRemoteArchiveUrlResolver.logIdForLog(bizResp) + ", isSuccess=" + bizResp.isSuccess());
                    if (!bizResp.isSuccess()) {
                        htmlArtifactRemoteArchiveUrlResolver.logE("resolve: wakeup sandbox biz failed, chatSessionId=" + str + ", bizCode=" + bizResp.getCode() + ", msg=" + bizResp.getMsg() + ", message=" + bizResp.getMessage());
                    }
                } else {
                    if (!(success instanceof HttpDataResult.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    HttpDataResult.Error error = (HttpDataResult.Error) success;
                    StringBuilder append = new StringBuilder("POST /api/remote/v1/chat_sessions/").append(str).append("/wakeup_sandbox failed: code=").append(error.getCode()).append(", msg=").append(error.getMsg()).append(", throwable=");
                    Throwable throwable = error.getThrowable();
                    StringBuilder append2 = append.append((throwable == null || (cls = throwable.getClass()) == null) ? null : cls.getName()).append(": ");
                    Throwable throwable2 = error.getThrowable();
                    htmlArtifactRemoteArchiveUrlResolver.logE(append2.append(throwable2 != null ? throwable2.getMessage() : null).toString());
                }
                return Unit.INSTANCE;
            }
        }
        htmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1 = new HtmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1(this, continuation);
        Object obj2 = htmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = htmlArtifactRemoteArchiveUrlResolver$wakeupSandbox$1.label;
        if (i != 0) {
        }
        success = (HttpDataResult) obj2;
        if (!(success instanceof HttpDataResult.Success)) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object waitForSandboxReady(String str, Continuation<? super Boolean> continuation) {
        HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1 htmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1;
        int i;
        Ref.ObjectRef objectRef;
        String str2;
        Object withTimeoutOrNull;
        HtmlArtifactRemoteArchiveUrlResolver htmlArtifactRemoteArchiveUrlResolver;
        Ref.ObjectRef objectRef2;
        RealtimeSandboxStatusUpdate realtimeSandboxStatusUpdate;
        if (continuation instanceof HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1) {
            htmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1 = (HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1) continuation;
            if ((htmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1.label & Integer.MIN_VALUE) != 0) {
                htmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1.label -= Integer.MIN_VALUE;
                HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1 htmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$12 = htmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1;
                Object obj = htmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = htmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                    objectRef = new Ref.ObjectRef();
                    long j = this.sandboxReadyTimeoutMs;
                    C0761xe5c31e97 c0761xe5c31e97 = new C0761xe5c31e97(this, str, objectRef3, objectRef, null);
                    htmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$12.L$0 = this;
                    str2 = str;
                    htmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$12.L$1 = str2;
                    htmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$12.L$2 = objectRef3;
                    htmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$12.L$3 = objectRef;
                    htmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$12.label = 1;
                    withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(j, c0761xe5c31e97, htmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$12);
                    if (withTimeoutOrNull == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    htmlArtifactRemoteArchiveUrlResolver = this;
                    objectRef2 = objectRef3;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Ref.ObjectRef objectRef4 = (Ref.ObjectRef) htmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$12.L$3;
                    objectRef2 = (Ref.ObjectRef) htmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$12.L$2;
                    String str3 = (String) htmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$12.L$1;
                    htmlArtifactRemoteArchiveUrlResolver = (HtmlArtifactRemoteArchiveUrlResolver) htmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    objectRef = objectRef4;
                    withTimeoutOrNull = obj;
                    str2 = str3;
                }
                realtimeSandboxStatusUpdate = (RealtimeSandboxStatusUpdate) withTimeoutOrNull;
                if (realtimeSandboxStatusUpdate == null) {
                    htmlArtifactRemoteArchiveUrlResolver.logD("resolve: sandbox ready received, chatSessionId=" + str2 + ", " + htmlArtifactRemoteArchiveUrlResolver.describeForLog(realtimeSandboxStatusUpdate));
                    return Boxing.boxBoolean(true);
                }
                htmlArtifactRemoteArchiveUrlResolver.logE("resolve: wait sandbox ready timeout, chatSessionId=" + str2 + ", timeoutMs=" + htmlArtifactRemoteArchiveUrlResolver.sandboxReadyTimeoutMs + ", lastMatchingUpdate=" + htmlArtifactRemoteArchiveUrlResolver.describeForLog((RealtimeSandboxStatusUpdate) objectRef.element) + ", lastAnyUpdate=" + htmlArtifactRemoteArchiveUrlResolver.describeForLog((RealtimeSandboxStatusUpdate) objectRef2.element));
                return Boxing.boxBoolean(false);
            }
        }
        htmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1 = new HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1(this, continuation);
        HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1 htmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$122 = htmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$1;
        Object obj2 = htmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = htmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$122.label;
        if (i != 0) {
        }
        realtimeSandboxStatusUpdate = (RealtimeSandboxStatusUpdate) withTimeoutOrNull;
        if (realtimeSandboxStatusUpdate == null) {
        }
    }

    private final boolean isSandboxReady(ChatSessionResponse chatSessionResponse) {
        ChatSessionSandbox sandbox = chatSessionResponse.getSandbox();
        if (sandbox == null) {
            return false;
        }
        Integer allocationStatus = sandbox.getAllocationStatus();
        return allocationStatus != null && allocationStatus.intValue() == RealtimeSandboxStatus.READY.getValue();
    }

    private final boolean hasSandboxInfo(ChatSessionResponse chatSessionResponse) {
        return chatSessionResponse.getSandbox() != null;
    }

    private final String buildArchiveUrl(ChatSessionResponse session, String requestPath, String chatSessionId) {
        String explorerUrl = session.getExplorerUrl();
        String str = explorerUrl;
        if (str == null || str.length() == 0) {
            logE("resolve: explorerUrl is empty, chatSessionId=" + chatSessionId);
            return null;
        }
        HtmlArtifactDownloadTarget fromPreviewPath = HtmlArtifactDownloadTarget.INSTANCE.fromPreviewPath(normalizeFilePath(requestPath, session.getWorkspacePath()));
        logD("resolve: /archive.zip path=" + fromPreviewPath.getRemoteArchivePath() + " filename=" + fromPreviewPath.getArchiveFileName());
        return HtmlArtifactRemoteArchiveUrlBuilder.INSTANCE.build(explorerUrl, fromPreviewPath.getRemoteArchivePath(), fromPreviewPath.getArchiveFileName(), (String) this.xttTokenProvider.invoke());
    }

    public static /* synthetic */ String normalizeFilePath$default(HtmlArtifactRemoteArchiveUrlResolver htmlArtifactRemoteArchiveUrlResolver, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return htmlArtifactRemoteArchiveUrlResolver.normalizeFilePath(str, str2);
    }

    public final String normalizeFilePath(String filePath, String workspacePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        String str = workspacePath;
        if (!(str == null || str.length() == 0)) {
            String str2 = StringsKt.endsWith$default(workspacePath, "/", false, 2, (Object) null) ? workspacePath : workspacePath + '/';
            if (StringsKt.endsWith$default(workspacePath, "/", false, 2, (Object) null)) {
                workspacePath = StringsKt.dropLast(workspacePath, 1);
            }
            for (String str3 : CollectionsKt.listOf(new String[]{str2, workspacePath})) {
                if (StringsKt.startsWith$default(filePath, str3, false, 2, (Object) null)) {
                    String substring = filePath.substring(str3.length());
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    return StringsKt.removePrefix(substring, "/");
                }
            }
        }
        if (!StringsKt.startsWith$default(filePath, "/", false, 2, (Object) null)) {
            return filePath;
        }
        String substring2 = filePath.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        return substring2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logD(String message) {
        try {
            Result.Companion companion = Result.Companion;
            HtmlArtifactRemoteArchiveUrlResolver htmlArtifactRemoteArchiveUrlResolver = this;
            FLogger.INSTANCE.d(TAG, message);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    private final void logE(String message) {
        try {
            Result.Companion companion = Result.Companion;
            HtmlArtifactRemoteArchiveUrlResolver htmlArtifactRemoteArchiveUrlResolver = this;
            FLogger.INSTANCE.e(TAG, message);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String describeForLog(RealtimeSandboxStatusUpdate realtimeSandboxStatusUpdate) {
        return realtimeSandboxStatusUpdate == null ? "null" : "conversationId=" + realtimeSandboxStatusUpdate.getConversationId() + ", cliConversationId=" + realtimeSandboxStatusUpdate.getCliConversationId() + ", sandboxName=" + realtimeSandboxStatusUpdate.getSandboxName() + ", sandboxType=" + realtimeSandboxStatusUpdate.getSandboxType() + ", status=" + statusForLog(realtimeSandboxStatusUpdate.getStatus());
    }

    private final <T> String logIdForLog(BizResponse<T> bizResponse) {
        List headers;
        T t;
        SsResponse sSResponse = bizResponse.getSSResponse();
        if (sSResponse == null || (headers = sSResponse.headers()) == null) {
            return null;
        }
        Iterator<T> it = headers.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (StringsKt.equals(((Header) t).getName(), XBridgeAPIRequestUtils.X_TT_LOG_ID, true)) {
                break;
            }
        }
        Header header = (Header) t;
        if (header != null) {
            return header.getValue();
        }
        return null;
    }

    private final String statusForLog(Integer status) {
        return status == null ? "null" : status + '(' + statusName(status.intValue()) + ')';
    }

    private final String statusName(int status) {
        return status == RealtimeSandboxStatus.UNKNOWN.getValue() ? "Unknown" : status == RealtimeSandboxStatus.SUBMITTED.getValue() ? "Submitted" : status == RealtimeSandboxStatus.INITIALIZING.getValue() ? "Initializing" : status == RealtimeSandboxStatus.READY.getValue() ? "Ready" : status == RealtimeSandboxStatus.TERMINATING.getValue() ? "Terminating" : status == RealtimeSandboxStatus.TERMINATED.getValue() ? "Terminated" : "Unrecognized";
    }

    /* compiled from: HtmlArtifactRemoteArchiveUrlResolver.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver$Companion;", "", "<init>", "()V", "TAG", "", "DEFAULT_SANDBOX_READY_TIMEOUT_MS", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
