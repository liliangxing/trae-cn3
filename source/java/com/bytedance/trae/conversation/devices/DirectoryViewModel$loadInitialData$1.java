package com.bytedance.trae.conversation.devices;

import com.bytedance.trae.conversation.devices.DirectoryEvent;
import com.bytedance.trae.conversation.devices.DirectoryViewModel;
import com.bytedance.trae.conversation.network.IGetProjectApi;
import com.bytedance.trae.conversation.network.UserProjectFoldersData;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DirectoryViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.devices.DirectoryViewModel$loadInitialData$1", f = "DirectoryViewModel.kt", i = {}, l = {110, 149, 157}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DirectoryViewModel$loadInitialData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    int label;
    final /* synthetic */ DirectoryViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectoryViewModel$loadInitialData$1(DirectoryViewModel directoryViewModel, String str, Continuation<? super DirectoryViewModel$loadInitialData$1> continuation) {
        super(2, continuation);
        this.this$0 = directoryViewModel;
        this.$id = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DirectoryViewModel$loadInitialData$1(this.this$0, this.$id, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        Object userProjectFoldersRawCall;
        MutableStateFlow mutableStateFlow3;
        MutableStateFlow mutableStateFlow4;
        MutableSharedFlow mutableSharedFlow;
        String errorMessage;
        MutableStateFlow mutableStateFlow5;
        MutableStateFlow mutableStateFlow6;
        MutableSharedFlow mutableSharedFlow2;
        String errorMessage2;
        MutableStateFlow mutableStateFlow7;
        MutableStateFlow mutableStateFlow8;
        MutableStateFlow mutableStateFlow9;
        MutableStateFlow mutableStateFlow10;
        MutableStateFlow mutableStateFlow11;
        MutableStateFlow mutableStateFlow12;
        MutableStateFlow mutableStateFlow13;
        List applyPreselection;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0._uiState;
            mutableStateFlow2 = this.this$0._uiState;
            mutableStateFlow.setValue(DirectoryUiState.copy$default((DirectoryUiState) mutableStateFlow2.getValue(), null, null, true, null, 0, null, 59, null));
            Map<String, String> mapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("cli_id", this.$id), TuplesKt.to("mode", this.this$0.getChatMode().getValue())});
            this.label = 1;
            userProjectFoldersRawCall = IGetProjectApi.INSTANCE.getUserProjectFoldersRawCall(mapOf, (Continuation) this);
            if (userProjectFoldersRawCall == coroutine_suspended) {
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
            userProjectFoldersRawCall = obj;
        }
        HttpDataResult.Success success = (HttpDataResult) userProjectFoldersRawCall;
        if (success instanceof HttpDataResult.Success) {
            BizResponse bizResp = success.getBizResp();
            if (!bizResp.isSuccess()) {
                mutableStateFlow5 = this.this$0._uiState;
                mutableStateFlow6 = this.this$0._uiState;
                mutableStateFlow5.setValue(DirectoryUiState.copy$default((DirectoryUiState) mutableStateFlow6.getValue(), null, null, false, null, 0, null, 59, null));
                mutableSharedFlow2 = this.this$0._events;
                errorMessage2 = this.this$0.errorMessage(bizResp.getCode(), bizResp.getMsg(), R.string.trae_dir_fetch_project_failed);
                this.label = 2;
                if (mutableSharedFlow2.emit(new DirectoryEvent.ShowToast(errorMessage2), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                UserProjectFoldersData userProjectFoldersData = (UserProjectFoldersData) bizResp.getData();
                List<String> paths = userProjectFoldersData != null ? userProjectFoldersData.getPaths() : null;
                if (paths == null) {
                    paths = CollectionsKt.emptyList();
                }
                mutableStateFlow7 = this.this$0._userFolders;
                mutableStateFlow7.setValue(paths);
                mutableStateFlow8 = this.this$0._defaultFolder;
                mutableStateFlow8.setValue(CollectionsKt.firstOrNull(paths));
                List drop = CollectionsKt.drop(paths, 1);
                if (!drop.isEmpty()) {
                    this.this$0.setMode(DirectoryViewModel.Mode.RECENT);
                    List list = drop;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    int i2 = 0;
                    for (Object obj2 : list) {
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        String str = (String) obj2;
                        String substringAfterLast$default = StringsKt.substringAfterLast$default(StringsKt.substringAfterLast$default(str, '/', (String) null, 2, (Object) null), '\\', (String) null, 2, (Object) null);
                        String valueOf = String.valueOf(i3);
                        String str2 = substringAfterLast$default;
                        if (str2.length() == 0) {
                            str2 = str;
                        }
                        arrayList.add(new DirectoryNode(valueOf, str2, str, 0, null, false, false, false, false, false, false, 2000, null));
                        i2 = i3;
                    }
                    mutableStateFlow12 = this.this$0._uiState;
                    mutableStateFlow13 = this.this$0._uiState;
                    DirectoryUiState directoryUiState = (DirectoryUiState) mutableStateFlow13.getValue();
                    applyPreselection = this.this$0.applyPreselection(arrayList);
                    mutableStateFlow12.setValue(DirectoryUiState.copy$default(directoryUiState, applyPreselection, null, false, null, 0, DirectoryViewModel.Mode.RECENT, 26, null));
                } else {
                    this.this$0.setMode(DirectoryViewModel.Mode.DOCUMENT);
                    mutableStateFlow9 = this.this$0._uiState;
                    mutableStateFlow10 = this.this$0._uiState;
                    mutableStateFlow9.setValue(DirectoryUiState.copy$default((DirectoryUiState) mutableStateFlow10.getValue(), null, null, true, null, 0, DirectoryViewModel.Mode.DOCUMENT, 27, null));
                    mutableStateFlow11 = this.this$0._defaultFolder;
                    String str3 = (String) mutableStateFlow11.getValue();
                    if (str3 == null) {
                        str3 = "";
                    }
                    DirectoryViewModel.loadDocumentFolder$default(this.this$0, str3, 0, false, 2, null);
                }
            }
        } else if (success instanceof HttpDataResult.Error) {
            mutableStateFlow3 = this.this$0._uiState;
            mutableStateFlow4 = this.this$0._uiState;
            mutableStateFlow3.setValue(DirectoryUiState.copy$default((DirectoryUiState) mutableStateFlow4.getValue(), null, null, false, null, 0, null, 59, null));
            mutableSharedFlow = this.this$0._events;
            HttpDataResult.Error error = (HttpDataResult.Error) success;
            errorMessage = this.this$0.errorMessage(error.getCode(), error.getMsg(), R.string.trae_dir_fetch_project_failed);
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
