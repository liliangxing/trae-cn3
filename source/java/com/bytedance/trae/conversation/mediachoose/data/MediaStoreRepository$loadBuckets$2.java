package com.bytedance.trae.conversation.mediachoose.data;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.bytedance.trae.conversation.mediachoose.data.MediaStoreRepository;
import com.bytedance.trae.conversation.mediachoose.model.AlbumBucket;
import com.bytedance.trae.conversation.mediachoose.model.MediaType;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaStoreRepository.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.mediachoose.data.MediaStoreRepository$loadBuckets$2", f = "MediaStoreRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MediaStoreRepository$loadBuckets$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends AlbumBucket>>, Object> {
    final /* synthetic */ MediaType $mediaType;
    int label;
    final /* synthetic */ MediaStoreRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaStoreRepository$loadBuckets$2(MediaStoreRepository mediaStoreRepository, MediaType mediaType, Continuation<? super MediaStoreRepository$loadBuckets$2> continuation) {
        super(2, continuation);
        this.this$0 = mediaStoreRepository;
        this.$mediaType = mediaType;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MediaStoreRepository$loadBuckets$2(this.this$0, this.$mediaType, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<AlbumBucket>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Cursor queryMediaCursor;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        queryMediaCursor = this.this$0.queryMediaCursor(null, this.$mediaType, 0, 2000);
        Cursor cursor = queryMediaCursor;
        try {
            Cursor cursor2 = cursor;
            if (cursor2 == null) {
                List emptyList = CollectionsKt.emptyList();
                CloseableKt.closeFinally(cursor, (Throwable) null);
                return emptyList;
            }
            int columnIndexOrThrow = cursor2.getColumnIndexOrThrow("bucket_id");
            int columnIndexOrThrow2 = cursor2.getColumnIndexOrThrow("bucket_display_name");
            int columnIndexOrThrow3 = cursor2.getColumnIndexOrThrow("_id");
            while (cursor2.moveToNext()) {
                long j = cursor2.getLong(columnIndexOrThrow3);
                long j2 = cursor2.getLong(columnIndexOrThrow);
                String string = cursor2.getString(columnIndexOrThrow2);
                if (string == null) {
                    string = "";
                }
                String str = string;
                Uri withAppendedId = ContentUris.withAppendedId(MediaStore.Files.getContentUri("external"), j);
                Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(...)");
                LinkedHashMap linkedHashMap2 = linkedHashMap;
                Long boxLong = Boxing.boxLong(j2);
                Object obj2 = linkedHashMap2.get(boxLong);
                if (obj2 == null) {
                    obj2 = new MediaStoreRepository.MutableBucket(j2, str, 0, withAppendedId, 4, null);
                    linkedHashMap2.put(boxLong, obj2);
                }
                MediaStoreRepository.MutableBucket mutableBucket = (MediaStoreRepository.MutableBucket) obj2;
                mutableBucket.setCount(mutableBucket.getCount() + 1);
                if (mutableBucket.getCoverUri() == null) {
                    mutableBucket.setCoverUri(withAppendedId);
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(cursor, (Throwable) null);
            Collection values = linkedHashMap.values();
            Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
            Collection<MediaStoreRepository.MutableBucket> collection = values;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
            for (MediaStoreRepository.MutableBucket mutableBucket2 : collection) {
                arrayList.add(new AlbumBucket(mutableBucket2.getId(), mutableBucket2.getName(), mutableBucket2.getCount(), mutableBucket2.getCoverUri()));
            }
            List sortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.bytedance.trae.conversation.mediachoose.data.MediaStoreRepository$loadBuckets$2$invokeSuspend$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((AlbumBucket) t2).getCount()), Integer.valueOf(((AlbumBucket) t).getCount()));
                }
            });
            List list = sortedWith;
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                i += ((AlbumBucket) it.next()).getCount();
            }
            AlbumBucket albumBucket = (AlbumBucket) CollectionsKt.firstOrNull(sortedWith);
            return CollectionsKt.plus(CollectionsKt.listOf(new AlbumBucket(-1L, "全部", i, albumBucket != null ? albumBucket.getCoverUri() : null)), list);
        } finally {
        }
    }
}
