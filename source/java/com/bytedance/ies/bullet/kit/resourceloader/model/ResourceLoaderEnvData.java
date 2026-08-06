package com.bytedance.ies.bullet.kit.resourceloader.model;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceLoaderEnvData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/model/ResourceLoaderEnvData;", "", "type", "Lcom/bytedance/ies/bullet/kit/resourceloader/model/ResourceLoaderType;", "name", "", "(Lcom/bytedance/ies/bullet/kit/resourceloader/model/ResourceLoaderType;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getType", "()Lcom/bytedance/ies/bullet/kit/resourceloader/model/ResourceLoaderType;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ResourceLoaderEnvData {
    private final String name;
    private final ResourceLoaderType type;

    public static /* synthetic */ ResourceLoaderEnvData copy$default(ResourceLoaderEnvData resourceLoaderEnvData, ResourceLoaderType resourceLoaderType, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            resourceLoaderType = resourceLoaderEnvData.type;
        }
        if ((i & 2) != 0) {
            str = resourceLoaderEnvData.name;
        }
        return resourceLoaderEnvData.copy(resourceLoaderType, str);
    }

    /* renamed from: component1, reason: from getter */
    public final ResourceLoaderType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final ResourceLoaderEnvData copy(ResourceLoaderType type, String name) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        return new ResourceLoaderEnvData(type, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResourceLoaderEnvData)) {
            return false;
        }
        ResourceLoaderEnvData resourceLoaderEnvData = (ResourceLoaderEnvData) other;
        return this.type == resourceLoaderEnvData.type && Intrinsics.areEqual(this.name, resourceLoaderEnvData.name);
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.name.hashCode();
    }

    public String toString() {
        return "ResourceLoaderEnvData(type=" + this.type + ", name=" + this.name + ')';
    }

    public ResourceLoaderEnvData(ResourceLoaderType type, String name) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        this.type = type;
        this.name = name;
    }

    public final String getName() {
        return this.name;
    }

    public final ResourceLoaderType getType() {
        return this.type;
    }
}
