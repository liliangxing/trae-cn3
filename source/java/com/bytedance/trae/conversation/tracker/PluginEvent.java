package com.bytedance.trae.conversation.tracker;

import kotlin.Metadata;

/* compiled from: PluginTracker.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/PluginEvent;", "", "<init>", "()V", "CONNECTOR_AUTH_START", "", "CONNECTOR_AUTH_RESULT", "CONNECTOR_AUTH_SUCCESS", "CONNECTOR_AUTH_FAIL", "CHAT_PLUGIN_INCLUDE", "CHAT_PLUGIN_INVOKED", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PluginEvent {
    public static final String CHAT_PLUGIN_INCLUDE = "chat_plugin_include";
    public static final String CHAT_PLUGIN_INVOKED = "chat_plugin_invoked";
    public static final String CONNECTOR_AUTH_FAIL = "connector_auth_fail";
    public static final String CONNECTOR_AUTH_RESULT = "connector_auth_result";
    public static final String CONNECTOR_AUTH_START = "connector_auth_start";
    public static final String CONNECTOR_AUTH_SUCCESS = "connector_auth_success";
    public static final PluginEvent INSTANCE = new PluginEvent();

    private PluginEvent() {
    }
}
