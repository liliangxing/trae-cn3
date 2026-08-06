package com.bytedance.trae.network;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.trae.network.response.BizResponse;
import kotlin.Metadata;

/* compiled from: IApiRespInterceptor.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/network/IApiRespInterceptor;", "", "intercept", "", ExifInterface.GPS_DIRECTION_TRUE, "path", "", "bizResp", "Lcom/bytedance/trae/network/response/BizResponse;", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IApiRespInterceptor {
    <T> boolean intercept(String path, BizResponse<T> bizResp);
}
