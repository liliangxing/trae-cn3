package com.bytedance.trae.conversation.products;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareLinkBottomSheet.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.ShareLinkBottomSheet", f = "ShareLinkBottomSheet.kt", i = {0, 0, 0, 0, 0}, l = {195, 203}, m = "requestRemoteShareLink", n = {"this", "loadingContainer", "successContainer", "loadingIcon", "tvShareUrl"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ShareLinkBottomSheet$requestRemoteShareLink$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ShareLinkBottomSheet this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareLinkBottomSheet$requestRemoteShareLink$1(ShareLinkBottomSheet shareLinkBottomSheet, Continuation<? super ShareLinkBottomSheet$requestRemoteShareLink$1> continuation) {
        super(continuation);
        this.this$0 = shareLinkBottomSheet;
    }

    public final Object invokeSuspend(Object obj) {
        Object requestRemoteShareLink;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        requestRemoteShareLink = this.this$0.requestRemoteShareLink(null, null, null, null, (Continuation) this);
        return requestRemoteShareLink;
    }
}
