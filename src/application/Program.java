package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import entities.Products;
import services.ProductService;

public class Program {

	public static void main(String[] args) throws ParseException {

		// instantiate a new List with String key and an integer value
		List<Products> list = new ArrayList<>();
		// String path receiving a string
		String path = "/users/lucasmancini/in.txt";

		// try bloc with istantiate a buffered reader and a file reader
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			// String named "line" that read a line of the archive.
			String line = br.readLine();

			// while line is not null then read the line of the archive and continue to be
			// null
			while (line != null) {
				String[] fields = line.split(", ");
				String name = fields[0];
				double value = Double.parseDouble(fields[1]);



				list.add(new Products(name, value));
				list.sort((p1, p2) -> p1.getValue().compareTo(p2.getValue()));
				line = br.readLine();

			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());

			}

		}

	}

