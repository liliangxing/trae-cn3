package com.bytedance.push.settings.permission.boot;

import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes4.dex */
public class PermissionBootChannelModel {

    @SerializedName("enable_permission_channel_clear")
    public boolean enablePermissionChannelClear = false;

    @SerializedName("request_code_white_list")
    public List<Integer> requestCodeWhiteList = Collections.emptyList();

    @SerializedName("channel_name_white_list")
    public List<String> channelNameWhiteList = Collections.emptyList();

    @SerializedName("channel_name_show_map")
    public Map<String, String> channelNameShowMap = new HashMap();

    public String toString() {
        return "PermissionBootChannelModel{enablePermissionChannelClear=" + this.enablePermissionChannelClear + ", requestCodeWhiteList=" + this.requestCodeWhiteList + ", channelNameWhiteList=" + this.channelNameWhiteList + ", channelNameShowMap=" + this.channelNameShowMap + AbstractJsonLexerKt.END_OBJ;
    }
}
