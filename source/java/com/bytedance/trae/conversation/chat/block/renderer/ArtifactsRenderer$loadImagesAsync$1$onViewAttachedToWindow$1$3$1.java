package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.net.Uri;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.products.FileDownloadHelper;
import com.facebook.drawee.view.SimpleDraweeView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: ArtifactsRenderer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1", f = "ArtifactsRenderer.kt", i = {}, l = {2492, 2499}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ FileDownloadHelper $fileDownloadHelper;
    final /* synthetic */ JSONObject $fileExtras;
    final /* synthetic */ List<SimpleDraweeView> $imageViews;
    final /* synthetic */ int $index;
    final /* synthetic */ String $path;
    final /* synthetic */ String $url;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1(FileDownloadHelper fileDownloadHelper, Context context, String str, String str2, String str3, JSONObject jSONObject, List<? extends SimpleDraweeView> list, int i, Continuation<? super ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1> continuation) {
        super(2, continuation);
        this.$fileDownloadHelper = fileDownloadHelper;
        this.$context = context;
        this.$url = str;
        this.$conversationId = str2;
        this.$path = str3;
        this.$fileExtras = jSONObject;
        this.$imageViews = list;
        this.$index = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1(this.$fileDownloadHelper, this.$context, this.$url, this.$conversationId, this.$path, this.$fileExtras, this.$imageViews, this.$index, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FileDownloadHelper fileDownloadHelper = this.$fileDownloadHelper;
            Context applicationContext = this.$context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            this.label = 1;
            obj = fileDownloadHelper.downloadToCache(applicationContext, this.$url, this.$conversationId, this.$path, (r19 & 16) != 0 ? false : true, (r19 & 32) != 0 ? 0L : 0L, (Continuation) this);
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
        File file = (File) obj;
        this.label = 2;
        if (BuildersKt.withContext(Dispatchers.getMain(), new C06831(file, this.$fileExtras, this.$imageViews, this.$index, null), (Continuation) this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArtifactsRenderer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1", f = "ArtifactsRenderer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C06831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ File $cacheFile;
        final /* synthetic */ JSONObject $fileExtras;
        final /* synthetic */ List<SimpleDraweeView> $imageViews;
        final /* synthetic */ int $index;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06831(File file, JSONObject jSONObject, List<? extends SimpleDraweeView> list, int i, Continuation<? super C06831> continuation) {
            super(2, continuation);
            this.$cacheFile = file;
            this.$fileExtras = jSONObject;
            this.$imageViews = list;
            this.$index = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06831(this.$cacheFile, this.$fileExtras, this.$imageViews, this.$index, continuation);
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
            File file = this.$cacheFile;
            if (file != null && file.exists() && this.$cacheFile.length() > 0) {
                ArtifactFileUrlHelper.INSTANCE.reportApm("download_img", "local", "success", "", this.$fileExtras);
                this.$imageViews.get(this.$index).setImageURI(Uri.fromFile(this.$cacheFile));
            } else {
                ArtifactFileUrlHelper.INSTANCE.reportApm("download_img", "local", "failed", "download_error", this.$fileExtras);
                this.$imageViews.get(this.$index).setImageResource(C0591R.drawable.trae_ic_image_break);
            }
            return Unit.INSTANCE;
        }
    }
}
