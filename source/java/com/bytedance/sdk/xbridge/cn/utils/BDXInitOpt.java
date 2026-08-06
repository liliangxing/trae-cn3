package com.bytedance.sdk.xbridge.cn.utils;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: BDXInitOpt.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\b\u0010\u0010\u001a\u00020\u0004H\u0007J\u001c\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0007J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0007R\u0018\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/utils/BDXInitOpt;", "", "()V", "bdxOptEnable", "", "getBdxOptEnable$annotations", "localData", "Lorg/json/JSONObject;", "getLocalData$annotations", "getLocalData", "()Lorg/json/JSONObject;", "setLocalData", "(Lorg/json/JSONObject;)V", "enableBDXOpt", "", "enable", "isBDXOptEnable", "isEquals", "obj1", "obj2", "isEqualsJSONArray", "arr1", "Lorg/json/JSONArray;", "arr2", "isEqualsJSONObject", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class BDXInitOpt {
    public static final BDXInitOpt INSTANCE = new BDXInitOpt();
    private static volatile boolean bdxOptEnable;
    private static volatile JSONObject localData;

    @JvmStatic
    private static /* synthetic */ void getBdxOptEnable$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getLocalData$annotations() {
    }

    private BDXInitOpt() {
    }

    @JvmStatic
    public static final void enableBDXOpt(boolean enable) {
        bdxOptEnable = enable;
    }

    @JvmStatic
    public static final boolean isBDXOptEnable() {
        return bdxOptEnable;
    }

    public static final JSONObject getLocalData() {
        return localData;
    }

    public static final void setLocalData(JSONObject jSONObject) {
        localData = jSONObject;
    }

    @JvmStatic
    public static final boolean isEquals(Object obj1, Object obj2) {
        if ((obj1 instanceof JSONObject) && (obj2 instanceof JSONObject)) {
            return isEqualsJSONObject((JSONObject) obj1, (JSONObject) obj2);
        }
        if ((obj1 instanceof JSONArray) && (obj2 instanceof JSONArray)) {
            return isEqualsJSONArray((JSONArray) obj1, (JSONArray) obj2);
        }
        return Intrinsics.areEqual(obj1, obj2);
    }

    @JvmStatic
    public static final boolean isEqualsJSONObject(JSONObject obj1, JSONObject obj2) {
        Intrinsics.checkNotNullParameter(obj1, "obj1");
        Intrinsics.checkNotNullParameter(obj2, "obj2");
        if (obj1.length() != obj2.length()) {
            return false;
        }
        Iterator<String> keys = obj1.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "obj1.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = obj1.opt(next);
            Intrinsics.checkNotNull(opt);
            if (!isEquals(opt, obj2.opt(next))) {
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    public static final boolean isEqualsJSONArray(JSONArray arr1, JSONArray arr2) {
        Intrinsics.checkNotNullParameter(arr1, "arr1");
        Intrinsics.checkNotNullParameter(arr2, "arr2");
        if (arr1.length() != arr2.length()) {
            return false;
        }
        int length = arr1.length();
        for (int i = 0; i < length; i++) {
            if (!isEquals(arr1.opt(i), arr2.opt(i))) {
                return false;
            }
        }
        return true;
    }
}
