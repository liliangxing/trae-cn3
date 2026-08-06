package com.bytedance.sdk.xbridge.cn.auth.entity;

import com.bytedance.bdinstall.Api;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionConfigNamespace.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/entity/PermissionRule;", "", Api.KEY_ACCESS, "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "includedMethods", "", "", "excludedMethods", "(Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;Ljava/util/Set;Ljava/util/Set;)V", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "setAccess", "(Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;)V", "getExcludedMethods", "()Ljava/util/Set;", "setExcludedMethods", "(Ljava/util/Set;)V", "getIncludedMethods", "setIncludedMethods", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PermissionRule {
    private IDLXBridgeMethod.Access access;
    private Set<String> excludedMethods;
    private Set<String> includedMethods;

    public PermissionRule() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PermissionRule copy$default(PermissionRule permissionRule, IDLXBridgeMethod.Access access, Set set, Set set2, int i, Object obj) {
        if ((i & 1) != 0) {
            access = permissionRule.access;
        }
        if ((i & 2) != 0) {
            set = permissionRule.includedMethods;
        }
        if ((i & 4) != 0) {
            set2 = permissionRule.excludedMethods;
        }
        return permissionRule.copy(access, set, set2);
    }

    /* renamed from: component1, reason: from getter */
    public final IDLXBridgeMethod.Access getAccess() {
        return this.access;
    }

    public final Set<String> component2() {
        return this.includedMethods;
    }

    public final Set<String> component3() {
        return this.excludedMethods;
    }

    public final PermissionRule copy(IDLXBridgeMethod.Access access, Set<String> includedMethods, Set<String> excludedMethods) {
        Intrinsics.checkNotNullParameter(access, "access");
        Intrinsics.checkNotNullParameter(includedMethods, "includedMethods");
        Intrinsics.checkNotNullParameter(excludedMethods, "excludedMethods");
        return new PermissionRule(access, includedMethods, excludedMethods);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermissionRule)) {
            return false;
        }
        PermissionRule permissionRule = (PermissionRule) other;
        return this.access == permissionRule.access && Intrinsics.areEqual(this.includedMethods, permissionRule.includedMethods) && Intrinsics.areEqual(this.excludedMethods, permissionRule.excludedMethods);
    }

    public int hashCode() {
        return (((this.access.hashCode() * 31) + this.includedMethods.hashCode()) * 31) + this.excludedMethods.hashCode();
    }

    public String toString() {
        return "PermissionRule(access=" + this.access + ", includedMethods=" + this.includedMethods + ", excludedMethods=" + this.excludedMethods + ')';
    }

    public PermissionRule(IDLXBridgeMethod.Access access, Set<String> includedMethods, Set<String> excludedMethods) {
        Intrinsics.checkNotNullParameter(access, "access");
        Intrinsics.checkNotNullParameter(includedMethods, "includedMethods");
        Intrinsics.checkNotNullParameter(excludedMethods, "excludedMethods");
        this.access = access;
        this.includedMethods = includedMethods;
        this.excludedMethods = excludedMethods;
    }

    public /* synthetic */ PermissionRule(IDLXBridgeMethod.Access access, LinkedHashSet linkedHashSet, LinkedHashSet linkedHashSet2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? IDLXBridgeMethod.Access.PUBLIC : access, (i & 2) != 0 ? new LinkedHashSet() : linkedHashSet, (i & 4) != 0 ? new LinkedHashSet() : linkedHashSet2);
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.access;
    }

    public final void setAccess(IDLXBridgeMethod.Access access) {
        Intrinsics.checkNotNullParameter(access, "<set-?>");
        this.access = access;
    }

    public final Set<String> getIncludedMethods() {
        return this.includedMethods;
    }

    public final void setIncludedMethods(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.includedMethods = set;
    }

    public final Set<String> getExcludedMethods() {
        return this.excludedMethods;
    }

    public final void setExcludedMethods(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.excludedMethods = set;
    }
}
