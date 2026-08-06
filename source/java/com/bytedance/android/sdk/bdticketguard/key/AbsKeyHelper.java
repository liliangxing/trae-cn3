package com.bytedance.android.sdk.bdticketguard.key;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.bytedance.android.sdk.bdticketguard.TicketGuardEventHelper;
import com.bytedance.android.sdk.bdticketguard.TicketGuardInnerFrameWork;
import com.bytedance.android.sdk.bdticketguard.TicketGuardProviderKt;
import com.bytedance.android.sdk.bdticketguard.key.KeyObject;
import com.bytedance.bdturing.setting.SettingsManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbsKeyHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u001a\u001a\u00020\u001bH&J\b\u0010\u001c\u001a\u00020\u001bH&J\u0017\u0010\u001d\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001e\u001a\u00020\bH&¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\bH$J\b\u0010!\u001a\u00020\bH\u0004J\b\u0010\"\u001a\u00020\bH&J\b\u0010#\u001a\u00020\bH\u0004J\b\u0010$\u001a\u00020\bH&J\u0017\u0010%\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001e\u001a\u00020\bH&¢\u0006\u0002\u0010\u001fJ\b\u0010&\u001a\u00020'H\u0002J\u001a\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\bH&J\u000e\u0010,\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\bJ%\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00028\u00012\u0006\u0010*\u001a\u00020)2\u0006\u0010/\u001a\u00020)H&¢\u0006\u0002\u00100R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00018\u00002\b\u0010\r\u001a\u0004\u0018\u00018\u0000@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u0017X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u00061"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/key/AbsKeyHelper;", "K", "Lcom/bytedance/android/sdk/bdticketguard/key/KeyObject;", "PubInfo", "", "context", "Landroid/content/Context;", "keystoreAlias", "", "(Landroid/content/Context;Ljava/lang/String;)V", "SP_KEY_CREATE_LOG", "getContext", "()Landroid/content/Context;", "<set-?>", "createLog", "getCreateLog", "()Ljava/lang/String;", "keyObject", "getKeyObject", "()Lcom/bytedance/android/sdk/bdticketguard/key/KeyObject;", "Lcom/bytedance/android/sdk/bdticketguard/key/KeyObject;", "getKeystoreAlias", "sp", "Landroid/content/SharedPreferences;", "getSp", "()Landroid/content/SharedPreferences;", "completeKeyObject", "", "containsAlias", "generateKeyPair", "scene", "(Ljava/lang/String;)Lcom/bytedance/android/sdk/bdticketguard/key/KeyObject;", "getCreateLogSpKey", "getSpKeyPrivate", "getSpKeyPrivateSuffix", "getSpKeyPublic", "getSpKeyPublicPrefix", "loadKeyPair", "markCreateLog", "", TicketGuardProviderKt.PATH_SIGN, "", "data", "path", "tryGetKey", SettingsManager.VERIFY_SERVICE, "pubInfo", "signature", "(Ljava/lang/Object;[B[B)Z", "bd_ticket_guard_core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class AbsKeyHelper<K extends KeyObject, PubInfo> {
    private final String SP_KEY_CREATE_LOG;
    private final Context context;
    private String createLog;
    private K keyObject;
    private final String keystoreAlias;
    private final SharedPreferences sp;

    public abstract boolean completeKeyObject();

    public abstract boolean containsAlias();

    public abstract K generateKeyPair(String scene);

    protected abstract String getCreateLogSpKey();

    public abstract String getSpKeyPrivateSuffix();

    public abstract String getSpKeyPublicPrefix();

    public abstract K loadKeyPair(String scene);

    public abstract byte[] sign(byte[] data, String path);

    public abstract boolean verify(PubInfo pubInfo, byte[] data, byte[] signature);

    public AbsKeyHelper(Context context, String str) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "keystoreAlias");
        this.context = context;
        this.keystoreAlias = str;
        SharedPreferences sharedPreferences = context.getSharedPreferences("sp_TicketGuardHelper", 0);
        Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        this.sp = sharedPreferences;
        String str2 = getCreateLogSpKey() + '_' + str;
        this.SP_KEY_CREATE_LOG = str2;
        this.createLog = sharedPreferences.getString(str2, "");
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getKeystoreAlias() {
        return this.keystoreAlias;
    }

    public final K getKeyObject() {
        return this.keyObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SharedPreferences getSp() {
        return this.sp;
    }

    public final String getCreateLog() {
        return this.createLog;
    }

    private final void markCreateLog() {
        this.createLog += ",timestamp=" + System.currentTimeMillis();
        this.sp.edit().putString(this.SP_KEY_CREATE_LOG, this.createLog).apply();
    }

    public final boolean tryGetKey(String scene) {
        K generateKeyPair;
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        K k = this.keyObject;
        boolean z = true;
        if (k != null && k.isComplete()) {
            return true;
        }
        synchronized (this) {
            K k2 = this.keyObject;
            if (k2 != null && k2.isComplete()) {
                return true;
            }
            if (this.keyObject != null) {
                return completeKeyObject();
            }
            try {
                boolean containsAlias = containsAlias();
                boolean z2 = this.sp.getBoolean("has_gen_key", false);
                if (!containsAlias && z2) {
                    TicketGuardEventHelper.monitorContainsAliasNotMatch();
                }
                if (containsAlias) {
                    generateKeyPair = loadKeyPair(scene);
                } else {
                    generateKeyPair = generateKeyPair(scene);
                }
                if (generateKeyPair != null) {
                    if (!z2) {
                        this.sp.edit().putBoolean("has_gen_key", true).apply();
                    }
                    if (generateKeyPair.getNewKey()) {
                        markCreateLog();
                    }
                } else {
                    generateKeyPair = null;
                }
                this.keyObject = generateKeyPair;
                if (generateKeyPair == null || !generateKeyPair.isComplete()) {
                    z = false;
                }
                return z;
            } catch (Throwable th) {
                TicketGuardInnerFrameWork.log("containsAlias failed, e=" + Log.getStackTraceString(th));
                TicketGuardEventHelper.monitorContainsAliasError(scene, th);
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getSpKeyPublic() {
        return getSpKeyPublicPrefix() + "_" + this.keystoreAlias;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getSpKeyPrivate() {
        return getSpKeyPrivateSuffix() + "_" + this.keystoreAlias;
    }
}
