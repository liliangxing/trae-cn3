package com.bytedance.push.settings.assosiation.start;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class AssociationStartSettingsModel {
    public boolean enableAssociationHook = false;
    public boolean enableAssociationStartMonitor = false;
    public boolean enableAssociationStartIntercept = false;
    public List<String> monitorComponentBlackList = new ArrayList();
    public List<String> interceptComponentBlackList = new ArrayList();
    public List<String> interceptComponentWhiteList = new ArrayList();
    public List<String> isolationInterceptComponentBlackList = new ArrayList();
    public Map<String, String> isolationRedirectMap = new HashMap();
}
