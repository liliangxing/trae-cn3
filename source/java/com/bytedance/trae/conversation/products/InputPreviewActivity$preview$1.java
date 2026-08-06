package com.bytedance.trae.conversation.products;

import android.text.TextUtils;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.products.InputPreviewActivity;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InputPreviewActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.InputPreviewActivity$preview$1", f = "InputPreviewActivity.kt", i = {}, l = {283}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InputPreviewActivity$preview$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InputPreviewActivity this$0;

    /* compiled from: InputPreviewActivity.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InputPreviewActivity.FileType.values().length];
            try {
                iArr[InputPreviewActivity.FileType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InputPreviewActivity.FileType.MARKDOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InputPreviewActivity.FileType.CODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[InputPreviewActivity.FileType.TXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[InputPreviewActivity.FileType.HTML.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[InputPreviewActivity.FileType.OTHER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputPreviewActivity$preview$1(InputPreviewActivity inputPreviewActivity, Continuation<? super InputPreviewActivity$preview$1> continuation) {
        super(2, continuation);
        this.this$0 = inputPreviewActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InputPreviewActivity$preview$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        InputPreviewActivity.FileType fileType;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.fetchFileUrl((Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        String str7 = (String) obj;
        if (TextUtils.isEmpty(str7) || str7 == null) {
            this.this$0.showError();
            return Unit.INSTANCE;
        }
        this.this$0.fileUrl = str7;
        FLogger.INSTANCE.d("InputPreviewActivity", "preview:" + str7);
        fileType = this.this$0.fileType;
        String str8 = null;
        if (fileType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileType");
            fileType = null;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[fileType.ordinal()]) {
            case 1:
                InputPreviewActivity inputPreviewActivity = this.this$0;
                str = inputPreviewActivity.fileUrl;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileUrl");
                } else {
                    str8 = str;
                }
                inputPreviewActivity.showImagePreview(str8);
                break;
            case 2:
                InputPreviewActivity inputPreviewActivity2 = this.this$0;
                str2 = inputPreviewActivity2.fileUrl;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileUrl");
                } else {
                    str8 = str2;
                }
                inputPreviewActivity2.loadMarkdownPreview(str8);
                break;
            case 3:
                InputPreviewActivity inputPreviewActivity3 = this.this$0;
                str3 = inputPreviewActivity3.fileUrl;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileUrl");
                } else {
                    str8 = str3;
                }
                inputPreviewActivity3.showCodePreview(str8);
                break;
            case 4:
                InputPreviewActivity inputPreviewActivity4 = this.this$0;
                str4 = inputPreviewActivity4.fileUrl;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileUrl");
                } else {
                    str8 = str4;
                }
                inputPreviewActivity4.downloadAndShowTxt(str8);
                break;
            case 5:
                InputPreviewActivity inputPreviewActivity5 = this.this$0;
                str5 = inputPreviewActivity5.fileUrl;
                if (str5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileUrl");
                } else {
                    str8 = str5;
                }
                inputPreviewActivity5.downloadAndShowTxt(str8);
                break;
            case 6:
                InputPreviewActivity inputPreviewActivity6 = this.this$0;
                str6 = inputPreviewActivity6.fileUrl;
                if (str6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileUrl");
                } else {
                    str8 = str6;
                }
                inputPreviewActivity6.showDownloadWithUrl(str8);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }
}
