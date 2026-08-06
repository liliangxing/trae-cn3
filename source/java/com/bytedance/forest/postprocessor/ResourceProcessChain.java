package com.bytedance.forest.postprocessor;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.forest.model.ErrorInfo;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.utils.ForestPipelineContext;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: chain.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f0\u0013H\u0002J)\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f0\u0013H\u0000¢\u0006\u0002\b\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/forest/postprocessor/ResourceProcessChain;", "", "request", "Lcom/bytedance/forest/model/Request;", "context", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "(Lcom/bytedance/forest/model/Request;Lcom/bytedance/forest/utils/ForestPipelineContext;)V", "getContext$forest_release", "()Lcom/bytedance/forest/utils/ForestPipelineContext;", "setContext$forest_release", "(Lcom/bytedance/forest/utils/ForestPipelineContext;)V", "processors", "Ljava/util/Queue;", "Lcom/bytedance/forest/postprocessor/ForestPostProcessor;", "performProcessor", "", "originResponse", "Lcom/bytedance/forest/model/Response;", JsCallParser.VALUE_CALLBACK, "Lkotlin/Function1;", "process", ApmTrafficStats.TTNET_RESPONSE, "process$forest_release", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ResourceProcessChain {
    private static final String TAG = "ResourceProcessChain";
    private ForestPipelineContext context;
    private final Queue<ForestPostProcessor<?>> processors;
    private final Request request;

    public ResourceProcessChain(Request request, ForestPipelineContext forestPipelineContext) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(forestPipelineContext, "context");
        this.request = request;
        this.context = forestPipelineContext;
        LinkedList linkedList = new LinkedList();
        if (request.getLoadToMemory()) {
            linkedList.add(new LoadToMemoryProcessor(!request.getIsASync() || request.getAllowIOOnMainThread()));
        }
        PostProcessRequest postProcessRequest = (PostProcessRequest) (!(request instanceof PostProcessRequest) ? null : request);
        if (postProcessRequest != null) {
            linkedList.add(postProcessRequest.getPostProcessor$forest_release());
        }
        if (request.getEnableMemoryCache()) {
            linkedList.add(new UpdateToMemoryCacheProcessor());
        }
        this.processors = linkedList;
    }

    /* renamed from: getContext$forest_release, reason: from getter */
    public final ForestPipelineContext getContext() {
        return this.context;
    }

    public final void setContext$forest_release(ForestPipelineContext forestPipelineContext) {
        Intrinsics.checkParameterIsNotNull(forestPipelineContext, "<set-?>");
        this.context = forestPipelineContext;
    }

    public final void process$forest_release(Response response, final Function1<? super Response, Unit> callback) {
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        Intrinsics.checkParameterIsNotNull(callback, JsCallParser.VALUE_CALLBACK);
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(this.context, new String[]{"post_processor_execute_start"}, null, 2, null);
        performProcessor(response, new Function1<Response, Unit>() { // from class: com.bytedance.forest.postprocessor.ResourceProcessChain$process$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Response) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Response response2) {
                Intrinsics.checkParameterIsNotNull(response2, "it");
                ForestPipelineContext.recordPerformanceTiming$forest_release$default(ResourceProcessChain.this.getContext(), new String[]{"post_processor_execute_finish"}, null, 2, null);
                callback.invoke(response2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performProcessor(final Response originResponse, final Function1<? super Response, Unit> callback) {
        if (!originResponse.getIsSucceed()) {
            ProcessedResponse processedResponse = (originResponse instanceof ProcessedResponse) || !(this.request instanceof PostProcessRequest) ? originResponse : null;
            if (processedResponse == null) {
                Request request = this.request;
                if (request != null) {
                    processedResponse = new ProcessedResponse(originResponse, (PostProcessRequest) request, null);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.bytedance.forest.postprocessor.PostProcessRequest<kotlin.Any>");
                }
            }
            callback.invoke(processedResponse);
            return;
        }
        ForestPostProcessor<?> poll = this.processors.poll();
        if (poll == null) {
            callback.invoke(originResponse);
            return;
        }
        poll.setContext$forest_release(this.context);
        if (poll instanceof BuiltinProcessor) {
            try {
                ((BuiltinProcessor) poll).process$forest_release(originResponse, new Function1<ProcessedData<Response>, Unit>() { // from class: com.bytedance.forest.postprocessor.ResourceProcessChain$performProcessor$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((ProcessedData<Response>) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ProcessedData<Response> processedData) {
                        Intrinsics.checkParameterIsNotNull(processedData, "it");
                        ResourceProcessChain.this.performProcessor(processedData.getData(), callback);
                    }
                });
                return;
            } catch (Throwable th) {
                originResponse.getErrorInfo().setError(ErrorInfo.Type.Pipeline, 3, "error occurs in " + poll.getClass() + " cause by " + th.getMessage());
                originResponse.setSucceed(false);
                performProcessor(originResponse, callback);
                return;
            }
        }
        try {
            poll.process$forest_release(originResponse, new Function1<ProcessedData<? extends Object>, Unit>() { // from class: com.bytedance.forest.postprocessor.ResourceProcessChain$performProcessor$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((ProcessedData<? extends Object>) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(ProcessedData<? extends Object> processedData) {
                    Intrinsics.checkParameterIsNotNull(processedData, "it");
                    Response response = originResponse;
                    if (response == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.forest.postprocessor.ProcessedResponse<kotlin.Any>");
                    }
                    ProcessedResponse processedResponse2 = (ProcessedResponse) response;
                    processedResponse2.setProcessedData$forest_release(processedData);
                    ResourceProcessChain.this.performProcessor(processedResponse2, callback);
                }
            });
        } catch (Throwable th2) {
            if (originResponse != null) {
                ProcessedResponse processedResponse2 = (ProcessedResponse) originResponse;
                processedResponse2.setProcessedData$forest_release(null);
                processedResponse2.getErrorInfo().setError(ErrorInfo.Type.PostProcess, 1, "error occurs in executing " + this.processors + ", cause by " + th2.getMessage());
                performProcessor(processedResponse2, callback);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.bytedance.forest.postprocessor.ProcessedResponse<kotlin.Any>");
        }
    }
}
