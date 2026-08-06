package com.bytedance.upc;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.upc.DialogImpl;
import com.bytedance.upc.PopupImpl;
import com.bytedance.upc.PrivacyImpl;
import com.bytedance.upc.TeenImpl;
import com.bytedance.upc.common.monitor.UpcMonitor;
import com.bytedance.upc.common.settings.UpcOnlineSettings;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpcImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/upc/UpcImpl;", "Lcom/bytedance/upc/IUpc;", "Lcom/bytedance/upc/PrivacyImpl;", "Lcom/bytedance/upc/DialogImpl;", "Lcom/bytedance/upc/TeenImpl;", "Lcom/bytedance/upc/PopupImpl;", "()V", "init", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mConfiguration", "Lcom/bytedance/upc/Configuration;", "mContext", "Landroid/content/Context;", "mDeviceId", "", "mUserId", "start", "", "context", "configuration", "initService", "load", "", "scheme", "open", "did", "uid", "updateSettings", "settings", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class UpcImpl implements IUpc, PrivacyImpl, DialogImpl, TeenImpl, PopupImpl {
    private Configuration mConfiguration;
    private Context mContext;
    private String mDeviceId;
    private String mUserId;
    private final AtomicBoolean init = new AtomicBoolean(false);
    private final AtomicBoolean start = new AtomicBoolean(false);

    @Override // com.bytedance.upc.PrivacyImpl, com.bytedance.upc.IPrivacy
    public void addPrivacyStatusChangeListener(IPrivacyChangeListener iPrivacyChangeListener) {
        Intrinsics.checkParameterIsNotNull(iPrivacyChangeListener, "listener");
        PrivacyImpl.DefaultImpls.addPrivacyStatusChangeListener(this, iPrivacyChangeListener);
    }

    @Override // com.bytedance.upc.PrivacyImpl, com.bytedance.upc.IPrivacy
    public boolean clearPrivacyStatus(boolean z) {
        return PrivacyImpl.DefaultImpls.clearPrivacyStatus(this, z);
    }

    @Override // com.bytedance.upc.DialogImpl, com.bytedance.upc.IDialog
    public void disMissDialog(String str) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        DialogImpl.DefaultImpls.disMissDialog(this, str);
    }

    @Override // com.bytedance.upc.TeenImpl, com.bytedance.upc.ITeenMode
    public long getAllowStayDuration() {
        return TeenImpl.DefaultImpls.getAllowStayDuration(this);
    }

    @Override // com.bytedance.upc.PrivacyImpl, com.bytedance.upc.IPrivacy
    public String getPrivacyStatus(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        return PrivacyImpl.DefaultImpls.getPrivacyStatus(this, str, str2);
    }

    @Override // com.bytedance.upc.TeenImpl, com.bytedance.upc.ITeenMode
    public void getTeenModeEnable(Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        TeenImpl.DefaultImpls.getTeenModeEnable(this, function1);
    }

    @Override // com.bytedance.upc.TeenImpl, com.bytedance.upc.ITeenMode
    public long getTeenModeEntryDuration() {
        return TeenImpl.DefaultImpls.getTeenModeEntryDuration(this);
    }

    @Override // com.bytedance.upc.PrivacyImpl, com.bytedance.upc.IPrivacy
    public void removePrivacyStatusChangeListener(IPrivacyChangeListener iPrivacyChangeListener) {
        Intrinsics.checkParameterIsNotNull(iPrivacyChangeListener, "listener");
        PrivacyImpl.DefaultImpls.removePrivacyStatusChangeListener(this, iPrivacyChangeListener);
    }

    @Override // com.bytedance.upc.PrivacyImpl, com.bytedance.upc.IPrivacy
    public boolean setPrivacyStatus(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        return PrivacyImpl.DefaultImpls.setPrivacyStatus(this, str, str2);
    }

    @Override // com.bytedance.upc.TeenImpl, com.bytedance.upc.ITeenMode
    public void setTeenModeAllowStayDuration(long j) {
        TeenImpl.DefaultImpls.setTeenModeAllowStayDuration(this, j);
    }

    @Override // com.bytedance.upc.TeenImpl, com.bytedance.upc.ITeenMode
    public void setTeenModeEnable(boolean z, String str, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(str, "passwd");
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        TeenImpl.DefaultImpls.setTeenModeEnable(this, z, str, function1);
    }

    @Override // com.bytedance.upc.DialogImpl, com.bytedance.upc.IDialog
    public boolean showDialog(String str, Activity activity, IUpcDialog iUpcDialog) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(iUpcDialog, "iUpcDialog");
        return DialogImpl.DefaultImpls.showDialog(this, str, activity, iUpcDialog);
    }

    @Override // com.bytedance.upc.PopupImpl, com.bytedance.upc.IPopup
    public void showPopup(String str, String str2, String str3, IUpcPopupGuideCallback iUpcPopupGuideCallback) {
        Intrinsics.checkParameterIsNotNull(str, "permission");
        Intrinsics.checkParameterIsNotNull(str2, "popupTitle");
        Intrinsics.checkParameterIsNotNull(str3, "popupContent");
        PopupImpl.DefaultImpls.showPopup(this, str, str2, str3, iUpcPopupGuideCallback);
    }

    @Override // com.bytedance.upc.DialogImpl, com.bytedance.upc.IDialog
    public void tryCheckPrivacy(Activity activity, Map<String, ? extends IUpcPrivacyDialog> map) {
        Intrinsics.checkParameterIsNotNull(map, "config");
        DialogImpl.DefaultImpls.tryCheckPrivacy(this, activity, map);
    }

    @Override // com.bytedance.upc.IUpc
    public void init(final Context context, final Configuration configuration) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(configuration, "configuration");
        if (this.init.get()) {
            return;
        }
        UpcMonitor.INSTANCE.monitorInitCost(new Function0<Unit>() { // from class: com.bytedance.upc.UpcImpl$init$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m6495invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m6495invoke() {
                UpcImpl.this.mContext = context;
                UpcImpl.this.mConfiguration = configuration;
                UpcImpl.this.initService();
            }
        });
        this.init.set(true);
    }

    @Override // com.bytedance.upc.IUpc
    public void start(String did, String uid) {
        if (!this.init.get() || this.start.get() || TextUtils.isEmpty(did)) {
            return;
        }
        this.mDeviceId = did;
        this.mUserId = uid;
        this.start.set(true);
    }

    @Override // com.bytedance.upc.IUpc
    public boolean load(String scheme) {
        ILoaderService iLoaderService;
        Intrinsics.checkParameterIsNotNull(scheme, "scheme");
        Configuration configuration = this.mConfiguration;
        if (configuration == null || (iLoaderService = configuration.mILoaderService) == null) {
            return false;
        }
        return iLoaderService.load(scheme);
    }

    @Override // com.bytedance.upc.IUpc
    public boolean open(String scheme) {
        IOpenService iOpenService;
        Intrinsics.checkParameterIsNotNull(scheme, "scheme");
        Configuration configuration = this.mConfiguration;
        if (configuration == null || (iOpenService = configuration.mIOpenService) == null) {
            return false;
        }
        return iOpenService.open(scheme);
    }

    @Override // com.bytedance.upc.IUpc
    public void updateSettings(String settings) {
        UpcOnlineSettings.updateSetting(settings);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initService() {
        IUpcTeenModeService iUpcTeenModeService;
        IBridgeService iBridgeService;
        IPrivacyService iPrivacyService;
        Set services = ServiceManager.get().getServices(IUpcLifecycleService.class);
        Intrinsics.checkExpressionValueIsNotNull(services, "ServiceManager.get().get…cycleService::class.java)");
        for (IUpcLifecycleService iUpcLifecycleService : CollectionsKt.sortedWith(services, new Comparator<T>() { // from class: com.bytedance.upc.UpcImpl$initService$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((IUpcLifecycleService) t).priority()), Integer.valueOf(((IUpcLifecycleService) t2).priority()));
            }
        })) {
            Context context = this.mContext;
            if (context == null) {
                Intrinsics.throwNpe();
            }
            Configuration configuration = this.mConfiguration;
            if (configuration == null) {
                Intrinsics.throwNpe();
            }
            iUpcLifecycleService.init(context, configuration);
        }
        try {
            Configuration configuration2 = this.mConfiguration;
            if (configuration2 != null && configuration2.mNeedInitRpc) {
                Class.forName("com.bytedance.upc.privacy.report.rpc.UpcRpcService").getMethod("init", Context.class).invoke(null, this.mContext);
            }
        } catch (Throwable unused) {
        }
        try {
            Configuration configuration3 = this.mConfiguration;
            if (configuration3 != null && (iPrivacyService = configuration3.mIPrivacyService) != null) {
                iPrivacyService.init();
            }
            Configuration configuration4 = this.mConfiguration;
            if (configuration4 != null && (iBridgeService = configuration4.mIBridgeService) != null) {
                iBridgeService.init();
            }
            Configuration configuration5 = this.mConfiguration;
            if (configuration5 == null || (iUpcTeenModeService = configuration5.mIUpcTeenModeService) == null) {
                return;
            }
            iUpcTeenModeService.init();
        } catch (Throwable unused2) {
        }
    }
}
