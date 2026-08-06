package com.bytedance.trae.conversation.devices;

import com.bytedance.trae.conversation.devices.DirectoryEvent;
import com.bytedance.trae.conversation.network.FolderNode;
import com.bytedance.trae.conversation.network.IGetProjectApi;
import com.bytedance.trae.conversation.network.ListFolderData;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import java.util.ArrayList;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DirectoryViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.devices.DirectoryViewModel$listFolder$1", f = "DirectoryViewModel.kt", i = {}, l = {187, 217, 225}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DirectoryViewModel$listFolder$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $depth;
    final /* synthetic */ String $id;
    final /* synthetic */ String $path;
    final /* synthetic */ boolean $skipRoot;
    int label;
    final /* synthetic */ DirectoryViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectoryViewModel$listFolder$1(DirectoryViewModel directoryViewModel, String str, String str2, int i, boolean z, Continuation<? super DirectoryViewModel$listFolder$1> continuation) {
        super(2, continuation);
        this.this$0 = directoryViewModel;
        this.$id = str;
        this.$path = str2;
        this.$depth = i;
        this.$skipRoot = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DirectoryViewModel$listFolder$1(this.this$0, this.$id, this.$path, this.$depth, this.$skipRoot, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        Object listFolderRawCall;
        MutableStateFlow mutableStateFlow3;
        MutableStateFlow mutableStateFlow4;
        MutableSharedFlow mutableSharedFlow;
        String errorMessage;
        MutableStateFlow mutableStateFlow5;
        MutableStateFlow mutableStateFlow6;
        MutableSharedFlow mutableSharedFlow2;
        String errorMessage2;
        MutableStateFlow mutableStateFlow7;
        ArrayList flattenFolderNodeShallow;
        MutableStateFlow mutableStateFlow8;
        MutableStateFlow mutableStateFlow9;
        List applyPreselection;
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0._uiState;
            mutableStateFlow2 = this.this$0._uiState;
            mutableStateFlow.setValue(DirectoryUiState.copy$default((DirectoryUiState) mutableStateFlow2.getValue(), null, null, true, null, 0, null, 59, null));
            Map<String, String> mapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("cli_id", this.$id), TuplesKt.to("path", this.$path), TuplesKt.to("depth", String.valueOf(this.$depth))});
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
                mutableStateFlow5 = this.this$0._uiState;
                mutableStateFlow6 = this.this$0._uiState;
                mutableStateFlow5.setValue(DirectoryUiState.copy$default((DirectoryUiState) mutableStateFlow6.getValue(), null, null, false, null, 0, null, 59, null));
                mutableSharedFlow2 = this.this$0._events;
                errorMessage2 = this.this$0.errorMessage(bizResp.getCode(), bizResp.getMsg(), R.string.trae_dir_fetch_list_failed);
                this.label = 2;
                if (mutableSharedFlow2.emit(new DirectoryEvent.ShowToast(errorMessage2), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                ListFolderData listFolderData = (ListFolderData) bizResp.getData();
                FolderNode folder = listFolderData != null ? listFolderData.getFolder() : null;
                mutableStateFlow7 = this.this$0._folderTree;
                mutableStateFlow7.setValue(folder);
                if (!this.$skipRoot || folder == null) {
                    flattenFolderNodeShallow = this.this$0.flattenFolderNodeShallow(folder);
                } else {
                    List<FolderNode> children = folder.getChildren();
                    if (children != null) {
                        List<FolderNode> list = children;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                        for (FolderNode folderNode : list) {
                            String path = folderNode.getPath();
                            String name = folderNode.getName();
                            String path2 = folderNode.getPath();
                            if (!folderNode.getHasChildren()) {
                                List<FolderNode> children2 = folderNode.getChildren();
                                if (children2 == null || children2.isEmpty()) {
                                    z = false;
                                    arrayList.add(new DirectoryNode(path, name, path2, 0, null, z, false, false, false, false, false, 1680, null));
                                }
                            }
                            z = true;
                            arrayList.add(new DirectoryNode(path, name, path2, 0, null, z, false, false, false, false, false, 1680, null));
                        }
                        flattenFolderNodeShallow = arrayList;
                    } else {
                        flattenFolderNodeShallow = null;
                    }
                    if (flattenFolderNodeShallow == null) {
                        flattenFolderNodeShallow = CollectionsKt.emptyList();
                    }
                }
                mutableStateFlow8 = this.this$0._uiState;
                mutableStateFlow9 = this.this$0._uiState;
                DirectoryUiState directoryUiState = (DirectoryUiState) mutableStateFlow9.getValue();
                applyPreselection = this.this$0.applyPreselection(flattenFolderNodeShallow);
                mutableStateFlow8.setValue(DirectoryUiState.copy$default(directoryUiState, applyPreselection, null, false, folder != null ? folder.getPath() : null, 0, null, 50, null));
            }
        } else if (success instanceof HttpDataResult.Error) {
            mutableStateFlow3 = this.this$0._uiState;
            mutableStateFlow4 = this.this$0._uiState;
            mutableStateFlow3.setValue(DirectoryUiState.copy$default((DirectoryUiState) mutableStateFlow4.getValue(), null, null, false, null, 0, null, 59, null));
            mutableSharedFlow = this.this$0._events;
            HttpDataResult.Error error = (HttpDataResult.Error) success;
            errorMessage = this.this$0.errorMessage(error.getCode(), error.getMsg(), R.string.trae_dir_fetch_list_failed);
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
