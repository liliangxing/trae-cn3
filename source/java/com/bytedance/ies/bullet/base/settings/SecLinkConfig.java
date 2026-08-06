package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: SecuritySettingConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/SecLinkConfig;", "", "()V", "domainWhiteList", "", "", "getDomainWhiteList", "()Ljava/util/List;", "setDomainWhiteList", "(Ljava/util/List;)V", "enableBuiltinSecLink", "", "getEnableBuiltinSecLink", "()Z", "setEnableBuiltinSecLink", "(Z)V", "enableSecLink", "getEnableSecLink", "setEnableSecLink", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SecLinkConfig {

    @SerializedName("enable_builtin_sec_link")
    private boolean enableBuiltinSecLink;

    @SerializedName("enable_sec_link")
    private boolean enableSecLink = true;

    @SerializedName("domain_white_list")
    private List<String> domainWhiteList = CollectionsKt.emptyList();

    public final boolean getEnableBuiltinSecLink() {
        return this.enableBuiltinSecLink;
    }

    public final void setEnableBuiltinSecLink(boolean z) {
        this.enableBuiltinSecLink = z;
    }

    public final boolean getEnableSecLink() {
        return this.enableSecLink;
    }

    public final void setEnableSecLink(boolean z) {
        this.enableSecLink = z;
    }

    public final List<String> getDomainWhiteList() {
        return this.domainWhiteList;
    }

    public final void setDomainWhiteList(List<String> list) {
        this.domainWhiteList = list;
    }
}
