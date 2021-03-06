package com.syouth.ngpong.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.syouth.ngpong.NgPongMain;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1024;
		config.height = 768;
		config.vSyncEnabled = true;
		new LwjglApplication(new NgPongMain(new CommandsProcessorDesktop()), config);
	}
}
