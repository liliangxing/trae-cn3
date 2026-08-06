package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.net.Uri;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.products.FileDownloadHelper;
import com.bytedance.trae.im.model.FileDiffInfo;
import com.bytedance.trae.im.service.ChatSessionResponse;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.GetDownloadUrlData;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.FLogger;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: ArtifactsRenderer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1", f = "ArtifactsRenderer.kt", i = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3}, l = {2378, 2431, 2447, 2491}, m = "invokeSuspend", n = {"targets", "extras", "urlMap", "attempt", "targets", "extras", "urlMap", "attempt", "targets", "urlMap", "fileDownloadHelper", "index$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatSessionId;
    final /* synthetic */ String $cliType;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ List<FileDiffInfo> $files;
    final /* synthetic */ List<SimpleDraweeView> $imageViews;
    final /* synthetic */ String $messageId;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    final /* synthetic */ ArtifactsRenderer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1(String str, List<FileDiffInfo> list, List<? extends SimpleDraweeView> list2, String str2, String str3, String str4, ArtifactsRenderer artifactsRenderer, Context context, Continuation<? super ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1> continuation) {
        super(2, continuation);
        this.$cliType = str;
        this.$files = list;
        this.$imageViews = list2;
        this.$chatSessionId = str2;
        this.$conversationId = str3;
        this.$messageId = str4;
        this.this$0 = artifactsRenderer;
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1(this.$cliType, this.$files, this.$imageViews, this.$chatSessionId, this.$conversationId, this.$messageId, this.this$0, this.$context, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|2|(1:(1:(1:(1:(9:8|9|10|11|12|13|(15:15|(1:17)|18|19|20|21|22|23|24|(5:29|(4:31|(2:36|(1:38)(2:40|11))|41|42)(2:43|44)|12|13|(0))|45|(0)(0)|12|13|(0))|50|51)(2:52|53))(5:54|55|56|57|(2:59|(1:61)(8:62|63|(5:104|105|106|(1:108)(1:111)|109)(6:65|(1:67)(1:103)|68|(2:73|(2:95|(2:97|(1:99)(3:100|57|(5:113|77|(2:82|(5:84|13|(0)|50|51)(5:85|(5:88|(1:90)|91|92|86)|93|50|51))|94|(0)(0))(0)))(1:101))(1:75))|102|(0)(0))|76|77|(3:79|82|(0)(0))|94|(0)(0)))(0)))(9:114|115|63|(0)(0)|76|77|(0)|94|(0)(0)))(2:116|117))(3:163|164|(2:166|(1:168))(8:169|(7:172|(1:174)|175|(1:177)(1:180)|178|179|170)|181|182|183|184|185|(0)(0)))|118|119|120|121|(8:123|(1:125)(1:151)|126|(1:128)|129|(2:134|(3:136|(6:139|(1:141)|142|(2:144|145)(1:147)|146|137)|148)(1:149))|150|(0)(0))(5:152|(1:154)(1:160)|155|(2:158|156)|159)|50|51) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:15|(1:17)|18|19|20|21|22|23|24|(5:29|(4:31|(2:36|(1:38)(2:40|11))|41|42)(2:43|44)|12|13|(0))|45|(0)(0)|12|13|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x03d7, code lost:
    
        r33 = r6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0111 A[Catch: Exception -> 0x008f, TryCatch #0 {Exception -> 0x008f, blocks: (B:9:0x0047, B:13:0x0390, B:15:0x0396, B:17:0x039e, B:18:0x03a1, B:24:0x03d9, B:26:0x03de, B:31:0x03ea, B:33:0x040b, B:36:0x0414, B:41:0x0466, B:43:0x047e, B:55:0x006c, B:57:0x02d0, B:59:0x024c, B:63:0x0275, B:65:0x027b, B:67:0x028a, B:68:0x0290, B:70:0x0298, B:77:0x0354, B:79:0x035a, B:84:0x0366, B:85:0x04b6, B:86:0x04cf, B:88:0x04d5, B:90:0x04dd, B:91:0x04e0, B:95:0x02a7, B:97:0x02b8, B:101:0x02db, B:115:0x0080, B:116:0x0089, B:118:0x00bf, B:121:0x00d5, B:123:0x00d9, B:125:0x00e8, B:126:0x00ee, B:128:0x00fc, B:129:0x0100, B:131:0x0105, B:136:0x0111, B:137:0x012f, B:139:0x0135, B:141:0x013d, B:142:0x0140, B:146:0x0149, B:149:0x0160, B:152:0x0173, B:154:0x0177, B:155:0x01b8, B:156:0x01c0, B:158:0x01c6, B:160:0x01a8, B:164:0x0095, B:166:0x00a3, B:169:0x01d2, B:170:0x01e7, B:172:0x01ed, B:175:0x01fa, B:177:0x0204, B:178:0x0213, B:179:0x0228, B:180:0x0218, B:182:0x022c, B:185:0x0242), top: B:2:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0160 A[Catch: Exception -> 0x008f, TryCatch #0 {Exception -> 0x008f, blocks: (B:9:0x0047, B:13:0x0390, B:15:0x0396, B:17:0x039e, B:18:0x03a1, B:24:0x03d9, B:26:0x03de, B:31:0x03ea, B:33:0x040b, B:36:0x0414, B:41:0x0466, B:43:0x047e, B:55:0x006c, B:57:0x02d0, B:59:0x024c, B:63:0x0275, B:65:0x027b, B:67:0x028a, B:68:0x0290, B:70:0x0298, B:77:0x0354, B:79:0x035a, B:84:0x0366, B:85:0x04b6, B:86:0x04cf, B:88:0x04d5, B:90:0x04dd, B:91:0x04e0, B:95:0x02a7, B:97:0x02b8, B:101:0x02db, B:115:0x0080, B:116:0x0089, B:118:0x00bf, B:121:0x00d5, B:123:0x00d9, B:125:0x00e8, B:126:0x00ee, B:128:0x00fc, B:129:0x0100, B:131:0x0105, B:136:0x0111, B:137:0x012f, B:139:0x0135, B:141:0x013d, B:142:0x0140, B:146:0x0149, B:149:0x0160, B:152:0x0173, B:154:0x0177, B:155:0x01b8, B:156:0x01c0, B:158:0x01c6, B:160:0x01a8, B:164:0x0095, B:166:0x00a3, B:169:0x01d2, B:170:0x01e7, B:172:0x01ed, B:175:0x01fa, B:177:0x0204, B:178:0x0213, B:179:0x0228, B:180:0x0218, B:182:0x022c, B:185:0x0242), top: B:2:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0396 A[Catch: Exception -> 0x008f, TryCatch #0 {Exception -> 0x008f, blocks: (B:9:0x0047, B:13:0x0390, B:15:0x0396, B:17:0x039e, B:18:0x03a1, B:24:0x03d9, B:26:0x03de, B:31:0x03ea, B:33:0x040b, B:36:0x0414, B:41:0x0466, B:43:0x047e, B:55:0x006c, B:57:0x02d0, B:59:0x024c, B:63:0x0275, B:65:0x027b, B:67:0x028a, B:68:0x0290, B:70:0x0298, B:77:0x0354, B:79:0x035a, B:84:0x0366, B:85:0x04b6, B:86:0x04cf, B:88:0x04d5, B:90:0x04dd, B:91:0x04e0, B:95:0x02a7, B:97:0x02b8, B:101:0x02db, B:115:0x0080, B:116:0x0089, B:118:0x00bf, B:121:0x00d5, B:123:0x00d9, B:125:0x00e8, B:126:0x00ee, B:128:0x00fc, B:129:0x0100, B:131:0x0105, B:136:0x0111, B:137:0x012f, B:139:0x0135, B:141:0x013d, B:142:0x0140, B:146:0x0149, B:149:0x0160, B:152:0x0173, B:154:0x0177, B:155:0x01b8, B:156:0x01c0, B:158:0x01c6, B:160:0x01a8, B:164:0x0095, B:166:0x00a3, B:169:0x01d2, B:170:0x01e7, B:172:0x01ed, B:175:0x01fa, B:177:0x0204, B:178:0x0213, B:179:0x0228, B:180:0x0218, B:182:0x022c, B:185:0x0242), top: B:2:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x03ea A[Catch: Exception -> 0x008f, TryCatch #0 {Exception -> 0x008f, blocks: (B:9:0x0047, B:13:0x0390, B:15:0x0396, B:17:0x039e, B:18:0x03a1, B:24:0x03d9, B:26:0x03de, B:31:0x03ea, B:33:0x040b, B:36:0x0414, B:41:0x0466, B:43:0x047e, B:55:0x006c, B:57:0x02d0, B:59:0x024c, B:63:0x0275, B:65:0x027b, B:67:0x028a, B:68:0x0290, B:70:0x0298, B:77:0x0354, B:79:0x035a, B:84:0x0366, B:85:0x04b6, B:86:0x04cf, B:88:0x04d5, B:90:0x04dd, B:91:0x04e0, B:95:0x02a7, B:97:0x02b8, B:101:0x02db, B:115:0x0080, B:116:0x0089, B:118:0x00bf, B:121:0x00d5, B:123:0x00d9, B:125:0x00e8, B:126:0x00ee, B:128:0x00fc, B:129:0x0100, B:131:0x0105, B:136:0x0111, B:137:0x012f, B:139:0x0135, B:141:0x013d, B:142:0x0140, B:146:0x0149, B:149:0x0160, B:152:0x0173, B:154:0x0177, B:155:0x01b8, B:156:0x01c0, B:158:0x01c6, B:160:0x01a8, B:164:0x0095, B:166:0x00a3, B:169:0x01d2, B:170:0x01e7, B:172:0x01ed, B:175:0x01fa, B:177:0x0204, B:178:0x0213, B:179:0x0228, B:180:0x0218, B:182:0x022c, B:185:0x0242), top: B:2:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x047e A[Catch: Exception -> 0x008f, TryCatch #0 {Exception -> 0x008f, blocks: (B:9:0x0047, B:13:0x0390, B:15:0x0396, B:17:0x039e, B:18:0x03a1, B:24:0x03d9, B:26:0x03de, B:31:0x03ea, B:33:0x040b, B:36:0x0414, B:41:0x0466, B:43:0x047e, B:55:0x006c, B:57:0x02d0, B:59:0x024c, B:63:0x0275, B:65:0x027b, B:67:0x028a, B:68:0x0290, B:70:0x0298, B:77:0x0354, B:79:0x035a, B:84:0x0366, B:85:0x04b6, B:86:0x04cf, B:88:0x04d5, B:90:0x04dd, B:91:0x04e0, B:95:0x02a7, B:97:0x02b8, B:101:0x02db, B:115:0x0080, B:116:0x0089, B:118:0x00bf, B:121:0x00d5, B:123:0x00d9, B:125:0x00e8, B:126:0x00ee, B:128:0x00fc, B:129:0x0100, B:131:0x0105, B:136:0x0111, B:137:0x012f, B:139:0x0135, B:141:0x013d, B:142:0x0140, B:146:0x0149, B:149:0x0160, B:152:0x0173, B:154:0x0177, B:155:0x01b8, B:156:0x01c0, B:158:0x01c6, B:160:0x01a8, B:164:0x0095, B:166:0x00a3, B:169:0x01d2, B:170:0x01e7, B:172:0x01ed, B:175:0x01fa, B:177:0x0204, B:178:0x0213, B:179:0x0228, B:180:0x0218, B:182:0x022c, B:185:0x0242), top: B:2:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x024c A[Catch: Exception -> 0x008f, TryCatch #0 {Exception -> 0x008f, blocks: (B:9:0x0047, B:13:0x0390, B:15:0x0396, B:17:0x039e, B:18:0x03a1, B:24:0x03d9, B:26:0x03de, B:31:0x03ea, B:33:0x040b, B:36:0x0414, B:41:0x0466, B:43:0x047e, B:55:0x006c, B:57:0x02d0, B:59:0x024c, B:63:0x0275, B:65:0x027b, B:67:0x028a, B:68:0x0290, B:70:0x0298, B:77:0x0354, B:79:0x035a, B:84:0x0366, B:85:0x04b6, B:86:0x04cf, B:88:0x04d5, B:90:0x04dd, B:91:0x04e0, B:95:0x02a7, B:97:0x02b8, B:101:0x02db, B:115:0x0080, B:116:0x0089, B:118:0x00bf, B:121:0x00d5, B:123:0x00d9, B:125:0x00e8, B:126:0x00ee, B:128:0x00fc, B:129:0x0100, B:131:0x0105, B:136:0x0111, B:137:0x012f, B:139:0x0135, B:141:0x013d, B:142:0x0140, B:146:0x0149, B:149:0x0160, B:152:0x0173, B:154:0x0177, B:155:0x01b8, B:156:0x01c0, B:158:0x01c6, B:160:0x01a8, B:164:0x0095, B:166:0x00a3, B:169:0x01d2, B:170:0x01e7, B:172:0x01ed, B:175:0x01fa, B:177:0x0204, B:178:0x0213, B:179:0x0228, B:180:0x0218, B:182:0x022c, B:185:0x0242), top: B:2:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x027b A[Catch: Exception -> 0x008f, TryCatch #0 {Exception -> 0x008f, blocks: (B:9:0x0047, B:13:0x0390, B:15:0x0396, B:17:0x039e, B:18:0x03a1, B:24:0x03d9, B:26:0x03de, B:31:0x03ea, B:33:0x040b, B:36:0x0414, B:41:0x0466, B:43:0x047e, B:55:0x006c, B:57:0x02d0, B:59:0x024c, B:63:0x0275, B:65:0x027b, B:67:0x028a, B:68:0x0290, B:70:0x0298, B:77:0x0354, B:79:0x035a, B:84:0x0366, B:85:0x04b6, B:86:0x04cf, B:88:0x04d5, B:90:0x04dd, B:91:0x04e0, B:95:0x02a7, B:97:0x02b8, B:101:0x02db, B:115:0x0080, B:116:0x0089, B:118:0x00bf, B:121:0x00d5, B:123:0x00d9, B:125:0x00e8, B:126:0x00ee, B:128:0x00fc, B:129:0x0100, B:131:0x0105, B:136:0x0111, B:137:0x012f, B:139:0x0135, B:141:0x013d, B:142:0x0140, B:146:0x0149, B:149:0x0160, B:152:0x0173, B:154:0x0177, B:155:0x01b8, B:156:0x01c0, B:158:0x01c6, B:160:0x01a8, B:164:0x0095, B:166:0x00a3, B:169:0x01d2, B:170:0x01e7, B:172:0x01ed, B:175:0x01fa, B:177:0x0204, B:178:0x0213, B:179:0x0228, B:180:0x0218, B:182:0x022c, B:185:0x0242), top: B:2:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x035a A[Catch: Exception -> 0x008f, TryCatch #0 {Exception -> 0x008f, blocks: (B:9:0x0047, B:13:0x0390, B:15:0x0396, B:17:0x039e, B:18:0x03a1, B:24:0x03d9, B:26:0x03de, B:31:0x03ea, B:33:0x040b, B:36:0x0414, B:41:0x0466, B:43:0x047e, B:55:0x006c, B:57:0x02d0, B:59:0x024c, B:63:0x0275, B:65:0x027b, B:67:0x028a, B:68:0x0290, B:70:0x0298, B:77:0x0354, B:79:0x035a, B:84:0x0366, B:85:0x04b6, B:86:0x04cf, B:88:0x04d5, B:90:0x04dd, B:91:0x04e0, B:95:0x02a7, B:97:0x02b8, B:101:0x02db, B:115:0x0080, B:116:0x0089, B:118:0x00bf, B:121:0x00d5, B:123:0x00d9, B:125:0x00e8, B:126:0x00ee, B:128:0x00fc, B:129:0x0100, B:131:0x0105, B:136:0x0111, B:137:0x012f, B:139:0x0135, B:141:0x013d, B:142:0x0140, B:146:0x0149, B:149:0x0160, B:152:0x0173, B:154:0x0177, B:155:0x01b8, B:156:0x01c0, B:158:0x01c6, B:160:0x01a8, B:164:0x0095, B:166:0x00a3, B:169:0x01d2, B:170:0x01e7, B:172:0x01ed, B:175:0x01fa, B:177:0x0204, B:178:0x0213, B:179:0x0228, B:180:0x0218, B:182:0x022c, B:185:0x0242), top: B:2:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0366 A[Catch: Exception -> 0x008f, TryCatch #0 {Exception -> 0x008f, blocks: (B:9:0x0047, B:13:0x0390, B:15:0x0396, B:17:0x039e, B:18:0x03a1, B:24:0x03d9, B:26:0x03de, B:31:0x03ea, B:33:0x040b, B:36:0x0414, B:41:0x0466, B:43:0x047e, B:55:0x006c, B:57:0x02d0, B:59:0x024c, B:63:0x0275, B:65:0x027b, B:67:0x028a, B:68:0x0290, B:70:0x0298, B:77:0x0354, B:79:0x035a, B:84:0x0366, B:85:0x04b6, B:86:0x04cf, B:88:0x04d5, B:90:0x04dd, B:91:0x04e0, B:95:0x02a7, B:97:0x02b8, B:101:0x02db, B:115:0x0080, B:116:0x0089, B:118:0x00bf, B:121:0x00d5, B:123:0x00d9, B:125:0x00e8, B:126:0x00ee, B:128:0x00fc, B:129:0x0100, B:131:0x0105, B:136:0x0111, B:137:0x012f, B:139:0x0135, B:141:0x013d, B:142:0x0140, B:146:0x0149, B:149:0x0160, B:152:0x0173, B:154:0x0177, B:155:0x01b8, B:156:0x01c0, B:158:0x01c6, B:160:0x01a8, B:164:0x0095, B:166:0x00a3, B:169:0x01d2, B:170:0x01e7, B:172:0x01ed, B:175:0x01fa, B:177:0x0204, B:178:0x0213, B:179:0x0228, B:180:0x0218, B:182:0x022c, B:185:0x0242), top: B:2:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x04b6 A[Catch: Exception -> 0x008f, TryCatch #0 {Exception -> 0x008f, blocks: (B:9:0x0047, B:13:0x0390, B:15:0x0396, B:17:0x039e, B:18:0x03a1, B:24:0x03d9, B:26:0x03de, B:31:0x03ea, B:33:0x040b, B:36:0x0414, B:41:0x0466, B:43:0x047e, B:55:0x006c, B:57:0x02d0, B:59:0x024c, B:63:0x0275, B:65:0x027b, B:67:0x028a, B:68:0x0290, B:70:0x0298, B:77:0x0354, B:79:0x035a, B:84:0x0366, B:85:0x04b6, B:86:0x04cf, B:88:0x04d5, B:90:0x04dd, B:91:0x04e0, B:95:0x02a7, B:97:0x02b8, B:101:0x02db, B:115:0x0080, B:116:0x0089, B:118:0x00bf, B:121:0x00d5, B:123:0x00d9, B:125:0x00e8, B:126:0x00ee, B:128:0x00fc, B:129:0x0100, B:131:0x0105, B:136:0x0111, B:137:0x012f, B:139:0x0135, B:141:0x013d, B:142:0x0140, B:146:0x0149, B:149:0x0160, B:152:0x0173, B:154:0x0177, B:155:0x01b8, B:156:0x01c0, B:158:0x01c6, B:160:0x01a8, B:164:0x0095, B:166:0x00a3, B:169:0x01d2, B:170:0x01e7, B:172:0x01ed, B:175:0x01fa, B:177:0x0204, B:178:0x0213, B:179:0x0228, B:180:0x0218, B:182:0x022c, B:185:0x0242), top: B:2:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02a7 A[Catch: Exception -> 0x008f, TryCatch #0 {Exception -> 0x008f, blocks: (B:9:0x0047, B:13:0x0390, B:15:0x0396, B:17:0x039e, B:18:0x03a1, B:24:0x03d9, B:26:0x03de, B:31:0x03ea, B:33:0x040b, B:36:0x0414, B:41:0x0466, B:43:0x047e, B:55:0x006c, B:57:0x02d0, B:59:0x024c, B:63:0x0275, B:65:0x027b, B:67:0x028a, B:68:0x0290, B:70:0x0298, B:77:0x0354, B:79:0x035a, B:84:0x0366, B:85:0x04b6, B:86:0x04cf, B:88:0x04d5, B:90:0x04dd, B:91:0x04e0, B:95:0x02a7, B:97:0x02b8, B:101:0x02db, B:115:0x0080, B:116:0x0089, B:118:0x00bf, B:121:0x00d5, B:123:0x00d9, B:125:0x00e8, B:126:0x00ee, B:128:0x00fc, B:129:0x0100, B:131:0x0105, B:136:0x0111, B:137:0x012f, B:139:0x0135, B:141:0x013d, B:142:0x0140, B:146:0x0149, B:149:0x0160, B:152:0x0173, B:154:0x0177, B:155:0x01b8, B:156:0x01c0, B:158:0x01c6, B:160:0x01a8, B:164:0x0095, B:166:0x00a3, B:169:0x01d2, B:170:0x01e7, B:172:0x01ed, B:175:0x01fa, B:177:0x0204, B:178:0x0213, B:179:0x0228, B:180:0x0218, B:182:0x022c, B:185:0x0242), top: B:2:0x0017 }] */
    /* JADX WARN: Type inference failed for: r10v28, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v31, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x045d -> B:11:0x0462). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:98:0x02ce -> B:56:0x02d0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ArrayList arrayList;
        JSONObject jSONObject;
        Ref.ObjectRef objectRef;
        ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1 artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;
        int i;
        int i2;
        Object withContext;
        boolean z;
        String normalizeFilePath;
        String buildFileUrl;
        JSONObject jSONObject2;
        boolean z2;
        Map map;
        boolean z3;
        String str;
        int i3;
        FileDownloadHelper fileDownloadHelper;
        ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1 artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$12;
        Ref.ObjectRef objectRef2;
        Iterator it;
        Context context;
        List<SimpleDraweeView> list;
        String str2;
        String str3;
        List list2;
        ArrayList arrayList2;
        JSONObject jSONObject3;
        Object obj2;
        int i4;
        HttpDataResult.Success success;
        boolean z4;
        boolean z5;
        ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1 artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13 = this;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.label;
        String str4 = "messageId";
        String str5 = "conversationId";
        String str6 = "chatSessionId";
        try {
        } catch (Exception e) {
            FLogger.INSTANCE.e("AgentBlock", "loadImagesAsync error", e);
        }
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            if (Intrinsics.areEqual(artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.$cliType, CliType.REMOTE.getValue())) {
                artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.label = 1;
                withContext = BuildersKt.withContext(Dispatchers.getIO(), new C0684x4a730535(artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.$chatSessionId, null), (Continuation) artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13);
                if (withContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                List<FileDiffInfo> list3 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.$files;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                Iterator it2 = list3.iterator();
                while (it2.hasNext()) {
                    String filePath = ((FileDiffInfo) it2.next()).getFilePath();
                    if (filePath == null) {
                        filePath = "";
                    }
                    arrayList3.add((StringsKt.startsWith$default(filePath, "/", false, 2, (Object) null) ? new StringBuilder().append("files").append(filePath) : new StringBuilder().append("files/").append(filePath)).toString());
                }
                arrayList = arrayList3;
                jSONObject = new JSONObject();
                String str7 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.$chatSessionId;
                String str8 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.$conversationId;
                String str9 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.$messageId;
                try {
                    jSONObject.put("chatSessionId", str7);
                    jSONObject.put("conversationId", str8);
                    jSONObject.put("messageId", str9);
                } catch (Throwable unused) {
                }
                objectRef = new Ref.ObjectRef();
                artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13;
                i = 4;
                i2 = 0;
                if (i2 < i) {
                }
            }
        } else if (i5 == 1) {
            ResultKt.throwOnFailure(obj);
            withContext = obj;
        } else if (i5 == 2) {
            i4 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.I$0;
            objectRef = (Ref.ObjectRef) artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.L$2;
            jSONObject3 = (JSONObject) artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.L$1;
            ?? r10 = (List) artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.L$0;
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
            arrayList2 = r10;
            artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13;
            success = (HttpDataResult) obj2;
            if (success instanceof HttpDataResult.Success) {
            }
            jSONObject2 = jSONObject3;
            arrayList = arrayList2;
            map = (Map) objectRef.element;
            if (map != null) {
            }
            z3 = z2;
            if (!z3) {
            }
        } else {
            if (i5 != 3) {
                if (i5 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i6 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.I$0;
                it = (Iterator) artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.L$8;
                context = (Context) artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.L$7;
                String str10 = (String) artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.L$6;
                str = (String) artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.L$5;
                str3 = (String) artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.L$4;
                list = (List) artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.L$3;
                fileDownloadHelper = (FileDownloadHelper) artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.L$2;
                objectRef2 = (Ref.ObjectRef) artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.L$1;
                list2 = (List) artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.L$0;
                ResultKt.throwOnFailure(obj);
                String str11 = "messageId";
                String str12 = "conversationId";
                String str13 = "chatSessionId";
                String str14 = str10;
                i3 = i6;
                artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$12 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13;
                String str15 = str14;
                str2 = str15;
                str6 = str13;
                str4 = str11;
                str5 = str12;
                if (it.hasNext()) {
                    Object next = it.next();
                    int i7 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Object obj3 = coroutine_suspended;
                    String str16 = (String) list2.get(i3);
                    String str17 = (String) ((Map) objectRef2.element).get(str16);
                    Iterator it3 = it;
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put(str6, str3);
                    jSONObject4.put(str5, str);
                    jSONObject4.put(str4, str2);
                    str11 = str4;
                    jSONObject4.put("path", str16);
                    jSONObject4.put(IWeixinService.ResponseConstants.URL, str17);
                    String str18 = str17;
                    if (str18 != null && str18.length() != 0) {
                        z5 = false;
                        if (z5) {
                            ArtifactFileUrlHelper.INSTANCE.reportApm("fetch_img_url", "local", "success", "", jSONObject4);
                            String str19 = str2;
                            str12 = str5;
                            str13 = str6;
                            if (!StringsKt.startsWith$default(str17, "content://", false, 2, (Object) null) && !StringsKt.startsWith$default(str17, "file://", false, 2, (Object) null)) {
                                CoroutineContext io = Dispatchers.getIO();
                                ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1 artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1 = new ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1(fileDownloadHelper, context, str17, str, str16, jSONObject4, list, i3, null);
                                artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$12.L$0 = list2;
                                artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$12.L$1 = objectRef2;
                                artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$12.L$2 = fileDownloadHelper;
                                artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$12.L$3 = list;
                                artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$12.L$4 = str3;
                                artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$12.L$5 = str;
                                artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$12.L$6 = str19;
                                artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$12.L$7 = context;
                                artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$12.L$8 = it3;
                                artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$12.I$0 = i7;
                                artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$12.label = 4;
                                if (BuildersKt.withContext(io, artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1$3$1, artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$12) == obj3) {
                                    return obj3;
                                }
                                coroutine_suspended = obj3;
                                str14 = str19;
                                it = it3;
                                artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$12;
                                i6 = i7;
                                i3 = i6;
                                artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$12 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13;
                                String str152 = str14;
                            }
                            list.get(i3).setImageURI(Uri.parse(str17));
                            str152 = str19;
                            it = it3;
                            coroutine_suspended = obj3;
                            i3 = i7;
                        } else {
                            str152 = str2;
                            str12 = str5;
                            str13 = str6;
                            ArtifactFileUrlHelper.INSTANCE.reportApm("download_img", "local", "failed", "url_map_is_null", jSONObject4);
                            list.get(i3).setImageResource(C0591R.drawable.trae_ic_image_break);
                            it = it3;
                            coroutine_suspended = obj3;
                            i3 = i7;
                        }
                        str2 = str152;
                        str6 = str13;
                        str4 = str11;
                        str5 = str12;
                        if (it.hasNext()) {
                        }
                    }
                    z5 = true;
                    if (z5) {
                    }
                    str2 = str152;
                    str6 = str13;
                    str4 = str11;
                    str5 = str12;
                    if (it.hasNext()) {
                    }
                }
                return Unit.INSTANCE;
            }
            i4 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.I$0;
            objectRef = (Ref.ObjectRef) artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.L$2;
            jSONObject3 = (JSONObject) artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.L$1;
            ?? r102 = (List) artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.L$0;
            ResultKt.throwOnFailure(obj);
            ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1 artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$14 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13;
            ArrayList arrayList4 = r102;
            i2 = i4 + 1;
            jSONObject = jSONObject3;
            arrayList = arrayList4;
            i = 4;
            artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$14;
            if (i2 < i) {
                artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1.L$0 = arrayList;
                artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1.L$1 = jSONObject;
                artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1.L$2 = objectRef;
                artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1.I$0 = i2;
                artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1.label = 2;
                obj2 = BuildersKt.withContext(Dispatchers.getIO(), new C0685x4a730536(arrayList, artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1.$conversationId, artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1.$messageId, null), (Continuation) artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                arrayList2 = arrayList;
                jSONObject3 = jSONObject;
                i4 = i2;
                success = (HttpDataResult) obj2;
                if (success instanceof HttpDataResult.Success) {
                    GetDownloadUrlData getDownloadUrlData = (GetDownloadUrlData) success.getBizResp().getData();
                    objectRef.element = getDownloadUrlData != null ? getDownloadUrlData.getUrlMap() : null;
                    Map map2 = (Map) objectRef.element;
                    if (map2 != null && !map2.isEmpty()) {
                        z4 = false;
                        if (!z4) {
                            z2 = true;
                        } else if (success.getBizResp().getCode() == 202) {
                            artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1.L$0 = arrayList2;
                            artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1.L$1 = jSONObject3;
                            artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1.L$2 = objectRef;
                            artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1.I$0 = i4;
                            artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1.label = 3;
                            if (DelayKt.delay(50L, (Continuation) artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$14 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;
                            arrayList4 = arrayList2;
                            i2 = i4 + 1;
                            jSONObject = jSONObject3;
                            arrayList = arrayList4;
                            i = 4;
                            artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$14;
                            if (i2 < i) {
                                z2 = true;
                                jSONObject2 = jSONObject;
                                map = (Map) objectRef.element;
                                if (map != null && !map.isEmpty()) {
                                    z3 = false;
                                    if (!z3) {
                                        FileDownloadHelper fileDownloadHelper2 = new FileDownloadHelper();
                                        List<FileDiffInfo> list4 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1.$files;
                                        List<SimpleDraweeView> list5 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1.$imageViews;
                                        String str20 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1.$chatSessionId;
                                        str = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1.$conversationId;
                                        String str21 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1.$messageId;
                                        Context context2 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1.$context;
                                        i3 = 0;
                                        ArtifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1 artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$15 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1;
                                        fileDownloadHelper = fileDownloadHelper2;
                                        artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$12 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$15;
                                        objectRef2 = objectRef;
                                        it = list4.iterator();
                                        context = context2;
                                        ArrayList arrayList5 = arrayList;
                                        list = list5;
                                        str2 = str21;
                                        str3 = str20;
                                        list2 = arrayList5;
                                        if (it.hasNext()) {
                                        }
                                        return Unit.INSTANCE;
                                    }
                                    ArtifactFileUrlHelper.INSTANCE.reportApm("download_img", "local", "failed", "url_map_is_null", jSONObject2);
                                    List<FileDiffInfo> list6 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1.$files;
                                    List<SimpleDraweeView> list7 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$1.$imageViews;
                                    int i8 = 0;
                                    for (Object obj4 : list6) {
                                        int i9 = i8 + 1;
                                        if (i8 < 0) {
                                            CollectionsKt.throwIndexOverflow();
                                        }
                                        list7.get(i8).setImageResource(C0591R.drawable.trae_ic_image_break);
                                        i8 = i9;
                                    }
                                    return Unit.INSTANCE;
                                }
                                z3 = z2;
                                if (!z3) {
                                }
                            }
                        } else {
                            z2 = true;
                            ArtifactFileUrlHelper.INSTANCE.reportApm("fetch_img_url", "local", "failed", "code_" + success.getBizResp().getCode(), jSONObject3);
                        }
                    }
                    z4 = true;
                    if (!z4) {
                    }
                } else {
                    z2 = true;
                    try {
                        if (success instanceof HttpDataResult.Error) {
                            ArtifactFileUrlHelper.INSTANCE.reportApm("fetch_img_url", "local", "failed", ((HttpDataResult.Error) success).getCode() + '_' + ((HttpDataResult.Error) success).getMsg(), jSONObject3);
                        } else {
                            ArtifactFileUrlHelper.INSTANCE.reportApm("fetch_img_url", "local", "failed", "other", jSONObject3);
                        }
                    } catch (Throwable unused2) {
                    }
                }
                jSONObject2 = jSONObject3;
                arrayList = arrayList2;
                map = (Map) objectRef.element;
                if (map != null) {
                    z3 = false;
                    if (!z3) {
                    }
                }
                z3 = z2;
                if (!z3) {
                }
            }
        }
        HttpDataResult.Success success2 = (HttpDataResult) withContext;
        JSONObject jSONObject5 = new JSONObject();
        String str22 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.$chatSessionId;
        String str23 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.$conversationId;
        String str24 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.$messageId;
        jSONObject5.put("chatSessionId", str22);
        jSONObject5.put("conversationId", str23);
        jSONObject5.put("messageId", str24);
        if (success2 instanceof HttpDataResult.Success) {
            ChatSessionResponse chatSessionResponse = (ChatSessionResponse) success2.getBizResp().getData();
            String explorerUrl = chatSessionResponse != null ? chatSessionResponse.getExplorerUrl() : null;
            ChatSessionResponse chatSessionResponse2 = (ChatSessionResponse) success2.getBizResp().getData();
            String workspacePath = chatSessionResponse2 != null ? chatSessionResponse2.getWorkspacePath() : null;
            String str25 = explorerUrl;
            if (str25 != null && str25.length() != 0) {
                z = false;
                if (z) {
                    ArtifactFileUrlHelper.INSTANCE.reportApm("fetch_img_url", "remote", "success", "", jSONObject5);
                    List<FileDiffInfo> list8 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.$files;
                    ArtifactsRenderer artifactsRenderer = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.this$0;
                    List<SimpleDraweeView> list9 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.$imageViews;
                    int i10 = 0;
                    for (Object obj5 : list8) {
                        int i11 = i10 + 1;
                        if (i10 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        String filePath2 = ((FileDiffInfo) obj5).getFilePath();
                        if (filePath2 == null) {
                            filePath2 = "";
                        }
                        normalizeFilePath = artifactsRenderer.normalizeFilePath(filePath2, workspacePath);
                        buildFileUrl = artifactsRenderer.buildFileUrl(explorerUrl, normalizeFilePath);
                        list9.get(i10).setImageURI(Uri.parse(buildFileUrl));
                        i10 = i11;
                    }
                } else {
                    ArtifactFileUrlHelper.INSTANCE.reportApm("fetch_img_url", "remote", "failed", "url_is_null", jSONObject5);
                }
            }
            z = true;
            if (z) {
            }
        } else {
            if (success2 instanceof HttpDataResult.Error) {
                ArtifactFileUrlHelper.INSTANCE.reportApm("fetch_img_url", "remote", "failed", ((HttpDataResult.Error) success2).getCode() + '_' + ((HttpDataResult.Error) success2).getMsg(), jSONObject5);
            } else {
                ArtifactFileUrlHelper.INSTANCE.reportApm("fetch_img_url", "remote", "failed", "other", jSONObject5);
            }
            Iterator it4 = artifactsRenderer$loadImagesAsync$1$onViewAttachedToWindow$13.$imageViews.iterator();
            while (it4.hasNext()) {
                ((SimpleDraweeView) it4.next()).setImageResource(C0591R.drawable.trae_ic_image_break);
            }
        }
        return Unit.INSTANCE;
    }
}
