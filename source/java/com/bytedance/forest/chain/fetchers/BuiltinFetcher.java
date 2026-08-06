package com.bytedance.forest.chain.fetchers;

import android.app.Application;
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
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: BuiltinFetcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J,\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/forest/chain/fetchers/BuiltinFetcher;", "Lcom/bytedance/forest/chain/fetchers/ResourceFetcher;", "forest", "Lcom/bytedance/forest/Forest;", "(Lcom/bytedance/forest/Forest;)V", "cancel", "", "fetchAsync", "request", "Lcom/bytedance/forest/model/Request;", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", JsCallParser.VALUE_CALLBACK, "Lkotlin/Function1;", "fetchSync", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class BuiltinFetcher extends ResourceFetcher {
    private static final String BUILTIN_DIR = "offline";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "BuiltinFetcher";

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void cancel() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuiltinFetcher(Forest forest) {
        super(forest);
        Intrinsics.checkParameterIsNotNull(forest, "forest");
    }

    /* compiled from: BuiltinFetcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/forest/chain/fetchers/BuiltinFetcher$Companion;", "", "()V", "BUILTIN_DIR", "", "TAG", "checkBuiltinFileExists", "", "app", "Landroid/app/Application;", "builtinPath", "getBuiltinPath", "geckoModel", "Lcom/bytedance/forest/model/GeckoModel;", "forest_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getBuiltinPath(GeckoModel geckoModel) {
            String buildPath = geckoModel.buildPath();
            if (StringsKt.startsWith$default(buildPath, "/", false, 2, (Object) null)) {
                return "offline" + buildPath;
            }
            return "offline/" + buildPath;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean checkBuiltinFileExists(Application app, String builtinPath) {
            Object obj;
            Integer valueOf = Integer.valueOf(StringsKt.lastIndexOf$default(builtinPath, '/', 0, false, 6, (Object) null));
            if (!(valueOf.intValue() != -1)) {
                valueOf = null;
            }
            if (valueOf == null) {
                return false;
            }
            int intValue = valueOf.intValue();
            if (builtinPath != null) {
                String substring = builtinPath.substring(0, intValue);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                int i = intValue + 1;
                if (builtinPath != null) {
                    String substring2 = builtinPath.substring(i);
                    Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
                    try {
                        Result.Companion companion = Result.Companion;
                        obj = Result.constructor-impl(app.getAssets().list(substring));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    String[] strArr = (String[]) (Result.isFailure-impl(obj) ? null : obj);
                    if (strArr != null) {
                        return ArraysKt.contains(strArr, substring2);
                    }
                    return false;
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
    }

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void fetchSync(Request request, Response response) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        fetchAsync(request, response, new Function1<Response, Unit>() { // from class: com.bytedance.forest.chain.fetchers.BuiltinFetcher$fetchSync$1
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
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        Intrinsics.checkParameterIsNotNull(callback, JsCallParser.VALUE_CALLBACK);
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext$forest_release(), new String[]{Timing.BUILTIN_START}, null, 2, null);
        ForestLogger.print$default(getContext$forest_release().getLogger(), 4, "BuiltinFetcher", "start to fetch from buildin", true, null, Timing.BUILTIN_START, 16, null);
        if (request.getGeckoModel().isChannelOrBundleBlank()) {
            response.getErrorInfo().setError(ErrorInfo.Type.Builtin, 1, "Could not get Channel Or Bundle");
            ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext$forest_release(), new String[]{Timing.BUILTIN_FINISH}, null, 2, null);
            callback.invoke(response);
            return;
        }
        Companion companion = INSTANCE;
        final String builtinPath = companion.getBuiltinPath(request.getGeckoModel());
        if (companion.checkBuiltinFileExists(getForest().getApplication(), builtinPath)) {
            response.setSucceed(true);
            response.setFilePath(builtinPath);
            response.setFrom(ResourceFrom.BUILTIN);
            response.setCache(true);
            response.setInMemoryBuffer$forest_release(getContext$forest_release().obtainInMemoryByteBuffer$forest_release(new BytesProvider() { // from class: com.bytedance.forest.chain.fetchers.BuiltinFetcher$fetchAsync$$inlined$apply$lambda$1
                @Override // com.bytedance.forest.model.BytesProvider
                public boolean isMultiProvider() {
                    return true;
                }

                @Override // com.bytedance.forest.model.BytesProvider
                public InputStream provideInputStream() {
                    try {
                        return Forest.INSTANCE.getApp().getAssets().open(builtinPath);
                    } catch (Exception e) {
                        BuiltinFetcher.this.getContext$forest_release().getLogger().printOptimize(6, ForestBuffer.TAG, true, e, LogReportNode.BUILDIN_GET_INPUT_STREAM_ERROR, new Function0<String>() { // from class: com.bytedance.forest.chain.fetchers.BuiltinFetcher$fetchAsync$$inlined$apply$lambda$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            public final String invoke() {
                                return "error occurs when getting input stream from builtin, e:" + e.getMessage();
                            }
                        });
                        return null;
                    }
                }
            }, request));
        } else {
            response.getErrorInfo().setError(ErrorInfo.Type.Builtin, 3, "builtin resource not exists");
        }
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext$forest_release(), new String[]{Timing.BUILTIN_FINISH}, null, 2, null);
        callback.invoke(response);
    }
}
