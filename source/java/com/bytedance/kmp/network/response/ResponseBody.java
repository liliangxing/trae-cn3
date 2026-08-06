package com.bytedance.kmp.network.response;

import android.support.v4.media.session.PlaybackStateCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import okio.Buffer;
import okio.Source;
import org.bouncycastle.cms.CMSAttributeTableGenerator;

/* compiled from: ResponseBody.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\tJ\b\u0010\n\u001a\u00020\u000bH&J\n\u0010\f\u001a\u0004\u0018\u00010\rH&J\b\u0010\u000e\u001a\u0004\u0018\u00010\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/kmp/network/response/ResponseBody;", "", "()V", "byteStream", "Lokio/Source;", "byteStream2Buffer", "Lokio/Buffer;", "source", "bytes", "", "contentLength", "", CMSAttributeTableGenerator.CONTENT_TYPE, "", "string", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class ResponseBody {
    public abstract Source byteStream();

    public abstract long contentLength();

    public abstract String contentType();

    private final Buffer byteStream2Buffer(Source source) {
        if (source == null) {
            return null;
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = new Buffer();
        try {
            try {
                Ref.LongRef longRef = new Ref.LongRef();
                while (true) {
                    long read = source.read(buffer2, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                    longRef.element = read;
                    if (read != -1) {
                        buffer.write(buffer2, longRef.element);
                    } else {
                        buffer.flush();
                        return buffer;
                    }
                }
            } catch (Exception e) {
                buffer.close();
                throw e;
            }
        } finally {
            source.close();
            buffer2.close();
        }
    }

    public final byte[] bytes() {
        Buffer byteStream2Buffer = byteStream2Buffer(byteStream());
        if (byteStream2Buffer == null) {
            return null;
        }
        try {
            return byteStream2Buffer.readByteArray();
        } finally {
            byteStream2Buffer.close();
        }
    }

    public final String string() {
        Buffer byteStream2Buffer = byteStream2Buffer(byteStream());
        if (byteStream2Buffer == null) {
            return null;
        }
        try {
            return byteStream2Buffer.readUtf8();
        } finally {
            byteStream2Buffer.close();
        }
    }
}
