package com.larus.business.markdown.api.model;

import com.facebook.common.util.ByteConstants;
import com.larus.business.markdown.api.customlink.ICustomLinkHandler;
import com.larus.business.markdown.api.model.latex.LatexSingleConfig;
import com.lynx.tasm.DefaultLogicExecutor;
import com.lynx.tasm.animation.AnimationConstant;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.core.spans.ListMarginInfo;
import io.noties.markwon.html.TagHandler;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Node;

/* compiled from: CustomMarkDownInfo.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\bp\b\u0086\b\u0018\u00002\u00020\u0001Bù\u0003\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012'\b\u0002\u0010\u001a\u001a!\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001b\u0012'\b\u0002\u0010 \u001a!\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001b\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u0006\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u000100\u0012\n\b\u0003\u00101\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000103\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u00107\u001a\u000208\u0012\b\b\u0002\u00109\u001a\u00020\u000b\u0012\u0016\b\u0003\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0011\u0018\u00010;\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=\u0012\b\b\u0002\u0010>\u001a\u00020\u000b¢\u0006\u0002\u0010?J\n\u0010\u0082\u0001\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010HJ\n\u0010\u0084\u0001\u001a\u00020\u0011HÆ\u0003J\u0011\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010HJ\n\u0010\u0086\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u0011\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\\J\u0011\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\\J)\u0010\u008b\u0001\u001a!\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001bHÆ\u0003J)\u0010\u008c\u0001\u001a!\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001bHÆ\u0003J\u0011\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\\J\f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\"HÆ\u0003J\f\u0010\u008f\u0001\u001a\u0004\u0018\u00010$HÆ\u0003J\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010&HÆ\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010(HÆ\u0003J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010*HÆ\u0003J\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010,HÆ\u0003J\u0012\u0010\u0094\u0001\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0095\u0001\u001a\u0004\u0018\u000100HÆ\u0003J\u0011\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\\J\f\u0010\u0097\u0001\u001a\u0004\u0018\u000103HÆ\u0003J\u0010\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u0011\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010CJ\u0011\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010CJ\u0011\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010CJ\n\u0010\u009c\u0001\u001a\u000208HÆ\u0003J\n\u0010\u009d\u0001\u001a\u00020\u000bHÆ\u0003J\u0018\u0010\u009e\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0011\u0018\u00010;HÆ\u0003J\f\u0010\u009f\u0001\u001a\u0004\u0018\u00010=HÆ\u0003J\n\u0010 \u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010¡\u0001\u001a\u00020\tHÆ\u0003J\n\u0010¢\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010£\u0001\u001a\u00020\u000bHÆ\u0003J\u0011\u0010¤\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\\J\n\u0010¥\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¦\u0001\u001a\u00020\u0003HÆ\u0003J\u0084\u0004\u0010§\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032'\b\u0002\u0010\u001a\u001a!\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001b2'\b\u0002\u0010 \u001a!\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u00062\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0003\u00101\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020\u000b2\u0016\b\u0003\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0011\u0018\u00010;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\b\b\u0002\u0010>\u001a\u00020\u000bHÆ\u0001¢\u0006\u0003\u0010¨\u0001J\u0015\u0010©\u0001\u001a\u00020\u000b2\t\u0010ª\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010«\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010¬\u0001\u001a\u00020\tHÖ\u0001R\u0011\u00109\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0015\u00105\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010D\u001a\u0004\bB\u0010CR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010I\u001a\u0004\bG\u0010HR\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0013\u0010%\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u001c\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bR\u0010O\u001a\u0004\bS\u0010TR\u0019\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0015\u00104\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010D\u001a\u0004\bW\u0010CR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bX\u0010TR\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bY\u0010O\u001a\u0004\bZ\u0010AR\u0015\u00101\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010]\u001a\u0004\b[\u0010\\R\u001f\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0011\u0018\u00010;¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b`\u0010VR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010]\u001a\u0004\ba\u0010\\R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bb\u0010TR\u0011\u00107\u001a\u000208¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010]\u001a\u0004\be\u0010\\R\u0013\u0010<\u001a\u0004\u0018\u00010=¢\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u0013\u0010/\u001a\u0004\u0018\u000100¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bj\u0010TR\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010]\u001a\u0004\bk\u0010\\R\u0013\u0010+\u001a\u0004\u0018\u00010,¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0013\u00102\u001a\u0004\u0018\u000103¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bp\u0010TR\u0011\u0010>\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bq\u0010AR\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010]\u001a\u0004\br\u0010\\R0\u0010\u001a\u001a!\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\bs\u0010tR0\u0010 \u001a!\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\bu\u0010tR\u0013\u0010)\u001a\u0004\u0018\u00010*¢\u0006\b\n\u0000\u001a\u0004\bv\u0010wR\u0015\u00106\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010D\u001a\u0004\bx\u0010CR\u0013\u0010'\u001a\u0004\u0018\u00010(¢\u0006\b\n\u0000\u001a\u0004\by\u0010zR\u001c\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b{\u0010O\u001a\u0004\b|\u0010}R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010I\u001a\u0004\b~\u0010HR\u0014\u0010#\u001a\u0004\u0018\u00010$¢\u0006\t\n\u0000\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0012\u0010\f\u001a\u00020\u000b¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010A¨\u0006\u00ad\u0001"}, d2 = {"Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "", "imgCornerRadius", "", "imgBgColor", "htmlTagHandlerList", "", "Lio/noties/markwon/html/TagHandler;", "codeCopyTitle", "", "enableCodeCopyButton", "", "useSubscribedColor", "linkColor", "codeTitleSize", "listItemColor", "blankLineMulti", "", "tableTextSize", "textLineMulti", "diffDp", "minImgWidthHeight", "bgListItemConfig", "Lcom/larus/business/markdown/api/model/BgListItemConfig;", "paragraphSpaceHeight", "listItemSpaceHeight", "paragraphSpaceHeightProvider", "Lkotlin/Function1;", "Lorg/commonmark/node/Node;", "Lkotlin/ParameterName;", DefaultLogicExecutor.GLOBAL_EVENT_NAME, "node", "paragraphTopSpaceHeightProvider", "blockQuoteConfig", "Lcom/larus/business/markdown/api/model/BlockQuoteConfig;", "thematicBreakConfig", "Lcom/larus/business/markdown/api/model/ThematicBreakConfig;", "codeBlockConfig", "Lcom/larus/business/markdown/api/model/CodeBlockConfig;", "tableConfig", "Lcom/larus/business/markdown/api/model/TableConfig;", "phoneNumberConfig", "Lcom/larus/business/markdown/api/model/PhoneNumberConfig;", "listMarginInfo", "Lio/noties/markwon/core/spans/ListMarginInfo;", "customListPlugin", "Lio/noties/markwon/AbstractMarkwonPlugin;", "listConfig", "Lcom/larus/business/markdown/api/model/ListConfig;", "headingColor", "listStyle", "Lcom/larus/business/markdown/api/model/ListStyle;", "darkMode", "allowParentInterceptTouchWhenOverScroll", "splitCodeBlock", "latexSingleConfig", "Lcom/larus/business/markdown/api/model/latex/LatexSingleConfig;", "allowNonClosedTags", "headingLevelTextSizeMap", "", "linkHandler", "Lcom/larus/business/markdown/api/customlink/ICustomLinkHandler;", "noBlockSpace", "(ILjava/lang/Integer;Ljava/util/List;Ljava/lang/String;ZZLjava/lang/Integer;IILjava/lang/Float;FLjava/lang/Float;IILcom/larus/business/markdown/api/model/BgListItemConfig;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcom/larus/business/markdown/api/model/BlockQuoteConfig;Lcom/larus/business/markdown/api/model/ThematicBreakConfig;Lcom/larus/business/markdown/api/model/CodeBlockConfig;Lcom/larus/business/markdown/api/model/TableConfig;Lcom/larus/business/markdown/api/model/PhoneNumberConfig;Lio/noties/markwon/core/spans/ListMarginInfo;Ljava/util/List;Lcom/larus/business/markdown/api/model/ListConfig;Ljava/lang/Integer;Lcom/larus/business/markdown/api/model/ListStyle;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/larus/business/markdown/api/model/latex/LatexSingleConfig;ZLjava/util/Map;Lcom/larus/business/markdown/api/customlink/ICustomLinkHandler;Z)V", "getAllowNonClosedTags", "()Z", "getAllowParentInterceptTouchWhenOverScroll", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBgListItemConfig", "()Lcom/larus/business/markdown/api/model/BgListItemConfig;", "getBlankLineMulti", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getBlockQuoteConfig", "()Lcom/larus/business/markdown/api/model/BlockQuoteConfig;", "getCodeBlockConfig", "()Lcom/larus/business/markdown/api/model/CodeBlockConfig;", "getCodeCopyTitle$annotations", "()V", "getCodeCopyTitle", "()Ljava/lang/String;", "getCodeTitleSize$annotations", "getCodeTitleSize", "()I", "getCustomListPlugin", "()Ljava/util/List;", "getDarkMode", "getDiffDp", "getEnableCodeCopyButton$annotations", "getEnableCodeCopyButton", "getHeadingColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeadingLevelTextSizeMap", "()Ljava/util/Map;", "getHtmlTagHandlerList", "getImgBgColor", "getImgCornerRadius", "getLatexSingleConfig", "()Lcom/larus/business/markdown/api/model/latex/LatexSingleConfig;", "getLinkColor", "getLinkHandler", "()Lcom/larus/business/markdown/api/customlink/ICustomLinkHandler;", "getListConfig", "()Lcom/larus/business/markdown/api/model/ListConfig;", "getListItemColor", "getListItemSpaceHeight", "getListMarginInfo", "()Lio/noties/markwon/core/spans/ListMarginInfo;", "getListStyle", "()Lcom/larus/business/markdown/api/model/ListStyle;", "getMinImgWidthHeight", "getNoBlockSpace", "getParagraphSpaceHeight", "getParagraphSpaceHeightProvider", "()Lkotlin/jvm/functions/Function1;", "getParagraphTopSpaceHeightProvider", "getPhoneNumberConfig", "()Lcom/larus/business/markdown/api/model/PhoneNumberConfig;", "getSplitCodeBlock", "getTableConfig", "()Lcom/larus/business/markdown/api/model/TableConfig;", "getTableTextSize$annotations", "getTableTextSize", "()F", "getTextLineMulti", "getThematicBreakConfig", "()Lcom/larus/business/markdown/api/model/ThematicBreakConfig;", "getUseSubscribedColor", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/Integer;Ljava/util/List;Ljava/lang/String;ZZLjava/lang/Integer;IILjava/lang/Float;FLjava/lang/Float;IILcom/larus/business/markdown/api/model/BgListItemConfig;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcom/larus/business/markdown/api/model/BlockQuoteConfig;Lcom/larus/business/markdown/api/model/ThematicBreakConfig;Lcom/larus/business/markdown/api/model/CodeBlockConfig;Lcom/larus/business/markdown/api/model/TableConfig;Lcom/larus/business/markdown/api/model/PhoneNumberConfig;Lio/noties/markwon/core/spans/ListMarginInfo;Ljava/util/List;Lcom/larus/business/markdown/api/model/ListConfig;Ljava/lang/Integer;Lcom/larus/business/markdown/api/model/ListStyle;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/larus/business/markdown/api/model/latex/LatexSingleConfig;ZLjava/util/Map;Lcom/larus/business/markdown/api/customlink/ICustomLinkHandler;Z)Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "equals", "other", "hashCode", "toString", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final /* data */ class CustomMarkDownInfo {
    private final boolean allowNonClosedTags;
    private final Boolean allowParentInterceptTouchWhenOverScroll;
    private final BgListItemConfig bgListItemConfig;
    private final Float blankLineMulti;
    private final BlockQuoteConfig blockQuoteConfig;
    private final CodeBlockConfig codeBlockConfig;
    private final String codeCopyTitle;
    private final int codeTitleSize;
    private final List<AbstractMarkwonPlugin> customListPlugin;
    private final Boolean darkMode;
    private final int diffDp;
    private final boolean enableCodeCopyButton;
    private final Integer headingColor;
    private final Map<Integer, Float> headingLevelTextSizeMap;
    private final List<TagHandler> htmlTagHandlerList;
    private final Integer imgBgColor;
    private final int imgCornerRadius;
    private final LatexSingleConfig latexSingleConfig;
    private final Integer linkColor;
    private final ICustomLinkHandler linkHandler;
    private final ListConfig listConfig;
    private final int listItemColor;
    private final Integer listItemSpaceHeight;
    private final ListMarginInfo listMarginInfo;
    private final ListStyle listStyle;
    private final int minImgWidthHeight;
    private final boolean noBlockSpace;
    private final Integer paragraphSpaceHeight;
    private final Function1<Node, Integer> paragraphSpaceHeightProvider;
    private final Function1<Node, Integer> paragraphTopSpaceHeightProvider;
    private final PhoneNumberConfig phoneNumberConfig;
    private final Boolean splitCodeBlock;
    private final TableConfig tableConfig;
    private final float tableTextSize;
    private final Float textLineMulti;
    private final ThematicBreakConfig thematicBreakConfig;
    private final boolean useSubscribedColor;

    public CustomMarkDownInfo() {
        this(0, null, null, null, false, false, null, 0, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, -1, 31, null);
    }

    @Deprecated(message = "use CodeBlockConfig.codeCopyTitle instead")
    public static /* synthetic */ void getCodeCopyTitle$annotations() {
    }

    @Deprecated(message = "use CodeBlockConfig.codeTitleSize instead")
    public static /* synthetic */ void getCodeTitleSize$annotations() {
    }

    @Deprecated(message = "use CodeBlockConfig.enableCodeCopyButton instead")
    public static /* synthetic */ void getEnableCodeCopyButton$annotations() {
    }

    @Deprecated(message = "use TableConfig.tableTextSize instead")
    public static /* synthetic */ void getTableTextSize$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final int getImgCornerRadius() {
        return this.imgCornerRadius;
    }

    /* renamed from: component10, reason: from getter */
    public final Float getBlankLineMulti() {
        return this.blankLineMulti;
    }

    /* renamed from: component11, reason: from getter */
    public final float getTableTextSize() {
        return this.tableTextSize;
    }

    /* renamed from: component12, reason: from getter */
    public final Float getTextLineMulti() {
        return this.textLineMulti;
    }

    /* renamed from: component13, reason: from getter */
    public final int getDiffDp() {
        return this.diffDp;
    }

    /* renamed from: component14, reason: from getter */
    public final int getMinImgWidthHeight() {
        return this.minImgWidthHeight;
    }

    /* renamed from: component15, reason: from getter */
    public final BgListItemConfig getBgListItemConfig() {
        return this.bgListItemConfig;
    }

    /* renamed from: component16, reason: from getter */
    public final Integer getParagraphSpaceHeight() {
        return this.paragraphSpaceHeight;
    }

    /* renamed from: component17, reason: from getter */
    public final Integer getListItemSpaceHeight() {
        return this.listItemSpaceHeight;
    }

    public final Function1<Node, Integer> component18() {
        return this.paragraphSpaceHeightProvider;
    }

    public final Function1<Node, Integer> component19() {
        return this.paragraphTopSpaceHeightProvider;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getImgBgColor() {
        return this.imgBgColor;
    }

    /* renamed from: component20, reason: from getter */
    public final BlockQuoteConfig getBlockQuoteConfig() {
        return this.blockQuoteConfig;
    }

    /* renamed from: component21, reason: from getter */
    public final ThematicBreakConfig getThematicBreakConfig() {
        return this.thematicBreakConfig;
    }

    /* renamed from: component22, reason: from getter */
    public final CodeBlockConfig getCodeBlockConfig() {
        return this.codeBlockConfig;
    }

    /* renamed from: component23, reason: from getter */
    public final TableConfig getTableConfig() {
        return this.tableConfig;
    }

    /* renamed from: component24, reason: from getter */
    public final PhoneNumberConfig getPhoneNumberConfig() {
        return this.phoneNumberConfig;
    }

    /* renamed from: component25, reason: from getter */
    public final ListMarginInfo getListMarginInfo() {
        return this.listMarginInfo;
    }

    public final List<AbstractMarkwonPlugin> component26() {
        return this.customListPlugin;
    }

    /* renamed from: component27, reason: from getter */
    public final ListConfig getListConfig() {
        return this.listConfig;
    }

    /* renamed from: component28, reason: from getter */
    public final Integer getHeadingColor() {
        return this.headingColor;
    }

    /* renamed from: component29, reason: from getter */
    public final ListStyle getListStyle() {
        return this.listStyle;
    }

    public final List<TagHandler> component3() {
        return this.htmlTagHandlerList;
    }

    /* renamed from: component30, reason: from getter */
    public final Boolean getDarkMode() {
        return this.darkMode;
    }

    /* renamed from: component31, reason: from getter */
    public final Boolean getAllowParentInterceptTouchWhenOverScroll() {
        return this.allowParentInterceptTouchWhenOverScroll;
    }

    /* renamed from: component32, reason: from getter */
    public final Boolean getSplitCodeBlock() {
        return this.splitCodeBlock;
    }

    /* renamed from: component33, reason: from getter */
    public final LatexSingleConfig getLatexSingleConfig() {
        return this.latexSingleConfig;
    }

    /* renamed from: component34, reason: from getter */
    public final boolean getAllowNonClosedTags() {
        return this.allowNonClosedTags;
    }

    public final Map<Integer, Float> component35() {
        return this.headingLevelTextSizeMap;
    }

    /* renamed from: component36, reason: from getter */
    public final ICustomLinkHandler getLinkHandler() {
        return this.linkHandler;
    }

    /* renamed from: component37, reason: from getter */
    public final boolean getNoBlockSpace() {
        return this.noBlockSpace;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCodeCopyTitle() {
        return this.codeCopyTitle;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getEnableCodeCopyButton() {
        return this.enableCodeCopyButton;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getUseSubscribedColor() {
        return this.useSubscribedColor;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getLinkColor() {
        return this.linkColor;
    }

    /* renamed from: component8, reason: from getter */
    public final int getCodeTitleSize() {
        return this.codeTitleSize;
    }

    /* renamed from: component9, reason: from getter */
    public final int getListItemColor() {
        return this.listItemColor;
    }

    public final CustomMarkDownInfo copy(int imgCornerRadius, Integer imgBgColor, List<? extends TagHandler> htmlTagHandlerList, String codeCopyTitle, boolean enableCodeCopyButton, boolean useSubscribedColor, Integer linkColor, int codeTitleSize, int listItemColor, Float blankLineMulti, float tableTextSize, Float textLineMulti, int diffDp, int minImgWidthHeight, BgListItemConfig bgListItemConfig, Integer paragraphSpaceHeight, Integer listItemSpaceHeight, Function1<? super Node, Integer> paragraphSpaceHeightProvider, Function1<? super Node, Integer> paragraphTopSpaceHeightProvider, BlockQuoteConfig blockQuoteConfig, ThematicBreakConfig thematicBreakConfig, CodeBlockConfig codeBlockConfig, TableConfig tableConfig, PhoneNumberConfig phoneNumberConfig, ListMarginInfo listMarginInfo, List<? extends AbstractMarkwonPlugin> customListPlugin, ListConfig listConfig, Integer headingColor, ListStyle listStyle, Boolean darkMode, Boolean allowParentInterceptTouchWhenOverScroll, Boolean splitCodeBlock, LatexSingleConfig latexSingleConfig, boolean allowNonClosedTags, Map<Integer, Float> headingLevelTextSizeMap, ICustomLinkHandler linkHandler, boolean noBlockSpace) {
        Intrinsics.checkNotNullParameter(htmlTagHandlerList, "htmlTagHandlerList");
        Intrinsics.checkNotNullParameter(codeCopyTitle, "codeCopyTitle");
        Intrinsics.checkNotNullParameter(latexSingleConfig, "latexSingleConfig");
        return new CustomMarkDownInfo(imgCornerRadius, imgBgColor, htmlTagHandlerList, codeCopyTitle, enableCodeCopyButton, useSubscribedColor, linkColor, codeTitleSize, listItemColor, blankLineMulti, tableTextSize, textLineMulti, diffDp, minImgWidthHeight, bgListItemConfig, paragraphSpaceHeight, listItemSpaceHeight, paragraphSpaceHeightProvider, paragraphTopSpaceHeightProvider, blockQuoteConfig, thematicBreakConfig, codeBlockConfig, tableConfig, phoneNumberConfig, listMarginInfo, customListPlugin, listConfig, headingColor, listStyle, darkMode, allowParentInterceptTouchWhenOverScroll, splitCodeBlock, latexSingleConfig, allowNonClosedTags, headingLevelTextSizeMap, linkHandler, noBlockSpace);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomMarkDownInfo)) {
            return false;
        }
        CustomMarkDownInfo customMarkDownInfo = (CustomMarkDownInfo) other;
        return this.imgCornerRadius == customMarkDownInfo.imgCornerRadius && Intrinsics.areEqual(this.imgBgColor, customMarkDownInfo.imgBgColor) && Intrinsics.areEqual(this.htmlTagHandlerList, customMarkDownInfo.htmlTagHandlerList) && Intrinsics.areEqual(this.codeCopyTitle, customMarkDownInfo.codeCopyTitle) && this.enableCodeCopyButton == customMarkDownInfo.enableCodeCopyButton && this.useSubscribedColor == customMarkDownInfo.useSubscribedColor && Intrinsics.areEqual(this.linkColor, customMarkDownInfo.linkColor) && this.codeTitleSize == customMarkDownInfo.codeTitleSize && this.listItemColor == customMarkDownInfo.listItemColor && Intrinsics.areEqual(this.blankLineMulti, customMarkDownInfo.blankLineMulti) && Float.compare(this.tableTextSize, customMarkDownInfo.tableTextSize) == 0 && Intrinsics.areEqual(this.textLineMulti, customMarkDownInfo.textLineMulti) && this.diffDp == customMarkDownInfo.diffDp && this.minImgWidthHeight == customMarkDownInfo.minImgWidthHeight && Intrinsics.areEqual(this.bgListItemConfig, customMarkDownInfo.bgListItemConfig) && Intrinsics.areEqual(this.paragraphSpaceHeight, customMarkDownInfo.paragraphSpaceHeight) && Intrinsics.areEqual(this.listItemSpaceHeight, customMarkDownInfo.listItemSpaceHeight) && Intrinsics.areEqual(this.paragraphSpaceHeightProvider, customMarkDownInfo.paragraphSpaceHeightProvider) && Intrinsics.areEqual(this.paragraphTopSpaceHeightProvider, customMarkDownInfo.paragraphTopSpaceHeightProvider) && Intrinsics.areEqual(this.blockQuoteConfig, customMarkDownInfo.blockQuoteConfig) && Intrinsics.areEqual(this.thematicBreakConfig, customMarkDownInfo.thematicBreakConfig) && Intrinsics.areEqual(this.codeBlockConfig, customMarkDownInfo.codeBlockConfig) && Intrinsics.areEqual(this.tableConfig, customMarkDownInfo.tableConfig) && Intrinsics.areEqual(this.phoneNumberConfig, customMarkDownInfo.phoneNumberConfig) && Intrinsics.areEqual(this.listMarginInfo, customMarkDownInfo.listMarginInfo) && Intrinsics.areEqual(this.customListPlugin, customMarkDownInfo.customListPlugin) && Intrinsics.areEqual(this.listConfig, customMarkDownInfo.listConfig) && Intrinsics.areEqual(this.headingColor, customMarkDownInfo.headingColor) && Intrinsics.areEqual(this.listStyle, customMarkDownInfo.listStyle) && Intrinsics.areEqual(this.darkMode, customMarkDownInfo.darkMode) && Intrinsics.areEqual(this.allowParentInterceptTouchWhenOverScroll, customMarkDownInfo.allowParentInterceptTouchWhenOverScroll) && Intrinsics.areEqual(this.splitCodeBlock, customMarkDownInfo.splitCodeBlock) && Intrinsics.areEqual(this.latexSingleConfig, customMarkDownInfo.latexSingleConfig) && this.allowNonClosedTags == customMarkDownInfo.allowNonClosedTags && Intrinsics.areEqual(this.headingLevelTextSizeMap, customMarkDownInfo.headingLevelTextSizeMap) && Intrinsics.areEqual(this.linkHandler, customMarkDownInfo.linkHandler) && this.noBlockSpace == customMarkDownInfo.noBlockSpace;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = Integer.hashCode(this.imgCornerRadius) * 31;
        Integer num = this.imgBgColor;
        int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.htmlTagHandlerList.hashCode()) * 31) + this.codeCopyTitle.hashCode()) * 31;
        boolean z = this.enableCodeCopyButton;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z2 = this.useSubscribedColor;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        Integer num2 = this.linkColor;
        int hashCode3 = (((((i4 + (num2 == null ? 0 : num2.hashCode())) * 31) + Integer.hashCode(this.codeTitleSize)) * 31) + Integer.hashCode(this.listItemColor)) * 31;
        Float f = this.blankLineMulti;
        int hashCode4 = (((hashCode3 + (f == null ? 0 : f.hashCode())) * 31) + Float.hashCode(this.tableTextSize)) * 31;
        Float f2 = this.textLineMulti;
        int hashCode5 = (((((hashCode4 + (f2 == null ? 0 : f2.hashCode())) * 31) + Integer.hashCode(this.diffDp)) * 31) + Integer.hashCode(this.minImgWidthHeight)) * 31;
        BgListItemConfig bgListItemConfig = this.bgListItemConfig;
        int hashCode6 = (hashCode5 + (bgListItemConfig == null ? 0 : bgListItemConfig.hashCode())) * 31;
        Integer num3 = this.paragraphSpaceHeight;
        int hashCode7 = (hashCode6 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.listItemSpaceHeight;
        int hashCode8 = (hashCode7 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Function1<Node, Integer> function1 = this.paragraphSpaceHeightProvider;
        int hashCode9 = (hashCode8 + (function1 == null ? 0 : function1.hashCode())) * 31;
        Function1<Node, Integer> function12 = this.paragraphTopSpaceHeightProvider;
        int hashCode10 = (hashCode9 + (function12 == null ? 0 : function12.hashCode())) * 31;
        BlockQuoteConfig blockQuoteConfig = this.blockQuoteConfig;
        int hashCode11 = (hashCode10 + (blockQuoteConfig == null ? 0 : blockQuoteConfig.hashCode())) * 31;
        ThematicBreakConfig thematicBreakConfig = this.thematicBreakConfig;
        int hashCode12 = (hashCode11 + (thematicBreakConfig == null ? 0 : thematicBreakConfig.hashCode())) * 31;
        CodeBlockConfig codeBlockConfig = this.codeBlockConfig;
        int hashCode13 = (hashCode12 + (codeBlockConfig == null ? 0 : codeBlockConfig.hashCode())) * 31;
        TableConfig tableConfig = this.tableConfig;
        int hashCode14 = (hashCode13 + (tableConfig == null ? 0 : tableConfig.hashCode())) * 31;
        PhoneNumberConfig phoneNumberConfig = this.phoneNumberConfig;
        int hashCode15 = (hashCode14 + (phoneNumberConfig == null ? 0 : phoneNumberConfig.hashCode())) * 31;
        ListMarginInfo listMarginInfo = this.listMarginInfo;
        int hashCode16 = (hashCode15 + (listMarginInfo == null ? 0 : listMarginInfo.hashCode())) * 31;
        List<AbstractMarkwonPlugin> list = this.customListPlugin;
        int hashCode17 = (hashCode16 + (list == null ? 0 : list.hashCode())) * 31;
        ListConfig listConfig = this.listConfig;
        int hashCode18 = (hashCode17 + (listConfig == null ? 0 : listConfig.hashCode())) * 31;
        Integer num5 = this.headingColor;
        int hashCode19 = (hashCode18 + (num5 == null ? 0 : num5.hashCode())) * 31;
        ListStyle listStyle = this.listStyle;
        int hashCode20 = (hashCode19 + (listStyle == null ? 0 : listStyle.hashCode())) * 31;
        Boolean bool = this.darkMode;
        int hashCode21 = (hashCode20 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.allowParentInterceptTouchWhenOverScroll;
        int hashCode22 = (hashCode21 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.splitCodeBlock;
        int hashCode23 = (((hashCode22 + (bool3 == null ? 0 : bool3.hashCode())) * 31) + this.latexSingleConfig.hashCode()) * 31;
        boolean z3 = this.allowNonClosedTags;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        int i6 = (hashCode23 + i5) * 31;
        Map<Integer, Float> map = this.headingLevelTextSizeMap;
        int hashCode24 = (i6 + (map == null ? 0 : map.hashCode())) * 31;
        ICustomLinkHandler iCustomLinkHandler = this.linkHandler;
        int hashCode25 = (hashCode24 + (iCustomLinkHandler != null ? iCustomLinkHandler.hashCode() : 0)) * 31;
        boolean z4 = this.noBlockSpace;
        return hashCode25 + (z4 ? 1 : z4 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CustomMarkDownInfo(imgCornerRadius=");
        sb.append(this.imgCornerRadius).append(", imgBgColor=").append(this.imgBgColor).append(", htmlTagHandlerList=").append(this.htmlTagHandlerList).append(", codeCopyTitle=").append(this.codeCopyTitle).append(", enableCodeCopyButton=").append(this.enableCodeCopyButton).append(", useSubscribedColor=").append(this.useSubscribedColor).append(", linkColor=").append(this.linkColor).append(", codeTitleSize=").append(this.codeTitleSize).append(", listItemColor=").append(this.listItemColor).append(", blankLineMulti=").append(this.blankLineMulti).append(", tableTextSize=").append(this.tableTextSize).append(", textLineMulti=");
        sb.append(this.textLineMulti).append(", diffDp=").append(this.diffDp).append(", minImgWidthHeight=").append(this.minImgWidthHeight).append(", bgListItemConfig=").append(this.bgListItemConfig).append(", paragraphSpaceHeight=").append(this.paragraphSpaceHeight).append(", listItemSpaceHeight=").append(this.listItemSpaceHeight).append(", paragraphSpaceHeightProvider=").append(this.paragraphSpaceHeightProvider).append(", paragraphTopSpaceHeightProvider=").append(this.paragraphTopSpaceHeightProvider).append(", blockQuoteConfig=").append(this.blockQuoteConfig).append(", thematicBreakConfig=").append(this.thematicBreakConfig).append(", codeBlockConfig=").append(this.codeBlockConfig).append(", tableConfig=").append(this.tableConfig);
        sb.append(", phoneNumberConfig=").append(this.phoneNumberConfig).append(", listMarginInfo=").append(this.listMarginInfo).append(", customListPlugin=").append(this.customListPlugin).append(", listConfig=").append(this.listConfig).append(", headingColor=").append(this.headingColor).append(", listStyle=").append(this.listStyle).append(", darkMode=").append(this.darkMode).append(", allowParentInterceptTouchWhenOverScroll=").append(this.allowParentInterceptTouchWhenOverScroll).append(", splitCodeBlock=").append(this.splitCodeBlock).append(", latexSingleConfig=").append(this.latexSingleConfig).append(", allowNonClosedTags=").append(this.allowNonClosedTags).append(", headingLevelTextSizeMap=");
        sb.append(this.headingLevelTextSizeMap).append(", linkHandler=").append(this.linkHandler).append(", noBlockSpace=").append(this.noBlockSpace).append(')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomMarkDownInfo(int i, Integer num, List<? extends TagHandler> list, String str, boolean z, boolean z2, Integer num2, int i2, int i3, Float f, float f2, Float f3, int i4, int i5, BgListItemConfig bgListItemConfig, Integer num3, Integer num4, Function1<? super Node, Integer> function1, Function1<? super Node, Integer> function12, BlockQuoteConfig blockQuoteConfig, ThematicBreakConfig thematicBreakConfig, CodeBlockConfig codeBlockConfig, TableConfig tableConfig, PhoneNumberConfig phoneNumberConfig, ListMarginInfo listMarginInfo, List<? extends AbstractMarkwonPlugin> list2, ListConfig listConfig, Integer num5, ListStyle listStyle, Boolean bool, Boolean bool2, Boolean bool3, LatexSingleConfig latexSingleConfig, boolean z3, Map<Integer, Float> map, ICustomLinkHandler iCustomLinkHandler, boolean z4) {
        Intrinsics.checkNotNullParameter(list, "htmlTagHandlerList");
        Intrinsics.checkNotNullParameter(str, "codeCopyTitle");
        Intrinsics.checkNotNullParameter(latexSingleConfig, "latexSingleConfig");
        this.imgCornerRadius = i;
        this.imgBgColor = num;
        this.htmlTagHandlerList = list;
        this.codeCopyTitle = str;
        this.enableCodeCopyButton = z;
        this.useSubscribedColor = z2;
        this.linkColor = num2;
        this.codeTitleSize = i2;
        this.listItemColor = i3;
        this.blankLineMulti = f;
        this.tableTextSize = f2;
        this.textLineMulti = f3;
        this.diffDp = i4;
        this.minImgWidthHeight = i5;
        this.bgListItemConfig = bgListItemConfig;
        this.paragraphSpaceHeight = num3;
        this.listItemSpaceHeight = num4;
        this.paragraphSpaceHeightProvider = function1;
        this.paragraphTopSpaceHeightProvider = function12;
        this.blockQuoteConfig = blockQuoteConfig;
        this.thematicBreakConfig = thematicBreakConfig;
        this.codeBlockConfig = codeBlockConfig;
        this.tableConfig = tableConfig;
        this.phoneNumberConfig = phoneNumberConfig;
        this.listMarginInfo = listMarginInfo;
        this.customListPlugin = list2;
        this.listConfig = listConfig;
        this.headingColor = num5;
        this.listStyle = listStyle;
        this.darkMode = bool;
        this.allowParentInterceptTouchWhenOverScroll = bool2;
        this.splitCodeBlock = bool3;
        this.latexSingleConfig = latexSingleConfig;
        this.allowNonClosedTags = z3;
        this.headingLevelTextSizeMap = map;
        this.linkHandler = iCustomLinkHandler;
        this.noBlockSpace = z4;
    }

    public final int getImgCornerRadius() {
        return this.imgCornerRadius;
    }

    public final Integer getImgBgColor() {
        return this.imgBgColor;
    }

    public final List<TagHandler> getHtmlTagHandlerList() {
        return this.htmlTagHandlerList;
    }

    public final String getCodeCopyTitle() {
        return this.codeCopyTitle;
    }

    public final boolean getEnableCodeCopyButton() {
        return this.enableCodeCopyButton;
    }

    public final boolean getUseSubscribedColor() {
        return this.useSubscribedColor;
    }

    public final Integer getLinkColor() {
        return this.linkColor;
    }

    public final int getCodeTitleSize() {
        return this.codeTitleSize;
    }

    public final int getListItemColor() {
        return this.listItemColor;
    }

    public final Float getBlankLineMulti() {
        return this.blankLineMulti;
    }

    public final float getTableTextSize() {
        return this.tableTextSize;
    }

    public final Float getTextLineMulti() {
        return this.textLineMulti;
    }

    public final int getDiffDp() {
        return this.diffDp;
    }

    public final int getMinImgWidthHeight() {
        return this.minImgWidthHeight;
    }

    public final BgListItemConfig getBgListItemConfig() {
        return this.bgListItemConfig;
    }

    public final Integer getParagraphSpaceHeight() {
        return this.paragraphSpaceHeight;
    }

    public final Integer getListItemSpaceHeight() {
        return this.listItemSpaceHeight;
    }

    public final Function1<Node, Integer> getParagraphSpaceHeightProvider() {
        return this.paragraphSpaceHeightProvider;
    }

    public final Function1<Node, Integer> getParagraphTopSpaceHeightProvider() {
        return this.paragraphTopSpaceHeightProvider;
    }

    public final BlockQuoteConfig getBlockQuoteConfig() {
        return this.blockQuoteConfig;
    }

    public final ThematicBreakConfig getThematicBreakConfig() {
        return this.thematicBreakConfig;
    }

    public final CodeBlockConfig getCodeBlockConfig() {
        return this.codeBlockConfig;
    }

    public final TableConfig getTableConfig() {
        return this.tableConfig;
    }

    public final PhoneNumberConfig getPhoneNumberConfig() {
        return this.phoneNumberConfig;
    }

    public final ListMarginInfo getListMarginInfo() {
        return this.listMarginInfo;
    }

    public final List<AbstractMarkwonPlugin> getCustomListPlugin() {
        return this.customListPlugin;
    }

    public final ListConfig getListConfig() {
        return this.listConfig;
    }

    public final Integer getHeadingColor() {
        return this.headingColor;
    }

    public final ListStyle getListStyle() {
        return this.listStyle;
    }

    public final Boolean getDarkMode() {
        return this.darkMode;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ CustomMarkDownInfo(int i, Integer num, List list, String str, boolean z, boolean z2, Integer num2, int i2, int i3, Float f, float f2, Float f3, int i4, int i5, BgListItemConfig bgListItemConfig, Integer num3, Integer num4, Function1 function1, Function1 function12, BlockQuoteConfig blockQuoteConfig, ThematicBreakConfig thematicBreakConfig, CodeBlockConfig codeBlockConfig, TableConfig tableConfig, PhoneNumberConfig phoneNumberConfig, ListMarginInfo listMarginInfo, List list2, ListConfig listConfig, Integer num5, ListStyle listStyle, Boolean bool, Boolean bool2, Boolean bool3, LatexSingleConfig latexSingleConfig, boolean z3, Map map, ICustomLinkHandler iCustomLinkHandler, boolean z4, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r35, r77, r34, r33, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r16, r0, (i7 & 2) != 0 ? r5 : z3, (i7 & 4) != 0 ? r2 : map, (i7 & 8) == 0 ? iCustomLinkHandler : r2, (i7 & 16) == 0 ? z4 : r5);
        Float f4;
        BgListItemConfig bgListItemConfig2;
        int i8;
        int i9;
        Map map2;
        boolean z5;
        LatexSingleConfig latexSingleConfig2;
        int i10 = (i6 & 1) != 0 ? 0 : i;
        Integer num6 = (i6 & 2) != 0 ? null : num;
        List emptyList = (i6 & 4) != 0 ? CollectionsKt.emptyList() : list;
        String str2 = (i6 & 8) != 0 ? "" : str;
        boolean z6 = (i6 & 16) != 0 ? true : z;
        boolean z7 = (i6 & 32) != 0 ? false : z2;
        Integer num7 = (i6 & 64) != 0 ? null : num2;
        int i11 = (i6 & 128) != 0 ? 0 : i2;
        int i12 = (i6 & 256) != 0 ? 0 : i3;
        Float f5 = (i6 & 512) != 0 ? null : f;
        float f6 = (i6 & 1024) != 0 ? 0.0f : f2;
        Float f7 = (i6 & AnimationConstant.PROP_BOTTOM) != 0 ? null : f3;
        int i13 = (i6 & 4096) != 0 ? 0 : i4;
        int i14 = (i6 & AnimationConstant.PROP_COLOR) != 0 ? 0 : i5;
        Boolean bool4 = false;
        BgListItemConfig bgListItemConfig3 = (i6 & AnimationConstant.PROP_MAX_WIDTH) != 0 ? null : bgListItemConfig;
        Integer num8 = (i6 & AnimationConstant.PROP_MIN_WIDTH) != 0 ? null : num3;
        Integer num9 = (i6 & 65536) != 0 ? null : num4;
        Function1 function13 = (i6 & AnimationConstant.PROP_MIN_HEIGHT) != 0 ? null : function1;
        Function1 function14 = (i6 & AnimationConstant.TRAN_PROP_ALL) != 0 ? null : function12;
        BlockQuoteConfig blockQuoteConfig2 = (i6 & 524288) != 0 ? null : blockQuoteConfig;
        ThematicBreakConfig thematicBreakConfig2 = (i6 & ByteConstants.f354MB) != 0 ? null : thematicBreakConfig;
        CodeBlockConfig codeBlockConfig2 = (i6 & 2097152) != 0 ? null : codeBlockConfig;
        TableConfig tableConfig2 = (i6 & 4194304) != 0 ? null : tableConfig;
        PhoneNumberConfig phoneNumberConfig2 = (i6 & 8388608) != 0 ? null : phoneNumberConfig;
        ListMarginInfo listMarginInfo2 = (i6 & 16777216) != 0 ? null : listMarginInfo;
        List list3 = (i6 & 33554432) != 0 ? null : list2;
        ListConfig listConfig2 = (i6 & 67108864) != 0 ? null : listConfig;
        Integer num10 = (i6 & 134217728) != 0 ? null : num5;
        ListStyle listStyle2 = (i6 & 268435456) != 0 ? null : listStyle;
        Boolean bool5 = (i6 & 536870912) != 0 ? null : bool;
        Boolean bool6 = (i6 & 1073741824) != 0 ? null : bool2;
        bool4 = (i6 & Integer.MIN_VALUE) == 0 ? bool3 : bool4;
        if ((i7 & 1) != 0) {
            bgListItemConfig2 = bgListItemConfig3;
            f4 = f7;
            i8 = i13;
            i9 = i14;
            map2 = null;
            z5 = false;
            latexSingleConfig2 = new LatexSingleConfig(0.0f, 0, 3, null);
        } else {
            f4 = f7;
            bgListItemConfig2 = bgListItemConfig3;
            i8 = i13;
            i9 = i14;
            map2 = null;
            z5 = false;
            latexSingleConfig2 = latexSingleConfig;
        }
    }

    public final Boolean getAllowParentInterceptTouchWhenOverScroll() {
        return this.allowParentInterceptTouchWhenOverScroll;
    }

    public final Boolean getSplitCodeBlock() {
        return this.splitCodeBlock;
    }

    public final LatexSingleConfig getLatexSingleConfig() {
        return this.latexSingleConfig;
    }

    public final boolean getAllowNonClosedTags() {
        return this.allowNonClosedTags;
    }

    public final Map<Integer, Float> getHeadingLevelTextSizeMap() {
        return this.headingLevelTextSizeMap;
    }

    public final ICustomLinkHandler getLinkHandler() {
        return this.linkHandler;
    }

    public final boolean getNoBlockSpace() {
        return this.noBlockSpace;
    }
}
