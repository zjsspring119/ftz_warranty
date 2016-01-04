package com.ouyeelf.ftz.rsdb.imp.buffer.impl;

import java.nio.ByteBuffer;

import sun.nio.ch.DirectBuffer;

import com.ouyeelf.ftz.rsdb.imp.buffer.IByteBuffer;
import com.ouyeelf.ftz.rsdb.imp.utils.SerializableUtils;

@SuppressWarnings("restriction")
public class ResourceByteBuffer<T> implements IByteBuffer<T>{
	private ByteBuffer buffer; 
	
	public ResourceByteBuffer(int size){
		this.buffer =  ByteBuffer.allocateDirect(size);
	}
	
	public ByteBuffer getBuffer() {
		return buffer;
	}

	public ResourceByteBuffer<T> put(T t) throws Exception{
		byte[] resByte = SerializableUtils.objectToBytes(t);
		byte[] lengthByte = intToBytes(resByte.length);
		buffer.put(lengthByte);
		buffer.put(resByte);
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public T get() throws Exception {
		byte[] lengthByte = new byte[4];
		buffer.get(lengthByte);
		int length = bytesToInt(lengthByte);
		byte[] resultByte =new byte[length];
		buffer.get(resultByte);
		T t = (T) SerializableUtils.bytesToObject(resultByte);
		return t;
	}
	
	
	public boolean hasRemaining(){
		return buffer.hasRemaining();
	}
	
	
	public ResourceByteBuffer<T> flip(){
		buffer.flip();
		return this;
	}
	
	
	public ResourceByteBuffer<T> clear() {
		if (buffer.isDirect()){
			((DirectBuffer)buffer).cleaner().clean();
		}else{
			buffer.clear();
		}
		return this;
	}
	
	private static byte[] intToBytes(int value){
		 byte[] b = new byte[4];
	     for (int i = 0; i < 4; i++) {
	            int offset = (b.length - 1 - i) * 8;
	             b[i] = (byte) ((value >>> offset) & 0xFF);
	      }
	      return b;
	}
	
	private static int bytesToInt(byte[] b) {
		return (b[0] << 24)
                + ((b[1] & 0xFF) << 16)
                + ((b[2] & 0xFF) << 8)
                + (b[3] & 0xFF);
	}
	
}
