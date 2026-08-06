package com.bytedance.kmp.network.requet;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import org.bouncycastle.cms.CMSAttributeTableGenerator;

/* compiled from: RequestBody.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/kmp/network/requet/RequestBody;", "", "()V", "contentLength", "", CMSAttributeTableGenerator.CONTENT_TYPE, "", "isStreamingUpload", "", "writeChunkTo", "sink", "Lokio/BufferedSink;", "maxSize", "", "writeTo", "", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class RequestBody {
    public long contentLength() {
        return -1L;
    }

    public abstract String contentType();

    public boolean isStreamingUpload() {
        return false;
    }

    public boolean writeChunkTo(BufferedSink sink, int maxSize) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return true;
    }

    public abstract void writeTo(BufferedSink sink);
}
