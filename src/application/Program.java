package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import entities.Products;
import services.ProductService;

public class Program {

	public static void main(String[] args) throws ParseException {

		
		
		Scanner sc = new Scanner(System.in);
		// instantiate a new List with String key and an integer value
		List<Products> list = new ArrayList<>();
		// String path receiving a string
		String path = "/users/lucasmancini/in.txt";
		System.out.println("Enter the price: ");
		double price = sc.nextDouble();

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
				line = br.readLine();

			}
			
			System.out.println("Consoles whose the price is more than: " + price);
			List<String> names = list.stream()
					.filter(p -> p.getValue() > price)
					.map(p -> p.getName())
			        .collect(Collectors.toList());
			     
			      names.forEach(System.out::println);
			
			         Double sum = list.stream()
					.filter(p -> p.getName().charAt(0) == 'P')
					.map(p -> p.getValue())
					.reduce(0.0, (x, y) -> x + y);
					System.out.println("The sum of consoles whose starts with 'P': " + sum);
			
			

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());

			}
		
		sc.close();

		}

	}

