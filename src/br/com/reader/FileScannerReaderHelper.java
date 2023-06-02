package br.com.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FileScannerReaderHelper extends FileReaderHelper {

	public FileScannerReaderHelper(String fileName) {
		super(fileName);
	}

	@Override
	public List<Long> readNumbersFromFileReturningList() throws Exception {
		List<Long> numbers = new ArrayList<>();

		String fileName = getFileName();
		File file = new File(fileName);

		if (!file.exists()) {
			throw new FileNotFoundException("Arquivo não encontrado: " + fileName);
		}

		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNext()) {
				try {
					long number = scanner.nextLong();
					numbers.add(number);
				} catch (InputMismatchException e) {
					throw new InputMismatchException("Erro ao converter um número válido: " + e.getMessage());
				}
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Arquivo não pode ser lido: " + e.getMessage());
		}

		return numbers;
	}

	@Override
	public long[] readNumbersFromFileReturningArray() throws Exception {
		long[] numbers = null;

		String fileName = getFileName();
		File file = new File(fileName);

		if (!file.exists()) {
			throw new FileNotFoundException("Arquivo não encontrado: " + fileName);
		}

		int count = 0;
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLong()) {
				scanner.nextLong();
				count++;
			}
		} catch (FileNotFoundException e) {
			throw new InputMismatchException("Erro ao converter um número válido: " + e.getMessage());
		}

		numbers = new long[count];

		try (Scanner scanner = new Scanner(file)) {
			for (int i = 0; i < count; i++) {
				numbers[i] = scanner.nextLong();
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Arquivo não pode ser lido: " + e.getMessage());
		}

		return numbers;
	}
}
