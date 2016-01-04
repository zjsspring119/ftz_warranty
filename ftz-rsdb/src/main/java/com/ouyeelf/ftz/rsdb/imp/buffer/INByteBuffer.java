package com.ouyeelf.ftz.rsdb.imp.buffer;


public interface INByteBuffer<T> {
	
	public INByteBuffer<T> put(T t) throws Exception;
	
	public IByteBuffer<T>[] getUsedBuffer();
}
