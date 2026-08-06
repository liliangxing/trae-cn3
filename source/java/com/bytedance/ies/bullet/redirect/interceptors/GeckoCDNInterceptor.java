package com.bytedance.ies.bullet.redirect.interceptors;

import com.bytedance.ies.bullet.base.settings.AnnieXRedirectSettingsConfig;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.redirect.AnnieXRedirectImplProcessor;
import com.bytedance.ies.bullet.redirect.api.IAnnieXRedirectInterceptor;
import com.bytedance.ies.bullet.redirect.data.GeckoCDNSource;
import com.bytedance.ies.bullet.redirect.data.RedirectInputInfo;
import com.bytedance.ies.bullet.redirect.data.RedirectOutputInfo;
import com.bytedance.ies.bullet.redirect.data.RedirectReportInfo;
import com.bytedance.ies.bullet.redirect.data.RedirectSettingsData;
import com.bytedance.ies.bullet.redirect.helper.ObservableWrapper;
import com.bytedance.ies.bullet.redirect.helper.RedirectRuleStorage;
import com.bytedance.ies.bullet.settings.data.IBulletSettings;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.lynx.service.image.LynxImageService;
import com.bytedance.news.common.settings.IndividualManager;
import com.bytedance.news.common.settings.SettingsUpdateListener;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.pia.core.metrics.ErrorType;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeckoCDNInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\bH\u0002Jk\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001a0 26\u0010$\u001a2\u0012\u0013\u0012\u00110&¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001a0%H\u0016J\n\u0010)\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010*\u001a\u00020\u001aH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006+"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/interceptors/GeckoCDNInterceptor;", "Lcom/bytedance/ies/bullet/redirect/api/IAnnieXRedirectInterceptor;", "diskStorage", "Lcom/bytedance/ies/bullet/redirect/helper/RedirectRuleStorage;", "cdnUrl", "", "(Lcom/bytedance/ies/bullet/redirect/helper/RedirectRuleStorage;Ljava/lang/String;)V", "cacheSettings", "Lcom/bytedance/ies/bullet/redirect/data/RedirectSettingsData;", "getCdnUrl", "()Ljava/lang/String;", "getDiskStorage", "()Lcom/bytedance/ies/bullet/redirect/helper/RedirectRuleStorage;", "geckoCDNSource", "Lcom/bytedance/ies/bullet/redirect/data/GeckoCDNSource;", "lock", "", "pollDisposable", "Lio/reactivex/disposables/Disposable;", ErrorType.SETTINGS, "Lcom/bytedance/ies/bullet/settings/data/IBulletSettings;", "getSettings", "()Lcom/bytedance/ies/bullet/settings/data/IBulletSettings;", "settings$delegate", "Lkotlin/Lazy;", "continuePollConfig", "", "diskCache", "intercept", "info", "Lcom/bytedance/ies/bullet/redirect/data/RedirectInputInfo;", "success", "Lkotlin/Function1;", "Lcom/bytedance/ies/bullet/redirect/data/RedirectOutputInfo;", "Lkotlin/ParameterName;", "name", SccResult.MESSAGE_FAIL, "Lkotlin/Function2;", "", "code", "msg", "memCache", "refreshCache", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class GeckoCDNInterceptor implements IAnnieXRedirectInterceptor {
    private volatile RedirectSettingsData cacheSettings;
    private final String cdnUrl;
    private final RedirectRuleStorage diskStorage;
    private final GeckoCDNSource geckoCDNSource;
    private final Object lock;
    private Disposable pollDisposable;

    /* renamed from: settings$delegate, reason: from kotlin metadata */
    private final Lazy settings;

    public GeckoCDNInterceptor(RedirectRuleStorage redirectRuleStorage, String str) {
        Intrinsics.checkNotNullParameter(redirectRuleStorage, "diskStorage");
        this.diskStorage = redirectRuleStorage;
        this.cdnUrl = str;
        this.settings = LazyKt.lazy(new Function0<IBulletSettings>() { // from class: com.bytedance.ies.bullet.redirect.interceptors.GeckoCDNInterceptor$settings$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final IBulletSettings m548invoke() {
                return (IBulletSettings) IndividualManager.obtainManager("Bullet").obtain(IBulletSettings.class);
            }
        });
        GeckoCDNSource geckoCDNSource = new GeckoCDNSource();
        geckoCDNSource.setCdnSourceUrl(str);
        this.geckoCDNSource = geckoCDNSource;
        this.lock = new Object();
        IndividualManager.obtainManager("Bullet").registerListener(new SettingsUpdateListener() { // from class: com.bytedance.ies.bullet.redirect.interceptors.GeckoCDNInterceptor.1
            @Override // com.bytedance.news.common.settings.SettingsUpdateListener
            public final void onSettingsUpdate(SettingsData settingsData) {
                GeckoCDNInterceptor.this.continuePollConfig();
            }
        }, false);
    }

    public /* synthetic */ GeckoCDNInterceptor(RedirectRuleStorage redirectRuleStorage, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(redirectRuleStorage, (i & 2) != 0 ? null : str);
    }

    public final String getCdnUrl() {
        return this.cdnUrl;
    }

    public final RedirectRuleStorage getDiskStorage() {
        return this.diskStorage;
    }

    private final IBulletSettings getSettings() {
        return (IBulletSettings) this.settings.getValue();
    }

    @Override // com.bytedance.ies.bullet.redirect.api.IAnnieXRedirectInterceptor
    public void intercept(final RedirectInputInfo info, final Function1<? super RedirectOutputInfo, Unit> success, final Function2<? super Integer, ? super String, Unit> fail) {
        RedirectSettingsData memCache;
        RedirectReportInfo.Category category;
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(success, "success");
        Intrinsics.checkNotNullParameter(fail, SccResult.MESSAGE_FAIL);
        synchronized (this.lock) {
            memCache = memCache();
            if (memCache != null) {
                RedirectReportInfo reportInfo = info.getReportInfo();
                RedirectReportInfo.Category category2 = reportInfo != null ? reportInfo.getCategory() : null;
                if (category2 != null) {
                    category2.setConfigType("memory");
                }
            } else {
                memCache = diskCache();
                if (memCache != null) {
                    RedirectReportInfo reportInfo2 = info.getReportInfo();
                    RedirectReportInfo.Category category3 = reportInfo2 != null ? reportInfo2.getCategory() : null;
                    if (category3 != null) {
                        category3.setConfigType(LynxImageService.CACHE_DISK);
                    }
                }
            }
        }
        if (memCache != null) {
            RedirectReportInfo reportInfo3 = info.getReportInfo();
            category = reportInfo3 != null ? reportInfo3.getCategory() : null;
            if (category != null) {
                String geckoCDNVersion = memCache.getGeckoCDNVersion();
                if (geckoCDNVersion == null) {
                    geckoCDNVersion = "";
                }
                category.setConfigVersion(geckoCDNVersion);
            }
            RedirectOutputInfo targetInfoWithEntryKey = memCache.getTargetInfoWithEntryKey(info);
            Integer errorCode = targetInfoWithEntryKey.getErrorCode();
            if (errorCode != null && errorCode.intValue() == 0) {
                success.invoke(targetInfoWithEntryKey);
                return;
            }
            Integer errorCode2 = targetInfoWithEntryKey.getErrorCode();
            Integer valueOf = Integer.valueOf(errorCode2 != null ? errorCode2.intValue() : -1);
            String errorMsg = targetInfoWithEntryKey.getErrorMsg();
            if (errorMsg == null) {
                errorMsg = "";
            }
            fail.invoke(valueOf, errorMsg);
            return;
        }
        RedirectReportInfo reportInfo4 = info.getReportInfo();
        category = reportInfo4 != null ? reportInfo4.getCategory() : null;
        if (category != null) {
            category.setConfigType("remote");
        }
        this.geckoCDNSource.provide().subscribeOn(Schedulers.io()).subscribe(new Consumer() { // from class: com.bytedance.ies.bullet.redirect.interceptors.GeckoCDNInterceptor$intercept$dispose$1
            public final void accept(RedirectSettingsData redirectSettingsData) {
                Object obj;
                obj = GeckoCDNInterceptor.this.lock;
                GeckoCDNInterceptor geckoCDNInterceptor = GeckoCDNInterceptor.this;
                synchronized (obj) {
                    RedirectRuleStorage diskStorage = geckoCDNInterceptor.getDiskStorage();
                    Intrinsics.checkNotNullExpressionValue(redirectSettingsData, "it");
                    diskStorage.save(redirectSettingsData);
                    geckoCDNInterceptor.cacheSettings = redirectSettingsData;
                    Unit unit = Unit.INSTANCE;
                }
                RedirectOutputInfo targetInfoWithEntryKey2 = redirectSettingsData.getTargetInfoWithEntryKey(info);
                RedirectReportInfo reportInfo5 = info.getReportInfo();
                RedirectReportInfo.Category category4 = reportInfo5 != null ? reportInfo5.getCategory() : null;
                if (category4 != null) {
                    String geckoCDNVersion2 = redirectSettingsData.getGeckoCDNVersion();
                    if (geckoCDNVersion2 == null) {
                        geckoCDNVersion2 = "";
                    }
                    category4.setConfigVersion(geckoCDNVersion2);
                }
                Integer errorCode3 = targetInfoWithEntryKey2.getErrorCode();
                if (errorCode3 != null && errorCode3.intValue() == 0) {
                    success.invoke(targetInfoWithEntryKey2);
                    return;
                }
                Function2<Integer, String, Unit> function2 = fail;
                Integer errorCode4 = targetInfoWithEntryKey2.getErrorCode();
                Integer valueOf2 = Integer.valueOf(errorCode4 != null ? errorCode4.intValue() : -1);
                String errorMsg2 = targetInfoWithEntryKey2.getErrorMsg();
                if (errorMsg2 == null) {
                    errorMsg2 = "";
                }
                function2.invoke(valueOf2, errorMsg2);
            }
        }, new Consumer() { // from class: com.bytedance.ies.bullet.redirect.interceptors.GeckoCDNInterceptor$intercept$dispose$2
            public final void accept(Throwable th) {
                fail.invoke(2, "Gecko CDN request fail, " + th.getMessage());
            }
        });
    }

    private final RedirectSettingsData memCache() {
        RedirectSettingsData redirectSettingsData = this.cacheSettings;
        if (redirectSettingsData == null) {
            return null;
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, AnnieXRedirectImplProcessor.TAG, "settings use memory cache", null, null, 12, null);
        if (!redirectSettingsData.isExpired()) {
            return redirectSettingsData;
        }
        refreshCache();
        return redirectSettingsData;
    }

    private final RedirectSettingsData diskCache() {
        RedirectSettingsData restore = this.diskStorage.restore();
        if (restore == null) {
            return null;
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, AnnieXRedirectImplProcessor.TAG, "settings use disk cache", null, null, 12, null);
        this.cacheSettings = restore;
        refreshCache();
        return restore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshCache() {
        HybridLogger.i$default(HybridLogger.INSTANCE, AnnieXRedirectImplProcessor.TAG, "start refresh", null, null, 12, null);
        this.geckoCDNSource.provide().subscribeOn(Schedulers.io()).subscribe(new Consumer() { // from class: com.bytedance.ies.bullet.redirect.interceptors.GeckoCDNInterceptor$refreshCache$dispose$1
            public final void accept(RedirectSettingsData redirectSettingsData) {
                Object obj;
                obj = GeckoCDNInterceptor.this.lock;
                GeckoCDNInterceptor geckoCDNInterceptor = GeckoCDNInterceptor.this;
                synchronized (obj) {
                    HybridLogger.i$default(HybridLogger.INSTANCE, AnnieXRedirectImplProcessor.TAG, "receive refresh result", null, null, 12, null);
                    RedirectRuleStorage diskStorage = geckoCDNInterceptor.getDiskStorage();
                    Intrinsics.checkNotNullExpressionValue(redirectSettingsData, "it");
                    diskStorage.save(redirectSettingsData);
                    geckoCDNInterceptor.cacheSettings = redirectSettingsData;
                    Unit unit = Unit.INSTANCE;
                }
            }
        }, new Consumer() { // from class: com.bytedance.ies.bullet.redirect.interceptors.GeckoCDNInterceptor$refreshCache$dispose$2
            public final void accept(Throwable th) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void continuePollConfig() {
        AnnieXRedirectSettingsConfig annieXRedirectConfig = getSettings().getAnnieXRedirectConfig();
        Long pollInterval = annieXRedirectConfig != null ? annieXRedirectConfig.getPollInterval() : null;
        if (pollInterval != null && pollInterval.longValue() > 0) {
            Disposable disposable = this.pollDisposable;
            if (disposable != null) {
                disposable.dispose();
            }
            this.pollDisposable = ObservableWrapper.INSTANCE.interval(10L, pollInterval.longValue(), TimeUnit.SECONDS).subscribe(new Consumer() { // from class: com.bytedance.ies.bullet.redirect.interceptors.GeckoCDNInterceptor$continuePollConfig$1
                public final void accept(Long l) {
                    GeckoCDNInterceptor.this.continuePollConfig();
                    GeckoCDNInterceptor.this.refreshCache();
                }
            });
            return;
        }
        Disposable disposable2 = this.pollDisposable;
        if (disposable2 != null) {
            disposable2.dispose();
        }
    }
}
