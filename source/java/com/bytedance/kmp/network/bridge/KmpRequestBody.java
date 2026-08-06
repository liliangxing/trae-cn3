package com.bytedance.kmp.network.bridge;

import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpRequestBody.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/kmp/network/bridge/KmpRequestBody;", "", "bodyType", "Lcom/bytedance/kmp/network/bridge/KmpRequestBodyType;", ReportConst.ValidationReport.BODY, "(Lcom/bytedance/kmp/network/bridge/KmpRequestBodyType;Ljava/lang/Object;)V", "getBody", "()Ljava/lang/Object;", "getBodyType", "()Lcom/bytedance/kmp/network/bridge/KmpRequestBodyType;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class KmpRequestBody {
    private final Object body;
    private final KmpRequestBodyType bodyType;

    public static /* synthetic */ KmpRequestBody copy$default(KmpRequestBody kmpRequestBody, KmpRequestBodyType kmpRequestBodyType, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            kmpRequestBodyType = kmpRequestBody.bodyType;
        }
        if ((i & 2) != 0) {
            obj = kmpRequestBody.body;
        }
        return kmpRequestBody.copy(kmpRequestBodyType, obj);
    }

    /* renamed from: component1, reason: from getter */
    public final KmpRequestBodyType getBodyType() {
        return this.bodyType;
    }

    /* renamed from: component2, reason: from getter */
    public final Object getBody() {
        return this.body;
    }

    public final KmpRequestBody copy(KmpRequestBodyType bodyType, Object body) {
        Intrinsics.checkNotNullParameter(bodyType, "bodyType");
        return new KmpRequestBody(bodyType, body);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KmpRequestBody)) {
            return false;
        }
        KmpRequestBody kmpRequestBody = (KmpRequestBody) other;
        return this.bodyType == kmpRequestBody.bodyType && Intrinsics.areEqual(this.body, kmpRequestBody.body);
    }

    public int hashCode() {
        int hashCode = this.bodyType.hashCode() * 31;
        Object obj = this.body;
        return hashCode + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "KmpRequestBody(bodyType=" + this.bodyType + ", body=" + this.body + ')';
    }

    public KmpRequestBody(KmpRequestBodyType bodyType, Object obj) {
        Intrinsics.checkNotNullParameter(bodyType, "bodyType");
        this.bodyType = bodyType;
        this.body = obj;
    }

    public final KmpRequestBodyType getBodyType() {
        return this.bodyType;
    }

    public final Object getBody() {
        return this.body;
    }
}
