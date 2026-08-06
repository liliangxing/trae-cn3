package com.bytedance.sdk.account.information.method.update_user_info.data;

/* loaded from: classes5.dex */
public class AuditInfo {
    private UserInfo auditInfo;
    private boolean isAuditing;
    private Long lastUpdateTime;

    public boolean isAuditing() {
        return this.isAuditing;
    }

    public void setAuditing(boolean z) {
        this.isAuditing = z;
    }

    public UserInfo getAuditInfo() {
        return this.auditInfo;
    }

    public void setAuditInfo(UserInfo userInfo) {
        this.auditInfo = userInfo;
    }

    public Long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public void setLastUpdateTime(Long l) {
        this.lastUpdateTime = l;
    }
}
