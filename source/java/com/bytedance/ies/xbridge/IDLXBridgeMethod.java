package com.bytedance.ies.xbridge;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.xbridge.model.context.XContextProviderFactory;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod;
import com.bytedance.sdk.xbridge.cn.storage.utils.UserDomainStorageConstants;
import io.noties.markwon.html.jsoup.nodes.DocumentType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.RegistrationRequest;

/* compiled from: IDLXBridgeMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \"2\u00020\u0001:\u0004 !\"#J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J\u0012\u0010\u0011\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0012\u0018\u00010\u000fH\u0016J.\u0010\u0013\u001a\u00020\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH&J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\u0012\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH&R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006$"}, d2 = {"Lcom/bytedance/ies/xbridge/IDLXBridgeMethod;", "Lcom/bytedance/sdk/xbridge/cn/protocol/StatefulMethod;", Api.KEY_ACCESS, "Lcom/bytedance/ies/xbridge/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/ies/xbridge/IDLXBridgeMethod$Access;", "name", "", "getName", "()Ljava/lang/String;", "asDouble", "", "origin", "", "provideParamModel", "Ljava/lang/Class;", "Lcom/bytedance/ies/xbridge/model/idl/XBaseParamModel;", "provideResultModel", "Lcom/bytedance/ies/xbridge/model/idl/XBaseResultModel;", "realHandle", "", "params", "", "", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/ies/xbridge/IDLXBridgeMethod$Callback;", "type", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "release", "setProviderFactory", "contextProviderFactory", "Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;", "Access", "Callback", "Companion", "JSEventDelegate", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IDLXBridgeMethod extends StatefulMethod {
    public static final int CANCELLED = -7;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int FAIL = 0;
    public static final int INVALID_PARAM = -3;
    public static final int INVALID_RESULT = -5;
    public static final int KEY_NOT_FOUND = 2;
    public static final int MALFORMEDRESPONSE_ERROR = -1003;
    public static final int NETWORK_TIMEOUT = -1002;
    public static final int NETWORK_UNREACHABLE = -1001;
    public static final int NOT_FOUND = -9;
    public static final int OPERATION_TIMEOUT = -8;
    public static final String PARAM_CODE = "code";
    public static final String PARAM_DATA = "data";
    public static final String PARAM_MSG = "msg";
    public static final int SUCCESS = 1;
    public static final int UNAUTHORIZED = -1;
    public static final int UNAUTHORIZED_ACCESS = -6;
    public static final int UNKNOWN_ERROR = -1000;
    public static final int UNREGISTERED = -2;

    /* compiled from: IDLXBridgeMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/xbridge/IDLXBridgeMethod$Callback;", "", "invoke", "", "data", "", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Callback {
        void invoke(Map<String, ? extends Object> data);
    }

    /* compiled from: IDLXBridgeMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/xbridge/IDLXBridgeMethod$JSEventDelegate;", "", "sendJSEvent", "", SchemaConstants.INNER_PARAM_EVENT_NAME, "", "params", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public interface JSEventDelegate {
        void sendJSEvent(String eventName, Map<String, ? extends Object> params);
    }

    double asDouble(Number origin);

    Access getAccess();

    String getName();

    Class<? extends XBaseParamModel> provideParamModel();

    Class<? extends XBaseResultModel> provideResultModel();

    void realHandle(Map<String, ? extends Object> params, Callback callback, XBridgePlatformType type);

    @Override // com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod
    void release();

    void setProviderFactory(XContextProviderFactory contextProviderFactory);

    /* compiled from: IDLXBridgeMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/xbridge/IDLXBridgeMethod$Companion;", "", "()V", "CANCELLED", "", "FAIL", UserDomainStorageConstants.INVALID_PARAM, "INVALID_RESULT", "KEY_NOT_FOUND", "MALFORMEDRESPONSE_ERROR", "NETWORK_TIMEOUT", "NETWORK_UNREACHABLE", "NOT_FOUND", "OPERATION_TIMEOUT", "PARAM_CODE", "", "PARAM_DATA", "PARAM_MSG", "SUCCESS", "UNAUTHORIZED", "UNAUTHORIZED_ACCESS", "UNKNOWN_ERROR", "UNREGISTERED", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int CANCELLED = -7;
        public static final int FAIL = 0;
        public static final int INVALID_PARAM = -3;
        public static final int INVALID_RESULT = -5;
        public static final int KEY_NOT_FOUND = 2;
        public static final int MALFORMEDRESPONSE_ERROR = -1003;
        public static final int NETWORK_TIMEOUT = -1002;
        public static final int NETWORK_UNREACHABLE = -1001;
        public static final int NOT_FOUND = -9;
        public static final int OPERATION_TIMEOUT = -8;
        public static final String PARAM_CODE = "code";
        public static final String PARAM_DATA = "data";
        public static final String PARAM_MSG = "msg";
        public static final int SUCCESS = 1;
        public static final int UNAUTHORIZED = -1;
        public static final int UNAUTHORIZED_ACCESS = -6;
        public static final int UNKNOWN_ERROR = -1000;
        public static final int UNREGISTERED = -2;

        private Companion() {
        }
    }

    /* compiled from: IDLXBridgeMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/xbridge/IDLXBridgeMethod$Access;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", DocumentType.PUBLIC_KEY, "PRIVATE", "PROTECT", "SECURE", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public enum Access {
        PUBLIC(RegistrationRequest.SUBJECT_TYPE_PUBLIC),
        PRIVATE("private"),
        PROTECT("protected"),
        SECURE("secure");

        private final String value;

        Access(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* compiled from: IDLXBridgeMethod.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static Class<? extends XBaseParamModel> provideParamModel(IDLXBridgeMethod iDLXBridgeMethod) {
            return null;
        }

        public static Class<? extends XBaseResultModel> provideResultModel(IDLXBridgeMethod iDLXBridgeMethod) {
            return null;
        }

        public static void release(IDLXBridgeMethod iDLXBridgeMethod) {
        }

        public static double asDouble(IDLXBridgeMethod iDLXBridgeMethod, Number origin) {
            Intrinsics.checkNotNullParameter(origin, "origin");
            if (!(origin instanceof Double) && !(origin instanceof Integer) && !(origin instanceof Float) && !(origin instanceof Long)) {
                throw new IllegalArgumentException("Dynamic is not Double");
            }
            return origin.doubleValue();
        }

        public static Access getAccess(IDLXBridgeMethod iDLXBridgeMethod) {
            return Access.PRIVATE;
        }
    }
}
