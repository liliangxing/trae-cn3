package com.bytedance.trae.conversation.devices;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.conversation.network.FolderNode;
import com.bytedance.trae.multilanguage.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: DirectoryViewModel.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 g2\u00020\u0001:\u0002ghB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\"\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\tH\u0002J \u0010\n\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u0006\u0010A\u001a\u00020BJ\"\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020\u00072\b\b\u0002\u0010E\u001a\u00020\t2\b\b\u0002\u0010F\u001a\u00020GJ\"\u0010H\u001a\u00020B2\u0006\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\t2\b\b\u0002\u0010F\u001a\u00020GH\u0002J\"\u0010I\u001a\b\u0012\u0004\u0012\u00020@042\b\u0010J\u001a\u0004\u0018\u00010;2\b\b\u0002\u0010K\u001a\u00020\tH\u0002J\u0018\u0010L\u001a\b\u0012\u0004\u0012\u00020@042\b\u0010J\u001a\u0004\u0018\u00010;H\u0002J\u000e\u0010M\u001a\u00020B2\u0006\u0010J\u001a\u00020@J\u0010\u0010N\u001a\u00020B2\u0006\u0010J\u001a\u00020@H\u0002J\u0010\u0010O\u001a\u00020B2\u0006\u0010J\u001a\u00020@H\u0002J&\u0010P\u001a\u00020\t2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020@042\u0006\u0010R\u001a\u00020\t2\u0006\u0010S\u001a\u00020\tH\u0002J\u000e\u0010T\u001a\u00020B2\u0006\u0010J\u001a\u00020@J\u0006\u0010U\u001a\u00020BJ\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020@042\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020@04H\u0002J\u0006\u0010W\u001a\u00020BJ\u0016\u0010X\u001a\u00020B2\u0006\u0010Y\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\u0007J\u000e\u0010[\u001a\u00020B2\u0006\u0010Y\u001a\u00020\u0007J,\u0010\\\u001a\u00020B2\u0006\u0010Y\u001a\u00020\u00072\u0006\u0010]\u001a\u00020G2\u0006\u0010^\u001a\u00020G2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u0007H\u0002J&\u0010`\u001a\u00020B2\u0006\u0010D\u001a\u00020\u00072\u0016\b\u0002\u0010a\u001a\u0010\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020B\u0018\u00010bJ(\u0010c\u001a\u00020B2\u0006\u0010D\u001a\u00020\u00072\u0006\u0010d\u001a\u00020\u00072\u0010\b\u0002\u0010e\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010fR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020'0)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020.00¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001a\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0007040&X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0007040)¢\u0006\b\n\u0000\u001a\u0004\b6\u0010+R\u0016\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070)¢\u0006\b\n\u0000\u001a\u0004\b9\u0010+R\u0016\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010;0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010;0)¢\u0006\b\n\u0000\u001a\u0004\b=\u0010+R \u0010>\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020@040?X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006i"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "getString", "", "resId", "", "errorMessage", "bizCode", "", "bizMsg", "defaultResId", "resultCode", OnekeyLoginConstants.CU_KEY_RESULT_MSG, "mode", "Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;", "getMode", "()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;", "setMode", "(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;)V", "chatMode", "Lcom/bytedance/trae/im/service/Mode;", "getChatMode", "()Lcom/bytedance/trae/im/service/Mode;", "setChatMode", "(Lcom/bytedance/trae/im/service/Mode;)V", "cliId", "getCliId", "()Ljava/lang/String;", "setCliId", "(Ljava/lang/String;)V", "preselectedPath", "getPreselectedPath", "setPreselectedPath", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bytedance/trae/conversation/devices/DirectoryUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "_events", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/bytedance/trae/conversation/devices/DirectoryEvent;", "events", "Lkotlinx/coroutines/flow/SharedFlow;", "getEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "_userFolders", "", "userFolders", "getUserFolders", "_defaultFolder", "defaultFolder", "getDefaultFolder", "_folderTree", "Lcom/bytedance/trae/conversation/network/FolderNode;", "folderTree", "getFolderTree", "childrenCache", "", "Lcom/bytedance/trae/conversation/devices/DirectoryNode;", "loadInitialData", "", "loadDocumentFolder", "path", "depth", "skipRoot", "", "listFolder", "flattenFolderNode", "node", "level", "flattenFolderNodeShallow", "onNodeClicked", "expandNode", "collapseNode", "countDescendants", "nodes", "parentIndex", "parentDepth", "onNodeSelected", "clearSelection", "applyPreselection", "onAddNewFolderClicked", "onNewFolderNameConfirmed", "placeholderId", "finalName", "cancelNewFolder", "updatePlaceholderState", "isEditing", "isLoading", "name", "checkNeedAuthorization", "onResult", "Lkotlin/Function1;", "submitAuthorizationResult", "action", "onSuccess", "Lkotlin/Function0;", "Companion", "Mode", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DirectoryViewModel extends AndroidViewModel {
    private static final long CODE_LITE_DEVICE_OFFLINE = 2900101;
    private final MutableStateFlow<String> _defaultFolder;
    private final MutableSharedFlow<DirectoryEvent> _events;
    private final MutableStateFlow<FolderNode> _folderTree;
    private final MutableStateFlow<DirectoryUiState> _uiState;
    private final MutableStateFlow<List<String>> _userFolders;
    private com.bytedance.trae.im.service.Mode chatMode;
    private final Map<String, List<DirectoryNode>> childrenCache;
    private String cliId;
    private final StateFlow<String> defaultFolder;
    private final SharedFlow<DirectoryEvent> events;
    private final StateFlow<FolderNode> folderTree;
    private Mode mode;
    private String preselectedPath;
    private final StateFlow<DirectoryUiState> uiState;
    private final StateFlow<List<String>> userFolders;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectoryViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.mode = Mode.RECENT;
        this.chatMode = com.bytedance.trae.im.service.Mode.CODE;
        MutableStateFlow<DirectoryUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(new DirectoryUiState(null, null, false, null, 0, null, 63, null));
        this._uiState = MutableStateFlow;
        this.uiState = FlowKt.asStateFlow(MutableStateFlow);
        MutableSharedFlow<DirectoryEvent> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._events = MutableSharedFlow$default;
        this.events = FlowKt.asSharedFlow(MutableSharedFlow$default);
        MutableStateFlow<List<String>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._userFolders = MutableStateFlow2;
        this.userFolders = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<String> MutableStateFlow3 = StateFlowKt.MutableStateFlow((Object) null);
        this._defaultFolder = MutableStateFlow3;
        this.defaultFolder = FlowKt.asStateFlow(MutableStateFlow3);
        MutableStateFlow<FolderNode> MutableStateFlow4 = StateFlowKt.MutableStateFlow((Object) null);
        this._folderTree = MutableStateFlow4;
        this.folderTree = FlowKt.asStateFlow(MutableStateFlow4);
        this.childrenCache = new LinkedHashMap();
    }

    private final String getString(int resId) {
        String string = getApplication().getString(resId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String errorMessage(long bizCode, String bizMsg, int defaultResId) {
        if (bizCode == 2900101) {
            return getString(R.string.trae_conversation_device_offline);
        }
        return bizMsg == null ? getString(defaultResId) : bizMsg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String errorMessage(int resultCode, String resultMsg, int defaultResId) {
        if (resultCode == 2900101) {
            return getString(R.string.trae_conversation_device_offline);
        }
        String str = resultMsg;
        if (str.length() == 0) {
            str = getString(defaultResId);
        }
        return str;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: DirectoryViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "RECENT", "DOCUMENT", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Mode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final Mode RECENT = new Mode("RECENT", 0);
        public static final Mode DOCUMENT = new Mode("DOCUMENT", 1);

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{RECENT, DOCUMENT};
        }

        public static EnumEntries<Mode> getEntries() {
            return $ENTRIES;
        }

        private Mode(String str, int i) {
        }

        static {
            Mode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }

    public final Mode getMode() {
        return this.mode;
    }

    public final void setMode(Mode mode) {
        Intrinsics.checkNotNullParameter(mode, "<set-?>");
        this.mode = mode;
    }

    public final com.bytedance.trae.im.service.Mode getChatMode() {
        return this.chatMode;
    }

    public final void setChatMode(com.bytedance.trae.im.service.Mode mode) {
        Intrinsics.checkNotNullParameter(mode, "<set-?>");
        this.chatMode = mode;
    }

    public final String getCliId() {
        return this.cliId;
    }

    public final void setCliId(String str) {
        this.cliId = str;
    }

    public final String getPreselectedPath() {
        return this.preselectedPath;
    }

    public final void setPreselectedPath(String str) {
        this.preselectedPath = str;
    }

    public final StateFlow<DirectoryUiState> getUiState() {
        return this.uiState;
    }

    public final SharedFlow<DirectoryEvent> getEvents() {
        return this.events;
    }

    public final StateFlow<List<String>> getUserFolders() {
        return this.userFolders;
    }

    public final StateFlow<String> getDefaultFolder() {
        return this.defaultFolder;
    }

    public final StateFlow<FolderNode> getFolderTree() {
        return this.folderTree;
    }

    public final void loadInitialData() {
        String str = this.cliId;
        if (str == null) {
            return;
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new DirectoryViewModel$loadInitialData$1(this, str, null), 3, (Object) null);
    }

    public static /* synthetic */ void loadDocumentFolder$default(DirectoryViewModel directoryViewModel, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 3;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        directoryViewModel.loadDocumentFolder(str, i, z);
    }

    public final void loadDocumentFolder(String path, int depth, boolean skipRoot) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.mode = Mode.DOCUMENT;
        MutableStateFlow<DirectoryUiState> mutableStateFlow = this._uiState;
        mutableStateFlow.setValue(DirectoryUiState.copy$default((DirectoryUiState) mutableStateFlow.getValue(), null, null, false, null, 0, Mode.DOCUMENT, 31, null));
        listFolder(path, depth, skipRoot);
    }

    static /* synthetic */ void listFolder$default(DirectoryViewModel directoryViewModel, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        directoryViewModel.listFolder(str, i, z);
    }

    private final void listFolder(String path, int depth, boolean skipRoot) {
        String str = this.cliId;
        if (str == null) {
            return;
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new DirectoryViewModel$listFolder$1(this, str, path, depth, skipRoot, null), 3, (Object) null);
    }

    static /* synthetic */ List flattenFolderNode$default(DirectoryViewModel directoryViewModel, FolderNode folderNode, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return directoryViewModel.flattenFolderNode(folderNode, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<DirectoryNode> flattenFolderNode(FolderNode node, int level) {
        boolean z;
        boolean z2;
        List<FolderNode> children;
        if (node == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        boolean z3 = node.getChildren() != null;
        if (!node.getHasChildren()) {
            List<FolderNode> children2 = node.getChildren();
            if (children2 == null || children2.isEmpty()) {
                z = false;
                if (z) {
                    List<FolderNode> children3 = node.getChildren();
                    if (!(children3 == null || children3.isEmpty())) {
                        z2 = true;
                        arrayList.add(new DirectoryNode(node.getPath(), node.getName(), node.getPath(), level, null, z, z2, false, !z3 && z, false, false, 1680, null));
                        children = node.getChildren();
                        if (children != null) {
                            Iterator<T> it = children.iterator();
                            while (it.hasNext()) {
                                arrayList.addAll(flattenFolderNode((FolderNode) it.next(), level + 1));
                            }
                        }
                        return arrayList;
                    }
                }
                z2 = false;
                arrayList.add(new DirectoryNode(node.getPath(), node.getName(), node.getPath(), level, null, z, z2, false, !z3 && z, false, false, 1680, null));
                children = node.getChildren();
                if (children != null) {
                }
                return arrayList;
            }
        }
        z = true;
        if (z) {
        }
        z2 = false;
        arrayList.add(new DirectoryNode(node.getPath(), node.getName(), node.getPath(), level, null, z, z2, false, !z3 && z, false, false, 1680, null));
        children = node.getChildren();
        if (children != null) {
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<DirectoryNode> flattenFolderNodeShallow(FolderNode node) {
        boolean z;
        boolean z2;
        List<FolderNode> children;
        boolean z3;
        if (node == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        if (!node.getHasChildren()) {
            List<FolderNode> children2 = node.getChildren();
            if (children2 == null || children2.isEmpty()) {
                z = false;
                if (z) {
                    List<FolderNode> children3 = node.getChildren();
                    if (!(children3 == null || children3.isEmpty())) {
                        z2 = true;
                        arrayList.add(new DirectoryNode(node.getPath(), node.getName(), node.getPath(), 0, null, z, z2, false, z2, false, false, 1680, null));
                        children = node.getChildren();
                        if (children != null) {
                            for (FolderNode folderNode : children) {
                                if (!folderNode.getHasChildren()) {
                                    List<FolderNode> children4 = folderNode.getChildren();
                                    if (children4 == null || children4.isEmpty()) {
                                        z3 = false;
                                        arrayList.add(new DirectoryNode(folderNode.getPath(), folderNode.getName(), folderNode.getPath(), 1, node.getPath(), z3, false, false, false, false, false, 1664, null));
                                    }
                                }
                                z3 = true;
                                arrayList.add(new DirectoryNode(folderNode.getPath(), folderNode.getName(), folderNode.getPath(), 1, node.getPath(), z3, false, false, false, false, false, 1664, null));
                            }
                        }
                        return arrayList;
                    }
                }
                z2 = false;
                arrayList.add(new DirectoryNode(node.getPath(), node.getName(), node.getPath(), 0, null, z, z2, false, z2, false, false, 1680, null));
                children = node.getChildren();
                if (children != null) {
                }
                return arrayList;
            }
        }
        z = true;
        if (z) {
        }
        z2 = false;
        arrayList.add(new DirectoryNode(node.getPath(), node.getName(), node.getPath(), 0, null, z, z2, false, z2, false, false, 1680, null));
        children = node.getChildren();
        if (children != null) {
        }
        return arrayList;
    }

    public final void onNodeClicked(DirectoryNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (!node.isEditing() && node.getHasChildren()) {
            if (node.isExpanded()) {
                collapseNode(node);
            } else {
                expandNode(node);
            }
        }
    }

    private final void expandNode(DirectoryNode node) {
        DirectoryNode copy;
        DirectoryNode copy2;
        List mutableList = CollectionsKt.toMutableList(((DirectoryUiState) this._uiState.getValue()).getNodes());
        Iterator it = mutableList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(((DirectoryNode) it.next()).getId(), node.getId())) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        List<DirectoryNode> list = this.childrenCache.get(node.getId());
        if (list != null) {
            copy2 = node.copy((r24 & 1) != 0 ? node.id : null, (r24 & 2) != 0 ? node.name : null, (r24 & 4) != 0 ? node.path : null, (r24 & 8) != 0 ? node.depth : 0, (r24 & 16) != 0 ? node.parentId : null, (r24 & 32) != 0 ? node.hasChildren : false, (r24 & 64) != 0 ? node.isExpanded : true, (r24 & 128) != 0 ? node.isLoading : false, (r24 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? node.childrenLoaded : false, (r24 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? node.isEditing : false, (r24 & 1024) != 0 ? node.isSelected : false);
            mutableList.set(i, copy2);
            mutableList.addAll(i + 1, list);
            MutableStateFlow<DirectoryUiState> mutableStateFlow = this._uiState;
            mutableStateFlow.setValue(DirectoryUiState.copy$default((DirectoryUiState) mutableStateFlow.getValue(), mutableList, null, false, null, 0, null, 62, null));
            return;
        }
        if (node.getChildrenLoaded()) {
            return;
        }
        copy = node.copy((r24 & 1) != 0 ? node.id : null, (r24 & 2) != 0 ? node.name : null, (r24 & 4) != 0 ? node.path : null, (r24 & 8) != 0 ? node.depth : 0, (r24 & 16) != 0 ? node.parentId : null, (r24 & 32) != 0 ? node.hasChildren : false, (r24 & 64) != 0 ? node.isExpanded : false, (r24 & 128) != 0 ? node.isLoading : true, (r24 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? node.childrenLoaded : false, (r24 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? node.isEditing : false, (r24 & 1024) != 0 ? node.isSelected : false);
        mutableList.set(i, copy);
        MutableStateFlow<DirectoryUiState> mutableStateFlow2 = this._uiState;
        mutableStateFlow2.setValue(DirectoryUiState.copy$default((DirectoryUiState) mutableStateFlow2.getValue(), mutableList, null, false, null, 0, null, 62, null));
        String str = this.cliId;
        if (str == null) {
            return;
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new DirectoryViewModel$expandNode$1(str, node, this, null), 3, (Object) null);
    }

    private final void collapseNode(DirectoryNode node) {
        DirectoryNode copy;
        DirectoryNode copy2;
        List<DirectoryNode> mutableList = CollectionsKt.toMutableList(((DirectoryUiState) this._uiState.getValue()).getNodes());
        Iterator<DirectoryNode> it = mutableList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getId(), node.getId())) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        int countDescendants = countDescendants(mutableList, i, node.getDepth());
        ArrayList arrayList = new ArrayList();
        int i2 = i + 1;
        int i3 = i2 + countDescendants;
        for (int i4 = i2; i4 < i3; i4++) {
            DirectoryNode directoryNode = mutableList.get(i4);
            if (directoryNode.getDepth() == node.getDepth() + 1) {
                copy2 = directoryNode.copy((r24 & 1) != 0 ? directoryNode.id : null, (r24 & 2) != 0 ? directoryNode.name : null, (r24 & 4) != 0 ? directoryNode.path : null, (r24 & 8) != 0 ? directoryNode.depth : 0, (r24 & 16) != 0 ? directoryNode.parentId : null, (r24 & 32) != 0 ? directoryNode.hasChildren : false, (r24 & 64) != 0 ? directoryNode.isExpanded : false, (r24 & 128) != 0 ? directoryNode.isLoading : false, (r24 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? directoryNode.childrenLoaded : false, (r24 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? directoryNode.isEditing : false, (r24 & 1024) != 0 ? directoryNode.isSelected : false);
                arrayList.add(copy2);
            }
        }
        this.childrenCache.put(node.getId(), arrayList);
        for (int i5 = 0; i5 < countDescendants; i5++) {
            mutableList.remove(i2);
        }
        copy = node.copy((r24 & 1) != 0 ? node.id : null, (r24 & 2) != 0 ? node.name : null, (r24 & 4) != 0 ? node.path : null, (r24 & 8) != 0 ? node.depth : 0, (r24 & 16) != 0 ? node.parentId : null, (r24 & 32) != 0 ? node.hasChildren : false, (r24 & 64) != 0 ? node.isExpanded : false, (r24 & 128) != 0 ? node.isLoading : false, (r24 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? node.childrenLoaded : false, (r24 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? node.isEditing : false, (r24 & 1024) != 0 ? node.isSelected : false);
        mutableList.set(i, copy);
        MutableStateFlow<DirectoryUiState> mutableStateFlow = this._uiState;
        mutableStateFlow.setValue(DirectoryUiState.copy$default((DirectoryUiState) mutableStateFlow.getValue(), mutableList, null, false, null, 0, null, 62, null));
    }

    private final int countDescendants(List<DirectoryNode> nodes, int parentIndex, int parentDepth) {
        int size = nodes.size();
        int i = 0;
        for (int i2 = parentIndex + 1; i2 < size && nodes.get(i2).getDepth() > parentDepth; i2++) {
            i++;
        }
        return i;
    }

    public final void onNodeSelected(DirectoryNode node) {
        DirectoryNode copy;
        Intrinsics.checkNotNullParameter(node, "node");
        if (node.isEditing()) {
            return;
        }
        List<DirectoryNode> nodes = ((DirectoryUiState) this._uiState.getValue()).getNodes();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(nodes, 10));
        for (DirectoryNode directoryNode : nodes) {
            copy = directoryNode.copy((r24 & 1) != 0 ? directoryNode.id : null, (r24 & 2) != 0 ? directoryNode.name : null, (r24 & 4) != 0 ? directoryNode.path : null, (r24 & 8) != 0 ? directoryNode.depth : 0, (r24 & 16) != 0 ? directoryNode.parentId : null, (r24 & 32) != 0 ? directoryNode.hasChildren : false, (r24 & 64) != 0 ? directoryNode.isExpanded : false, (r24 & 128) != 0 ? directoryNode.isLoading : false, (r24 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? directoryNode.childrenLoaded : false, (r24 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? directoryNode.isEditing : false, (r24 & 1024) != 0 ? directoryNode.isSelected : Intrinsics.areEqual(directoryNode.getId(), node.getId()));
            arrayList.add(copy);
        }
        MutableStateFlow<DirectoryUiState> mutableStateFlow = this._uiState;
        mutableStateFlow.setValue(DirectoryUiState.copy$default((DirectoryUiState) mutableStateFlow.getValue(), arrayList, null, false, null, 0, null, 62, null));
    }

    public final void clearSelection() {
        DirectoryNode copy;
        List<DirectoryNode> nodes = ((DirectoryUiState) this._uiState.getValue()).getNodes();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(nodes, 10));
        Iterator<T> it = nodes.iterator();
        while (it.hasNext()) {
            copy = r4.copy((r24 & 1) != 0 ? r4.id : null, (r24 & 2) != 0 ? r4.name : null, (r24 & 4) != 0 ? r4.path : null, (r24 & 8) != 0 ? r4.depth : 0, (r24 & 16) != 0 ? r4.parentId : null, (r24 & 32) != 0 ? r4.hasChildren : false, (r24 & 64) != 0 ? r4.isExpanded : false, (r24 & 128) != 0 ? r4.isLoading : false, (r24 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r4.childrenLoaded : false, (r24 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r4.isEditing : false, (r24 & 1024) != 0 ? ((DirectoryNode) it.next()).isSelected : false);
            arrayList.add(copy);
        }
        MutableStateFlow<DirectoryUiState> mutableStateFlow = this._uiState;
        mutableStateFlow.setValue(DirectoryUiState.copy$default((DirectoryUiState) mutableStateFlow.getValue(), arrayList, null, false, null, 0, null, 62, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<DirectoryNode> applyPreselection(List<DirectoryNode> nodes) {
        DirectoryNode copy;
        String str = this.preselectedPath;
        if (str == null) {
            return nodes;
        }
        List<DirectoryNode> list = nodes;
        boolean z = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (Intrinsics.areEqual(((DirectoryNode) it.next()).getPath(), str)) {
                    z = true;
                    break;
                }
            }
        }
        if (!z) {
            return nodes;
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (DirectoryNode directoryNode : list) {
            copy = directoryNode.copy((r24 & 1) != 0 ? directoryNode.id : null, (r24 & 2) != 0 ? directoryNode.name : null, (r24 & 4) != 0 ? directoryNode.path : null, (r24 & 8) != 0 ? directoryNode.depth : 0, (r24 & 16) != 0 ? directoryNode.parentId : null, (r24 & 32) != 0 ? directoryNode.hasChildren : false, (r24 & 64) != 0 ? directoryNode.isExpanded : false, (r24 & 128) != 0 ? directoryNode.isLoading : false, (r24 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? directoryNode.childrenLoaded : false, (r24 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? directoryNode.isEditing : false, (r24 & 1024) != 0 ? directoryNode.isSelected : Intrinsics.areEqual(directoryNode.getPath(), str));
            arrayList.add(copy);
        }
        return arrayList;
    }

    public final void onAddNewFolderClicked() {
        boolean z;
        Object obj;
        String str;
        int i;
        String parentId;
        int depth;
        List mutableList = CollectionsKt.toMutableList(((DirectoryUiState) this._uiState.getValue()).getNodes());
        List list = mutableList;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((DirectoryNode) it.next()).isEditing()) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            return;
        }
        Iterator it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it2.next();
                if (((DirectoryNode) obj).isSelected()) {
                    break;
                }
            }
        }
        DirectoryNode directoryNode = (DirectoryNode) obj;
        Ref.IntRef intRef = new Ref.IntRef();
        if (directoryNode != null && directoryNode.isExpanded()) {
            parentId = directoryNode.getId();
            depth = directoryNode.getDepth() + 1;
            intRef.element = mutableList.indexOf(directoryNode) + 1;
        } else if (directoryNode != null && directoryNode.getHasChildren() && !directoryNode.isExpanded()) {
            parentId = directoryNode.getId();
            depth = directoryNode.getDepth() + 1;
            intRef.element = mutableList.indexOf(directoryNode) + 1;
        } else if (directoryNode != null) {
            parentId = directoryNode.getParentId();
            if (parentId == null) {
                parentId = ((DirectoryUiState) this._uiState.getValue()).getCurrentParentId();
            }
            depth = directoryNode.getDepth();
            int indexOf = mutableList.indexOf(directoryNode) - 1;
            while (indexOf >= 0 && ((DirectoryNode) mutableList.get(indexOf)).getDepth() >= depth) {
                indexOf--;
            }
            intRef.element = indexOf + 1;
        } else {
            String currentParentId = ((DirectoryUiState) this._uiState.getValue()).getCurrentParentId();
            intRef.element = 0;
            Iterator it3 = list.iterator();
            int i2 = 0;
            while (true) {
                if (!it3.hasNext()) {
                    str = currentParentId;
                    i = 0;
                    break;
                }
                i2++;
                DirectoryNode directoryNode2 = (DirectoryNode) it3.next();
                if (Intrinsics.areEqual(directoryNode2.getId(), currentParentId)) {
                    intRef.element = i2;
                    i = directoryNode2.getDepth() + 1;
                    str = currentParentId;
                    break;
                }
            }
            mutableList.add(intRef.element, DirectoryNode.INSTANCE.newFolderPlaceholder(str, i));
            MutableStateFlow<DirectoryUiState> mutableStateFlow = this._uiState;
            mutableStateFlow.setValue(DirectoryUiState.copy$default((DirectoryUiState) mutableStateFlow.getValue(), mutableList, null, false, str, i, null, 38, null));
            BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new DirectoryViewModel$onAddNewFolderClicked$2(this, intRef, null), 3, (Object) null);
        }
        str = parentId;
        i = depth;
        mutableList.add(intRef.element, DirectoryNode.INSTANCE.newFolderPlaceholder(str, i));
        MutableStateFlow<DirectoryUiState> mutableStateFlow2 = this._uiState;
        mutableStateFlow2.setValue(DirectoryUiState.copy$default((DirectoryUiState) mutableStateFlow2.getValue(), mutableList, null, false, str, i, null, 38, null));
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new DirectoryViewModel$onAddNewFolderClicked$2(this, intRef, null), 3, (Object) null);
    }

    public final void onNewFolderNameConfirmed(String placeholderId, String finalName) {
        Intrinsics.checkNotNullParameter(placeholderId, "placeholderId");
        Intrinsics.checkNotNullParameter(finalName, "finalName");
        String obj = StringsKt.trim(finalName).toString();
        if (obj.length() == 0) {
            cancelNewFolder(placeholderId);
        } else {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new DirectoryViewModel$onNewFolderNameConfirmed$1(this, placeholderId, obj, null), 3, (Object) null);
        }
    }

    public final void cancelNewFolder(final String placeholderId) {
        Intrinsics.checkNotNullParameter(placeholderId, "placeholderId");
        List mutableList = CollectionsKt.toMutableList(((DirectoryUiState) this._uiState.getValue()).getNodes());
        CollectionsKt.removeAll(mutableList, new Function1() { // from class: com.bytedance.trae.conversation.devices.DirectoryViewModel$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean cancelNewFolder$lambda$11;
                cancelNewFolder$lambda$11 = DirectoryViewModel.cancelNewFolder$lambda$11(placeholderId, (DirectoryNode) obj);
                return Boolean.valueOf(cancelNewFolder$lambda$11);
            }
        });
        MutableStateFlow<DirectoryUiState> mutableStateFlow = this._uiState;
        mutableStateFlow.setValue(DirectoryUiState.copy$default((DirectoryUiState) mutableStateFlow.getValue(), mutableList, null, false, null, 0, null, 62, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean cancelNewFolder$lambda$11(String str, DirectoryNode directoryNode) {
        Intrinsics.checkNotNullParameter(directoryNode, "it");
        return Intrinsics.areEqual(directoryNode.getId(), str);
    }

    static /* synthetic */ void updatePlaceholderState$default(DirectoryViewModel directoryViewModel, String str, boolean z, boolean z2, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        directoryViewModel.updatePlaceholderState(str, z, z2, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePlaceholderState(String placeholderId, boolean isEditing, boolean isLoading, String name) {
        DirectoryNode copy;
        List mutableList = CollectionsKt.toMutableList(((DirectoryUiState) this._uiState.getValue()).getNodes());
        Iterator it = mutableList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(((DirectoryNode) it.next()).getId(), placeholderId)) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            DirectoryNode directoryNode = (DirectoryNode) mutableList.get(i);
            copy = directoryNode.copy((r24 & 1) != 0 ? directoryNode.id : null, (r24 & 2) != 0 ? directoryNode.name : name == null ? directoryNode.getName() : name, (r24 & 4) != 0 ? directoryNode.path : null, (r24 & 8) != 0 ? directoryNode.depth : 0, (r24 & 16) != 0 ? directoryNode.parentId : null, (r24 & 32) != 0 ? directoryNode.hasChildren : false, (r24 & 64) != 0 ? directoryNode.isExpanded : false, (r24 & 128) != 0 ? directoryNode.isLoading : isLoading, (r24 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? directoryNode.childrenLoaded : false, (r24 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? directoryNode.isEditing : isEditing, (r24 & 1024) != 0 ? directoryNode.isSelected : false);
            mutableList.set(i, copy);
            MutableStateFlow<DirectoryUiState> mutableStateFlow = this._uiState;
            mutableStateFlow.setValue(DirectoryUiState.copy$default((DirectoryUiState) mutableStateFlow.getValue(), mutableList, null, false, null, 0, null, 62, null));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void checkNeedAuthorization$default(DirectoryViewModel directoryViewModel, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        directoryViewModel.checkNeedAuthorization(str, function1);
    }

    public final void checkNeedAuthorization(String path, Function1<? super Boolean, Unit> onResult) {
        Intrinsics.checkNotNullParameter(path, "path");
        String str = this.cliId;
        if (str == null) {
            return;
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new DirectoryViewModel$checkNeedAuthorization$1(str, path, onResult, this, null), 3, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void submitAuthorizationResult$default(DirectoryViewModel directoryViewModel, String str, String str2, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        directoryViewModel.submitAuthorizationResult(str, str2, function0);
    }

    public final void submitAuthorizationResult(String path, String action, Function0<Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(action, "action");
        String str = this.cliId;
        if (str == null) {
            return;
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new DirectoryViewModel$submitAuthorizationResult$1(str, path, action, this, onSuccess, null), 3, (Object) null);
    }
}
