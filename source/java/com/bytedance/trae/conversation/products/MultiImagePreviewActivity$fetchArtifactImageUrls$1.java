package com.bytedance.trae.conversation.products;

import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.products.MultiImagePreviewActivity;
import com.bytedance.trae.im.service.ChatSessionResponse;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.Map;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MultiImagePreviewActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.MultiImagePreviewActivity$fetchArtifactImageUrls$1", f = "MultiImagePreviewActivity.kt", i = {}, l = {498, 513}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MultiImagePreviewActivity$fetchArtifactImageUrls$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MultiImagePreviewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiImagePreviewActivity$fetchArtifactImageUrls$1(MultiImagePreviewActivity multiImagePreviewActivity, Continuation<? super MultiImagePreviewActivity$fetchArtifactImageUrls$1> continuation) {
        super(2, continuation);
        this.this$0 = multiImagePreviewActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MultiImagePreviewActivity$fetchArtifactImageUrls$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0168, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a0, code lost:
    
        r1 = r10.this$0.paths;
        r2 = r10.this$0;
        r1 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b2, code lost:
    
        if (r1.hasNext() == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b4, code lost:
    
        r6 = (java.lang.String) r1.next();
        r8 = r2.normalizeFilePath(r6, r11);
        r8 = r2.buildFileUrl(r0, r8);
        r2.imageUrls.put(r6, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0163, code lost:
    
        if (r7 != null) goto L62;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x00ee A[Catch: all -> 0x0027, LOOP:0: B:8:0x00e8->B:10:0x00ee, LOOP_END, TRY_LEAVE, TryCatch #0 {all -> 0x0027, blocks: (B:6:0x0016, B:7:0x00dc, B:8:0x00e8, B:10:0x00ee, B:28:0x0023, B:29:0x0062, B:31:0x0068, B:33:0x0077, B:34:0x007d, B:36:0x008b, B:37:0x0091, B:39:0x0096, B:44:0x00a0, B:45:0x00ae, B:47:0x00b4, B:52:0x002d, B:54:0x0035, B:55:0x003b, B:57:0x0047, B:60:0x00ca), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0068 A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:6:0x0016, B:7:0x00dc, B:8:0x00e8, B:10:0x00ee, B:28:0x0023, B:29:0x0062, B:31:0x0068, B:33:0x0077, B:34:0x007d, B:36:0x008b, B:37:0x0091, B:39:0x0096, B:44:0x00a0, B:45:0x00ae, B:47:0x00b4, B:52:0x002d, B:54:0x0035, B:55:0x003b, B:57:0x0047, B:60:0x00ca), top: B:2:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ViewPager2 viewPager2;
        ProgressBar progressBar;
        HttpDataResult.Success success;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String str = this.this$0.cliType;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cliType");
                    str = null;
                }
                if (Intrinsics.areEqual(str, CliType.REMOTE.getValue())) {
                    this.label = 1;
                    obj = BuildersKt.withContext(Dispatchers.getIO(), new MultiImagePreviewActivity$fetchArtifactImageUrls$1$result$1(this.this$0, null), (Continuation) this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    success = (HttpDataResult) obj;
                    if (success instanceof HttpDataResult.Success) {
                    }
                } else {
                    MultiImagePreviewActivity multiImagePreviewActivity = this.this$0;
                    this.label = 2;
                    obj = multiImagePreviewActivity.fetchDownloadUrlsWithRetry(multiImagePreviewActivity.paths, (Continuation) this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    MultiImagePreviewActivity multiImagePreviewActivity2 = this.this$0;
                    while (r11.hasNext()) {
                    }
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
                success = (HttpDataResult) obj;
                if (success instanceof HttpDataResult.Success) {
                    ChatSessionResponse chatSessionResponse = (ChatSessionResponse) success.getBizResp().getData();
                    String explorerUrl = chatSessionResponse != null ? chatSessionResponse.getExplorerUrl() : null;
                    ChatSessionResponse chatSessionResponse2 = (ChatSessionResponse) success.getBizResp().getData();
                    String workspacePath = chatSessionResponse2 != null ? chatSessionResponse2.getWorkspacePath() : null;
                    String str2 = explorerUrl;
                    if (str2 != null && str2.length() != 0) {
                        z = false;
                    }
                }
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                MultiImagePreviewActivity multiImagePreviewActivity22 = this.this$0;
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    multiImagePreviewActivity22.imageUrls.put((String) entry.getKey(), (String) entry.getValue());
                }
            }
        } catch (Throwable th) {
            try {
                FLogger.INSTANCE.e("MultiImagePreviewActivity", "fetchAllImageUrls error", th);
                progressBar = this.this$0.progressBar;
                if (progressBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                    progressBar = null;
                }
                progressBar.setVisibility(8);
                ViewPager2 viewPager22 = this.this$0.viewPager;
                if (viewPager22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                    viewPager22 = null;
                }
                ViewPager2 adapter = viewPager22.getAdapter();
                r7 = adapter instanceof MultiImagePreviewActivity.ImagePagerAdapter ? (MultiImagePreviewActivity.ImagePagerAdapter) adapter : null;
            } finally {
                viewPager2 = this.this$0.progressBar;
                if (viewPager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                    viewPager2 = null;
                }
                viewPager2.setVisibility(8);
                ViewPager2 viewPager23 = this.this$0.viewPager;
                if (viewPager23 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                    viewPager23 = null;
                }
                RecyclerView.Adapter adapter2 = viewPager23.getAdapter();
                r7 = adapter2 instanceof MultiImagePreviewActivity.ImagePagerAdapter ? (MultiImagePreviewActivity.ImagePagerAdapter) adapter2 : null;
                if (r7 != null) {
                    r7.notifyDataSetChanged();
                }
            }
        }
    }
}
