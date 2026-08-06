package com.bytedance.pia.core.cache;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IPiaCacheProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/bytedance/pia/core/cache/IPiaCacheProvider;", "", "getCacheConfig", "Lcom/bytedance/pia/core/cache/IPiaCacheProvider$CacheConfig;", "getCacheContent", "", "getNormalizeUrl", "CacheConfig", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IPiaCacheProvider {
    CacheConfig getCacheConfig();

    String getCacheContent();

    String getNormalizeUrl();

    /* compiled from: IPiaCacheProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u001a\u001a\u00020\u0007J\b\u0010\u001b\u001a\u00020\u0005H\u0016R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/bytedance/pia/core/cache/IPiaCacheProvider$CacheConfig;", "", CacheConfig.FIELD_MAXAGE, "", "version", "", CacheConfig.FIELD_META, "Lcom/google/gson/JsonObject;", CacheConfig.FIELD_EXPIRE, CacheConfig.FIELD_MARK, "", "(Ljava/lang/Number;Ljava/lang/String;Lcom/google/gson/JsonObject;Ljava/lang/Number;Ljava/lang/Boolean;)V", "getExpire", "()Ljava/lang/Number;", "setExpire", "(Ljava/lang/Number;)V", "getMarked", "()Ljava/lang/Boolean;", "setMarked", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMaxAge", "getMeta", "()Lcom/google/gson/JsonObject;", "getVersion", "()Ljava/lang/String;", "toJsonObject", "toString", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class CacheConfig {
        public static final String FIELD_EXPIRE = "expire";
        public static final String FIELD_MARK = "marked";
        public static final String FIELD_MAXAGE = "maxAge";
        public static final String FIELD_META = "meta";
        public static final String FIELD_VERSION = "version";

        @SerializedName(FIELD_EXPIRE)
        private Number expire;

        @SerializedName(FIELD_MARK)
        private Boolean marked;

        @SerializedName(FIELD_MAXAGE)
        private final Number maxAge;

        @SerializedName(FIELD_META)
        private final JsonObject meta;

        @SerializedName("version")
        private final String version;

        public CacheConfig() {
            this(null, null, null, null, null, 31, null);
        }

        public CacheConfig(Number number, String str, JsonObject jsonObject, Number number2, Boolean bool) {
            this.maxAge = number;
            this.version = str;
            this.meta = jsonObject;
            this.expire = number2;
            this.marked = bool;
        }

        public /* synthetic */ CacheConfig(Number number, String str, JsonObject jsonObject, Number number2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : number, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : jsonObject, (i & 8) != 0 ? null : number2, (i & 16) != 0 ? null : bool);
        }

        public final Number getMaxAge() {
            return this.maxAge;
        }

        public final String getVersion() {
            return this.version;
        }

        public final JsonObject getMeta() {
            return this.meta;
        }

        public final Number getExpire() {
            return this.expire;
        }

        public final void setExpire(Number number) {
            this.expire = number;
        }

        public final Boolean getMarked() {
            return this.marked;
        }

        public final void setMarked(Boolean bool) {
            this.marked = bool;
        }

        public final JsonObject toJsonObject() {
            JsonObject jsonObject = new JsonObject();
            Number number = this.maxAge;
            if (number != null) {
                jsonObject.addProperty(FIELD_MAXAGE, number);
            }
            String str = this.version;
            if (str != null) {
                jsonObject.addProperty("version", str);
            }
            Number number2 = this.expire;
            if (number2 != null) {
                jsonObject.addProperty(FIELD_EXPIRE, number2);
            }
            JsonObject jsonObject2 = this.meta;
            if (jsonObject2 != null) {
                jsonObject.add(FIELD_META, jsonObject2);
            }
            Boolean bool = this.marked;
            if (bool != null) {
                bool.booleanValue();
                jsonObject.addProperty(FIELD_MARK, this.marked);
            }
            return jsonObject;
        }

        public String toString() {
            String jsonObject = toJsonObject().toString();
            Intrinsics.checkNotNullExpressionValue(jsonObject, "toJsonObject().toString()");
            return jsonObject;
        }
    }
}
