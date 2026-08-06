package com.bytedance.ies.argus.plugin;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ISecurePlugin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b \u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/argus/plugin/ISecurePluginHandler;", "", "type", "Lcom/bytedance/ies/argus/plugin/SecurePluginType;", "cId", "", "(Lcom/bytedance/ies/argus/plugin/SecurePluginType;Ljava/lang/String;)V", "getCId", "()Ljava/lang/String;", "pluginName", "getPluginName", "getType", "()Lcom/bytedance/ies/argus/plugin/SecurePluginType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ISecurePluginHandler {
    private final String cId;
    private final String pluginName;
    private final SecurePluginType type;

    public ISecurePluginHandler(SecurePluginType type, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.cId = str;
        this.pluginName = type.getStringValue();
    }

    public final SecurePluginType getType() {
        return this.type;
    }

    public final String getCId() {
        return this.cId;
    }

    public final String getPluginName() {
        return this.pluginName;
    }
}
