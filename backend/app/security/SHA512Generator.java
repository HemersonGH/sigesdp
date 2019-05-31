package security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.commons.codec.binary.Hex;

import play.Logger;

public class SHA512Generator {

	public static String generateValue() {
		return generateValue(UUID.randomUUID().toString());
	}

	public static String generateValue(String param) {
		byte[] hash = null;

		try {
			hash = MessageDigest.getInstance("SHA-512").digest(param.getBytes());
		} catch (NoSuchAlgorithmException nsae) {
			Logger.error(nsae, nsae.getMessage());
		}

		return Hex.encodeHexString(hash);
	}
}
