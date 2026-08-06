package com.bytedance.forest.postprocessor;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.ForestPipelineContext;
import com.bytedance.forest.utils.ThreadUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForestPostProcessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000 \u001a*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001\u001aB\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0010J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010\u000e\u001a\u00020\u000fH$J/\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0018\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0004\u0012\u00020\r0\u0017H\u0000¢\u0006\u0002\b\u0018J\u0015\u0010\n\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/forest/postprocessor/ForestPostProcessor;", "T", "", "allowOnMainThread", "", "(Z)V", "context", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "getContext", "()Lcom/bytedance/forest/utils/ForestPipelineContext;", "setContext", "(Lcom/bytedance/forest/utils/ForestPipelineContext;)V", "onPostProcess", "", "data", "Lcom/bytedance/forest/postprocessor/ProcessableData;", "onPostProcess$forest_release", "onProcess", "Lcom/bytedance/forest/postprocessor/ProcessedData;", "process", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", JsCallParser.VALUE_CALLBACK, "Lkotlin/Function1;", "process$forest_release", "setContext$forest_release", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class ForestPostProcessor<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean allowOnMainThread;
    protected ForestPipelineContext context;

    public ForestPostProcessor() {
        this(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ProcessedData<T> onProcess(ProcessableData data);

    public ForestPostProcessor(boolean z) {
        this.allowOnMainThread = z;
    }

    public /* synthetic */ ForestPostProcessor(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    /* compiled from: ForestPostProcessor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0005*\u00020\u0001H\u0000¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/forest/postprocessor/ForestPostProcessor$Companion;", "", "()V", "fakeOne", "Lcom/bytedance/forest/postprocessor/ForestPostProcessor;", "T", "fakeOne$forest_release", "forest_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T> ForestPostProcessor<T> fakeOne$forest_release() {
            return new ForestPostProcessor<T>() { // from class: com.bytedance.forest.postprocessor.ForestPostProcessor$Companion$fakeOne$1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.bytedance.forest.postprocessor.ForestPostProcessor
                public ProcessedData<T> onProcess(ProcessableData data) {
                    Intrinsics.checkParameterIsNotNull(data, "data");
                    throw new IllegalStateException("A fake processor can not be performed");
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ForestPipelineContext getContext() {
        ForestPipelineContext forestPipelineContext = this.context;
        if (forestPipelineContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        }
        return forestPipelineContext;
    }

    protected final void setContext(ForestPipelineContext forestPipelineContext) {
        Intrinsics.checkParameterIsNotNull(forestPipelineContext, "<set-?>");
        this.context = forestPipelineContext;
    }

    public final void setContext$forest_release(ForestPipelineContext context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.context = context;
    }

    public final void process$forest_release(Response response, final Function1<? super ProcessedData<T>, Unit> callback) {
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        Intrinsics.checkParameterIsNotNull(callback, JsCallParser.VALUE_CALLBACK);
        final ProcessableData processableData = new ProcessableData(response);
        Runnable runnable = new Runnable() { // from class: com.bytedance.forest.postprocessor.ForestPostProcessor$process$task$1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    ProcessedData onProcess = ForestPostProcessor.this.onProcess(processableData);
                    onProcess.setContext$forest_release(ForestPostProcessor.this.getContext());
                    ForestPostProcessor.this.onPostProcess$forest_release(processableData);
                    callback.invoke(onProcess);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        ForestPostProcessor.this.onPostProcess$forest_release(processableData);
                        throw th2;
                    }
                }
            }
        };
        if (!this.allowOnMainThread) {
            ThreadUtils.INSTANCE.runInBackgroundIfNeed(runnable);
        } else {
            runnable.run();
        }
    }

    public void onPostProcess$forest_release(final ProcessableData data) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(data, "data");
        if (data.getIsDataStreamBuilt()) {
            try {
                Result.Companion companion = Result.Companion;
                data.getDataStream().close();
                obj = Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            final Throwable th2 = Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                ForestPipelineContext forestPipelineContext = this.context;
                if (forestPipelineContext == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                }
                ForestLogger.printOptimize$default(forestPipelineContext.getLogger(), 6, "PostProcessor", true, null, null, new Function0<String>() { // from class: com.bytedance.forest.postprocessor.ForestPostProcessor$onPostProcess$$inlined$onFailure$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public final String invoke() {
                        return "error occur in onPostProcess cause by " + th2.getMessage() + " for " + data.getUrl();
                    }
                }, 24, null);
            }
        }
    }
}
