/*
 * Copyright (C) 2011 The CyanogenMod Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cyanogenmod.cmparts.intents;

import java.io.FileWriter;
import java.io.IOException;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemProperties;
import android.util.Log;

public class LCDReceiver extends BroadcastReceiver {
    private static final String TAG = "LCDSettings";

    private static final String ULTRA_BRIGHTNESS_PERSIST_PROP = "persist.sys.ultrabrightness";

    @Override
    public void onReceive(Context ctx, Intent intent) {
   		if (SystemProperties.getBoolean(ULTRA_BRIGHTNESS_PERSIST_PROP, false)) {
		    writeOneLine("/sys/devices/platform/i2c-adapter/i2c-0/0-0036/mode", "i2c_pwm");
   			Log.d(TAG, "Brightness: Raised");
   		} else {
   			writeOneLine("/sys/devices/platform/i2c-adapter/i2c-0/0-0036/mode", "i2c_pwm_als");
   			Log.d(TAG, "Brightness: Normal");
   		}
    }

	private boolean writeOneLine(String fname, String value) {
		try {
			FileWriter fw = new FileWriter(fname);
			try {
				fw.write(value);
			} finally {
				fw.close();
			}
		} catch (IOException e) {
			String Error = "Error writing to " + fname + ". Exception: ";
			Log.e(TAG, Error, e);
			return false;
		}
		return true;
	}

}
