package com.bytedance.trae.conversation.products;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.trae.common.widget.CustomToast;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.products.ShareLinkBottomSheet;
import com.bytedance.trae.network.response.HttpDataResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
@DebugMetadata(c = "com.bytedance.trae.conversation.products.ShareLinkBottomSheet$requestRemoteShareLink$2", f = "ShareLinkBottomSheet.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ShareLinkBottomSheet$requestRemoteShareLink$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $loadingContainer;
    final /* synthetic */ ImageView $loadingIcon;
    final /* synthetic */ HttpDataResult<ShareLinkData> $result;
    final /* synthetic */ View $successContainer;
    final /* synthetic */ TextView $tvShareUrl;
    int label;
    final /* synthetic */ ShareLinkBottomSheet this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareLinkBottomSheet$requestRemoteShareLink$2(ShareLinkBottomSheet shareLinkBottomSheet, HttpDataResult<ShareLinkData> httpDataResult, View view, View view2, ImageView imageView, TextView textView, Continuation<? super ShareLinkBottomSheet$requestRemoteShareLink$2> continuation) {
        super(2, continuation);
        this.this$0 = shareLinkBottomSheet;
        this.$result = httpDataResult;
        this.$loadingContainer = view;
        this.$successContainer = view2;
        this.$loadingIcon = imageView;
        this.$tvShareUrl = textView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShareLinkBottomSheet$requestRemoteShareLink$2(this.this$0, this.$result, this.$loadingContainer, this.$successContainer, this.$loadingIcon, this.$tvShareUrl, continuation);
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
        if (!this.this$0.isAdded()) {
            return Unit.INSTANCE;
        }
        HttpDataResult.Success success = this.$result;
        if (success instanceof HttpDataResult.Success) {
            ShareLinkData shareLinkData = (ShareLinkData) success.getBizResp().getData();
            String shareSessionId = shareLinkData != null ? shareLinkData.getShareSessionId() : null;
            if (shareSessionId != null) {
                this.this$0.shareSessionId = shareSessionId;
                String str = ShareLinkBottomSheet.INSTANCE.getShareHost() + shareSessionId;
                this.this$0.shareUrl = str;
                ShareLinkBottomSheet.OnShareStateChangedListener onShareStateChangedListener = this.this$0.getOnShareStateChangedListener();
                if (onShareStateChangedListener != null) {
                    onShareStateChangedListener.onShareCreated(str, shareSessionId);
                }
                this.this$0.trackShareShowSuccess();
                this.this$0.showSuccess(this.$loadingContainer, this.$successContainer, this.$loadingIcon, this.$tvShareUrl);
                this.this$0.copyToClipboard();
            } else {
                this.this$0.trackShareShow();
                this.this$0.dismiss();
                CustomToast.showLong(this.this$0.requireContext(), this.this$0.getString(C0637R.string.trae_html_artifact_link_generate_failed));
            }
        } else if (success instanceof HttpDataResult.Error) {
            this.this$0.trackShareShow();
            this.this$0.dismiss();
            CustomToast.showLong(this.this$0.requireContext(), this.this$0.getString(C0637R.string.trae_html_artifact_link_generate_failed));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }
}
