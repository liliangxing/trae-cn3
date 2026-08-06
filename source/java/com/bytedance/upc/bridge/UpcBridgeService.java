package com.bytedance.upc.bridge;

import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.XBridgeConfig;
import com.bytedance.upc.IBridgeService;
import com.bytedance.upc.common.log.LogUtils;
import kotlin.Metadata;

/* compiled from: UpcBridgeService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/upc/bridge/UpcBridgeService;", "Lcom/bytedance/upc/IBridgeService;", "()V", "init", "", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class UpcBridgeService implements IBridgeService {
    public void init() {
        LogUtils.i("init x bridge and register bridge method");
        XBridge.INSTANCE.init(new XBridgeConfig());
    }
}
