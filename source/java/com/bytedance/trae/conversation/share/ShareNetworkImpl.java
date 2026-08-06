package com.bytedance.trae.conversation.share;

import com.bytedance.common.utility.NetworkClient;
import com.bytedance.trae.conversation.voice.VoiceChatApiPaths;
import com.bytedance.ug.sdk.share.api.depend.IShareNetworkConfig;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* compiled from: ShareNetworkImpl.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016J \u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/share/ShareNetworkImpl;", "Lcom/bytedance/ug/sdk/share/api/depend/IShareNetworkConfig;", "<init>", "()V", "getHost", "", "executeGet", "maxLength", "", "strUrl", "executePost", "json", "Lorg/json/JSONObject;", "checkResponseException", "e", "", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShareNetworkImpl implements IShareNetworkConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Override // com.bytedance.ug.sdk.share.api.depend.IShareNetworkConfig
    public int checkResponseException(Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        return 0;
    }

    @Override // com.bytedance.ug.sdk.share.api.depend.IShareNetworkConfig
    public String getHost() {
        return "";
    }

    @Override // com.bytedance.ug.sdk.share.api.depend.IShareNetworkConfig
    public String executeGet(int maxLength, String strUrl) throws Exception {
        Intrinsics.checkNotNullParameter(strUrl, "strUrl");
        String str = NetworkClient.getDefault().get(strUrl);
        Intrinsics.checkNotNull(str);
        return str;
    }

    @Override // com.bytedance.ug.sdk.share.api.depend.IShareNetworkConfig
    public String executePost(int maxLength, String strUrl, JSONObject json) throws Exception {
        Intrinsics.checkNotNullParameter(strUrl, "strUrl");
        Intrinsics.checkNotNullParameter(json, "json");
        NetworkClient networkClient = NetworkClient.getDefault();
        String jSONObject = json.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
        byte[] bytes = jSONObject.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String post = networkClient.post(strUrl, bytes, false, VoiceChatApiPaths.HeaderValue.CONTENT_TYPE_JSON, true);
        Intrinsics.checkNotNullExpressionValue(post, "post(...)");
        return post;
    }

    /* compiled from: ShareNetworkImpl.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/share/ShareNetworkImpl$Companion;", "", "<init>", "()V", "readStream", "", "in", "Ljava/io/InputStream;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final String readStream(InputStream in) throws Exception {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = in.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    in.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
                    return new String(byteArray, Charsets.UTF_8);
                }
            }
        }
    }
}
