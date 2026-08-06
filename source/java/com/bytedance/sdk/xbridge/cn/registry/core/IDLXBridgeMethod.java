package com.bytedance.sdk.xbridge.cn.registry.core;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.sdk.xbridge.cn.storage.utils.UserDomainStorageConstants;
import io.noties.markwon.html.jsoup.nodes.DocumentType;
import java.util.Map;
import kotlin.Metadata;
import net.openid.appauth.RegistrationRequest;

/* compiled from: IDLXBridgeMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \u001a2\u00020\u0001:\u0005\u0018\u0019\u001a\u001b\u001cJ\b\u0010\u000e\u001a\u00020\u000fH&J.\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H&R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "", Api.KEY_ACCESS, "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "compatibility", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Compatibility;", "getCompatibility", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Compatibility;", "name", "", "getName", "()Ljava/lang/String;", "canRunInBackground", "", "realHandle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Callback;", "Access", "Callback", "Companion", "Compatibility", "XBridgeThreadType", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface IDLXBridgeMethod {
    public static final int APPID_EMPTY = 1001;
    public static final int BRIDGE_RELEASED = -12;
    public static final int CANCELLED = -7;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int EXCEPTION_THROWN = -999;
    public static final int FAIL = 0;
    public static final int HANDLE_ERROR = -11;
    public static final int IDL_ERROR = -10;
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
    public static final int UNKNOWN_APP_ID = 0;
    public static final int UNKNOWN_ERROR = -1000;
    public static final int UNKNOWN_HOST = -4;
    public static final int UNREGISTERED = -2;

    /* compiled from: IDLXBridgeMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Callback;", "", "invoke", "", "data", "", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Callback {
        void invoke(Map<String, ? extends Object> data);
    }

    boolean canRunInBackground();

    Access getAccess();

    Compatibility getCompatibility();

    String getName();

    void realHandle(IBDXBridgeContext bridgeContext, Map<String, ? extends Object> params, Callback callback);

    /* compiled from: IDLXBridgeMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Companion;", "", "()V", "APPID_EMPTY", "", "BRIDGE_RELEASED", "CANCELLED", "EXCEPTION_THROWN", "FAIL", "HANDLE_ERROR", "IDL_ERROR", UserDomainStorageConstants.INVALID_PARAM, "INVALID_RESULT", "KEY_NOT_FOUND", "MALFORMEDRESPONSE_ERROR", "NETWORK_TIMEOUT", "NETWORK_UNREACHABLE", "NOT_FOUND", "OPERATION_TIMEOUT", "PARAM_CODE", "", "PARAM_DATA", "PARAM_MSG", "SUCCESS", "UNAUTHORIZED", "UNAUTHORIZED_ACCESS", "UNKNOWN_APP_ID", "UNKNOWN_ERROR", "UNKNOWN_HOST", "UNREGISTERED", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int APPID_EMPTY = 1001;
        public static final int BRIDGE_RELEASED = -12;
        public static final int CANCELLED = -7;
        public static final int EXCEPTION_THROWN = -999;
        public static final int FAIL = 0;
        public static final int HANDLE_ERROR = -11;
        public static final int IDL_ERROR = -10;
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
        public static final int UNKNOWN_APP_ID = 0;
        public static final int UNKNOWN_ERROR = -1000;
        public static final int UNKNOWN_HOST = -4;
        public static final int UNREGISTERED = -2;

        private Companion() {
        }
    }

    /* compiled from: IDLXBridgeMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", DocumentType.PUBLIC_KEY, "PROTECT", "PRIVATE", "SECURE", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public enum Access {
        PUBLIC(RegistrationRequest.SUBJECT_TYPE_PUBLIC),
        PROTECT("protected"),
        PRIVATE("private"),
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
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Compatibility;", "", "value", "", "(Ljava/lang/String;IZ)V", "getValue", "()Z", "Compatible", "InCompatible", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public enum Compatibility {
        Compatible(true),
        InCompatible(false);

        private final boolean value;

        Compatibility(boolean z) {
            this.value = z;
        }

        public final boolean getValue() {
            return this.value;
        }
    }

    /* compiled from: IDLXBridgeMethod.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static Access getAccess(IDLXBridgeMethod iDLXBridgeMethod) {
            return Access.PRIVATE;
        }

        public static Compatibility getCompatibility(IDLXBridgeMethod iDLXBridgeMethod) {
            return Compatibility.InCompatible;
        }
    }

    /* compiled from: IDLXBridgeMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$XBridgeThreadType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SYNC_THREAD", "MAIN_THREAD", "ASYNC_THREAD", "MAIN_THREAD_OPT", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public enum XBridgeThreadType {
        SYNC_THREAD("sync_thread"),
        MAIN_THREAD("main_thread"),
        ASYNC_THREAD("async_thread"),
        MAIN_THREAD_OPT("main_thread_opt");

        private final String value;

        XBridgeThreadType(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }
}
