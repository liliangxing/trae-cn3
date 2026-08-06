package com.bytedance.ies.bullet.preloadv2;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import com.bytedance.ies.bullet.core.RLReportController;
import com.bytedance.ies.bullet.kit.resourceloader.monitor.RLMonitorReporter;
import com.bytedance.ies.bullet.preloadv2.cache.FontPreloadItem;
import com.bytedance.ies.bullet.preloadv2.cache.HighSubResourceMemCache;
import com.bytedance.ies.bullet.preloadv2.cache.ImagePreloadItem;
import com.bytedance.ies.bullet.preloadv2.cache.PreloadItem;
import com.bytedance.ies.bullet.preloadv2.cache.SubResourceMemCache;
import com.bytedance.ies.bullet.preloadv2.utils.PreloadLogger;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.IPreloadV2Service;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import com.facebook.common.references.CloseableReference;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: PreloadV2Service.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J2\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\tH\u0002¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/bullet/preloadv2/PreloadV2Service;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "Lcom/bytedance/ies/bullet/service/base/IPreloadV2Service;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "getCacheFont", "Landroid/graphics/Typeface;", "bid", "", "url", "getCacheImage", "", EventConstants.PARAM_SOURCE_INIT, "", "reportPreload", "resUrl", "status", "", "resTag", "failReason", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PreloadV2Service extends BaseBulletService implements IPreloadV2Service {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile boolean mInitSuccess;

    public PreloadV2Service(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        init(application);
    }

    /* compiled from: PreloadV2Service.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/preloadv2/PreloadV2Service$Companion;", "", "()V", "mInitSuccess", "", "getMInitSuccess", "()Z", "setMInitSuccess", "(Z)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getMInitSuccess() {
            return PreloadV2Service.mInitSuccess;
        }

        public final void setMInitSuccess(boolean z) {
            PreloadV2Service.mInitSuccess = z;
        }
    }

    private final void init(Application application) {
        if (mInitSuccess) {
            return;
        }
        mInitSuccess = true;
        application.registerComponentCallbacks(new ComponentCallbacks() { // from class: com.bytedance.ies.bullet.preloadv2.PreloadV2Service$init$1
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration newConfig) {
                Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
                PreloadV2.INSTANCE.onLowMemory();
            }
        });
        RLReportController.INSTANCE.initRLConfig(null);
    }

    @Override // com.bytedance.ies.bullet.service.base.IPreloadV2Service
    public Object getCacheImage(String bid, String url) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(url, "url");
        if (StringsKt.startsWith$default(url, "file", false, 2, (Object) null)) {
            try {
                if (!new File(Uri.parse(url).getPath()).exists()) {
                    PreloadLogger.INSTANCE.m43i("getCacheImage，文件不存在, 清理缓存，" + url);
                    HighSubResourceMemCache.INSTANCE.removeCache(url);
                    SubResourceMemCache.INSTANCE.removeCache(url);
                    return null;
                }
            } catch (Exception e) {
                PreloadLogger.INSTANCE.m42e("getCacheImage，File Check Failed " + e.getMessage());
                return null;
            }
        }
        PreloadItem cache = HighSubResourceMemCache.INSTANCE.getCache(url);
        if (cache == null) {
            cache = SubResourceMemCache.INSTANCE.getCache(url);
        }
        ImagePreloadItem imagePreloadItem = cache instanceof ImagePreloadItem ? (ImagePreloadItem) cache : null;
        CloseableReference<Bitmap> image = imagePreloadItem != null ? imagePreloadItem.getImage() : null;
        if (image != null) {
            if (image.get() != null) {
                PreloadLogger.INSTANCE.m43i("命中内存缓存 image，" + url);
                reportPreload$default(this, bid, url, true, "image", null, 16, null);
            } else {
                PreloadLogger.INSTANCE.m43i("错过内存缓存 image, GC clear，" + url);
                reportPreload(bid, url, false, "image", "gc");
            }
        } else {
            PreloadLogger.INSTANCE.m43i("错过内存缓存 image，" + url);
            reportPreload$default(this, bid, url, false, "image", null, 16, null);
        }
        return image;
    }

    @Override // com.bytedance.ies.bullet.service.base.IPreloadV2Service
    public Typeface getCacheFont(String bid, String url) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(url, "url");
        PreloadItem cache = HighSubResourceMemCache.INSTANCE.getCache(url);
        if (cache == null) {
            cache = SubResourceMemCache.INSTANCE.getCache(url);
        }
        FontPreloadItem fontPreloadItem = cache instanceof FontPreloadItem ? (FontPreloadItem) cache : null;
        Typeface typeFace = fontPreloadItem != null ? fontPreloadItem.getTypeFace() : null;
        if (typeFace != null) {
            PreloadLogger.INSTANCE.m43i("命中内存缓存 font，" + url);
            reportPreload$default(this, bid, url, true, "font", null, 16, null);
        } else {
            PreloadLogger.INSTANCE.m43i("错过内存缓存 font，" + url);
            reportPreload$default(this, bid, url, false, "font", null, 16, null);
        }
        return typeFace;
    }

    static /* synthetic */ void reportPreload$default(PreloadV2Service preloadV2Service, String str, String str2, boolean z, String str3, String str4, int i, Object obj) {
        if ((i & 16) != 0) {
            str4 = "";
        }
        preloadV2Service.reportPreload(str, str2, z, str3, str4);
    }

    private final void reportPreload(String bid, String resUrl, boolean status, String resTag, String failReason) {
        IMonitorReportService iMonitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(bid, IMonitorReportService.class);
        if (iMonitorReportService != null) {
            ReportInfo reportInfo = new ReportInfo(RLMonitorReporter.EVENT_FETCH, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
            reportInfo.setUrl(resUrl);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SchemaConstants.QUERY_KEY_RES_URL, resUrl);
            jSONObject.put("memory_static", 1);
            jSONObject.put("res_memory", status ? 1 : 0);
            jSONObject.put("sub_resource_type", resTag);
            jSONObject.put("fail_reason", failReason);
            reportInfo.setCategory(jSONObject);
            iMonitorReportService.report(reportInfo);
        }
    }
}
