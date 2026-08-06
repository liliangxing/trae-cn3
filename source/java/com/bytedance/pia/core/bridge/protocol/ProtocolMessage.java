package com.bytedance.pia.core.bridge.protocol;

import android.text.TextUtils;
import com.bytedance.pia.core.utils.GsonUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProtocolMessage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0004\u001c\u001d\u001e\u001fBA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\fJ\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u0010R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/bytedance/pia/core/bridge/protocol/ProtocolMessage;", "", "type", "Lcom/bytedance/pia/core/bridge/protocol/ProtocolMessage$Type;", "id", "", "data", "Lcom/google/gson/JsonObject;", "name", "", "status", "message", "(Lcom/bytedance/pia/core/bridge/protocol/ProtocolMessage$Type;Ljava/lang/Integer;Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getData", "()Lcom/google/gson/JsonObject;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Ljava/lang/String;", "getName", "getStatus", "getType", "()Lcom/bytedance/pia/core/bridge/protocol/ProtocolMessage$Type;", "asCallback", "Lcom/bytedance/pia/core/bridge/protocol/ProtocolMessage$Callback;", "asInvocation", "Lcom/bytedance/pia/core/bridge/protocol/ProtocolMessage$Invocation;", "Callback", "Companion", "Invocation", "Type", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ProtocolMessage {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @SerializedName("data")
    private final JsonObject data;

    @SerializedName("id")
    private final Integer id;

    @SerializedName("err_msg")
    private final String message;

    @SerializedName("name")
    private final String name;

    @SerializedName("status")
    private final Integer status;

    @SerializedName("type")
    private final Type type;

    /* compiled from: ProtocolMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/pia/core/bridge/protocol/ProtocolMessage$Type;", "", "(Ljava/lang/String;I)V", "Invocation", "Callback", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public enum Type {
        Invocation,
        Callback
    }

    @JvmStatic
    public static final ProtocolMessage fromRaw(JsonObject jsonObject) {
        return INSTANCE.fromRaw(jsonObject);
    }

    @JvmStatic
    public static final JsonObject toRaw(Callback callback) {
        return INSTANCE.toRaw(callback);
    }

    @JvmStatic
    public static final JsonObject toRaw(Invocation invocation) {
        return INSTANCE.toRaw(invocation);
    }

    public ProtocolMessage(Type type, Integer num, JsonObject jsonObject, String str, Integer num2, String str2) {
        this.type = type;
        this.id = num;
        this.data = jsonObject;
        this.name = str;
        this.status = num2;
        this.message = str2;
    }

    public final Type getType() {
        return this.type;
    }

    public final Integer getId() {
        return this.id;
    }

    public final JsonObject getData() {
        return this.data;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getMessage() {
        return this.message;
    }

    /* compiled from: ProtocolMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/pia/core/bridge/protocol/ProtocolMessage$Invocation;", "", "id", "", "name", "", "data", "Lcom/google/gson/JsonObject;", "(ILjava/lang/String;Lcom/google/gson/JsonObject;)V", "getData", "()Lcom/google/gson/JsonObject;", "getId", "()I", "getName", "()Ljava/lang/String;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Invocation {
        private final JsonObject data;
        private final int id;
        private final String name;

        public Invocation(int i, String str, JsonObject jsonObject) {
            Intrinsics.checkNotNullParameter(str, "name");
            this.id = i;
            this.name = str;
            this.data = jsonObject;
        }

        public final int getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final JsonObject getData() {
            return this.data;
        }
    }

    /* compiled from: ProtocolMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/pia/core/bridge/protocol/ProtocolMessage$Callback;", "", "id", "", "status", "data", "Lcom/google/gson/JsonObject;", "message", "", "(IILcom/google/gson/JsonObject;Ljava/lang/String;)V", "getData", "()Lcom/google/gson/JsonObject;", "getId", "()I", "getMessage", "()Ljava/lang/String;", "getStatus", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Callback {
        private final JsonObject data;
        private final int id;
        private final String message;
        private final int status;

        public Callback(int i, int i2, JsonObject jsonObject, String str) {
            this.id = i;
            this.status = i2;
            this.data = jsonObject;
            this.message = str;
        }

        public final int getId() {
            return this.id;
        }

        public final int getStatus() {
            return this.status;
        }

        public final JsonObject getData() {
            return this.data;
        }

        public final String getMessage() {
            return this.message;
        }
    }

    public final Invocation asInvocation() {
        if (Type.Invocation != this.type || TextUtils.isEmpty(this.name) || this.id == null) {
            return null;
        }
        int intValue = this.id.intValue();
        String str = this.name;
        Intrinsics.checkNotNull(str);
        return new Invocation(intValue, str, this.data);
    }

    public final Callback asCallback() {
        Integer num;
        if (Type.Callback == this.type && (num = this.id) != null && ((num == null || num.intValue() != 0) && this.status != null)) {
            return new Callback(this.id.intValue(), this.status.intValue(), this.data, this.message);
        }
        return null;
    }

    /* compiled from: ProtocolMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/pia/core/bridge/protocol/ProtocolMessage$Companion;", "", "()V", "fromRaw", "Lcom/bytedance/pia/core/bridge/protocol/ProtocolMessage;", "raw", "Lcom/google/gson/JsonObject;", "toRaw", "callback", "Lcom/bytedance/pia/core/bridge/protocol/ProtocolMessage$Callback;", "invocation", "Lcom/bytedance/pia/core/bridge/protocol/ProtocolMessage$Invocation;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ProtocolMessage fromRaw(JsonObject raw) {
            Object obj;
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl((ProtocolMessage) GsonUtils.getGson().fromJson((JsonElement) raw, ProtocolMessage.class));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            return (ProtocolMessage) obj;
        }

        @JvmStatic
        public final JsonObject toRaw(Invocation invocation) {
            Object obj;
            if (invocation == null || TextUtils.isEmpty(invocation.getName())) {
                return null;
            }
            ProtocolMessage protocolMessage = new ProtocolMessage(Type.Invocation, Integer.valueOf(invocation.getId()), invocation.getData(), invocation.getName(), null, null);
            try {
                Result.Companion companion = Result.Companion;
                JsonObject jsonTree = GsonUtils.getGson().toJsonTree(protocolMessage);
                Intrinsics.checkNotNull(jsonTree, "null cannot be cast to non-null type com.google.gson.JsonObject");
                obj = Result.constructor-impl(jsonTree);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            return (JsonObject) (Result.isFailure-impl(obj) ? null : obj);
        }

        @JvmStatic
        public final JsonObject toRaw(Callback callback) {
            Object obj;
            if (callback == null || callback.getId() == 0) {
                return null;
            }
            ProtocolMessage protocolMessage = new ProtocolMessage(Type.Callback, Integer.valueOf(callback.getId()), callback.getData(), null, Integer.valueOf(callback.getStatus()), callback.getMessage());
            try {
                Result.Companion companion = Result.Companion;
                JsonObject jsonTree = GsonUtils.getGson().toJsonTree(protocolMessage);
                Intrinsics.checkNotNull(jsonTree, "null cannot be cast to non-null type com.google.gson.JsonObject");
                obj = Result.constructor-impl(jsonTree);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            return (JsonObject) (Result.isFailure-impl(obj) ? null : obj);
        }
    }
}
