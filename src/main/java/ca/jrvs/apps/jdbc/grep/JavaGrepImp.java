package ca.jrvs.apps.jdbc.grep;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Implementation of interface
class JavaGrepImp implements JavaGrep {
    private String rootPath;
    private String regex;
    private String outFile;

    @Override
    public String getRootPath() {
        return rootPath;
    }

    @Override
    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    @Override
    public String getRegex() {
        return regex;
    }

    @Override
    public void setRegex(String regex) {
        this.regex = regex;
    }

    @Override
    public String getOutFile() {
        return outFile;
    }

    @Override
    public void setOutFile(String outFile) {
        this.outFile = outFile;
    }

    @Override
    public void process() throws IOException {
        List<String> matchedLines = new ArrayList<String>();
        for (File file : listFiles(getRootPath())) {
            for (String line : readLines(file)) {
                if (containsPattern(line)) {
                    matchedLines.add(line);
                }
            }
        }
        writeToFile(matchedLines);
    }


    @Override
    public List<File> listFiles(String rootDir) throws IOException {
        List<File> files = new ArrayList<>();
        File dir = new File(rootDir);
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                files.addAll(listFiles(file.getPath()));
            } else {
                files.add(file);
            }
        }
        return files;
    }

    @Override
    public List<String> readLines(File inputFile) throws IOException {
        String line = null;
        List<String> files = new ArrayList<String>();
        FileReader fr = new FileReader(inputFile);
        BufferedReader br = new BufferedReader(fr);
        while ((line = br.readLine()) != null) {
            files.add(line);
        }
        br.close();
        fr.close();
        return files;
    }

    @Override
    public boolean containsPattern(String line) {
        if (line.matches(regex)) {
            return true;
        }
        return false;
    }


    @Override
    public void writeToFile(List<String> lines) throws IOException {
        File file = new File(getOutFile());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        for (String line : lines) {
            bufferedWriter.write(line);
            bufferedWriter.write("\n");
        }
        bufferedWriter.flush();
        fileOutputStream.close();

    }

    public static void main(String[] args) throws IOException {
        System.out.println("Display");
        JavaGrepImp javaGrepImp = new JavaGrepImp();
        javaGrepImp.setRegex(args[0]);
        javaGrepImp.setRootPath(args[1]);
        javaGrepImp.setOutFile(args[2]);
        javaGrepImp.process();

        try {
            javaGrepImp.process();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}






