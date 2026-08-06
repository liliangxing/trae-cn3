package com.bytedance.android.sdk.bdticketguard.key;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.bytedance.android.sdk.bdticketguard.MainTicketGuardManager;
import com.bytedance.android.sdk.bdticketguard.ServerCert;
import com.bytedance.android.sdk.bdticketguard.TicketGuardEventHelper;
import com.bytedance.android.sdk.bdticketguard.TicketGuardInnerFrameWork;
import com.bytedance.android.sdk.bdticketguard.TicketGuardProviderKt;
import com.bytedance.bdturing.setting.SettingsManager;
import com.google.gson.Gson;
import java.nio.charset.Charset;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPublicKey;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.Charsets;
import net.bytedance.zdplib.Delta;
import net.bytedance.zdplib.DeltaSignerVerifier;

/* compiled from: ReeKeyHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u001fJ\u0010\u0010!\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u001fJ\u0012\u0010\"\u001a\u0004\u0018\u00010\u00022\u0006\u0010#\u001a\u00020\u0003H\u0016J\b\u0010$\u001a\u00020\u0003H\u0014J\b\u0010%\u001a\u0004\u0018\u00010\u0003J\b\u0010&\u001a\u00020\u0003H\u0016J\b\u0010'\u001a\u00020\u0003H\u0016J\u0006\u0010(\u001a\u00020\u001cJ\u0006\u0010)\u001a\u00020*J\u0012\u0010+\u001a\u0004\u0018\u00010\u00022\u0006\u0010#\u001a\u00020\u0003H\u0016J\u0012\u0010,\u001a\u0004\u0018\u00010\u00172\u0006\u0010-\u001a\u00020\u0003H\u0002J\u001a\u0010.\u001a\u0004\u0018\u00010\u001f2\u0006\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u0003H\u0016J\u0006\u00101\u001a\u00020\u001cJ\u001a\u00102\u001a\u00020\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u00103\u001a\u00020\u001cH\u0002J\u000e\u00104\u001a\u00020*2\u0006\u00105\u001a\u00020\u0003J \u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u001f2\u0006\u00108\u001a\u00020\u001fH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u00069"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/key/ReeKeyHelper;", "Lcom/bytedance/android/sdk/bdticketguard/key/AbsKeyHelper;", "Lcom/bytedance/android/sdk/bdticketguard/key/ReeKeyObject;", "", "context", "Landroid/content/Context;", "keystoreAlias", "(Landroid/content/Context;Ljava/lang/String;)V", "delta", "Lnet/bytedance/zdplib/Delta;", "encryptionSp", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getEncryptionSp", "()Landroid/content/SharedPreferences;", "encryptionSp$delegate", "Lkotlin/Lazy;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "<set-?>", "Lcom/bytedance/android/sdk/bdticketguard/ServerCert;", "serverCert", "getServerCert", "()Lcom/bytedance/android/sdk/bdticketguard/ServerCert;", "completeKeyObject", "", "containsAlias", TicketGuardProviderKt.PATH_DECRYPT, "", "msg", TicketGuardProviderKt.PATH_ENCRYPT, "generateKeyPair", "scene", "getCreateLogSpKey", "getEncryptionPublicKey", "getSpKeyPrivateSuffix", "getSpKeyPublicPrefix", "hasEncryption", "invalidEncryption", "", "loadKeyPair", "parseServerCert", "certString", TicketGuardProviderKt.PATH_SIGN, "data", "path", "tryInitEncryption", "updateEncryption", "needSave", "updateServerCert", "serverCertString", SettingsManager.VERIFY_SERVICE, "pubInfo", "signature", "bd_ticket_guard_core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ReeKeyHelper extends AbsKeyHelper<ReeKeyObject, String> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ReeKeyHelper.class), "encryptionSp", "getEncryptionSp()Landroid/content/SharedPreferences;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ReeKeyHelper.class), "gson", "getGson()Lcom/google/gson/Gson;"))};
    private Delta delta;

    /* renamed from: encryptionSp$delegate, reason: from kotlin metadata */
    private final Lazy encryptionSp;

    /* renamed from: gson$delegate, reason: from kotlin metadata */
    private final Lazy gson;
    private ServerCert serverCert;

    private final SharedPreferences getEncryptionSp() {
        Lazy lazy = this.encryptionSp;
        KProperty kProperty = $$delegatedProperties[0];
        return (SharedPreferences) lazy.getValue();
    }

    private final Gson getGson() {
        Lazy lazy = this.gson;
        KProperty kProperty = $$delegatedProperties[1];
        return (Gson) lazy.getValue();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.AbsKeyHelper
    public boolean completeKeyObject() {
        return true;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.AbsKeyHelper
    protected String getCreateLogSpKey() {
        return ReeKeyHelperKt.SP_KEY_REE_CREATE_LOG;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.AbsKeyHelper
    public String getSpKeyPrivateSuffix() {
        return ReeKeyHelperKt.SP_KEY_PRIVATE_KEY_REE;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.AbsKeyHelper
    public String getSpKeyPublicPrefix() {
        return ReeKeyHelperKt.SP_KEY_PUBLIC_KEY_REE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReeKeyHelper(final Context context, String str) {
        super(context, str);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "keystoreAlias");
        this.encryptionSp = LazyKt.lazy(new Function0<SharedPreferences>() { // from class: com.bytedance.android.sdk.bdticketguard.key.ReeKeyHelper$encryptionSp$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final SharedPreferences m411invoke() {
                return context.getSharedPreferences(MainTicketGuardManager.SP_NAME, 0);
            }
        });
        this.gson = LazyKt.lazy(new Function0<Gson>() { // from class: com.bytedance.android.sdk.bdticketguard.key.ReeKeyHelper$gson$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Gson m412invoke() {
                return new Gson();
            }
        });
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.AbsKeyHelper
    public boolean containsAlias() {
        String string = getSp().getString(getSpKeyPublic(), null);
        String string2 = getSp().getString(getSpKeyPrivate(), null);
        String str = string;
        if (str == null || str.length() == 0) {
            return false;
        }
        String str2 = string2;
        return !(str2 == null || str2.length() == 0);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.AbsKeyHelper
    public ReeKeyObject generateKeyPair(String scene) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        try {
            String GeneratePrivateKey = DeltaSignerVerifier.GeneratePrivateKey();
            DeltaSignerVerifier deltaSignerVerifier = new DeltaSignerVerifier(GeneratePrivateKey);
            String publicKeyUncompressed = deltaSignerVerifier.getPublicKeyUncompressed();
            SharedPreferences.Editor edit = getSp().edit();
            edit.putString(getSpKeyPublic(), publicKeyUncompressed);
            edit.putString(getSpKeyPrivate(), GeneratePrivateKey);
            edit.apply();
            TicketGuardInnerFrameWork.log("ree 生成 Key pair 成功");
            TicketGuardEventHelper.monitorGetReeKeyPair(0, null, true, scene);
            Intrinsics.checkExpressionValueIsNotNull(publicKeyUncompressed, "pub");
            Intrinsics.checkExpressionValueIsNotNull(GeneratePrivateKey, "pri");
            return new ReeKeyObject(true, publicKeyUncompressed, GeneratePrivateKey, deltaSignerVerifier);
        } catch (Throwable th) {
            String stackTraceString = Log.getStackTraceString(th);
            Intrinsics.checkExpressionValueIsNotNull(stackTraceString, "Log.getStackTraceString(e)");
            TicketGuardInnerFrameWork.log("ree 生成 Key pair 失败, exception=" + stackTraceString);
            TicketGuardEventHelper.monitorGetReeKeyPair(-1, stackTraceString, true, scene);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003c A[Catch: all -> 0x0072, TryCatch #0 {all -> 0x0072, blocks: (B:3:0x0011, B:5:0x0030, B:10:0x003c, B:12:0x0041, B:18:0x004c, B:20:0x005b, B:23:0x0064, B:25:0x006b), top: B:2:0x0011 }] */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.sdk.bdticketguard.key.ReeKeyHelper$loadKeyPair$1] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.android.sdk.bdticketguard.key.ReeKeyHelper$loadKeyPair$2] */
    @Override // com.bytedance.android.sdk.bdticketguard.key.AbsKeyHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ReeKeyObject loadKeyPair(final String scene) {
        String string;
        String string2;
        String str;
        boolean z;
        boolean z2;
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        ?? r0 = new Function0<Unit>() { // from class: com.bytedance.android.sdk.bdticketguard.key.ReeKeyHelper$loadKeyPair$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m413invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m413invoke() {
                TicketGuardInnerFrameWork.log("ree 加载 Key pair 成功");
                TicketGuardEventHelper.monitorGetReeKeyPair(0, null, false, scene);
            }
        };
        ?? r1 = new Function1<String, Unit>() { // from class: com.bytedance.android.sdk.bdticketguard.key.ReeKeyHelper$loadKeyPair$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str2) {
                Intrinsics.checkParameterIsNotNull(str2, "errorDesc");
                TicketGuardInnerFrameWork.log("ree 加载 Key pair 失败, " + str2);
                TicketGuardEventHelper.monitorGetReeKeyPair(-1, str2, false, scene);
            }
        };
        try {
            string = getSp().getString(getSpKeyPublic(), null);
            string2 = getSp().getString(getSpKeyPrivate(), null);
            str = string;
            z = true;
        } catch (Throwable th) {
            r1.invoke("exception=" + Log.getStackTraceString(th));
        }
        if (str != null && str.length() != 0) {
            z2 = false;
            if (!z2) {
                String str2 = string2;
                if (str2 != null && str2.length() != 0) {
                    z = false;
                }
                DeltaSignerVerifier deltaSignerVerifier = new DeltaSignerVerifier(string2);
                if (Intrinsics.areEqual(string, deltaSignerVerifier.getPublicKeyUncompressed())) {
                    r0.m413invoke();
                    return new ReeKeyObject(false, string, string2, deltaSignerVerifier);
                }
                r1.invoke("sp内容与deltaSignerVerifier恢复的不一致");
                return null;
            }
            r1.invoke("sp内容为空");
            return null;
        }
        z2 = true;
        if (!z2) {
        }
        r1.invoke("sp内容为空");
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.sdk.bdticketguard.key.ReeKeyHelper$sign$1] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.android.sdk.bdticketguard.key.ReeKeyHelper$sign$2] */
    @Override // com.bytedance.android.sdk.bdticketguard.key.AbsKeyHelper
    public byte[] sign(byte[] data, final String path) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        Intrinsics.checkParameterIsNotNull(path, "path");
        ?? r0 = new Function1<Long, Unit>() { // from class: com.bytedance.android.sdk.bdticketguard.key.ReeKeyHelper$sign$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                TicketGuardInnerFrameWork.log("ree 签名成功");
                TicketGuardEventHelper.monitorReeRealSign(true, null, j, path);
            }
        };
        ?? r1 = new Function1<String, Unit>() { // from class: com.bytedance.android.sdk.bdticketguard.key.ReeKeyHelper$sign$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                Intrinsics.checkParameterIsNotNull(str, "errorDesc");
                TicketGuardInnerFrameWork.log("ree 签名失败, " + str);
                TicketGuardEventHelper.monitorReeRealSign(false, str, 0L, path);
            }
        };
        ReeKeyObject keyObject = getKeyObject();
        if (keyObject == null) {
            r1.invoke("获取私钥失败");
            return null;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            byte[] Sign = keyObject.getDeltaSignerVerifier().Sign(data);
            r0.invoke(System.currentTimeMillis() - currentTimeMillis);
            return Sign;
        } catch (Throwable th) {
            String stackTraceString = Log.getStackTraceString(th);
            Intrinsics.checkExpressionValueIsNotNull(stackTraceString, "Log.getStackTraceString(e)");
            r1.invoke(stackTraceString);
            return null;
        }
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.AbsKeyHelper
    public boolean verify(String pubInfo, byte[] data, byte[] signature) {
        Intrinsics.checkParameterIsNotNull(pubInfo, "pubInfo");
        Intrinsics.checkParameterIsNotNull(data, "data");
        Intrinsics.checkParameterIsNotNull(signature, "signature");
        try {
            ReeKeyObject keyObject = getKeyObject();
            if (keyObject == null) {
                return false;
            }
            Boolean VerifySignature = DeltaSignerVerifier.VerifySignature(signature, data, keyObject.getPublicKey());
            Intrinsics.checkExpressionValueIsNotNull(VerifySignature, "DeltaSignerVerifier.Veri…ture, data, it.publicKey)");
            return VerifySignature.booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public final ServerCert getServerCert() {
        return this.serverCert;
    }

    public final boolean hasEncryption() {
        return this.delta != null;
    }

    public final String getEncryptionPublicKey() {
        Delta delta = this.delta;
        if (delta != null) {
            return delta.GetPublicKey();
        }
        return null;
    }

    public final boolean tryInitEncryption() {
        boolean z = true;
        if (hasEncryption()) {
            return true;
        }
        TicketGuardEventHelper.monitorLoadRemoteCertStart();
        String string = getEncryptionSp().getString(MainTicketGuardManager.SP_KEY_SERVER_CERT, null);
        String str = string;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (!z) {
            try {
                ServerCert serverCert = (ServerCert) getGson().fromJson(string, ServerCert.class);
                this.serverCert = serverCert;
                if (serverCert != null) {
                    TicketGuardEventHelper.monitorLoadRemoteCertSuccess(serverCert.getSerialNumber());
                } else {
                    TicketGuardEventHelper.monitorLoadRemoteCertFail("not empty in sp, gson parsing success, but empty result");
                }
            } catch (Throwable th) {
                getEncryptionSp().edit().remove(MainTicketGuardManager.SP_KEY_SERVER_CERT).apply();
                String stackTraceString = Log.getStackTraceString(th);
                Intrinsics.checkExpressionValueIsNotNull(stackTraceString, "Log.getStackTraceString(ignore)");
                TicketGuardEventHelper.monitorParseJsonError("load_server_cert", string, stackTraceString);
                TicketGuardEventHelper.monitorLoadRemoteCertFail("gson parsing error, e=" + th.getMessage() + ", originText=" + string);
            }
        } else {
            TicketGuardEventHelper.monitorLoadRemoteCertFail("empty in sp");
        }
        return updateEncryption(this.serverCert, false);
    }

    public final void updateServerCert(String serverCertString) {
        Intrinsics.checkParameterIsNotNull(serverCertString, "serverCertString");
        ServerCert parseServerCert = parseServerCert(serverCertString);
        this.serverCert = parseServerCert;
        updateEncryption(parseServerCert, true);
    }

    private final ServerCert parseServerCert(String certString) {
        String str;
        Charset charset;
        if (certString.length() == 0) {
            return null;
        }
        try {
            charset = Charsets.UTF_8;
        } catch (Throwable th) {
            String stackTraceString = Log.getStackTraceString(th);
            String stackTraceString2 = Log.getStackTraceString(th);
            Intrinsics.checkExpressionValueIsNotNull(stackTraceString2, "Log.getStackTraceString(e)");
            TicketGuardInnerFrameWork.log(stackTraceString2);
            str = stackTraceString;
        }
        if (certString == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = certString.getBytes(charset);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        X509Certificate parseCertificate = TeeApi.parseCertificate(bytes);
        if (parseCertificate == null) {
            str = "parse certificate failed without exception";
        } else {
            if (parseCertificate.getPublicKey() instanceof ECPublicKey) {
                String bigInteger = parseCertificate.getSerialNumber().toString();
                Intrinsics.checkExpressionValueIsNotNull(bigInteger, "certificate.serialNumber.toString()");
                PublicKey publicKey = parseCertificate.getPublicKey();
                if (publicKey == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.security.interfaces.ECPublicKey");
                }
                String parse04PublicKey = TeeApi.parse04PublicKey((ECPublicKey) publicKey);
                TicketGuardInnerFrameWork.log("snNumber=" + bigInteger + ", serverPubKey=" + parse04PublicKey);
                TicketGuardEventHelper.monitorParseServerCert(true, null);
                return new ServerCert(certString, bigInteger, parse04PublicKey);
            }
            str = "certificate's public key is not ECPublicKey";
        }
        TicketGuardEventHelper.monitorParseServerCert(false, str);
        return null;
    }

    private final boolean updateEncryption(ServerCert serverCert, boolean needSave) {
        DeltaSignerVerifier deltaSignerVerifier;
        if (serverCert == null) {
            return false;
        }
        try {
            ReeKeyObject keyObject = getKeyObject();
            this.delta = (keyObject == null || (deltaSignerVerifier = keyObject.getDeltaSignerVerifier()) == null) ? null : deltaSignerVerifier.createDelta(serverCert.getPublicKey());
            if (needSave) {
                getEncryptionSp().edit().putString(MainTicketGuardManager.SP_KEY_SERVER_CERT, getGson().toJson(serverCert)).apply();
            }
        } catch (Throwable th) {
            TicketGuardEventHelper.monitorDeltaInsFail(th);
        }
        return hasEncryption();
    }

    public final void invalidEncryption() {
        this.serverCert = null;
        getEncryptionSp().edit().putString(MainTicketGuardManager.SP_KEY_SERVER_CERT, null).apply();
        this.delta = null;
    }

    public final byte[] encrypt(byte[] msg) throws Exception {
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        Delta delta = this.delta;
        if (delta != null) {
            return delta.Encrypt(msg);
        }
        return null;
    }

    public final byte[] decrypt(byte[] msg) throws Exception {
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        Delta delta = this.delta;
        if (delta != null) {
            return delta.Decrypt(msg);
        }
        return null;
    }
}
