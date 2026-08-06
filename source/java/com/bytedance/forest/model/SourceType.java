package com.bytedance.forest.model;

import kotlin.Metadata;

/* compiled from: constants.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/forest/model/SourceType;", "", "()V", "BUILTIN", "", "CDN_CACHE", "CDN_ONLINE", "GECKO_OFFINLE_CDN", "GECKO_OFFLINE", "GECKO_UPDATE", "MEMORY", "UNKNOWN", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class SourceType {
    public static final String BUILTIN = "builtin";
    public static final String CDN_CACHE = "cdn_cache";
    public static final String CDN_ONLINE = "cdn";
    public static final String GECKO_OFFINLE_CDN = "gecko_offline_cdn";
    public static final String GECKO_OFFLINE = "gecko";
    public static final String GECKO_UPDATE = "gecko_update";
    public static final SourceType INSTANCE = new SourceType();
    public static final String MEMORY = "memory";
    public static final String UNKNOWN = "unknown";

    private SourceType() {
    }
}
