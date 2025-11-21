package homework7;

public class FileAnalyzerMain {

        public static void main(String[] args) {

            fileAnalyzer analyzer = new fileAnalyzer();


            String path = "input.txt";

            path = "C:/Users/ADMIN/IdeaProjects/JavaCore/src/homework7/input.txt";

            try {
                System.out.println("Word map: " + analyzer.wordMap(path));
                System.out.println("Total word count: " + analyzer.totalWordCount(path));
                System.out.println("Unique word count: " + analyzer.uniqueWordCount(path));
                System.out.println("Top 5 frequent words: " + analyzer.topFrequentWords(path, 5));
                System.out.println("Occurrences of 'java': " + analyzer.countWordOccurrences(path, "java"));

            } catch (Exception e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
    }
