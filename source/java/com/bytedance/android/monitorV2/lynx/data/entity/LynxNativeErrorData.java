package com.bytedance.android.monitorV2.lynx.data.entity;

import com.bytedance.android.monitorV2.base.BaseNativeInfo;
import com.bytedance.android.monitorV2.util.JsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: LynxNativeErrorData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxNativeErrorData;", "Lcom/bytedance/android/monitorV2/base/BaseNativeInfo;", "()V", "errorCode", "", "getErrorCode", "()I", "setErrorCode", "(I)V", "errorMsg", "", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "scene", "getScene", "setScene", "appendNativeInfoParams", "", "jsonObject", "Lorg/json/JSONObject;", "fillInJsonObject", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class LynxNativeErrorData extends BaseNativeInfo {
    public static final int LYNX_ERROR_CODE_JAVASCRIPT = 201;
    public static final int LYNX_ERROR_CODE_LAYOUT = 102;
    public static final int LYNX_ERROR_CODE_LEPUS = 1101;
    public static final int LYNX_ERROR_CODE_LOAD_TEMPLATE = 100;
    public static final int LYNX_ERROR_CODE_RESOURCE = 301;
    public static final int LYNX_ERROR_CODE_TEMPLATE_PROVIDER = 103;
    public static final int LYNX_ERROR_CODE_UPDATE = 101;
    private int errorCode;
    private String errorMsg;
    private String scene;

    public LynxNativeErrorData() {
        super("nativeError");
        this.scene = "lynx_error";
    }

    public final String getScene() {
        return this.scene;
    }

    public final void setScene(String str) {
        this.scene = str;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(int i) {
        this.errorCode = i;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    @Override // com.bytedance.android.monitorV2.base.BaseMonitorData
    public void fillInJsonObject(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        appendNativeInfoParams(jsonObject);
    }

    private final void appendNativeInfoParams(JSONObject jsonObject) {
        JsonUtils.safePut(jsonObject, "scene", this.scene);
        JsonUtils.safePut(jsonObject, "error_code", this.errorCode);
        JsonUtils.safePut(jsonObject, "error_msg", this.errorMsg);
    }
}
