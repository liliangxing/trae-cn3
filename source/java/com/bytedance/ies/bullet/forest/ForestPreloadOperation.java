package com.bytedance.ies.bullet.forest;

import com.bytedance.forest.model.Response;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForestPreloadMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u001f\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u0007HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J3\u0010\u0010\u001a\u00020\u00002\u001e\b\u0002\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R'\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/bullet/forest/ForestPreloadOperation;", "", "callback", "Lkotlin/Function2;", "Lcom/bytedance/forest/model/Response;", "Lcom/bytedance/ies/bullet/forest/ForestRequestInfo;", "", "Lcom/bytedance/ies/bullet/forest/ForestPreloadCallback;", "requestInfo", "(Lkotlin/jvm/functions/Function2;Lcom/bytedance/ies/bullet/forest/ForestRequestInfo;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getRequestInfo", "()Lcom/bytedance/ies/bullet/forest/ForestRequestInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final /* data */ class ForestPreloadOperation {
    private final Function2<Response, ForestRequestInfo, Unit> callback;
    private final ForestRequestInfo requestInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ForestPreloadOperation copy$default(ForestPreloadOperation forestPreloadOperation, Function2 function2, ForestRequestInfo forestRequestInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            function2 = forestPreloadOperation.callback;
        }
        if ((i & 2) != 0) {
            forestRequestInfo = forestPreloadOperation.requestInfo;
        }
        return forestPreloadOperation.copy(function2, forestRequestInfo);
    }

    public final Function2<Response, ForestRequestInfo, Unit> component1() {
        return this.callback;
    }

    /* renamed from: component2, reason: from getter */
    public final ForestRequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public final ForestPreloadOperation copy(Function2<? super Response, ? super ForestRequestInfo, Unit> callback, ForestRequestInfo requestInfo) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(requestInfo, "requestInfo");
        return new ForestPreloadOperation(callback, requestInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForestPreloadOperation)) {
            return false;
        }
        ForestPreloadOperation forestPreloadOperation = (ForestPreloadOperation) other;
        return Intrinsics.areEqual(this.callback, forestPreloadOperation.callback) && Intrinsics.areEqual(this.requestInfo, forestPreloadOperation.requestInfo);
    }

    public int hashCode() {
        return (this.callback.hashCode() * 31) + this.requestInfo.hashCode();
    }

    public String toString() {
        return "ForestPreloadOperation(callback=" + this.callback + ", requestInfo=" + this.requestInfo + ')';
    }

    public ForestPreloadOperation(Function2<? super Response, ? super ForestRequestInfo, Unit> function2, ForestRequestInfo forestRequestInfo) {
        Intrinsics.checkNotNullParameter(function2, "callback");
        Intrinsics.checkNotNullParameter(forestRequestInfo, "requestInfo");
        this.callback = function2;
        this.requestInfo = forestRequestInfo;
    }

    public final Function2<Response, ForestRequestInfo, Unit> getCallback() {
        return this.callback;
    }

    public final ForestRequestInfo getRequestInfo() {
        return this.requestInfo;
    }
}
