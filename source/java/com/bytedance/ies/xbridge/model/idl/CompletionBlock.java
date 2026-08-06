package com.bytedance.ies.xbridge.model.idl;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* compiled from: CompletionBlock.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00018\u0000H'¢\u0006\u0002\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00028\u00002\b\b\u0002\u0010\b\u001a\u00020\tH&¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/xbridge/model/idl/CompletionBlock;", ExifInterface.LATITUDE_SOUTH, "Lcom/bytedance/ies/xbridge/model/idl/XBaseResultModel;", "", "onFailure", "", "code", "", "msg", "", "data", "(ILjava/lang/String;Lcom/bytedance/ies/xbridge/model/idl/XBaseResultModel;)V", "onRawSuccess", "(Lcom/bytedance/ies/xbridge/model/idl/XBaseResultModel;)V", "onSuccess", "result", "(Lcom/bytedance/ies/xbridge/model/idl/XBaseResultModel;Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface CompletionBlock<S extends XBaseResultModel> {
    void onFailure(int code, String msg, S data);

    @Deprecated(level = DeprecationLevel.WARNING, message = "just for compatibility with old bridge")
    void onRawSuccess(S data);

    void onSuccess(S result, String msg);

    /* compiled from: CompletionBlock.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void onSuccess$default(CompletionBlock completionBlock, XBaseResultModel xBaseResultModel, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSuccess");
            }
            if ((i & 2) != 0) {
                str = "";
            }
            completionBlock.onSuccess(xBaseResultModel, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onFailure$default(CompletionBlock completionBlock, int i, String str, XBaseResultModel xBaseResultModel, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFailure");
            }
            if ((i2 & 2) != 0) {
                str = "";
            }
            if ((i2 & 4) != 0) {
                xBaseResultModel = null;
            }
            completionBlock.onFailure(i, str, xBaseResultModel);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onRawSuccess$default(CompletionBlock completionBlock, XBaseResultModel xBaseResultModel, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onRawSuccess");
            }
            if ((i & 1) != 0) {
                xBaseResultModel = null;
            }
            completionBlock.onRawSuccess(xBaseResultModel);
        }
    }
}
