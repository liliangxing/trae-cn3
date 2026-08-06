package com.bytedance.trae.conversation.plugin;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.trae.conversation.network.PluginItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: PluginsViewModel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001c\u001a\u00020\u001dR\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_plugins", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/bytedance/trae/conversation/network/PluginItem;", "plugins", "Landroidx/lifecycle/LiveData;", "getPlugins", "()Landroidx/lifecycle/LiveData;", "_isLoading", "", "kotlin.jvm.PlatformType", "isLoading", "_error", "", "error", "getError", "cliId", "getCliId", "()Ljava/lang/String;", "setCliId", "(Ljava/lang/String;)V", "workspaceFolder", "getWorkspaceFolder", "setWorkspaceFolder", "loadPlugins", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PluginsViewModel extends ViewModel {
    private final MutableLiveData<String> _error;
    private final MutableLiveData<Boolean> _isLoading;
    private final MutableLiveData<List<PluginItem>> _plugins;
    private String cliId;
    private final LiveData<String> error;
    private final LiveData<Boolean> isLoading;
    private final LiveData<List<PluginItem>> plugins;
    private String workspaceFolder;

    public PluginsViewModel() {
        LiveData<List<PluginItem>> mutableLiveData = new MutableLiveData<>(CollectionsKt.emptyList());
        this._plugins = mutableLiveData;
        this.plugins = mutableLiveData;
        LiveData<Boolean> mutableLiveData2 = new MutableLiveData<>(false);
        this._isLoading = mutableLiveData2;
        this.isLoading = mutableLiveData2;
        LiveData<String> mutableLiveData3 = new MutableLiveData<>((Object) null);
        this._error = mutableLiveData3;
        this.error = mutableLiveData3;
    }

    public final LiveData<List<PluginItem>> getPlugins() {
        return this.plugins;
    }

    public final LiveData<Boolean> isLoading() {
        return this.isLoading;
    }

    public final LiveData<String> getError() {
        return this.error;
    }

    public final String getCliId() {
        return this.cliId;
    }

    public final void setCliId(String str) {
        this.cliId = str;
    }

    public final String getWorkspaceFolder() {
        return this.workspaceFolder;
    }

    public final void setWorkspaceFolder(String str) {
        this.workspaceFolder = str;
    }

    public final void loadPlugins() {
        List<PluginItem> cachedPlugins = PluginListCache.INSTANCE.getCachedPlugins(this.cliId, this.workspaceFolder);
        if (cachedPlugins != null) {
            this._plugins.setValue(cachedPlugins);
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PluginsViewModel$loadPlugins$1(this, cachedPlugins, null), 3, (Object) null);
    }
}
