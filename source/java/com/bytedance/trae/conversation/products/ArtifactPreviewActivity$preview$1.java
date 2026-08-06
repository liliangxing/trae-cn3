package com.bytedance.trae.conversation.products;

import android.text.TextUtils;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.products.ArtifactPreviewActivity;
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
/* compiled from: ArtifactPreviewActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.ArtifactPreviewActivity$preview$1", f = "ArtifactPreviewActivity.kt", i = {}, l = {328}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ArtifactPreviewActivity$preview$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ArtifactPreviewActivity this$0;

    /* compiled from: ArtifactPreviewActivity.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ArtifactPreviewActivity.FileType.values().length];
            try {
                iArr[ArtifactPreviewActivity.FileType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArtifactPreviewActivity.FileType.MARKDOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ArtifactPreviewActivity.FileType.CODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ArtifactPreviewActivity.FileType.TXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ArtifactPreviewActivity.FileType.HTML.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ArtifactPreviewActivity.FileType.OTHER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactPreviewActivity$preview$1(ArtifactPreviewActivity artifactPreviewActivity, Continuation<? super ArtifactPreviewActivity$preview$1> continuation) {
        super(2, continuation);
        this.this$0 = artifactPreviewActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArtifactPreviewActivity$preview$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z;
        ArtifactPreviewActivity.FileType fileType;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
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
        String str11 = (String) obj;
        z = this.this$0.isDeleted;
        if (z) {
            this.this$0.showArtifactDelete();
            return Unit.INSTANCE;
        }
        if (TextUtils.isEmpty(str11) || str11 == null) {
            this.this$0.showError();
            return Unit.INSTANCE;
        }
        this.this$0.fileUrl = str11;
        fileType = this.this$0.fileType;
        String str12 = null;
        if (fileType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileType");
            fileType = null;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[fileType.ordinal()]) {
            case 1:
                ArtifactPreviewActivity artifactPreviewActivity = this.this$0;
                str = artifactPreviewActivity.fileUrl;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileUrl");
                } else {
                    str12 = str;
                }
                artifactPreviewActivity.showImagePreview(str12);
                break;
            case 2:
                ArtifactPreviewActivity artifactPreviewActivity2 = this.this$0;
                str2 = artifactPreviewActivity2.fileUrl;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileUrl");
                    str2 = null;
                }
                str3 = this.this$0.chatSessionId;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatSessionId");
                    str3 = null;
                }
                str4 = this.this$0.path;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("path");
                } else {
                    str12 = str4;
                }
                artifactPreviewActivity2.loadMarkdownPreview(str2, str3, str12);
                break;
            case 3:
                ArtifactPreviewActivity artifactPreviewActivity3 = this.this$0;
                str5 = artifactPreviewActivity3.fileUrl;
                if (str5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileUrl");
                } else {
                    str12 = str5;
                }
                artifactPreviewActivity3.showCodePreview(str12);
                break;
            case 4:
                ArtifactPreviewActivity artifactPreviewActivity4 = this.this$0;
                str6 = artifactPreviewActivity4.fileUrl;
                if (str6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileUrl");
                } else {
                    str12 = str6;
                }
                artifactPreviewActivity4.downloadAndShowTxt(str12);
                break;
            case 5:
                ArtifactPreviewActivity artifactPreviewActivity5 = this.this$0;
                str7 = artifactPreviewActivity5.fileUrl;
                if (str7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileUrl");
                } else {
                    str12 = str7;
                }
                artifactPreviewActivity5.downloadAndShowTxt(str12);
                break;
            case 6:
                ArtifactPreviewActivity artifactPreviewActivity6 = this.this$0;
                str8 = artifactPreviewActivity6.fileUrl;
                if (str8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fileUrl");
                    str8 = null;
                }
                str9 = this.this$0.chatSessionId;
                if (str9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatSessionId");
                    str9 = null;
                }
                str10 = this.this$0.path;
                if (str10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("path");
                } else {
                    str12 = str10;
                }
                artifactPreviewActivity6.showDownloadWithUrl(str8, str9, str12);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }
}
