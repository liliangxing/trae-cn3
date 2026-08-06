package com.bytedance.android.sdk.bdticketguard.key;

import android.util.Base64;
import com.bytedance.android.sdk.bdticketguard.TicketGuardInnerFrameWork;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytedance.zdplib.Delta;
import net.bytedance.zdplib.DeltaSignerVerifier;

/* compiled from: AbsKeyHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0019\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\u00050\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/key/ReeKeyObject;", "Lcom/bytedance/android/sdk/bdticketguard/key/KeyObject;", "newKey", "", "publicKey", "", "privateKey", "deltaSignerVerifier", "Lnet/bytedance/zdplib/DeltaSignerVerifier;", "(ZLjava/lang/String;Ljava/lang/String;Lnet/bytedance/zdplib/DeltaSignerVerifier;)V", "base64PublicKey", "kotlin.jvm.PlatformType", "getBase64PublicKey", "()Ljava/lang/String;", "getDeltaSignerVerifier", "()Lnet/bytedance/zdplib/DeltaSignerVerifier;", "getPrivateKey", "getPublicKey", "isComplete", "bd_ticket_guard_core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ReeKeyObject extends KeyObject {
    private final String base64PublicKey;
    private final DeltaSignerVerifier deltaSignerVerifier;
    private final String privateKey;
    private final String publicKey;

    @Override // com.bytedance.android.sdk.bdticketguard.key.KeyObject
    public boolean isComplete() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReeKeyObject(boolean z, String str, String str2, DeltaSignerVerifier deltaSignerVerifier) {
        super(z, null);
        Intrinsics.checkParameterIsNotNull(str, "publicKey");
        Intrinsics.checkParameterIsNotNull(str2, "privateKey");
        Intrinsics.checkParameterIsNotNull(deltaSignerVerifier, "deltaSignerVerifier");
        this.publicKey = str;
        this.privateKey = str2;
        this.deltaSignerVerifier = deltaSignerVerifier;
        TicketGuardInnerFrameWork.log("ree public key=" + str);
        this.base64PublicKey = Base64.encodeToString(Delta.hexStringToByteArray(str), 2);
    }

    public final DeltaSignerVerifier getDeltaSignerVerifier() {
        return this.deltaSignerVerifier;
    }

    public final String getPrivateKey() {
        return this.privateKey;
    }

    public final String getPublicKey() {
        return this.publicKey;
    }

    public final String getBase64PublicKey() {
        return this.base64PublicKey;
    }
}
