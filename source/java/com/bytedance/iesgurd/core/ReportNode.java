package com.bytedance.iesgurd.core;

import kotlin.Metadata;

/* compiled from: Enum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0081\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/iesgurd/core/ReportNode;", "", "tag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "GECKO_REGISTER_BY_IREGISTER", "GECKO_REGISTER_CUSTOM_PARAMS", "CHECK_UPDATE_REQUEST", "CHECK_UPDATE_RESPONSE", "SYNC_GLOBAL_SETTING", "SETTINGS_RESPONSE", "HIT_STORAGE_POLICY", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public enum ReportNode {
    GECKO_REGISTER_BY_IREGISTER("gecko_register_by_iRegister"),
    GECKO_REGISTER_CUSTOM_PARAMS("gecko_register_custom_params"),
    CHECK_UPDATE_REQUEST("check_update_request"),
    CHECK_UPDATE_RESPONSE("check_update_response"),
    SYNC_GLOBAL_SETTING("sync_global_setting"),
    SETTINGS_RESPONSE("settings_response"),
    HIT_STORAGE_POLICY("hit_storage_policy");

    private final String tag;

    ReportNode(String str) {
        this.tag = str;
    }

    public final String getTag() {
        return this.tag;
    }
}
