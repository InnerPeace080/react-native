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
public class OnKeyEvent extends Event<OnKeyEvent> {

    public static final String EVENT_NAME = "topKeyPress";

    private final int mKeyCode;
    private final int mKeyEvent;

    public OnKeyEvent(int viewTag, int keyCode,int keyEvent) {
        super(viewTag);
        mKeyCode = keyCode;
        mKeyEvent = keyEvent;
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        WritableMap data = Arguments.createMap();
        data.putInt("keyCode", mKeyCode);
        data.putInt("keyEvent", mKeyEvent);
        rctEventEmitter.receiveEvent(getViewTag(), EVENT_NAME, data);
    }
}
