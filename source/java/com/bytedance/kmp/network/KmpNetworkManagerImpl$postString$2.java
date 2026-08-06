package com.bytedance.kmp.network;

import com.bytedance.kmp.network.requet.RequestBody;
import kotlin.Metadata;
import okio.BufferedSink;
import org.bouncycastle.cms.CMSAttributeTableGenerator;

/* compiled from: KmpNetworkManagerImpl.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/bytedance/kmp/network/KmpNetworkManagerImpl$postString$2", "Lcom/bytedance/kmp/network/requet/RequestBody;", CMSAttributeTableGenerator.CONTENT_TYPE, "", "writeTo", "", "sink", "Lokio/BufferedSink;", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 176)
/* loaded from: classes4.dex */
public final class KmpNetworkManagerImpl$postString$2 extends RequestBody {
    final /* synthetic */ String $content;
    final /* synthetic */ String $contentType;

    public KmpNetworkManagerImpl$postString$2(String str, String str2) {
        this.$contentType = str;
        this.$content = str2;
    }

    @Override // com.bytedance.kmp.network.requet.RequestBody
    /* renamed from: contentType, reason: from getter */
    public String get$contentType() {
        return this.$contentType;
    }

    @Override // com.bytedance.kmp.network.requet.RequestBody
    public void writeTo(BufferedSink sink) {
        if (sink != null) {
            sink.writeUtf8(this.$content);
        }
        if (sink != null) {
            sink.flush();
        }
    }
}
