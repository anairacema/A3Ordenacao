package br.com.reader;

import java.util.List;

public abstract class FileReaderHelper {

	private String fileName;

	public FileReaderHelper(String fileName) {
		this.fileName = fileName;
	}

	public abstract List<Long> readNumbersFromFileReturningList() throws Exception;

	public abstract long[] readNumbersFromFileReturningArray() throws Exception;

	protected String getFileName() {
		return fileName;
	}

}
