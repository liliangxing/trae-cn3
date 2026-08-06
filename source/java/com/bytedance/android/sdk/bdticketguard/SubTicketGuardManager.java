package com.bytedance.android.sdk.bdticketguard;

import com.bytedance.bdturing.methods.JsCallParser;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: SubTicketGuardManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\u001a\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010'\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010(\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010)\u001a\u0004\u0018\u00010\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\u0016J\u0010\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u0004H\u0016J\u001a\u0010.\u001a\u0004\u0018\u00010\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\u0016J\u001c\u0010/\u001a\u00020\"2\b\u00100\u001a\u0004\u0018\u00010\u00042\b\u00101\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u00102\u001a\u00020\"2\u0006\u00103\u001a\u00020\u001fH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/SubTicketGuardManager;", "Lcom/bytedance/android/sdk/bdticketguard/TicketGuardManager;", "()V", "base64ReePub", "", "clientCert", TicketGuardProviderKt.COL_CSR, "needRee", "", "providerHelper", "Lcom/bytedance/android/sdk/bdticketguard/TicketGuardProviderHelper;", "getProviderHelper", "()Lcom/bytedance/android/sdk/bdticketguard/TicketGuardProviderHelper;", "providerHelper$delegate", "Lkotlin/Lazy;", "teeHasEverFail", TicketGuardProviderKt.PATH_DECRYPT, "", "content", TicketGuardProviderKt.PATH_ENCRYPT, "getBase64ReePub", "getClientCert", "getCsr", "getDeltaPublicKey", "getReeCreateLog", "getServerCert", "Lcom/bytedance/android/sdk/bdticketguard/ServerCert;", "getTeeCreateLog", "getTeeEverFail", "getTeePublic", "getTicketData", "Lcom/bytedance/android/sdk/bdticketguard/TicketDataBean;", "ticket", "invalidServerCert", "", "loadEncryption", "scene", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/android/sdk/bdticketguard/TicketInitCallback;", "loadRee", "loadTee", "reeSign", TicketGuardProviderKt.PARAM_UNSIGNED, "path", "setTeeEverFail", "reason", TicketGuardProviderKt.PATH_SIGN, "updateLocalCert", "resClientCert", "resServerCert", "updateTicketData", "ticketData", "bd_ticket_guard_core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class SubTicketGuardManager extends TicketGuardManager {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SubTicketGuardManager.class), "providerHelper", "getProviderHelper()Lcom/bytedance/android/sdk/bdticketguard/TicketGuardProviderHelper;"))};
    private String base64ReePub;
    private String clientCert;
    private String csr;
    private boolean needRee;

    /* renamed from: providerHelper$delegate, reason: from kotlin metadata */
    private final Lazy providerHelper = LazyKt.lazy(new Function0<TicketGuardProviderHelper>() { // from class: com.bytedance.android.sdk.bdticketguard.SubTicketGuardManager$providerHelper$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final TicketGuardProviderHelper m399invoke() {
            return new TicketGuardProviderHelper(SubTicketGuardManager.this.getTicketGuardInitParam().getApplicationContext());
        }
    });
    private boolean teeHasEverFail;

    private final TicketGuardProviderHelper getProviderHelper() {
        Lazy lazy = this.providerHelper;
        KProperty kProperty = $$delegatedProperties[0];
        return (TicketGuardProviderHelper) lazy.getValue();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public void loadRee(final String scene, final TicketInitCallback callback) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        InitStatus initStatus = getInitStatusMap().get(TicketGuardApiKt.INIT_STATUS_REE);
        if (initStatus == null) {
            Intrinsics.throwNpe();
        }
        final InitStatus initStatus2 = initStatus;
        if (!Intrinsics.areEqual(initStatus2.getInitResult(), true)) {
            getProviderHelper().loadRee(scene, new TicketInitCallback() { // from class: com.bytedance.android.sdk.bdticketguard.SubTicketGuardManager$loadRee$$inlined$apply$lambda$1
                @Override // com.bytedance.android.sdk.bdticketguard.TicketInitCallback
                public void onFinish(Boolean initResult) {
                    InitStatus.this.setInitResult(initResult);
                    TicketInitCallback ticketInitCallback = callback;
                    if (ticketInitCallback != null) {
                        ticketInitCallback.onFinish(initResult);
                    }
                }
            });
        } else if (callback != null) {
            callback.onFinish(true);
        }
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public void loadTee(final String scene, final TicketInitCallback callback) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        InitStatus initStatus = getInitStatusMap().get(TicketGuardApiKt.INIT_STATUS_TEE);
        if (initStatus == null) {
            Intrinsics.throwNpe();
        }
        final InitStatus initStatus2 = initStatus;
        if (!Intrinsics.areEqual(initStatus2.getInitResult(), true)) {
            getProviderHelper().loadTee(scene, new TicketInitCallback() { // from class: com.bytedance.android.sdk.bdticketguard.SubTicketGuardManager$loadTee$$inlined$apply$lambda$1
                @Override // com.bytedance.android.sdk.bdticketguard.TicketInitCallback
                public void onFinish(Boolean initResult) {
                    InitStatus.this.setInitResult(initResult);
                    TicketInitCallback ticketInitCallback = callback;
                    if (ticketInitCallback != null) {
                        ticketInitCallback.onFinish(initResult);
                    }
                }
            });
        } else if (callback != null) {
            callback.onFinish(true);
        }
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public void loadEncryption(final String scene, final TicketInitCallback callback) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        InitStatus initStatus = getInitStatusMap().get(TicketGuardApiKt.INIT_STATUS_ENCRYPTION);
        if (initStatus == null) {
            Intrinsics.throwNpe();
        }
        final InitStatus initStatus2 = initStatus;
        if (!Intrinsics.areEqual(initStatus2.getInitResult(), true)) {
            getProviderHelper().loadEncryption(scene, new TicketInitCallback() { // from class: com.bytedance.android.sdk.bdticketguard.SubTicketGuardManager$loadEncryption$$inlined$apply$lambda$1
                @Override // com.bytedance.android.sdk.bdticketguard.TicketInitCallback
                public void onFinish(Boolean initResult) {
                    InitStatus.this.setInitResult(initResult);
                    TicketInitCallback ticketInitCallback = callback;
                    if (ticketInitCallback != null) {
                        ticketInitCallback.onFinish(initResult);
                    }
                }
            });
        } else if (callback != null) {
            callback.onFinish(true);
        }
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public String getCsr() {
        String str = this.csr;
        if (str == null || str.length() == 0) {
            this.csr = getProviderHelper().getCsr();
        }
        return this.csr;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public String getBase64ReePub() {
        String str = this.base64ReePub;
        if (str == null || str.length() == 0) {
            this.base64ReePub = getProviderHelper().getBase64ReePub();
        }
        return this.base64ReePub;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public boolean needRee() {
        if (!this.needRee) {
            this.needRee = getProviderHelper().getNeedRee();
        }
        return this.needRee;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public boolean getTeeEverFail() {
        if (!this.teeHasEverFail) {
            this.teeHasEverFail = getProviderHelper().getTeeEverFail();
        }
        return this.teeHasEverFail;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public String getTeePublic() {
        return getProviderHelper().getTeePublic();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public void setTeeEverFail(String reason) {
        Intrinsics.checkParameterIsNotNull(reason, "reason");
        getProviderHelper().setTeeEverFail(reason);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public String getClientCert() {
        String str = this.clientCert;
        if (str == null || str.length() == 0) {
            this.clientCert = getProviderHelper().getClientCert();
        }
        return this.clientCert;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public ServerCert getServerCert() {
        return getProviderHelper().getServerCert();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public String sign(String unsigned, String path) {
        Intrinsics.checkParameterIsNotNull(unsigned, TicketGuardProviderKt.PARAM_UNSIGNED);
        Intrinsics.checkParameterIsNotNull(path, "path");
        return getProviderHelper().getBase64Signed(unsigned, path, TicketGuardProviderKt.VALUE_SIGN_TYPE_TEE);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public String reeSign(String unsigned, String path) {
        Intrinsics.checkParameterIsNotNull(unsigned, TicketGuardProviderKt.PARAM_UNSIGNED);
        Intrinsics.checkParameterIsNotNull(path, "path");
        return getProviderHelper().getBase64Signed(unsigned, path, TicketGuardProviderKt.VALUE_SIGN_TYPE_REE);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public void invalidServerCert() {
        getProviderHelper().clearServerCert();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public byte[] encrypt(byte[] content) {
        Intrinsics.checkParameterIsNotNull(content, "content");
        return getProviderHelper().encrypt(content);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public byte[] decrypt(byte[] content) {
        Intrinsics.checkParameterIsNotNull(content, "content");
        return getProviderHelper().decrypt(content);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public String getDeltaPublicKey() {
        return getProviderHelper().getDeltaPublicKey();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public void updateTicketData(TicketDataBean ticketData) {
        Intrinsics.checkParameterIsNotNull(ticketData, "ticketData");
        getProviderHelper().updateTicketData(ticketData);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public TicketDataBean getTicketData(String ticket) {
        Intrinsics.checkParameterIsNotNull(ticket, "ticket");
        return getProviderHelper().getTicketData(ticket);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardService
    public void updateLocalCert(String resClientCert, String resServerCert) {
        getProviderHelper().updateLocalCert(resClientCert, resServerCert);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public String getTeeCreateLog() {
        return getProviderHelper().getTeeCreateLog();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.TicketGuardManager
    public String getReeCreateLog() {
        return getProviderHelper().getReeCreateLog();
    }
}
