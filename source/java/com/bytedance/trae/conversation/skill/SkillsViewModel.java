package com.bytedance.trae.conversation.skill;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.trae.conversation.network.SkillItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import org.json.JSONObject;

/* compiled from: SkillsViewModel.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010+\u001a\u00020,J\u0010\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0011H\u0002J\u0012\u0010/\u001a\u00020\u00112\b\u00100\u001a\u0004\u0018\u00010\rH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001c\u0010!\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001c\u0010$\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\u001c\u0010'\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001aR\u0010\u0010*\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/trae/conversation/skill/SkillsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_skills", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/bytedance/trae/conversation/network/SkillItem;", "skills", "Landroidx/lifecycle/LiveData;", "getSkills", "()Landroidx/lifecycle/LiveData;", "_error", "", "error", "getError", "_isDeviceOffline", "", "kotlin.jvm.PlatformType", "isDeviceOffline", "_isDeviceProjectOffline", "isDeviceProjectOffline", "workspaceFolder", "getWorkspaceFolder", "()Ljava/lang/String;", "setWorkspaceFolder", "(Ljava/lang/String;)V", "cliId", "getCliId", "setCliId", "projectId", "getProjectId", "setProjectId", "conversationId", "getConversationId", "setConversationId", "configName", "getConfigName", "setConfigName", "agentType", "getAgentType", "setAgentType", "nextPageToken", "loadSkills", "", "fetchSkills", "isLoadMore", "isDeviceOfflineError", "errorBody", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SkillsViewModel extends ViewModel {
    private static final int DEVICE_OFFLINE_CODE = 2900101;
    private static final int PAGE_SIZE = 20;
    private final MutableLiveData<String> _error;
    private final MutableLiveData<Boolean> _isDeviceOffline;
    private final MutableLiveData<Boolean> _isDeviceProjectOffline;
    private final MutableLiveData<List<SkillItem>> _skills;
    private String agentType;
    private String cliId;
    private String configName;
    private String conversationId;
    private final LiveData<String> error;
    private final LiveData<Boolean> isDeviceOffline;
    private final LiveData<Boolean> isDeviceProjectOffline;
    private String nextPageToken;
    private String projectId;
    private final LiveData<List<SkillItem>> skills;
    private String workspaceFolder;

    public SkillsViewModel() {
        LiveData<List<SkillItem>> mutableLiveData = new MutableLiveData<>();
        this._skills = mutableLiveData;
        this.skills = mutableLiveData;
        LiveData<String> mutableLiveData2 = new MutableLiveData<>((Object) null);
        this._error = mutableLiveData2;
        this.error = mutableLiveData2;
        LiveData<Boolean> mutableLiveData3 = new MutableLiveData<>(false);
        this._isDeviceOffline = mutableLiveData3;
        this.isDeviceOffline = mutableLiveData3;
        LiveData<Boolean> mutableLiveData4 = new MutableLiveData<>(false);
        this._isDeviceProjectOffline = mutableLiveData4;
        this.isDeviceProjectOffline = mutableLiveData4;
    }

    public final LiveData<List<SkillItem>> getSkills() {
        return this.skills;
    }

    public final LiveData<String> getError() {
        return this.error;
    }

    public final LiveData<Boolean> isDeviceOffline() {
        return this.isDeviceOffline;
    }

    public final LiveData<Boolean> isDeviceProjectOffline() {
        return this.isDeviceProjectOffline;
    }

    public final String getWorkspaceFolder() {
        return this.workspaceFolder;
    }

    public final void setWorkspaceFolder(String str) {
        this.workspaceFolder = str;
    }

    public final String getCliId() {
        return this.cliId;
    }

    public final void setCliId(String str) {
        this.cliId = str;
    }

    public final String getProjectId() {
        return this.projectId;
    }

    public final void setProjectId(String str) {
        this.projectId = str;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final void setConversationId(String str) {
        this.conversationId = str;
    }

    public final String getConfigName() {
        return this.configName;
    }

    public final void setConfigName(String str) {
        this.configName = str;
    }

    public final String getAgentType() {
        return this.agentType;
    }

    public final void setAgentType(String str) {
        this.agentType = str;
    }

    public final void loadSkills() {
        this.nextPageToken = null;
        fetchSkills(false);
    }

    private final void fetchSkills(boolean isLoadMore) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SkillsViewModel$fetchSkills$1(this, isLoadMore, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isDeviceOfflineError(String errorBody) {
        String str = errorBody;
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            return new JSONObject(errorBody).optInt("code", 0) == DEVICE_OFFLINE_CODE;
        } catch (Exception unused) {
            return false;
        }
    }
}
