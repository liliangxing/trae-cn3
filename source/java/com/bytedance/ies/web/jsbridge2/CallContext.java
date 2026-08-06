package com.bytedance.ies.web.jsbridge2;

import android.content.Context;
import android.view.View;

/* loaded from: classes4.dex */
public class CallContext {
    protected String bizKey;
    CallHandler callHandler;
    Context context;
    View hybridView;
    PermissionGroup permissionGroup;
    String url;
    boolean needCheckPermission = true;
    boolean isAnnieXCall = false;
    private CallContextDelegate eventDelegate = null;
    SecurityContext securityContext = new SecurityContext();

    /* loaded from: classes4.dex */
    public enum HostType {
        PRIVATE,
        PROTECTED,
        PUBLIC
    }

    public String getBizKey() {
        String str = this.bizKey;
        return (str == null || str.isEmpty()) ? "host" : this.bizKey;
    }

    public String getUrl() {
        return this.url;
    }

    @Deprecated
    public HostType getHostType() {
        return HostType.PUBLIC;
    }

    public Context getContext() {
        return this.context;
    }

    public View getHybridView() {
        return this.hybridView;
    }

    public <T> void sendJsEvent(String str, T t) {
        CallContextDelegate callContextDelegate = this.eventDelegate;
        if (callContextDelegate != null) {
            callContextDelegate.onSendJsEvent(str, t);
            return;
        }
        CallHandler callHandler = this.callHandler;
        if (callHandler != null) {
            callHandler.onSendJsEvent(str, t);
        }
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setHybridView(View view) {
        this.hybridView = view;
    }

    public void setBizKey(String str) {
        this.bizKey = str;
    }

    public void setPermissionGroup(PermissionGroup permissionGroup) {
        this.permissionGroup = permissionGroup;
    }

    public void setContextDelegate(CallContextDelegate callContextDelegate) {
        this.eventDelegate = callContextDelegate;
    }

    public boolean isAnnieXCall() {
        return this.isAnnieXCall;
    }

    public void setAnnieXCall(boolean z) {
        this.isAnnieXCall = z;
    }

    public SecurityContext getSecurityContext() {
        return this.securityContext;
    }
}
