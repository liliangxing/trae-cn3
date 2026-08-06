package com.bytedance.ies.bullet.service.base;

import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: IPreLoadService.kt */
@Deprecated(message = "内部解耦用的临时接口，随时下线，请勿使用")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&Jd\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f2@\b\u0002\u0010\u0011\u001a:\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012j\u0004\u0018\u0001`\u0019H&J\\\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2@\b\u0002\u0010\u0011\u001a:\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012j\u0004\u0018\u0001`\u0019H&J\\\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u001e2@\b\u0002\u0010\u0011\u001a:\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012j\u0004\u0018\u0001`\u0019H&J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006!"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/IPreLoadService;", "", "forceClean", "", "schema", "", "getCache", "url", "type", "", "onLowMemory", "preDownloadResource", "config", "Lcom/bytedance/ies/bullet/service/base/PreDownloadConfig;", "resourceInfoList", "", "Lcom/bytedance/ies/bullet/service/base/PreloadResourceInfo;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "Lcom/bytedance/ies/bullet/service/base/PreLoadResult;", "code", "Lcom/bytedance/ies/bullet/service/base/PreLoadCallBack;", ResourceInfo.RESOURCE_FROM_PRELOAD, "preloadConfig", "Lcom/bytedance/ies/bullet/service/base/PreloadConfig;", "preloadStrategy", "Lcom/bytedance/ies/bullet/service/base/PreloadStrategy;", "putUrl", "redirectUrl", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IPreLoadService {
    void forceClean(String schema);

    Object getCache(String url, int type);

    void onLowMemory();

    void preDownloadResource(PreDownloadConfig config, List<PreloadResourceInfo> resourceInfoList, Function2<? super Boolean, ? super PreLoadResult, Unit> callback);

    void preload(PreloadConfig preloadConfig, PreloadStrategy preloadStrategy, Function2<? super Boolean, ? super PreLoadResult, Unit> callback);

    void preload(String schema, PreloadStrategy preloadStrategy, Function2<? super Boolean, ? super PreLoadResult, Unit> callback);

    void putUrl(String redirectUrl, String url);

    /* compiled from: IPreLoadService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void preDownloadResource$default(IPreLoadService iPreLoadService, PreDownloadConfig preDownloadConfig, List list, Function2 function2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preDownloadResource");
            }
            if ((i & 4) != 0) {
                function2 = null;
            }
            iPreLoadService.preDownloadResource(preDownloadConfig, list, function2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void preload$default(IPreLoadService iPreLoadService, String str, PreloadStrategy preloadStrategy, Function2 function2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preload");
            }
            if ((i & 2) != 0) {
                preloadStrategy = new PreloadStrategy();
            }
            if ((i & 4) != 0) {
                function2 = null;
            }
            iPreLoadService.preload(str, preloadStrategy, (Function2<? super Boolean, ? super PreLoadResult, Unit>) function2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void preload$default(IPreLoadService iPreLoadService, PreloadConfig preloadConfig, PreloadStrategy preloadStrategy, Function2 function2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preload");
            }
            if ((i & 2) != 0) {
                preloadStrategy = new PreloadStrategy();
            }
            if ((i & 4) != 0) {
                function2 = null;
            }
            iPreLoadService.preload(preloadConfig, preloadStrategy, (Function2<? super Boolean, ? super PreLoadResult, Unit>) function2);
        }

        public static /* synthetic */ void forceClean$default(IPreLoadService iPreLoadService, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: forceClean");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            iPreLoadService.forceClean(str);
        }
    }
}
