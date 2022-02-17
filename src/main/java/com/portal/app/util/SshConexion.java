package com.portal.app.util;

import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SshConexion {
	
	private static final Logger log = LoggerFactory.getLogger(SshConexion.class);

	public static void listFolderStructure(String username, String password, String host, int port, String command)
			throws Exception {

		Session session = null;
		ChannelExec channel = null;

		try {
			session = new JSch().getSession(username, host, port);
			session.setPassword(password);
			session.setConfig("StrictHostKeyChecking", "no");
			session.connect();

			channel = (ChannelExec) session.openChannel("exec");
			channel.setCommand(command);
			ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
			channel.setOutputStream(responseStream);
			channel.connect();

			while (channel.isConnected()) {
				Thread.sleep(100);
			}

			String responseString = new String(responseStream.toByteArray());
			log.info(responseString);
		} finally {
			if (session != null) {
				session.disconnect();
			}
			if (channel != null) {
				channel.disconnect();
			}
		}
	}

}
