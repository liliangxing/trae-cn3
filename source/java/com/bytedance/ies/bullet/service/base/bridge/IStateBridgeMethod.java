package com.bytedance.ies.bullet.service.base.bridge;

import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.ies.bullet.service.base.IReleasable;
import com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod;
import io.noties.markwon.html.jsoup.nodes.DocumentType;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: BridgeMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \n2\u00020\u00012\u00020\u0002:\u0003\t\n\u000bJ\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/bridge/IStateBridgeMethod;", "Lcom/bytedance/ies/bullet/service/base/IReleasable;", "Lcom/bytedance/ies/bullet/service/base/bridge/IGenericBridgeMethod;", "handle", "", "params", "Lorg/json/JSONObject;", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/ies/bullet/service/base/bridge/IStateBridgeMethod$ICallback;", "Access", "Companion", "ICallback", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IStateBridgeMethod extends IReleasable, IGenericBridgeMethod {
    public static final int CODE_BRIDGE_METHOD_NOT_FOUND = -2;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* compiled from: BridgeMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/bridge/IStateBridgeMethod$Access;", "", "(Ljava/lang/String;I)V", DocumentType.PUBLIC_KEY, "PRIVATE", "PROTECT", "SECURE", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public enum Access {
        PUBLIC,
        PRIVATE,
        PROTECT,
        SECURE
    }

    /* compiled from: BridgeMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/bridge/IStateBridgeMethod$ICallback;", "Lcom/bytedance/ies/bullet/service/base/bridge/IGenericBridgeMethod$ICallback;", "finishCall", "", "value", "", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public interface ICallback extends IGenericBridgeMethod.ICallback {
        void finishCall(String value);

        void finishCall(JSONObject value);
    }

    void handle(JSONObject params, ICallback callback);

    /* compiled from: BridgeMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/bridge/IStateBridgeMethod$Companion;", "", "()V", "CODE_BRIDGE_METHOD_NOT_FOUND", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int CODE_BRIDGE_METHOD_NOT_FOUND = -2;

        private Companion() {
        }
    }
}
