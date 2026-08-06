package com.bytedance.trae.conversation.products;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.products.IShareLinkApi;
import com.bytedance.trae.network.response.HttpDataResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HtmlArtifactPreviewActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity$queryExistingShareLink$1", f = "HtmlArtifactPreviewActivity.kt", i = {}, l = {599, 617}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class HtmlArtifactPreviewActivity$queryExistingShareLink$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isLocal;
    int label;
    final /* synthetic */ HtmlArtifactPreviewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HtmlArtifactPreviewActivity$queryExistingShareLink$1(boolean z, HtmlArtifactPreviewActivity htmlArtifactPreviewActivity, Continuation<? super HtmlArtifactPreviewActivity$queryExistingShareLink$1> continuation) {
        super(2, continuation);
        this.$isLocal = z;
        this.this$0 = htmlArtifactPreviewActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HtmlArtifactPreviewActivity$queryExistingShareLink$1(this.$isLocal, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        HtmlArtifactRemoteArchiveUrlResolver htmlArtifactRemoteArchiveUrlResolver;
        HtmlArtifactDownloadTarget htmlArtifactDownloadTarget;
        HtmlArtifactRemoteArchiveUrlResolver htmlArtifactRemoteArchiveUrlResolver2;
        String str;
        String str2;
        String str3;
        HtmlArtifactDownloadTarget htmlArtifactDownloadTarget2;
        HttpDataResult.Success success;
        HttpDataResult.Success success2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$isLocal) {
                str2 = this.this$0.realPath;
                String str4 = str2;
                HtmlArtifactPreviewActivity htmlArtifactPreviewActivity = this.this$0;
                if (str4.length() == 0) {
                    htmlArtifactDownloadTarget2 = htmlArtifactPreviewActivity.downloadTarget;
                    if (htmlArtifactDownloadTarget2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("downloadTarget");
                        htmlArtifactDownloadTarget2 = null;
                    }
                    str4 = StringsKt.removePrefix(htmlArtifactDownloadTarget2.getLocalRequestPath(), "package/");
                }
                String str5 = str4;
                IShareLinkApi.Companion companion = IShareLinkApi.INSTANCE;
                str3 = this.this$0.conversationId;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("conversationId");
                    str3 = null;
                }
                this.label = 1;
                obj = companion.getLocalShareLink(new GetLocalShareLinkRequest(str3, str5), (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                success = (HttpDataResult) obj;
                if (success instanceof HttpDataResult.Success) {
                }
            } else {
                htmlArtifactRemoteArchiveUrlResolver = this.this$0.remoteArchiveUrlResolver;
                htmlArtifactDownloadTarget = this.this$0.downloadTarget;
                if (htmlArtifactDownloadTarget == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("downloadTarget");
                    htmlArtifactDownloadTarget = null;
                }
                String localRequestPath = htmlArtifactDownloadTarget.getLocalRequestPath();
                htmlArtifactRemoteArchiveUrlResolver2 = this.this$0.remoteArchiveUrlResolver;
                String normalizeFilePath = htmlArtifactRemoteArchiveUrlResolver.normalizeFilePath(localRequestPath, htmlArtifactRemoteArchiveUrlResolver2.getWorkSpace());
                IShareLinkApi.Companion companion2 = IShareLinkApi.INSTANCE;
                str = this.this$0.chatSessionId;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatSessionId");
                    str = null;
                }
                this.label = 2;
                obj = companion2.getRemoteShareLink(str, normalizeFilePath, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                success2 = (HttpDataResult) obj;
                if (success2 instanceof HttpDataResult.Success) {
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            success = (HttpDataResult) obj;
            if (success instanceof HttpDataResult.Success) {
                GetLocalShareLinkData getLocalShareLinkData = (GetLocalShareLinkData) success.getBizResp().getData();
                if (Intrinsics.areEqual(getLocalShareLinkData != null ? getLocalShareLinkData.getStatus() : null, "active")) {
                    String shareUrl = getLocalShareLinkData.getShareUrl();
                    if (!(shareUrl == null || shareUrl.length() == 0)) {
                        this.this$0.existingShareUrl = getLocalShareLinkData.getShareUrl();
                        this.this$0.existingShareId = getLocalShareLinkData.getShareId();
                    }
                }
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            success2 = (HttpDataResult) obj;
            if (success2 instanceof HttpDataResult.Success) {
                ShareArtifactData shareArtifactData = (ShareArtifactData) success2.getBizResp().getData();
                if (Intrinsics.areEqual(shareArtifactData != null ? shareArtifactData.getStatus() : null, "active")) {
                    String shareSessionId = shareArtifactData.getShareSessionId();
                    if (!(shareSessionId == null || shareSessionId.length() == 0)) {
                        this.this$0.existingShareId = shareArtifactData.getShareSessionId();
                        this.this$0.existingShareUrl = ShareLinkBottomSheet.INSTANCE.getShareHost() + shareArtifactData.getShareSessionId();
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }
}
