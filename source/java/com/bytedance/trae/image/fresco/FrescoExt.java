package com.bytedance.trae.image.fresco;

import android.content.Context;
import android.net.Uri;
import android.util.Pair;
import com.bytedance.fresco.heif.HeifDecoder;
import com.bytedance.trae.apm.api.IExtraParams;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.fileupload.FileUploadService;
import com.bytedance.trae.image.fresco.SvgFrescoDecoder;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.DraweeConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.common.ImageDecodeBitmapConfigStrategy;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.ImageDecoderConfig;
import com.facebook.imagepipeline.listener.RequestLoggingListener;
import com.facebook.imagepipeline.memory.PoolConfig;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.producers.ImageResizeOptionStrategy;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.net.FrescoTTNetFetcher;
import com.facebook.net.RetryInterceptManager;
import com.optimize.statistics.FrescoControllerListener;
import com.optimize.statistics.FrescoMonitor;
import com.optimize.statistics.FrescoTraceListener;
import com.optimize.statistics.IMonitorHookV2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: FrescoExt.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u0007H\u0002J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002JV\u0010\u000e\u001a\u00020\u000f2\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u0011j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f`\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/image/fresco/FrescoExt;", "", "<init>", "()V", "TAG", "", "init", "", "context", "Landroid/content/Context;", "preCreateImagePipeline", "configMainDiskCache", "builder", "Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;", "configIndependentCache", "Lcom/facebook/cache/disk/DiskCacheConfig;", "cacheCfgMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "scene", "cfg", "Lkotlin/Triple;", "", "configImageResize", "reportImageEvent", "openImageRetrySwitch", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FrescoExt {
    public static final FrescoExt INSTANCE = new FrescoExt();
    private static final String TAG = "FrescoExt";

    private FrescoExt() {
    }

    public final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        HashSet hashSet = new HashSet();
        hashSet.add(new FrescoTraceListener());
        hashSet.add(new RequestLoggingListener());
        ImageDecodeBitmapConfigStrategy.setStrategy(ImageDecodeBitmapConfigStrategy.MEMORY_AT_LEAST);
        FrescoMonitor.setExceedTheLimitBitmapMonitorEnabled(true);
        FrescoMonitor.setReportHitCacheEnabled(true);
        DraweeConfig.Builder addGlobalControllerListener = DraweeConfig.newBuilder().addGlobalControllerListener(new FrescoControllerListener());
        PoolFactory poolFactory = new PoolFactory(PoolConfig.newBuilder().build());
        ImagePipelineConfig.Builder diskCacheEnabled = ImagePipelineConfig.newBuilder(AppHost.INSTANCE.getApplication()).setDownsampleEnabled(true).setPoolFactory(poolFactory).setNetworkFetcher(new FrescoTTNetFetcher(true)).setRequestListeners(hashSet).setDiskCacheEnabled(true);
        Intrinsics.checkNotNull(diskCacheEnabled);
        configMainDiskCache(context, diskCacheEnabled);
        diskCacheEnabled.setImageDecoderConfig(ImageDecoderConfig.newBuilder().addDecodingCapability(HeifDecoder.HEIF_FORMAT, new HeifDecoder.HeifFormatChecker(), new HeifDecoder.HeifFormatDecoder(poolFactory.getPooledByteBufferFactory())).addDecodingCapability(SvgFrescoDecoder.INSTANCE.getSVG_FORMAT(), new SvgFrescoDecoder.SvgFormatChecker(), new SvgFrescoDecoder.SvgDecoder()).build());
        addGlobalControllerListener.addCustomDrawableFactory(new SvgFrescoDecoder.SvgDrawableFactory());
        diskCacheEnabled.setCacheKeyFactory(OnlyPathCacheKeyFactory.INSTANCE);
        DefaultCacheKeyFactory.getInstance().setCacheKeyOnlyPath(true);
        diskCacheEnabled.experiment().setOomOptEnabled(true);
        configImageResize();
        openImageRetrySwitch();
        reportImageEvent();
        Fresco.setCanReInitialize(false);
        Fresco.initialize(AppHost.INSTANCE.getApplication(), diskCacheEnabled.build(), addGlobalControllerListener.build());
        SimpleDraweeView.enableLazySize(true);
        preCreateImagePipeline();
    }

    private final void preCreateImagePipeline() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            FrescoExt frescoExt = this;
            obj = Result.constructor-impl(Fresco.getImagePipeline());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
    }

    private final void configMainDiskCache(Context context, ImagePipelineConfig.Builder builder) {
        DiskCacheConfig.Builder baseDirectoryPath = DiskCacheConfig.newBuilder(context).setBaseDirectoryPath(context.getCacheDir());
        baseDirectoryPath.setMaxCacheSize(41943040L).setMaxCacheSizeOnLowDiskSpace(10485760L).setMaxCacheSizeOnVeryLowDiskSpace(2097152L).build();
        builder.setMainDiskCacheConfig(baseDirectoryPath.build());
    }

    private final DiskCacheConfig configIndependentCache(HashMap<String, DiskCacheConfig> cacheCfgMap, String scene, Context context, Triple<Integer, Integer, Integer> cfg) {
        DiskCacheConfig build = DiskCacheConfig.newBuilder(context).setBaseDirectoryPath(context.getCacheDir()).setBaseDirectoryName(scene).setMaxCacheSize(((Number) cfg.getFirst()).intValue() * 1024).setMaxCacheSizeOnLowDiskSpace(((Number) cfg.getSecond()).longValue() * 1024).setMaxCacheSizeOnVeryLowDiskSpace(((Number) cfg.getThird()).longValue() * 1024).build();
        cacheCfgMap.put(scene, build);
        Intrinsics.checkNotNull(build);
        return build;
    }

    private final void configImageResize() {
        ImageResizeOptionStrategy.setStrategy(new ImageResizeOptionStrategy() { // from class: com.bytedance.trae.image.fresco.FrescoExt$configImageResize$1
            public ResizeOptions getResizeConfig(Uri uri, int viewWidth, int viewHeight, int imgWidth, int imgHeight, boolean hasAlpha, ImageFormat imageFormat) {
                Iterator<IResizeStrategy> it = IResizeStrategyKt.getStrategies().iterator();
                while (it.hasNext()) {
                    ResizeOptions resizeConfig = it.next().getResizeConfig(uri, viewWidth, viewHeight, imgWidth, imgHeight, hasAlpha, imageFormat);
                    if (resizeConfig != null) {
                        return resizeConfig;
                    }
                }
                return null;
            }
        });
    }

    private final void reportImageEvent() {
        FrescoMonitor.addMonitorHookV2(new IMonitorHookV2() { // from class: com.bytedance.trae.image.fresco.FrescoExt$$ExternalSyntheticLambda0
            public final Pair onMonitorCompleted(ImageRequest imageRequest, Object obj, String str, JSONObject jSONObject, boolean z, boolean z2) {
                Pair reportImageEvent$lambda$2;
                reportImageEvent$lambda$2 = FrescoExt.reportImageEvent$lambda$2(imageRequest, obj, str, jSONObject, z, z2);
                return reportImageEvent$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair reportImageEvent$lambda$2(ImageRequest imageRequest, Object obj, String str, JSONObject jSONObject, boolean z, boolean z2) {
        Uri sourceUri;
        String queryParameter;
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (imageRequest != null && (sourceUri = imageRequest.getSourceUri()) != null && (queryParameter = sourceUri.getQueryParameter(FrescoUtils.BIZ_TAG)) != null) {
            hashMap.put(FrescoUtils.BIZ_TAG, queryParameter);
        }
        hashMap.put("flow_app_variant", IExtraParams.INSTANCE.getAppVariant());
        return new Pair(Boolean.valueOf(jSONObject.optBoolean("is_request_network")), hashMap);
    }

    private final void openImageRetrySwitch() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(FileUploadService.LOG_CHUNK_SIZE));
        arrayList.add(5000);
        arrayList.add(15000);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(5000);
        arrayList2.add(10000);
        arrayList2.add(20000);
        RetryInterceptManager.inst().open(arrayList, arrayList2);
        RetryInterceptManager.inst().setContentTypeOpen(true);
        RetryInterceptManager.inst().setContentLengthOpen(true);
    }
}
