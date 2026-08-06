package com.bytedance.android.sdk.bdticketguard.key;

import android.util.Base64;
import java.security.KeyPair;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytedance.zdplib.Delta;

/* compiled from: AbsKeyHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u0014\u001a\u00020\u0003H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/key/TeeKeyObject;", "Lcom/bytedance/android/sdk/bdticketguard/key/KeyObject;", "newKey", "", "keyPair", "Ljava/security/KeyPair;", "csr", "", "base64Cert", "(ZLjava/security/KeyPair;Ljava/lang/String;Ljava/lang/String;)V", "getBase64Cert", "()Ljava/lang/String;", "setBase64Cert", "(Ljava/lang/String;)V", "getCsr", "setCsr", "getKeyPair", "()Ljava/security/KeyPair;", "publicKeyBase64", "getPublicKeyBase64", "isComplete", "Companion", "bd_ticket_guard_core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final class TeeKeyObject extends KeyObject {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String base64Cert;
    private String csr;
    private final KeyPair keyPair;
    private final String publicKeyBase64;

    @JvmStatic
    public static final String parse04PublicKey(ECPublicKey eCPublicKey) {
        return INSTANCE.parse04PublicKey(eCPublicKey);
    }

    @JvmStatic
    public static final String parseBase64PublicKey(ECPublicKey eCPublicKey) {
        return INSTANCE.parseBase64PublicKey(eCPublicKey);
    }

    /* compiled from: AbsKeyHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/key/TeeKeyObject$Companion;", "", "()V", "parse04PublicKey", "", "ecPublicKey", "Ljava/security/interfaces/ECPublicKey;", "parseBase64PublicKey", "bd_ticket_guard_core_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final String parse04PublicKey(ECPublicKey ecPublicKey) {
            Intrinsics.checkParameterIsNotNull(ecPublicKey, "ecPublicKey");
            ECPoint point = ecPublicKey.getW();
            Intrinsics.checkExpressionValueIsNotNull(point, "point");
            byte[] byteArray = point.getAffineX().toByteArray();
            byte[] byteArray2 = point.getAffineY().toByteArray();
            if (byteArray[0] == 0) {
                byteArray = Arrays.copyOfRange(byteArray, 1, byteArray.length);
            }
            if (byteArray2[0] == 0) {
                byteArray2 = Arrays.copyOfRange(byteArray2, 1, byteArray2.length);
            }
            return "04" + Delta.bytearrayToHexString(byteArray) + Delta.bytearrayToHexString(byteArray2);
        }

        @JvmStatic
        public final String parseBase64PublicKey(ECPublicKey ecPublicKey) {
            Intrinsics.checkParameterIsNotNull(ecPublicKey, "ecPublicKey");
            String encodeToString = Base64.encodeToString(Delta.hexStringToByteArray(parse04PublicKey(ecPublicKey)), 0);
            Intrinsics.checkExpressionValueIsNotNull(encodeToString, "Base64.encodeToString(De…y(pub04), Base64.DEFAULT)");
            return encodeToString;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TeeKeyObject(boolean z, KeyPair keyPair, String str, String str2) {
        super(z, null);
        String parseBase64PublicKey;
        Intrinsics.checkParameterIsNotNull(keyPair, "keyPair");
        this.keyPair = keyPair;
        this.csr = str;
        this.base64Cert = str2;
        PublicKey publicKey = keyPair.getPublic();
        ECPublicKey eCPublicKey = (ECPublicKey) (publicKey instanceof ECPublicKey ? publicKey : null);
        this.publicKeyBase64 = (eCPublicKey == null || (parseBase64PublicKey = INSTANCE.parseBase64PublicKey(eCPublicKey)) == null) ? "" : parseBase64PublicKey;
    }

    public final String getBase64Cert() {
        return this.base64Cert;
    }

    public final String getCsr() {
        return this.csr;
    }

    public final KeyPair getKeyPair() {
        return this.keyPair;
    }

    public final void setBase64Cert(String str) {
        this.base64Cert = str;
    }

    public final void setCsr(String str) {
        this.csr = str;
    }

    public final String getPublicKeyBase64() {
        return this.publicKeyBase64;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.KeyObject
    public boolean isComplete() {
        String str = this.csr;
        if (str == null || str.length() == 0) {
            String str2 = this.base64Cert;
            if (str2 == null || str2.length() == 0) {
                return false;
            }
        }
        return true;
    }
}
