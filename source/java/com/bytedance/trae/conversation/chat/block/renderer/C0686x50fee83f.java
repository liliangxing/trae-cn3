package com.bytedance.trae.conversation.chat.block.renderer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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

/* compiled from: ArtifactsRenderer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1", f = "ArtifactsRenderer.kt", i = {}, l = {899, 907, 913, 914, 929}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class C0686x50fee83f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $cardContainer;
    final /* synthetic */ String $chatSessionId;
    final /* synthetic */ String $cliType;
    final /* synthetic */ View $contentContainer;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ View $dividerLine;
    final /* synthetic */ View $headerRow;
    final /* synthetic */ View $loadingView;
    final /* synthetic */ SimpleMarkdownTextView $markdownTextView;
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $path;
    final /* synthetic */ TextView $subtitleView;
    int label;
    final /* synthetic */ ArtifactsRenderer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0686x50fee83f(String str, String str2, String str3, String str4, String str5, ArtifactsRenderer artifactsRenderer, View view, View view2, TextView textView, View view3, View view4, View view5, SimpleMarkdownTextView simpleMarkdownTextView, Continuation<? super C0686x50fee83f> continuation) {
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
        this.$markdownTextView = simpleMarkdownTextView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0686x50fee83f(this.$chatSessionId, this.$cliType, this.$path, this.$messageId, this.$conversationId, this.this$0, this.$contentContainer, this.$headerRow, this.$subtitleView, this.$dividerLine, this.$cardContainer, this.$loadingView, this.$markdownTextView, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x006e, code lost:
    
        r17.label = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0092, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.bytedance.trae.conversation.chat.block.renderer.C0686x50fee83f.AnonymousClass1(r17.this$0, r17.$contentContainer, r17.$headerRow, r17.$subtitleView, r17.$dividerLine, r17.$cardContainer, null), (kotlin.coroutines.Continuation) r17) != r2) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0094, code lost:
    
        return r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00dc A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object fetchFileUrl;
        Object fetchTextContent;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        try {
        } catch (Exception e) {
            FLogger.INSTANCE.e("AgentBlock", "loadMarkdownContentAsync error", e);
            this.label = 5;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass3(this.this$0, this.$contentContainer, this.$headerRow, this.$subtitleView, this.$dividerLine, this.$cardContainer, null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
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
                    ResultKt.throwOnFailure(obj);
                    fetchTextContent = obj;
                    str = (String) fetchTextContent;
                    this.label = 4;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(str, this.$loadingView, this.$markdownTextView, this.this$0, this.$contentContainer, this.$headerRow, this.$subtitleView, this.$dividerLine, this.$cardContainer, null), (Continuation) this) == coroutine_suspended) {
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
            ResultKt.throwOnFailure(obj);
            fetchFileUrl = obj;
        }
        ArtifactFileUrlHelper.FileUrlResult fileUrlResult = (ArtifactFileUrlHelper.FileUrlResult) fetchFileUrl;
        String url = fileUrlResult.getUrl();
        if (url != null && url.length() != 0) {
            z = false;
        }
        this.label = 3;
        fetchTextContent = ArtifactFileUrlHelper.INSTANCE.fetchTextContent(fileUrlResult.getUrl(), this.$cliType, (Continuation) this);
        if (fetchTextContent == coroutine_suspended) {
            return coroutine_suspended;
        }
        str = (String) fetchTextContent;
        this.label = 4;
        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(str, this.$loadingView, this.$markdownTextView, this.this$0, this.$contentContainer, this.$headerRow, this.$subtitleView, this.$dividerLine, this.$cardContainer, null), (Continuation) this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArtifactsRenderer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$1", f = "ArtifactsRenderer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$1, reason: invalid class name */
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
    @DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2", f = "ArtifactsRenderer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$2, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ View $cardContainer;
        final /* synthetic */ String $content;
        final /* synthetic */ View $contentContainer;
        final /* synthetic */ View $dividerLine;
        final /* synthetic */ View $headerRow;
        final /* synthetic */ View $loadingView;
        final /* synthetic */ SimpleMarkdownTextView $markdownTextView;
        final /* synthetic */ TextView $subtitleView;
        int label;
        final /* synthetic */ ArtifactsRenderer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, View view, SimpleMarkdownTextView simpleMarkdownTextView, ArtifactsRenderer artifactsRenderer, View view2, View view3, TextView textView, View view4, View view5, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$content = str;
            this.$loadingView = view;
            this.$markdownTextView = simpleMarkdownTextView;
            this.this$0 = artifactsRenderer;
            this.$contentContainer = view2;
            this.$headerRow = view3;
            this.$subtitleView = textView;
            this.$dividerLine = view4;
            this.$cardContainer = view5;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$content, this.$loadingView, this.$markdownTextView, this.this$0, this.$contentContainer, this.$headerRow, this.$subtitleView, this.$dividerLine, this.$cardContainer, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            String truncateForPreview;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String str = this.$content;
            if (str == null || str.length() == 0) {
                this.this$0.collapseToFileCard(this.$contentContainer, this.$headerRow, this.$subtitleView, this.$dividerLine, this.$cardContainer);
            } else {
                this.$loadingView.setVisibility(8);
                Object parent = this.$loadingView.getParent();
                View view = parent instanceof View ? (View) parent : null;
                if (view != null) {
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = -2;
                    }
                    view.requestLayout();
                }
                this.$markdownTextView.setVisibility(0);
                MarkdownHelper markdownHelper = MarkdownHelper.INSTANCE;
                SimpleMarkdownTextView simpleMarkdownTextView = this.$markdownTextView;
                truncateForPreview = this.this$0.truncateForPreview(this.$content);
                MarkdownHelper.setMarkdownContent$default(markdownHelper, simpleMarkdownTextView, truncateForPreview, true, null, 8, null);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArtifactsRenderer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$3", f = "ArtifactsRenderer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadMarkdownContentAsync$1$onViewAttachedToWindow$1$3, reason: invalid class name */
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
