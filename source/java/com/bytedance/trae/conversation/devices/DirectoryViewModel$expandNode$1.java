package com.bytedance.trae.conversation.devices;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.conversation.devices.DirectoryEvent;
import com.bytedance.trae.conversation.network.FolderNode;
import com.bytedance.trae.conversation.network.IGetProjectApi;
import com.bytedance.trae.conversation.network.ListFolderData;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DirectoryViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.devices.DirectoryViewModel$expandNode$1", f = "DirectoryViewModel.kt", i = {}, l = {335, 368, 381}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DirectoryViewModel$expandNode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    final /* synthetic */ DirectoryNode $node;
    int label;
    final /* synthetic */ DirectoryViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectoryViewModel$expandNode$1(String str, DirectoryNode directoryNode, DirectoryViewModel directoryViewModel, Continuation<? super DirectoryViewModel$expandNode$1> continuation) {
        super(2, continuation);
        this.$id = str;
        this.$node = directoryNode;
        this.this$0 = directoryViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DirectoryViewModel$expandNode$1(this.$id, this.$node, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object listFolderRawCall;
        MutableStateFlow mutableStateFlow;
        MutableSharedFlow mutableSharedFlow;
        String errorMessage;
        DirectoryNode copy;
        MutableStateFlow mutableStateFlow2;
        MutableStateFlow mutableStateFlow3;
        MutableStateFlow mutableStateFlow4;
        MutableSharedFlow mutableSharedFlow2;
        String errorMessage2;
        DirectoryNode copy2;
        MutableStateFlow mutableStateFlow5;
        MutableStateFlow mutableStateFlow6;
        MutableStateFlow mutableStateFlow7;
        DirectoryNode copy3;
        Map map;
        MutableStateFlow mutableStateFlow8;
        MutableStateFlow mutableStateFlow9;
        List<FolderNode> children;
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        int i2 = 0;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Map<String, String> mapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("cli_id", this.$id), TuplesKt.to("path", this.$node.getPath()), TuplesKt.to("depth", OnekeyLoginConstants.TELECOM_TYPE)});
            this.label = 1;
            listFolderRawCall = IGetProjectApi.INSTANCE.listFolderRawCall(mapOf, (Continuation) this);
            if (listFolderRawCall == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2 && i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            listFolderRawCall = obj;
        }
        HttpDataResult.Success success = (HttpDataResult) listFolderRawCall;
        if (success instanceof HttpDataResult.Success) {
            BizResponse bizResp = success.getBizResp();
            if (!bizResp.isSuccess()) {
                mutableStateFlow4 = this.this$0._uiState;
                List mutableList = CollectionsKt.toMutableList(((DirectoryUiState) mutableStateFlow4.getValue()).getNodes());
                DirectoryNode directoryNode = this.$node;
                Iterator it = mutableList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    if (Intrinsics.areEqual(((DirectoryNode) it.next()).getId(), directoryNode.getId())) {
                        break;
                    }
                    i2++;
                }
                if (i2 != -1) {
                    copy2 = r11.copy((r24 & 1) != 0 ? r11.id : null, (r24 & 2) != 0 ? r11.name : null, (r24 & 4) != 0 ? r11.path : null, (r24 & 8) != 0 ? r11.depth : 0, (r24 & 16) != 0 ? r11.parentId : null, (r24 & 32) != 0 ? r11.hasChildren : false, (r24 & 64) != 0 ? r11.isExpanded : false, (r24 & 128) != 0 ? r11.isLoading : false, (r24 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r11.childrenLoaded : false, (r24 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r11.isEditing : false, (r24 & 1024) != 0 ? this.$node.isSelected : false);
                    mutableList.set(i2, copy2);
                    mutableStateFlow5 = this.this$0._uiState;
                    mutableStateFlow6 = this.this$0._uiState;
                    mutableStateFlow5.setValue(DirectoryUiState.copy$default((DirectoryUiState) mutableStateFlow6.getValue(), mutableList, null, false, null, 0, null, 62, null));
                }
                mutableSharedFlow2 = this.this$0._events;
                errorMessage2 = this.this$0.errorMessage(bizResp.getCode(), bizResp.getMsg(), R.string.trae_dir_expand_failed);
                this.label = 2;
                if (mutableSharedFlow2.emit(new DirectoryEvent.ShowToast(errorMessage2), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                ListFolderData listFolderData = (ListFolderData) bizResp.getData();
                ArrayList arrayList = null;
                FolderNode folder = listFolderData != null ? listFolderData.getFolder() : null;
                if (folder != null && (children = folder.getChildren()) != null) {
                    List<FolderNode> list = children;
                    DirectoryNode directoryNode2 = this.$node;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (FolderNode folderNode : list) {
                        String path = folderNode.getPath();
                        String name = folderNode.getName();
                        String path2 = folderNode.getPath();
                        int depth = directoryNode2.getDepth() + 1;
                        String id = directoryNode2.getId();
                        if (!folderNode.getHasChildren()) {
                            List<FolderNode> children2 = folderNode.getChildren();
                            if (children2 == null || children2.isEmpty()) {
                                z = false;
                                arrayList2.add(new DirectoryNode(path, name, path2, depth, id, z, false, false, false, false, false, 1984, null));
                            }
                        }
                        z = true;
                        arrayList2.add(new DirectoryNode(path, name, path2, depth, id, z, false, false, false, false, false, 1984, null));
                    }
                    arrayList = arrayList2;
                }
                if (arrayList == null) {
                    arrayList = CollectionsKt.emptyList();
                }
                mutableStateFlow7 = this.this$0._uiState;
                List mutableList2 = CollectionsKt.toMutableList(((DirectoryUiState) mutableStateFlow7.getValue()).getNodes());
                DirectoryNode directoryNode3 = this.$node;
                Iterator it2 = mutableList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    if (Intrinsics.areEqual(((DirectoryNode) it2.next()).getId(), directoryNode3.getId())) {
                        break;
                    }
                    i2++;
                }
                if (i2 == -1) {
                    return Unit.INSTANCE;
                }
                copy3 = r11.copy((r24 & 1) != 0 ? r11.id : null, (r24 & 2) != 0 ? r11.name : null, (r24 & 4) != 0 ? r11.path : null, (r24 & 8) != 0 ? r11.depth : 0, (r24 & 16) != 0 ? r11.parentId : null, (r24 & 32) != 0 ? r11.hasChildren : false, (r24 & 64) != 0 ? r11.isExpanded : true, (r24 & 128) != 0 ? r11.isLoading : false, (r24 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r11.childrenLoaded : true, (r24 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r11.isEditing : false, (r24 & 1024) != 0 ? this.$node.isSelected : false);
                mutableList2.set(i2, copy3);
                mutableList2.addAll(i2 + 1, arrayList);
                map = this.this$0.childrenCache;
                map.put(this.$node.getId(), arrayList);
                mutableStateFlow8 = this.this$0._uiState;
                mutableStateFlow9 = this.this$0._uiState;
                mutableStateFlow8.setValue(DirectoryUiState.copy$default((DirectoryUiState) mutableStateFlow9.getValue(), mutableList2, null, false, null, 0, null, 62, null));
            }
        } else if (success instanceof HttpDataResult.Error) {
            mutableStateFlow = this.this$0._uiState;
            List mutableList3 = CollectionsKt.toMutableList(((DirectoryUiState) mutableStateFlow.getValue()).getNodes());
            DirectoryNode directoryNode4 = this.$node;
            Iterator it3 = mutableList3.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    i2 = -1;
                    break;
                }
                if (Intrinsics.areEqual(((DirectoryNode) it3.next()).getId(), directoryNode4.getId())) {
                    break;
                }
                i2++;
            }
            if (i2 != -1) {
                copy = r11.copy((r24 & 1) != 0 ? r11.id : null, (r24 & 2) != 0 ? r11.name : null, (r24 & 4) != 0 ? r11.path : null, (r24 & 8) != 0 ? r11.depth : 0, (r24 & 16) != 0 ? r11.parentId : null, (r24 & 32) != 0 ? r11.hasChildren : false, (r24 & 64) != 0 ? r11.isExpanded : false, (r24 & 128) != 0 ? r11.isLoading : false, (r24 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r11.childrenLoaded : false, (r24 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r11.isEditing : false, (r24 & 1024) != 0 ? this.$node.isSelected : false);
                mutableList3.set(i2, copy);
                mutableStateFlow2 = this.this$0._uiState;
                mutableStateFlow3 = this.this$0._uiState;
                mutableStateFlow2.setValue(DirectoryUiState.copy$default((DirectoryUiState) mutableStateFlow3.getValue(), mutableList3, null, false, null, 0, null, 62, null));
            }
            mutableSharedFlow = this.this$0._events;
            HttpDataResult.Error error = (HttpDataResult.Error) success;
            errorMessage = this.this$0.errorMessage(error.getCode(), error.getMsg(), R.string.trae_dir_expand_failed);
            this.label = 3;
            if (mutableSharedFlow.emit(new DirectoryEvent.ShowToast(errorMessage), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }
}
