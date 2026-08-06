package com.bytedance.sdk.xbridge.cn.media.utils;

import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: ResponseJsonConvert.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/utils/UploadFileResponse;", "", "()V", "data", "Lcom/bytedance/sdk/xbridge/cn/media/utils/AvatarUri;", "getData", "()Lcom/bytedance/sdk/xbridge/cn/media/utils/AvatarUri;", AirActionConstant.ActionId.ACTION_ID_NAME_SET_DATA, "(Lcom/bytedance/sdk/xbridge/cn/media/utils/AvatarUri;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class UploadFileResponse {

    @SerializedName("data")
    private AvatarUri data;

    public final AvatarUri getData() {
        return this.data;
    }

    public final void setData(AvatarUri avatarUri) {
        this.data = avatarUri;
    }
}
