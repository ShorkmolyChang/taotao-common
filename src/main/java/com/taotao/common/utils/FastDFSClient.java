package com.taotao.common.utils;

import java.io.IOException;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FastDFSClient {

	private TrackerServer trackerServer = null;
	private TrackerClient trackerClient = null;
	private StorageServer storageServer = null;
	private StorageClient storageClient = null;

	public FastDFSClient(String conf) throws IOException, MyException {
		if (conf.contains("classpath:")) {
			conf = conf.replace("classpath:", this.getClass().getResource("/").getPath());
		}
		System.out.println(conf);
		ClientGlobal.init(conf);
		trackerClient = new TrackerClient();
		trackerServer = trackerClient.getConnection();
		storageServer = null;
		storageClient = new StorageClient(trackerServer, storageServer);
	}

	public String[] uploadFile(String filePath, String extName, NameValuePair[] metas) throws IOException, MyException {
		String[] result = storageClient.upload_file(filePath, extName, metas);
		return result;
	}

	public String[] uploadFile(String filePath) throws IOException, MyException {
		return uploadFile(filePath, null, null);
	}

	public String[] uploadFile(String filePath, String extName) throws IOException, MyException {
		return uploadFile(filePath, extName, null);
	}

	public String[] uploadFile(byte[] fileContent, String extName, NameValuePair[] metas)
			throws IOException, MyException {
		String[] result = storageClient.upload_file(fileContent, extName, metas);
		return result;
	}

	public String[] uploadFile(byte[] fileContent) throws IOException, MyException {
		return uploadFile(fileContent, null, null);
	}

	public String[] uploadFile(byte[] fileContent, String extName) throws IOException, MyException {
		return uploadFile(fileContent, extName, null);
	}

}
