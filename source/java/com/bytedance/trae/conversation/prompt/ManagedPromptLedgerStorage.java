package com.bytedance.trae.conversation.prompt;

import com.bytedance.android.live.core.setting.v2.tools.SettingV2Monitor;
import kotlin.Metadata;

/* compiled from: ManagedPromptLedger.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/prompt/ManagedPromptLedgerStorage;", "", SettingV2Monitor.REPORT_TYPE_READ, "", "userId", "write", "", "serializedState", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ManagedPromptLedgerStorage {
    String read(String userId);

    void write(String userId, String serializedState);
}
