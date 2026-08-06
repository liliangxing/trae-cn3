package com.bytedance.sdk.xbridge.cn.auth.entity;

import com.bytedance.bdinstall.Api;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.webx.addr.AddressParam;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\nJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J?\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/entity/PermissionConfig;", "", AddressParam.SETTING_BDWK_EXTENSION_PATTERN, "Ljava/util/regex/Pattern;", Api.KEY_ACCESS, "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "includedMethods", "", "", "excludedMethods", "(Ljava/util/regex/Pattern;Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;Ljava/util/List;Ljava/util/List;)V", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "setAccess", "(Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;)V", "getExcludedMethods", "()Ljava/util/List;", "setExcludedMethods", "(Ljava/util/List;)V", "getIncludedMethods", "setIncludedMethods", "getPattern", "()Ljava/util/regex/Pattern;", "setPattern", "(Ljava/util/regex/Pattern;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PermissionConfig {
    private IDLXBridgeMethod.Access access;
    private List<String> excludedMethods;
    private List<String> includedMethods;
    private Pattern pattern;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PermissionConfig copy$default(PermissionConfig permissionConfig, Pattern pattern, IDLXBridgeMethod.Access access, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            pattern = permissionConfig.pattern;
        }
        if ((i & 2) != 0) {
            access = permissionConfig.access;
        }
        if ((i & 4) != 0) {
            list = permissionConfig.includedMethods;
        }
        if ((i & 8) != 0) {
            list2 = permissionConfig.excludedMethods;
        }
        return permissionConfig.copy(pattern, access, list, list2);
    }

    /* renamed from: component1, reason: from getter */
    public final Pattern getPattern() {
        return this.pattern;
    }

    /* renamed from: component2, reason: from getter */
    public final IDLXBridgeMethod.Access getAccess() {
        return this.access;
    }

    public final List<String> component3() {
        return this.includedMethods;
    }

    public final List<String> component4() {
        return this.excludedMethods;
    }

    public final PermissionConfig copy(Pattern pattern, IDLXBridgeMethod.Access access, List<String> includedMethods, List<String> excludedMethods) {
        Intrinsics.checkNotNullParameter(access, "access");
        Intrinsics.checkNotNullParameter(includedMethods, "includedMethods");
        Intrinsics.checkNotNullParameter(excludedMethods, "excludedMethods");
        return new PermissionConfig(pattern, access, includedMethods, excludedMethods);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermissionConfig)) {
            return false;
        }
        PermissionConfig permissionConfig = (PermissionConfig) other;
        return Intrinsics.areEqual(this.pattern, permissionConfig.pattern) && this.access == permissionConfig.access && Intrinsics.areEqual(this.includedMethods, permissionConfig.includedMethods) && Intrinsics.areEqual(this.excludedMethods, permissionConfig.excludedMethods);
    }

    public int hashCode() {
        Pattern pattern = this.pattern;
        return ((((((pattern == null ? 0 : pattern.hashCode()) * 31) + this.access.hashCode()) * 31) + this.includedMethods.hashCode()) * 31) + this.excludedMethods.hashCode();
    }

    public String toString() {
        return "PermissionConfig(pattern=" + this.pattern + ", access=" + this.access + ", includedMethods=" + this.includedMethods + ", excludedMethods=" + this.excludedMethods + ')';
    }

    public PermissionConfig(Pattern pattern, IDLXBridgeMethod.Access access, List<String> includedMethods, List<String> excludedMethods) {
        Intrinsics.checkNotNullParameter(access, "access");
        Intrinsics.checkNotNullParameter(includedMethods, "includedMethods");
        Intrinsics.checkNotNullParameter(excludedMethods, "excludedMethods");
        this.pattern = pattern;
        this.access = access;
        this.includedMethods = includedMethods;
        this.excludedMethods = excludedMethods;
    }

    public final Pattern getPattern() {
        return this.pattern;
    }

    public final void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.access;
    }

    public final void setAccess(IDLXBridgeMethod.Access access) {
        Intrinsics.checkNotNullParameter(access, "<set-?>");
        this.access = access;
    }

    public final List<String> getIncludedMethods() {
        return this.includedMethods;
    }

    public final void setIncludedMethods(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.includedMethods = list;
    }

    public final List<String> getExcludedMethods() {
        return this.excludedMethods;
    }

    public final void setExcludedMethods(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.excludedMethods = list;
    }
}
