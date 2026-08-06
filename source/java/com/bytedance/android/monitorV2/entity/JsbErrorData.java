package com.bytedance.android.monitorV2.entity;

import com.bytedance.android.monitorV2.base.BaseNativeInfo;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: JsbErrorData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BK\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nB\u0005¢\u0006\u0002\u0010\u000bJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR(\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000f¨\u0006'"}, d2 = {"Lcom/bytedance/android/monitorV2/entity/JsbErrorData;", "Lcom/bytedance/android/monitorV2/base/BaseNativeInfo;", "isSync", "", "errorCode", "errorMessage", "", "bridgeName", "errorActivity", MonitorConstants.PROTOCOL, "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "getBridgeName", "()Ljava/lang/String;", "setBridgeName", "(Ljava/lang/String;)V", "getErrorActivity", "setErrorActivity", "getErrorCode", "()I", "setErrorCode", "(I)V", "getErrorMessage", "setErrorMessage", "extra", "", "", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "setSync", "getProtocol", "setProtocol", "fillInJsonObject", "", "jsonObject", "Lorg/json/JSONObject;", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class JsbErrorData extends BaseNativeInfo {
    private String bridgeName;
    private String errorActivity;
    private int errorCode;
    private String errorMessage;
    private Map<String, ? extends Object> extra;
    private int isSync;
    private String protocol;

    public JsbErrorData() {
        super("jsbError");
    }

    /* renamed from: isSync, reason: from getter */
    public final int getIsSync() {
        return this.isSync;
    }

    public final void setSync(int i) {
        this.isSync = i;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(int i) {
        this.errorCode = i;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final String getBridgeName() {
        return this.bridgeName;
    }

    public final void setBridgeName(String str) {
        this.bridgeName = str;
    }

    public final String getErrorActivity() {
        return this.errorActivity;
    }

    public final void setErrorActivity(String str) {
        this.errorActivity = str;
    }

    public final String getProtocol() {
        return this.protocol;
    }

    public final void setProtocol(String str) {
        this.protocol = str;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final void setExtra(Map<String, ? extends Object> map) {
        this.extra = map;
    }

    public /* synthetic */ JsbErrorData(int i, int i2, String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) == 0 ? i2 : 0, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : str4);
    }

    public JsbErrorData(int i, int i2, String str, String str2, String str3, String str4) {
        this();
        this.isSync = i;
        this.errorCode = i2;
        this.errorMessage = str;
        this.bridgeName = str2;
        this.errorActivity = str3;
        this.protocol = str4;
    }

    @Override // com.bytedance.android.monitorV2.base.BaseMonitorData
    public void fillInJsonObject(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        JsonUtils.safePut(jsonObject, "is_sync", this.isSync);
        JsonUtils.safePut(jsonObject, "error_code", this.errorCode);
        JsonUtils.safePut(jsonObject, "error_message", this.errorMessage);
        JsonUtils.safePut(jsonObject, "bridge_name", this.bridgeName);
        JsonUtils.safePut(jsonObject, "error_activity", this.errorActivity);
        JsonUtils.safePut(jsonObject, "protocol_version", this.protocol);
    }

    @Override // com.bytedance.android.monitorV2.base.BaseNativeInfo
    public String toString() {
        return "JsbErrorData(isSync=" + this.isSync + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", bridgeName=" + this.bridgeName + ", errorActivity=" + this.errorActivity + ", protocol=" + this.protocol + ')';
    }
}
