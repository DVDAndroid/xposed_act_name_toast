package com.dvd.android.xposed.showactivitynametoast;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

import android.app.Activity;
import android.widget.Toast;

public class XposedMod implements IXposedHookZygoteInit {

	@Override
	public void initZygote(StartupParam startupParam) throws Throwable {

		final Class<?> ActivityClass = XposedHelpers.findClass(
				"android.app.Activity", null);

		findAndHookMethod(ActivityClass, "performResume", new XC_MethodHook() {
			@Override
			protected void afterHookedMethod(MethodHookParam param)
					throws Throwable {
				Object currentObj = param.thisObject;
				Activity currentActivity;
				if (currentObj instanceof Activity) {
					currentActivity = (Activity) currentObj;
				} else {
					return;
				}

				Toast toast = Toast.makeText(
						currentActivity.getApplicationContext(),
						"Current Activity:\n"
								+ currentActivity.getPackageName() + "."
								+ currentActivity.getLocalClassName(),
						Toast.LENGTH_SHORT);
				toast.show();

			}
		});

	}

}