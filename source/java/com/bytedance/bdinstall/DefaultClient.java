package com.bytedance.bdinstall;

import android.util.Pair;
import com.bytedance.bdinstall.network.TTResponse;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class DefaultClient implements INetworkClient {
    private final DefaultClientWrapper defaultTicketClient = new DefaultClientWrapper();

    @Override // com.bytedance.bdinstall.INetworkClient
    public String get(String str, Map<String, String> map) throws Exception {
        TTResponse tTResponse = this.defaultTicketClient.get(str, map);
        return tTResponse != null ? tTResponse.getBody() : "";
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String str, byte[] bArr, Map<String, String> map) throws Exception {
        TTResponse post = this.defaultTicketClient.post(str, bArr, map);
        return post != null ? post.getBody() : "";
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String str, byte[] bArr, String str2) throws Exception {
        TTResponse post = this.defaultTicketClient.post(str, bArr, str2);
        return post != null ? post.getBody() : "";
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String str, List<Pair<String, String>> list) throws Exception {
        TTResponse post = this.defaultTicketClient.post(str, list);
        return post != null ? post.getBody() : "";
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public byte[] postStream(String str, byte[] bArr, Map<String, String> map) throws RangersHttpException {
        return this.defaultTicketClient.postStream(str, bArr, map);
    }
}
