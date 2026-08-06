package com.bytedance.android.sdk.bdticketguard.key;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import com.bytedance.android.sdk.bdticketguard.MainTicketGuardManager;
import com.bytedance.android.sdk.bdticketguard.TicketGuardEventHelper;
import com.bytedance.android.sdk.bdticketguard.TicketGuardInnerFrameWork;
import com.bytedance.android.sdk.bdticketguard.TicketGuardProviderKt;
import com.bytedance.bdturing.setting.SettingsManager;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: TeeKeyHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0014J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\u0017\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010 \u001a\u00020!H\u0002¢\u0006\u0002\u0010\"J\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010#\u001a\u00020\u0007¢\u0006\u0002\u0010$J\u0012\u0010%\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010&\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J\u001a\u0010'\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)H\u0002J\u001a\u0010*\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)H\u0002J\u001a\u0010+\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)H\u0002J*\u0010,\u001a\u0004\u0018\u00010!2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020!2\u0006\u0010(\u001a\u00020)2\u0006\u00100\u001a\u00020\u0007H\u0002J\u001a\u00101\u001a\u0004\u0018\u00010!2\u0006\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\u0007H\u0016J\u000e\u00102\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0007J \u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u00032\u0006\u0010/\u001a\u00020!2\u0006\u00105\u001a\u00020!H\u0016R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/key/TeeKeyHelper;", "Lcom/bytedance/android/sdk/bdticketguard/key/AbsKeyHelper;", "Lcom/bytedance/android/sdk/bdticketguard/key/TeeKeyObject;", "Ljava/security/cert/Certificate;", "context", "Landroid/content/Context;", "keystoreAlias", "", "principal", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "<set-?>", "", "hasEverFail", "getHasEverFail", "()Z", "apiFail", "", "reason", "error", "", "completeKeyObject", "containsAlias", "genCsr", "keyPair", "Ljava/security/KeyPair;", "generateKeyPair", "scene", "getCreateLogSpKey", "getSpKeyClientCert", "getSpKeyPrivateSuffix", "getSpKeyPublicPrefix", "isKeyMatch", "cert", "", "([B)Ljava/lang/Boolean;", "base64Cert", "(Ljava/lang/String;)Ljava/lang/Boolean;", "loadCertFromSp", "loadKeyPair", "realGenCsr", "attemptCount", "", "realGenKey", "realLoadKeyPair", "realSign", "privateKey", "Ljava/security/PrivateKey;", "data", "path", TicketGuardProviderKt.PATH_SIGN, "updateClientCert", SettingsManager.VERIFY_SERVICE, "pubInfo", "signature", "bd_ticket_guard_core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class TeeKeyHelper extends AbsKeyHelper<TeeKeyObject, Certificate> {
    private boolean hasEverFail;
    private final String principal;

    @Override // com.bytedance.android.sdk.bdticketguard.key.AbsKeyHelper
    protected String getCreateLogSpKey() {
        return TeeKeyHelperKt.SP_KEY_TEE_CREATE_LOG;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.AbsKeyHelper
    public String getSpKeyPrivateSuffix() {
        return TeeKeyHelperKt.SP_KEY_PRIVATE_KEY;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.AbsKeyHelper
    public String getSpKeyPublicPrefix() {
        return TeeKeyHelperKt.SP_KEY_PUBLIC_KEY;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TeeKeyHelper(Context context, String str, String str2) {
        super(context, str);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "keystoreAlias");
        Intrinsics.checkParameterIsNotNull(str2, "principal");
        this.principal = str2;
        this.hasEverFail = getSp().getBoolean(TeeKeyHelperKt.SP_KEY_HAS_EVER_FAIL, false);
    }

    private final String getSpKeyClientCert() {
        return "client_cert_" + getKeystoreAlias();
    }

    public final boolean getHasEverFail() {
        return this.hasEverFail;
    }

    public final void apiFail(String reason, Throwable error) {
        Intrinsics.checkParameterIsNotNull(reason, "reason");
        TicketGuardInnerFrameWork.log(reason + " fail, error=" + Log.getStackTraceString(error));
        if (this.hasEverFail) {
            return;
        }
        this.hasEverFail = true;
        getSp().edit().putBoolean(TeeKeyHelperKt.SP_KEY_HAS_EVER_FAIL, true).apply();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.AbsKeyHelper
    public boolean containsAlias() {
        try {
            return TeeApi.containsAlias(getKeystoreAlias(), getSp(), getSpKeyPublic(), getSpKeyPrivate());
        } catch (Throwable th) {
            apiFail("contains alias", th);
            throw th;
        }
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.AbsKeyHelper
    public TeeKeyObject generateKeyPair(String scene) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        for (int i = 1; i <= 3; i++) {
            KeyPair realGenKey = realGenKey(scene, i);
            if (realGenKey != null) {
                return new TeeKeyObject(true, realGenKey, genCsr(realGenKey), null);
            }
        }
        return null;
    }

    private final KeyPair realGenKey(String scene, int attemptCount) {
        long currentTimeMillis = System.currentTimeMillis();
        KeyPair keyPair = null;
        try {
            String keystoreAlias = getKeystoreAlias();
            SharedPreferences.Editor edit = getSp().edit();
            Intrinsics.checkExpressionValueIsNotNull(edit, "sp.edit()");
            KeyPair genKeyPair = TeeApi.genKeyPair(keystoreAlias, edit, getSpKeyPublic(), getSpKeyPrivate());
            if (genKeyPair != null) {
                TicketGuardInnerFrameWork.log("生成 Key pair 成功");
                TicketGuardEventHelper.monitorGetKeyPair(0, null, System.currentTimeMillis() - currentTimeMillis, true, attemptCount, scene);
                keyPair = genKeyPair;
            } else {
                TicketGuardInnerFrameWork.log("生成 Key pair 失败");
                TicketGuardEventHelper.monitorGetKeyPair(-1, null, System.currentTimeMillis() - currentTimeMillis, true, attemptCount, scene);
            }
        } catch (Throwable th) {
            apiFail("generate key", th);
            TicketGuardInnerFrameWork.log("生成 Key pair 失败, exception=" + Log.getStackTraceString(th));
            TicketGuardEventHelper.monitorGetKeyPair(-1, th, System.currentTimeMillis() - currentTimeMillis, true, attemptCount, scene);
        }
        return keyPair;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.AbsKeyHelper
    public TeeKeyObject loadKeyPair(String scene) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        for (int i = 1; i <= 3; i++) {
            KeyPair realLoadKeyPair = realLoadKeyPair(scene, i);
            if (realLoadKeyPair != null) {
                TeeKeyObject teeKeyObject = new TeeKeyObject(false, realLoadKeyPair, null, loadCertFromSp(realLoadKeyPair));
                if (!teeKeyObject.isComplete()) {
                    completeKeyObject();
                }
                return teeKeyObject;
            }
        }
        return null;
    }

    private final String loadCertFromSp(KeyPair keyPair) {
        String str;
        TicketGuardEventHelper.INSTANCE.monitorLoadLocalCertStart();
        boolean z = true;
        if (getSp().getBoolean(TeeKeyHelperKt.SP_KEY_HAS_LOAD_FROM_ORIGIN_SP, false)) {
            str = null;
        } else {
            SharedPreferences sharedPreferences = getContext().getSharedPreferences(MainTicketGuardManager.SP_NAME, 0);
            str = sharedPreferences.getString("sp_key_cert", null);
            sharedPreferences.edit().remove("sp_key_cert").apply();
            SharedPreferences.Editor edit = getSp().edit();
            edit.putBoolean(TeeKeyHelperKt.SP_KEY_HAS_LOAD_FROM_ORIGIN_SP, true);
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                byte[] decode = Base64.decode(str, 0);
                Intrinsics.checkExpressionValueIsNotNull(decode, "Base64.decode(originCert, Base64.DEFAULT)");
                PrivateKey privateKey = keyPair.getPrivate();
                Intrinsics.checkExpressionValueIsNotNull(privateKey, "keyPair.private");
                if (TeeApi.isKeyMatch(decode, privateKey)) {
                    edit.putString(getSpKeyClientCert(), str);
                    edit.apply();
                }
            }
            str = null;
            edit.apply();
        }
        String str3 = str;
        if (!(str3 == null || str3.length() == 0)) {
            return str;
        }
        String string = getSp().getString(getSpKeyClientCert(), null);
        String str4 = string;
        if (str4 != null && str4.length() != 0) {
            z = false;
        }
        if (z) {
            TicketGuardEventHelper.INSTANCE.monitorLoadLocalCertFail("sp empty");
        } else {
            byte[] decode2 = Base64.decode(string, 0);
            Intrinsics.checkExpressionValueIsNotNull(decode2, "Base64.decode(cert, Base64.DEFAULT)");
            PrivateKey privateKey2 = keyPair.getPrivate();
            Intrinsics.checkExpressionValueIsNotNull(privateKey2, "keyPair.private");
            if (TeeApi.isKeyMatch(decode2, privateKey2)) {
                TicketGuardEventHelper.INSTANCE.monitorLoadLocalCertSuccess(string);
            } else {
                TicketGuardEventHelper.INSTANCE.monitorLoadLocalCertFail("not match private key");
                getSp().edit().remove(getSpKeyClientCert()).apply();
                return null;
            }
        }
        return string;
    }

    private final KeyPair realLoadKeyPair(String scene, int attemptCount) {
        long currentTimeMillis = System.currentTimeMillis();
        KeyPair keyPair = null;
        try {
            KeyPair loadKeyPair = TeeApi.loadKeyPair(getKeystoreAlias(), getSp(), getSpKeyPublic(), getSpKeyPrivate());
            if (loadKeyPair != null) {
                TicketGuardInnerFrameWork.log("加载 Key pair 成功");
                TicketGuardEventHelper.monitorGetKeyPair(0, null, System.currentTimeMillis() - currentTimeMillis, false, attemptCount, scene);
                keyPair = loadKeyPair;
            } else {
                TicketGuardInnerFrameWork.log("加载 Key pair 失败");
                TicketGuardEventHelper.monitorGetKeyPair(0, null, System.currentTimeMillis() - currentTimeMillis, false, attemptCount, scene);
            }
        } catch (Throwable th) {
            apiFail("load key pair", th);
            TicketGuardInnerFrameWork.log("加载 Key pair 失败, exception=" + Log.getStackTraceString(th));
            TicketGuardEventHelper.monitorGetKeyPair(-1, th, System.currentTimeMillis() - currentTimeMillis, false, attemptCount, scene);
        }
        return keyPair;
    }

    private final String genCsr(KeyPair keyPair) {
        for (int i = 1; i <= 3; i++) {
            String realGenCsr = realGenCsr(keyPair, i);
            if (realGenCsr != null) {
                return realGenCsr;
            }
        }
        return null;
    }

    private final String realGenCsr(KeyPair keyPair, int attemptCount) {
        try {
            String genCsr = TeeApi.genCsr(keyPair, this.principal);
            TicketGuardInnerFrameWork.log("生成 csr 成功");
            TicketGuardEventHelper.monitorGenCsr(0, null, attemptCount);
            return genCsr;
        } catch (Throwable th) {
            apiFail("generate csr", th);
            TicketGuardInnerFrameWork.log("生成 csr 失败, exception=" + Log.getStackTraceString(th));
            TicketGuardEventHelper.monitorGenCsr(TicketGuardEventHelper.ERROR_CODE_GEN_CSR_GEN_CSR_ERROR, th, attemptCount);
            return null;
        }
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.AbsKeyHelper
    public boolean completeKeyObject() {
        TeeKeyObject keyObject = getKeyObject();
        if (keyObject == null) {
            return false;
        }
        keyObject.setCsr(genCsr(keyObject.getKeyPair()));
        return keyObject.isComplete();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.AbsKeyHelper
    public byte[] sign(byte[] data, String path) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        Intrinsics.checkParameterIsNotNull(path, "path");
        TeeKeyObject keyObject = getKeyObject();
        if (keyObject == null) {
            TicketGuardInnerFrameWork.log("签名失败, 获取私钥失败");
            TicketGuardEventHelper.monitorSign(TicketGuardEventHelper.ERROR_CODE_SIGN_SIGN_EMPTY_PRIVATE_KEY, TicketGuardEventHelper.ERROR_DESC_SIGN_EMPTY_PRIVATE_KEY, 0L, 0, path);
            return null;
        }
        for (int i = 1; i <= 3; i++) {
            PrivateKey privateKey = keyObject.getKeyPair().getPrivate();
            Intrinsics.checkExpressionValueIsNotNull(privateKey, "it.keyPair.private");
            byte[] realSign = realSign(privateKey, data, i, path);
            if (realSign != null) {
                return realSign;
            }
        }
        return null;
    }

    private final byte[] realSign(PrivateKey privateKey, byte[] data, int attemptCount, String path) {
        byte[] bArr = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            bArr = TeeApi.sign(privateKey, data);
            TicketGuardInnerFrameWork.log("签名成功");
            TicketGuardEventHelper.monitorSign(0, null, System.currentTimeMillis() - currentTimeMillis, attemptCount, path);
            TicketGuardEventHelper.monitorRealSign(true, null, attemptCount, System.currentTimeMillis() - currentTimeMillis, path);
        } catch (Throwable th) {
            apiFail(TicketGuardProviderKt.PATH_SIGN, th);
            TicketGuardInnerFrameWork.log("签名失败, exception=" + Log.getStackTraceString(th));
            TicketGuardEventHelper.monitorSign(-1, "sign error, see bd_ticket_guard_create_signature", 0L, 3, path);
            TicketGuardEventHelper.monitorRealSign(false, th, attemptCount, 0L, path);
        }
        return bArr;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.AbsKeyHelper
    public boolean verify(Certificate pubInfo, byte[] data, byte[] signature) {
        Intrinsics.checkParameterIsNotNull(pubInfo, "pubInfo");
        Intrinsics.checkParameterIsNotNull(data, "data");
        Intrinsics.checkParameterIsNotNull(signature, "signature");
        try {
            return TeeApi.verify(pubInfo, data, signature);
        } catch (Throwable th) {
            apiFail(SettingsManager.VERIFY_SERVICE, th);
            return false;
        }
    }

    public final Boolean isKeyMatch(String base64Cert) {
        Intrinsics.checkParameterIsNotNull(base64Cert, "base64Cert");
        byte[] decode = Base64.decode(base64Cert, 0);
        Intrinsics.checkExpressionValueIsNotNull(decode, "Base64.decode(base64Cert, Base64.DEFAULT)");
        return isKeyMatch(decode);
    }

    private final Boolean isKeyMatch(byte[] cert) {
        TeeKeyObject keyObject = getKeyObject();
        if (keyObject == null) {
            return null;
        }
        try {
            PrivateKey privateKey = keyObject.getKeyPair().getPrivate();
            Intrinsics.checkExpressionValueIsNotNull(privateKey, "it.keyPair.private");
            return Boolean.valueOf(TeeApi.isKeyMatch(cert, privateKey));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void updateClientCert(String cert) {
        Intrinsics.checkParameterIsNotNull(cert, "cert");
        byte[] bytes = cert.getBytes(Charsets.UTF_8);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        if (Intrinsics.areEqual(isKeyMatch(bytes), true)) {
            byte[] bytes2 = cert.getBytes(Charsets.UTF_8);
            Intrinsics.checkExpressionValueIsNotNull(bytes2, "(this as java.lang.String).getBytes(charset)");
            String encodeToString = Base64.encodeToString(bytes2, 2);
            TeeKeyObject keyObject = getKeyObject();
            if (keyObject != null) {
                keyObject.setBase64Cert(encodeToString);
            }
            getSp().edit().putString(getSpKeyClientCert(), encodeToString).apply();
            TicketGuardEventHelper ticketGuardEventHelper = TicketGuardEventHelper.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(encodeToString, "base64Cert");
            ticketGuardEventHelper.monitorUpdateLocalCert(encodeToString);
        }
    }
}
