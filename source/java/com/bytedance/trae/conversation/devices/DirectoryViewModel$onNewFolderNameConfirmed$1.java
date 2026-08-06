package com.bytedance.trae.conversation.devices;

import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.trae.conversation.devices.DirectoryEvent;
import com.bytedance.trae.conversation.network.CreateFolderData;
import com.bytedance.trae.conversation.network.CreateFolderRequest;
import com.bytedance.trae.conversation.network.FolderNode;
import com.bytedance.trae.conversation.network.IGetProjectApi;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "com.bytedance.trae.conversation.devices.DirectoryViewModel$onNewFolderNameConfirmed$1", f = "DirectoryViewModel.kt", i = {0}, l = {558, 597, FConstants.DOWNLOAD_FAIL_CODE, 608}, m = "invokeSuspend", n = {"state"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DirectoryViewModel$onNewFolderNameConfirmed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $placeholderId;
    final /* synthetic */ String $trimmedName;
    Object L$0;
    int label;
    final /* synthetic */ DirectoryViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectoryViewModel$onNewFolderNameConfirmed$1(DirectoryViewModel directoryViewModel, String str, String str2, Continuation<? super DirectoryViewModel$onNewFolderNameConfirmed$1> continuation) {
        super(2, continuation);
        this.this$0 = directoryViewModel;
        this.$placeholderId = str;
        this.$trimmedName = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DirectoryViewModel$onNewFolderNameConfirmed$1(this.this$0, this.$placeholderId, this.$trimmedName, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        DirectoryUiState directoryUiState;
        Object createFolderRawCall;
        MutableSharedFlow mutableSharedFlow;
        String errorMessage;
        MutableSharedFlow mutableSharedFlow2;
        String errorMessage2;
        MutableStateFlow mutableStateFlow2;
        MutableSharedFlow mutableSharedFlow3;
        String str;
        String str2;
        MutableStateFlow mutableStateFlow3;
        MutableStateFlow mutableStateFlow4;
        String path;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        int i2 = 0;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.updatePlaceholderState(this.$placeholderId, false, true, this.$trimmedName);
            String cliId = this.this$0.getCliId();
            if (cliId == null) {
                return Unit.INSTANCE;
            }
            mutableStateFlow = this.this$0._uiState;
            directoryUiState = (DirectoryUiState) mutableStateFlow.getValue();
            String currentParentId = directoryUiState.getCurrentParentId();
            if (currentParentId == null) {
                currentParentId = "";
            }
            CreateFolderRequest createFolderRequest = new CreateFolderRequest(cliId, currentParentId, this.$trimmedName);
            this.L$0 = directoryUiState;
            this.label = 1;
            createFolderRawCall = IGetProjectApi.INSTANCE.createFolderRawCall(createFolderRequest, (Continuation) this);
            if (createFolderRawCall == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2 && i != 3 && i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            DirectoryUiState directoryUiState2 = (DirectoryUiState) this.L$0;
            ResultKt.throwOnFailure(obj);
            directoryUiState = directoryUiState2;
            createFolderRawCall = obj;
        }
        HttpDataResult.Success success = (HttpDataResult) createFolderRawCall;
        if (success instanceof HttpDataResult.Success) {
            BizResponse bizResp = success.getBizResp();
            if (bizResp.isSuccess()) {
                CreateFolderData createFolderData = (CreateFolderData) bizResp.getData();
                FolderNode folder = createFolderData != null ? createFolderData.getFolder() : null;
                mutableStateFlow2 = this.this$0._uiState;
                List mutableList = CollectionsKt.toMutableList(((DirectoryUiState) mutableStateFlow2.getValue()).getNodes());
                String str3 = this.$placeholderId;
                Iterator it = mutableList.iterator();
                int i3 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i3 = -1;
                        break;
                    }
                    if (Intrinsics.areEqual(((DirectoryNode) it.next()).getId(), str3)) {
                        break;
                    }
                    i3++;
                }
                if (i3 != -1) {
                    mutableList.remove(i3);
                    if (folder == null || (str = folder.getPath()) == null) {
                        str = this.$placeholderId;
                    }
                    String str4 = str;
                    if (folder == null || (str2 = folder.getName()) == null) {
                        str2 = this.$trimmedName;
                    }
                    DirectoryNode directoryNode = new DirectoryNode(str4, str2, (folder == null || (path = folder.getPath()) == null) ? "" : path, directoryUiState.getCurrentDepth(), directoryUiState.getCurrentParentId(), false, false, false, false, false, false, 1344, null);
                    String currentParentId2 = directoryUiState.getCurrentParentId();
                    int size = mutableList.size();
                    if (currentParentId2 != null) {
                        Iterator it2 = mutableList.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                i2 = -1;
                                break;
                            }
                            if (Intrinsics.areEqual(((DirectoryNode) it2.next()).getId(), currentParentId2)) {
                                break;
                            }
                            i2++;
                        }
                        if (i2 != -1) {
                            size = i2 + 1;
                            while (size < mutableList.size() && ((DirectoryNode) mutableList.get(size)).getDepth() > ((DirectoryNode) mutableList.get(i2)).getDepth()) {
                                size++;
                            }
                        }
                    }
                    mutableList.add(size, directoryNode);
                    mutableStateFlow3 = this.this$0._uiState;
                    mutableStateFlow4 = this.this$0._uiState;
                    mutableStateFlow3.setValue(DirectoryUiState.copy$default((DirectoryUiState) mutableStateFlow4.getValue(), mutableList, null, false, null, 0, null, 62, null));
                }
                mutableSharedFlow3 = this.this$0._events;
                this.L$0 = null;
                this.label = 2;
                if (mutableSharedFlow3.emit(new DirectoryEvent.FolderCreated(this.$trimmedName), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.this$0.cancelNewFolder(this.$placeholderId);
                mutableSharedFlow2 = this.this$0._events;
                errorMessage2 = this.this$0.errorMessage(bizResp.getCode(), bizResp.getMsg(), R.string.trae_dir_create_failed);
                this.L$0 = null;
                this.label = 3;
                if (mutableSharedFlow2.emit(new DirectoryEvent.ShowToast(errorMessage2), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (!(success instanceof HttpDataResult.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            this.this$0.cancelNewFolder(this.$placeholderId);
            mutableSharedFlow = this.this$0._events;
            HttpDataResult.Error error = (HttpDataResult.Error) success;
            errorMessage = this.this$0.errorMessage(error.getCode(), error.getMsg(), R.string.trae_dir_create_failed);
            this.L$0 = null;
            this.label = 4;
            if (mutableSharedFlow.emit(new DirectoryEvent.ShowToast(errorMessage), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
