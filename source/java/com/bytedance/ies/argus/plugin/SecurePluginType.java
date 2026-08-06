package com.bytedance.ies.argus.plugin;

import com.bytedance.ies.argus.bean.IEnumClass;
import kotlin.Metadata;

/* compiled from: ISecurePlugin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0017\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/argus/plugin/SecurePluginType;", "", "Lcom/bytedance/ies/argus/bean/IEnumClass;", "stringValue", "", "instanceType", "Lcom/bytedance/ies/argus/plugin/SecurePluginInstanceType;", "(Ljava/lang/String;ILjava/lang/String;Lcom/bytedance/ies/argus/plugin/SecurePluginInstanceType;)V", "getInstanceType", "()Lcom/bytedance/ies/argus/plugin/SecurePluginInstanceType;", "getStringValue", "()Ljava/lang/String;", "SEC_LINK", "TTMACHINE", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public enum SecurePluginType implements IEnumClass {
    SEC_LINK("sec_link", SecurePluginInstanceType.CONTAINER),
    TTMACHINE("ttmachine", SecurePluginInstanceType.GLOBAL);

    private final SecurePluginInstanceType instanceType;
    private final String stringValue;

    SecurePluginType(String str, SecurePluginInstanceType securePluginInstanceType) {
        this.stringValue = str;
        this.instanceType = securePluginInstanceType;
    }

    @Override // com.bytedance.ies.argus.bean.IEnumClass
    public String getStringValue() {
        return this.stringValue;
    }

    public final SecurePluginInstanceType getInstanceType() {
        return this.instanceType;
    }
}
