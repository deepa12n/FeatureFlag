package com.md.demo.service.Impl;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Logger;

import org.apache.commons.lang3.SerializationUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.md.demo.service.MessageDigestService;
import com.md.demo.vo.FlagData;
import com.md.demo.vo.Flags;
import com.md.demo.vo.GeneratedMD;

@Service
public class MessageDigestServiceImpl implements MessageDigestService {

	private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	@Value("${salt}")
	private byte[] salt ;

	private byte[] generateSalt() {
		
		byte[] salt = new byte[16];
		 SecureRandom random = new SecureRandom();
		 random.nextBytes(salt);
	    return salt;
	}
	
	
	public GeneratedMD getMessageDigest(FlagData fd) {
		GeneratedMD gmd = new GeneratedMD();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
            //byte[] salt = generateSalt();
			
			byte[] data = SerializationUtils.serialize(fd);
			md.update(salt);
			byte[] digest = md.digest(data);
			System.out.println("Message Digest Byte Array : " + digest.toString());
			System.out.print("MD: ");
			for ( int i=0;i<digest.length; i++)
			{
				System.out.print(" " + digest[i]);
			}

			StringBuffer hexData = new StringBuffer();
			for (int i = 0; i < digest.length; i++) {
				hexData.append(Integer.toHexString(0xFF & digest[i]));
			}
			System.out.println("\n"+"Hex format : " + hexData.toString());

			gmd.setShaValue(digest);
			gmd.setHexValue(hexData.toString());
			return gmd;
			
		} catch (Exception e) {
			logger.info("Exception occured");
		}
		return gmd;
	}

	public Boolean comapreMessageDigest(Flags flags) {
		FlagData fSrc = flags.getFlagDataSource();
		FlagData fDest = flags.getFlagDataDestination();
		GeneratedMD mdSrc = getMessageDigest(fSrc);
		System.out.println("MDSourcs" + mdSrc.getShaValue());
		GeneratedMD mdDest = getMessageDigest(fDest);
		System.out.println("MDDest" + mdDest.getShaValue());
		return Arrays.equals(mdSrc.getShaValue(), mdDest.getShaValue());
	}
}
