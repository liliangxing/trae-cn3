package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: SecuritySettingConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/MonitorConfig;", "", "()V", "enableUploadLynxSignFailedFile", "", "getEnableUploadLynxSignFailedFile", "()Z", "setEnableUploadLynxSignFailedFile", "(Z)V", "uploadLynxVerifyCodeList", "", "", "getUploadLynxVerifyCodeList", "()Ljava/util/List;", "setUploadLynxVerifyCodeList", "(Ljava/util/List;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class MonitorConfig {

    @SerializedName("enable_upload_lynx_sign_failed_file")
    private boolean enableUploadLynxSignFailedFile;

    @SerializedName("upload_lynx_verify_code")
    private List<Integer> uploadLynxVerifyCodeList = CollectionsKt.listOf(new Integer[]{-1, 104});

    public final boolean getEnableUploadLynxSignFailedFile() {
        return this.enableUploadLynxSignFailedFile;
    }

    public final void setEnableUploadLynxSignFailedFile(boolean z) {
        this.enableUploadLynxSignFailedFile = z;
    }

    public final List<Integer> getUploadLynxVerifyCodeList() {
        return this.uploadLynxVerifyCodeList;
    }

    public final void setUploadLynxVerifyCodeList(List<Integer> list) {
        this.uploadLynxVerifyCodeList = list;
    }
}
