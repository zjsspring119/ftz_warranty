package com.ouyeelf.ftz.rsdb.imp.buffer;

import java.nio.ByteBuffer;


public interface IByteBuffer<T> {
	
	public IByteBuffer<T> put(T t) throws Exception;
	
	public T get() throws Exception;
	
	public IByteBuffer<T> flip();
	
	public boolean hasRemaining();
	
	public ByteBuffer getBuffer();

	public IByteBuffer<T> clear();
}
