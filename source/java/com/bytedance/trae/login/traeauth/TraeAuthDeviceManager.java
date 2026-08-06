package com.bytedance.trae.login.traeauth;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.utils.logger.FLogger;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.spec.ECGenParameterSpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* compiled from: TraeAuthDeviceManager.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001$B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0005J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u001f\u001a\u00020\u0005H\u0002J\u0006\u0010 \u001a\u00020\u0018J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006%"}, d2 = {"Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager;", "", "<init>", "()V", "TAG", "", "KEYSTORE_PROVIDER", "KEY_ALIAS", "PLATFORM_CODE", "DEVICE_TYPE", "keyStore", "Ljava/security/KeyStore;", "getKeyStore", "()Ljava/security/KeyStore;", "keyStore$delegate", "Lkotlin/Lazy;", "getDeviceInfo", "Lcom/bytedance/trae/login/traeauth/DeviceInfo;", "getDeviceProof", "Lcom/bytedance/trae/login/traeauth/DeviceProof;", "httpMethod", "path", "refreshToken", "ensureKeyPairExists", "", "generateKeyPair", "getPrivateKey", "Ljava/security/PrivateKey;", "getPublicKey", "Ljava/security/PublicKey;", "exportPublicKeyPEM", "buildDeviceName", "regenerateKeyPair", "showLimitDeviceDialog", "callback", "Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$TraeAuthDeviceCallback;", "TraeAuthDeviceCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeAuthDeviceManager {
    private static final String DEVICE_TYPE = "mobile";
    public static final TraeAuthDeviceManager INSTANCE;
    private static final String KEYSTORE_PROVIDER = "AndroidKeyStore";
    private static final String KEY_ALIAS = "com.trae.device.ec256";
    private static final String PLATFORM_CODE = "solo_mobile";
    private static final String TAG = "TraeAuthDeviceManager";

    /* renamed from: keyStore$delegate, reason: from kotlin metadata */
    private static final Lazy keyStore;

    /* compiled from: TraeAuthDeviceManager.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/login/traeauth/TraeAuthDeviceManager$TraeAuthDeviceCallback;", "", "unBind", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface TraeAuthDeviceCallback {
        void unBind();
    }

    private TraeAuthDeviceManager() {
    }

    static {
        TraeAuthDeviceManager traeAuthDeviceManager = new TraeAuthDeviceManager();
        INSTANCE = traeAuthDeviceManager;
        keyStore = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.login.traeauth.TraeAuthDeviceManager$$ExternalSyntheticLambda0
            public final Object invoke() {
                KeyStore keyStore_delegate$lambda$1;
                keyStore_delegate$lambda$1 = TraeAuthDeviceManager.keyStore_delegate$lambda$1();
                return keyStore_delegate$lambda$1;
            }
        });
        traeAuthDeviceManager.ensureKeyPairExists();
    }

    private final KeyStore getKeyStore() {
        Object value = keyStore.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (KeyStore) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KeyStore keyStore_delegate$lambda$1() {
        KeyStore keyStore2 = KeyStore.getInstance(KEYSTORE_PROVIDER);
        keyStore2.load(null);
        return keyStore2;
    }

    public final DeviceInfo getDeviceInfo() {
        String deviceId = IApplog.Companion.getDeviceId();
        String buildDeviceName = buildDeviceName();
        String versionName = AppHost.Companion.getVersionName();
        String str = Build.MODEL;
        String str2 = str == null ? "" : str;
        String str3 = Build.VERSION.RELEASE;
        String str4 = str3 == null ? "" : str3;
        String exportPublicKeyPEM = exportPublicKeyPEM();
        String str5 = exportPublicKeyPEM == null ? "" : exportPublicKeyPEM;
        String str6 = Build.BRAND;
        return new DeviceInfo(deviceId, buildDeviceName, DEVICE_TYPE, PLATFORM_CODE, versionName, str2, str4, null, str5, str6 == null ? "" : str6, 128, null);
    }

    public static /* synthetic */ DeviceProof getDeviceProof$default(TraeAuthDeviceManager traeAuthDeviceManager, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "POST";
        }
        if ((i & 2) != 0) {
            str2 = "/cloudide/api/v3/trae/oauth/BindDevice";
        }
        if ((i & 4) != 0) {
            str3 = TraeAuthStorage.INSTANCE.getRefreshToken();
        }
        return traeAuthDeviceManager.getDeviceProof(str, str2, str3);
    }

    public final DeviceProof getDeviceProof(String httpMethod, String path, String refreshToken) {
        Intrinsics.checkNotNullParameter(httpMethod, "httpMethod");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(refreshToken, "refreshToken");
        PrivateKey privateKey = getPrivateKey();
        if (privateKey == null) {
            FLogger.INSTANCE.mo426e(TAG, "getDeviceProof: privateKey unavailable");
            return null;
        }
        String clientId = TraeAuthConfig.INSTANCE.getClientId();
        long currentTimeMillis = System.currentTimeMillis() / BytePatchException.ErrorCode.paramsError;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        String lowerCase = StringsKt.replace$default(uuid, "-", "", false, 4, (Object) null).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String joinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOf(new String[]{httpMethod, path, clientId, refreshToken, String.valueOf(currentTimeMillis), lowerCase}), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        try {
            Signature signature = Signature.getInstance("SHA256withECDSA");
            signature.initSign(privateKey);
            byte[] bytes = joinToString$default.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            signature.update(bytes);
            return new DeviceProof(Base64.encodeToString(signature.sign(), 2), Long.valueOf(currentTimeMillis), lowerCase);
        } catch (Exception e) {
            FLogger.INSTANCE.mo426e(TAG, "getDeviceProof: signing failed - " + e.getMessage());
            return null;
        }
    }

    private final void ensureKeyPairExists() {
        if (getKeyStore().containsAlias(KEY_ALIAS)) {
            return;
        }
        generateKeyPair();
    }

    private final void generateKeyPair() {
        try {
            KeyGenParameterSpec build = new KeyGenParameterSpec.Builder(KEY_ALIAS, 12).setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1")).setDigests("SHA-256").build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC", KEYSTORE_PROVIDER);
            keyPairGenerator.initialize(build);
            keyPairGenerator.generateKeyPair();
            FLogger.INSTANCE.mo428i(TAG, "generateKeyPair: new EC P-256 key pair generated");
        } catch (Exception e) {
            FLogger.INSTANCE.mo426e(TAG, "generateKeyPair: failed - " + e.getMessage());
        }
    }

    private final PrivateKey getPrivateKey() {
        try {
            Key key = getKeyStore().getKey(KEY_ALIAS, null);
            if (key instanceof PrivateKey) {
                return (PrivateKey) key;
            }
            return null;
        } catch (Exception e) {
            FLogger.INSTANCE.mo426e(TAG, "getPrivateKey: failed - " + e.getMessage());
            return null;
        }
    }

    private final PublicKey getPublicKey() {
        try {
            Certificate certificate = getKeyStore().getCertificate(KEY_ALIAS);
            if (certificate != null) {
                return certificate.getPublicKey();
            }
            return null;
        } catch (Exception e) {
            FLogger.INSTANCE.mo426e(TAG, "getPublicKey: failed - " + e.getMessage());
            return null;
        }
    }

    private final String exportPublicKeyPEM() {
        byte[] encoded;
        PublicKey publicKey = getPublicKey();
        if (publicKey == null || (encoded = publicKey.getEncoded()) == null) {
            return null;
        }
        return "-----BEGIN PUBLIC KEY-----\n" + Base64.encodeToString(encoded, 2) + "\n-----END PUBLIC KEY-----";
    }

    private final String buildDeviceName() {
        String str = Build.MANUFACTURER;
        if (str == null) {
            str = "";
        }
        String str2 = Build.MODEL;
        List listOf = CollectionsKt.listOf(new String[]{str, str2 != null ? str2 : ""});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listOf) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.joinToString$default(arrayList, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public final void regenerateKeyPair() {
        try {
            getKeyStore().deleteEntry(KEY_ALIAS);
            FLogger.INSTANCE.mo428i(TAG, "regenerateKeyPair: old key deleted");
        } catch (Exception e) {
            FLogger.INSTANCE.mo426e(TAG, "regenerateKeyPair: delete failed - " + e.getMessage());
        }
        generateKeyPair();
    }

    public final void showLimitDeviceDialog(TraeAuthDeviceCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new TraeAuthDeviceManager$showLimitDeviceDialog$1(callback, null), 3, (Object) null);
    }
}
