package com.bytedance.trae.home.solo.setting;

import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CNCommercialApiParser.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\u0007\u001a\u00020\bJ/\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0005\"\u0004\b\u0000\u0010\u000e*\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u0001H\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000f*\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\bH\u0002J\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\u0018J\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u0012*\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u0004\u0018\u00010\b*\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\bH\u0002J\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d*\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;", "", "<init>", "()V", "parsePayStatus", "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;", "body", "", "parseUsage", "Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;", "parseBillingSwitch", "", "toBizResponse", "T", "Lcom/google/gson/JsonObject;", "data", "missingCode", "", "(Lcom/google/gson/JsonObject;Ljava/lang/Object;J)Lcom/bytedance/trae/network/response/BizResponse;", "objectOrNull", "key", "intOrNull", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Integer;", "longOrNull", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Long;", "stringOrNull", "booleanOrNull", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Boolean;", "COMPAT_SUCCESS_CODE", "PAY_STATUS_FIELDS", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CNCommercialApiParser {
    private static final long COMPAT_SUCCESS_CODE = 0;
    public static final CNCommercialApiParser INSTANCE = new CNCommercialApiParser();
    private static final Set<String> PAY_STATUS_FIELDS = SetsKt.setOf(new String[]{"user_pay_identity", "user_pay_identity_str", "is_credits_billing"});
    public static final int $stable = 8;

    private CNCommercialApiParser() {
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[LOOP:0: B:22:0x0062->B:36:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final BizResponse<CNUserPayStatusData> parsePayStatus(String body) {
        boolean booleanValue;
        boolean z;
        Intrinsics.checkNotNullParameter(body, "body");
        JsonObject asJsonObject = JsonParser.parseString(body).getAsJsonObject();
        JsonObject objectOrNull = objectOrNull(asJsonObject, "data");
        Integer intOrNull = intOrNull(asJsonObject, "user_pay_identity");
        if (intOrNull == null) {
            intOrNull = intOrNull(objectOrNull, "user_pay_identity");
        }
        String stringOrNull = stringOrNull(asJsonObject, "user_pay_identity_str");
        if (stringOrNull == null) {
            stringOrNull = stringOrNull(objectOrNull, "user_pay_identity_str");
        }
        Boolean booleanOrNull = booleanOrNull(asJsonObject, "is_credits_billing");
        boolean z2 = false;
        if (booleanOrNull != null) {
            booleanValue = booleanOrNull.booleanValue();
        } else {
            Boolean booleanOrNull2 = booleanOrNull(objectOrNull, "is_credits_billing");
            booleanValue = booleanOrNull2 != null ? booleanOrNull2.booleanValue() : false;
        }
        CNUserPayStatusData cNUserPayStatusData = new CNUserPayStatusData(intOrNull, stringOrNull, booleanValue);
        Set<String> set = PAY_STATUS_FIELDS;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator<T> it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                if (!asJsonObject.has(str)) {
                    if (!(objectOrNull != null && objectOrNull.has(str))) {
                        z = false;
                        if (!z) {
                            z2 = true;
                            break;
                        }
                    }
                }
                z = true;
                if (!z) {
                }
            }
        }
        Intrinsics.checkNotNull(asJsonObject);
        return toBizResponse(asJsonObject, cNUserPayStatusData, z2 ? 0L : -999L);
    }

    public final BizResponse<UserEntStatusResponse> parseUsage(String body) {
        Intrinsics.checkNotNullParameter(body, "body");
        JsonElement asJsonObject = JsonParser.parseString(body).getAsJsonObject();
        UserEntStatusResponse userEntStatusResponse = (UserEntStatusResponse) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(asJsonObject, UserEntStatusResponse.class);
        JsonElement jsonElement = asJsonObject.get("user_entitlement_pack_list");
        if (jsonElement == null || !jsonElement.isJsonArray()) {
            jsonElement = null;
        }
        boolean z = jsonElement != null;
        Intrinsics.checkNotNull(asJsonObject);
        return toBizResponse(asJsonObject, userEntStatusResponse, z ? 0L : -999L);
    }

    public final BizResponse<Unit> parseBillingSwitch(String body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return new BizResponse<>(0L, (String) null, (String) null, (String) null, Unit.INSTANCE, (String) null, 46, (DefaultConstructorMarker) null);
    }

    private final <T> BizResponse<T> toBizResponse(JsonObject jsonObject, T t, long j) {
        Long longOrNull = longOrNull(jsonObject, "code");
        if (longOrNull != null) {
            j = longOrNull.longValue();
        }
        return new BizResponse<>(j, stringOrNull(jsonObject, "msg"), stringOrNull(jsonObject, "message"), (String) null, t, (String) null, 40, (DefaultConstructorMarker) null);
    }

    private final JsonObject objectOrNull(JsonObject jsonObject, String str) {
        JsonElement jsonElement;
        if (jsonObject == null || (jsonElement = jsonObject.get(str)) == null) {
            return null;
        }
        if (!jsonElement.isJsonObject()) {
            jsonElement = null;
        }
        if (jsonElement != null) {
            return jsonElement.getAsJsonObject();
        }
        return null;
    }

    private final Integer intOrNull(JsonObject jsonObject, String str) {
        JsonElement jsonElement;
        Object obj;
        if (jsonObject == null || (jsonElement = jsonObject.get(str)) == null) {
            return null;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        if (jsonElement == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Integer.valueOf(jsonElement.getAsInt()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (Integer) (Result.isFailure-impl(obj) ? null : obj);
    }

    private final Long longOrNull(JsonObject jsonObject, String str) {
        JsonElement jsonElement;
        Object obj;
        if (jsonObject == null || (jsonElement = jsonObject.get(str)) == null) {
            return null;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        if (jsonElement == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Long.valueOf(jsonElement.getAsLong()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (Long) (Result.isFailure-impl(obj) ? null : obj);
    }

    private final String stringOrNull(JsonObject jsonObject, String str) {
        JsonElement jsonElement;
        Object obj;
        if (jsonObject == null || (jsonElement = jsonObject.get(str)) == null) {
            return null;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        if (jsonElement == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(jsonElement.getAsString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (String) (Result.isFailure-impl(obj) ? null : obj);
    }

    private final Boolean booleanOrNull(JsonObject jsonObject, String str) {
        JsonElement jsonElement;
        Object obj;
        if (jsonObject == null || (jsonElement = jsonObject.get(str)) == null) {
            return null;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        if (jsonElement == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Boolean.valueOf(jsonElement.getAsBoolean()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (Boolean) (Result.isFailure-impl(obj) ? null : obj);
    }
}
