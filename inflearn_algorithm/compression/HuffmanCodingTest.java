package compression;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Huffman Coding Test")
class HuffmanCodingTest {
	
	@BeforeEach
	void printLine() {
		System.out.println("===================================");
	}
	
	@AfterEach
	void println() {
		System.out.println();
	}

	@Test
	@Order(1)
	@DisplayName("collectRuns 메서드 테스트")
	void collectRunsTest() {
		HuffmanCoding app = new HuffmanCoding();
		RandomAccessFile fIn;
		String fileName = "sample.txt";
		ArrayList<Run> runs = app.getRuns();
		
		try {
			fIn = new RandomAccessFile(fileName, "r");
			app.collectRuns(fIn);
			fIn.close();
		} catch (FileNotFoundException e) {
			System.out.println("can not open " + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			fIn = new RandomAccessFile("sample.txt", "r");
			int ch;
			System.out.print("sample.txt : ");
			while((ch = fIn.read()) != -1)
			{	
				System.out.print((char) ch);
			}
			System.out.println();
			
			runs.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		
	@Test
	@Order(2)
	@DisplayName("createHuffmanTree 메서드 테스트")
	void createHuffmanTreeTest() {
		HuffmanCoding app = new HuffmanCoding();
		RandomAccessFile fIn;
		String fileName = "sample.txt";
		ArrayList<Run> runs = app.getRuns();
		
		// 1. Run 탐색
		try {
			fIn = new RandomAccessFile("sample.txt", "r");
			app.collectRuns(fIn);
			fIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 2. HuffmanTree 생성
		app.createHuffmanTree();
		
		// 3. HuffmanTree 출력
		app.printHuffmanTree();
	}
	
	@Test
	@Order(3)
	@DisplayName("assignCodeword 메서드 및 compressFile 메서드 테스트")
	void compressFileTest() {
		HuffmanCoding app = new HuffmanCoding();
		RandomAccessFile fIn;
		
		try {
			fIn = new RandomAccessFile("sample.txt", "r");
			app.compressFile("sample.txt", fIn);
			fIn.close();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open sample.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		app.getRuns().forEach((run)->System.out.println(run));
	}
	
	@Test
	@Order(4)
	@DisplayName("storeRunsIntoArray 메서드 테스트")
	void storeRunsIntoArrayTest() {
		HuffmanCoding app = new HuffmanCoding();
		RandomAccessFile fIn;
		
		try {
			fIn = new RandomAccessFile("sample.txt", "r");
			app.compressFile("sample.txt", fIn);
			fIn.close();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open sample.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<Run>[] chars = app.getChars();
		
		for(List<Run> run_list : chars)
		{
			if(run_list.isEmpty())
			{
				continue;
			}
			
			for(Run run : run_list)
			{
				System.out.print(run + " ");			
			}
			System.out.println();
		}
	}
	
	@Test
	@Order(5)
	@DisplayName("findRun 메서드 테스트")
	void findRunTest() {
		HuffmanCoding app = new HuffmanCoding();
		RandomAccessFile fIn;
		
		try {
			fIn = new RandomAccessFile("sample.txt", "r");
			app.compressFile("sample.txt", fIn);
			fIn.close();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open sample.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<Run>[] chars = app.getChars();
		
		byte symbol = 65;	// A
		int runLength = 3;
		
		Run run = app.findRun(symbol, runLength);
		
		System.out.println("탐색한 Run 정보");
		System.out.println(run);
		
	}
	
	@Test
	@Order(6)
	@DisplayName("outputFrequencies 메서드 테스트")
	void outputFrequenciesTest() {
		HuffmanCoding app = new HuffmanCoding();
		RandomAccessFile fIn;
		
		try {
			fIn = new RandomAccessFile("sample.txt", "r");
			app.compressFile("sample.txt", fIn);			
			fIn.close();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open sample.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	@Order(7)
	@DisplayName("encode 메서드 테스트")
	void encodeTest() {
		HuffmanCoding app = new HuffmanCoding();
		RandomAccessFile fIn;
		
		try {
			fIn = new RandomAccessFile("sample.txt", "r");
			app.compressFile("sample.txt", fIn);			
			fIn.close();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open sample.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	@Order(8)
	@DisplayName("encode/decode 메서드 테스트")
	void encodeTest2() throws IOException {
		HuffmanEncoder he = new HuffmanEncoder();
		HuffmanDecoder hd = new HuffmanDecoder();
		
		he.encoder("sample.txt");
		
		hd.decoder("sample.txt.z");
	}
}