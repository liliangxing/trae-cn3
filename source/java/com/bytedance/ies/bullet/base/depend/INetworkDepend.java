package com.bytedance.ies.bullet.base.depend;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* compiled from: INetworkDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007H&¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/base/depend/INetworkDepend;", "", "create", ExifInterface.GPS_DIRECTION_TRUE, "baseUrl", "", "api", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface INetworkDepend {
    <T> T create(String baseUrl, Class<T> api);
}
