package security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class SHA256Generator {

	public static String generateValue() {
		return generateValue(UUID.randomUUID().toString());
	}

	private static final char[] hexCode = "0123456789abcdef".toCharArray();

	public static String toHexString(byte[] data) {

		if (data == null) {
			return null;
		}

		StringBuilder r = new StringBuilder(data.length * 2);

		for (byte b : data) {
			r.append(hexCode[(b >> 4) & 0xF]);
			r.append(hexCode[(b & 0xF)]);
		}

		return r.toString();
	}

	public static String generateValue(String param) {

		try {

			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			algorithm.reset();
			algorithm.update(param.getBytes());

			byte[] messageDigest = algorithm.digest();

			return toHexString(messageDigest);

		} catch (NoSuchAlgorithmException e) {

			throw new RuntimeException("Algoritmo de hash 'SHA-256' não encontrado.", e);

		}
	}
}
