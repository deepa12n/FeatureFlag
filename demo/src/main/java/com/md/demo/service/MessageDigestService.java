package com.md.demo.service;

import com.md.demo.vo.FlagData;
import com.md.demo.vo.Flags;
import com.md.demo.vo.GeneratedMD;

public interface MessageDigestService {
	public GeneratedMD getMessageDigest(FlagData fd);
	public Boolean comapreMessageDigest(Flags flags);
}
