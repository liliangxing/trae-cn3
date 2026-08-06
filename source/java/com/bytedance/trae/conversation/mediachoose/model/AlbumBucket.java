package com.bytedance.trae.conversation.mediachoose.model;

import android.net.Uri;
import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AlbumBucket.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;", "", "id", "", "name", "", "count", "", "coverUri", "Landroid/net/Uri;", "<init>", "(JLjava/lang/String;ILandroid/net/Uri;)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getCount", "()I", "getCoverUri", "()Landroid/net/Uri;", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AlbumBucket {
    private final int count;
    private final Uri coverUri;
    private final long id;
    private final String name;

    public static /* synthetic */ AlbumBucket copy$default(AlbumBucket albumBucket, long j, String str, int i, Uri uri, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = albumBucket.id;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            str = albumBucket.name;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            i = albumBucket.count;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            uri = albumBucket.coverUri;
        }
        return albumBucket.copy(j2, str2, i3, uri);
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

    public final AlbumBucket copy(long id, String name, int count, Uri coverUri) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new AlbumBucket(id, name, count, coverUri);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlbumBucket)) {
            return false;
        }
        AlbumBucket albumBucket = (AlbumBucket) other;
        return this.id == albumBucket.id && Intrinsics.areEqual(this.name, albumBucket.name) && this.count == albumBucket.count && Intrinsics.areEqual(this.coverUri, albumBucket.coverUri);
    }

    public int hashCode() {
        int hashCode = ((((Long.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.count)) * 31;
        Uri uri = this.coverUri;
        return hashCode + (uri == null ? 0 : uri.hashCode());
    }

    public String toString() {
        return "AlbumBucket(id=" + this.id + ", name=" + this.name + ", count=" + this.count + ", coverUri=" + this.coverUri + ')';
    }

    public AlbumBucket(long j, String name, int i, Uri uri) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = j;
        this.name = name;
        this.count = i;
        this.coverUri = uri;
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

    public final Uri getCoverUri() {
        return this.coverUri;
    }
}
