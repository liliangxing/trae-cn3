package com.bytedance.iesgurd.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.iesgurd.settings.SettingsExtra;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: ApiResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/iesgurd/model/ApiResponse;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "data", "getData", "()Ljava/lang/Object;", AirActionConstant.ActionId.ACTION_ID_NAME_SET_DATA, "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "extra", "Lcom/bytedance/iesgurd/settings/SettingsExtra;", "getExtra", "()Lcom/bytedance/iesgurd/settings/SettingsExtra;", "setExtra", "(Lcom/bytedance/iesgurd/settings/SettingsExtra;)V", "msg", "", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "status", "", "getStatus", "()I", "setStatus", "(I)V", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final class ApiResponse<T> {

    @SerializedName("data")
    private T data;

    @SerializedName("extra")
    private SettingsExtra extra;

    @SerializedName("message")
    private String msg;

    @SerializedName("status")
    private int status;

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final T getData() {
        return this.data;
    }

    public final void setData(T t) {
        this.data = t;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final void setMsg(String str) {
        this.msg = str;
    }

    public final SettingsExtra getExtra() {
        return this.extra;
    }

    public final void setExtra(SettingsExtra settingsExtra) {
        this.extra = settingsExtra;
    }
}
