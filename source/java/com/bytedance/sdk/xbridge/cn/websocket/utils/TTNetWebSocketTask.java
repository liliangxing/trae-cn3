package com.bytedance.sdk.xbridge.cn.websocket.utils;

import android.content.Context;
import com.bytedance.sdk.account.platform.api.IWeiboService;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.websocket.utils.BdpWsClient;
import com.bytedance.sdk.xbridge.cn.websocket.utils.SocketRequest;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TTNetWebSocketTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J$\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u001bj\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011`\u001cH\u0002J\b\u0010\u001d\u001a\u00020\rH\u0014J\b\u0010\u001e\u001a\u00020\rH\u0014R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/utils/TTNetWebSocketTask;", "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/BaseWebSocketTask;", "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/BdpWsClient$OnStateChangeListener;", "context", "Landroid/content/Context;", "requestTask", "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest$RequestTask;", "(Landroid/content/Context;Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest$RequestTask;)V", "mTmaWsClient", "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/BdpWsClient;", "isWsConnected", "", "onConnStateChange", "", "state", "", IWeixinService.ResponseConstants.URL, "", "jsonStr", "onMessage", "data", "", DBData.FIELD_TYPE, "sendMessage", "byteData", "msg", "setupHeader", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "startConnectReal", "stopConnectReal", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TTNetWebSocketTask extends BaseWebSocketTask implements BdpWsClient.OnStateChangeListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private BdpWsClient mTmaWsClient;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TTNetWebSocketTask(Context context, SocketRequest.RequestTask requestTask) {
        super(context, requestTask);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(requestTask, "requestTask");
    }

    /* compiled from: TTNetWebSocketTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/websocket/utils/TTNetWebSocketTask$Companion;", "", "()V", "tryNewInst", "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/TTNetWebSocketTask;", "context", "Landroid/content/Context;", "requestTask", "Lcom/bytedance/sdk/xbridge/cn/websocket/utils/SocketRequest$RequestTask;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TTNetWebSocketTask tryNewInst(Context context, SocketRequest.RequestTask requestTask) {
            Unit unit;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(requestTask, "requestTask");
            TTNetWebSocketTask tTNetWebSocketTask = new TTNetWebSocketTask(context, requestTask);
            BdpWsClient createWsClient = TTNetWebSocketUtil.createWsClient(tTNetWebSocketTask);
            if (createWsClient != null) {
                Intrinsics.checkNotNullExpressionValue(createWsClient, "createWsClient(this)");
                tTNetWebSocketTask.mTmaWsClient = createWsClient;
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                return null;
            }
            return tTNetWebSocketTask;
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.BaseWebSocketTask
    protected void startConnectReal() {
        BdpWsClient bdpWsClient = this.mTmaWsClient;
        if (bdpWsClient != null) {
            bdpWsClient.openConnection(new HashMap(), setupHeader(), CollectionsKt.listOf(getRequestTask().url), false, false);
        }
    }

    private final HashMap<String, String> setupHeader() {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        JSONObject jSONObject = getRequestTask().header;
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                if (!(next.length() == 0)) {
                    HashMap<String, String> hashMap2 = hashMap;
                    Object opt = jSONObject.opt(next);
                    if (opt == null || (str = opt.toString()) == null) {
                        str = "";
                    }
                    hashMap2.put(next, str);
                }
            }
        }
        JSONArray jSONArray = getRequestTask().protocols;
        if (jSONArray != null) {
            int length = jSONArray.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sb.append(jSONArray.optString(i));
                if (i != length - 1) {
                    sb.append(IWeiboService.Scope.EMPTY_SCOPE);
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "protocolBuilder.toString()");
            if (sb2.length() > 0) {
                hashMap.put("Sec-WebSocket-Protocol", sb2);
            }
        }
        return hashMap;
    }

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.BaseWebSocketTask
    protected void stopConnectReal() {
        try {
            try {
                BdpWsClient bdpWsClient = this.mTmaWsClient;
                if (bdpWsClient != null) {
                    bdpWsClient.stopConnection();
                }
            } finally {
                onClosed(false);
            }
        } catch (Throwable unused) {
            XBridge.log("Task.ttnet:stopConnection error");
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.IWebSocketTask
    public boolean isWsConnected() {
        BdpWsClient bdpWsClient = this.mTmaWsClient;
        return (bdpWsClient != null && bdpWsClient.isConnected()) && getCurrentStatus() == 1;
    }

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.IWebSocketTask
    public String sendMessage(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (!isWsConnected()) {
            return "the socket is disconnected";
        }
        BdpWsClient bdpWsClient = this.mTmaWsClient;
        if (bdpWsClient != null) {
            Charset charset = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(charset, "UTF_8");
            byte[] bytes = msg.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            bdpWsClient.sendMessage(bytes, 1);
        }
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.IWebSocketTask
    public String sendMessage(byte[] byteData) {
        Intrinsics.checkNotNullParameter(byteData, "byteData");
        if (!isWsConnected()) {
            return "the socket is disconnected";
        }
        BdpWsClient bdpWsClient = this.mTmaWsClient;
        if (bdpWsClient != null) {
            bdpWsClient.sendMessage(byteData, 2);
        }
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.BdpWsClient.OnStateChangeListener
    public void onConnStateChange(int state, String url, String jsonStr) {
        Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
        boolean z = true;
        if (state != 2) {
            if (state == 3) {
                onClosed(true);
                return;
            } else {
                if (state != 4) {
                    return;
                }
                onConnected();
                return;
            }
        }
        String str = jsonStr;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            onFailed("unknown error");
        } else {
            onFailed(jsonStr);
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.BdpWsClient.OnStateChangeListener
    public void onMessage(byte[] data, int type) {
        String str;
        if (1 == type) {
            if (data != null) {
                Charset charset = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(charset, "UTF_8");
                str = new String(data, charset);
            } else {
                str = "";
            }
            onReceivedMessage(str);
            return;
        }
        if (data == null) {
            data = new byte[0];
        }
        onReceivedMessage(data);
    }
}
