package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.net.Uri;
import android.widget.FrameLayout;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.model.FileDiffInfo;
import com.bytedance.trae.utils.logger.FLogger;
import com.facebook.drawee.view.SimpleDraweeView;
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
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1", f = "ArtifactsRenderer.kt", i = {}, l = {2073, 2076}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class C0687x8c709ea8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatSessionId;
    final /* synthetic */ String $cliType;
    final /* synthetic */ FrameLayout $container;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ SimpleDraweeView $draweeView;
    final /* synthetic */ FileDiffInfo $file;
    final /* synthetic */ int $maxSizePx;
    final /* synthetic */ String $messageId;
    int label;
    final /* synthetic */ ArtifactsRenderer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0687x8c709ea8(ArtifactsRenderer artifactsRenderer, Context context, FileDiffInfo fileDiffInfo, String str, String str2, String str3, String str4, SimpleDraweeView simpleDraweeView, FrameLayout frameLayout, int i, Continuation<? super C0687x8c709ea8> continuation) {
        super(2, continuation);
        this.this$0 = artifactsRenderer;
        this.$context = context;
        this.$file = fileDiffInfo;
        this.$cliType = str;
        this.$chatSessionId = str2;
        this.$conversationId = str3;
        this.$messageId = str4;
        this.$draweeView = simpleDraweeView;
        this.$container = frameLayout;
        this.$maxSizePx = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0687x8c709ea8(this.this$0, this.$context, this.$file, this.$cliType, this.$chatSessionId, this.$conversationId, this.$messageId, this.$draweeView, this.$container, this.$maxSizePx, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Exception e) {
            FLogger.INSTANCE.e("AgentBlock", "loadSingleImageAsync error", e);
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.resolveImageUri(this.$context, this.$file, this.$cliType, this.$chatSessionId, this.$conversationId, this.$messageId, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        Uri uri = (Uri) obj;
        this.label = 2;
        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(uri, this.this$0, this.$draweeView, this.$container, this.$maxSizePx, null), (Continuation) this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArtifactsRenderer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1", f = "ArtifactsRenderer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadSingleImageAsync$1$onViewAttachedToWindow$1$1, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FrameLayout $container;
        final /* synthetic */ SimpleDraweeView $draweeView;
        final /* synthetic */ Uri $imageUri;
        final /* synthetic */ int $maxSizePx;
        int label;
        final /* synthetic */ ArtifactsRenderer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Uri uri, ArtifactsRenderer artifactsRenderer, SimpleDraweeView simpleDraweeView, FrameLayout frameLayout, int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$imageUri = uri;
            this.this$0 = artifactsRenderer;
            this.$draweeView = simpleDraweeView;
            this.$container = frameLayout;
            this.$maxSizePx = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$imageUri, this.this$0, this.$draweeView, this.$container, this.$maxSizePx, continuation);
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
            Uri uri = this.$imageUri;
            if (uri != null) {
                this.this$0.setImageWithResize(this.$draweeView, this.$container, this.$maxSizePx, uri);
            } else {
                this.$draweeView.setImageResource(C0591R.drawable.trae_ic_image_break);
            }
            return Unit.INSTANCE;
        }
    }
}
