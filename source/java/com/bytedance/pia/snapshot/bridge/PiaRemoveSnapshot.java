package com.bytedance.pia.snapshot.bridge;

import com.bytedance.pia.core.api.bridge.IPiaBridge;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IFactory;
import com.bytedance.pia.core.utils.GsonUtils;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.bytedance.pia.snapshot.SnapShotManager;
import com.bytedance.pia.snapshot.bridge.PiaRemoveSnapshot;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PiaRemoveSnapshot.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000e\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0004J5\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u000bH\u0096\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/pia/snapshot/bridge/PiaRemoveSnapshot;", "Lcom/bytedance/pia/core/api/bridge/PiaMethod$ICall;", "Lcom/bytedance/pia/snapshot/bridge/PiaRemoveSnapshot$Params;", "Lcom/bytedance/pia/snapshot/bridge/PiaRemoveSnapshot$Result;", "()V", "invoke", "", "bridge", "Lcom/bytedance/pia/core/api/bridge/IPiaBridge;", "params", "resolve", "Lcom/bytedance/pia/core/api/utils/IConsumer;", "reject", "Lcom/bytedance/pia/core/api/bridge/PiaMethod$Error;", "Companion", "Params", "Result", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PiaRemoveSnapshot implements PiaMethod.ICall<Params, Result> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String NAME = "pia.removeSnapshot";
    private static final PiaMethod<Params, Result> method = new PiaMethod<>(NAME, PiaMethod.Scope.Render, new IFactory() { // from class: com.bytedance.pia.snapshot.bridge.PiaRemoveSnapshot$Companion$method$1
        @Override // com.bytedance.pia.core.api.utils.IFactory
        public final PiaMethod.ICall<PiaRemoveSnapshot.Params, PiaRemoveSnapshot.Result> create() {
            return new PiaRemoveSnapshot();
        }
    });

    public static final PiaMethod<Params, Result> getMethod() {
        return INSTANCE.getMethod();
    }

    @Override // com.bytedance.pia.core.api.bridge.PiaMethod.ICall
    public /* bridge */ /* synthetic */ void invoke(IPiaBridge iPiaBridge, Params params, IConsumer<Result> iConsumer, IConsumer iConsumer2) {
        invoke2(iPiaBridge, params, iConsumer, (IConsumer<PiaMethod.Error>) iConsumer2);
    }

    /* compiled from: PiaRemoveSnapshot.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R(\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/pia/snapshot/bridge/PiaRemoveSnapshot$Companion;", "", "()V", "NAME", "", "method", "Lcom/bytedance/pia/core/api/bridge/PiaMethod;", "Lcom/bytedance/pia/snapshot/bridge/PiaRemoveSnapshot$Params;", "Lcom/bytedance/pia/snapshot/bridge/PiaRemoveSnapshot$Result;", "getMethod$annotations", "getMethod", "()Lcom/bytedance/pia/core/api/bridge/PiaMethod;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getMethod$annotations() {
        }

        private Companion() {
        }

        public final PiaMethod<Params, Result> getMethod() {
            return PiaRemoveSnapshot.method;
        }
    }

    /* compiled from: PiaRemoveSnapshot.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/pia/snapshot/bridge/PiaRemoveSnapshot$Params;", "", "query", "Lcom/google/gson/JsonObject;", "url", "", "sdk", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/Number;)V", "getQuery", "()Lcom/google/gson/JsonObject;", "getSdk", "()Ljava/lang/Number;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final /* data */ class Params {

        @SerializedName("query")
        private final JsonObject query;

        @SerializedName("sdk")
        private final Number sdk;

        @SerializedName("url")
        private final String url;

        public static /* synthetic */ Params copy$default(Params params, JsonObject jsonObject, String str, Number number, int i, Object obj) {
            if ((i & 1) != 0) {
                jsonObject = params.query;
            }
            if ((i & 2) != 0) {
                str = params.url;
            }
            if ((i & 4) != 0) {
                number = params.sdk;
            }
            return params.copy(jsonObject, str, number);
        }

        /* renamed from: component1, reason: from getter */
        public final JsonObject getQuery() {
            return this.query;
        }

        /* renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* renamed from: component3, reason: from getter */
        public final Number getSdk() {
            return this.sdk;
        }

        public final Params copy(JsonObject query, String url, Number sdk) {
            return new Params(query, url, sdk);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Params)) {
                return false;
            }
            Params params = (Params) other;
            return Intrinsics.areEqual(this.query, params.query) && Intrinsics.areEqual(this.url, params.url) && Intrinsics.areEqual(this.sdk, params.sdk);
        }

        public int hashCode() {
            JsonObject jsonObject = this.query;
            int hashCode = (jsonObject == null ? 0 : jsonObject.hashCode()) * 31;
            String str = this.url;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            Number number = this.sdk;
            return hashCode2 + (number != null ? number.hashCode() : 0);
        }

        public String toString() {
            return "Params(query=" + this.query + ", url=" + this.url + ", sdk=" + this.sdk + ')';
        }

        public Params(JsonObject jsonObject, String str, Number number) {
            this.query = jsonObject;
            this.url = str;
            this.sdk = number;
        }

        public final JsonObject getQuery() {
            return this.query;
        }

        public final String getUrl() {
            return this.url;
        }

        public final Number getSdk() {
            return this.sdk;
        }
    }

    /* compiled from: PiaRemoveSnapshot.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/pia/snapshot/bridge/PiaRemoveSnapshot$Result;", "", "delete", "", "(Z)V", "getDelete", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final /* data */ class Result {

        @SerializedName("delete")
        private final boolean delete;

        public static /* synthetic */ Result copy$default(Result result, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = result.delete;
            }
            return result.copy(z);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getDelete() {
            return this.delete;
        }

        public final Result copy(boolean delete) {
            return new Result(delete);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Result) && this.delete == ((Result) other).delete;
        }

        public int hashCode() {
            return Boolean.hashCode(this.delete);
        }

        public String toString() {
            return "Result(delete=" + this.delete + ')';
        }

        public Result(boolean z) {
            this.delete = z;
        }

        public final boolean getDelete() {
            return this.delete;
        }
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(IPiaBridge bridge, final Params params, final IConsumer<Result> resolve, final IConsumer<PiaMethod.Error> reject) {
        Intrinsics.checkNotNullParameter(bridge, "bridge");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(resolve, "resolve");
        Intrinsics.checkNotNullParameter(reject, "reject");
        ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.snapshot.bridge.PiaRemoveSnapshot$invoke$1
            @Override // java.lang.Runnable
            public final void run() {
                String str;
                Logger.d$default("[SnapShot] pia.removeSnapshot called (Query: " + PiaRemoveSnapshot.Params.this.getQuery() + ", URL: " + PiaRemoveSnapshot.Params.this.getUrl() + ", SDK: " + PiaRemoveSnapshot.Params.this.getSdk() + ')', null, null, 6, null);
                Number sdk = PiaRemoveSnapshot.Params.this.getSdk();
                int intValue = sdk != null ? sdk.intValue() : 1;
                String url = PiaRemoveSnapshot.Params.this.getUrl();
                JsonObject query = PiaRemoveSnapshot.Params.this.getQuery();
                if (query == null || (str = query.toString()) == null) {
                    str = "";
                }
                if (url == null) {
                    reject.accept(new PiaMethod.InvalidParamsError());
                    return;
                }
                JSONObject jSONObject = (JSONObject) GsonUtils.fromJson(str, JSONObject.class);
                if (jSONObject == null) {
                    reject.accept(new PiaMethod.InvalidParamsError(""));
                } else {
                    resolve.accept(new PiaRemoveSnapshot.Result(SnapShotManager.INSTANCE.removeSnapShot(jSONObject, url, intValue)));
                }
            }
        });
    }
}
