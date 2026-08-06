package com.bytedance.trae.im.service;

import com.bytedance.trae.network.response.HttpDataResult;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICreateAgentTask.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/im/service/CreateTaskRawResult;", "", "result", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/im/service/CreateTaskResponse;", "errorDetail", "Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;", "errorData", "Lcom/google/gson/JsonObject;", "<init>", "(Lcom/bytedance/trae/network/response/HttpDataResult;Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;Lcom/google/gson/JsonObject;)V", "getResult", "()Lcom/bytedance/trae/network/response/HttpDataResult;", "getErrorDetail", "()Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;", "getErrorData", "()Lcom/google/gson/JsonObject;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class CreateTaskRawResult {
    private final JsonObject errorData;
    private final CreateTaskErrorDetail errorDetail;
    private final HttpDataResult<CreateTaskResponse> result;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreateTaskRawResult copy$default(CreateTaskRawResult createTaskRawResult, HttpDataResult httpDataResult, CreateTaskErrorDetail createTaskErrorDetail, JsonObject jsonObject, int i, Object obj) {
        if ((i & 1) != 0) {
            httpDataResult = createTaskRawResult.result;
        }
        if ((i & 2) != 0) {
            createTaskErrorDetail = createTaskRawResult.errorDetail;
        }
        if ((i & 4) != 0) {
            jsonObject = createTaskRawResult.errorData;
        }
        return createTaskRawResult.copy(httpDataResult, createTaskErrorDetail, jsonObject);
    }

    public final HttpDataResult<CreateTaskResponse> component1() {
        return this.result;
    }

    /* renamed from: component2, reason: from getter */
    public final CreateTaskErrorDetail getErrorDetail() {
        return this.errorDetail;
    }

    /* renamed from: component3, reason: from getter */
    public final JsonObject getErrorData() {
        return this.errorData;
    }

    public final CreateTaskRawResult copy(HttpDataResult<CreateTaskResponse> result, CreateTaskErrorDetail errorDetail, JsonObject errorData) {
        Intrinsics.checkNotNullParameter(result, "result");
        return new CreateTaskRawResult(result, errorDetail, errorData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateTaskRawResult)) {
            return false;
        }
        CreateTaskRawResult createTaskRawResult = (CreateTaskRawResult) other;
        return Intrinsics.areEqual(this.result, createTaskRawResult.result) && Intrinsics.areEqual(this.errorDetail, createTaskRawResult.errorDetail) && Intrinsics.areEqual(this.errorData, createTaskRawResult.errorData);
    }

    public int hashCode() {
        int hashCode = this.result.hashCode() * 31;
        CreateTaskErrorDetail createTaskErrorDetail = this.errorDetail;
        int hashCode2 = (hashCode + (createTaskErrorDetail == null ? 0 : createTaskErrorDetail.hashCode())) * 31;
        JsonObject jsonObject = this.errorData;
        return hashCode2 + (jsonObject != null ? jsonObject.hashCode() : 0);
    }

    public String toString() {
        return "CreateTaskRawResult(result=" + this.result + ", errorDetail=" + this.errorDetail + ", errorData=" + this.errorData + ')';
    }

    public CreateTaskRawResult(HttpDataResult<CreateTaskResponse> httpDataResult, CreateTaskErrorDetail createTaskErrorDetail, JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(httpDataResult, "result");
        this.result = httpDataResult;
        this.errorDetail = createTaskErrorDetail;
        this.errorData = jsonObject;
    }

    public final HttpDataResult<CreateTaskResponse> getResult() {
        return this.result;
    }

    public final CreateTaskErrorDetail getErrorDetail() {
        return this.errorDetail;
    }

    public final JsonObject getErrorData() {
        return this.errorData;
    }
}
