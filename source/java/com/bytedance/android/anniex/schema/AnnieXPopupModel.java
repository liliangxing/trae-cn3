package com.bytedance.android.anniex.schema;

import android.content.Context;
import android.graphics.Color;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.ies.bullet.core.device.UIUtils;
import com.bytedance.ies.bullet.schema.param.GravityParam;
import com.bytedance.ies.bullet.schema.param.GravityType;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.schema.ISchemaMutableData;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.FloatParam;
import com.bytedance.ies.bullet.service.sdk.param.IntegerParam;
import com.bytedance.ies.bullet.service.sdk.param.PercentParam;
import com.bytedance.ies.bullet.service.sdk.param.PopupType;
import com.bytedance.ies.bullet.service.sdk.param.PopupTypeParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import com.bytedance.ies.bullet.service.sdk.param.UIColorParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXPopupModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b^\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010ë\u0001\u001a\u00030ì\u00012\b\u0010í\u0001\u001a\u00030î\u0001J\u0014\u0010ï\u0001\u001a\u00030ì\u00012\b\u0010í\u0001\u001a\u00030î\u0001H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010:\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0011\u0010?\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0011\u0010C\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\bD\u0010BR\u0011\u0010E\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\bF\u0010BR\u001c\u0010G\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010<\"\u0004\bI\u0010>R\u0011\u0010J\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\bK\u0010BR$\u0010M\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010R\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bS\u0010O\"\u0004\bT\u0010QR$\u0010U\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bV\u0010O\"\u0004\bW\u0010QR\u0011\u0010X\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\bY\u0010OR\u0011\u0010Z\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b[\u0010OR\u0011\u0010\\\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b]\u0010OR\u0011\u0010^\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b_\u0010OR\u0011\u0010`\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\ba\u0010OR\u0011\u0010b\u001a\u00020c8F¢\u0006\u0006\u001a\u0004\bd\u0010eR\u001c\u0010f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010<\"\u0004\bh\u0010>R\u001c\u0010i\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010<\"\u0004\bk\u0010>R\u001c\u0010l\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010<\"\u0004\bn\u0010>R\u0011\u0010o\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\bp\u0010OR$\u0010q\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\br\u0010O\"\u0004\bs\u0010QR$\u0010t\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bu\u0010O\"\u0004\bv\u0010QR\u0011\u0010w\u001a\u00020x8F¢\u0006\u0006\u001a\u0004\by\u0010zR\u0011\u0010{\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b|\u0010OR\u001f\u0010}\u001a\u0004\u0018\u00010~X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010<\"\u0005\b\u0085\u0001\u0010>R\u001f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010<\"\u0005\b\u0088\u0001\u0010>R\u001f\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010<\"\u0005\b\u008b\u0001\u0010>R\"\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R(\u0010\u0092\u0001\u001a\u00020@2\u0006\u0010L\u001a\u00020@8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\b\u0093\u0001\u0010B\"\u0006\b\u0094\u0001\u0010\u0095\u0001R'\u0010\u0096\u0001\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0097\u0001\u0010O\"\u0005\b\u0098\u0001\u0010QR\u0013\u0010\u0099\u0001\u001a\u00020@8F¢\u0006\u0007\u001a\u0005\b\u009a\u0001\u0010BR'\u0010\u009b\u0001\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u009c\u0001\u0010O\"\u0005\b\u009d\u0001\u0010QR'\u0010\u009e\u0001\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u009f\u0001\u0010O\"\u0005\b \u0001\u0010QR'\u0010¡\u0001\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¢\u0001\u0010O\"\u0005\b£\u0001\u0010QR'\u0010¤\u0001\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¥\u0001\u0010O\"\u0005\b¦\u0001\u0010QR'\u0010§\u0001\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b¨\u0001\u0010O\"\u0005\b©\u0001\u0010QR\u0013\u0010ª\u0001\u001a\u00020\u00158F¢\u0006\u0007\u001a\u0005\b«\u0001\u0010OR\u0013\u0010¬\u0001\u001a\u00020\u00158F¢\u0006\u0007\u001a\u0005\b\u00ad\u0001\u0010OR\u0013\u0010®\u0001\u001a\u00020\u00158F¢\u0006\u0007\u001a\u0005\b¯\u0001\u0010OR(\u0010±\u0001\u001a\u0004\u0018\u00010\u00152\t\u0010°\u0001\u001a\u0004\u0018\u00010\u0015@BX\u0086\u000e¢\u0006\f\n\u0002\u0010\u0016\u001a\u0006\b²\u0001\u0010³\u0001R(\u0010´\u0001\u001a\u0004\u0018\u00010\u00152\t\u0010°\u0001\u001a\u0004\u0018\u00010\u0015@BX\u0086\u000e¢\u0006\f\n\u0002\u0010\u0016\u001a\u0006\bµ\u0001\u0010³\u0001R(\u0010¶\u0001\u001a\u0004\u0018\u00010\u00152\t\u0010°\u0001\u001a\u0004\u0018\u00010\u0015@BX\u0086\u000e¢\u0006\f\n\u0002\u0010\u0016\u001a\u0006\b·\u0001\u0010³\u0001R(\u0010¸\u0001\u001a\u0004\u0018\u00010\u00152\t\u0010°\u0001\u001a\u0004\u0018\u00010\u0015@BX\u0086\u000e¢\u0006\f\n\u0002\u0010\u0016\u001a\u0006\b¹\u0001\u0010³\u0001R(\u0010º\u0001\u001a\u0004\u0018\u00010\u00152\t\u0010°\u0001\u001a\u0004\u0018\u00010\u0015@BX\u0086\u000e¢\u0006\f\n\u0002\u0010\u0016\u001a\u0006\b»\u0001\u0010³\u0001R\u0013\u0010¼\u0001\u001a\u00020\u00158F¢\u0006\u0007\u001a\u0005\b½\u0001\u0010OR\u0013\u0010¾\u0001\u001a\u00020@8F¢\u0006\u0007\u001a\u0005\b¿\u0001\u0010BR\u001f\u0010À\u0001\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÁ\u0001\u0010<\"\u0005\bÂ\u0001\u0010>R\u001f\u0010Ã\u0001\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÄ\u0001\u0010<\"\u0005\bÅ\u0001\u0010>R(\u0010Æ\u0001\u001a\u00020@2\u0006\u0010L\u001a\u00020@8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\bÇ\u0001\u0010B\"\u0006\bÈ\u0001\u0010\u0095\u0001R\u0013\u0010É\u0001\u001a\u00020\u00158F¢\u0006\u0007\u001a\u0005\bÊ\u0001\u0010OR'\u0010Ë\u0001\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÌ\u0001\u0010O\"\u0005\bÍ\u0001\u0010QR!\u0010Î\u0001\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÏ\u0001\u0010Ð\u0001\"\u0006\bÑ\u0001\u0010Ò\u0001R\u0013\u0010Ó\u0001\u001a\u00020@8F¢\u0006\u0007\u001a\u0005\bÔ\u0001\u0010BR\u001f\u0010Õ\u0001\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÖ\u0001\u0010<\"\u0005\b×\u0001\u0010>R\u001f\u0010Ø\u0001\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÙ\u0001\u0010<\"\u0005\bÚ\u0001\u0010>R\u0013\u0010Û\u0001\u001a\u00020@8F¢\u0006\u0007\u001a\u0005\bÜ\u0001\u0010BR'\u0010Ý\u0001\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÞ\u0001\u0010O\"\u0005\bß\u0001\u0010QR'\u0010à\u0001\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bá\u0001\u0010O\"\u0005\bâ\u0001\u0010QR\u0013\u0010ã\u0001\u001a\u00020@8F¢\u0006\u0007\u001a\u0005\bä\u0001\u0010BR'\u0010å\u0001\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bæ\u0001\u0010O\"\u0005\bç\u0001\u0010QR'\u0010è\u0001\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bé\u0001\u0010O\"\u0005\bê\u0001\u0010Q¨\u0006ð\u0001"}, d2 = {"Lcom/bytedance/android/anniex/schema/AnnieXPopupModel;", "Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "()V", "_autoShowNavBar", "Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "_closePositionRight", "_disableMaskClick", "_disableOutsideClickClose", "_enableEngineViewScroll", "_gravity", "Lcom/bytedance/ies/bullet/schema/param/GravityParam;", "_height", "Lcom/bytedance/ies/bullet/service/sdk/param/IntegerParam;", "_heightPercent", "Lcom/bytedance/ies/bullet/service/sdk/param/PercentParam;", "_horizontalHeight", "_horizontalHeightPercent", "_horizontalRadius", "_horizontalWidth", "_horizontalWidthPercent", "_intGravity", "", "Ljava/lang/Integer;", "_margin", "_marginBottom", "_marginRight", "_maskAlpha", "Lcom/bytedance/ies/bullet/service/sdk/param/FloatParam;", "_maskBgColor", "Lcom/bytedance/ies/bullet/service/sdk/param/UIColorParam;", "_pullDownClose", "_pullDownHeight", "_pullDownIndicatorColor", "Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;", "_pullDownIndicatorNotShow", "_radius", "_radiusBottomLeft", "_radiusBottomRight", "_radiusTopLeft", "_radiusTopRight", "_rateHeight", "_schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaMutableData;", "_schemaGravity", "_schemaHeight", "_schemaWidth", "_showBack", "_showPullDownIndicator", "_upFullScreen", "_upHeightPercent", "_upOffsetHeight", "_upTransStatusBar", "_useScreenHeight", "_width", "_widthPercent", "_windowFloating", "_xOffset", "_yOffset", "abandonCoordinate", "getAbandonCoordinate", "()Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "setAbandonCoordinate", "(Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;)V", "autoShowNavBar", "", "getAutoShowNavBar", "()Z", "canceledOnTouchOutside", "getCanceledOnTouchOutside", "closePositionRight", "getClosePositionRight", "disableChildScroll", "getDisableChildScroll", "setDisableChildScroll", "enableEngineViewScroll", "getEnableEngineViewScroll", StrategyConstants.VALUE, "gravity", "getGravity", "()I", "setGravity", "(I)V", "height", "getHeight", "setHeight", "heightPercent", "getHeightPercent", "setHeightPercent", "horizontalHeight", "getHorizontalHeight", "horizontalHeightPercent", "getHorizontalHeightPercent", "horizontalRadius", "getHorizontalRadius", "horizontalWidth", "getHorizontalWidth", "horizontalWidthPercent", "getHorizontalWidthPercent", "indicatorColor", "", "getIndicatorColor", "()Ljava/lang/String;", "landscapeCustomGravity", "getLandscapeCustomGravity", "setLandscapeCustomGravity", "landscapeCustomHeight", "getLandscapeCustomHeight", "setLandscapeCustomHeight", "landscapeCustomWidth", "getLandscapeCustomWidth", "setLandscapeCustomWidth", "margin", "getMargin", "marginBottom", "getMarginBottom", "setMarginBottom", "marginRight", "getMarginRight", "setMarginRight", "maskAlpha", "", "getMaskAlpha", "()F", "maskBgColor", "getMaskBgColor", "modelContext", "Landroid/content/Context;", "getModelContext", "()Landroid/content/Context;", "setModelContext", "(Landroid/content/Context;)V", "openAnimate", "getOpenAnimate", "setOpenAnimate", "padUsePhoneSize", "getPadUsePhoneSize", "setPadUsePhoneSize", "padUsePlayerBottomHeight", "getPadUsePlayerBottomHeight", "setPadUsePlayerBottomHeight", "popupType", "Lcom/bytedance/ies/bullet/service/sdk/param/PopupTypeParam;", "getPopupType", "()Lcom/bytedance/ies/bullet/service/sdk/param/PopupTypeParam;", "setPopupType", "(Lcom/bytedance/ies/bullet/service/sdk/param/PopupTypeParam;)V", "pullDownClose", "getPullDownClose", "setPullDownClose", "(Z)V", "pullDownHeight", "getPullDownHeight", "setPullDownHeight", "pullDownIndicatorNotShow", "getPullDownIndicatorNotShow", "radius", "getRadius", "setRadius", "radiusBottomLeft", "getRadiusBottomLeft", "setRadiusBottomLeft", "radiusBottomRight", "getRadiusBottomRight", "setRadiusBottomRight", "radiusTopLeft", "getRadiusTopLeft", "setRadiusTopLeft", "radiusTopRight", "getRadiusTopRight", "setRadiusTopRight", "rateHeight", "getRateHeight", "schemaGravity", "getSchemaGravity", "schemaHeight", "getSchemaHeight", "<set-?>", "schemaRadius", "getSchemaRadius", "()Ljava/lang/Integer;", "schemaRadiusBottomLeft", "getSchemaRadiusBottomLeft", "schemaRadiusBottomRight", "getSchemaRadiusBottomRight", "schemaRadiusTopLeft", "getSchemaRadiusTopLeft", "schemaRadiusTopRight", "getSchemaRadiusTopRight", "schemaWidth", "getSchemaWidth", "showBack", "getShowBack", "showDim", "getShowDim", "setShowDim", "showMask", "getShowMask", "setShowMask", "upFullScreen", "getUpFullScreen", "setUpFullScreen", "upHeightPercent", "getUpHeightPercent", "upOffsetHeight", "getUpOffsetHeight", "setUpOffsetHeight", "upStatusBarBgColor", "getUpStatusBarBgColor", "()Lcom/bytedance/ies/bullet/service/sdk/param/UIColorParam;", "setUpStatusBarBgColor", "(Lcom/bytedance/ies/bullet/service/sdk/param/UIColorParam;)V", "upTransStatusBar", "getUpTransStatusBar", "useBottomClose", "getUseBottomClose", "setUseBottomClose", "usePlayerBottomHeight", "getUsePlayerBottomHeight", "setUsePlayerBottomHeight", "useScreenHeight", "getUseScreenHeight", "width", "getWidth", "setWidth", "widthPercent", "getWidthPercent", "setWidthPercent", "windowFloating", "getWindowFloating", "xOffset", "getXOffset", "setXOffset", "yOffset", "getYOffset", "setYOffset", "initBaseData", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "initWithData", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXPopupModel implements ISchemaModel {
    private BooleanParam _autoShowNavBar;
    private BooleanParam _closePositionRight;
    private BooleanParam _disableMaskClick;
    private BooleanParam _disableOutsideClickClose;
    private BooleanParam _enableEngineViewScroll;
    private GravityParam _gravity;
    private IntegerParam _height;
    private PercentParam _heightPercent;
    private IntegerParam _horizontalHeight;
    private PercentParam _horizontalHeightPercent;
    private IntegerParam _horizontalRadius;
    private IntegerParam _horizontalWidth;
    private PercentParam _horizontalWidthPercent;
    private Integer _intGravity;
    private IntegerParam _margin;
    private IntegerParam _marginBottom;
    private IntegerParam _marginRight;
    private FloatParam _maskAlpha;
    private UIColorParam _maskBgColor;
    private BooleanParam _pullDownClose;
    private IntegerParam _pullDownHeight;
    private StringParam _pullDownIndicatorColor;
    private BooleanParam _pullDownIndicatorNotShow;
    private IntegerParam _radius;
    private IntegerParam _radiusBottomLeft;
    private IntegerParam _radiusBottomRight;
    private IntegerParam _radiusTopLeft;
    private IntegerParam _radiusTopRight;
    private IntegerParam _rateHeight;
    private ISchemaMutableData _schemaData;
    private GravityParam _schemaGravity;
    private IntegerParam _schemaHeight;
    private IntegerParam _schemaWidth;
    private BooleanParam _showBack;
    private BooleanParam _showPullDownIndicator;
    private BooleanParam _upFullScreen;
    private PercentParam _upHeightPercent;
    private IntegerParam _upOffsetHeight;
    private BooleanParam _upTransStatusBar;
    private BooleanParam _useScreenHeight;
    private IntegerParam _width;
    private PercentParam _widthPercent;
    private BooleanParam _windowFloating;
    private IntegerParam _xOffset;
    private IntegerParam _yOffset;
    private BooleanParam abandonCoordinate;
    private BooleanParam disableChildScroll;
    private BooleanParam landscapeCustomGravity;
    private BooleanParam landscapeCustomHeight;
    private BooleanParam landscapeCustomWidth;
    private Context modelContext;
    private BooleanParam openAnimate;
    private BooleanParam padUsePhoneSize;
    private BooleanParam padUsePlayerBottomHeight;
    private PopupTypeParam popupType;
    private Integer schemaRadius;
    private Integer schemaRadiusBottomLeft;
    private Integer schemaRadiusBottomRight;
    private Integer schemaRadiusTopLeft;
    private Integer schemaRadiusTopRight;
    private BooleanParam showDim;
    private BooleanParam showMask;
    private UIColorParam upStatusBarBgColor;
    private BooleanParam useBottomClose;
    private BooleanParam usePlayerBottomHeight;

    public final Context getModelContext() {
        return this.modelContext;
    }

    public final void setModelContext(Context context) {
        this.modelContext = context;
    }

    public final BooleanParam getAbandonCoordinate() {
        return this.abandonCoordinate;
    }

    public final void setAbandonCoordinate(BooleanParam booleanParam) {
        this.abandonCoordinate = booleanParam;
    }

    public final BooleanParam getDisableChildScroll() {
        return this.disableChildScroll;
    }

    public final void setDisableChildScroll(BooleanParam booleanParam) {
        this.disableChildScroll = booleanParam;
    }

    public final boolean getCanceledOnTouchOutside() {
        BooleanParam booleanParam = this._disableMaskClick;
        if (!(booleanParam != null ? Intrinsics.areEqual(booleanParam.getValue(), false) : false)) {
            return false;
        }
        BooleanParam booleanParam2 = this._disableOutsideClickClose;
        return booleanParam2 != null ? Intrinsics.areEqual(booleanParam2.getValue(), false) : false;
    }

    public final int getGravity() {
        GravityType gravityType;
        Integer num = this._intGravity;
        if (num == null) {
            GravityParam gravityParam = this._gravity;
            num = (gravityParam == null || (gravityType = (GravityType) gravityParam.getValue()) == null) ? null : Integer.valueOf(gravityType.getClientValue());
            if (num == null) {
                return 17;
            }
        }
        return num.intValue();
    }

    public final void setGravity(int i) {
        this._intGravity = Integer.valueOf(i);
    }

    public final int getHeight() {
        Integer num;
        IntegerParam integerParam = this._height;
        if (integerParam == null || (num = (Integer) integerParam.getValue()) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final void setHeight(int i) {
        ISchemaMutableData iSchemaMutableData = this._schemaData;
        if (iSchemaMutableData != null && this.modelContext != null) {
            Context context = this.modelContext;
            Intrinsics.checkNotNull(context);
            iSchemaMutableData.addParam("lynx_init_height", new IntegerParam(Integer.valueOf(UIUtils.dpToPx$anniex_release(i, context))), true);
        }
        this._height = new IntegerParam(Integer.valueOf(i));
    }

    public final int getHeightPercent() {
        Integer num;
        PercentParam percentParam = this._heightPercent;
        if (percentParam == null || (num = (Integer) percentParam.getValue()) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final void setHeightPercent(int i) {
        this._heightPercent = new PercentParam(Integer.valueOf(i));
    }

    public final boolean getClosePositionRight() {
        Boolean bool;
        BooleanParam booleanParam = this._closePositionRight;
        if (booleanParam == null || (bool = (Boolean) booleanParam.getValue()) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public final int getHorizontalHeight() {
        Integer num;
        IntegerParam integerParam = this._horizontalHeight;
        if (integerParam == null || (num = (Integer) integerParam.getValue()) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final int getHorizontalHeightPercent() {
        Integer num;
        PercentParam percentParam = this._horizontalHeightPercent;
        if (percentParam == null || (num = (Integer) percentParam.getValue()) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final int getHorizontalRadius() {
        Integer num;
        IntegerParam integerParam = this._horizontalRadius;
        if (integerParam == null || (num = (Integer) integerParam.getValue()) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final int getHorizontalWidth() {
        Integer num;
        IntegerParam integerParam = this._horizontalWidth;
        if (integerParam == null || (num = (Integer) integerParam.getValue()) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final int getHorizontalWidthPercent() {
        Integer num;
        PercentParam percentParam = this._horizontalWidthPercent;
        if (percentParam == null || (num = (Integer) percentParam.getValue()) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final BooleanParam getLandscapeCustomGravity() {
        return this.landscapeCustomGravity;
    }

    public final void setLandscapeCustomGravity(BooleanParam booleanParam) {
        this.landscapeCustomGravity = booleanParam;
    }

    public final BooleanParam getLandscapeCustomHeight() {
        return this.landscapeCustomHeight;
    }

    public final void setLandscapeCustomHeight(BooleanParam booleanParam) {
        this.landscapeCustomHeight = booleanParam;
    }

    public final BooleanParam getLandscapeCustomWidth() {
        return this.landscapeCustomWidth;
    }

    public final void setLandscapeCustomWidth(BooleanParam booleanParam) {
        this.landscapeCustomWidth = booleanParam;
    }

    public final int getMargin() {
        Integer num;
        IntegerParam integerParam = this._margin;
        if (integerParam == null || (num = (Integer) integerParam.getValue()) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final int getMarginBottom() {
        Integer num;
        IntegerParam integerParam = this._marginBottom;
        if (integerParam == null || (num = (Integer) integerParam.getValue()) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final void setMarginBottom(int i) {
        this._marginBottom = new IntegerParam(Integer.valueOf(i));
    }

    public final int getMarginRight() {
        Integer num;
        IntegerParam integerParam = this._marginRight;
        if (integerParam == null || (num = (Integer) integerParam.getValue()) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final void setMarginRight(int i) {
        this._marginRight = new IntegerParam(Integer.valueOf(i));
    }

    public final float getMaskAlpha() {
        Float f;
        FloatParam floatParam = this._maskAlpha;
        if (floatParam == null || (f = (Float) floatParam.getValue()) == null) {
            return 0.0f;
        }
        return f.floatValue();
    }

    public final int getMaskBgColor() {
        Integer num;
        UIColorParam uIColorParam = this._maskBgColor;
        return (uIColorParam == null || (num = (Integer) uIColorParam.getValue()) == null) ? Color.parseColor("#00FFFFFF") : num.intValue();
    }

    public final BooleanParam getOpenAnimate() {
        return this.openAnimate;
    }

    public final void setOpenAnimate(BooleanParam booleanParam) {
        this.openAnimate = booleanParam;
    }

    public final BooleanParam getPadUsePhoneSize() {
        return this.padUsePhoneSize;
    }

    public final void setPadUsePhoneSize(BooleanParam booleanParam) {
        this.padUsePhoneSize = booleanParam;
    }

    public final BooleanParam getPadUsePlayerBottomHeight() {
        return this.padUsePlayerBottomHeight;
    }

    public final void setPadUsePlayerBottomHeight(BooleanParam booleanParam) {
        this.padUsePlayerBottomHeight = booleanParam;
    }

    public final PopupTypeParam getPopupType() {
        return this.popupType;
    }

    public final void setPopupType(PopupTypeParam popupTypeParam) {
        this.popupType = popupTypeParam;
    }

    public final int getPullDownHeight() {
        Integer num;
        IntegerParam integerParam = this._pullDownHeight;
        if (integerParam == null || (num = (Integer) integerParam.getValue()) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final void setPullDownHeight(int i) {
        this._pullDownHeight = new IntegerParam(Integer.valueOf(i));
    }

    public final String getIndicatorColor() {
        String str;
        StringParam stringParam = this._pullDownIndicatorColor;
        return (stringParam == null || (str = (String) stringParam.getValue()) == null) ? "" : str;
    }

    public final boolean getPullDownClose() {
        Boolean bool;
        BooleanParam booleanParam = this._pullDownClose;
        if (booleanParam == null || (bool = (Boolean) booleanParam.getValue()) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final void setPullDownClose(boolean z) {
        this._pullDownClose = new BooleanParam(Boolean.valueOf(z));
    }

    public final boolean getPullDownIndicatorNotShow() {
        Boolean bool;
        BooleanParam booleanParam = this._pullDownIndicatorNotShow;
        if (booleanParam == null || (bool = (Boolean) booleanParam.getValue()) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final int getRadius() {
        Integer num;
        IntegerParam integerParam = this._radius;
        if (integerParam == null || (num = (Integer) integerParam.getValue()) == null) {
            return 8;
        }
        return num.intValue();
    }

    public final void setRadius(int i) {
        this._radius = new IntegerParam(Integer.valueOf(i));
    }

    public final int getRadiusTopLeft() {
        Integer num;
        IntegerParam integerParam = this._radiusTopLeft;
        if (integerParam == null || (num = (Integer) integerParam.getValue()) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final void setRadiusTopLeft(int i) {
        this._radiusTopLeft = new IntegerParam(Integer.valueOf(i));
    }

    public final int getRadiusTopRight() {
        Integer num;
        IntegerParam integerParam = this._radiusTopRight;
        if (integerParam == null || (num = (Integer) integerParam.getValue()) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final void setRadiusTopRight(int i) {
        this._radiusTopRight = new IntegerParam(Integer.valueOf(i));
    }

    public final int getRadiusBottomLeft() {
        Integer num;
        IntegerParam integerParam = this._radiusBottomLeft;
        if (integerParam == null || (num = (Integer) integerParam.getValue()) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final void setRadiusBottomLeft(int i) {
        this._radiusBottomLeft = new IntegerParam(Integer.valueOf(i));
    }

    public final int getRadiusBottomRight() {
        Integer num;
        IntegerParam integerParam = this._radiusBottomRight;
        if (integerParam == null || (num = (Integer) integerParam.getValue()) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final void setRadiusBottomRight(int i) {
        this._radiusBottomRight = new IntegerParam(Integer.valueOf(i));
    }

    public final int getRateHeight() {
        Integer num;
        IntegerParam integerParam = this._rateHeight;
        if (integerParam == null || (num = (Integer) integerParam.getValue()) == null) {
            return -1;
        }
        return num.intValue();
    }

    public final BooleanParam getShowDim() {
        return this.showDim;
    }

    public final void setShowDim(BooleanParam booleanParam) {
        this.showDim = booleanParam;
    }

    public final BooleanParam getShowMask() {
        return this.showMask;
    }

    public final void setShowMask(BooleanParam booleanParam) {
        this.showMask = booleanParam;
    }

    public final boolean getUpFullScreen() {
        Boolean bool;
        BooleanParam booleanParam = this._upFullScreen;
        if (booleanParam == null || (bool = (Boolean) booleanParam.getValue()) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final void setUpFullScreen(boolean z) {
        this._upFullScreen = new BooleanParam(Boolean.valueOf(z));
    }

    public final int getUpHeightPercent() {
        Integer num;
        PercentParam percentParam = this._upHeightPercent;
        if (percentParam == null || (num = (Integer) percentParam.getValue()) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final int getUpOffsetHeight() {
        Integer num;
        IntegerParam integerParam = this._upOffsetHeight;
        if (integerParam == null || (num = (Integer) integerParam.getValue()) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final void setUpOffsetHeight(int i) {
        this._upOffsetHeight = new IntegerParam(Integer.valueOf(i));
    }

    public final UIColorParam getUpStatusBarBgColor() {
        return this.upStatusBarBgColor;
    }

    public final void setUpStatusBarBgColor(UIColorParam uIColorParam) {
        this.upStatusBarBgColor = uIColorParam;
    }

    public final boolean getUpTransStatusBar() {
        Boolean bool;
        BooleanParam booleanParam = this._upTransStatusBar;
        if (booleanParam == null || (bool = (Boolean) booleanParam.getValue()) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final BooleanParam getUseBottomClose() {
        return this.useBottomClose;
    }

    public final void setUseBottomClose(BooleanParam booleanParam) {
        this.useBottomClose = booleanParam;
    }

    public final BooleanParam getUsePlayerBottomHeight() {
        return this.usePlayerBottomHeight;
    }

    public final void setUsePlayerBottomHeight(BooleanParam booleanParam) {
        this.usePlayerBottomHeight = booleanParam;
    }

    public final boolean getUseScreenHeight() {
        Boolean bool;
        BooleanParam booleanParam = this._useScreenHeight;
        if (booleanParam == null || (bool = (Boolean) booleanParam.getValue()) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final int getWidth() {
        Integer num;
        IntegerParam integerParam = this._width;
        if (integerParam == null || (num = (Integer) integerParam.getValue()) == null) {
            return 300;
        }
        return num.intValue();
    }

    public final void setWidth(int i) {
        ISchemaMutableData iSchemaMutableData = this._schemaData;
        if (iSchemaMutableData != null && this.modelContext != null) {
            Context context = this.modelContext;
            Intrinsics.checkNotNull(context);
            iSchemaMutableData.addParam("lynx_init_width", new IntegerParam(Integer.valueOf(UIUtils.dpToPx$anniex_release(i, context))), true);
        }
        this._width = new IntegerParam(Integer.valueOf(i));
    }

    public final int getWidthPercent() {
        Integer num;
        PercentParam percentParam = this._widthPercent;
        if (percentParam == null || (num = (Integer) percentParam.getValue()) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final void setWidthPercent(int i) {
        this._widthPercent = new PercentParam(Integer.valueOf(i));
    }

    public final int getXOffset() {
        Integer num;
        IntegerParam integerParam = this._xOffset;
        if (integerParam == null || (num = (Integer) integerParam.getValue()) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final void setXOffset(int i) {
        this._xOffset = new IntegerParam(Integer.valueOf(i));
    }

    public final int getYOffset() {
        Integer num;
        IntegerParam integerParam = this._yOffset;
        if (integerParam == null || (num = (Integer) integerParam.getValue()) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final void setYOffset(int i) {
        this._yOffset = new IntegerParam(Integer.valueOf(i));
    }

    public final boolean getWindowFloating() {
        Boolean bool;
        BooleanParam booleanParam = this._windowFloating;
        if (booleanParam == null || (bool = (Boolean) booleanParam.getValue()) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public final boolean getEnableEngineViewScroll() {
        Boolean bool;
        BooleanParam booleanParam = this._enableEngineViewScroll;
        if (booleanParam == null || (bool = (Boolean) booleanParam.getValue()) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean getAutoShowNavBar() {
        Boolean bool;
        BooleanParam booleanParam = this._autoShowNavBar;
        if (booleanParam == null || (bool = (Boolean) booleanParam.getValue()) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean getShowBack() {
        Boolean bool;
        BooleanParam booleanParam = this._showBack;
        if (booleanParam == null || (bool = (Boolean) booleanParam.getValue()) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final int getSchemaWidth() {
        Integer num;
        IntegerParam integerParam = this._schemaWidth;
        if (integerParam == null || (num = (Integer) integerParam.getValue()) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final int getSchemaHeight() {
        Integer num;
        IntegerParam integerParam = this._schemaHeight;
        if (integerParam == null || (num = (Integer) integerParam.getValue()) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final int getSchemaGravity() {
        GravityType gravityType;
        GravityParam gravityParam = this._schemaGravity;
        if (gravityParam == null || (gravityType = (GravityType) gravityParam.getValue()) == null) {
            return 17;
        }
        return gravityType.getClientValue();
    }

    public final Integer getSchemaRadius() {
        return this.schemaRadius;
    }

    public final Integer getSchemaRadiusTopLeft() {
        return this.schemaRadiusTopLeft;
    }

    public final Integer getSchemaRadiusTopRight() {
        return this.schemaRadiusTopRight;
    }

    public final Integer getSchemaRadiusBottomLeft() {
        return this.schemaRadiusBottomLeft;
    }

    public final Integer getSchemaRadiusBottomRight() {
        return this.schemaRadiusBottomRight;
    }

    public void initWithData(ISchemaData schemaData) {
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        initBaseData(schemaData);
        this.abandonCoordinate = new BooleanParam(schemaData, "abandon_coordinate", false);
        this.disableChildScroll = new BooleanParam(schemaData, "disable_nested_child_scroll", false);
        this._disableMaskClick = new BooleanParam(schemaData, "mask_click_disable", false);
        this._disableOutsideClickClose = new BooleanParam(schemaData, "disable_outside_click_close", false);
        this._schemaHeight = new IntegerParam(schemaData, "height", 0);
        this._heightPercent = new PercentParam(schemaData, "height_percent", (Integer) null);
        this._horizontalHeight = new IntegerParam(schemaData, "horizontal_height", 0);
        this._horizontalHeightPercent = new PercentParam(schemaData, "horizontal_height_percent", 0);
        this._horizontalRadius = new IntegerParam(schemaData, "horizontal_radius", -1);
        this._horizontalWidth = new IntegerParam(schemaData, "horizontal_width", 0);
        this._horizontalWidthPercent = new PercentParam(schemaData, "horizontal_width_percent", 0);
        this.landscapeCustomGravity = new BooleanParam(schemaData, "landscape_custom_gravity", false);
        this.landscapeCustomHeight = new BooleanParam(schemaData, "landscape_custom_height", false);
        this.landscapeCustomWidth = new BooleanParam(schemaData, "landscape_custom_width", false);
        this._margin = new IntegerParam(schemaData, "margin", 0);
        this._marginBottom = new IntegerParam(schemaData, "margin_bottom", 0);
        this._marginRight = new IntegerParam(schemaData, "margin_right", 0);
        this._maskAlpha = new FloatParam(schemaData, "mask_alpha", Float.valueOf(0.0f));
        this._maskBgColor = new UIColorParam(schemaData, "mask_bg_color", (Integer) null);
        this.openAnimate = new BooleanParam(schemaData, "open_animate", true);
        this.padUsePhoneSize = new BooleanParam(schemaData, "pad_use_phone_size", false);
        this.padUsePlayerBottomHeight = new BooleanParam(schemaData, "pad_use_player_bottom_height", false);
        this.popupType = new PopupTypeParam(schemaData, "popup_type", PopupType.BOTTOM);
        this._pullDownHeight = new IntegerParam(schemaData, "pull_down_height", 0);
        this._pullDownIndicatorColor = new StringParam(schemaData, "pull_down_indicator_color", "");
        this._rateHeight = new IntegerParam(schemaData, "rate_height", (Integer) null);
        this.showDim = new BooleanParam(schemaData, "show_dim", false);
        this.showMask = new BooleanParam(schemaData, "show_mask", false);
        this._showPullDownIndicator = new BooleanParam(schemaData, "show_pull_down_indicator", false);
        this._pullDownClose = new BooleanParam(schemaData, "pull_down_close", false);
        this._pullDownIndicatorNotShow = new BooleanParam(schemaData, "pull_down_indicator_not_show", false);
        this._upFullScreen = new BooleanParam(schemaData, "up_full_screen", false);
        this._upHeightPercent = new PercentParam(schemaData, "up_height_percent", 0);
        this._upOffsetHeight = new IntegerParam(schemaData, "up_offset_height", -1);
        this.upStatusBarBgColor = new UIColorParam(schemaData, "up_status_bar_bg_color", (Integer) null);
        this._upTransStatusBar = new BooleanParam(schemaData, "up_trans_status_bar", false);
        this.useBottomClose = new BooleanParam(schemaData, "use_bottom_close", false);
        this.usePlayerBottomHeight = new BooleanParam(schemaData, "use_player_bottom_height", false);
        this._useScreenHeight = new BooleanParam(schemaData, "use_screen_height", false);
        this._schemaWidth = new IntegerParam(schemaData, "width", 0);
        this._widthPercent = new PercentParam(schemaData, "width_percent", (Integer) null);
        this._xOffset = new IntegerParam(schemaData, "x_offset", 0);
        this._yOffset = new IntegerParam(schemaData, "y_offset", 0);
        this._closePositionRight = new BooleanParam(schemaData, "close_position_right", true);
        this._windowFloating = new BooleanParam(schemaData, "window_floating", true);
        this._enableEngineViewScroll = new BooleanParam(schemaData, "enable_engine_view_scroll", false);
        this._autoShowNavBar = new BooleanParam(schemaData, "auto_show_nav_bar", false);
        this._showBack = new BooleanParam(schemaData, "show_back", false);
        this._schemaData = (ISchemaMutableData) schemaData;
        this._schemaGravity = new GravityParam(schemaData, "gravity", GravityType.CENTER);
        this.schemaRadius = (Integer) new IntegerParam(schemaData, "radius", (Integer) null).getValue();
        this.schemaRadiusTopLeft = (Integer) new IntegerParam(schemaData, "radius_top_left", (Integer) null).getValue();
        this.schemaRadiusTopRight = (Integer) new IntegerParam(schemaData, "radius_top_right", (Integer) null).getValue();
        this.schemaRadiusBottomLeft = (Integer) new IntegerParam(schemaData, "radius_bottom_left", (Integer) null).getValue();
        this.schemaRadiusBottomRight = (Integer) new IntegerParam(schemaData, "radius_bottom_right", (Integer) null).getValue();
    }

    public final void initBaseData(ISchemaData schemaData) {
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        this._gravity = new GravityParam(schemaData, "gravity", GravityType.CENTER);
        this._width = new IntegerParam(schemaData, "width", 300);
        this._height = new IntegerParam(schemaData, "height", 400);
        this._radius = new IntegerParam(schemaData, "radius", 8);
        this._radiusTopLeft = new IntegerParam(schemaData, "radius_top_left", (Integer) null);
        this._radiusTopRight = new IntegerParam(schemaData, "radius_top_right", (Integer) null);
        this._radiusBottomLeft = new IntegerParam(schemaData, "radius_bottom_left", (Integer) null);
        this._radiusBottomRight = new IntegerParam(schemaData, "radius_bottom_right", (Integer) null);
        this._intGravity = null;
    }
}
