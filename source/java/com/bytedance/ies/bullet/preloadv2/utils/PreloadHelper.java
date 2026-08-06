package com.bytedance.ies.bullet.preloadv2.utils;

import android.net.Uri;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderUtils;
import com.bytedance.ies.bullet.kit.resourceloader.loader.LoaderUtil;
import com.bytedance.ies.bullet.kit.resourceloader.model.RLChannelBundleModel;
import com.bytedance.ies.bullet.preloadv2.cache.PreloadItem;
import com.bytedance.ies.bullet.preloadv2.cache.PreloadResourceType;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.api.BidConstants;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.settings.PineappleConfig;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: PreloadHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tJ\"\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\tJ \u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\tJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\tJ\u000e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/preloadv2/utils/PreloadHelper;", "", "()V", "checkUriValid", "", "uri", "Landroid/net/Uri;", "disableCodeCache", "bid", "", "generateKey", "taskConfig", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "resourceInfo", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "srcUrl", "generateTaskConfig", "item", "Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadItem;", "targetBid", "getTemplateKey", "schema", "wrapAsset", "path", "wrapFile", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PreloadHelper {
    public static final PreloadHelper INSTANCE = new PreloadHelper();

    /* compiled from: PreloadHelper.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PreloadResourceType.values().length];
            try {
                iArr[PreloadResourceType.Template.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PreloadResourceType.ExternalJs.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PreloadResourceType.Font.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PreloadResourceType.DynamicComponent.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private PreloadHelper() {
    }

    public final TaskConfig generateTaskConfig(PreloadItem item, Uri uri, String targetBid) {
        String str;
        String safeGetQueryParameter;
        String safeGetQueryParameter2;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(targetBid, "targetBid");
        boolean z = true;
        TaskConfig taskConfig = new TaskConfig(null, 1, null);
        if (item == null) {
            str = ResourceInfo.RESOURCE_FROM_PRELOAD;
        } else {
            int i = WhenMappings.$EnumSwitchMapping$0[item.getType().ordinal()];
            str = i != 1 ? (i == 2 || i == 3) ? "external_js" : i != 4 ? "sub_resource" : "component" : "template";
        }
        taskConfig.setResTag(str);
        taskConfig.setPreload(true);
        taskConfig.setPreloadHighPriority(item != null ? item.getHighPriority() : false);
        taskConfig.setBid(targetBid);
        taskConfig.setEnableCached(true);
        taskConfig.setDynamic(1);
        if (item != null && item.getDownloadTimeout() > 0) {
            PreloadLogger.INSTANCE.m41d("customDownloadTimeout: " + item.getDownloadTimeout());
            taskConfig.setLoadTimeOut(item.getDownloadTimeout());
        }
        try {
            String cdn = ResourceLoaderUtils.INSTANCE.getCDN(uri);
            if (cdn != null) {
                taskConfig.setCdnUrl(cdn);
                RLChannelBundleModel parseChannelBundle = ResourceLoader.with$default(ResourceLoader.INSTANCE, targetBid, null, 2, null).parseChannelBundle(cdn);
                if (parseChannelBundle == null || (safeGetQueryParameter = parseChannelBundle.provideChannel()) == null) {
                    safeGetQueryParameter = ResourceLoaderUtils.INSTANCE.safeGetQueryParameter("channel", uri);
                }
                if (parseChannelBundle == null || (safeGetQueryParameter2 = parseChannelBundle.providerBundlePath()) == null) {
                    safeGetQueryParameter2 = ResourceLoaderUtils.INSTANCE.safeGetQueryParameter(SchemaConstants.QUERY_KEY_BUNDLE, uri);
                }
                if (safeGetQueryParameter != null) {
                    taskConfig.setChannel(safeGetQueryParameter);
                }
                if (safeGetQueryParameter2 != null) {
                    taskConfig.setBundle(safeGetQueryParameter2);
                }
            }
            String queryParameter = uri.getQueryParameter("dynamic");
            if (queryParameter != null) {
                Intrinsics.checkNotNullExpressionValue(queryParameter, "it");
                taskConfig.setDynamic(Integer.valueOf(Integer.parseInt(queryParameter)));
            }
            if (!uri.isHierarchical()) {
                uri = null;
            }
            if (uri != null) {
                String queryParameter2 = uri.getQueryParameter("disable_builtin");
                if (queryParameter2 != null) {
                    taskConfig.setUseAssetsLoader(!Intrinsics.areEqual(queryParameter2, "1"));
                }
                String queryParameter3 = uri.getQueryParameter(SchemaConstants.QUERY_KEY_DISABLE_OFFLINE);
                if (queryParameter3 != null) {
                    if (Intrinsics.areEqual(queryParameter3, "1")) {
                        z = false;
                    }
                    taskConfig.setUseGeckoLoader(z);
                } else {
                    String queryParameter4 = uri.getQueryParameter("disable_gecko");
                    if (queryParameter4 != null) {
                        if (Intrinsics.areEqual(queryParameter4, "1")) {
                            z = false;
                        }
                        taskConfig.setUseGeckoLoader(z);
                    }
                }
            }
        } catch (Throwable unused) {
            PreloadLogger.INSTANCE.m42e("Preload 配置创建失败");
        }
        return taskConfig;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0087, code lost:
    
        if (r3 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String generateKey(TaskConfig taskConfig, ResourceInfo resourceInfo, String srcUrl) {
        String uri;
        Intrinsics.checkNotNullParameter(srcUrl, "srcUrl");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = srcUrl;
        try {
            Result.Companion companion = Result.Companion;
            if (taskConfig != null) {
                if (LoaderUtil.INSTANCE.isNotNullOrEmpty(taskConfig.getChannel()) && LoaderUtil.INSTANCE.isNotNullOrEmpty(taskConfig.getBundle())) {
                    uri = taskConfig.getChannel() + '_' + taskConfig.getBundle();
                } else if (LoaderUtil.INSTANCE.isNotNullOrEmpty(taskConfig.getCdnUrl())) {
                    uri = Uri.parse(taskConfig.getCdnUrl()).buildUpon().clearQuery().toString();
                    Intrinsics.checkNotNullExpressionValue(uri, "{\n                    Ur…tring()\n                }");
                } else {
                    uri = Uri.parse(srcUrl).buildUpon().clearQuery().build().toString();
                    Intrinsics.checkNotNullExpressionValue(uri, "{\n                    Ur…tring()\n                }");
                }
            }
            uri = Uri.parse(srcUrl).buildUpon().clearQuery().build().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "parse(srcUrl).buildUpon(…uery().build().toString()");
            objectRef.element = uri;
            return (String) objectRef.element;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Throwable th2 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
            if (th2 != null) {
                PreloadLogger.INSTANCE.m42e("generateKey error " + th2.getMessage());
            }
            return (String) objectRef.element;
        }
    }

    public final boolean checkUriValid(Uri uri) {
        if (uri == null) {
            PreloadLogger.INSTANCE.m42e("uri invalid " + uri);
            return false;
        }
        if (!Intrinsics.areEqual(uri.getQueryParameter("__dev"), "1")) {
            return true;
        }
        PreloadLogger.INSTANCE.m42e("uri invalid " + uri);
        return false;
    }

    public final String wrapAsset(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        String uri = new Uri.Builder().scheme("asset").authority("").path(path).build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "Builder()\n            .s…).\n            toString()");
        return uri;
    }

    public final String wrapFile(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        String uri = Uri.fromFile(new File(path)).toString();
        Intrinsics.checkNotNullExpressionValue(uri, "fromFile(File(path)).toString()");
        return uri;
    }

    public final boolean disableCodeCache(String bid) {
        PineappleConfig pineappleConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        return ((iBulletSettingsService == null || (pineappleConfig = (PineappleConfig) iBulletSettingsService.obtainSettings(PineappleConfig.class)) == null) ? false : pineappleConfig.getDisableCodeCache()) && Intrinsics.areEqual(BidConstants.LUCKY, bid);
    }

    public final String getTemplateKey(String schema) {
        Object obj;
        Intrinsics.checkNotNullParameter(schema, "schema");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Uri.parse(schema));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Uri uri = (Uri) obj;
        if (uri == null) {
            PreloadLogger.INSTANCE.m42e("template schema in wrong format");
            return null;
        }
        try {
            Result.Companion companion3 = Result.Companion;
            TaskConfig taskConfig = new TaskConfig(null, 1, null);
            String cdn = ResourceLoaderUtils.INSTANCE.getCDN(uri);
            if (cdn != null) {
                taskConfig.setCdnUrl(cdn);
            }
            String safeGetQueryParameter = ResourceLoaderUtils.INSTANCE.safeGetQueryParameter("channel", uri);
            if (safeGetQueryParameter != null) {
                taskConfig.setChannel(safeGetQueryParameter);
            }
            String safeGetQueryParameter2 = ResourceLoaderUtils.INSTANCE.safeGetQueryParameter(SchemaConstants.QUERY_KEY_BUNDLE, uri);
            if (safeGetQueryParameter2 != null) {
                taskConfig.setBundle(safeGetQueryParameter2);
            }
            if (LoaderUtil.INSTANCE.isNotNullOrEmpty(taskConfig.getChannel()) && LoaderUtil.INSTANCE.isNotNullOrEmpty(taskConfig.getBundle())) {
                return taskConfig.getChannel() + '_' + taskConfig.getBundle();
            }
            if (LoaderUtil.INSTANCE.isNotNullOrEmpty(taskConfig.getCdnUrl())) {
                String builder = Uri.parse(taskConfig.getCdnUrl()).buildUpon().clearQuery().toString();
                Intrinsics.checkNotNullExpressionValue(builder, "{\n                    Ur…tring()\n                }");
                return builder;
            }
            String uri2 = Uri.parse(schema).buildUpon().clearQuery().build().toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "{\n                    Ur…tring()\n                }");
            return uri2;
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            Throwable th3 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th2)));
            if (th3 != null) {
                PreloadLogger.INSTANCE.m42e("generate TemplateItem Key error " + th3.getMessage());
            }
            return null;
        }
    }
}
