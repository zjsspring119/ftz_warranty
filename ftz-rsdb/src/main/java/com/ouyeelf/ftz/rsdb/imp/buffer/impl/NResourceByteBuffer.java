package com.ouyeelf.ftz.rsdb.imp.buffer.impl;


import com.ouyeelf.ftz.rsdb.imp.buffer.IByteBuffer;
import com.ouyeelf.ftz.rsdb.imp.buffer.IByteBufferFactory;
import com.ouyeelf.ftz.rsdb.imp.buffer.INByteBuffer;

public class NResourceByteBuffer<T> implements INByteBuffer<T>{
	
	private final static int csize = 8;//桶数
	
	private final static int rsize = 2048;//每条资源大小
	
	private IByteBuffer<T>[] buffer = new ResourceByteBuffer[csize];//构建桶
	

	private int usedChunk;//已使用的桶数
	
	private int cursor = 0;//游标
	
	public NResourceByteBuffer(int size){
		signChuck(size);
	}
	
	private void signChuck(int size) {
		
		if (size < csize*rsize){//桶不足分配
			buffer[0] = IByteBufferFactory.createResourceByteBuffer(size);
			usedChunk = 1;
			return;
		}
		
		int nsize = size / csize;//每个桶大小
		int msize = size % csize;//余桶大小
		usedChunk = csize;//可用桶
		for(int i=0; i<usedChunk-1; i++){
			buffer[i] = IByteBufferFactory.createResourceByteBuffer(nsize);
		}
		buffer[usedChunk-1] = IByteBufferFactory.createResourceByteBuffer(nsize+msize);
	}


	public INByteBuffer<T> put(T t) throws Exception {
		buffer[cursor].put(t);
		cursor++;
		if (cursor >= usedChunk){//游标到达末尾
			cursor = 0;
		}
		return this;
	}
	
	public IByteBuffer<T>[] getUsedBuffer() {
		IByteBuffer<T>[] usedBuffer = new ResourceByteBuffer[usedChunk];
		for (int i = 0; i < usedChunk; i++) {
			usedBuffer[i] = buffer[i];
		}
		return usedBuffer;
	}
	
	
}
