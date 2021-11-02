package ru.darkcat09.blockapp;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toast;

public class BlockAppAccessibilityService extends AccessibilityService {

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
        info.flags = AccessibilityServiceInfo.DEFAULT;
        info.eventTypes = AccessibilityEvent.TYPES_ALL_MASK;
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;
        info.packageNames = new String[] {
                "com.zhiliaoapp.musically",
                "com.zhiliaoapp.musically.go",
                "com.ss.android.ugc.trill"
        };
        setServiceInfo(info);
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        String msg = getString(R.string.message);
        performGlobalAction(GLOBAL_ACTION_HOME);
        if (!msg.equals(""))
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInterrupt() {
        //
    }
}