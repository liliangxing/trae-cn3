package com.bytedance.ies.bullet.kit.resourceloader;

import android.net.Uri;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ResourceMetaData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/StreamMetaInfo;", "Lcom/bytedance/ies/bullet/kit/resourceloader/BasicMetaInfo;", "stream", "Ljava/io/InputStream;", "from", "Lcom/bytedance/ies/bullet/service/base/ResourceFrom;", "streamPathUri", "Landroid/net/Uri;", "(Ljava/io/InputStream;Lcom/bytedance/ies/bullet/service/base/ResourceFrom;Landroid/net/Uri;)V", "getFrom", "()Lcom/bytedance/ies/bullet/service/base/ResourceFrom;", "setFrom", "(Lcom/bytedance/ies/bullet/service/base/ResourceFrom;)V", "getStream", "()Ljava/io/InputStream;", "getStreamPathUri", "()Landroid/net/Uri;", "setStreamPathUri", "(Landroid/net/Uri;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class StreamMetaInfo extends BasicMetaInfo {
    private ResourceFrom from;
    private final InputStream stream;
    private Uri streamPathUri;

    public /* synthetic */ StreamMetaInfo(InputStream inputStream, ResourceFrom resourceFrom, Uri uri, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(inputStream, (i & 2) != 0 ? null : resourceFrom, (i & 4) != 0 ? null : uri);
    }

    public final InputStream getStream() {
        return this.stream;
    }

    public final ResourceFrom getFrom() {
        return this.from;
    }

    public final void setFrom(ResourceFrom resourceFrom) {
        this.from = resourceFrom;
    }

    public final Uri getStreamPathUri() {
        return this.streamPathUri;
    }

    public final void setStreamPathUri(Uri uri) {
        this.streamPathUri = uri;
    }

    public StreamMetaInfo(InputStream inputStream, ResourceFrom resourceFrom, Uri uri) {
        this.stream = inputStream;
        this.from = resourceFrom;
        this.streamPathUri = uri;
    }
}
