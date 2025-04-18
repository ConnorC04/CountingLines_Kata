public class CountingLines {


    public CountingLines(){}

    public Integer parseJavaCode(String javaCode){
        int count = 0;
        boolean inBlockComment = false;
        String[] lines = javaCode.split("\n");

        for (String line : lines) {
            String trimmed = line.trim();

            if (trimmed.isEmpty()) continue; // Skip lines with only whitespace

            if (inBlockComment) {
                int endIndex = trimmed.indexOf("*/");
                if (endIndex != -1) {
                    inBlockComment = false;
                    // Check if there's actual code after the block comment ends
                    String after = trimmed.substring(endIndex + 2).trim();
                    if (!after.isEmpty() && !after.startsWith("//") && !after.startsWith("/*")) {
                        count++;
                    }
                }
                continue; // Still inside a block comment
            }

            if (trimmed.startsWith("//")) continue; // Skip single-line comment

            if (trimmed.startsWith("/*")) {
                int endIndex = trimmed.indexOf("*/");
                if (endIndex != -1) {
                    String after = trimmed.substring(endIndex + 2).trim();
                    if (!after.isEmpty() && !after.startsWith("//") && !after.startsWith("/*")) {
                        count++;
                    }
                } else {
                    inBlockComment = true; // Entering block comment
                }
                continue;
            }

            // Count everything else, including lines with just "}"
            count++;
        }

        return count;
    }
}
