package com.bytedance.android.sdk.bdticketguard;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import com.bytedance.android.sdk.bdticketguard.key.ReeKeyHelper;
import com.bytedance.android.sdk.bdticketguard.key.ReeKeyObject;
import com.bytedance.android.sdk.bdticketguard.key.TeeKeyHelper;
import com.bytedance.android.sdk.bdticketguard.key.TeeKeyHelperKt;
import com.bytedance.android.sdk.bdticketguard.key.TeeKeyObject;
import com.bytedance.bdturing.methods.JsCallParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.Charsets;

/* compiled from: MainTicketGuardManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 A2\u00020\u0001:\u0001AB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010#\u001a\u00020\u000bH\u0016J\n\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u000bH\u0016J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u000bH\u0016J\u0012\u0010*\u001a\u0004\u0018\u00010\f2\u0006\u0010+\u001a\u00020\u000bH\u0016J\b\u0010,\u001a\u00020-H\u0016J\u001a\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u000b2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u001a\u00102\u001a\u00020-2\u0006\u0010/\u001a\u00020\u000b2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u001a\u00103\u001a\u00020-2\u0006\u0010/\u001a\u00020\u000b2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00104\u001a\u00020(H\u0016J\u001a\u00105\u001a\u0004\u0018\u00010\u000b2\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000bH\u0016J\u0010\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020\fH\u0002J\u0010\u0010:\u001a\u00020-2\u0006\u0010;\u001a\u00020\u000bH\u0016J\u001a\u0010<\u001a\u0004\u0018\u00010\u000b2\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000bH\u0016J\u001c\u0010=\u001a\u00020-2\b\u0010>\u001a\u0004\u0018\u00010\u000b2\b\u0010?\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010@\u001a\u00020-2\u0006\u00109\u001a\u00020\fH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R'\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\r\u0010\u000eR#\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\b\u001a\u0004\b\u0018\u0010\u0019¨\u0006B"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/MainTicketGuardManager;", "Lcom/bytedance/android/sdk/bdticketguard/TicketGuardManager;", "()V", "reeKeyHelper", "Lcom/bytedance/android/sdk/bdticketguard/key/ReeKeyHelper;", "getReeKeyHelper", "()Lcom/bytedance/android/sdk/bdticketguard/key/ReeKeyHelper;", "reeKeyHelper$delegate", "Lkotlin/Lazy;", "savedTicketData", "", "", "Lcom/bytedance/android/sdk/bdticketguard/TicketDataBean;", "getSavedTicketData", "()Ljava/util/Map;", "savedTicketData$delegate", "sp", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getSp", "()Landroid/content/SharedPreferences;", "sp$delegate", "teeKeyHelper", "Lcom/bytedance/android/sdk/bdticketguard/key/TeeKeyHelper;", "getTeeKeyHelper", "()Lcom/bytedance/android/sdk/bdticketguard/key/TeeKeyHelper;", "teeKeyHelper$delegate", TicketGuardProviderKt.PATH_DECRYPT, "", "content", TicketGuardProviderKt.PATH_ENCRYPT, "getBase64ReePub", "getClientCert", "getCsr", "getDeltaPublicKey", "getReeCreateLog", "getServerCert", "Lcom/bytedance/android/sdk/bdticketguard/ServerCert;", "getTeeCreateLog", "getTeeEverFail", "", "getTeePublic", "getTicketData", "ticket", "invalidServerCert", "", "loadEncryption", "scene", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/android/sdk/bdticketguard/TicketInitCallback;", "loadRee", "loadTee", "needRee", "reeSign", TicketGuardProviderKt.PARAM_UNSIGNED, "path", "removeTicketData", "ticketData", "setTeeEverFail", "reason", TicketGuardProviderKt.PATH_SIGN, "updateLocalCert", "resClientCert", "resServerCert", "updateTicketData", "Companion", "bd_ticket_guard_core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class MainTicketGuardManager extends TicketGuardManager {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MainTicketGuardManager.class), "sp", "getSp()Landroid/content/SharedPreferences;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MainTicketGuardManager.class), "teeKeyHelper", "getTeeKeyHelper()Lcom/bytedance/android/sdk/bdticketguard/key/TeeKeyHelper;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MainTicketGuardManager.class), "reeKeyHelper", "getReeKeyHelper()Lcom/bytedance/android/sdk/bdticketguard/key/ReeKeyHelper;")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MainTicketGuardManager.class), "savedTicketData", "getSavedTicketData()Ljava/util/Map;"))};
    private static final String KEY_STORE_ALIAS = "TicketGuardManager";
    private static final String SP_KEY_CLIENT_CERT = "sp_key_cert";
    private static final String SP_KEY_SAVED_TICKET_DATA = "sp_key_saved_ticket_data";
    public static final String SP_KEY_SERVER_CERT = "sp_key_server_cert";
    public static final String SP_NAME = "sp_TicketGuardManager";

    /* renamed from: sp$delegate, reason: from kotlin metadata */
    private final Lazy sp = LazyKt.lazy(new Function0<SharedPreferences>() { // from class: com.bytedance.android.sdk.bdticketguard.MainTicketGuardManager$sp$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SharedPreferences m397invoke() {
            return MainTicketGuardManager.this.getTicketGuardInitParam().getApplicationContext().getSharedPreferences(MainTicketGuardManager.SP_NAME, 0);
        }
    });

    /* renamed from: teeKeyHelper$delegate, reason: from kotlin metadata */
    private final Lazy teeKeyHelper = LazyKt.lazy(new Function0<TeeKeyHelper>() { // from class: com.bytedance.android.sdk.bdticketguard.MainTicketGuardManager$teeKeyHelper$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final TeeKeyHelper m398invoke() {
            return new TeeKeyHelper(MainTicketGuardManager.this.getTicketGuardInitParam().getApplicationContext(), TicketGuardManager.TAG, TeeKeyHelperKt.getPrincipal(TicketGuardManager.LOG_TAG, "", "", ""));
        }
    });

    /* renamed from: reeKeyHelper$delegate, reason: from kotlin metadata */
    private final Lazy reeKeyHelper = LazyKt.lazy(new Function0<ReeKeyHelper>() { // from class: com.bytedance.android.sdk.bdticketguard.MainTicketGuardManager$reeKeyHelper$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ReeKeyHelper m395invoke() {
            return new ReeKeyHelper(MainTicketGuardManager.this.getTicketGuardInitParam().getApplicationContext(), TicketGuardManager.TAG);
        }
    });

    /* renamed from: savedTicketData$delegate, reason: from kotlin metadata */
    private final Lazy savedTicketData = LazyKt.lazy(new Function0<Map<String, TicketDataBean>>() { // from class: com.bytedance.android.sdk.bdticketguard.MainTicketGuardManager$savedTicketData$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        public final Map<String, TicketDataBean> invoke() {
            SharedPreferences sp;
            SharedPreferences sp2;
            SharedPreferences sp3;
            MainTicketGuardManager.this.log("load savedTicketData start");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            sp = MainTicketGuardManager.this.getSp();
            SharedPreferences.Editor edit = sp.edit();
            sp2 = MainTicketGuardManager.this.getSp();
            Set<String> stringSet = sp2.getStringSet("sp_key_saved_ticket_data", null);
            Set<String> set = stringSet;
            if (!(set == null || set.isEmpty())) {
                Iterator<String> it = stringSet.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    String next = it.next();
                    sp3 = MainTicketGuardManager.this.getSp();
                    String string = sp3.getString(next, null);
                    String str = string;
                    if (!(str == null || str.length() == 0)) {
                        try {
                            TicketDataBean ticketDataBean = (TicketDataBean) MainTicketGuardManager.this.getGson().fromJson(string, TicketDataBean.class);
                            if (ticketDataBean != null) {
                                Intrinsics.checkExpressionValueIsNotNull(next, "type");
                                linkedHashMap.put(next, ticketDataBean);
                            }
                        } catch (Throwable th) {
                            it.remove();
                            edit.remove(next);
                            String stackTraceString = Log.getStackTraceString(th);
                            Intrinsics.checkExpressionValueIsNotNull(stackTraceString, "Log.getStackTraceString(e)");
                            TicketGuardEventHelper.monitorParseJsonError("load_ticket_data", string, stackTraceString);
                            z = true;
                        }
                    }
                }
                if (z) {
                    edit.putStringSet("sp_key_saved_ticket_data", stringSet);
                    edit.apply();
                }
            }
            MainTicketGuardManager.this.log("load savedTicketData finish");
            return linkedHashMap;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final ReeKeyHelper getReeKeyHelper() {
        Lazy lazy = this.reeKeyHelper;
        KProperty kProperty = $$delegatedProperties[2];
        return (ReeKeyHelper) lazy.getValue();
    }

    private final Map<String, TicketDataBean> getSavedTicketData() {
        Lazy lazy = this.savedTicketData;
        KProperty kProperty = $$delegatedProperties[3];
        return (Map) lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPreferences getSp() {
        Lazy lazy = this.sp;
        KProperty kProperty = $$delegatedProperties[0];
        return (SharedPreferences) lazy.getValue();
    }

    private final TeeKeyHelper getTeeKeyHelper() {
        Lazy lazy = this.teeKeyHelper;
        KProperty kProperty = $$delegatedProperties[1];
        return (TeeKeyHelper) lazy.getValue();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public boolean needRee() {
        return true;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public String getCsr() {
        TeeKeyObject keyObject = getTeeKeyHelper().getKeyObject();
        if (keyObject != null) {
            return keyObject.getCsr();
        }
        return null;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public String getClientCert() {
        TeeKeyObject keyObject = getTeeKeyHelper().getKeyObject();
        if (keyObject != null) {
            return keyObject.getBase64Cert();
        }
        return null;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public String getBase64ReePub() {
        ReeKeyObject keyObject = getReeKeyHelper().getKeyObject();
        if (keyObject != null) {
            return keyObject.getBase64PublicKey();
        }
        return null;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public boolean getTeeEverFail() {
        return getTeeKeyHelper().getHasEverFail();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public void setTeeEverFail(String reason) {
        Intrinsics.checkParameterIsNotNull(reason, "reason");
        getTeeKeyHelper().apiFail(reason, null);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public String getTeePublic() {
        String publicKeyBase64;
        TeeKeyObject keyObject = getTeeKeyHelper().getKeyObject();
        return (keyObject == null || (publicKeyBase64 = keyObject.getPublicKeyBase64()) == null) ? "" : publicKeyBase64;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public void loadRee(String scene, TicketInitCallback callback) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        InitStatus initStatus = getInitStatusMap().get(TicketGuardApiKt.INIT_STATUS_REE);
        if (initStatus == null) {
            Intrinsics.throwNpe();
        }
        InitStatus initStatus2 = initStatus;
        if (!Intrinsics.areEqual(initStatus2.getInitResult(), true)) {
            synchronized (initStatus2.getInitLock()) {
                if (true ^ Intrinsics.areEqual(initStatus2.getInitResult(), true)) {
                    initStatus2.setInitResult(Boolean.valueOf(getReeKeyHelper().tryGetKey(scene)));
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        initCallback(initStatus2.getInitResult(), callback);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public void loadTee(String scene, TicketInitCallback callback) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        InitStatus initStatus = getInitStatusMap().get(TicketGuardApiKt.INIT_STATUS_TEE);
        if (initStatus == null) {
            Intrinsics.throwNpe();
        }
        InitStatus initStatus2 = initStatus;
        if (!Intrinsics.areEqual(initStatus2.getInitResult(), true)) {
            synchronized (initStatus2.getInitLock()) {
                if (!Intrinsics.areEqual(initStatus2.getInitResult(), true)) {
                    initStatus2.setInitResult(Boolean.valueOf(getTeeKeyHelper().tryGetKey(scene)));
                    initCallback(initStatus2.getInitResult(), callback);
                    if (Intrinsics.areEqual(initStatus2.getInitResult(), true)) {
                        ArrayList arrayList = new ArrayList();
                        for (TicketDataBean ticketDataBean : getSavedTicketData().values()) {
                            String cert = ticketDataBean.getCert();
                            String str = cert;
                            if (str != null && str.length() != 0) {
                                z = false;
                                if (!z && Intrinsics.areEqual(getTeeKeyHelper().isKeyMatch(cert), false)) {
                                    arrayList.add(ticketDataBean);
                                }
                            }
                            z = true;
                            if (!z) {
                                arrayList.add(ticketDataBean);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                removeTicketData((TicketDataBean) it.next());
                            }
                        }
                    }
                    return;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        initCallback(initStatus2.getInitResult(), callback);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public void loadEncryption(String scene, TicketInitCallback callback) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        loadRee(scene, new MainTicketGuardManager$loadEncryption$1(this, scene, callback));
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public void updateLocalCert(String resClientCert, String resServerCert) {
        log("realUpdateLocalCert: resClientCert=" + resClientCert + ", resServerCert=" + resServerCert);
        String str = resClientCert;
        if (!(str == null || str.length() == 0)) {
            getTeeKeyHelper().updateClientCert(resClientCert);
        }
        String str2 = resServerCert;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        getReeKeyHelper().updateServerCert(resServerCert);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public ServerCert getServerCert() {
        return getReeKeyHelper().getServerCert();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public String sign(String unsigned, String path) {
        Intrinsics.checkParameterIsNotNull(unsigned, TicketGuardProviderKt.PARAM_UNSIGNED);
        Intrinsics.checkParameterIsNotNull(path, "path");
        TeeKeyHelper teeKeyHelper = getTeeKeyHelper();
        byte[] bytes = unsigned.getBytes(Charsets.UTF_8);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] sign = teeKeyHelper.sign(bytes, path);
        if (sign != null) {
            return Base64.encodeToString(sign, 2);
        }
        return null;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public String reeSign(String unsigned, String path) {
        Intrinsics.checkParameterIsNotNull(unsigned, TicketGuardProviderKt.PARAM_UNSIGNED);
        Intrinsics.checkParameterIsNotNull(path, "path");
        ReeKeyHelper reeKeyHelper = getReeKeyHelper();
        byte[] bytes = unsigned.getBytes(Charsets.UTF_8);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] sign = reeKeyHelper.sign(bytes, path);
        if (sign != null) {
            return Base64.encodeToString(sign, 2);
        }
        return null;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public void invalidServerCert() {
        getReeKeyHelper().invalidEncryption();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public byte[] encrypt(byte[] content) {
        Intrinsics.checkParameterIsNotNull(content, "content");
        return getReeKeyHelper().encrypt(content);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public byte[] decrypt(byte[] content) {
        Intrinsics.checkParameterIsNotNull(content, "content");
        try {
            long currentTimeMillis = System.currentTimeMillis();
            byte[] decrypt = getReeKeyHelper().decrypt(content);
            TicketGuardEventHelper.monitorDecryptResult(null, System.currentTimeMillis() - currentTimeMillis);
            return decrypt;
        } catch (Throwable th) {
            TicketGuardEventHelper.monitorDecryptResult(th, 0L);
            throw th;
        }
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public void updateTicketData(TicketDataBean ticketData) {
        Intrinsics.checkParameterIsNotNull(ticketData, "ticketData");
        log("realUpdateTicketData start");
        String str = getGson().toJson(ticketData).toString();
        getSavedTicketData().put(ticketData.getType(), ticketData);
        SharedPreferences.Editor edit = getSp().edit();
        edit.putString(ticketData.getType(), str);
        edit.putStringSet(SP_KEY_SAVED_TICKET_DATA, getSavedTicketData().keySet());
        edit.apply();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public TicketDataBean getTicketData(String ticket) {
        Intrinsics.checkParameterIsNotNull(ticket, "ticket");
        for (TicketDataBean ticketDataBean : getSavedTicketData().values()) {
            if (Intrinsics.areEqual(ticketDataBean.getTicket(), ticket)) {
                log("getTicketData success");
                return ticketDataBean;
            }
        }
        log("getTicketData fail");
        return null;
    }

    private final void removeTicketData(TicketDataBean ticketData) {
        TicketGuardEventHelper.INSTANCE.monitorRemoveTicketData(ticketData);
        String type = ticketData.getType();
        log("remove ticket data, type=" + type);
        getSavedTicketData().remove(type);
        SharedPreferences.Editor edit = getSp().edit();
        edit.remove(type);
        edit.putStringSet(SP_KEY_SAVED_TICKET_DATA, getSavedTicketData().keySet());
        edit.apply();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public String getDeltaPublicKey() {
        return getReeKeyHelper().getEncryptionPublicKey();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public String getTeeCreateLog() {
        String createLog = getTeeKeyHelper().getCreateLog();
        return createLog != null ? createLog : "";
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public String getReeCreateLog() {
        String createLog = getReeKeyHelper().getCreateLog();
        return createLog != null ? createLog : "";
    }
}
