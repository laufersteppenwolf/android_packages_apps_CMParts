package com.cyanogenmod.cmparts.preferences;

import android.content.Context;
import android.util.AttributeSet;

public final class GingerDXStatusBarTransparencyPicker extends GingerDXTransparencyPickerBase {
	
	private static final String KEY = Settings.System.ACHEP_STATUS_BAR_BACKGROUND_TRANSPARENCY;

	public GingerDXStatusBarTransparencyPicker(Context context, AttributeSet attrs) {
		super(context, attrs, KEY);
	}
	
}