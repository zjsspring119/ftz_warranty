package com.ouyeelf.ftz.rsdb.imp.buffer;

import com.ouyeelf.ftz.rsdb.imp.buffer.impl.NResourceByteBuffer;
import com.ouyeelf.ftz.rsdb.imp.buffer.impl.ResourceByteBuffer;

public class IByteBufferFactory {
	
	public static <T> IByteBuffer<T> createResourceByteBuffer(int size){
		return new ResourceByteBuffer<T>(size);
	}
	
	public static <T> INByteBuffer<T> createNResourceByteBuffer(int size){
		return new NResourceByteBuffer<T>(size);
	}
	
	
	
}
