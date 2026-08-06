package com.bytedance.trae.conversation.products;

import android.util.Base64;
import com.bytedance.sdk.account.api.AccountErrorCode;
import com.bytedance.trae.conversation.fileupload.ResourceUploadUtilKt;
import com.bytedance.trae.im.model.MergeChangedFilesData;
import com.bytedance.trae.im.model.MergeFileDiffInfo;
import com.bytedance.trae.im.model.MergeTotalDiffInfo;
import com.bytedance.trae.im.service.ChatSessionResponse;
import com.bytedance.trae.im.service.GitBatchDiffResponse;
import com.bytedance.trae.im.service.GitFileContent;
import com.bytedance.trae.im.service.GitFileDiff;
import com.bytedance.trae.im.service.IChatSessionApi;
import com.bytedance.trae.im.service.IGitBatchDiffApi;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: MergeDiffManager.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0002J\u001c\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0002¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/products/MergeDiffManager;", "", "<init>", "()V", "fetchMergeDiffs", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;", "chatSessionId", "", "mergeData", "Lcom/bytedance/trae/im/model/MergeChangedFilesData;", "taskName", "(Ljava/lang/String;Lcom/bytedance/trae/im/model/MergeChangedFilesData;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractFileName", "filePath", "decodeGitContent", "encoding", "data", "MergeDiffResult", "MergeDiffError", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MergeDiffManager {

    /* compiled from: MergeDiffManager.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003JK\u0010\u001d\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\bHÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011¨\u0006#"}, d2 = {"Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;", "", "diffFiles", "", "Lcom/bytedance/trae/conversation/products/DiffFile;", "taskName", "", "totalInsertLineCount", "", "totalDeleteLineCount", "sourceBranch", "targetBranch", "<init>", "(Ljava/util/List;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getDiffFiles", "()Ljava/util/List;", "getTaskName", "()Ljava/lang/String;", "getTotalInsertLineCount", "()I", "getTotalDeleteLineCount", "getSourceBranch", "getTargetBranch", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class MergeDiffResult {
        private final List<DiffFile> diffFiles;
        private final String sourceBranch;
        private final String targetBranch;
        private final String taskName;
        private final int totalDeleteLineCount;
        private final int totalInsertLineCount;

        public static /* synthetic */ MergeDiffResult copy$default(MergeDiffResult mergeDiffResult, List list, String str, int i, int i2, String str2, String str3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = mergeDiffResult.diffFiles;
            }
            if ((i3 & 2) != 0) {
                str = mergeDiffResult.taskName;
            }
            String str4 = str;
            if ((i3 & 4) != 0) {
                i = mergeDiffResult.totalInsertLineCount;
            }
            int i4 = i;
            if ((i3 & 8) != 0) {
                i2 = mergeDiffResult.totalDeleteLineCount;
            }
            int i5 = i2;
            if ((i3 & 16) != 0) {
                str2 = mergeDiffResult.sourceBranch;
            }
            String str5 = str2;
            if ((i3 & 32) != 0) {
                str3 = mergeDiffResult.targetBranch;
            }
            return mergeDiffResult.copy(list, str4, i4, i5, str5, str3);
        }

        public final List<DiffFile> component1() {
            return this.diffFiles;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTaskName() {
            return this.taskName;
        }

        /* renamed from: component3, reason: from getter */
        public final int getTotalInsertLineCount() {
            return this.totalInsertLineCount;
        }

        /* renamed from: component4, reason: from getter */
        public final int getTotalDeleteLineCount() {
            return this.totalDeleteLineCount;
        }

        /* renamed from: component5, reason: from getter */
        public final String getSourceBranch() {
            return this.sourceBranch;
        }

        /* renamed from: component6, reason: from getter */
        public final String getTargetBranch() {
            return this.targetBranch;
        }

        public final MergeDiffResult copy(List<DiffFile> diffFiles, String taskName, int totalInsertLineCount, int totalDeleteLineCount, String sourceBranch, String targetBranch) {
            Intrinsics.checkNotNullParameter(diffFiles, "diffFiles");
            Intrinsics.checkNotNullParameter(taskName, "taskName");
            Intrinsics.checkNotNullParameter(sourceBranch, "sourceBranch");
            Intrinsics.checkNotNullParameter(targetBranch, "targetBranch");
            return new MergeDiffResult(diffFiles, taskName, totalInsertLineCount, totalDeleteLineCount, sourceBranch, targetBranch);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MergeDiffResult)) {
                return false;
            }
            MergeDiffResult mergeDiffResult = (MergeDiffResult) other;
            return Intrinsics.areEqual(this.diffFiles, mergeDiffResult.diffFiles) && Intrinsics.areEqual(this.taskName, mergeDiffResult.taskName) && this.totalInsertLineCount == mergeDiffResult.totalInsertLineCount && this.totalDeleteLineCount == mergeDiffResult.totalDeleteLineCount && Intrinsics.areEqual(this.sourceBranch, mergeDiffResult.sourceBranch) && Intrinsics.areEqual(this.targetBranch, mergeDiffResult.targetBranch);
        }

        public int hashCode() {
            return (((((((((this.diffFiles.hashCode() * 31) + this.taskName.hashCode()) * 31) + Integer.hashCode(this.totalInsertLineCount)) * 31) + Integer.hashCode(this.totalDeleteLineCount)) * 31) + this.sourceBranch.hashCode()) * 31) + this.targetBranch.hashCode();
        }

        public String toString() {
            return "MergeDiffResult(diffFiles=" + this.diffFiles + ", taskName=" + this.taskName + ", totalInsertLineCount=" + this.totalInsertLineCount + ", totalDeleteLineCount=" + this.totalDeleteLineCount + ", sourceBranch=" + this.sourceBranch + ", targetBranch=" + this.targetBranch + ')';
        }

        public MergeDiffResult(List<DiffFile> list, String str, int i, int i2, String str2, String str3) {
            Intrinsics.checkNotNullParameter(list, "diffFiles");
            Intrinsics.checkNotNullParameter(str, "taskName");
            Intrinsics.checkNotNullParameter(str2, "sourceBranch");
            Intrinsics.checkNotNullParameter(str3, "targetBranch");
            this.diffFiles = list;
            this.taskName = str;
            this.totalInsertLineCount = i;
            this.totalDeleteLineCount = i2;
            this.sourceBranch = str2;
            this.targetBranch = str3;
        }

        public final List<DiffFile> getDiffFiles() {
            return this.diffFiles;
        }

        public final String getTaskName() {
            return this.taskName;
        }

        public final int getTotalInsertLineCount() {
            return this.totalInsertLineCount;
        }

        public final int getTotalDeleteLineCount() {
            return this.totalDeleteLineCount;
        }

        public final String getSourceBranch() {
            return this.sourceBranch;
        }

        public final String getTargetBranch() {
            return this.targetBranch;
        }
    }

    /* compiled from: MergeDiffManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError;", "", "<init>", "()V", "ExplorerUrlMissing", "ApiError", "Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ApiError;", "Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ExplorerUrlMissing;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static abstract class MergeDiffError {
        public /* synthetic */ MergeDiffError(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: MergeDiffManager.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ExplorerUrlMissing;", "Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class ExplorerUrlMissing extends MergeDiffError {
            private final String message;

            public static /* synthetic */ ExplorerUrlMissing copy$default(ExplorerUrlMissing explorerUrlMissing, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = explorerUrlMissing.message;
                }
                return explorerUrlMissing.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getMessage() {
                return this.message;
            }

            public final ExplorerUrlMissing copy(String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                return new ExplorerUrlMissing(message);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ExplorerUrlMissing) && Intrinsics.areEqual(this.message, ((ExplorerUrlMissing) other).message);
            }

            public int hashCode() {
                return this.message.hashCode();
            }

            public String toString() {
                return "ExplorerUrlMissing(message=" + this.message + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ExplorerUrlMissing(String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "message");
                this.message = str;
            }

            public final String getMessage() {
                return this.message;
            }
        }

        private MergeDiffError() {
        }

        /* compiled from: MergeDiffManager.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError$ApiError;", "Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffError;", "message", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getMessage", "()Ljava/lang/String;", "getCause", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class ApiError extends MergeDiffError {
            private final Throwable cause;
            private final String message;

            public static /* synthetic */ ApiError copy$default(ApiError apiError, String str, Throwable th, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = apiError.message;
                }
                if ((i & 2) != 0) {
                    th = apiError.cause;
                }
                return apiError.copy(str, th);
            }

            /* renamed from: component1, reason: from getter */
            public final String getMessage() {
                return this.message;
            }

            /* renamed from: component2, reason: from getter */
            public final Throwable getCause() {
                return this.cause;
            }

            public final ApiError copy(String message, Throwable cause) {
                Intrinsics.checkNotNullParameter(message, "message");
                return new ApiError(message, cause);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ApiError)) {
                    return false;
                }
                ApiError apiError = (ApiError) other;
                return Intrinsics.areEqual(this.message, apiError.message) && Intrinsics.areEqual(this.cause, apiError.cause);
            }

            public int hashCode() {
                int hashCode = this.message.hashCode() * 31;
                Throwable th = this.cause;
                return hashCode + (th == null ? 0 : th.hashCode());
            }

            public String toString() {
                return "ApiError(message=" + this.message + ", cause=" + this.cause + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ApiError(String str, Throwable th) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "message");
                this.message = str;
                this.cause = th;
            }

            public final Throwable getCause() {
                return this.cause;
            }

            public final String getMessage() {
                return this.message;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:177:0x0195, code lost:
    
        if (r0 != null) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x020e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0319 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0238 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchMergeDiffs(String str, MergeChangedFilesData mergeChangedFilesData, String str2, Continuation<? super HttpDataResult<MergeDiffResult>> continuation) {
        MergeDiffManager$fetchMergeDiffs$1 mergeDiffManager$fetchMergeDiffs$1;
        int i;
        MergeChangedFilesData mergeChangedFilesData2;
        String str3;
        MergeDiffManager mergeDiffManager;
        HttpDataResult.Success success;
        ArrayList emptyList;
        Set emptySet;
        Set set;
        MergeChangedFilesData mergeChangedFilesData3;
        MergeDiffManager mergeDiffManager2;
        String str4;
        HttpDataResult.Success success2;
        List<GitFileDiff> emptyList2;
        int i2;
        int i3;
        Integer deleteLineCount;
        Integer insertLineCount;
        MergeFileDiffInfo mergeFileDiffInfo;
        DiffFile diffFile;
        Object obj;
        if (continuation instanceof MergeDiffManager$fetchMergeDiffs$1) {
            mergeDiffManager$fetchMergeDiffs$1 = (MergeDiffManager$fetchMergeDiffs$1) continuation;
            if ((mergeDiffManager$fetchMergeDiffs$1.label & Integer.MIN_VALUE) != 0) {
                mergeDiffManager$fetchMergeDiffs$1.label -= Integer.MIN_VALUE;
                Object obj2 = mergeDiffManager$fetchMergeDiffs$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = mergeDiffManager$fetchMergeDiffs$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    IChatSessionApi.Companion companion = IChatSessionApi.INSTANCE;
                    mergeDiffManager$fetchMergeDiffs$1.L$0 = this;
                    mergeChangedFilesData2 = mergeChangedFilesData;
                    mergeDiffManager$fetchMergeDiffs$1.L$1 = mergeChangedFilesData2;
                    str3 = str2;
                    mergeDiffManager$fetchMergeDiffs$1.L$2 = str3;
                    mergeDiffManager$fetchMergeDiffs$1.label = 1;
                    obj2 = companion.getChatSessionRawCall(str, mergeDiffManager$fetchMergeDiffs$1);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mergeDiffManager = this;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        set = (Set) mergeDiffManager$fetchMergeDiffs$1.L$3;
                        String str5 = (String) mergeDiffManager$fetchMergeDiffs$1.L$2;
                        mergeChangedFilesData3 = (MergeChangedFilesData) mergeDiffManager$fetchMergeDiffs$1.L$1;
                        mergeDiffManager2 = (MergeDiffManager) mergeDiffManager$fetchMergeDiffs$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        str4 = str5;
                        success2 = (HttpDataResult) obj2;
                        if (!(success2 instanceof HttpDataResult.Error)) {
                            return success2;
                        }
                        if (!(success2 instanceof HttpDataResult.Success)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        GitBatchDiffResponse gitBatchDiffResponse = (GitBatchDiffResponse) success2.getBizResp().getData();
                        if (gitBatchDiffResponse == null || (emptyList2 = gitBatchDiffResponse.getDiffs()) == null) {
                            emptyList2 = CollectionsKt.emptyList();
                        }
                        ArrayList arrayList = new ArrayList();
                        for (GitFileDiff gitFileDiff : emptyList2) {
                            String path = gitFileDiff.getPath();
                            if (path != null) {
                                boolean z = Intrinsics.areEqual(gitFileDiff.isConflict(), Boxing.boxBoolean(true)) || set.contains(path);
                                GitFileContent baseContent = gitFileDiff.getBaseContent();
                                String encoding = baseContent != null ? baseContent.getEncoding() : null;
                                GitFileContent baseContent2 = gitFileDiff.getBaseContent();
                                String decodeGitContent = mergeDiffManager2.decodeGitContent(encoding, baseContent2 != null ? baseContent2.getData() : null);
                                GitFileContent headContent = gitFileDiff.getHeadContent();
                                String encoding2 = headContent != null ? headContent.getEncoding() : null;
                                GitFileContent headContent2 = gitFileDiff.getHeadContent();
                                String decodeGitContent2 = mergeDiffManager2.decodeGitContent(encoding2, headContent2 != null ? headContent2.getData() : null);
                                List<MergeFileDiffInfo> fileDiffInfos = mergeChangedFilesData3.getFileDiffInfos();
                                if (fileDiffInfos != null) {
                                    Iterator<T> it = fileDiffInfos.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            obj = null;
                                            break;
                                        }
                                        obj = it.next();
                                        if (Intrinsics.areEqual(mergeDiffManager2.extractFileName(((MergeFileDiffInfo) obj).getFilePath()), path)) {
                                            break;
                                        }
                                    }
                                    mergeFileDiffInfo = (MergeFileDiffInfo) obj;
                                } else {
                                    mergeFileDiffInfo = null;
                                }
                                if (mergeFileDiffInfo != null) {
                                    Integer insertLineCount2 = mergeFileDiffInfo.getInsertLineCount();
                                    int intValue = insertLineCount2 != null ? insertLineCount2.intValue() : 0;
                                    Integer deleteLineCount2 = mergeFileDiffInfo.getDeleteLineCount();
                                    int intValue2 = deleteLineCount2 != null ? deleteLineCount2.intValue() : 0;
                                    String filePath = Intrinsics.areEqual(mergeFileDiffInfo.getFileAction(), "added") ? null : mergeFileDiffInfo.getFilePath();
                                    String filePath2 = mergeFileDiffInfo.getFilePath();
                                    diffFile = new DiffFile(filePath, filePath2 == null ? path : filePath2, intValue, intValue2, decodeGitContent, decodeGitContent2, false, z);
                                    if (diffFile == null) {
                                        arrayList.add(diffFile);
                                    }
                                }
                            }
                            diffFile = null;
                            if (diffFile == null) {
                            }
                        }
                        ArrayList arrayList2 = arrayList;
                        MergeTotalDiffInfo totalDiffInfo = mergeChangedFilesData3.getTotalDiffInfo();
                        if (totalDiffInfo == null || (insertLineCount = totalDiffInfo.getInsertLineCount()) == null) {
                            Iterator it2 = arrayList2.iterator();
                            int i4 = 0;
                            while (it2.hasNext()) {
                                i4 += ((DiffFile) it2.next()).getInsertLineCount();
                            }
                            i2 = i4;
                        } else {
                            i2 = insertLineCount.intValue();
                        }
                        if (totalDiffInfo == null || (deleteLineCount = totalDiffInfo.getDeleteLineCount()) == null) {
                            Iterator it3 = arrayList2.iterator();
                            int i5 = 0;
                            while (it3.hasNext()) {
                                i5 += ((DiffFile) it3.next()).getDeleteLineCount();
                            }
                            i3 = i5;
                        } else {
                            i3 = deleteLineCount.intValue();
                        }
                        String sourceBranch = mergeChangedFilesData3.getSourceBranch();
                        String str6 = sourceBranch == null ? "" : sourceBranch;
                        String targetBranch = mergeChangedFilesData3.getTargetBranch();
                        return new HttpDataResult.Success(new BizResponse(0L, (String) null, (String) null, (String) null, new MergeDiffResult(arrayList2, str4, i2, i3, str6, targetBranch == null ? "" : targetBranch), (String) null, 47, (DefaultConstructorMarker) null), (Throwable) null);
                    }
                    String str7 = (String) mergeDiffManager$fetchMergeDiffs$1.L$2;
                    MergeChangedFilesData mergeChangedFilesData4 = (MergeChangedFilesData) mergeDiffManager$fetchMergeDiffs$1.L$1;
                    mergeDiffManager = (MergeDiffManager) mergeDiffManager$fetchMergeDiffs$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    str3 = str7;
                    mergeChangedFilesData2 = mergeChangedFilesData4;
                }
                success = (HttpDataResult) obj2;
                if (success instanceof HttpDataResult.Success) {
                    if (success instanceof HttpDataResult.Error) {
                        return success;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                ChatSessionResponse chatSessionResponse = (ChatSessionResponse) success.getBizResp().getData();
                String explorerUrl = chatSessionResponse != null ? chatSessionResponse.getExplorerUrl() : null;
                if (explorerUrl == null) {
                    return new HttpDataResult.Error(AccountErrorCode.CommonError.COMMON_ERROR_REQUEST_API, "explorer_url is null", new Exception("explorer_url is null"), (String) null, 8, (DefaultConstructorMarker) null);
                }
                String mergeBaseHash = mergeChangedFilesData2.getMergeBaseHash();
                if (mergeBaseHash == null) {
                    return new HttpDataResult.Error(AccountErrorCode.CommonError.COMMON_ERROR_REQUEST_API, "merge_base_hash is null", new Exception("merge_base_hash is null"), (String) null, 8, (DefaultConstructorMarker) null);
                }
                String sourceBranchHash = mergeChangedFilesData2.getSourceBranchHash();
                if (sourceBranchHash == null) {
                    return new HttpDataResult.Error(AccountErrorCode.CommonError.COMMON_ERROR_REQUEST_API, "source_branch_hash is null", new Exception("source_branch_hash is null"), (String) null, 8, (DefaultConstructorMarker) null);
                }
                List<MergeFileDiffInfo> fileDiffInfos2 = mergeChangedFilesData2.getFileDiffInfos();
                if (fileDiffInfos2 == null) {
                    emptyList = CollectionsKt.emptyList();
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    Iterator<T> it4 = fileDiffInfos2.iterator();
                    while (it4.hasNext()) {
                        String extractFileName = mergeDiffManager.extractFileName(((MergeFileDiffInfo) it4.next()).getFilePath());
                        if (extractFileName != null) {
                            arrayList3.add(extractFileName);
                        }
                    }
                    emptyList = arrayList3;
                }
                List<MergeFileDiffInfo> fileDiffInfos3 = mergeChangedFilesData2.getFileDiffInfos();
                if (fileDiffInfos3 != null) {
                    ArrayList arrayList4 = new ArrayList();
                    for (Object obj3 : fileDiffInfos3) {
                        if (Intrinsics.areEqual(((MergeFileDiffInfo) obj3).isConflict(), Boxing.boxBoolean(true))) {
                            arrayList4.add(obj3);
                        }
                    }
                    ArrayList arrayList5 = new ArrayList();
                    Iterator it5 = arrayList4.iterator();
                    while (it5.hasNext()) {
                        String extractFileName2 = mergeDiffManager.extractFileName(((MergeFileDiffInfo) it5.next()).getFilePath());
                        if (extractFileName2 != null) {
                            arrayList5.add(extractFileName2);
                        }
                    }
                    emptySet = CollectionsKt.toSet(arrayList5);
                }
                emptySet = SetsKt.emptySet();
                String str8 = StringsKt.trimEnd(explorerUrl, new char[]{'/'}) + '/';
                ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
                String xTToken = iLoginService != null ? iLoginService.getXTToken() : null;
                if (xTToken == null) {
                    xTToken = "";
                }
                Map<String, String> mapOf = MapsKt.mapOf(TuplesKt.to("authorization", "Cloud-IDE-JWT " + xTToken));
                IGitBatchDiffApi.Companion companion2 = IGitBatchDiffApi.INSTANCE;
                MergeDiffManager$fetchMergeDiffs$batchResult$1 mergeDiffManager$fetchMergeDiffs$batchResult$1 = new MergeDiffManager$fetchMergeDiffs$batchResult$1(mergeBaseHash, sourceBranchHash, emptyList, null);
                mergeDiffManager$fetchMergeDiffs$1.L$0 = mergeDiffManager;
                mergeDiffManager$fetchMergeDiffs$1.L$1 = mergeChangedFilesData2;
                mergeDiffManager$fetchMergeDiffs$1.L$2 = str3;
                mergeDiffManager$fetchMergeDiffs$1.L$3 = emptySet;
                mergeDiffManager$fetchMergeDiffs$1.label = 2;
                obj2 = companion2.safeCall(str8, mapOf, mergeDiffManager$fetchMergeDiffs$batchResult$1, mergeDiffManager$fetchMergeDiffs$1);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                set = emptySet;
                mergeChangedFilesData3 = mergeChangedFilesData2;
                mergeDiffManager2 = mergeDiffManager;
                str4 = str3;
                success2 = (HttpDataResult) obj2;
                if (!(success2 instanceof HttpDataResult.Error)) {
                }
            }
        }
        mergeDiffManager$fetchMergeDiffs$1 = new MergeDiffManager$fetchMergeDiffs$1(this, continuation);
        Object obj22 = mergeDiffManager$fetchMergeDiffs$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = mergeDiffManager$fetchMergeDiffs$1.label;
        if (i != 0) {
        }
        success = (HttpDataResult) obj22;
        if (success instanceof HttpDataResult.Success) {
        }
    }

    private final String extractFileName(String filePath) {
        String str = filePath;
        if (str == null || str.length() == 0) {
            return "";
        }
        return StringsKt.substringAfterLast$default(filePath, StringsKt.contains$default(str, '\\', false, 2, (Object) null) ? '\\' : '/', (String) null, 2, (Object) null);
    }

    private final String decodeGitContent(String encoding, String data) {
        String str = data;
        if (str == null || str.length() == 0) {
            return "";
        }
        if (!Intrinsics.areEqual(encoding, "base64")) {
            return data;
        }
        try {
            byte[] decode = Base64.decode(data, 0);
            Intrinsics.checkNotNull(decode);
            return new String(ResourceUploadUtilKt.decodeContent(decode), Charsets.UTF_8);
        } catch (Exception unused) {
            return data;
        }
    }
}
