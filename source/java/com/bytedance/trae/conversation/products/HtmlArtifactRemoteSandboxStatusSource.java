package com.bytedance.trae.conversation.products;

import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: HtmlArtifactRemoteArchiveUrlResolver.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSandboxStatusSource;", "", "updates", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface HtmlArtifactRemoteSandboxStatusSource {
    Flow<RealtimeSandboxStatusUpdate> updates();
}
