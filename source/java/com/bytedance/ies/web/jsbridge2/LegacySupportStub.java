package com.bytedance.ies.web.jsbridge2;

/* loaded from: classes4.dex */
final class LegacySupportStub {
    private Callback callback;
    private boolean isValid;
    private String methodName;
    private PermissionGroup permissionGroup;

    /* loaded from: classes4.dex */
    interface Callback {
        void onResponse(String str);
    }

    LegacySupportStub(String str, Callback callback) {
        this(str, null, callback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LegacySupportStub(String str, PermissionGroup permissionGroup, Callback callback) {
        this.isValid = true;
        this.methodName = str;
        this.permissionGroup = permissionGroup;
        this.callback = callback;
    }

    public PermissionGroup getPermissionGroup() {
        return this.permissionGroup;
    }

    public void setPermissionGroup(PermissionGroup permissionGroup) {
        this.permissionGroup = permissionGroup;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onResponse(String str) {
        checkInvalid();
        DebugUtil.i("Jsb async call about to finish with response: " + this.methodName + ", stub: " + hashCode());
        this.callback.onResponse(str);
        this.isValid = false;
    }

    private void checkInvalid() {
        if (this.isValid) {
            return;
        }
        DebugUtil.throwRuntimeException(new IllegalStateException("Jsb async call already finished: " + this.methodName + ", stub: " + hashCode()));
    }
}
