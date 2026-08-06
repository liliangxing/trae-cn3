package com.bytedance.trae.conversation.chat.block.renderer;

import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.trae.conversation.chat.block.renderer.ArtifactFileUrlHelper;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: ArtifactsRenderer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1", f = "ArtifactsRenderer.kt", i = {0, 2}, l = {622, 631, 638, 651, 664}, m = "invokeSuspend", n = {"extras", "urlResult"}, s = {"L$0", "L$0"})
/* renamed from: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class C0688x86d82341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $cardContainer;
    final /* synthetic */ String $chatSessionId;
    final /* synthetic */ String $cliType;
    final /* synthetic */ View $contentContainer;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ View $dividerLine;
    final /* synthetic */ View $headerRow;
    final /* synthetic */ View $loadingView;
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $path;
    final /* synthetic */ TextView $subtitleView;
    final /* synthetic */ TextView $textView;
    Object L$0;
    int label;
    final /* synthetic */ ArtifactsRenderer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0688x86d82341(String str, String str2, String str3, String str4, String str5, ArtifactsRenderer artifactsRenderer, View view, View view2, TextView textView, View view3, View view4, View view5, TextView textView2, Continuation<? super C0688x86d82341> continuation) {
        super(2, continuation);
        this.$chatSessionId = str;
        this.$cliType = str2;
        this.$path = str3;
        this.$messageId = str4;
        this.$conversationId = str5;
        this.this$0 = artifactsRenderer;
        this.$contentContainer = view;
        this.$headerRow = view2;
        this.$subtitleView = textView;
        this.$dividerLine = view3;
        this.$cardContainer = view4;
        this.$loadingView = view5;
        this.$textView = textView2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0688x86d82341(this.$chatSessionId, this.$cliType, this.$path, this.$messageId, this.$conversationId, this.this$0, this.$contentContainer, this.$headerRow, this.$subtitleView, this.$dividerLine, this.$cardContainer, this.$loadingView, this.$textView, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:1|2|(1:(1:(1:(3:(1:(1:9)(2:13|14))(1:15)|10|11)(9:16|17|18|19|20|21|(1:23)|10|11))(3:26|27|28))(3:29|30|31))(6:46|47|48|49|50|(1:52))|32|33|(1:38)|43|(1:45)|18|19|20|21|(0)|10|11) */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a9, code lost:
    
        com.bytedance.trae.conversation.chat.block.renderer.ArtifactFileUrlHelper.INSTANCE.reportApm("fetch_file_url", r37.$cliType, "failed", "", r21);
        r37.L$0 = null;
        r37.label = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ec, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.bytedance.trae.conversation.chat.block.renderer.C0688x86d82341.AnonymousClass1(r37.this$0, r37.$contentContainer, r37.$headerRow, r37.$subtitleView, r37.$dividerLine, r37.$cardContainer, null), (kotlin.coroutines.Continuation) r37) != r2) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ee, code lost:
    
        return r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0184 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        Object fetchFileUrl;
        ArtifactFileUrlHelper.FileUrlResult fileUrlResult;
        Object fetchTextContent;
        String str;
        JSONObject jSONObject2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        try {
        } catch (Exception e) {
            FLogger.INSTANCE.e("AgentBlock", "loadTextContentAsync error", e);
            this.L$0 = null;
            this.label = 5;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass3(this.this$0, this.$contentContainer, this.$headerRow, this.$subtitleView, this.$dividerLine, this.$cardContainer, null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            jSONObject = new JSONObject();
            String str2 = this.$chatSessionId;
            String str3 = this.$conversationId;
            String str4 = this.$messageId;
            String str5 = this.$path;
            try {
                jSONObject.put("chatSessionId", str2);
                jSONObject.put("conversationId", str3);
                jSONObject.put("messageId", str4);
                jSONObject.put("path", str5);
            } catch (Throwable unused) {
            }
            this.L$0 = jSONObject;
            this.label = 1;
            fetchFileUrl = ArtifactFileUrlHelper.INSTANCE.fetchFileUrl(this.$chatSessionId, this.$cliType, this.$path, this.$messageId, this.$conversationId, (Continuation) this);
            if (fetchFileUrl == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i == 3) {
                    fileUrlResult = (ArtifactFileUrlHelper.FileUrlResult) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    fetchTextContent = obj;
                    str = (String) fetchTextContent;
                    jSONObject2 = new JSONObject();
                    String str6 = this.$chatSessionId;
                    String str7 = this.$conversationId;
                    String str8 = this.$messageId;
                    String str9 = this.$path;
                    jSONObject2.put("chatSessionId", str6);
                    jSONObject2.put("conversationId", str7);
                    jSONObject2.put("messageId", str8);
                    jSONObject2.put(IWeixinService.ResponseConstants.URL, fileUrlResult.getUrl());
                    jSONObject2.put("path", str9);
                    this.L$0 = null;
                    this.label = 4;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(str, this.$cliType, jSONObject2, this.$loadingView, this.$textView, this.this$0, this.$contentContainer, this.$headerRow, this.$subtitleView, this.$dividerLine, this.$cardContainer, null), (Continuation) this) == coroutine_suspended) {
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
            fetchFileUrl = obj;
        }
        JSONObject jSONObject3 = jSONObject;
        fileUrlResult = (ArtifactFileUrlHelper.FileUrlResult) fetchFileUrl;
        String url = fileUrlResult.getUrl();
        if (url != null && url.length() != 0) {
            z = false;
        }
        ArtifactFileUrlHelper.INSTANCE.reportApm("fetch_file_url", this.$cliType, "success", "", jSONObject3);
        this.L$0 = fileUrlResult;
        this.label = 3;
        fetchTextContent = ArtifactFileUrlHelper.INSTANCE.fetchTextContent(fileUrlResult.getUrl(), this.$cliType, (Continuation) this);
        if (fetchTextContent == coroutine_suspended) {
            return coroutine_suspended;
        }
        str = (String) fetchTextContent;
        jSONObject2 = new JSONObject();
        String str62 = this.$chatSessionId;
        String str72 = this.$conversationId;
        String str82 = this.$messageId;
        String str92 = this.$path;
        jSONObject2.put("chatSessionId", str62);
        jSONObject2.put("conversationId", str72);
        jSONObject2.put("messageId", str82);
        jSONObject2.put(IWeixinService.ResponseConstants.URL, fileUrlResult.getUrl());
        jSONObject2.put("path", str92);
        this.L$0 = null;
        this.label = 4;
        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(str, this.$cliType, jSONObject2, this.$loadingView, this.$textView, this.this$0, this.$contentContainer, this.$headerRow, this.$subtitleView, this.$dividerLine, this.$cardContainer, null), (Continuation) this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArtifactsRenderer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$1", f = "ArtifactsRenderer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$1, reason: invalid class name */
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
    @DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2", f = "ArtifactsRenderer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$2, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ View $cardContainer;
        final /* synthetic */ String $cliType;
        final /* synthetic */ String $content;
        final /* synthetic */ View $contentContainer;
        final /* synthetic */ View $dividerLine;
        final /* synthetic */ JSONObject $downloadExtras;
        final /* synthetic */ View $headerRow;
        final /* synthetic */ View $loadingView;
        final /* synthetic */ TextView $subtitleView;
        final /* synthetic */ TextView $textView;
        int label;
        final /* synthetic */ ArtifactsRenderer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, String str2, JSONObject jSONObject, View view, TextView textView, ArtifactsRenderer artifactsRenderer, View view2, View view3, TextView textView2, View view4, View view5, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$content = str;
            this.$cliType = str2;
            this.$downloadExtras = jSONObject;
            this.$loadingView = view;
            this.$textView = textView;
            this.this$0 = artifactsRenderer;
            this.$contentContainer = view2;
            this.$headerRow = view3;
            this.$subtitleView = textView2;
            this.$dividerLine = view4;
            this.$cardContainer = view5;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$content, this.$cliType, this.$downloadExtras, this.$loadingView, this.$textView, this.this$0, this.$contentContainer, this.$headerRow, this.$subtitleView, this.$dividerLine, this.$cardContainer, continuation);
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
            String str = this.$content;
            if (!(str == null || str.length() == 0)) {
                ArtifactFileUrlHelper.INSTANCE.reportApm("fetch_file_content", this.$cliType, "success", "", this.$downloadExtras);
                this.$loadingView.setVisibility(8);
                this.$textView.setVisibility(0);
                this.$textView.setText(this.$content);
            } else {
                ArtifactFileUrlHelper.INSTANCE.reportApm("fetch_file_content", this.$cliType, "failed", "", this.$downloadExtras);
                this.this$0.collapseToFileCard(this.$contentContainer, this.$headerRow, this.$subtitleView, this.$dividerLine, this.$cardContainer);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArtifactsRenderer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$3", f = "ArtifactsRenderer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadTextContentAsync$1$onViewAttachedToWindow$1$3, reason: invalid class name */
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
