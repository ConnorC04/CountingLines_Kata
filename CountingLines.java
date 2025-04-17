public class CountingLines {


    public CountingLines(){}

    public Integer parseJavaCode(String javaCode){
        int lineCount = 0;

        String[] separateLines = javaCode.split("\n");
        for (String line : separateLines){
            String[] commentBlockStart = line.split("/*");
            if (commentBlockStart.length == 2){
                String[] commentBlockEnd = line.split("/*/");
            }
        }
        return lineCount;
    }
}
