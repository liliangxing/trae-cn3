package com.bytedance.trae.conversation.mediachoose.p008ui;

import com.bytedance.trae.conversation.mediachoose.data.MediaStoreRepository;
import com.bytedance.trae.conversation.mediachoose.model.MediaChooseConfig;
import com.bytedance.trae.conversation.mediachoose.model.MediaType;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.ArrayList;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaChooseFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment$loadNextPageIfNeed$1", f = "MediaChooseFragment.kt", i = {}, l = {279}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MediaChooseFragment$loadNextPageIfNeed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MediaChooseFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaChooseFragment$loadNextPageIfNeed$1(MediaChooseFragment mediaChooseFragment, Continuation<? super MediaChooseFragment$loadNextPageIfNeed$1> continuation) {
        super(2, continuation);
        this.this$0 = mediaChooseFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MediaChooseFragment$loadNextPageIfNeed$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MediaStoreRepository mediaStoreRepository;
        MediaStoreRepository mediaStoreRepository2;
        long j;
        MediaChooseConfig mediaChooseConfig;
        int i;
        int i2;
        ArrayList arrayList;
        MediaGridAdapter mediaGridAdapter;
        ArrayList arrayList2;
        MediaChooseConfig mediaChooseConfig2;
        MediaGridAdapter mediaGridAdapter2;
        MediaSelection mediaSelection;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        MediaSelection mediaSelection2 = null;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            mediaStoreRepository = this.this$0.repository;
            if (mediaStoreRepository == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repository");
                mediaStoreRepository2 = null;
            } else {
                mediaStoreRepository2 = mediaStoreRepository;
            }
            j = this.this$0.currentBucketId;
            mediaChooseConfig = this.this$0.config;
            if (mediaChooseConfig == null) {
                Intrinsics.throwUninitializedPropertyAccessException("config");
                mediaChooseConfig = null;
            }
            MediaType mediaType = mediaChooseConfig.getMediaType();
            i = this.this$0.offset;
            this.label = 1;
            obj = mediaStoreRepository2.loadMediaPage(j, mediaType, i, 60, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        List list = (List) obj;
        if (list.isEmpty()) {
            this.this$0.hasMore = false;
            return Unit.INSTANCE;
        }
        MediaChooseFragment mediaChooseFragment = this.this$0;
        i2 = mediaChooseFragment.offset;
        mediaChooseFragment.offset = i2 + list.size();
        arrayList = this.this$0.mediaItems;
        arrayList.addAll(list);
        mediaGridAdapter = this.this$0.adapter;
        if (mediaGridAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            mediaGridAdapter = null;
        }
        arrayList2 = this.this$0.mediaItems;
        ArrayList arrayList3 = arrayList2;
        mediaChooseConfig2 = this.this$0.config;
        if (mediaChooseConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
            mediaChooseConfig2 = null;
        }
        mediaGridAdapter.submit(arrayList3, mediaChooseConfig2.getShowCamera());
        mediaGridAdapter2 = this.this$0.adapter;
        if (mediaGridAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            mediaGridAdapter2 = null;
        }
        mediaSelection = this.this$0.selection;
        if (mediaSelection == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selection");
        } else {
            mediaSelection2 = mediaSelection;
        }
        mediaGridAdapter2.updateSelection(mediaSelection2);
        return Unit.INSTANCE;
    }
}
