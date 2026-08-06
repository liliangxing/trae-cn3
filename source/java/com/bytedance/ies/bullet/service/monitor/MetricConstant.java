package com.bytedance.ies.bullet.service.monitor;

import kotlin.Deprecated;
import kotlin.Metadata;

/* compiled from: MetricConstant.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0003\b¯\u0001\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002²\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010U\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\bV\u0010\u0002R\u000e\u0010W\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u007f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0080\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0081\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0082\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0083\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0084\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0087\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0088\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008a\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008b\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008c\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008d\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008e\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008f\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0090\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0091\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0092\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0093\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0094\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0095\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0096\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0097\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0098\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0099\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u009a\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u009b\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u009c\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u009d\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u009e\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u009f\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010 \u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¡\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¢\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010£\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¤\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¥\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¦\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010§\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¨\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010©\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010ª\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010«\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¬\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u00ad\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010®\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¯\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010°\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010±\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006³\u0001"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/MetricConstant;", "", "()V", "ADD_TAG_VIEW", "", "ANNIEX_LYNXENGINE_LOAD", "ANNIEX_LYNXENGINE_LOAD_TEMPLATE_WITH_URL", "ANNIEX_LYNXENGINE_ON_LOAD_FAILED", "ANNIEX_LYNXENGINE_SET_NPTH_LAST_URL", "ANNIEX_LYNXVIEW_DESTROY", "ANNIEX_LYNXVIEW_FLUSH_ALL_STICKY_EVENTS", "ANNIEX_LYNXVIEW_INIT_BLOCK", "ANNIEX_LYNXVIEW_INIT_JSB", "ANNIEX_LYNXVIEW_LOAD", "ANNIEX_LYNXVIEW_LOAD_TEMPLATE_WITH_URL", "ANNIEX_LYNXVIEW_ON_DETACHED_FROM_WINDOW", "ANNIEX_LYNXVIEW_ON_LOAD_FAILED", "ANNIEX_LYNXVIEW_RELOAD_TEMPLATE", "ANNIEX_LYNXVIEW_RENDER_SSR_HYDRATE", "ANNIEX_LYNXVIEW_RENDER_TEMPLATE_BUNDLE", "ANNIEX_LYNXVIEW_RESET_DATA", "ANNIEX_LYNXVIEW_SEND_EVENT", "ANNIEX_LYNXVIEW_SET_NPTH_LAST_URL", "ANNIEX_LYNXVIEW_UPDATE_DATA", "ANNIEX_LYNX_MODEL_BUILDER_BUILD", "ANNIEX_LYNX_MODEL_BUILDER_COPY", "ANNIEX_LYNX_MODEL_BUILDER_PRE_BUILD", "ANNIE_BIZ_HOST_VALUE", "ANNIE_VIEW_TYPE", "API_REQUEST", "API_REQUEST_END", "API_REQUEST_START", "BEFORE_BULLET", "BULLET_GLOBAL_PROPS_COST", "BULLET_INIT", "BULLET_VIEW_CREATE", "BULLET_VIEW_RELEASE", "CHECK_LYNX_ENGINE_FILE", "CHECK_LYNX_FILE", "CONTAINER_ATTACH", "CONTAINER_CREATE", "CONTAINER_DETACH", "CONTAINER_DURATION", "CONTAINER_EXIT", "CONTAINER_INIT_END", "CONTAINER_INIT_START", "CONTAINER_NAME", "CREATE_LYNX", "CREATE_LYNXVIEW", "CREATE_TO_LOAD", "CREATE_TO_LOAD_URL", "CREATE_TO_PAGE_START", "CREATE_TO_RL", "CREATE_TO_START_RENDER", "CREATE_WEBVIEW", "DEVICE_PROPS_COST", "DOWNLOAD_TEMPLATE", "DOWNLOAD_TEMPLATE_END", "DOWNLOAD_TEMPLATE_START", "DRAW_END", "ENABLE_LITE_PAGE_ANNIE_CACHE_PARAM", "FCP_TIME", "FIELD_BIZ", "FIELD_CLIENT_COMPONENT", "FIELD_CORE_VIEW_TYPE", "FIELD_VIEW_TYPE", "FIRST_SCREEN", "FLOW_PAGE_CACHE_PARAM", "FULL_TIME", "GET_COMMON_APP_GLOBAL_PROPS", "GET_COMMON_GLOBAL_PROPS", "GET_COMMON_PAGE_GLOBAL_PROPS", "GET_DEVICE_PROPS", "GET_LYNX_COMMON_GLOBAL_PROPS", "GET_PAGE_DYNAMIC_GLOBAL_PROPS", "GET_PAGE_GLOBAL_PROPS", "GET_URI_GLOBAL_PROPS", "GET_WEB_COMMON_GLOBAL_PROPS", "GLOBAL_PROPS_CACHE_OPTIMIZE", "INIT_ANNIEX_LYNXVIEW", "INIT_DEBUG_TAG", "INIT_LYNXENGINE_BUILDER", "INIT_LYNXENGINE_BUILDER_IN_LYNX", "INIT_LYNXVIEW_BUILDER", "INIT_LYNXVIEW_BUILDER_IN_LYNX", "INIT_TIME_STAMP", "getINIT_TIME_STAMP$annotations", "INIT_TO_START_RENDER", "IS_DATA_INJECTED", "IS_FROM_ENGINE", "JSB_REGISTER", "JSB_REGISTER_END", "JSB_REGISTER_START", "KIT_LOAD_START", "LOADER_TASK", "LOAD_TO_KIT_VIEW_CREATE", "LOAD_URL_TO_PAGE_START", "LYNXVIEW_BUILDER_ADD_BEHAVIORS", "LYNXVIEW_BUILDER_REGISTER_MODULE", "LYNX_ASYNC_LAYOUT_RESULT", "LYNX_FIRST_SCREEN", "LYNX_INSTALL_DYNAMIC_FEATURE", "LYNX_IS_ASYNC_LAYOUT", "LYNX_LOAD_SUCCESS", "LYNX_MODEL_INIT", "LYNX_MODEL_INIT_END", "LYNX_MODEL_INIT_START", "LYNX_PAGE_START", "LYNX_READ_TEMPLATE_BEGIN", "LYNX_READ_TEMPLATE_END", "LYNX_RENDER", "LYNX_RENDER_BEGIN", "LYNX_RENDER_END", "MERGE_GLOBAL_PROPS", "MONITOR_STAGE_DOWNLOAD_TEMPLATE", "MONITOR_STAGE_LOAD_TEMPLATE", "MONITOR_STAGE_UPDATE", "PAGE_COMMIT_DURATION", "PAGE_COMMIT_END", "PAGE_COMMIT_START", "PARSE_CARD_SCHEMA", "PERF_TRACE_GET_LYNX_BRIDGE", "PREPARE_ENGINE_LOAD_END", "PREPARE_ENGINE_LOAD_START", "PUT_PREFETCH_GLOBAL_PROPS", "PUT_QUERY_ITEMS", "PUT_SCHEME_ITEMS", "PUT_STORAGE_GLOBAL_PROPS", "QUEUE_IDLE", "READ_TEMPLATE", "REGISTER_MODULE", "RENDER_COST", "RENDER_SSR", "RENDER_TEMPLATE", "RENDER_TEMPLATE_MAIN", "RESOURCE_LOAD", "RL_TO_RENDER", "ROUTER_OPEN", "ROUTER_PRE_OPEN", "ROUTER_TO_CREATE", "SCHEMA_CONVERT", "SCHEMA_END", "SCHEMA_START", "SDK_TYPE", "SEC_ABOUT_TO_LOAD_URL_END", "SEC_ABOUT_TO_LOAD_URL_START", "SEC_CONTAINER_CREATED_END", "SEC_CONTAINER_CREATED_START", "SEC_CREATE_CONTAINER_END", "SEC_CREATE_CONTAINER_START", "SEC_INIT_TO_START_RENDER", "SEC_LOAD_URL_TO_PAGE_START", "SEC_TRULY_LOAD_URL_INTERVAL", "SEC_WEB_LOAD_URL_END", "SEC_WEB_LOAD_URL_START", "SEC_WEB_REDIRECT_END", "SEC_WEB_REDIRECT_START", "STAY_DURATION", "TRACERT_ID", "TRACERT_INIT", "TRACE_BUILD_ANNIEX_LYNX_MODEL", "TRACE_CREATE_ANNIEX_LYNX_ENGINE", "TRACE_CREATE_ANNIEX_LYNX_VIEW", "TRACE_CREATE_ANNIEX_LYNX_VIEW_FROM_ENGINE", "TRACE_INIT_CANVAS_SETTINGS", "TRACE_INIT_MONITOR", "UPDATE_DRAW_END", "UPDATE_GLOBAL_PROPS", "UPDATE_LYNXVIEW_BUILDER_PARAMS", "VIEW_CREATE_END", "VIEW_CREATE_START", "VIEW_ENTER_BACKGROUND", "VIEW_ENTER_FOREGROUND", "WEB_LOAD_URL", "WEB_MODEL_INIT", "WEB_PAGE_FINISH", "WEB_PAGE_START", "WEB_RENDER", "StdMetric", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class MetricConstant {
    public static final String ADD_TAG_VIEW = "AnnieXLynxView:addTagView";
    public static final String ANNIEX_LYNXENGINE_LOAD = "AnnieXLynxEngine:load";
    public static final String ANNIEX_LYNXENGINE_LOAD_TEMPLATE_WITH_URL = "AnnieXLynxEngine:loadTemplateWithUrl";
    public static final String ANNIEX_LYNXENGINE_ON_LOAD_FAILED = "AnnieXLynxEngine:onLoadFail";
    public static final String ANNIEX_LYNXENGINE_SET_NPTH_LAST_URL = "AnnieXLynxEngine:setNpthLastUrl";
    public static final String ANNIEX_LYNXVIEW_DESTROY = "AnnieXLynxView:destroy";
    public static final String ANNIEX_LYNXVIEW_FLUSH_ALL_STICKY_EVENTS = "AnnieXLynxView:flushAllStickyEvents";
    public static final String ANNIEX_LYNXVIEW_INIT_BLOCK = "AnnieXLynxView:init_block";
    public static final String ANNIEX_LYNXVIEW_INIT_JSB = "AnnieXLynxView:initBridge";
    public static final String ANNIEX_LYNXVIEW_LOAD = "AnnieXLynxView:load";
    public static final String ANNIEX_LYNXVIEW_LOAD_TEMPLATE_WITH_URL = "AnnieXLynxView:loadTemplateWithUrl";
    public static final String ANNIEX_LYNXVIEW_ON_DETACHED_FROM_WINDOW = "AnnieXLynxView:onDetachedFromWindow";
    public static final String ANNIEX_LYNXVIEW_ON_LOAD_FAILED = "AnnieXLynxView:onLoadFail";
    public static final String ANNIEX_LYNXVIEW_RELOAD_TEMPLATE = "AnnieXLynxView:reloadTemplate";
    public static final String ANNIEX_LYNXVIEW_RENDER_SSR_HYDRATE = "AnnieXLynxView:renderSSRHydrate";
    public static final String ANNIEX_LYNXVIEW_RENDER_TEMPLATE_BUNDLE = "AnnieXLynxView:renderTemplateBundle";
    public static final String ANNIEX_LYNXVIEW_RESET_DATA = "AnnieXLynxView:resetData";
    public static final String ANNIEX_LYNXVIEW_SEND_EVENT = "AnnieXLynxView:sendEvent";
    public static final String ANNIEX_LYNXVIEW_SET_NPTH_LAST_URL = "AnnieXLynxView:setNpthLastUrl";
    public static final String ANNIEX_LYNXVIEW_UPDATE_DATA = "AnnieXLynxView:updateData";
    public static final String ANNIEX_LYNX_MODEL_BUILDER_BUILD = "AnnieXLynxModelBuilder:build";
    public static final String ANNIEX_LYNX_MODEL_BUILDER_COPY = "AnnieXLynxModelBuilder:copy";
    public static final String ANNIEX_LYNX_MODEL_BUILDER_PRE_BUILD = "AnnieXLynxModelBuilder:preBuild";
    public static final String ANNIE_BIZ_HOST_VALUE = "host";
    public static final String ANNIE_VIEW_TYPE = "annie_view_type";
    public static final String API_REQUEST = "api_request_duration";
    public static final String API_REQUEST_END = "api_request_end";
    public static final String API_REQUEST_START = "api_request_start";
    public static final String BEFORE_BULLET = "before_bullet_duration";
    public static final String BULLET_GLOBAL_PROPS_COST = "bullet_global_props_cost";
    public static final String BULLET_INIT = "containerInitTime";
    public static final String BULLET_VIEW_CREATE = "bullet_view_create";
    public static final String BULLET_VIEW_RELEASE = "bullet_view_release";
    public static final String CHECK_LYNX_ENGINE_FILE = "AnnieXLynxEngine:checkLynxFile";
    public static final String CHECK_LYNX_FILE = "AnnieXLynxView:checkLynxFile";
    public static final String CONTAINER_ATTACH = "view_attach";
    public static final String CONTAINER_CREATE = "container_create";
    public static final String CONTAINER_DETACH = "view_detach";
    public static final String CONTAINER_DURATION = "container_duration";
    public static final String CONTAINER_EXIT = "view_exit";
    public static final String CONTAINER_INIT_END = "container_init_end";
    public static final String CONTAINER_INIT_START = "container_init_start";
    public static final String CONTAINER_NAME = "container_name";
    public static final String CREATE_LYNX = "create_lynx";
    public static final String CREATE_LYNXVIEW = "create_lynxview";
    public static final String CREATE_TO_LOAD = "create_to_load";
    public static final String CREATE_TO_LOAD_URL = "kitcreate_to_loadurl";
    public static final String CREATE_TO_PAGE_START = "kitcreate_to_pagestart";
    public static final String CREATE_TO_RL = "kitcreate_to_rl";
    public static final String CREATE_TO_START_RENDER = "create_to_start_render";
    public static final String CREATE_WEBVIEW = "create_webview";
    public static final String DEVICE_PROPS_COST = "device_props_cost";
    public static final String DOWNLOAD_TEMPLATE = "download_template";
    public static final String DOWNLOAD_TEMPLATE_END = "prepare_template_end";
    public static final String DOWNLOAD_TEMPLATE_START = "prepare_template_start";
    public static final String DRAW_END = "draw_end";
    public static final String ENABLE_LITE_PAGE_ANNIE_CACHE_PARAM = "enable_lite_page_annie_cache_param";
    public static final String FCP_TIME = "fcp_time";
    public static final String FIELD_BIZ = "biz";
    public static final String FIELD_CLIENT_COMPONENT = "client_component";
    public static final String FIELD_CORE_VIEW_TYPE = "core_view_type";
    public static final String FIELD_VIEW_TYPE = "view_type";
    public static final String FIRST_SCREEN = "first_screen";
    public static final String FLOW_PAGE_CACHE_PARAM = "flow_page_cache_param";
    public static final String FULL_TIME = "full_time";
    public static final String GET_COMMON_APP_GLOBAL_PROPS = "GlobalPropsHelper:getCommonAppProps";
    public static final String GET_COMMON_GLOBAL_PROPS = "GlobalPropsHelper:getCommonGlobalProps";
    public static final String GET_COMMON_PAGE_GLOBAL_PROPS = "GlobalPropsHelper:getCommonPageProps";
    public static final String GET_DEVICE_PROPS = "GlobalPropsHelper:getDeviceProps";
    public static final String GET_LYNX_COMMON_GLOBAL_PROPS = "GlobalPropsHelper:getLynxCommonProps";
    public static final String GET_PAGE_DYNAMIC_GLOBAL_PROPS = "GlobalPropsHelper:getPageDynamicProps";
    public static final String GET_PAGE_GLOBAL_PROPS = "GlobalPropsHelper:getPageGlobalPropsByActivity";
    public static final String GET_URI_GLOBAL_PROPS = "GlobalPropsHelper:getUriGlobalProps";
    public static final String GET_WEB_COMMON_GLOBAL_PROPS = "GlobalPropsHelper:getWebCommonProps";
    public static final String GLOBAL_PROPS_CACHE_OPTIMIZE = "global_props_cache_optimize";
    public static final String INIT_ANNIEX_LYNXVIEW = "AnnieXLynxView:init";
    public static final String INIT_DEBUG_TAG = "AnnieXLynxView:init_debug_tag";
    public static final String INIT_LYNXENGINE_BUILDER = "LynxViewBuilderParams:toLynxEngineBuilder";
    public static final String INIT_LYNXENGINE_BUILDER_IN_LYNX = "LynxViewBuilder:<init>";
    public static final String INIT_LYNXVIEW_BUILDER = "LynxViewBuilderParams:toLynxViewBuilder";
    public static final String INIT_LYNXVIEW_BUILDER_IN_LYNX = "LynxViewBuilder:<init>";
    public static final String INIT_TIME_STAMP = "initTimestamp";
    public static final String INIT_TO_START_RENDER = "init_to_start_render";
    public static final MetricConstant INSTANCE = new MetricConstant();
    public static final String IS_DATA_INJECTED = "is_data_injected";
    public static final String IS_FROM_ENGINE = "is_from_engine";
    public static final String JSB_REGISTER = "jsb_register";
    public static final String JSB_REGISTER_END = "jsb_register_end";
    public static final String JSB_REGISTER_START = "jsb_register_start";
    public static final String KIT_LOAD_START = "kit_load_start";
    public static final String LOADER_TASK = "loader_task_duration";
    public static final String LOAD_TO_KIT_VIEW_CREATE = "load_to_kitcreate";
    public static final String LOAD_URL_TO_PAGE_START = "loadurl_to_pagestart";
    public static final String LYNXVIEW_BUILDER_ADD_BEHAVIORS = "LynxViewBuilder:addBehaviors";
    public static final String LYNXVIEW_BUILDER_REGISTER_MODULE = "LynxViewBuilder:registerModule";
    public static final String LYNX_ASYNC_LAYOUT_RESULT = "lynx_async_layout_result";
    public static final String LYNX_FIRST_SCREEN = "lynx_first_screen";
    public static final String LYNX_INSTALL_DYNAMIC_FEATURE = "lynx_install_dynamic_feature";
    public static final String LYNX_IS_ASYNC_LAYOUT = "lynx_is_async_layout";
    public static final String LYNX_LOAD_SUCCESS = "lynx_load_success";
    public static final String LYNX_MODEL_INIT = "lynx_model_init";
    public static final String LYNX_MODEL_INIT_END = "lynx_model_init_end";
    public static final String LYNX_MODEL_INIT_START = "lynx_model_init_start";
    public static final String LYNX_PAGE_START = "lynx_page_start";
    public static final String LYNX_READ_TEMPLATE_BEGIN = "read_template_start";
    public static final String LYNX_READ_TEMPLATE_END = "read_template_end";
    public static final String LYNX_RENDER = "lynx_render";
    public static final String LYNX_RENDER_BEGIN = "render_template_start";
    public static final String LYNX_RENDER_END = "render_template_end";
    public static final String MERGE_GLOBAL_PROPS = "AnnieXLynxModelBuilder:mergeGlobalProps";
    public static final String MONITOR_STAGE_DOWNLOAD_TEMPLATE = "download_template";
    public static final String MONITOR_STAGE_LOAD_TEMPLATE = "end";
    public static final String MONITOR_STAGE_UPDATE = "update";
    public static final String PAGE_COMMIT_DURATION = "page_commit_duration";
    public static final String PAGE_COMMIT_END = "page_commit_end";
    public static final String PAGE_COMMIT_START = "page_commit_start";
    public static final String PARSE_CARD_SCHEMA = "SchemaHelper:parseCardSchema";
    public static final String PERF_TRACE_GET_LYNX_BRIDGE = "XBridgeHelper:getLynxBridge";
    public static final String PREPARE_ENGINE_LOAD_END = "prepare_engine_load_end";
    public static final String PREPARE_ENGINE_LOAD_START = "prepare_engine_load_start";
    public static final String PUT_PREFETCH_GLOBAL_PROPS = "GlobalPropsHelper:putGlobalProps";
    public static final String PUT_QUERY_ITEMS = "GlobalPropsHelper:putQueryItems";
    public static final String PUT_SCHEME_ITEMS = "GlobalPropsHelper:putSchemeItems";
    public static final String PUT_STORAGE_GLOBAL_PROPS = "GlobalPropsHelper:putStorageGlobalProps";
    public static final String QUEUE_IDLE = "GlobalPropsIdleHandler:queueIdle";
    public static final String READ_TEMPLATE = "read_template";
    public static final String REGISTER_MODULE = "LynxViewBuilder:registerModule";
    public static final String RENDER_COST = "render_cost";
    public static final String RENDER_SSR = "AnnieXLynxView:renderSSR";
    public static final String RENDER_TEMPLATE = "LynxView:renderTemplateWithBaseUrl";
    public static final String RENDER_TEMPLATE_MAIN = "render_template_main";
    public static final String RESOURCE_LOAD = "resource_load";
    public static final String RL_TO_RENDER = "rl_to_render";
    public static final String ROUTER_OPEN = "open_time";
    public static final String ROUTER_PRE_OPEN = "router_pre_open";
    public static final String ROUTER_TO_CREATE = "router_to_create";
    public static final String SCHEMA_CONVERT = "schema_convert";
    public static final String SCHEMA_END = "prepare_init_data_end";
    public static final String SCHEMA_START = "prepare_init_data_start";
    public static final String SDK_TYPE = "sdk_type";
    public static final String SEC_ABOUT_TO_LOAD_URL_END = "about_load_url_end";
    public static final String SEC_ABOUT_TO_LOAD_URL_START = "about_load_url_start";
    public static final String SEC_CONTAINER_CREATED_END = "on_container_created_end";
    public static final String SEC_CONTAINER_CREATED_START = "on_container_created_start";
    public static final String SEC_CREATE_CONTAINER_END = "create_container_end";
    public static final String SEC_CREATE_CONTAINER_START = "create_container_start";
    public static final String SEC_INIT_TO_START_RENDER = "sec_dur_init_to_start_render";
    public static final String SEC_LOAD_URL_TO_PAGE_START = "sec_dur_loadurl_to_pagestart";
    public static final String SEC_TRULY_LOAD_URL_INTERVAL = "sec_dur_load_url_interval";
    public static final String SEC_WEB_LOAD_URL_END = "web_load_url_end";
    public static final String SEC_WEB_LOAD_URL_START = "web_load_url_start";
    public static final String SEC_WEB_REDIRECT_END = "web_redirect_end";
    public static final String SEC_WEB_REDIRECT_START = "web_redirect_start";
    public static final String STAY_DURATION = "stay_duration";
    public static final String TRACERT_ID = "tracert_id";
    public static final String TRACERT_INIT = "entry_start_timestamp";
    public static final String TRACE_BUILD_ANNIEX_LYNX_MODEL = "AnnieXLynxModelBuilder:buildInCompactMode";
    public static final String TRACE_CREATE_ANNIEX_LYNX_ENGINE = "AnnieXApi:createLynxEngine";
    public static final String TRACE_CREATE_ANNIEX_LYNX_VIEW = "AnnieXApi:createLynxView";
    public static final String TRACE_CREATE_ANNIEX_LYNX_VIEW_FROM_ENGINE = "AnnieXApi:createLynxViewFromEngine";
    public static final String TRACE_INIT_CANVAS_SETTINGS = "AnnieXApi:initCanvasSettings";
    public static final String TRACE_INIT_MONITOR = "AnnieXApi:initMonitorConfig";
    public static final String UPDATE_DRAW_END = "update_draw_end";
    public static final String UPDATE_GLOBAL_PROPS = "LynxView:updateGlobalProps";
    public static final String UPDATE_LYNXVIEW_BUILDER_PARAMS = "AnnieXLynxModelBuilder:updateLynxViewBuilderParams";
    public static final String VIEW_CREATE_END = "prepare_component_end";
    public static final String VIEW_CREATE_START = "prepare_component_start";
    public static final String VIEW_ENTER_BACKGROUND = "view_enter_background";
    public static final String VIEW_ENTER_FOREGROUND = "view_enter_foreground";
    public static final String WEB_LOAD_URL = "page_load";
    public static final String WEB_MODEL_INIT = "web_model_init";
    public static final String WEB_PAGE_FINISH = "page_finish";
    public static final String WEB_PAGE_START = "page_start";
    public static final String WEB_RENDER = "web_render";

    @Deprecated(message = "use ROUTER_OPEN instead")
    public static /* synthetic */ void getINIT_TIME_STAMP$annotations() {
    }

    private MetricConstant() {
    }

    /* compiled from: MetricConstant.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/MetricConstant$StdMetric;", "", "()V", "ENGINE_VIEW_RENDER_END", "", "ENGINE_VIEW_RENDER_START", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class StdMetric {
        public static final String ENGINE_VIEW_RENDER_END = "engineview_render_end";
        public static final String ENGINE_VIEW_RENDER_START = "engineview_render_start";
        public static final StdMetric INSTANCE = new StdMetric();

        private StdMetric() {
        }
    }
}
