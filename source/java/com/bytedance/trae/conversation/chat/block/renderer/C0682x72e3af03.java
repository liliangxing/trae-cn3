package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.model.FileDiffInfo;
import com.bytedance.trae.utils.logger.FLogger;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: ArtifactsRenderer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1", f = "ArtifactsRenderer.kt", i = {0}, l = {1240, 1243, 1251, 1252, 1263}, m = "invokeSuspend", n = {"extras"}, s = {"L$0"})
/* renamed from: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class C0682x72e3af03 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $cardContainer;
    final /* synthetic */ String $chatSessionId;
    final /* synthetic */ String $cliType;
    final /* synthetic */ View $contentContainer;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ View $dividerLine;
    final /* synthetic */ FileDiffInfo $file;
    final /* synthetic */ String $filePath;
    final /* synthetic */ View $headerRow;
    final /* synthetic */ View $loadingView;
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $path;
    final /* synthetic */ TextView $subtitleView;
    final /* synthetic */ WebView $webView;
    Object L$0;
    int label;
    final /* synthetic */ ArtifactsRenderer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0682x72e3af03(ArtifactsRenderer artifactsRenderer, String str, String str2, String str3, String str4, String str5, Context context, String str6, FileDiffInfo fileDiffInfo, View view, View view2, TextView textView, View view3, View view4, View view5, WebView webView, Continuation<? super C0682x72e3af03> continuation) {
        super(2, continuation);
        this.this$0 = artifactsRenderer;
        this.$chatSessionId = str;
        this.$cliType = str2;
        this.$path = str3;
        this.$conversationId = str4;
        this.$messageId = str5;
        this.$context = context;
        this.$filePath = str6;
        this.$file = fileDiffInfo;
        this.$contentContainer = view;
        this.$headerRow = view2;
        this.$subtitleView = textView;
        this.$dividerLine = view3;
        this.$cardContainer = view4;
        this.$loadingView = view5;
        this.$webView = webView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0682x72e3af03(this.this$0, this.$chatSessionId, this.$cliType, this.$path, this.$conversationId, this.$messageId, this.$context, this.$filePath, this.$file, this.$contentContainer, this.$headerRow, this.$subtitleView, this.$dividerLine, this.$cardContainer, this.$loadingView, this.$webView, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x009e, code lost:
    
        com.bytedance.trae.conversation.chat.block.renderer.ArtifactFileUrlHelper.INSTANCE.reportApm("fetch_html_url", r19.$cliType, "failed", "", r16);
        r19.L$0 = null;
        r19.label = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d3, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.bytedance.trae.conversation.chat.block.renderer.C0682x72e3af03.AnonymousClass1(r19.this$0, r19.$contentContainer, r19.$headerRow, r19.$subtitleView, r19.$dividerLine, r19.$cardContainer, null), (kotlin.coroutines.Continuation) r19) != r2) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d5, code lost:
    
        return r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0135 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        Object fetchHtmlArchiveUrl;
        Object downloadAndExtractHtml;
        File file;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        try {
        } catch (Exception e) {
            FLogger.INSTANCE.e("AgentBlock", "loadHtmlContentAsync error", e);
            this.L$0 = null;
            this.label = 5;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass3(this.this$0, this.$contentContainer, this.$headerRow, this.$subtitleView, this.$dividerLine, this.$cardContainer, null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            jSONObject = new JSONObject();
            String str = this.$chatSessionId;
            String str2 = this.$conversationId;
            String str3 = this.$messageId;
            FileDiffInfo fileDiffInfo = this.$file;
            try {
                jSONObject.put("chatSessionId", str);
                jSONObject.put("conversationId", str2);
                jSONObject.put("messageId", str3);
                jSONObject.put("path", fileDiffInfo.getFilePath());
            } catch (Throwable unused) {
            }
            this.L$0 = jSONObject;
            this.label = 1;
            fetchHtmlArchiveUrl = this.this$0.fetchHtmlArchiveUrl(this.$chatSessionId, this.$cliType, this.$path, this.$conversationId, this.$messageId, (Continuation) this);
            if (fetchHtmlArchiveUrl == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i == 3) {
                    ResultKt.throwOnFailure(obj);
                    downloadAndExtractHtml = obj;
                    file = (File) downloadAndExtractHtml;
                    this.label = 4;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(file, this.$loadingView, this.$webView, this.this$0, this.$contentContainer, this.$headerRow, this.$subtitleView, this.$dividerLine, this.$cardContainer, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                if (i == 4) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            jSONObject = (JSONObject) this.L$0;
            ResultKt.throwOnFailure(obj);
            fetchHtmlArchiveUrl = obj;
        }
        JSONObject jSONObject2 = jSONObject;
        String str4 = (String) fetchHtmlArchiveUrl;
        String str5 = str4;
        if (str5 != null && str5.length() != 0) {
            z = false;
        }
        ArtifactFileUrlHelper.INSTANCE.reportApm("fetch_html_url", this.$cliType, "success", "", jSONObject2);
        this.L$0 = null;
        this.label = 3;
        downloadAndExtractHtml = this.this$0.downloadAndExtractHtml(this.$context, str4, this.$cliType, this.$conversationId, this.$filePath, jSONObject2, (Continuation) this);
        if (downloadAndExtractHtml == coroutine_suspended) {
            return coroutine_suspended;
        }
        file = (File) downloadAndExtractHtml;
        this.label = 4;
        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(file, this.$loadingView, this.$webView, this.this$0, this.$contentContainer, this.$headerRow, this.$subtitleView, this.$dividerLine, this.$cardContainer, null), (Continuation) this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArtifactsRenderer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$1", f = "ArtifactsRenderer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$1, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ View $cardContainer;
        final /* synthetic */ View $contentContainer;
        final /* synthetic */ View $dividerLine;
        final /* synthetic */ View $headerRow;
        final /* synthetic */ TextView $subtitleView;
        int label;
        final /* synthetic */ ArtifactsRenderer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ArtifactsRenderer artifactsRenderer, View view, View view2, TextView textView, View view3, View view4, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = artifactsRenderer;
            this.$contentContainer = view;
            this.$headerRow = view2;
            this.$subtitleView = textView;
            this.$dividerLine = view3;
            this.$cardContainer = view4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$contentContainer, this.$headerRow, this.$subtitleView, this.$dividerLine, this.$cardContainer, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.collapseToFileCard(this.$contentContainer, this.$headerRow, this.$subtitleView, this.$dividerLine, this.$cardContainer);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArtifactsRenderer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2", f = "ArtifactsRenderer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$2, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ View $cardContainer;
        final /* synthetic */ View $contentContainer;
        final /* synthetic */ View $dividerLine;
        final /* synthetic */ File $entryFile;
        final /* synthetic */ View $headerRow;
        final /* synthetic */ View $loadingView;
        final /* synthetic */ TextView $subtitleView;
        final /* synthetic */ WebView $webView;
        int label;
        final /* synthetic */ ArtifactsRenderer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(File file, View view, WebView webView, ArtifactsRenderer artifactsRenderer, View view2, View view3, TextView textView, View view4, View view5, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$entryFile = file;
            this.$loadingView = view;
            this.$webView = webView;
            this.this$0 = artifactsRenderer;
            this.$contentContainer = view2;
            this.$headerRow = view3;
            this.$subtitleView = textView;
            this.$dividerLine = view4;
            this.$cardContainer = view5;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$entryFile, this.$loadingView, this.$webView, this.this$0, this.$contentContainer, this.$headerRow, this.$subtitleView, this.$dividerLine, this.$cardContainer, continuation);
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
            if (this.$entryFile == null) {
                this.this$0.collapseToFileCard(this.$contentContainer, this.$headerRow, this.$subtitleView, this.$dividerLine, this.$cardContainer);
            } else {
                this.$loadingView.setVisibility(8);
                this.$webView.setVisibility(0);
                this.$webView.loadUrl("file://" + this.$entryFile.getAbsolutePath());
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArtifactsRenderer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$3", f = "ArtifactsRenderer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadHtmlContentAsync$1$onViewAttachedToWindow$1$3, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ View $cardContainer;
        final /* synthetic */ View $contentContainer;
        final /* synthetic */ View $dividerLine;
        final /* synthetic */ View $headerRow;
        final /* synthetic */ TextView $subtitleView;
        int label;
        final /* synthetic */ ArtifactsRenderer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(ArtifactsRenderer artifactsRenderer, View view, View view2, TextView textView, View view3, View view4, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = artifactsRenderer;
            this.$contentContainer = view;
            this.$headerRow = view2;
            this.$subtitleView = textView;
            this.$dividerLine = view3;
            this.$cardContainer = view4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.this$0, this.$contentContainer, this.$headerRow, this.$subtitleView, this.$dividerLine, this.$cardContainer, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.collapseToFileCard(this.$contentContainer, this.$headerRow, this.$subtitleView, this.$dividerLine, this.$cardContainer);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
