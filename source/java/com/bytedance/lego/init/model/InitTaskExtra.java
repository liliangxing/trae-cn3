package com.bytedance.lego.init.model;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitTaskExtra.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020\u0005H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/bytedance/lego/init/model/InitTaskExtra;", "", "()V", "children", "", "", "getChildren", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", WiseOpenHianalyticsData.UNION_COSTTIME, "", "getCostTime", "()J", "setCostTime", "(J)V", "dependencies", "getDependencies", "setDependencies", "parent", "getParent", "setParent", "priority", "", "getPriority", "()I", "setPriority", "(I)V", "realPriority", "", "getRealPriority", "()F", "setRealPriority", "(F)V", "toString", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class InitTaskExtra {
    private long costTime;
    private float realPriority;
    private int priority = -1;
    private List<String> children = new ArrayList();
    private List<String> parent = new ArrayList();
    private List<String> dependencies = new ArrayList();

    public final int getPriority() {
        return this.priority;
    }

    public final void setPriority(int i) {
        this.priority = i;
    }

    public final float getRealPriority() {
        return this.realPriority;
    }

    public final void setRealPriority(float f) {
        this.realPriority = f;
    }

    public final long getCostTime() {
        return this.costTime;
    }

    public final void setCostTime(long j) {
        this.costTime = j;
    }

    public final List<String> getChildren() {
        return this.children;
    }

    public final void setChildren(List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.children = list;
    }

    public final List<String> getParent() {
        return this.parent;
    }

    public final void setParent(List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.parent = list;
    }

    public final List<String> getDependencies() {
        return this.dependencies;
    }

    public final void setDependencies(List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.dependencies = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("priority:" + this.priority);
        sb.append(", children: ");
        for (String str : this.children) {
        }
        sb.append(", parent: ");
        for (String str2 : this.parent) {
        }
        sb.append(", dependencies: ");
        for (String str3 : this.dependencies) {
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "stringBuilder.toString()");
        return sb2;
    }
}
