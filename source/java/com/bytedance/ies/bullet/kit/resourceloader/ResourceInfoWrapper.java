package com.bytedance.ies.bullet.kit.resourceloader;

import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceInfoWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceInfoWrapper;", "", "info", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "config", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "(Lcom/bytedance/ies/bullet/service/base/ResourceInfo;Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;)V", "getConfig", "()Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "setConfig", "(Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;)V", "getInfo", "()Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "setInfo", "(Lcom/bytedance/ies/bullet/service/base/ResourceInfo;)V", "isASync", "", "()Z", "setASync", "(Z)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ResourceInfoWrapper {
    private TaskConfig config;
    private ResourceInfo info;
    private boolean isASync;

    public ResourceInfoWrapper(ResourceInfo resourceInfo, TaskConfig taskConfig) {
        Intrinsics.checkNotNullParameter(resourceInfo, "info");
        Intrinsics.checkNotNullParameter(taskConfig, "config");
        this.info = resourceInfo;
        this.config = taskConfig;
    }

    public final ResourceInfo getInfo() {
        return this.info;
    }

    public final void setInfo(ResourceInfo resourceInfo) {
        Intrinsics.checkNotNullParameter(resourceInfo, "<set-?>");
        this.info = resourceInfo;
    }

    public final TaskConfig getConfig() {
        return this.config;
    }

    public final void setConfig(TaskConfig taskConfig) {
        Intrinsics.checkNotNullParameter(taskConfig, "<set-?>");
        this.config = taskConfig;
    }

    /* renamed from: isASync, reason: from getter */
    public final boolean getIsASync() {
        return this.isASync;
    }

    public final void setASync(boolean z) {
        this.isASync = z;
    }
}
