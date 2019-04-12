package chapter4;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTester extends TestCase {
    private FileReader _input;
    public FileReaderTester(String name) {
        super(name);
    }

    public static void main(String[] args) {
        // suite()に追加されたテストのみ実行される
//        junit.textui.TestRunner.run(suite());
        // testで始まるすべてのメソッドをテストケースとして含めるテストスイートを作る
        junit.textui.TestRunner.run(new TestSuite(FileReaderTester.class));
    }

    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new FileReaderTester("testRead"));
        suite.addTest(new FileReaderTester("testReadAtEnd"));
        suite.addTest(new FileReaderTester("testReadBoundaries"));
        return suite;
    }

    /**
     * テスト実行前に呼び出しされる
     */
    protected void setUp() {
        try {
            _input = new FileReader("src/main/resources/chapter4/data.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("テキストファイルがopenできない");
        }
    }

    /**
     * テスト実行後に呼び出しされる
     */
    protected void tearDown() {
        try {
            _input.close();
        } catch (IOException e) {
            throw new RuntimeException("テキストファイルをcloseするときにエラー発生");
        }
    }

    public void testRead() throws IOException {
        char ch = '&';
//        _input.close();// テストが通らないことの確認
        for (int i = 0; i < 4; i++) {
            ch = (char) _input.read();
        }
        assertEquals('d', ch);
    }

    public void testReadAtEnd() throws IOException {
        int ch = -1234;
        for (int i = 0; i < 141; i++) {
            ch = _input.read();
        }
        assertEquals("read at end", -1, _input.read());
    }

    public void testReadBoundaries() throws IOException {
        assertEquals("read first char", 'B', _input.read());
        int ch;
        for (int i = 1; i < 140; i++) {
            ch = _input.read();
        }
        assertEquals("read last char", '6', _input.read());
        assertEquals("read at end", -1, _input.read());
        assertEquals("read past end", -1, _input.read());
    }

    public void testReadAfterClose() throws IOException {
        _input.close();
        try {
            _input.read();
            fail ("no exception for read past end");
        } catch (IOException io) {

        }
    }
}
