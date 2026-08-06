package com.bytedance.sdk.xbridge.cn.runtime.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingKeyEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/model/SettingKeyEntry;", "", "key", "", "type", "Lcom/bytedance/sdk/xbridge/cn/runtime/model/SettingValueType;", "(Ljava/lang/String;Lcom/bytedance/sdk/xbridge/cn/runtime/model/SettingValueType;)V", "biz", "getBiz", "()Ljava/lang/String;", "setBiz", "(Ljava/lang/String;)V", "getKey", "getType", "()Lcom/bytedance/sdk/xbridge/cn/runtime/model/SettingValueType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingKeyEntry {
    private String biz;
    private final String key;
    private final SettingValueType type;

    public SettingKeyEntry(String key, SettingValueType type) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(type, "type");
        this.key = key;
        this.type = type;
        this.biz = "";
    }

    public final String getKey() {
        return this.key;
    }

    public final SettingValueType getType() {
        return this.type;
    }

    public final String getBiz() {
        return this.biz;
    }

    public final void setBiz(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.biz = str;
    }
}
