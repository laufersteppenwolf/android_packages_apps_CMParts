package com.cyanogenmod.cmparts.preferences;

import android.content.Context;
import android.util.AttributeSet;

public final class GingerDXJBStatusBarPanelTransparencyPicker extends GingerDXTransparencyPickerBase {
	
	private static final String KEY = Settings.System.ACHEP_JB_STATUS_BAR_PANEL_BACKGROUND_TRANSPARENCY;

	public GingerDXJBStatusBarPanelTransparencyPicker(Context context, AttributeSet attrs) {
		super(context, attrs, KEY);
	}
	
}