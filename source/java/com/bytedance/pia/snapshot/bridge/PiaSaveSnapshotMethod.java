package com.bytedance.pia.snapshot.bridge;

import android.text.TextUtils;
import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.bytedance.pia.core.PiaContext;
import com.bytedance.pia.core.api.bridge.IPiaBridge;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.context.IPiaContext;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IFactory;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.pia.core.metrics.ErrorCode;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.utils.GsonUtils;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.snapshot.SnapShotManager;
import com.bytedance.pia.snapshot.bridge.PiaSaveSnapshotMethod;
import com.bytedance.pia.snapshot.storage.ISnapshotStore;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PiaSaveSnapshotMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000e\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0004J5\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u000bH\u0096\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/pia/snapshot/bridge/PiaSaveSnapshotMethod;", "Lcom/bytedance/pia/core/api/bridge/PiaMethod$ICall;", "Lcom/bytedance/pia/snapshot/bridge/PiaSaveSnapshotMethod$Params;", "Lcom/bytedance/pia/snapshot/bridge/PiaSaveSnapshotMethod$Result;", "()V", "invoke", "", "bridge", "Lcom/bytedance/pia/core/api/bridge/IPiaBridge;", "params", "resolve", "Lcom/bytedance/pia/core/api/utils/IConsumer;", "reject", "Lcom/bytedance/pia/core/api/bridge/PiaMethod$Error;", "Companion", "Params", "Result", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PiaSaveSnapshotMethod implements PiaMethod.ICall<Params, Result> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String NAME = "pia.saveSnapshot";
    private static final PiaMethod<Params, Result> method = new PiaMethod<>(NAME, PiaMethod.Scope.Render, new IFactory() { // from class: com.bytedance.pia.snapshot.bridge.PiaSaveSnapshotMethod$Companion$method$1
        @Override // com.bytedance.pia.core.api.utils.IFactory
        public final PiaMethod.ICall<PiaSaveSnapshotMethod.Params, PiaSaveSnapshotMethod.Result> create() {
            return new PiaSaveSnapshotMethod();
        }
    });

    public static final PiaMethod<Params, Result> getMethod() {
        return INSTANCE.getMethod();
    }

    @Override // com.bytedance.pia.core.api.bridge.PiaMethod.ICall
    public /* bridge */ /* synthetic */ void invoke(IPiaBridge iPiaBridge, Params params, IConsumer<Result> iConsumer, IConsumer iConsumer2) {
        invoke2(iPiaBridge, params, iConsumer, (IConsumer<PiaMethod.Error>) iConsumer2);
    }

    /* compiled from: PiaSaveSnapshotMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R(\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/pia/snapshot/bridge/PiaSaveSnapshotMethod$Companion;", "", "()V", "NAME", "", "method", "Lcom/bytedance/pia/core/api/bridge/PiaMethod;", "Lcom/bytedance/pia/snapshot/bridge/PiaSaveSnapshotMethod$Params;", "Lcom/bytedance/pia/snapshot/bridge/PiaSaveSnapshotMethod$Result;", "getMethod$annotations", "getMethod", "()Lcom/bytedance/pia/core/api/bridge/PiaMethod;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
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
            return PiaSaveSnapshotMethod.method;
        }
    }

    /* compiled from: PiaSaveSnapshotMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u0013Jn\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\nHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016¨\u0006-"}, d2 = {"Lcom/bytedance/pia/snapshot/bridge/PiaSaveSnapshotMethod$Params;", "", "content", "", "head", "expires", "", "query", "Lcom/google/gson/JsonObject;", "sdk", "", IPiaCacheProvider.CacheConfig.FIELD_VERSION, "url", "enforce", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Lcom/google/gson/JsonObject;Ljava/lang/Integer;Ljava/lang/Number;Ljava/lang/String;Ljava/lang/Boolean;)V", "getContent", "()Ljava/lang/String;", "getEnforce", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getExpires", "()Ljava/lang/Number;", "getHead", "getQuery", "()Lcom/google/gson/JsonObject;", "getSdk", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUrl", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Lcom/google/gson/JsonObject;Ljava/lang/Integer;Ljava/lang/Number;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/bytedance/pia/snapshot/bridge/PiaSaveSnapshotMethod$Params;", "equals", "other", "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final /* data */ class Params {

        @SerializedName("content")
        private final String content;

        @SerializedName("enforce")
        private final Boolean enforce;

        @SerializedName("expires")
        private final Number expires;

        @SerializedName("head")
        private final String head;

        @SerializedName("query")
        private final JsonObject query;

        @SerializedName("sdk")
        private final Integer sdk;

        @SerializedName("url")
        private final String url;

        @SerializedName(IPiaCacheProvider.CacheConfig.FIELD_VERSION)
        private final Number version;

        /* renamed from: component1, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: component2, reason: from getter */
        public final String getHead() {
            return this.head;
        }

        /* renamed from: component3, reason: from getter */
        public final Number getExpires() {
            return this.expires;
        }

        /* renamed from: component4, reason: from getter */
        public final JsonObject getQuery() {
            return this.query;
        }

        /* renamed from: component5, reason: from getter */
        public final Integer getSdk() {
            return this.sdk;
        }

        /* renamed from: component6, reason: from getter */
        public final Number getVersion() {
            return this.version;
        }

        /* renamed from: component7, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* renamed from: component8, reason: from getter */
        public final Boolean getEnforce() {
            return this.enforce;
        }

        public final Params copy(String content, String head, Number expires, JsonObject query, Integer sdk, Number version, String url, Boolean enforce) {
            return new Params(content, head, expires, query, sdk, version, url, enforce);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Params)) {
                return false;
            }
            Params params = (Params) other;
            return Intrinsics.areEqual(this.content, params.content) && Intrinsics.areEqual(this.head, params.head) && Intrinsics.areEqual(this.expires, params.expires) && Intrinsics.areEqual(this.query, params.query) && Intrinsics.areEqual(this.sdk, params.sdk) && Intrinsics.areEqual(this.version, params.version) && Intrinsics.areEqual(this.url, params.url) && Intrinsics.areEqual(this.enforce, params.enforce);
        }

        public int hashCode() {
            String str = this.content;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.head;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Number number = this.expires;
            int hashCode3 = (hashCode2 + (number == null ? 0 : number.hashCode())) * 31;
            JsonObject jsonObject = this.query;
            int hashCode4 = (hashCode3 + (jsonObject == null ? 0 : jsonObject.hashCode())) * 31;
            Integer num = this.sdk;
            int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
            Number number2 = this.version;
            int hashCode6 = (hashCode5 + (number2 == null ? 0 : number2.hashCode())) * 31;
            String str3 = this.url;
            int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Boolean bool = this.enforce;
            return hashCode7 + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            return "Params(content=" + this.content + ", head=" + this.head + ", expires=" + this.expires + ", query=" + this.query + ", sdk=" + this.sdk + ", version=" + this.version + ", url=" + this.url + ", enforce=" + this.enforce + ')';
        }

        public Params(String str, String str2, Number number, JsonObject jsonObject, Integer num, Number number2, String str3, Boolean bool) {
            this.content = str;
            this.head = str2;
            this.expires = number;
            this.query = jsonObject;
            this.sdk = num;
            this.version = number2;
            this.url = str3;
            this.enforce = bool;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getHead() {
            return this.head;
        }

        public final Number getExpires() {
            return this.expires;
        }

        public final JsonObject getQuery() {
            return this.query;
        }

        public final Integer getSdk() {
            return this.sdk;
        }

        public final Number getVersion() {
            return this.version;
        }

        public final String getUrl() {
            return this.url;
        }

        public final Boolean getEnforce() {
            return this.enforce;
        }
    }

    /* compiled from: PiaSaveSnapshotMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/pia/snapshot/bridge/PiaSaveSnapshotMethod$Result;", "", MetricConstant.MONITOR_STAGE_UPDATE, "", "(Ljava/lang/Boolean;)V", "getUpdate", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/bytedance/pia/snapshot/bridge/PiaSaveSnapshotMethod$Result;", "equals", "other", "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final /* data */ class Result {

        @SerializedName(MetricConstant.MONITOR_STAGE_UPDATE)
        private final Boolean update;

        public static /* synthetic */ Result copy$default(Result result, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = result.update;
            }
            return result.copy(bool);
        }

        /* renamed from: component1, reason: from getter */
        public final Boolean getUpdate() {
            return this.update;
        }

        public final Result copy(Boolean update) {
            return new Result(update);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Result) && Intrinsics.areEqual(this.update, ((Result) other).update);
        }

        public int hashCode() {
            Boolean bool = this.update;
            if (bool == null) {
                return 0;
            }
            return bool.hashCode();
        }

        public String toString() {
            return "Result(update=" + this.update + ')';
        }

        public Result(Boolean bool) {
            this.update = bool;
        }

        public final Boolean getUpdate() {
            return this.update;
        }
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(IPiaBridge bridge, Params params, IConsumer<Result> resolve, IConsumer<PiaMethod.Error> reject) {
        String str;
        String number;
        Intrinsics.checkNotNullParameter(bridge, "bridge");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(resolve, "resolve");
        Intrinsics.checkNotNullParameter(reject, "reject");
        Logger.d$default("[SnapShot] pia.saveSnapshot called (Expires: " + params.getExpires() + ", Query: " + params.getQuery() + ", SDK: " + params.getSdk() + ", Version: " + params.getVersion() + ", URL: " + params.getUrl() + "), Enforce: " + params.getEnforce(), null, null, 6, null);
        String content = params.getContent();
        String head = params.getHead();
        Number expires = params.getExpires();
        long currentTimeMillis = System.currentTimeMillis() + (expires != null ? expires.longValue() : 604800000);
        JsonObject query = params.getQuery();
        if (query == null || (str = query.toString()) == null) {
            str = "";
        }
        Integer sdk = params.getSdk();
        int intValue = sdk != null ? sdk.intValue() : 1;
        Number version = params.getVersion();
        String str2 = (version == null || (number = version.toString()) == null) ? "" : number;
        String url = params.getUrl();
        Boolean enforce = params.getEnforce();
        boolean booleanValue = enforce != null ? enforce.booleanValue() : true;
        if (TextUtils.isEmpty(content) || TextUtils.isEmpty(url)) {
            reject.accept(new PiaMethod.InvalidParamsError());
            return;
        }
        try {
            JSONObject jSONObject = (JSONObject) GsonUtils.fromJson(str, JSONObject.class);
            if (jSONObject == null) {
                reject.accept(new PiaMethod.InvalidParamsError());
                return;
            }
            SnapShotManager snapShotManager = SnapShotManager.INSTANCE;
            Intrinsics.checkNotNull(content);
            Intrinsics.checkNotNull(url);
            resolve.accept(new Result(Boolean.valueOf(snapShotManager.saveSnapShot(content, head, currentTimeMillis, jSONObject, intValue, str2, url, booleanValue))));
        } catch (ISnapshotStore.SnapshotConflictException e) {
            IPiaContext context = bridge.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.bytedance.pia.core.PiaContext");
            ((PiaContext) context).getMetrics().onError(ErrorType.SNAPSHOT, ErrorCode.SNAPSHOT_SAVE_FAIL_FOR_CONFLICT);
            reject.accept(new PiaMethod.Error(e.toString()));
        }
    }
}
