package com.bytedance.trae.conversation.products;

import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.products.MultiImagePreviewActivity;
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
@DebugMetadata(c = "com.bytedance.trae.conversation.products.MultiImagePreviewActivity$fetchAllImageUrls$2", f = "MultiImagePreviewActivity.kt", i = {}, l = {372}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MultiImagePreviewActivity$fetchAllImageUrls$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MultiImagePreviewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiImagePreviewActivity$fetchAllImageUrls$2(MultiImagePreviewActivity multiImagePreviewActivity, Continuation<? super MultiImagePreviewActivity$fetchAllImageUrls$2> continuation) {
        super(2, continuation);
        this.this$0 = multiImagePreviewActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MultiImagePreviewActivity$fetchAllImageUrls$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00aa, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a5, code lost:
    
        if (r6 != null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ViewPager2 viewPager2;
        ProgressBar progressBar;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = BuildersKt.withContext(Dispatchers.getIO(), new MultiImagePreviewActivity$fetchAllImageUrls$2$urlMap$1(this.this$0, null), (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.imageUrls.putAll((Map) obj);
        } catch (Throwable th) {
            try {
                FLogger.INSTANCE.e("MultiImagePreviewActivity", "fetchAllImageUrls (image_id) error", th);
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
                r6 = adapter instanceof MultiImagePreviewActivity.ImagePagerAdapter ? (MultiImagePreviewActivity.ImagePagerAdapter) adapter : null;
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
                r6 = adapter2 instanceof MultiImagePreviewActivity.ImagePagerAdapter ? (MultiImagePreviewActivity.ImagePagerAdapter) adapter2 : null;
                if (r6 != null) {
                    r6.notifyDataSetChanged();
                }
            }
        }
    }
}
