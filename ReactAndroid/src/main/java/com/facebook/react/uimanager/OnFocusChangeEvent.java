// Copyright 2004-present Facebook. All Rights Reserved.

package com.facebook.react.uimanager;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/**
 * Event dispatched when total width or height of a view's children changes
 */
public class OnFocusChangeEvent extends Event<OnFocusChangeEvent> {

    public static final String EVENT_NAME = "topFocusChange";

    private final boolean mFocus;

    public OnFocusChangeEvent(int viewTag, boolean focus) {
        super(viewTag);
        mFocus = focus;
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        WritableMap data = Arguments.createMap();
        data.putBoolean("focus", mFocus);
        rctEventEmitter.receiveEvent(getViewTag(), EVENT_NAME, data);
    }
}
