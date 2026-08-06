package com.bytedance.trae.conversation.products;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareLinkBottomSheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.ShareLinkBottomSheet$requestShareLink$1", f = "ShareLinkBottomSheet.kt", i = {}, l = {182, 184}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ShareLinkBottomSheet$requestShareLink$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $loadingContainer;
    final /* synthetic */ ImageView $loadingIcon;
    final /* synthetic */ View $successContainer;
    final /* synthetic */ TextView $tvShareUrl;
    int label;
    final /* synthetic */ ShareLinkBottomSheet this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareLinkBottomSheet$requestShareLink$1(ShareLinkBottomSheet shareLinkBottomSheet, View view, View view2, ImageView imageView, TextView textView, Continuation<? super ShareLinkBottomSheet$requestShareLink$1> continuation) {
        super(2, continuation);
        this.this$0 = shareLinkBottomSheet;
        this.$loadingContainer = view;
        this.$successContainer = view2;
        this.$loadingIcon = imageView;
        this.$tvShareUrl = textView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShareLinkBottomSheet$requestShareLink$1(this.this$0, this.$loadingContainer, this.$successContainer, this.$loadingIcon, this.$tvShareUrl, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z;
        Object requestRemoteShareLink;
        Object requestLocalShareLink;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            z = this.this$0.isLocal;
            if (z) {
                this.label = 1;
                requestLocalShareLink = this.this$0.requestLocalShareLink(this.$loadingContainer, this.$successContainer, this.$loadingIcon, this.$tvShareUrl, (Continuation) this);
                if (requestLocalShareLink == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.label = 2;
                requestRemoteShareLink = this.this$0.requestRemoteShareLink(this.$loadingContainer, this.$successContainer, this.$loadingIcon, this.$tvShareUrl, (Continuation) this);
                if (requestRemoteShareLink == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
