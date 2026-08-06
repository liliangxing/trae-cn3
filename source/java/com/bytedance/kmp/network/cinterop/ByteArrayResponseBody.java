package com.bytedance.kmp.network.cinterop;

import com.bytedance.kmp.network.response.ResponseBody;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.Buffer;
import okio.Source;

/* compiled from: KmpNativeNetworkService.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/kmp/network/cinterop/ByteArrayResponseBody;", "Lcom/bytedance/kmp/network/response/ResponseBody;", "byteArray", "", "contentType", "", "([BLjava/lang/String;)V", "byteStream", "Lokio/Source;", "contentLength", "", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ByteArrayResponseBody extends ResponseBody {
    private final byte[] byteArray;
    private final String contentType;

    public /* synthetic */ ByteArrayResponseBody(byte[] bArr, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, (i & 2) != 0 ? null : str);
    }

    public ByteArrayResponseBody(byte[] bArr, String str) {
        this.byteArray = bArr;
        this.contentType = str;
    }

    @Override // com.bytedance.kmp.network.response.ResponseBody
    /* renamed from: contentType, reason: from getter */
    public String getContentType() {
        return this.contentType;
    }

    @Override // com.bytedance.kmp.network.response.ResponseBody
    public long contentLength() {
        if (this.byteArray != null) {
            return r0.length;
        }
        return 0L;
    }

    @Override // com.bytedance.kmp.network.response.ResponseBody
    public Source byteStream() {
        Buffer buffer = new Buffer();
        byte[] bArr = this.byteArray;
        if (bArr == null) {
            bArr = new byte[0];
        }
        return buffer.write(bArr);
    }
}
