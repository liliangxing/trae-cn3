package com.bytedance.trae.conversation.mediachoose.data;

import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.conversation.mediachoose.model.AlbumBucket;
import com.bytedance.trae.conversation.mediachoose.model.MediaItem;
import com.bytedance.trae.conversation.mediachoose.model.MediaType;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: MediaStoreRepository.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000bJ4\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0013J1\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "loadBuckets", "", "Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;", "mediaType", "Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;", "(Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadMediaPage", "Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;", "bucketId", "", "offset", "", "limit", "(JLcom/bytedance/trae/conversation/mediachoose/model/MediaType;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryMediaCursor", "Landroid/database/Cursor;", "(Ljava/lang/Long;Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;II)Landroid/database/Cursor;", "MutableBucket", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MediaStoreRepository {
    public static final long BUCKET_ALL = -1;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Context context;

    /* compiled from: MediaStoreRepository.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MediaType.values().length];
            try {
                iArr[MediaType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaType.ALL_EXCLUSIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MediaType.IMAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MediaType.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public MediaStoreRepository(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final Object loadBuckets(MediaType mediaType, Continuation<? super List<AlbumBucket>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MediaStoreRepository$loadBuckets$2(this, mediaType, null), continuation);
    }

    public final Object loadMediaPage(long j, MediaType mediaType, int i, int i2, Continuation<? super List<MediaItem>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MediaStoreRepository$loadMediaPage$2(j, i2, this, mediaType, i, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Cursor queryMediaCursor(Long bucketId, MediaType mediaType, int offset, int limit) {
        StringBuilder sb = new StringBuilder("(");
        ArrayList arrayList = new ArrayList();
        int i = WhenMappings.$EnumSwitchMapping$0[mediaType.ordinal()];
        if (i == 1 || i == 2) {
            sb.append("media_type=? OR media_type=?");
            arrayList.add("1");
            arrayList.add(OnekeyLoginConstants.TELECOM_TYPE);
        } else if (i == 3) {
            sb.append("media_type=?");
            arrayList.add("1");
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            sb.append("media_type=?");
            arrayList.add(OnekeyLoginConstants.TELECOM_TYPE);
        }
        sb.append(") AND _size>0");
        if (bucketId != null) {
            sb.append(" AND bucket_id=?");
            arrayList.add(bucketId.toString());
        }
        String[] strArr = {"_id", "media_type", "mime_type", "width", "height", "_size", "_display_name", "bucket_id", "bucket_display_name", ReportConstant.COMMON_INIT_DURATION, "date_added", "_display_name"};
        Uri contentUri = MediaStore.Files.getContentUri("external");
        if (Build.VERSION.SDK_INT >= 26) {
            Bundle bundle = new Bundle();
            bundle.putString("android:query-arg-sql-selection", sb.toString());
            bundle.putStringArray("android:query-arg-sql-selection-args", (String[]) arrayList.toArray(new String[0]));
            bundle.putStringArray("android:query-arg-sort-columns", new String[]{"date_added"});
            bundle.putInt("android:query-arg-sort-direction", 1);
            bundle.putInt("android:query-arg-limit", limit);
            bundle.putInt("android:query-arg-offset", offset);
            return this.context.getContentResolver().query(contentUri, strArr, bundle, null);
        }
        Cursor query = this.context.getContentResolver().query(contentUri, strArr, sb.toString(), (String[]) arrayList.toArray(new String[0]), "date_added DESC");
        if (query != null && offset > 0) {
            query.moveToPosition(offset - 1);
        }
        return query;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MediaStoreRepository.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$MutableBucket;", "", "id", "", "name", "", "count", "", "coverUri", "Landroid/net/Uri;", "<init>", "(JLjava/lang/String;ILandroid/net/Uri;)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getCount", "()I", "setCount", "(I)V", "getCoverUri", "()Landroid/net/Uri;", "setCoverUri", "(Landroid/net/Uri;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class MutableBucket {
        private int count;
        private Uri coverUri;
        private final long id;
        private final String name;

        public static /* synthetic */ MutableBucket copy$default(MutableBucket mutableBucket, long j, String str, int i, Uri uri, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = mutableBucket.id;
            }
            long j2 = j;
            if ((i2 & 2) != 0) {
                str = mutableBucket.name;
            }
            String str2 = str;
            if ((i2 & 4) != 0) {
                i = mutableBucket.count;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                uri = mutableBucket.coverUri;
            }
            return mutableBucket.copy(j2, str2, i3, uri);
        }

        /* renamed from: component1, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component3, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        /* renamed from: component4, reason: from getter */
        public final Uri getCoverUri() {
            return this.coverUri;
        }

        public final MutableBucket copy(long id, String name, int count, Uri coverUri) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new MutableBucket(id, name, count, coverUri);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MutableBucket)) {
                return false;
            }
            MutableBucket mutableBucket = (MutableBucket) other;
            return this.id == mutableBucket.id && Intrinsics.areEqual(this.name, mutableBucket.name) && this.count == mutableBucket.count && Intrinsics.areEqual(this.coverUri, mutableBucket.coverUri);
        }

        public int hashCode() {
            int hashCode = ((((Long.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.count)) * 31;
            Uri uri = this.coverUri;
            return hashCode + (uri == null ? 0 : uri.hashCode());
        }

        public String toString() {
            return "MutableBucket(id=" + this.id + ", name=" + this.name + ", count=" + this.count + ", coverUri=" + this.coverUri + ')';
        }

        public MutableBucket(long j, String str, int i, Uri uri) {
            Intrinsics.checkNotNullParameter(str, "name");
            this.id = j;
            this.name = str;
            this.count = i;
            this.coverUri = uri;
        }

        public /* synthetic */ MutableBucket(long j, String str, int i, Uri uri, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, str, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? null : uri);
        }

        public final long getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final int getCount() {
            return this.count;
        }

        public final void setCount(int i) {
            this.count = i;
        }

        public final Uri getCoverUri() {
            return this.coverUri;
        }

        public final void setCoverUri(Uri uri) {
            this.coverUri = uri;
        }
    }

    /* compiled from: MediaStoreRepository.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository$Companion;", "", "<init>", "()V", "BUCKET_ALL", "", "queryMediaItem", "Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "queryMediaItemFromMediaStore", "queryMediaItemFromProvider", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0024 A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:3:0x000c, B:5:0x0013, B:9:0x0024, B:12:0x0038, B:16:0x003d), top: B:2:0x000c }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final MediaItem queryMediaItem(Context context, Uri uri) {
            boolean z;
            MediaItem queryMediaItemFromProvider;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            try {
                String authority = uri.getAuthority();
                if (authority != null) {
                    z = true;
                    if (StringsKt.contains(authority, "fileprovider", true)) {
                        if (!z) {
                            String uri2 = uri.toString();
                            Intrinsics.checkNotNullExpressionValue(uri2, "toString(...)");
                            if (StringsKt.startsWith$default(uri2, "content://media/", false, 2, (Object) null)) {
                                queryMediaItemFromProvider = queryMediaItemFromMediaStore(context, uri);
                                return queryMediaItemFromProvider;
                            }
                        }
                        queryMediaItemFromProvider = queryMediaItemFromProvider(context, uri);
                        return queryMediaItemFromProvider;
                    }
                }
                z = false;
                if (!z) {
                }
                queryMediaItemFromProvider = queryMediaItemFromProvider(context, uri);
                return queryMediaItemFromProvider;
            } catch (Throwable unused) {
                return null;
            }
        }

        private final MediaItem queryMediaItemFromMediaStore(Context context, Uri uri) {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_id", "mime_type", "width", "height", "_size", "_display_name"}, null, null, null);
            if (query == null) {
                return null;
            }
            Cursor cursor = query;
            try {
                Cursor cursor2 = cursor;
                if (!cursor2.moveToFirst()) {
                    CloseableKt.closeFinally(cursor, (Throwable) null);
                    return null;
                }
                long j = cursor2.getLong(cursor2.getColumnIndexOrThrow("_id"));
                String string = cursor2.getString(cursor2.getColumnIndexOrThrow("mime_type"));
                int i = cursor2.getInt(cursor2.getColumnIndexOrThrow("width"));
                int i2 = cursor2.getInt(cursor2.getColumnIndexOrThrow("height"));
                long j2 = cursor2.getLong(cursor2.getColumnIndexOrThrow("_size"));
                int columnIndexOrThrow = cursor2.getColumnIndexOrThrow("_display_name");
                MediaItem mediaItem = new MediaItem(j, uri, string, 0L, 0L, "", i, i2, j2, false, columnIndexOrThrow != -1 ? cursor2.getString(columnIndexOrThrow) : null);
                CloseableKt.closeFinally(cursor, (Throwable) null);
                return mediaItem;
            } finally {
            }
        }

        private final MediaItem queryMediaItemFromProvider(Context context, Uri uri) {
            Cursor cursor;
            Throwable th;
            Cursor query = context.getContentResolver().query(uri, new String[]{"_display_name", "_size"}, null, null, null);
            if (query == null) {
                return null;
            }
            Cursor cursor2 = query;
            try {
                Cursor cursor3 = cursor2;
                if (!cursor3.moveToFirst()) {
                    CloseableKt.closeFinally(cursor2, (Throwable) null);
                    return null;
                }
                long j = cursor3.getLong(cursor3.getColumnIndexOrThrow("_size"));
                String string = cursor3.getString(cursor3.getColumnIndexOrThrow("_display_name"));
                String type = context.getContentResolver().getType(uri);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                if (openInputStream != null) {
                    try {
                        InputStream inputStream = openInputStream;
                        try {
                            BitmapFactory.decodeStream(inputStream, null, options);
                            CloseableKt.closeFinally(inputStream, (Throwable) null);
                        } finally {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursor2;
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            CloseableKt.closeFinally(cursor, th);
                            throw th3;
                        }
                    }
                }
                try {
                    MediaItem mediaItem = new MediaItem(0L, uri, type, 0L, 0L, "", options.outWidth, options.outHeight, j, false, string);
                    CloseableKt.closeFinally(cursor2, (Throwable) null);
                    return mediaItem;
                } catch (Throwable th4) {
                    th = th4;
                    cursor = cursor2;
                    th = th;
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                cursor = cursor2;
            }
        }
    }
}
