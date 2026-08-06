package com.bytedance.pia.core.service;

import android.net.Uri;
import com.bytedance.ies.bullet.service.monitor.fluency.FluencyHelper;
import com.bytedance.pia.core.api.plugin.IPiaLifeCycle;
import com.bytedance.pia.core.api.services.IPiaLifeCycleService;
import com.bytedance.pia.core.api.utils.IReleasable;
import com.bytedance.pia.core.runtime.PiaLifeCycle;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.runtime.PiaRuntimeFactory;
import com.bytedance.pia.core.setting.Config;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.UrlUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* compiled from: PiaLifeCycleService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J(\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J2\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/pia/core/service/PiaLifeCycleService;", "Lcom/bytedance/pia/core/api/services/IPiaLifeCycleService;", "()V", "createLifeCycle", "Lcom/bytedance/pia/core/api/plugin/IPiaLifeCycle;", "nameSpace", "", "namespace", "customContext", "", "support", "", "uri", "Landroid/net/Uri;", "url", "warmup", "Lcom/bytedance/pia/core/api/utils/IReleasable;", FluencyHelper.STAGE, "Lcom/bytedance/pia/core/api/services/IPiaLifeCycleService$WarmupStage;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PiaLifeCycleService implements IPiaLifeCycleService {
    public static final PiaLifeCycleService INSTANCE = new PiaLifeCycleService();

    private PiaLifeCycleService() {
    }

    @Override // com.bytedance.pia.core.api.services.IPiaLifeCycleService
    public boolean support(String url) {
        Object obj;
        if (url == null) {
            return false;
        }
        if (!Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).getIsPiaQueryDisable()) {
            String str = url;
            if (!StringsKt.contains$default(str, PiaRuntime.SCHEMA_V1, false, 2, (Object) null) && !StringsKt.contains$default(str, "_pia_", false, 2, (Object) null)) {
                return false;
            }
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Uri.parse(url));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return support((Uri) (Result.isFailure-impl(obj) ? null : obj));
    }

    @Override // com.bytedance.pia.core.api.services.IPiaLifeCycleService
    public boolean support(Uri uri) {
        if (uri == null || !UrlUtils.isHttp(uri)) {
            return false;
        }
        Config.IProvider proxy = Config.INSTANCE.getProxy();
        if (proxy != null && proxy.contains(uri)) {
            return true;
        }
        if (!Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).getIsPiaEnabled() || !Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).isDomainAllowed(uri) || Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).isPageBlocked(uri)) {
            return false;
        }
        if (uri.getBooleanQueryParameter(PiaRuntime.SCHEMA_V1, false)) {
            return true;
        }
        if (Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).getIsPiaQueryDisable()) {
            if (!Config.INSTANCE.contains(uri) && !uri.getBooleanQueryParameter("_pia_", false)) {
                return false;
            }
        } else if (!uri.getBooleanQueryParameter("_pia_", false) || !Config.INSTANCE.contains(uri)) {
            return false;
        }
        return true;
    }

    @Override // com.bytedance.pia.core.api.services.IPiaLifeCycleService
    public IPiaLifeCycle createLifeCycle(String nameSpace) {
        return createLifeCycle(nameSpace, null);
    }

    @Override // com.bytedance.pia.core.api.services.IPiaLifeCycleService
    public IPiaLifeCycle createLifeCycle(String namespace, Object customContext) {
        if (namespace == null) {
            return null;
        }
        return new PiaLifeCycle(namespace, customContext);
    }

    @Override // com.bytedance.pia.core.api.services.IPiaLifeCycleService
    public IReleasable warmup(String url, String namespace) {
        return warmup(url, namespace, null);
    }

    @Override // com.bytedance.pia.core.api.services.IPiaLifeCycleService
    public IReleasable warmup(String url, String namespace, Object customContext) {
        return warmup(url, namespace, customContext, IPiaLifeCycleService.WarmupStage.Activate);
    }

    @Override // com.bytedance.pia.core.api.services.IPiaLifeCycleService
    public IReleasable warmup(String url, String namespace, Object customContext, IPiaLifeCycleService.WarmupStage stage) {
        return PiaRuntimeFactory.getInstance().warmup(url, namespace, customContext, stage);
    }
}
