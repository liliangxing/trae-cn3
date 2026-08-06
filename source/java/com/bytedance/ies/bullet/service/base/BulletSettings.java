package com.bytedance.ies.bullet.service.base;

import com.bytedance.ies.bullet.service.base.settings.LegoBootFinishCommitter;
import com.bytedance.sdk.xbridge.cn.optimize.ThreadOptConfig;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.DateCalculationsKt;

/* compiled from: ISettingService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0003\b\u0090\u0001\n\u0002\u0010$\n\u0002\b!\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u0007\n\u0002\b\u001c\n\u0002\u0010\u0006\n\u0002\b3\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u000f\"\u0004\b*\u0010\u0011R\u001a\u0010+\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u000f\"\u0004\b-\u0010\u0011R\u001a\u0010.\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u000f\"\u0004\b<\u0010\u0011R \u0010=\u001a\b\u0012\u0004\u0012\u00020\u00140\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001f\"\u0004\b?\u0010!R\u001a\u0010@\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00101\"\u0004\bB\u00103R\u001a\u0010C\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\bR\u001a\u0010F\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0006\"\u0004\bH\u0010\bR\u001a\u0010I\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\bR\u001a\u0010L\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0006\"\u0004\bN\u0010\bR\u001a\u0010O\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0006\"\u0004\bQ\u0010\bR\u001a\u0010R\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0006\"\u0004\bT\u0010\bR\u001a\u0010U\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0006\"\u0004\bW\u0010\bR\u001a\u0010X\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0006\"\u0004\bZ\u0010\bR\u001a\u0010[\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0006\"\u0004\b]\u0010\bR\u001a\u0010^\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0006\"\u0004\b`\u0010\bR\u001a\u0010a\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0006\"\u0004\bc\u0010\bR\u001e\u0010d\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010i\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001a\u0010j\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u0006\"\u0004\bl\u0010\bR\u001a\u0010m\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\u0006\"\u0004\bo\u0010\bR\u001a\u0010p\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u000f\"\u0004\br\u0010\u0011R\u001a\u0010s\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\u0006\"\u0004\bu\u0010\bR\u001a\u0010v\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010\u0006\"\u0004\bx\u0010\bR\u001a\u0010y\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\u0006\"\u0004\b{\u0010\bR\u001a\u0010|\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010\u0006\"\u0004\b~\u0010\bR\u001c\u0010\u007f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010\u0006\"\u0005\b\u0081\u0001\u0010\bR\u001d\u0010\u0082\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u0006\"\u0005\b\u0084\u0001\u0010\bR\u001d\u0010\u0085\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010\u0006\"\u0005\b\u0087\u0001\u0010\bR\u001d\u0010\u0088\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010\u0006\"\u0005\b\u008a\u0001\u0010\bR\u001d\u0010\u008b\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010\u0006\"\u0005\b\u008d\u0001\u0010\bR\u001d\u0010\u008e\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010\u0006\"\u0005\b\u0090\u0001\u0010\bR\u001d\u0010\u0091\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010\u0006\"\u0005\b\u0093\u0001\u0010\bR\u001d\u0010\u0094\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010\u0006\"\u0005\b\u0096\u0001\u0010\bR\u001d\u0010\u0097\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010\u0006\"\u0005\b\u0099\u0001\u0010\bR\u001d\u0010\u009a\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u0010\u0006\"\u0005\b\u009c\u0001\u0010\bR(\u0010\u009d\u0001\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0000\u0012\u0005\b\u009e\u0001\u0010\u0002\u001a\u0005\b\u009f\u0001\u0010\u0006\"\u0005\b \u0001\u0010\bR\u001d\u0010¡\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0001\u0010\u0006\"\u0005\b£\u0001\u0010\bR\u001d\u0010¤\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0001\u0010\u0006\"\u0005\b¦\u0001\u0010\bR\u001d\u0010§\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¨\u0001\u0010\u0006\"\u0005\b©\u0001\u0010\bR\u001d\u0010ª\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b«\u0001\u0010\u0006\"\u0005\b¬\u0001\u0010\bR\u001d\u0010\u00ad\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0001\u0010\u0006\"\u0005\b¯\u0001\u0010\bR\u001d\u0010°\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0001\u0010\u0006\"\u0005\b²\u0001\u0010\bR\u001d\u0010³\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b´\u0001\u0010\u0006\"\u0005\bµ\u0001\u0010\bR\u001d\u0010¶\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b·\u0001\u0010\u0006\"\u0005\b¸\u0001\u0010\bR\u001d\u0010¹\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bº\u0001\u0010\u0006\"\u0005\b»\u0001\u0010\bR\u001d\u0010¼\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b½\u0001\u0010\u0006\"\u0005\b¾\u0001\u0010\bR\u001d\u0010¿\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÀ\u0001\u0010\u0006\"\u0005\bÁ\u0001\u0010\bR\u001d\u0010Â\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÃ\u0001\u0010\u0006\"\u0005\bÄ\u0001\u0010\bR4\u0010Å\u0001\u001a\u0017\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u001d\u0018\u00010Æ\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÇ\u0001\u0010È\u0001\"\u0006\bÉ\u0001\u0010Ê\u0001R\u001d\u0010Ë\u0001\u001a\u00020\rX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÌ\u0001\u0010\u000f\"\u0005\bÍ\u0001\u0010\u0011R\u001d\u0010Î\u0001\u001a\u00020\rX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÏ\u0001\u0010\u000f\"\u0005\bÐ\u0001\u0010\u0011R\u001d\u0010Ñ\u0001\u001a\u00020\rX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÒ\u0001\u0010\u000f\"\u0005\bÓ\u0001\u0010\u0011R\u001d\u0010Ô\u0001\u001a\u00020/X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÕ\u0001\u00101\"\u0005\bÖ\u0001\u00103R\u001d\u0010×\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b×\u0001\u0010\u0006\"\u0005\bØ\u0001\u0010\bR\u001d\u0010Ù\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÙ\u0001\u0010\u0006\"\u0005\bÚ\u0001\u0010\bR!\u0010Û\u0001\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0012\n\u0002\u0010i\u001a\u0005\bÛ\u0001\u0010f\"\u0005\bÜ\u0001\u0010hR\u001d\u0010Ý\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÝ\u0001\u0010\u0006\"\u0005\bÞ\u0001\u0010\bR\u001d\u0010ß\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bß\u0001\u0010\u0006\"\u0005\bà\u0001\u0010\bR\u001d\u0010á\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bá\u0001\u0010\u0006\"\u0005\bâ\u0001\u0010\bR\u001d\u0010ã\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bã\u0001\u0010\u0006\"\u0005\bä\u0001\u0010\bR\u001d\u0010å\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bå\u0001\u0010\u0006\"\u0005\bæ\u0001\u0010\bR%\u0010ç\u0001\u001a\n\u0012\u0005\u0012\u00030é\u00010è\u0001X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bê\u0001\u0010\u001f\"\u0005\bë\u0001\u0010!R#\u0010ì\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140\u001dX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bí\u0001\u0010\u001f\"\u0005\bî\u0001\u0010!R\u001d\u0010ï\u0001\u001a\u00020\rX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bð\u0001\u0010\u000f\"\u0005\bñ\u0001\u0010\u0011R%\u0010ò\u0001\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001dX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bó\u0001\u0010\u001f\"\u0005\bô\u0001\u0010!R%\u0010õ\u0001\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001dX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bö\u0001\u0010\u001f\"\u0005\b÷\u0001\u0010!R\u001d\u0010ø\u0001\u001a\u00020\rX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bù\u0001\u0010\u000f\"\u0005\bú\u0001\u0010\u0011R%\u0010û\u0001\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001dX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bü\u0001\u0010\u001f\"\u0005\bý\u0001\u0010!R%\u0010þ\u0001\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÿ\u0001\u0010\u0016\"\u0005\b\u0080\u0002\u0010\u0018R\u001d\u0010\u0081\u0002\u001a\u00020/X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0002\u00101\"\u0005\b\u0083\u0002\u00103R%\u0010\u0084\u0002\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0002\u0010\u0016\"\u0005\b\u0086\u0002\u0010\u0018R\u001d\u0010\u0087\u0002\u001a\u00020/X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0002\u00101\"\u0005\b\u0089\u0002\u00103R\u001d\u0010\u008a\u0002\u001a\u00020/X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0002\u00101\"\u0005\b\u008c\u0002\u00103R(\u0010\u008d\u0002\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0000\u0012\u0005\b\u008e\u0002\u0010\u0002\u001a\u0005\b\u008f\u0002\u0010\u0006\"\u0005\b\u0090\u0002\u0010\bR\u001d\u0010\u0091\u0002\u001a\u00020/X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0002\u00101\"\u0005\b\u0093\u0002\u00103R\u001d\u0010\u0094\u0002\u001a\u00020/X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0002\u00101\"\u0005\b\u0096\u0002\u00103R \u0010\u0097\u0002\u001a\u00030\u0098\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0099\u0002\u0010\u009a\u0002\"\u0006\b\u009b\u0002\u0010\u009c\u0002R\u001d\u0010\u009d\u0002\u001a\u00020/X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009e\u0002\u00101\"\u0005\b\u009f\u0002\u00103R\u001d\u0010 \u0002\u001a\u00020\rX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¡\u0002\u0010\u000f\"\u0005\b¢\u0002\u0010\u0011R\u001d\u0010£\u0002\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¤\u0002\u0010\u0006\"\u0005\b¥\u0002\u0010\bR\u001d\u0010¦\u0002\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b§\u0002\u0010\u0006\"\u0005\b¨\u0002\u0010\bR!\u0010©\u0002\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bª\u0002\u0010«\u0002\"\u0006\b¬\u0002\u0010\u00ad\u0002R#\u0010®\u0002\u001a\b\u0012\u0004\u0012\u00020\u00140\u001dX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¯\u0002\u0010\u001f\"\u0005\b°\u0002\u0010!R#\u0010±\u0002\u001a\b\u0012\u0004\u0012\u00020\u00140\u001dX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b²\u0002\u0010\u001f\"\u0005\b³\u0002\u0010!R \u0010´\u0002\u001a\u00030µ\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¶\u0002\u0010·\u0002\"\u0006\b¸\u0002\u0010¹\u0002R \u0010º\u0002\u001a\u00030µ\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b»\u0002\u0010·\u0002\"\u0006\b¼\u0002\u0010¹\u0002R\u001d\u0010½\u0002\u001a\u00020\rX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¾\u0002\u0010\u000f\"\u0005\b¿\u0002\u0010\u0011R\u001d\u0010À\u0002\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÁ\u0002\u0010\u0006\"\u0005\bÂ\u0002\u0010\bR\u001d\u0010Ã\u0002\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÄ\u0002\u0010\u0006\"\u0005\bÅ\u0002\u0010\bR\u001d\u0010Æ\u0002\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÇ\u0002\u0010\u0006\"\u0005\bÈ\u0002\u0010\bR \u0010É\u0002\u001a\u00030\u0098\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÊ\u0002\u0010\u009a\u0002\"\u0006\bË\u0002\u0010\u009c\u0002R\u001d\u0010Ì\u0002\u001a\u00020/X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÍ\u0002\u00101\"\u0005\bÎ\u0002\u00103R\u001d\u0010Ï\u0002\u001a\u00020\rX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÐ\u0002\u0010\u000f\"\u0005\bÑ\u0002\u0010\u0011R\u001d\u0010Ò\u0002\u001a\u00020/X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÓ\u0002\u00101\"\u0005\bÔ\u0002\u00103R\u001d\u0010Õ\u0002\u001a\u00020\rX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÖ\u0002\u0010\u000f\"\u0005\b×\u0002\u0010\u0011R\u001d\u0010Ø\u0002\u001a\u00020\rX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÙ\u0002\u0010\u000f\"\u0005\bÚ\u0002\u0010\u0011R\u001d\u0010Û\u0002\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÜ\u0002\u0010\u0006\"\u0005\bÝ\u0002\u0010\bR!\u0010Þ\u0002\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0012\n\u0002\u0010i\u001a\u0005\bß\u0002\u0010f\"\u0005\bà\u0002\u0010hR(\u0010á\u0002\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0000\u0012\u0005\bâ\u0002\u0010\u0002\u001a\u0005\bã\u0002\u0010\u0006\"\u0005\bä\u0002\u0010\bR#\u0010å\u0002\u001a\b\u0012\u0004\u0012\u00020\u00140\u001dX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bæ\u0002\u0010\u001f\"\u0005\bç\u0002\u0010!¨\u0006è\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/BulletSettings;", "", "()V", "annieFixWebUpload", "", "getAnnieFixWebUpload", "()Z", "setAnnieFixWebUpload", "(Z)V", "annieXWorker", "getAnnieXWorker", "setAnnieXWorker", "bcmChainLength", "", "getBcmChainLength", "()I", "setBcmChainLength", "(I)V", "blockBid", "", "", "getBlockBid", "()Ljava/util/Set;", "setBlockBid", "(Ljava/util/Set;)V", "blockEntranceForm", "getBlockEntranceForm", "setBlockEntranceForm", "blockSchema", "", "getBlockSchema", "()Ljava/util/List;", "setBlockSchema", "(Ljava/util/List;)V", "bulletSettingRunner", "Lcom/bytedance/ies/bullet/service/base/settings/LegoBootFinishCommitter;", "getBulletSettingRunner", "()Lcom/bytedance/ies/bullet/service/base/settings/LegoBootFinishCommitter;", "setBulletSettingRunner", "(Lcom/bytedance/ies/bullet/service/base/settings/LegoBootFinishCommitter;)V", "cardInitDelaySeconds", "getCardInitDelaySeconds", "setCardInitDelaySeconds", "cdnCacheMaxAge", "getCdnCacheMaxAge", "setCdnCacheMaxAge", "checkTimeoutMs", "", "getCheckTimeoutMs", "()J", "setCheckTimeoutMs", "(J)V", "cpuMemRecordFrequency", "", "getCpuMemRecordFrequency", "()Ljava/lang/Number;", "setCpuMemRecordFrequency", "(Ljava/lang/Number;)V", "delaySeconds", "getDelaySeconds", "setDelaySeconds", "deleteWhen100ErrorList", "getDeleteWhen100ErrorList", "setDeleteWhen100ErrorList", "detectFrequencyInternal", "getDetectFrequencyInternal", "setDetectFrequencyInternal", "enableAnnieConvertJsonOpt", "getEnableAnnieConvertJsonOpt", "setEnableAnnieConvertJsonOpt", "enableAnnieXBridgeThreadOpt", "getEnableAnnieXBridgeThreadOpt", "setEnableAnnieXBridgeThreadOpt", "enableAnnieXPadGPContainerMigration", "getEnableAnnieXPadGPContainerMigration", "setEnableAnnieXPadGPContainerMigration", "enableArgusFetchCdnConfigInternal", "getEnableArgusFetchCdnConfigInternal", "setEnableArgusFetchCdnConfigInternal", "enableAutoPlayBGMParam", "getEnableAutoPlayBGMParam", "setEnableAutoPlayBGMParam", "enableBridgeLeakFix", "getEnableBridgeLeakFix", "setEnableBridgeLeakFix", "enableBulletPreRenderGovern", "getEnableBulletPreRenderGovern", "setEnableBulletPreRenderGovern", "enableBulletSettingDelay", "getEnableBulletSettingDelay", "setEnableBulletSettingDelay", "enableCardInit", "getEnableCardInit", "setEnableCardInit", "enableDefaultInit", "getEnableDefaultInit", "setEnableDefaultInit", "enableFinishOnce", "getEnableFinishOnce", "setEnableFinishOnce", "enableFmpResourcePreload", "getEnableFmpResourcePreload", "()Ljava/lang/Boolean;", "setEnableFmpResourcePreload", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "enableForestTemplateProvider", "getEnableForestTemplateProvider", "setEnableForestTemplateProvider", "enableGeckoLoaderSecure", "getEnableGeckoLoaderSecure", "setEnableGeckoLoaderSecure", "enableGlobalLayoutMemLeak", "getEnableGlobalLayoutMemLeak", "setEnableGlobalLayoutMemLeak", "enableGlobalPropsCacheOptimize", "getEnableGlobalPropsCacheOptimize", "setEnableGlobalPropsCacheOptimize", "enableGlobalTemplateProvider", "getEnableGlobalTemplateProvider", "setEnableGlobalTemplateProvider", "enableJSBReleaseCache", "getEnableJSBReleaseCache", "setEnableJSBReleaseCache", "enableJsonOpt", "getEnableJsonOpt", "setEnableJsonOpt", "enableLynxFontCache", "getEnableLynxFontCache", "setEnableLynxFontCache", "enableMemLeakExperiment", "getEnableMemLeakExperiment", "setEnableMemLeakExperiment", "enableMixLogic", "getEnableMixLogic", "setEnableMixLogic", "enableNaEventReport", "getEnableNaEventReport", "setEnableNaEventReport", "enableNaStackStore", "getEnableNaStackStore", "setEnableNaStackStore", "enablePadAdapterMigrationToUniformStyle", "getEnablePadAdapterMigrationToUniformStyle", "setEnablePadAdapterMigrationToUniformStyle", "enablePadPopupMigrationToUniformStyle", "getEnablePadPopupMigrationToUniformStyle", "setEnablePadPopupMigrationToUniformStyle", "enablePageEventReport", "getEnablePageEventReport", "setEnablePageEventReport", "enablePageInit", "getEnablePageInit", "setEnablePageInit", "enablePreload", "getEnablePreload", "setEnablePreload", "enableRLOptimise", "getEnableRLOptimise$annotations", "getEnableRLOptimise", "setEnableRLOptimise", "enableRedirectDefaultCache", "getEnableRedirectDefaultCache", "setEnableRedirectDefaultCache", "enableReloadContextMerge", "getEnableReloadContextMerge", "setEnableReloadContextMerge", "enableRemoveDouyinScreenInfoParams", "getEnableRemoveDouyinScreenInfoParams", "setEnableRemoveDouyinScreenInfoParams", "enableSceneBcmChainInfo", "getEnableSceneBcmChainInfo", "setEnableSceneBcmChainInfo", "enableSceneRecognize", "getEnableSceneRecognize", "setEnableSceneRecognize", "enableSecLinkReportEntry", "getEnableSecLinkReportEntry", "setEnableSecLinkReportEntry", "enableUploadFileTypeLimit", "getEnableUploadFileTypeLimit", "setEnableUploadFileTypeLimit", "enableUploadImageTypeLimit", "getEnableUploadImageTypeLimit", "setEnableUploadImageTypeLimit", "enableViewAttachWithoutSessionId", "getEnableViewAttachWithoutSessionId", "setEnableViewAttachWithoutSessionId", "enableWebStandard", "getEnableWebStandard", "setEnableWebStandard", "enableXBridgeContextLeakFix", "getEnableXBridgeContextLeakFix", "setEnableXBridgeContextLeakFix", "fixAnnieXMethodFinder", "getFixAnnieXMethodFinder", "setFixAnnieXMethodFinder", "forestFmpResourceList", "", "getForestFmpResourceList", "()Ljava/util/Map;", "setForestFmpResourceList", "(Ljava/util/Map;)V", "forestNormalPoolSize", "getForestNormalPoolSize", "setForestNormalPoolSize", "forestPreloadPoolSize", "getForestPreloadPoolSize", "setForestPreloadPoolSize", "hotUrlCacheMaxSize", "getHotUrlCacheMaxSize", "setHotUrlCacheMaxSize", "hybridViewWindowDurationMs", "getHybridViewWindowDurationMs", "setHybridViewWindowDurationMs", "isCheckEnable", "setCheckEnable", "isDomainStandard", "setDomainStandard", "isH5CoverGlobalProps", "setH5CoverGlobalProps", "isJSBThreadOptEnable", "setJSBThreadOptEnable", "isOnlyLocal", "setOnlyLocal", "isPartialBlankCheckEnable", "setPartialBlankCheckEnable", "isPureBlankCheckEnable", "setPureBlankCheckEnable", "isWebUseAndroid", "setWebUseAndroid", "jsbThreadOptConfig", "", "Lcom/bytedance/sdk/xbridge/cn/optimize/ThreadOptConfig;", "getJsbThreadOptConfig", "setJsbThreadOptConfig", "keepWebViewEvent", "getKeepWebViewEvent", "setKeepWebViewEvent", "maxMemCache", "getMaxMemCache", "setMaxMemCache", "padAdapterMigrationToUniformStyleWhiteList", "getPadAdapterMigrationToUniformStyleWhiteList", "setPadAdapterMigrationToUniformStyleWhiteList", "padPopupMigrationToUniformStyleWhiteList", "getPadPopupMigrationToUniformStyleWhiteList", "setPadPopupMigrationToUniformStyleWhiteList", "pageInitDelaySeconds", "getPageInitDelaySeconds", "setPageInitDelaySeconds", "pageInitWorkerList", "getPageInitWorkerList", "setPageInitWorkerList", "pageStackBlackList", "getPageStackBlackList", "setPageStackBlackList", "pageStackSubscribeDelay", "getPageStackSubscribeDelay", "setPageStackSubscribeDelay", "pageStackWhiteList", "getPageStackWhiteList", "setPageStackWhiteList", "pageStackWindowDurationMs", "getPageStackWindowDurationMs", "setPageStackWindowDurationMs", "partialBlankCheckTimeoutMs", "getPartialBlankCheckTimeoutMs", "setPartialBlankCheckTimeoutMs", "pineappleDisableOptimize", "getPineappleDisableOptimize$annotations", "getPineappleDisableOptimize", "setPineappleDisableOptimize", "preRenderMaxCacheTime", "getPreRenderMaxCacheTime", "setPreRenderMaxCacheTime", "preRenderMinFreeMemory", "getPreRenderMinFreeMemory", "setPreRenderMinFreeMemory", "pureColorCheckThreshold", "", "getPureColorCheckThreshold", "()F", "setPureColorCheckThreshold", "(F)V", "pureColorCheckTimeoutMs", "getPureColorCheckTimeoutMs", "setPureColorCheckTimeoutMs", "recentSceneLruCacheMaxSize", "getRecentSceneLruCacheMaxSize", "setRecentSceneLruCacheMaxSize", "reloadWithReset", "getReloadWithReset", "setReloadWithReset", "removeRequestReadPermission", "getRemoveRequestReadPermission", "setRemoveRequestReadPermission", "resUrl", "getResUrl", "()Ljava/lang/String;", "setResUrl", "(Ljava/lang/String;)V", "routerAllowList", "getRouterAllowList", "setRouterAllowList", "routerBlockList", "getRouterBlockList", "setRouterBlockList", "sceneRecognizeCosineThreshold", "", "getSceneRecognizeCosineThreshold", "()D", "setSceneRecognizeCosineThreshold", "(D)V", "sceneRecognizeJaccardThreshold", "getSceneRecognizeJaccardThreshold", "setSceneRecognizeJaccardThreshold", "sceneTableMaxCount", "getSceneTableMaxCount", "setSceneTableMaxCount", "separateVMSdkLoad", "getSeparateVMSdkLoad", "setSeparateVMSdkLoad", "shouldResetPageStartUrlWhenReceivedError", "getShouldResetPageStartUrlWhenReceivedError", "setShouldResetPageStartUrlWhenReceivedError", "showTitle", "getShowTitle", "setShowTitle", "snapShotMaxQuality", "getSnapShotMaxQuality", "setSnapShotMaxQuality", "snapShotTimeoutMs", "getSnapShotTimeoutMs", "setSnapShotTimeoutMs", "sqliteCleanThreshold", "getSqliteCleanThreshold", "setSqliteCleanThreshold", "sqliteDataExpireMs", "getSqliteDataExpireMs", "setSqliteDataExpireMs", "sqliteTransFlushThreshold", "getSqliteTransFlushThreshold", "setSqliteTransFlushThreshold", "transitionTableMaxCount", "getTransitionTableMaxCount", "setTransitionTableMaxCount", "useBDXbridge", "getUseBDXbridge", "setUseBDXbridge", "useNewContainer", "getUseNewContainer", "setUseNewContainer", "useXBridge3", "getUseXBridge3$annotations", "getUseXBridge3", "setUseXBridge3", "webViewAdBlockList", "getWebViewAdBlockList", "setWebViewAdBlockList", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class BulletSettings {
    private boolean annieFixWebUpload;
    private boolean annieXWorker;
    private Set<String> blockBid;
    private Set<String> blockEntranceForm;
    private List<String> blockSchema;
    private LegoBootFinishCommitter bulletSettingRunner;
    private int cdnCacheMaxAge;
    private boolean enableAnnieConvertJsonOpt;
    private boolean enableAnnieXPadGPContainerMigration;
    private boolean enableAutoPlayBGMParam;
    private boolean enableBulletPreRenderGovern;
    private boolean enableBulletSettingDelay;
    private boolean enableCardInit;
    private boolean enableDefaultInit;
    private boolean enableForestTemplateProvider;
    private boolean enableGeckoLoaderSecure;
    private boolean enableGlobalPropsCacheOptimize;
    private boolean enableGlobalTemplateProvider;
    private boolean enableJSBReleaseCache;
    private boolean enableJsonOpt;
    private boolean enableMemLeakExperiment;
    private boolean enableNaEventReport;
    private boolean enableNaStackStore;
    private boolean enablePadAdapterMigrationToUniformStyle;
    private boolean enablePadPopupMigrationToUniformStyle;
    private boolean enablePageInit;
    private boolean enablePreload;
    private boolean enableRLOptimise;
    private boolean enableRedirectDefaultCache;
    private boolean enableReloadContextMerge;
    private boolean enableRemoveDouyinScreenInfoParams;
    private boolean enableSceneBcmChainInfo;
    private boolean enableSceneRecognize;
    private boolean enableSecLinkReportEntry;
    private boolean enableUploadFileTypeLimit;
    private boolean enableUploadImageTypeLimit;
    private boolean enableViewAttachWithoutSessionId;
    private boolean enableWebStandard;
    private boolean enableXBridgeContextLeakFix;
    private boolean fixAnnieXMethodFinder;
    private boolean isCheckEnable;
    private boolean isDomainStandard;
    private Boolean isH5CoverGlobalProps;
    private boolean isJSBThreadOptEnable;
    private boolean isOnlyLocal;
    private boolean isPartialBlankCheckEnable;
    private boolean isPureBlankCheckEnable;
    private boolean isWebUseAndroid;
    private List<String> padAdapterMigrationToUniformStyleWhiteList;
    private List<String> padPopupMigrationToUniformStyleWhiteList;
    private List<String> pageInitWorkerList;
    private Set<String> pageStackBlackList;
    private Set<String> pageStackWhiteList;
    private boolean pineappleDisableOptimize;
    private boolean reloadWithReset;
    private boolean removeRequestReadPermission;
    private String resUrl;
    private boolean separateVMSdkLoad;
    private boolean shouldResetPageStartUrlWhenReceivedError;
    private boolean useBDXbridge;
    private Boolean useNewContainer;
    private boolean useXBridge3;
    private int maxMemCache = 2097152;
    private List<String> deleteWhen100ErrorList = new ArrayList();
    private List<String> keepWebViewEvent = new ArrayList();
    private boolean enableLynxFontCache = true;
    private boolean enableFinishOnce = true;
    private List<String> webViewAdBlockList = CollectionsKt.emptyList();
    private Number cpuMemRecordFrequency = (Number) 0;
    private List<String> routerAllowList = CollectionsKt.emptyList();
    private List<String> routerBlockList = CollectionsKt.emptyList();
    private boolean enableMixLogic = true;
    private int enableGlobalLayoutMemLeak = 1;
    private boolean enableBridgeLeakFix = true;
    private List<ThreadOptConfig> jsbThreadOptConfig = new ArrayList();
    private boolean showTitle = true;
    private Map<String, ? extends List<String>> forestFmpResourceList = new LinkedHashMap();
    private Boolean enableFmpResourcePreload = false;
    private int delaySeconds = 10;
    private int pageInitDelaySeconds = 10;
    private int cardInitDelaySeconds = 10;
    private boolean enablePageEventReport = true;
    private long preRenderMinFreeMemory = 200;
    private long preRenderMaxCacheTime = 10000;
    private long checkTimeoutMs = 1500;
    private long snapShotTimeoutMs = 500;
    private float snapShotMaxQuality = 360.0f;
    private float pureColorCheckThreshold = 0.9f;
    private long pureColorCheckTimeoutMs = 500;
    private long partialBlankCheckTimeoutMs = 500;
    private long detectFrequencyInternal = 60 * 1000;
    private long pageStackSubscribeDelay = 60000;
    private int bcmChainLength = 3;
    private long hybridViewWindowDurationMs = 3000;
    private long pageStackWindowDurationMs = 2000;
    private int hotUrlCacheMaxSize = 100;
    private double sceneRecognizeJaccardThreshold = 0.7d;
    private double sceneRecognizeCosineThreshold = 0.7d;
    private int recentSceneLruCacheMaxSize = 5;
    private int sceneTableMaxCount = 1000;
    private int transitionTableMaxCount = 1000;
    private long sqliteDataExpireMs = ((24 * 30) * DateCalculationsKt.SECONDS_PER_HOUR) * 1000;
    private int sqliteCleanThreshold = 5;
    private int sqliteTransFlushThreshold = 5;
    private int forestNormalPoolSize = 5;
    private int forestPreloadPoolSize = 5;
    private boolean enableAnnieXBridgeThreadOpt = true;
    private boolean enableArgusFetchCdnConfigInternal = true;

    @Deprecated(message = "待删除")
    public static /* synthetic */ void getEnableRLOptimise$annotations() {
    }

    @Deprecated(message = "待删除")
    public static /* synthetic */ void getPineappleDisableOptimize$annotations() {
    }

    @Deprecated(message = "已迁移至BridgeService")
    public static /* synthetic */ void getUseXBridge3$annotations() {
    }

    public final boolean getEnableAutoPlayBGMParam() {
        return this.enableAutoPlayBGMParam;
    }

    public final void setEnableAutoPlayBGMParam(boolean z) {
        this.enableAutoPlayBGMParam = z;
    }

    public final int getMaxMemCache() {
        return this.maxMemCache;
    }

    public final void setMaxMemCache(int i) {
        this.maxMemCache = i;
    }

    public final List<String> getDeleteWhen100ErrorList() {
        return this.deleteWhen100ErrorList;
    }

    public final void setDeleteWhen100ErrorList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.deleteWhen100ErrorList = list;
    }

    public final List<String> getKeepWebViewEvent() {
        return this.keepWebViewEvent;
    }

    public final void setKeepWebViewEvent(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.keepWebViewEvent = list;
    }

    public final boolean getReloadWithReset() {
        return this.reloadWithReset;
    }

    public final void setReloadWithReset(boolean z) {
        this.reloadWithReset = z;
    }

    public final boolean getShouldResetPageStartUrlWhenReceivedError() {
        return this.shouldResetPageStartUrlWhenReceivedError;
    }

    public final void setShouldResetPageStartUrlWhenReceivedError(boolean z) {
        this.shouldResetPageStartUrlWhenReceivedError = z;
    }

    public final boolean getUseBDXbridge() {
        return this.useBDXbridge;
    }

    public final void setUseBDXbridge(boolean z) {
        this.useBDXbridge = z;
    }

    public final boolean getEnableLynxFontCache() {
        return this.enableLynxFontCache;
    }

    public final void setEnableLynxFontCache(boolean z) {
        this.enableLynxFontCache = z;
    }

    public final boolean getEnableFinishOnce() {
        return this.enableFinishOnce;
    }

    public final void setEnableFinishOnce(boolean z) {
        this.enableFinishOnce = z;
    }

    public final boolean getEnablePreload() {
        return this.enablePreload;
    }

    public final void setEnablePreload(boolean z) {
        this.enablePreload = z;
    }

    public final List<String> getWebViewAdBlockList() {
        return this.webViewAdBlockList;
    }

    public final void setWebViewAdBlockList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.webViewAdBlockList = list;
    }

    public final boolean getUseXBridge3() {
        return this.useXBridge3;
    }

    public final void setUseXBridge3(boolean z) {
        this.useXBridge3 = z;
    }

    /* renamed from: isWebUseAndroid, reason: from getter */
    public final boolean getIsWebUseAndroid() {
        return this.isWebUseAndroid;
    }

    public final void setWebUseAndroid(boolean z) {
        this.isWebUseAndroid = z;
    }

    public final Number getCpuMemRecordFrequency() {
        return this.cpuMemRecordFrequency;
    }

    public final void setCpuMemRecordFrequency(Number number) {
        Intrinsics.checkNotNullParameter(number, "<set-?>");
        this.cpuMemRecordFrequency = number;
    }

    public final boolean getEnableMemLeakExperiment() {
        return this.enableMemLeakExperiment;
    }

    public final void setEnableMemLeakExperiment(boolean z) {
        this.enableMemLeakExperiment = z;
    }

    public final boolean getEnableRLOptimise() {
        return this.enableRLOptimise;
    }

    public final void setEnableRLOptimise(boolean z) {
        this.enableRLOptimise = z;
    }

    public final boolean getPineappleDisableOptimize() {
        return this.pineappleDisableOptimize;
    }

    public final void setPineappleDisableOptimize(boolean z) {
        this.pineappleDisableOptimize = z;
    }

    public final List<String> getRouterAllowList() {
        return this.routerAllowList;
    }

    public final void setRouterAllowList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.routerAllowList = list;
    }

    public final List<String> getRouterBlockList() {
        return this.routerBlockList;
    }

    public final void setRouterBlockList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.routerBlockList = list;
    }

    public final Boolean getUseNewContainer() {
        return this.useNewContainer;
    }

    public final void setUseNewContainer(Boolean bool) {
        this.useNewContainer = bool;
    }

    /* renamed from: isH5CoverGlobalProps, reason: from getter */
    public final Boolean getIsH5CoverGlobalProps() {
        return this.isH5CoverGlobalProps;
    }

    public final void setH5CoverGlobalProps(Boolean bool) {
        this.isH5CoverGlobalProps = bool;
    }

    public final boolean getEnableGeckoLoaderSecure() {
        return this.enableGeckoLoaderSecure;
    }

    public final void setEnableGeckoLoaderSecure(boolean z) {
        this.enableGeckoLoaderSecure = z;
    }

    public final boolean getEnableGlobalPropsCacheOptimize() {
        return this.enableGlobalPropsCacheOptimize;
    }

    public final void setEnableGlobalPropsCacheOptimize(boolean z) {
        this.enableGlobalPropsCacheOptimize = z;
    }

    public final boolean getEnableGlobalTemplateProvider() {
        return this.enableGlobalTemplateProvider;
    }

    public final void setEnableGlobalTemplateProvider(boolean z) {
        this.enableGlobalTemplateProvider = z;
    }

    public final boolean getEnableForestTemplateProvider() {
        return this.enableForestTemplateProvider;
    }

    public final void setEnableForestTemplateProvider(boolean z) {
        this.enableForestTemplateProvider = z;
    }

    public final boolean getEnableMixLogic() {
        return this.enableMixLogic;
    }

    public final void setEnableMixLogic(boolean z) {
        this.enableMixLogic = z;
    }

    public final boolean getEnableUploadImageTypeLimit() {
        return this.enableUploadImageTypeLimit;
    }

    public final void setEnableUploadImageTypeLimit(boolean z) {
        this.enableUploadImageTypeLimit = z;
    }

    public final int getEnableGlobalLayoutMemLeak() {
        return this.enableGlobalLayoutMemLeak;
    }

    public final void setEnableGlobalLayoutMemLeak(int i) {
        this.enableGlobalLayoutMemLeak = i;
    }

    public final boolean getEnableBridgeLeakFix() {
        return this.enableBridgeLeakFix;
    }

    public final void setEnableBridgeLeakFix(boolean z) {
        this.enableBridgeLeakFix = z;
    }

    public final boolean getEnableUploadFileTypeLimit() {
        return this.enableUploadFileTypeLimit;
    }

    public final void setEnableUploadFileTypeLimit(boolean z) {
        this.enableUploadFileTypeLimit = z;
    }

    public final boolean getRemoveRequestReadPermission() {
        return this.removeRequestReadPermission;
    }

    public final void setRemoveRequestReadPermission(boolean z) {
        this.removeRequestReadPermission = z;
    }

    public final boolean getEnableXBridgeContextLeakFix() {
        return this.enableXBridgeContextLeakFix;
    }

    public final void setEnableXBridgeContextLeakFix(boolean z) {
        this.enableXBridgeContextLeakFix = z;
    }

    public final boolean getEnableRedirectDefaultCache() {
        return this.enableRedirectDefaultCache;
    }

    public final void setEnableRedirectDefaultCache(boolean z) {
        this.enableRedirectDefaultCache = z;
    }

    public final boolean getEnableReloadContextMerge() {
        return this.enableReloadContextMerge;
    }

    public final void setEnableReloadContextMerge(boolean z) {
        this.enableReloadContextMerge = z;
    }

    /* renamed from: isJSBThreadOptEnable, reason: from getter */
    public final boolean getIsJSBThreadOptEnable() {
        return this.isJSBThreadOptEnable;
    }

    public final void setJSBThreadOptEnable(boolean z) {
        this.isJSBThreadOptEnable = z;
    }

    public final List<ThreadOptConfig> getJsbThreadOptConfig() {
        return this.jsbThreadOptConfig;
    }

    public final void setJsbThreadOptConfig(List<ThreadOptConfig> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.jsbThreadOptConfig = list;
    }

    public final boolean getEnableRemoveDouyinScreenInfoParams() {
        return this.enableRemoveDouyinScreenInfoParams;
    }

    public final void setEnableRemoveDouyinScreenInfoParams(boolean z) {
        this.enableRemoveDouyinScreenInfoParams = z;
    }

    public final boolean getSeparateVMSdkLoad() {
        return this.separateVMSdkLoad;
    }

    public final void setSeparateVMSdkLoad(boolean z) {
        this.separateVMSdkLoad = z;
    }

    public final Set<String> getBlockBid() {
        return this.blockBid;
    }

    public final void setBlockBid(Set<String> set) {
        this.blockBid = set;
    }

    public final Set<String> getBlockEntranceForm() {
        return this.blockEntranceForm;
    }

    public final void setBlockEntranceForm(Set<String> set) {
        this.blockEntranceForm = set;
    }

    public final List<String> getBlockSchema() {
        return this.blockSchema;
    }

    public final void setBlockSchema(List<String> list) {
        this.blockSchema = list;
    }

    public final boolean getEnableWebStandard() {
        return this.enableWebStandard;
    }

    public final void setEnableWebStandard(boolean z) {
        this.enableWebStandard = z;
    }

    public final boolean getShowTitle() {
        return this.showTitle;
    }

    public final void setShowTitle(boolean z) {
        this.showTitle = z;
    }

    public final boolean getAnnieFixWebUpload() {
        return this.annieFixWebUpload;
    }

    public final void setAnnieFixWebUpload(boolean z) {
        this.annieFixWebUpload = z;
    }

    public final Map<String, List<String>> getForestFmpResourceList() {
        return this.forestFmpResourceList;
    }

    public final void setForestFmpResourceList(Map<String, ? extends List<String>> map) {
        this.forestFmpResourceList = map;
    }

    public final Boolean getEnableFmpResourcePreload() {
        return this.enableFmpResourcePreload;
    }

    public final void setEnableFmpResourcePreload(Boolean bool) {
        this.enableFmpResourcePreload = bool;
    }

    public final boolean getEnableJsonOpt() {
        return this.enableJsonOpt;
    }

    public final void setEnableJsonOpt(boolean z) {
        this.enableJsonOpt = z;
    }

    public final boolean getAnnieXWorker() {
        return this.annieXWorker;
    }

    public final void setAnnieXWorker(boolean z) {
        this.annieXWorker = z;
    }

    public final String getResUrl() {
        return this.resUrl;
    }

    public final void setResUrl(String str) {
        this.resUrl = str;
    }

    /* renamed from: isOnlyLocal, reason: from getter */
    public final boolean getIsOnlyLocal() {
        return this.isOnlyLocal;
    }

    public final void setOnlyLocal(boolean z) {
        this.isOnlyLocal = z;
    }

    public final int getDelaySeconds() {
        return this.delaySeconds;
    }

    public final void setDelaySeconds(int i) {
        this.delaySeconds = i;
    }

    public final List<String> getPageInitWorkerList() {
        return this.pageInitWorkerList;
    }

    public final void setPageInitWorkerList(List<String> list) {
        this.pageInitWorkerList = list;
    }

    public final int getPageInitDelaySeconds() {
        return this.pageInitDelaySeconds;
    }

    public final void setPageInitDelaySeconds(int i) {
        this.pageInitDelaySeconds = i;
    }

    public final int getCardInitDelaySeconds() {
        return this.cardInitDelaySeconds;
    }

    public final void setCardInitDelaySeconds(int i) {
        this.cardInitDelaySeconds = i;
    }

    public final boolean getEnablePageInit() {
        return this.enablePageInit;
    }

    public final void setEnablePageInit(boolean z) {
        this.enablePageInit = z;
    }

    public final boolean getEnableDefaultInit() {
        return this.enableDefaultInit;
    }

    public final void setEnableDefaultInit(boolean z) {
        this.enableDefaultInit = z;
    }

    public final boolean getEnableCardInit() {
        return this.enableCardInit;
    }

    public final void setEnableCardInit(boolean z) {
        this.enableCardInit = z;
    }

    public final boolean getEnableNaEventReport() {
        return this.enableNaEventReport;
    }

    public final void setEnableNaEventReport(boolean z) {
        this.enableNaEventReport = z;
    }

    public final boolean getEnablePageEventReport() {
        return this.enablePageEventReport;
    }

    public final void setEnablePageEventReport(boolean z) {
        this.enablePageEventReport = z;
    }

    public final boolean getEnableBulletPreRenderGovern() {
        return this.enableBulletPreRenderGovern;
    }

    public final void setEnableBulletPreRenderGovern(boolean z) {
        this.enableBulletPreRenderGovern = z;
    }

    public final boolean getEnableJSBReleaseCache() {
        return this.enableJSBReleaseCache;
    }

    public final void setEnableJSBReleaseCache(boolean z) {
        this.enableJSBReleaseCache = z;
    }

    public final long getPreRenderMinFreeMemory() {
        return this.preRenderMinFreeMemory;
    }

    public final void setPreRenderMinFreeMemory(long j) {
        this.preRenderMinFreeMemory = j;
    }

    public final long getPreRenderMaxCacheTime() {
        return this.preRenderMaxCacheTime;
    }

    public final void setPreRenderMaxCacheTime(long j) {
        this.preRenderMaxCacheTime = j;
    }

    /* renamed from: isCheckEnable, reason: from getter */
    public final boolean getIsCheckEnable() {
        return this.isCheckEnable;
    }

    public final void setCheckEnable(boolean z) {
        this.isCheckEnable = z;
    }

    /* renamed from: isPureBlankCheckEnable, reason: from getter */
    public final boolean getIsPureBlankCheckEnable() {
        return this.isPureBlankCheckEnable;
    }

    public final void setPureBlankCheckEnable(boolean z) {
        this.isPureBlankCheckEnable = z;
    }

    /* renamed from: isPartialBlankCheckEnable, reason: from getter */
    public final boolean getIsPartialBlankCheckEnable() {
        return this.isPartialBlankCheckEnable;
    }

    public final void setPartialBlankCheckEnable(boolean z) {
        this.isPartialBlankCheckEnable = z;
    }

    public final long getCheckTimeoutMs() {
        return this.checkTimeoutMs;
    }

    public final void setCheckTimeoutMs(long j) {
        this.checkTimeoutMs = j;
    }

    public final long getSnapShotTimeoutMs() {
        return this.snapShotTimeoutMs;
    }

    public final void setSnapShotTimeoutMs(long j) {
        this.snapShotTimeoutMs = j;
    }

    public final float getSnapShotMaxQuality() {
        return this.snapShotMaxQuality;
    }

    public final void setSnapShotMaxQuality(float f) {
        this.snapShotMaxQuality = f;
    }

    public final float getPureColorCheckThreshold() {
        return this.pureColorCheckThreshold;
    }

    public final void setPureColorCheckThreshold(float f) {
        this.pureColorCheckThreshold = f;
    }

    public final long getPureColorCheckTimeoutMs() {
        return this.pureColorCheckTimeoutMs;
    }

    public final void setPureColorCheckTimeoutMs(long j) {
        this.pureColorCheckTimeoutMs = j;
    }

    public final long getPartialBlankCheckTimeoutMs() {
        return this.partialBlankCheckTimeoutMs;
    }

    public final void setPartialBlankCheckTimeoutMs(long j) {
        this.partialBlankCheckTimeoutMs = j;
    }

    public final long getDetectFrequencyInternal() {
        return this.detectFrequencyInternal;
    }

    public final void setDetectFrequencyInternal(long j) {
        this.detectFrequencyInternal = j;
    }

    public final boolean getEnableSceneRecognize() {
        return this.enableSceneRecognize;
    }

    public final void setEnableSceneRecognize(boolean z) {
        this.enableSceneRecognize = z;
    }

    public final long getPageStackSubscribeDelay() {
        return this.pageStackSubscribeDelay;
    }

    public final void setPageStackSubscribeDelay(long j) {
        this.pageStackSubscribeDelay = j;
    }

    public final boolean getEnableNaStackStore() {
        return this.enableNaStackStore;
    }

    public final void setEnableNaStackStore(boolean z) {
        this.enableNaStackStore = z;
    }

    public final boolean getEnableViewAttachWithoutSessionId() {
        return this.enableViewAttachWithoutSessionId;
    }

    public final void setEnableViewAttachWithoutSessionId(boolean z) {
        this.enableViewAttachWithoutSessionId = z;
    }

    public final Set<String> getPageStackBlackList() {
        return this.pageStackBlackList;
    }

    public final void setPageStackBlackList(Set<String> set) {
        this.pageStackBlackList = set;
    }

    public final Set<String> getPageStackWhiteList() {
        return this.pageStackWhiteList;
    }

    public final void setPageStackWhiteList(Set<String> set) {
        this.pageStackWhiteList = set;
    }

    public final boolean getEnableSceneBcmChainInfo() {
        return this.enableSceneBcmChainInfo;
    }

    public final void setEnableSceneBcmChainInfo(boolean z) {
        this.enableSceneBcmChainInfo = z;
    }

    public final int getBcmChainLength() {
        return this.bcmChainLength;
    }

    public final void setBcmChainLength(int i) {
        this.bcmChainLength = i;
    }

    /* renamed from: isDomainStandard, reason: from getter */
    public final boolean getIsDomainStandard() {
        return this.isDomainStandard;
    }

    public final void setDomainStandard(boolean z) {
        this.isDomainStandard = z;
    }

    public final long getHybridViewWindowDurationMs() {
        return this.hybridViewWindowDurationMs;
    }

    public final void setHybridViewWindowDurationMs(long j) {
        this.hybridViewWindowDurationMs = j;
    }

    public final long getPageStackWindowDurationMs() {
        return this.pageStackWindowDurationMs;
    }

    public final void setPageStackWindowDurationMs(long j) {
        this.pageStackWindowDurationMs = j;
    }

    public final int getHotUrlCacheMaxSize() {
        return this.hotUrlCacheMaxSize;
    }

    public final void setHotUrlCacheMaxSize(int i) {
        this.hotUrlCacheMaxSize = i;
    }

    public final double getSceneRecognizeJaccardThreshold() {
        return this.sceneRecognizeJaccardThreshold;
    }

    public final void setSceneRecognizeJaccardThreshold(double d) {
        this.sceneRecognizeJaccardThreshold = d;
    }

    public final double getSceneRecognizeCosineThreshold() {
        return this.sceneRecognizeCosineThreshold;
    }

    public final void setSceneRecognizeCosineThreshold(double d) {
        this.sceneRecognizeCosineThreshold = d;
    }

    public final int getRecentSceneLruCacheMaxSize() {
        return this.recentSceneLruCacheMaxSize;
    }

    public final void setRecentSceneLruCacheMaxSize(int i) {
        this.recentSceneLruCacheMaxSize = i;
    }

    public final int getSceneTableMaxCount() {
        return this.sceneTableMaxCount;
    }

    public final void setSceneTableMaxCount(int i) {
        this.sceneTableMaxCount = i;
    }

    public final int getTransitionTableMaxCount() {
        return this.transitionTableMaxCount;
    }

    public final void setTransitionTableMaxCount(int i) {
        this.transitionTableMaxCount = i;
    }

    public final long getSqliteDataExpireMs() {
        return this.sqliteDataExpireMs;
    }

    public final void setSqliteDataExpireMs(long j) {
        this.sqliteDataExpireMs = j;
    }

    public final int getSqliteCleanThreshold() {
        return this.sqliteCleanThreshold;
    }

    public final void setSqliteCleanThreshold(int i) {
        this.sqliteCleanThreshold = i;
    }

    public final int getSqliteTransFlushThreshold() {
        return this.sqliteTransFlushThreshold;
    }

    public final void setSqliteTransFlushThreshold(int i) {
        this.sqliteTransFlushThreshold = i;
    }

    public final int getCdnCacheMaxAge() {
        return this.cdnCacheMaxAge;
    }

    public final void setCdnCacheMaxAge(int i) {
        this.cdnCacheMaxAge = i;
    }

    public final int getForestNormalPoolSize() {
        return this.forestNormalPoolSize;
    }

    public final void setForestNormalPoolSize(int i) {
        this.forestNormalPoolSize = i;
    }

    public final int getForestPreloadPoolSize() {
        return this.forestPreloadPoolSize;
    }

    public final void setForestPreloadPoolSize(int i) {
        this.forestPreloadPoolSize = i;
    }

    public final boolean getEnableAnnieXBridgeThreadOpt() {
        return this.enableAnnieXBridgeThreadOpt;
    }

    public final void setEnableAnnieXBridgeThreadOpt(boolean z) {
        this.enableAnnieXBridgeThreadOpt = z;
    }

    public final boolean getEnableArgusFetchCdnConfigInternal() {
        return this.enableArgusFetchCdnConfigInternal;
    }

    public final void setEnableArgusFetchCdnConfigInternal(boolean z) {
        this.enableArgusFetchCdnConfigInternal = z;
    }

    public final boolean getEnablePadAdapterMigrationToUniformStyle() {
        return this.enablePadAdapterMigrationToUniformStyle;
    }

    public final void setEnablePadAdapterMigrationToUniformStyle(boolean z) {
        this.enablePadAdapterMigrationToUniformStyle = z;
    }

    public final List<String> getPadAdapterMigrationToUniformStyleWhiteList() {
        return this.padAdapterMigrationToUniformStyleWhiteList;
    }

    public final void setPadAdapterMigrationToUniformStyleWhiteList(List<String> list) {
        this.padAdapterMigrationToUniformStyleWhiteList = list;
    }

    public final boolean getEnablePadPopupMigrationToUniformStyle() {
        return this.enablePadPopupMigrationToUniformStyle;
    }

    public final void setEnablePadPopupMigrationToUniformStyle(boolean z) {
        this.enablePadPopupMigrationToUniformStyle = z;
    }

    public final List<String> getPadPopupMigrationToUniformStyleWhiteList() {
        return this.padPopupMigrationToUniformStyleWhiteList;
    }

    public final void setPadPopupMigrationToUniformStyleWhiteList(List<String> list) {
        this.padPopupMigrationToUniformStyleWhiteList = list;
    }

    public final boolean getEnableSecLinkReportEntry() {
        return this.enableSecLinkReportEntry;
    }

    public final void setEnableSecLinkReportEntry(boolean z) {
        this.enableSecLinkReportEntry = z;
    }

    public final boolean getEnableBulletSettingDelay() {
        return this.enableBulletSettingDelay;
    }

    public final void setEnableBulletSettingDelay(boolean z) {
        this.enableBulletSettingDelay = z;
    }

    public final LegoBootFinishCommitter getBulletSettingRunner() {
        return this.bulletSettingRunner;
    }

    public final void setBulletSettingRunner(LegoBootFinishCommitter legoBootFinishCommitter) {
        this.bulletSettingRunner = legoBootFinishCommitter;
    }

    public final boolean getEnableAnnieConvertJsonOpt() {
        return this.enableAnnieConvertJsonOpt;
    }

    public final void setEnableAnnieConvertJsonOpt(boolean z) {
        this.enableAnnieConvertJsonOpt = z;
    }

    public final boolean getEnableAnnieXPadGPContainerMigration() {
        return this.enableAnnieXPadGPContainerMigration;
    }

    public final void setEnableAnnieXPadGPContainerMigration(boolean z) {
        this.enableAnnieXPadGPContainerMigration = z;
    }

    public final boolean getFixAnnieXMethodFinder() {
        return this.fixAnnieXMethodFinder;
    }

    public final void setFixAnnieXMethodFinder(boolean z) {
        this.fixAnnieXMethodFinder = z;
    }
}
