package com.bytedance.sdk.xbridge.cn.websocket.utils;

import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient;
import com.bytedance.sdk.xbridge.cn.XBridge;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BdpWsClientImpl implements BdpWsClient {
    private final IWsClient mWsClient;

    private static int originType2SocketDataType(int i) {
        if (i == 1) {
            return 1;
        }
        return i == 2 ? 2 : 0;
    }

    private static int socketDataType2OriginType(int i) {
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                return 0;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BdpWsClientImpl(IWsClient iWsClient) {
        this.mWsClient = iWsClient;
    }

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.BdpWsClient
    public void openConnection(Map<String, String> map, Map<String, String> map2, List<String> list, boolean z, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.mWsClient.openConnection(map, map2, list, z, z2);
    }

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.BdpWsClient
    public boolean isConnected() {
        return this.mWsClient.isConnected();
    }

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.BdpWsClient
    public void stopConnection() {
        this.mWsClient.stopConnection();
    }

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.BdpWsClient
    public boolean sendMessage(byte[] bArr, int i) {
        try {
            return this.mWsClient.sendMessage(bArr, socketDataType2OriginType(i));
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            XBridge.log(message);
            return false;
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.BdpWsClient
    public void onParameterChange(Map<String, String> map, Map<String, String> map2, List<String> list, boolean z, boolean z2) {
        this.mWsClient.onParameterChange(map, map2, list, z, z2);
    }
}
