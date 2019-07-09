package ca.jrvs.apps.grep;



import java.io.File;
import java.io.IOException;
import java.util.List;

public interface JavaGrep {
    /**
     * Main Method
     * @throws IOException
     */
    void process() throws IOException;

    /**
     *
     * @param rootDir - To get the root directory and traverse the directory to get all the files inside it.
     * @return
     */
    List<File> listFiles(String rootDir) throws IOException;

    /**
     *
     * @param inputFile - Read the file and return all the lines in it. This is implemented through FileReader, bufferReader
     * @return
     */
    List<String> readLines(File inputFile) throws IOException;

    /**
     *
     * @param line- check if the line contains the regex pattern passed by user
     * @return
     */
    boolean containsPattern(String line);

    /**
     * write lines to a file by using FileOutputStream, OutputStreamWriter and BufferedWriter
     * @param lines
     * @throws IOException
     */

    /**
     * Throws IOException if write fails
     * @return
     */
    void writeToFile(List<String> lines) throws IOException;

    String getRootPath();
    void setRootPath(String rootPath);
    String getRegex();
    void setRegex(String regex);
    String getOutFile();
    void setOutFile(String outFile);
}
