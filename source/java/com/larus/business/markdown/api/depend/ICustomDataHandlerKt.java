package com.larus.business.markdown.api.depend;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICustomDataHandler.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"TYPE_APPLET", "", "TYPE_FLOW_CREATION", "TYPE_IMAGE_GROUP", "TYPE_LYNX", "TYPE_LYNX_RUYI", "TYPE_MEMORY", "TYPE_SEARCH_REFERENCE", "TYPE_SIMPLE_IMAGE_GROUP", "TYPE_UGC", "TYPE_VIDEO_GROUP", "TYPE_VIDEO_GROUP_V2", "TYPE_VLM_MIXED_MEDIA_CARD", "isMarkdownLynxDataType", "", "dataType", "markdown-api_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class ICustomDataHandlerKt {
    public static final String TYPE_APPLET = "applet";
    public static final String TYPE_FLOW_CREATION = "creation";
    public static final String TYPE_IMAGE_GROUP = "image-group";
    public static final String TYPE_LYNX = "lynx";
    public static final String TYPE_LYNX_RUYI = "lynx_ruyi";
    public static final String TYPE_MEMORY = "memory";
    public static final String TYPE_SEARCH_REFERENCE = "search_reference";
    public static final String TYPE_SIMPLE_IMAGE_GROUP = "simple-image-group";
    public static final String TYPE_UGC = "mixed_media_card";
    public static final String TYPE_VIDEO_GROUP = "video-group";
    public static final String TYPE_VIDEO_GROUP_V2 = "video-group-v2";
    public static final String TYPE_VLM_MIXED_MEDIA_CARD = "vlm_mixed_media_card";

    public static final boolean isMarkdownLynxDataType(String dataType) {
        Intrinsics.checkNotNullParameter(dataType, "dataType");
        return Intrinsics.areEqual(dataType, "lynx") || Intrinsics.areEqual(dataType, TYPE_LYNX_RUYI);
    }
}
