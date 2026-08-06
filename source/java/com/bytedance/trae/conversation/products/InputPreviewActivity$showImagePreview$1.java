package com.bytedance.trae.conversation.products;

import android.content.Context;
import android.net.Uri;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InputPreviewActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.InputPreviewActivity$showImagePreview$1", f = "InputPreviewActivity.kt", i = {}, l = {414}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InputPreviewActivity$showImagePreview$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $imageUrl;
    final /* synthetic */ boolean $isLocalWork;
    int label;
    final /* synthetic */ InputPreviewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputPreviewActivity$showImagePreview$1(InputPreviewActivity inputPreviewActivity, String str, boolean z, Continuation<? super InputPreviewActivity$showImagePreview$1> continuation) {
        super(2, continuation);
        this.this$0 = inputPreviewActivity;
        this.$imageUrl = str;
        this.$isLocalWork = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InputPreviewActivity$showImagePreview$1(this.this$0, this.$imageUrl, this.$isLocalWork, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        FileDownloadHelper fileDownloadHelper;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z;
        Object downloadToCache;
        ProgressBar progressBar;
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        FrameLayout frameLayout3 = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            fileDownloadHelper = this.this$0.fileDownloadHelper;
            Context applicationContext = AppHost.INSTANCE.getApplication().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            String str6 = this.$imageUrl;
            str = this.this$0.conversationId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("conversationId");
                str2 = null;
            } else {
                str2 = str;
            }
            if (this.$isLocalWork) {
                str3 = this.this$0.oidId;
                if (str3 == null) {
                    str4 = "oidId";
                    Intrinsics.throwUninitializedPropertyAccessException(str4);
                    str5 = null;
                }
                str5 = str3;
            } else {
                str3 = this.this$0.fileName;
                if (str3 == null) {
                    str4 = "fileName";
                    Intrinsics.throwUninitializedPropertyAccessException(str4);
                    str5 = null;
                }
                str5 = str3;
            }
            z = this.this$0.needDecode;
            this.label = 1;
            downloadToCache = fileDownloadHelper.downloadToCache(applicationContext, str6, str2, str5, (r19 & 16) != 0 ? false : z, (r19 & 32) != 0 ? 0L : 0L, (Continuation) this);
            if (downloadToCache == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            downloadToCache = obj;
        }
        File file = (File) downloadToCache;
        if (file != null && file.exists() && file.length() > 0) {
            progressBar = this.this$0.progressBar;
            if (progressBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                progressBar = null;
            }
            progressBar.setVisibility(8);
            frameLayout = this.this$0.imageContainer;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageContainer");
                frameLayout = null;
            }
            frameLayout.setVisibility(0);
            Uri fromFile = Uri.fromFile(file);
            InputPreviewActivity inputPreviewActivity = this.this$0;
            Intrinsics.checkNotNull(fromFile);
            inputPreviewActivity.loadImage(fromFile);
            InputPreviewActivity inputPreviewActivity2 = this.this$0;
            frameLayout2 = inputPreviewActivity2.imageContainer;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageContainer");
            } else {
                frameLayout3 = frameLayout2;
            }
            inputPreviewActivity2.setupImageTouchHandling(frameLayout3);
        } else {
            FLogger.INSTANCE.d("ArtifactPreviewActivity", "showImagePreview: cache download failed");
            this.this$0.showError();
        }
        return Unit.INSTANCE;
    }
}
