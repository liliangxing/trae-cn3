package com.bytedance.trae.conversation.mediachoose.data;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.conversation.mediachoose.model.MediaItem;
import com.bytedance.trae.conversation.mediachoose.model.MediaType;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.mediachoose.data.MediaStoreRepository$loadMediaPage$2", f = "MediaStoreRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MediaStoreRepository$loadMediaPage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends MediaItem>>, Object> {
    final /* synthetic */ long $bucketId;
    final /* synthetic */ int $limit;
    final /* synthetic */ MediaType $mediaType;
    final /* synthetic */ int $offset;
    int label;
    final /* synthetic */ MediaStoreRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaStoreRepository$loadMediaPage$2(long j, int i, MediaStoreRepository mediaStoreRepository, MediaType mediaType, int i2, Continuation<? super MediaStoreRepository$loadMediaPage$2> continuation) {
        super(2, continuation);
        this.$bucketId = j;
        this.$limit = i;
        this.this$0 = mediaStoreRepository;
        this.$mediaType = mediaType;
        this.$offset = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MediaStoreRepository$loadMediaPage$2(this.$bucketId, this.$limit, this.this$0, this.$mediaType, this.$offset, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<MediaItem>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Cursor queryMediaCursor;
        Cursor cursor;
        Throwable th;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        long j = this.$bucketId;
        Long boxLong = j == -1 ? null : Boxing.boxLong(j);
        ArrayList arrayList = new ArrayList(this.$limit);
        queryMediaCursor = this.this$0.queryMediaCursor(boxLong, this.$mediaType, this.$offset, this.$limit);
        Cursor cursor2 = queryMediaCursor;
        try {
            Cursor cursor3 = cursor2;
            if (cursor3 == null) {
                try {
                    List emptyList = CollectionsKt.emptyList();
                    CloseableKt.closeFinally(cursor2, (Throwable) null);
                    return emptyList;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursor2;
                }
            } else {
                int columnIndexOrThrow = cursor3.getColumnIndexOrThrow("_id");
                int columnIndexOrThrow2 = cursor3.getColumnIndexOrThrow("mime_type");
                int columnIndexOrThrow3 = cursor3.getColumnIndexOrThrow("width");
                int columnIndexOrThrow4 = cursor3.getColumnIndexOrThrow("height");
                int columnIndexOrThrow5 = cursor3.getColumnIndexOrThrow("_size");
                int columnIndex = cursor3.getColumnIndex("_display_name");
                int columnIndexOrThrow6 = cursor3.getColumnIndexOrThrow("bucket_id");
                int columnIndexOrThrow7 = cursor3.getColumnIndexOrThrow("bucket_display_name");
                int columnIndexOrThrow8 = cursor3.getColumnIndexOrThrow(ReportConstant.COMMON_INIT_DURATION);
                int columnIndexOrThrow9 = cursor3.getColumnIndexOrThrow("media_type");
                while (cursor3.moveToNext()) {
                    Cursor cursor4 = cursor2;
                    try {
                        long j2 = cursor3.getLong(columnIndexOrThrow);
                        Uri withAppendedId = ContentUris.withAppendedId(MediaStore.Files.getContentUri("external"), j2);
                        int i = columnIndexOrThrow;
                        Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(...)");
                        long j3 = cursor3.getLong(columnIndexOrThrow6);
                        String string = cursor3.getString(columnIndexOrThrow7);
                        if (string == null) {
                            string = "";
                        }
                        String str = string;
                        int i2 = columnIndexOrThrow6;
                        boolean z = cursor3.getInt(columnIndexOrThrow9) == 3;
                        arrayList.add(new MediaItem(j2, withAppendedId, cursor3.getString(columnIndexOrThrow2), cursor3.getLong(columnIndexOrThrow8), j3, str, cursor3.getInt(columnIndexOrThrow3), cursor3.getInt(columnIndexOrThrow4), cursor3.getLong(columnIndexOrThrow5), z, columnIndex != -1 ? cursor3.getString(columnIndex) : null));
                        cursor2 = cursor4;
                        columnIndexOrThrow = i;
                        columnIndexOrThrow6 = i2;
                    } catch (Throwable th3) {
                        th = th3;
                        cursor = cursor4;
                    }
                }
                Cursor cursor5 = cursor2;
                try {
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursor5, (Throwable) null);
                    return arrayList;
                } catch (Throwable th4) {
                    th = th4;
                    cursor = cursor5;
                    th = th;
                    throw th;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            cursor = cursor2;
        }
        try {
            throw th;
        } catch (Throwable th6) {
            CloseableKt.closeFinally(cursor, th);
            throw th6;
        }
    }
}
