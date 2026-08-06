package com.bytedance.forest.chain.fetchers;

import android.content.res.AssetManager;
import android.net.Uri;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.BytesProvider;
import com.bytedance.forest.model.ErrorInfo;
import com.bytedance.forest.model.ForestBuffer;
import com.bytedance.forest.model.GeckoModel;
import com.bytedance.forest.model.LogReportNode;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Timing;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.ForestPipelineContext;
import com.bytedance.forest.utils.LoaderUtils;
import com.bytedance.geckox.GeckoBuildInManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: NewlyBuiltinFetcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J,\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/forest/chain/fetchers/NewlyBuiltinFetcher;", "Lcom/bytedance/forest/chain/fetchers/ResourceFetcher;", "forest", "Lcom/bytedance/forest/Forest;", "(Lcom/bytedance/forest/Forest;)V", "cancel", "", "fetchAsync", "request", "Lcom/bytedance/forest/model/Request;", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", JsCallParser.VALUE_CALLBACK, "Lkotlin/Function1;", "fetchSync", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class NewlyBuiltinFetcher extends ResourceFetcher {
    public static final String TAG = "BuiltinFetcher";

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void cancel() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewlyBuiltinFetcher(Forest forest) {
        super(forest);
        Intrinsics.checkParameterIsNotNull(forest, "forest");
    }

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void fetchSync(Request request, Response response) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        fetchAsync(request, response, new Function1<Response, Unit>() { // from class: com.bytedance.forest.chain.fetchers.NewlyBuiltinFetcher$fetchSync$1
            public final void invoke(Response response2) {
                Intrinsics.checkParameterIsNotNull(response2, "it");
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Response) obj);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void fetchAsync(final Request request, Response response, Function1<? super Response, Unit> callback) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        Intrinsics.checkParameterIsNotNull(callback, JsCallParser.VALUE_CALLBACK);
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext$forest_release(), new String[]{Timing.BUILTIN_START}, null, 2, null);
        ForestLogger.print$default(getContext$forest_release().getLogger(), 4, "BuiltinFetcher", "start to fetch from builtin", true, null, Timing.BUILTIN_START, 16, null);
        GeckoModel geckoModel = request.getGeckoModel();
        if ((geckoModel.getAccessKey().length() == 0) || geckoModel.isChannelOrBundleBlank()) {
            response.getErrorInfo().setError(ErrorInfo.Type.Builtin, 1, "ak/channel/bundle is empty");
            ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext$forest_release(), new String[]{Timing.BUILTIN_FINISH}, null, 2, null);
            callback.invoke(response);
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(GeckoBuildInManager.INSTANCE.getBuildInPath(getContext$forest_release().getAndroidContext(), geckoModel.getAccessKey(), geckoModel.getChannel(), geckoModel.getBundle()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            ForestLogger.print$default(getContext$forest_release().getLogger(), 5, "BuiltinFetcher", "get builtin path from gecko failed, " + th2, true, th2, null, 32, null);
            ErrorInfo errorInfo = response.getErrorInfo();
            ErrorInfo.Type type = ErrorInfo.Type.Builtin;
            String message = th2.getMessage();
            if (message == null) {
                message = "";
            }
            errorInfo.setError(type, 2, message);
            ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext$forest_release(), new String[]{Timing.BUILTIN_FINISH}, null, 2, null);
            callback.invoke(response);
            return;
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        final GeckoBuildInManager.GeckoBuildInPath geckoBuildInPath = (GeckoBuildInManager.GeckoBuildInPath) obj;
        if (geckoBuildInPath == null) {
            response.getErrorInfo().setError(ErrorInfo.Type.Builtin, 2, "builtin info from gecko is NULL");
            ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext$forest_release(), new String[]{Timing.BUILTIN_FINISH}, null, 2, null);
            callback.invoke(response);
            return;
        }
        if (LoaderUtils.INSTANCE.isNotNullOrEmpty(geckoBuildInPath.getFailMsg())) {
            ErrorInfo errorInfo2 = response.getErrorInfo();
            ErrorInfo.Type type2 = ErrorInfo.Type.Builtin;
            String failMsg = geckoBuildInPath.getFailMsg();
            if (failMsg == null) {
                failMsg = "";
            }
            errorInfo2.setError(type2, 2, failMsg);
            ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext$forest_release(), new String[]{Timing.BUILTIN_FINISH}, null, 2, null);
            callback.invoke(response);
            return;
        }
        String path = geckoBuildInPath.getPath();
        if (path == null || path.length() == 0) {
            response.getErrorInfo().setError(ErrorInfo.Type.Builtin, 2, "builtin path info from gecko is null or empty");
            ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext$forest_release(), new String[]{Timing.BUILTIN_FINISH}, null, 2, null);
            callback.invoke(response);
            return;
        }
        String path2 = geckoBuildInPath.getPath();
        if (path2 == null) {
            Intrinsics.throwNpe();
        }
        final Uri parse = Uri.parse(path2);
        Intrinsics.checkExpressionValueIsNotNull(parse, "it");
        Uri uri = Intrinsics.areEqual(parse.getScheme(), "file") ? parse : null;
        if (uri != null) {
            String path3 = uri.getPath();
            if (!new File(path3).exists()) {
                response.getErrorInfo().setError(ErrorInfo.Type.Builtin, 3, "builtin file " + path3 + " not exists");
                ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext$forest_release(), new String[]{Timing.BUILTIN_FINISH}, null, 2, null);
                callback.invoke(response);
                return;
            }
        }
        response.setSucceed(true);
        response.setFilePath(geckoBuildInPath.getPath());
        Long version = geckoBuildInPath.getVersion();
        response.setVersion(version != null ? version.longValue() : 0L);
        response.setFrom(ResourceFrom.BUILTIN);
        response.setCache(true);
        response.setInMemoryBuffer$forest_release(getContext$forest_release().obtainInMemoryByteBuffer$forest_release(new BytesProvider() { // from class: com.bytedance.forest.chain.fetchers.NewlyBuiltinFetcher$fetchAsync$$inlined$apply$lambda$1
            @Override // com.bytedance.forest.model.BytesProvider
            public boolean isMultiProvider() {
                return true;
            }

            @Override // com.bytedance.forest.model.BytesProvider
            public InputStream provideInputStream() {
                try {
                    Uri uri2 = parse;
                    Intrinsics.checkExpressionValueIsNotNull(uri2, "uri");
                    String scheme = uri2.getScheme();
                    if (scheme != null) {
                        int hashCode = scheme.hashCode();
                        if (hashCode == 3143036) {
                            if (scheme.equals("file")) {
                                Uri uri3 = parse;
                                Intrinsics.checkExpressionValueIsNotNull(uri3, "uri");
                                return new FileInputStream(new File(uri3.getPath()));
                            }
                        } else if (hashCode == 93121264 && scheme.equals("asset")) {
                            AssetManager assets = Forest.INSTANCE.getApp().getAssets();
                            Uri uri4 = parse;
                            Intrinsics.checkExpressionValueIsNotNull(uri4, "uri");
                            String path4 = uri4.getPath();
                            Intrinsics.checkExpressionValueIsNotNull(path4, "uri.path");
                            return assets.open(StringsKt.removePrefix(path4, "/"));
                        }
                    }
                    throw new IOException(parse.toString() + " is neither file nor asset");
                } catch (Exception e) {
                    NewlyBuiltinFetcher.this.getContext$forest_release().getLogger().printOptimize(6, ForestBuffer.TAG, true, e, LogReportNode.BUILDIN_GET_INPUT_STREAM_ERROR, new Function0<String>() { // from class: com.bytedance.forest.chain.fetchers.NewlyBuiltinFetcher$fetchAsync$$inlined$apply$lambda$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public final String invoke() {
                            return "error occurs when getting input stream from builtin file " + geckoBuildInPath.getPath() + ", e:" + e.getMessage();
                        }
                    });
                    return null;
                }
            }
        }, request));
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext$forest_release(), new String[]{Timing.BUILTIN_FINISH}, null, 2, null);
        callback.invoke(response);
    }
}
