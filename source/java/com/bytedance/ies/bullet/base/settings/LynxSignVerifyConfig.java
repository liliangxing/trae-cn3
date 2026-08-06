package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: SecuritySettingConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/LynxSignVerifyConfig;", "", "()V", "forceDegradeCodeList", "", "", "getForceDegradeCodeList", "()Ljava/util/List;", "setForceDegradeCodeList", "(Ljava/util/List;)V", "whiteList", "", "", "getWhiteList", "()[Ljava/lang/String;", "setWhiteList", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxSignVerifyConfig {

    @SerializedName("degrade_verify_code_list")
    private List<Integer> forceDegradeCodeList = CollectionsKt.emptyList();

    @SerializedName("white_list")
    private String[] whiteList;

    public final String[] getWhiteList() {
        return this.whiteList;
    }

    public final void setWhiteList(String[] strArr) {
        this.whiteList = strArr;
    }

    public final List<Integer> getForceDegradeCodeList() {
        return this.forceDegradeCodeList;
    }

    public final void setForceDegradeCodeList(List<Integer> list) {
        this.forceDegradeCodeList = list;
    }
}
