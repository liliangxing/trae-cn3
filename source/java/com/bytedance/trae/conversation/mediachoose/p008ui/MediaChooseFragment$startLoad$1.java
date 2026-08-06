package com.bytedance.trae.conversation.mediachoose.p008ui;

import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.conversation.databinding.TraeMediaChooseFragmentBinding;
import com.bytedance.trae.conversation.mediachoose.data.MediaStoreRepository;
import com.bytedance.trae.conversation.mediachoose.model.AlbumBucket;
import com.bytedance.trae.conversation.mediachoose.model.MediaChooseConfig;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment$startLoad$1", f = "MediaChooseFragment.kt", i = {}, l = {StatusBarUtils.FLAG_NOTCH_SUPPORT}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MediaChooseFragment$startLoad$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ MediaChooseFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaChooseFragment$startLoad$1(MediaChooseFragment mediaChooseFragment, Continuation<? super MediaChooseFragment$startLoad$1> continuation) {
        super(2, continuation);
        this.this$0 = mediaChooseFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MediaChooseFragment$startLoad$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MediaStoreRepository mediaStoreRepository;
        MediaChooseConfig mediaChooseConfig;
        MediaChooseFragment mediaChooseFragment;
        List list;
        List list2;
        TraeMediaChooseFragmentBinding binding;
        List list3;
        long j;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        Object obj2 = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MediaChooseFragment mediaChooseFragment2 = this.this$0;
            mediaStoreRepository = mediaChooseFragment2.repository;
            if (mediaStoreRepository == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repository");
                mediaStoreRepository = null;
            }
            mediaChooseConfig = this.this$0.config;
            if (mediaChooseConfig == null) {
                Intrinsics.throwUninitializedPropertyAccessException("config");
                mediaChooseConfig = null;
            }
            this.L$0 = mediaChooseFragment2;
            this.label = 1;
            Object loadBuckets = mediaStoreRepository.loadBuckets(mediaChooseConfig.getMediaType(), (Continuation) this);
            if (loadBuckets == coroutine_suspended) {
                return coroutine_suspended;
            }
            mediaChooseFragment = mediaChooseFragment2;
            obj = loadBuckets;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mediaChooseFragment = (MediaChooseFragment) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        mediaChooseFragment.buckets = (List) obj;
        list = this.this$0.buckets;
        if (!list.isEmpty()) {
            list2 = this.this$0.buckets;
            MediaChooseFragment mediaChooseFragment3 = this.this$0;
            Iterator it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                long id = ((AlbumBucket) next).getId();
                j = mediaChooseFragment3.currentBucketId;
                if (id == j) {
                    obj2 = next;
                    break;
                }
            }
            AlbumBucket albumBucket = (AlbumBucket) obj2;
            if (albumBucket == null) {
                list3 = this.this$0.buckets;
                albumBucket = (AlbumBucket) CollectionsKt.first(list3);
            }
            this.this$0.currentBucketId = albumBucket.getId();
            binding = this.this$0.getBinding();
            binding.titleBar.setTitle(albumBucket.getName());
        }
        this.this$0.resetAndReload();
        return Unit.INSTANCE;
    }
}
