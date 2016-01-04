package com.ouyeelf.ftz.rsdb.imp.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableUtils implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6589014478014565073L;

	public static byte[] objectToBytes(Object obj) throws Exception {
		if (null == obj){
			return null;
		}
		ByteArrayOutputStream bo = null;
		ObjectOutputStream oo = null;
		try {
			bo = new ByteArrayOutputStream();
			oo = new ObjectOutputStream(bo);
			oo.writeObject(obj);
			return bo.toByteArray();
		} finally{
			if (null != bo)
				bo.close();
			if (null != oo)
				oo.close();
		}
	}

	public static Object bytesToObject(byte[] bytes) throws Exception {
		if (null == bytes){
			return null;
		}
		java.lang.Object obj = new java.lang.Object();
		ByteArrayInputStream bi = null;
		ObjectInputStream oi = null;
		try {
			bi = new ByteArrayInputStream(bytes);
			oi = new ObjectInputStream(bi);
			obj = oi.readObject();
			return obj;
		} finally{
			if (null != bi)
				bi.close();
			if (null != oi)
				oi.close();
		}
	}
}
