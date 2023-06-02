package br.com.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileBufferedReaderHelper extends FileReaderHelper {

	public FileBufferedReaderHelper(String fileName) {
		super(fileName);
	}

	@Override
	public List<Long> readNumbersFromFileReturningList() throws Exception {
		List<Long> numbers = new ArrayList<>();

		String fileName = getFileName();

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				try {
					long number = Long.parseLong(line);
					numbers.add(number);
				} catch (NumberFormatException e) {
					throw new NumberFormatException("Erro ao converter um número válido: " + e.getMessage());
				}
			}
		} catch (IOException e) {
			throw new IOException("Erro ao ler o arquivo: " + e.getMessage());
		}

		return numbers;
	}

	@Override
	public long[] readNumbersFromFileReturningArray() throws Exception {
		long[] numbers = null;
		BufferedReader reader = new BufferedReader(new FileReader(getFileName()));
		int count = 0;

		while ((reader.readLine()) != null) {
			count++;
		}

		numbers = new long[count];

		reader.close();

		String line;
		int index = 0;

		// Por algum motivo desconhecido, para pesquisa binária com array
		// preciso desse segundo buffered reader
		reader = new BufferedReader(new FileReader(getFileName()));

		while ((line = reader.readLine()) != null) {
			numbers[index] = Long.parseLong(line);
			index++;
		}

		reader.close();

		return numbers;
	}

}
