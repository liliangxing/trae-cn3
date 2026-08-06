package com.bytedance.sdk.xbridge.cn.auth.bean;

import io.noties.markwon.html.jsoup.nodes.DocumentType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.RegistrationRequest;

/* compiled from: BridgeCallRecord.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNKNOWN", DocumentType.PUBLIC_KEY, "PRIVATE", "SECURE", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public enum AuthBridgeAccess {
    UNKNOWN("unknown"),
    PUBLIC(RegistrationRequest.SUBJECT_TYPE_PUBLIC),
    PRIVATE("private"),
    SECURE("secure");


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String value;

    AuthBridgeAccess(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    /* compiled from: BridgeCallRecord.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess$Companion;", "", "()V", "getAccess", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;", "value", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
        
            if (r2.equals("protected") == false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:4:0x001e, code lost:
        
            if (r2.equals("protect") == false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0028, code lost:
        
            if (r2.equals("private") == false) goto L23;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final AuthBridgeAccess getAccess(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            String lowerCase = value.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            switch (lowerCase.hashCode()) {
                case -977423767:
                    if (lowerCase.equals(RegistrationRequest.SUBJECT_TYPE_PUBLIC)) {
                        return AuthBridgeAccess.PUBLIC;
                    }
                    return AuthBridgeAccess.PRIVATE;
                case -906273929:
                    if (lowerCase.equals("secure")) {
                        return AuthBridgeAccess.SECURE;
                    }
                    return AuthBridgeAccess.PRIVATE;
                case -608539730:
                    break;
                case -314497661:
                    break;
                case -309012785:
                    break;
                default:
                    return AuthBridgeAccess.PRIVATE;
            }
            return AuthBridgeAccess.PRIVATE;
        }
    }
}
