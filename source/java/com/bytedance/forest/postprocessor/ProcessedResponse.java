package com.bytedance.forest.postprocessor;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.Response;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProcessedResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B-\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0002\u0010\nB\u0015\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0002\u0010\u000bJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\r\u0010\u001d\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020 H\u0016R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR4\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00062\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/bytedance/forest/postprocessor/ProcessedResponse;", "T", "", "Lcom/bytedance/forest/model/Response;", ApmTrafficStats.TTNET_RESPONSE, "processedData", "Lcom/bytedance/forest/postprocessor/ProcessedData;", "(Lcom/bytedance/forest/model/Response;Lcom/bytedance/forest/postprocessor/ProcessedData;)V", "request", "Lcom/bytedance/forest/postprocessor/PostProcessRequest;", "(Lcom/bytedance/forest/model/Response;Lcom/bytedance/forest/postprocessor/PostProcessRequest;Lcom/bytedance/forest/postprocessor/ProcessedData;)V", "(Lcom/bytedance/forest/postprocessor/ProcessedResponse;)V", "<set-?>", "", "isProcessSucceed", "()Z", "value", "getProcessedData$forest_release", "()Lcom/bytedance/forest/postprocessor/ProcessedData;", "setProcessedData$forest_release", "(Lcom/bytedance/forest/postprocessor/ProcessedData;)V", "loadToMemory", "", "processedDataSize", "", "provideBytes", "", "provideInputStream", "Ljava/io/InputStream;", "provideProcessedData", "()Ljava/lang/Object;", "toString", "", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ProcessedResponse<T> extends Response {
    private boolean isProcessSucceed;
    private ProcessedData<T> processedData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProcessedResponse(Response response, ProcessedData<T> processedData) {
        super(response, null, 2, null);
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        setProcessedData$forest_release(processedData);
        this.isProcessSucceed = processedData != null;
        Request request = response.getRequest();
        PostProcessRequest postProcessRequest = (PostProcessRequest) (request instanceof PostProcessRequest ? request : null);
        setRequest(postProcessRequest != null ? new PostProcessRequest(postProcessRequest) : new PostProcessRequest(getRequest(), ForestPostProcessor.INSTANCE.fakeOne$forest_release()));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProcessedResponse(Response response, PostProcessRequest<T> postProcessRequest, ProcessedData<T> processedData) {
        super(response, null, 2, null);
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        Intrinsics.checkParameterIsNotNull(postProcessRequest, "request");
        setProcessedData$forest_release(processedData);
        this.isProcessSucceed = processedData != null;
        setRequest(postProcessRequest);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProcessedResponse(ProcessedResponse<T> processedResponse) {
        this(processedResponse, processedResponse.processedData);
        Intrinsics.checkParameterIsNotNull(processedResponse, ApmTrafficStats.TTNET_RESPONSE);
    }

    public final ProcessedData<T> getProcessedData$forest_release() {
        return this.processedData;
    }

    public final void setProcessedData$forest_release(ProcessedData<T> processedData) {
        if (processedData != null) {
            this.isProcessSucceed = true;
            setInMemoryBuffer$forest_release(processedData);
        } else {
            this.isProcessSucceed = false;
        }
        this.processedData = processedData;
    }

    /* renamed from: isProcessSucceed, reason: from getter */
    public final boolean getIsProcessSucceed() {
        return this.isProcessSucceed;
    }

    public final T provideProcessedData() {
        ProcessedData<T> processedData = this.processedData;
        if (processedData != null) {
            return processedData.getData();
        }
        return null;
    }

    public final int processedDataSize() {
        ProcessedData<T> processedData = this.processedData;
        if (processedData != null) {
            return processedData.getSize();
        }
        return 0;
    }

    @Override // com.bytedance.forest.model.Response
    public byte[] provideBytes() {
        ProcessedData<T> processedData = this.processedData;
        if (processedData == null) {
            return super.provideBytes();
        }
        if (processedData == null) {
            Intrinsics.throwNpe();
        }
        return processedData.provideBytes();
    }

    @Override // com.bytedance.forest.model.Response
    public void loadToMemory() {
        ProcessedData<T> processedData = this.processedData;
        if (processedData == null) {
            super.loadToMemory();
            return;
        }
        if (processedData == null) {
            Intrinsics.throwNpe();
        }
        processedData.tryLoadToMemory$forest_release(this);
    }

    @Override // com.bytedance.forest.model.Response
    public InputStream provideInputStream() {
        ProcessedData<T> processedData = this.processedData;
        if (processedData == null) {
            return super.provideInputStream();
        }
        if (processedData == null) {
            Intrinsics.throwNpe();
        }
        return processedData.provideInputStream(this);
    }

    @Override // com.bytedance.forest.model.Response
    public String toString() {
        return "{response: " + super.toString() + ", processedData:" + this.processedData;
    }
}
