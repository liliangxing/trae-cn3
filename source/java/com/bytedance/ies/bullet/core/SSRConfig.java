package com.bytedance.ies.bullet.core;

import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/bullet/core/SSRConfig;", "", "byteArray", "", "url", "", "data", "", "enabled", "", "([BLjava/lang/String;Ljava/util/Map;Z)V", "getByteArray", "()[B", "setByteArray", "([B)V", "getData", "()Ljava/util/Map;", AirActionConstant.ActionId.ACTION_ID_NAME_SET_DATA, "(Ljava/util/Map;)V", "getEnabled", "()Z", "setEnabled", "(Z)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class SSRConfig {
    private byte[] byteArray;
    private Map<String, ? extends Object> data;
    private boolean enabled;
    private String url;

    public SSRConfig(byte[] byteArray, String url, Map<String, ? extends Object> data, boolean z) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(data, "data");
        this.byteArray = byteArray;
        this.url = url;
        this.data = data;
        this.enabled = z;
    }

    public /* synthetic */ SSRConfig(byte[] bArr, String str, Map map, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, str, map, (i & 8) != 0 ? true : z);
    }

    public final byte[] getByteArray() {
        return this.byteArray;
    }

    public final Map<String, Object> getData() {
        return this.data;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setByteArray(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<set-?>");
        this.byteArray = bArr;
    }

    public final void setData(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.data = map;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }
}
